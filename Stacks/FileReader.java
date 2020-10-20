import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
/***********************************************************************************************************************
 *Class Name:FileReader
 *Author/s Name:	Josue Carlos Zenteno Yave
 *					Marina Prieto Pech
 *					Ismael Camacho Talavera
 *Class Version: 1.0
 *Class Description: Class that get the information from the files and introduces it into the Stack
 **********************************************************************************************************************/
 class FileReader {
/***********************************************************************************************************************
 *Method Name: readItem
 *Author/s Name:	Josue Carlos Zenteno Yave
 *					Marina Prieto Pech
 *					Ismael Camacho Talavera
 *Description of the Method:	Method that reads, stores, and sorts the information of the file into the stack
 *Calling arguments: String path, String category
 *Return Value: Stack<Item>
 *Required Files: Files given in Campus Virtual
 *                  -feeds
 *                  -feeds_seq
 **********************************************************************************************************************/
    static Stack<Item> readItem(String path, String category) {
        File file = new File(path);
        Stack<Item> stack = new Stack<Item>(); 	//stack used to store the information of the file
        readFile(category, file, stack);	//We use the method readFile
        return sortStack(stack);            //We use the method sortStack
    }
/***********************************************************************************************************************
 *Method Name: readFile
 *Author/s Name:	Josue Carlos Zenteno Yave
 *					Marina Prieto Pech
 *					Ismael Camacho Talavera
 *Description of the Method: This method stores the information of the files using the String Tokenizer class in order
 *                            to help in the storing task.
 *Calling arguments: String category, File File, Stack<Item> stack
 *Return Value: Stack<Item>
 **********************************************************************************************************************/
    private static void readFile(String category, File File, Stack<Item> stack ) {
        try {
            BufferedReader br = new BufferedReader(new java.io.FileReader(File));
            String line;
            //While there're lines to read
            while((line = br.readLine()) != null){
                //We save the different parts of an Item using String tokenizer
                StringTokenizer st = new StringTokenizer(line, ";");
                String title = st.nextToken();
                String category_in = st.nextToken();
                //If the category is not the desired one, it's no necessary to store the rest of the information.
                //But if it's we store the rest of the information and then we push the new Item into the Stack
                if(category_in.equals(category)){
                    String description = st.nextToken();
                    String author = st.nextToken();
                    Date date = new SimpleDateFormat("dd/MM/yyyy").parse(st.nextToken());
                    stack.push(new Item(title, category_in, description,author,date));
                }
            }
            br.close();
        }catch(Exception ex) {
            System.out.println("Message: " + ex.getMessage());
        }
    }
/***********************************************************************************************************************
 *Method Name: sortStack
 *Author/s Name:	Josue Carlos Zenteno Yave
 *					Marina Prieto Pech
 *					Ismael Camacho Talavera
 *Description of the Method: This method sorts the stack considering the Dates of the Items
 *Calling arguments: Stack<Item> stack
 *Return Value: Stack<Item>
 **********************************************************************************************************************/
    private static Stack<Item> sortStack(Stack<Item> input){
        Stack<Item> tmpStack = new Stack<Item>();
        while(!input.isEmpty()) {
            // Pop out the first element
            Item tmp = input.pop();
            // while temporary stack is not empty and the date of the top Item in the stack is greater than temp.
            while(!tmpStack.isEmpty() && (tmpStack.peek().getDate()).compareTo(tmp.getDate()) > 0) {
                // pop from temporary stack and
                // push it to the input stack
                input.push(tmpStack.pop());
            }
            // push temp in temporary of stack
            tmpStack.push(tmp);
        }
        return tmpStack;
    }
}
