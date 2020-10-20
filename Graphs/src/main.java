import java.util.*;
import graphsDSESIUCLM.*;
/***********************************************************************************************************************
 * Class Name: main
 *
 * Author/s name: Josue Carlos Zenteno Yave
 *		          Marina Prieto Pech
 *		          Ismael Camacho Talavera
 *
 * Release/Creation date: 10/12/2019
 *
 * Class version: 1.0
 *
 * Class description: Main class where we implemented all the methods related with the resolution of the tasks
 **********************************************************************************************************************/
public class main {
    public static Scanner sc = new Scanner(System.in);
    /*******************************************************************************************************************
     * Method name: main
     *
     * Authors: Josue Carlos Zenteno Yave
     *          Marina Prieto Pech
     *          Ismael Camacho Talavera
     *
     * Description of the Method: main class that uses the method generateGraph() and prints the menu.
     ******************************************************************************************************************/
    public static void main(String[] args) {

        Graph<DecoratedElement<String>, DecoratedElement<Integer>> graph = FileReader.generateGraph();
        printMenu(graph);

    }
    /*******************************************************************************************************************
     * Method name: printMenu
     *
     * Authors:     Josue Carlos Zenteno Yave
     *              Marina Prieto Pech
     *              Ismael Camacho Talavera
     *
     * Description of the Method: method that prints the menu and show the options for the User
     *
     * Calling arguments:   Graph<DecoratedElement<String>, DecoratedElement<Integer>> graph
     ******************************************************************************************************************/
    private static void printMenu(Graph<DecoratedElement<String>, DecoratedElement<Integer>> graph) {
        int option;
        do {
            System.out.println("Choose an option:\n"+
                    "    0) Exit\n"+
                    "    1) Get statistics of the graph\n"+
                    "    2) Most famous hero team\n"+
                    "    3) Less sociable team of heroes\n");

            switch(option = sc.nextInt()) {
                case 0:
                    break;
                case 1:
                    getStatistics(graph);
                    break;
                case 2:
                    mostFamousTeam(graph);
                    break;
                case 3:
                    lessSociableTeam(graph);
                    break;
                default:
                    System.out.println("Error. Non valid option");
                    break;
            }
            System.out.println();
        }while(option != 0);
    }
    /*******************************************************************************************************************
     * Method name: getStatistics
     *
     * Authors: Josue Carlos Zenteno Yave
     *          Marina Prieto Pech
     *          Ismael Camacho Talavera
     *
     * Description of the Method:   Method that shows the next information:
     *                                -number of characters.
     *                                -total number of relationships between the characters.
     *                                -friendliest character.
     *                                -the most autistic character.
     *
     * Calling arguments: Graph<DecoratedElement<String>, DecoratedElement<Integer>> graph
     ******************************************************************************************************************/
    private static void getStatistics(Graph<DecoratedElement<String>, DecoratedElement<Integer>> graph) {

        System.out.println("The total number of characters is:    " + graph.getN());
        System.out.println("The total number of relationships between characters is:    " + graph.getM());
        System.out.println("The friendliest character is/are:    " + friendliestCharacter(graph));

        Stack <String> AuxStackWorksLess =worksLess(graph);
        System.out.print("The character/s that works less as a team counting edges is/are: ");
        while(!AuxStackWorksLess.isEmpty()) {
            System.out.print("    "+AuxStackWorksLess.pop());
        }
        System.out.println();

        System.out.println("The character/s that works less as a team working with weights is/are:    " + workLess2(graph));
    }
    /*******************************************************************************************************************
     * Method name: friendliestCharacter
     *
     * Authors:     Josue Carlos Zenteno Yave
     *              Marina Prieto Pech
     *              Ismael Camacho Talavera
     *
     * Description of the Method: Method that goes through the graph using the numberOfIncidentVertex() method in each
     *                            node, saving the node that has the maximum number of edges.

     * Calling arguments: Graph<DecoratedElement<String>, DecoratedElement<Integer>> graph
     *
     * Return value: String
     ******************************************************************************************************************/
    private static String friendliestCharacter(Graph<DecoratedElement<String>, DecoratedElement<Integer>> graph) {

        Vertex<DecoratedElement<String>> vertex;
        String hero = null;
        int relationships = 0;

        Iterator<Vertex<DecoratedElement<String>>> iter = graph.getVertices();

        while(iter.hasNext()) {
            vertex = iter.next();
            if(numberOfIncidentVertex(graph,vertex) > relationships) {
                relationships = numberOfIncidentVertex(graph, vertex);
                hero = vertex.getElement().getElement();
            }
        }
        return hero;
    }
    /*******************************************************************************************************************
     * Method name: worksLess
     *
     * Authors:     Josue Carlos Zenteno Yave
     *              Marina Prieto Pech
     *              Ismael Camacho Talavera
     *
     * Description of the Method: Method that goes through the graph using the numberOfIncidentVertex() method in each
     *                            node, saving the node that has the minimum number of edges.

     * Calling arguments: Graph<DecoratedElement<String>, DecoratedElement<Integer>> graph
     *
     * Return value: String
     ******************************************************************************************************************/
    private static Stack <String> worksLess(Graph<DecoratedElement<String>, DecoratedElement<Integer>> graph) {

        Vertex<DecoratedElement<String>> vertex;
        String hero = null;
        int relationships = 10000000;
        Stack<String> st = new Stack<String>();

        Iterator<Vertex<DecoratedElement<String>>> iter = graph.getVertices();

        while(iter.hasNext()) {
            vertex = iter.next();
            if(numberOfIncidentVertex(graph,vertex) < relationships) {
                relationships = numberOfIncidentVertex(graph, vertex);
                hero = vertex.getElement().getElement();

            }else if(numberOfIncidentVertex(graph,vertex) == relationships && !(vertex.getElement().getElement()).equals(hero)){

                st.push(hero);
                st.push(vertex.getElement().getElement());
            }
        }
        return st;
    }
    /*******************************************************************************************************************
     * Method name: workLess2
     *
     * Authors:     Josue Carlos Zenteno Yave
     *              Marina Prieto Pech
     *              Ismael Camacho Talavera
     *
     * Description of the Method: Method that goes through the graph using the weightInEachVertex() method in each
     *                            node, saving the node that has the minimum sum of weights.

     * Calling arguments: Graph<DecoratedElement<String>, DecoratedElement<Integer>> graph
     *
     * Return value: String
     ******************************************************************************************************************/
    private static String workLess2(Graph<DecoratedElement<String>, DecoratedElement<Integer>> graph) {

        Vertex<DecoratedElement<String>> vertex;
        String hero = null;
        int relationships = 10000000;

        Iterator<Vertex<DecoratedElement<String>>> iter = graph.getVertices();

        while(iter.hasNext()) {
            vertex = iter.next();
            if(weightInEachVertex(graph,vertex) < relationships) {
                relationships = weightInEachVertex(graph, vertex);
                hero = vertex.getElement().getElement();
            }
        }
        return hero;
    }
    /*******************************************************************************************************************
     * Method name: mostFamousTeam
     *
     * Name of the original author: Same of class
     *
     * Description of the Method: Method that generates a team taking into account two selected heroes and associating
     *                            via the most sociable heroes.
     *
     * Calling arguments: Graph<DecoratedElement<String>, DecoratedElement<Integer>> graph
     ******************************************************************************************************************/
    private static void mostFamousTeam(Graph<DecoratedElement<String>, DecoratedElement<Integer>> graph) {

        Vertex<DecoratedElement<String>> vertex1, vertex2;
        boolean error;
        String hero1,hero2;

        do {

            error = false;

            System.out.println("Introduce the first hero name");
            sc.nextLine();
            hero1 = sc.nextLine();

            System.out.println("Introduce the second hero name");
            hero2 = sc.nextLine();

            if((vertex1 = FileReader.searchInGraph(hero1, graph)) == null){
                System.out.println("Error. " + hero1 + " doesn't exist on the graph\n");
                error = true;
            }

            if((vertex2 = FileReader.searchInGraph(hero2, graph)) == null){
                System.out.println("Error. " + hero2 + " doesn't exist on the graph\n");
                error = true;
            }

        }while(error);

        clearVisited(graph);
        setUnparent(graph);

        Vertex<DecoratedElement<String>> v = BFS(graph,vertex1,vertex2);

        if((v == null) || (!v.equals(FileReader.searchInGraph(hero2,graph)))) {
            System.out.println("The path doesn't exist");
        }else {
            showPath(v.getElement());
        }
    }
    /*******************************************************************************************************************
     * Method name: lessSociableTeam
     *
     * Authors:     Josue Carlos Zenteno Yave
     *              Marina Prieto Pech
     *              Ismael Camacho Talavera
     *
     * Description of the Method: Method that triggers DFS to find the needed result and store it into a stack
     *                            if the selected heroes are valid
     *
     * Calling arguments: Graph<DecoratedElement<String>, DecoratedElement<Integer>> graph.
     ******************************************************************************************************************/
    private static void lessSociableTeam (Graph<DecoratedElement<String>, DecoratedElement<Integer>> graph) {

        String[] heroes = new String[2];

        for (int i = 0; i < 2; i++) {
            System.out.println("Select hero number " + (i+1) + " : ");
            heroes[i] = sc.next();
            heroes[i] += sc.nextLine();
        }// Heroes Selection

        if (heroes[0].equals(heroes[1])) {
            System.out.println("ERROR. IMPOSSIBLE TO MAKE A PATH WITH THE SAME STARTING AND ENDING POINT");
        } else {
            if ((FileReader.searchInGraph(heroes[0], graph)) != null && (FileReader.searchInGraph(heroes[1], graph)) != null) {

                Stack<Vertex<DecoratedElement<String>>> stack = new Stack<>();//Creation of the stack used for the DFS
                DFS(graph, (FileReader.searchInGraph(heroes[0], graph)), (FileReader.searchInGraph(heroes[1], graph)), stack);
                clearVisited(graph);//After we do the path, we clear the visited nodes to ensure no errors

                String [] array = new String [stack.size()] ;
                for (int i = 0; i < array.length; i++) {
                    array[i] = stack.pop().getElement().getElement();
                }
                for(int i = array.length-1; i>0; i--){
                    System.out.print(array[i]+" -> ");
                }
                System.out.print(heroes[1]);
            } else {
                System.out.println("ERROR AT HERO SELECTION");
            }//Error when a given name isn't at the graph
        }
    }
    /*******************************************************************************************************************
     * Method name: numberOfIncidentVertex
     *
     * Authors:     Josue Carlos Zenteno Yave
     *              Marina Prieto Pech
     *              Ismael Camacho Talavera
     *
     * Description of the Method: Method that counts the number of incident edges in a node.
     *
     * Calling arguments:
     *              -Graph<DecoratedElement<String>, DecoratedElement<Integer>> graph
     *              -Vertex<DecoratedElement<String>> vertex
     *
     * Return value: int
     ******************************************************************************************************************/
    private static int numberOfIncidentVertex(Graph<DecoratedElement<String>, DecoratedElement<Integer>> graph, Vertex<DecoratedElement<String>> vertex) {

        int numberOfIncidentEdges = 0;

        Iterator<Edge<DecoratedElement<Integer>>> iter = graph.incidentEdges(vertex);

        while(iter.hasNext()) {
            iter.next();
            numberOfIncidentEdges++;
        }
        return numberOfIncidentEdges;
    }
    /*******************************************************************************************************************
     * Method name: weightInEachVertex
     *
     * Authors:     Josue Carlos Zenteno Yave
     *              Marina Prieto Pech
     *              Ismael Camacho Talavera
     *
     * Description of the Method: Method that sums the weights of incident edges in a node.
     *
     * Calling arguments:
     *              -Graph<DecoratedElement<String>, DecoratedElement<Integer>> graph
     *              -Vertex<DecoratedElement<String>> vertex
     *
     * Return value: int
     ******************************************************************************************************************/
    private static int weightInEachVertex(Graph<DecoratedElement<String>, DecoratedElement<Integer>> graph, Vertex<DecoratedElement<String>> vertex) {

        int weight =0;
        Iterator<Edge<DecoratedElement<Integer>>> iter = graph.incidentEdges(vertex);

        while(iter.hasNext()) {
            weight += iter.next().getElement().getElement();
        }
        return weight;
    }
    /*******************************************************************************************************************
     * Method name: DFS
     *
     * Authors:     Josue Carlos Zenteno Yave
     *              Marina Prieto Pech
     *              Ismael Camacho Talavera
     *
     * Description of the Method: Method that works according to the DFS algorithm, storing positions onto a given stack
     *
     * Calling arguments:
     *                      -Graph<DecoratedElement<String>, DecoratedElement<Integer>> graph
     *                      -Vertex<DecoratedElement<String>> first
     *                      -Vertex<DecoratedElement<String>> last
     *                      -Stack<Vertex<DecoratedElement<String>>> stack
     *
     * Return value: boolean
     ******************************************************************************************************************/
    private static boolean DFS(Graph<DecoratedElement<String>, DecoratedElement<Integer>> graph, Vertex<DecoratedElement<String>> first, Vertex<DecoratedElement<String>> last, Stack<Vertex<DecoratedElement<String>>> stack) {

        boolean noEnd = !first.equals(last);
        Edge<DecoratedElement<Integer>> edge;
        Iterator<Edge<DecoratedElement<Integer>>> it;
        Vertex<DecoratedElement<String>> currentVertex;

        first.getElement().setVisited(true);
        stack.push(first);

        it = graph.incidentEdges(first);
        while (it.hasNext() && noEnd) {
            edge = it.next();
            currentVertex = graph.opposite(first, edge);
            if (!currentVertex.getElement().getVisited() && edge.getElement().getElement() < 11) {
                noEnd = DFS(graph, currentVertex, last, stack);
                if (noEnd) {
                    stack.pop();
                }
            }
        }
        return noEnd;
    }
    /*******************************************************************************************************************
     * Method name: BFS
     *
     * Name of the original author: Same of class
     *
     * Description of the Method: Method that performs a BFS
     *
     * Calling arguments:
     *              -Graph<DecoratedElement<String>, DecoratedElement<Integer>> graph
     *              -Vertex<DecoratedElement<String>> startingVertex
     *              -Vertex<DecoratedElement<String>> endingVertex
     *
     * Return value: Vertex<DecoratedElement<String>>
     ******************************************************************************************************************/
    private static Vertex<DecoratedElement<String>> BFS(Graph<DecoratedElement<String>, DecoratedElement<Integer>> graph, Vertex<DecoratedElement<String>> startingVertex, Vertex<DecoratedElement<String>> endingVertex) {

        Queue<Vertex<DecoratedElement<String>>> queue = new LinkedList<Vertex<DecoratedElement<String>>>();

        boolean noTheEnd = true;

        Vertex<DecoratedElement<String>> vertex1, vertex2 = null;

        Edge<DecoratedElement<Integer>> auxEdge;

        Iterator<Edge<DecoratedElement<Integer>>> iterator;

        startingVertex.getElement().setVisited(true);

        queue.offer(startingVertex); //we insert the starting vertex into the queue

        while (!queue.isEmpty() && noTheEnd) {  //While the queue is not empty and the second vertex is not the ending vertex

            vertex1 = queue.poll(); //we remove the starting vertex copying it in the vertex1 (aux vertex)

            iterator = graph.incidentEdges(vertex1); //We create an iterator that iterates between the incident edges of the aux vertex.

            while (iterator.hasNext() && noTheEnd) {  //While the iterator is not empty and the second vertex is not the ending vertex
                auxEdge = iterator.next();

                if(auxEdge.getElement().getElement() >= 15) { //Only if the edge has a weight equal or grater than 15

                    vertex2 = graph.opposite(vertex1, auxEdge); //We save the opposite vertex (which is connected with Vertex1)

                    if (!(vertex2.getElement()).getVisited()) {
                        (vertex2.getElement()).setVisited(true);
                        (vertex2.getElement()).setParent(vertex1.getElement());
                        queue.offer(vertex2);
                        noTheEnd = !(vertex2.getElement().equals(endingVertex.getElement()));
                    }
                }
            }
        }

        if (noTheEnd)
            vertex2.getElement().setParent(null);

        if(!vertex2.equals(endingVertex)) vertex2 = null;

        return vertex2;
    }
    /*******************************************************************************************************************
     * Method name: clearVisited
     *
     * Authors:     Josue Carlos Zenteno Yave
     *              Marina Prieto Pech
     *              Ismael Camacho Talavera
     *
     * Description of the Method: Method to clear nodes marked as visited
     *
     * Calling arguments: Graph<DecoratedElement<String>, DecoratedElement<Integer>> graph.
     ******************************************************************************************************************/
    private static void clearVisited(Graph<DecoratedElement<String>, DecoratedElement<Integer>> graph) {

        Iterator<Vertex<DecoratedElement<String>>> iter = graph.getVertices();
        Vertex<DecoratedElement<String>> vertex;

        while(iter.hasNext()) {
            vertex = iter.next();
            if (vertex.getElement().getVisited()) {
                vertex.getElement().setVisited(false);
            }
        }
    }
    /*******************************************************************************************************************
     * Method name: setUnparent
     *
     * Authors:     Josue Carlos Zenteno Yave
     *              Marina Prieto Pech
     *              Ismael Camacho Talavera
     *
     * Description of the Method: Method that unparent the nodes
     *
     * Calling arguments: Graph<DecoratedElement<String>, DecoratedElement<Integer>> graph
     ******************************************************************************************************************/
    private static void setUnparent(Graph<DecoratedElement<String>, DecoratedElement<Integer>> graph) {

        Iterator<Vertex<DecoratedElement<String>>> iter = graph.getVertices();
        while (iter.hasNext()) {
            iter.next().getElement().setParent(null);
        }
    }
    /*******************************************************************************************************************
     * Method name: showPath
     *
     * Authors:     -Josue Carlos Zenteno Yave
     *              -Marina Prieto Pech
     *              -Ismael Camacho Talavera
     *
     * Description of the Method: Method that prints the path
     *
     * Calling arguments: DecoratedElement<String> element
     ******************************************************************************************************************/
    private static void showPath(DecoratedElement<String> element) {

        Stack<DecoratedElement<String>> path = new Stack<DecoratedElement<String>>();

        while(element.hasParent()) {
            path.push(element);
            element = element.getParent();
        }

        path.push(element);

        while(!path.isEmpty()) {
            System.out.print(path.pop().getElement());
            if(!path.isEmpty()) System.out.print(" --> ");
        }
    }
}
