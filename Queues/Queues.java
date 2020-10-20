import java.util.PriorityQueue;// Import used for creation of the queue

/*********************************************************************************************************************************************************************************************************************
 *
 * Class Name: Queues
 * Author/s Name: Marina Prieto Pech, Ismael Camacho Talavera, Josué Carlos Zenteno Yave
 * Release/Creation date: 7th of november, 2019
 * Class Version: 1.0
 * Class Descripton: Class where the main program is made, associated with rest of classes
 *
 *********************************************************************************************************************************************************************************************************************/

public class Queues implements Interface{

    /*********************************************************************************************************************************************************************************************************************
     *
     * Method Name: main
     * Descripton of the Method: Main method which performs the main operations
     * Calling arguments: String[] args
     *
     *********************************************************************************************************************************************************************************************************************/

    public static void main(String[] args) {

        PriorityQueue<Criminal> policeStation = new PriorityQueue<>();// Creation of the priority queue

        int actualCriminals = 0;// Counter for actual criminals in the police station
        int t;// Temporal variable to pass the time when storing the criminals

        System.out.println("**************************************************************************************************************************");
        System.out.println("                                                Criminals By Arrival Time:                                                ");
        System.out.println("**************************************************************************************************************************\n");

        for (int i = 0; i < ((nCriminals * arrivalTime) + registerTime); i +=arrivalTime) {

            if (actualCriminals < (nCriminals)) {

                t = i + registerTime;// Temporal time gets added the register time to the moment of arrival of the criminal
                actualCriminals++;// Increment of the number of criminals

                Criminal offender = CriminalGenerator.criminalGenerator(t);// Generates each criminal with each time
                System.out.println(offender.toString());// Prints information generated
                policeStation.add(offender);// Adds each offender to the queue

            }// End of if loop to ensure we generate the correct number of criminals
        }// End of for loop which creates criminals, prints them, and stores them into the priority queue

        System.out.println("**************************************************************************************************************************");
        System.out.println("                                                  Criminals By Priority:                                                  ");
        System.out.println("**************************************************************************************************************************\n");

        while (!policeStation.isEmpty()) {
            System.out.println(policeStation.remove());
        }// End of while loop that goes removing elements from the queue taking into account its priority so they get re-ordered

        System.out.println("**************************************************************************************************************************");
    }// End of main

}// End of class