import java.io.*;
import java.util.*;
import graphsDSESIUCLM.*;
/***********************************************************************************************************************
 * Class Name: FileReader
 *
 * Author/s name:   Josue Carlos Zenteno Yave
 *		            Marina Prieto Pech
 *		            Ismael Camacho Talavera
 *
 * Release/Creation date: 10/12/2019
 *
 * Class version: 1.0
 *
 * Class description: This class is responsible of getting the data from the CSV file and generate the graph using
 *                      the methods graphExpander() and searchInGraph()
 *********************************************************************************************************************/
public class FileReader {
/***********************************************************************************************************************
 * Method name: generateGraph
 *
 * Author/s name:   Josue Carlos Zenteno Yave
 *  		        Marina Prieto Pech
 *  	            Ismael Camacho Talavera
 *
 * Description of the Method: Method that creates he graph reading the CSV file and using the method graphExpander()
 *                            it adds new elements to the graph.
 *
 * Return value: Graph<DecoratedElement<String>, DecoratedElement<Integer>>
 *
 * Required Files: marvel-unimodal-edges.csv
 **********************************************************************************************************************/
    public static Graph<DecoratedElement<String>, DecoratedElement<Integer>> generateGraph() {

        Graph<DecoratedElement<String>, DecoratedElement<Integer>> graph = new TreeMapGraph<>();

        File csvInteractions = new File("marvel-unimodal-edges.csv");  // CSV File with the Data

        try {
            BufferedReader reader = new BufferedReader(new java.io.FileReader(csvInteractions));
            String line;
            reader.readLine();
            while((line = reader.readLine()) != null){

                StringTokenizer st = new StringTokenizer(line, ",");
                graphExpander(st.nextToken(), st.nextToken(),Integer.parseInt(st.nextToken()), graph);
                //System.out.println(st.nextToken()+st.nextToken()+Integer.parseInt(st.nextToken())); Tester reading the file
            }
            reader.close();
        }catch(Exception ex) {
            System.out.println("Message: " + ex.getMessage());
        }
        return graph;
    }
    /*******************************************************************************************************************
     * Method name: graphExpander
     *
     * Name of the original author: Josue Carlos Zenteno Yave
     *                              Marina Prieto Pech
     *                              Ismael Camacho Talavera
     *
     * Description of the Method: Method that compares the names of the read heroes, if they were not read before it
     *                            creates a new node and the new edge, otherwise it only creates a new edge. In order to
     *                            complete this task this method uses another method called searchInGraph()
     *
     * Calling arguments:
     *                  -String hero1
     *                  -String hero2
     *                  -int interaction
     *                  -Graph<DecoratedElement<String>, DecoratedElement<Integer>> graph
     ******************************************************************************************************************/
    private static void graphExpander(String hero1, String hero2, int interaction, Graph<DecoratedElement<String>, DecoratedElement<Integer>> graph){
        Vertex<DecoratedElement<String>> name1,name2;

        if((name1 = searchInGraph(hero1,graph)) == null) {
            name1 = graph.insertVertex(new DecoratedElement<String>(hero1,hero1));
        }
        if((name2 = searchInGraph(hero2,graph)) == null) {
            name2 = graph.insertVertex(new DecoratedElement<String>(hero2,hero2));
        }

        DecoratedElement<Integer> ed = new DecoratedElement<Integer>(hero1+"-"+hero2, interaction);

        graph.insertEdge(name1, name2, ed);
    }
    /*******************************************************************************************************************
     * Method name: searchInGraph
     *
     * Name of the original author: Josue Carlos Zenteno Yave
     *                              Marina Prieto Pech
     *                              Ismael Camacho Talavera
     *
     * Description of the Method:  Method that searches the graph starting from a superhero name. If given name is
     *                             already in the graph, we go through the graph with an Iterator (while we still
     *                             have vertexes).When no vertexes are found, null is returned.
     *
     * Calling arguments:
     *                      -String ch1
     *                      -Graph<DecoratedElement<String>,DecoratedElement<Integer>> graph
     *
     * Return value: Vertex<DecoratedElement<String>>
     ******************************************************************************************************************/
    public static Vertex<DecoratedElement<String>> searchInGraph(String ch1, Graph<DecoratedElement<String>, DecoratedElement<Integer>> graph) {

        boolean exists = false;
        Vertex<DecoratedElement<String>> auxCh = null;
        DecoratedElement<String> nx;

        Iterator<Vertex<DecoratedElement<String>>> iter = graph.getVertices();

        while (iter.hasNext() && !exists) {
            auxCh = iter.next();
            nx = auxCh.getElement();
            if((nx.getElement()).equals(new DecoratedElement<String>(ch1,ch1).getElement()))
                exists = true;
        }
        if(!exists) auxCh = null;
        return auxCh;
    }
}
