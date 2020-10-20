import java.util.Random;// Import random, for the number generating to use later

/*********************************************************************************************************************************************************************************************************************
 *
 * Class Name: CriminalGenerator
 * Author/s Name: Marina Prieto Pech, Ismael Camacho Talavera, Josué Carlos Zenteno Yave
 * Release/Creation date: 7th of november, 2019
 * Class Version: 1.0
 * Class Description: Class which generates random values for each criminals and takes the time of arrival
 *
 *********************************************************************************************************************************************************************************************************************/

public class CriminalGenerator implements Interface {

    /*********************************************************************************************************************************************************************************************************************
     *
     * Method Name: criminalGenerator
     * Description of the Method: We generate random values for each variable and store them in an object
     * Calling arguments: int time
     * Return Value: object Criminal(DNI, crime, level, time)
     *
     *********************************************************************************************************************************************************************************************************************/

    public static Criminal criminalGenerator (int time) {

        Random random = new Random();// Creates an object from random, which helps generating numbers

        String crime = "";// We declare the variable, to then change it to final string
        String level = "";// Same as crime, we declare to then modify

        int DNI = random.nextInt(maxDNI + 1);// Generates random DNI between 0 and 99.999.999

        switch (random.nextInt(maxCrime)) {
            case 0:
                crime = "Tax crime";
                break;
            case 1:
                crime = "Theft";
                break;
            case 2:
                crime = "Harassment";
                break;
            case 3:
                crime = "Drugs";
                break;
            case 4:
                crime = "Guns";
                break;
            case 5:
                crime = "Other";
                break;
        }// End of switch to determine crime type with help of random numbers

        switch(random.nextInt(maxHazard)) {
            case 0:
                level = "Low-dangerous";
                break;
            case 1:
                level = "Contentious";
                break;
            case 2:
                level = "High-dangerous";
                break;
        }// End of switch to determine hazard level as string, with help of the random number generator

        return new Criminal(DNI, crime, level, time);// Creates an Object (criminal) and returns it to the main method
    }// End of method

}// End of class