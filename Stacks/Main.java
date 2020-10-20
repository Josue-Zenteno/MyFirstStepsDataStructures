import java.util.Scanner;
import java.util.Stack;
/***********************************************************************************************************************
 *Class Name: Main
 *Author/s Name:	Josue Carlos Zenteno Yave
 *					Marina Prieto Pech
 *					Ismael Camacho Talavera
 *Class Version: 1.0
 *Class Description: Main class and interface of the program
 **********************************************************************************************************************/
public class Main {
    private static Scanner sc = new Scanner(System.in);
/***********************************************************************************************************************
 *Method Name: main
 *Author/s Name:        Josue Carlos Zenteno Yave
 *  					Marina Prieto Pech
 *  					Ismael Camacho Talavera
 *Description of the Method: Principal method where we ask for the desired category and prints the Items.
 **********************************************************************************************************************/
    public static void main(String[] args) {
        //This is a menu that allows the user to choose between to use sequential or not sequential file
        System.out.println("Choose one:\n1) Sequential File\n2) No Sequential File");
        String path="";
        String category;
        switch(sc.nextInt()){
            case 1:
                path="feeds_seq.txt";
                break;
            case 2:
                path="feeds.txt";
                break;
        }
        System.out.println("Choose your category:");
        sc.nextLine();
        category=sc.nextLine();
        //We create an Stack of Items
        Stack<Item> stack = FileReader.readItem(path,category); //We fill the stack reading the file
        //We've to check if the stack is empty or not
        if(!(stack.size() == 0)) {
            while(stack.size() > 0)
                System.out.println(stack.pop().toString()); //We print all the information of every Item
        }else {
            System.out.println("Error, you've introduced an invalid category");
        }
    }
}
