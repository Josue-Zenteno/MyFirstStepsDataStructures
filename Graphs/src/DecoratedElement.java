import graphsDSESIUCLM.*;
/***********************************************************************************************************************
 *Class Name: DecoratedElement
 *
 * Author/s name:  Josue Carlos Zenteno Yave
 *		           Marina Prieto Pech
 *		           Ismael Camacho Talavera
 *
 * Release/Creation date: 10/12/2019
 *
 * Class version: 1.0
 *
 * Class description: Class composed of the necessary methods to interact with the graph's elements.
 **********************************************************************************************************************/
public class DecoratedElement<T> implements Element {
    private String ID;         				// Identifier of the class
    private T element;                		// element of the node
    private boolean visited;         		//Boolean created in order to know if the vertex has been visited.
    private DecoratedElement<T> parent;		// Parent of the node
    /*******************************************************************************************************************
     * Method name: DecoratedElement
     *
     * Authors: Josue Carlos Zenteno Yave
     *          Marina Prieto Pech
     *          Ismael Camacho Talavera
     *
     * Description of the Method: Constructor of the class
     *
     * Calling arguments:
     *                      -String Identifier
     *                      -T element
     ******************************************************************************************************************/
    public DecoratedElement (String Identifier, T element) {
        this.element = element;
        ID = Identifier;
        visited = false;
        parent = null;
    }
    /*******************************************************************************************************************
     * Method name: hasParent
     *
     * Authors: Josue Carlos Zenteno Yave
     *          Marina Prieto Pech
     *          Ismael Camacho Talavera
     *
     * Description of the Method: This method task is to answer if the node has a parent or not
     *
     * Return value: boolean
     ******************************************************************************************************************/
    public boolean hasParent() {
        return (this.parent != null);
    }
    public T getElement() {
        return element;
    }
    public boolean getVisited() {
        return visited;
    }
    public void setVisited(boolean t) {
        visited = t;
    }
    public String getID() {
        return ID;
    }
    public DecoratedElement<T> getParent() {
        return parent;
    }
    public void setParent(DecoratedElement<T> parent) {
        this.parent = parent;
    }
    public String toString() {
        return element.toString();
    }
}