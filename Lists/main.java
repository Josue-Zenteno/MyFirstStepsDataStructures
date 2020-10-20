import java.util.*;
/*********************************************************************************************************************************************************************************************************************
 *
 *Class Name: main
 *Author/s Name: Josué Carlos Zenteno Yave
 *				Marina Prieto Pech
 *				Ismael Camacho Talavera
 *Class Version: 1.0
 *Class Descripton: Main class of the program
 *
 *********************************************************************************************************************************************************************************************************************/
public class main {
    /*******************************************************************************************************************
     *Method Name: main
     *Author/s Name:    Josue Carlos Zenteno Yave
     *                    Marina Prieto Pech
     *                    Ismael Camacho Talavera
     *Description of the Method: Main method of the program that contains:
     *                              - do, while loop.
     *                              - For and if loop to add neighbors to the lists and to go throughout the list.
     *******************************************************************************************************************/
    public static void main(String[]args){
        ArrayList<neighbor>listA=create();
        ArrayList<neighbor>listB=create();
        ArrayList<neighbor>pollingstation=new ArrayList<neighbor>();
        System.out.println("District A" + listA.toString());
        System.out.println("District B" + listB.toString());
do{
            for (int i = 0; i < 20 && pollingstation.size() < 4; i++) {
                String num1 =listA.get(i).getDni() + "";
                String num2 =listB.get(19 - i).getDni() + "";
                String final1 = num1.substring(num1.length()-1);
                String final2 = num2.substring(num2.length()-1);
                if (final1.equals(final2)) {
                    pollingstation.add(listA.get(i));
                    pollingstation.add(listB.get(19 - i));
                }
            }
            if (pollingstation.size() < 4)
                for (int i = 0; (i < 20) && pollingstation.size() < 4; i++) {
                    String num1 =listA.get(i).getDni() + " ";
                    String num2 =listB.get(i).getDni() + " " ;
                    String final1 = num1.substring(num1.length()-1);
                    String final2 = num2.substring(num2.length()-1);
                    if (final1.equals(final2)) {
                        pollingstation.add(listA.get(i));
                        pollingstation.add(listB.get(i));
                    }
                }
        } while(pollingstation.size()<4);
        System.out.println("Polling Table" + pollingstation.toString());
    }
    /*******************************************************************************************************************
     *Method Name: create
     *Author/s Name:    Josue Carlos Zenteno Yave
     *                    Marina Prieto Pech
     *                    Ismael Camacho Talavera
     *Description of the Method: This method creates the array lists that are defined in the main method.
     *Calling arguments:
     *Return Value: list<neighbor>
     *******************************************************************************************************************/
    private static ArrayList<neighbor> create() {
        ArrayList<neighbor>list=new ArrayList<neighbor>();
        int n=0;
        while(n<20){
            neighbor x=new neighbor(0);
            x.setDni(x.randomDni());
            list.add(x);
            n=n+1;
        }
        return list;
    }
}
