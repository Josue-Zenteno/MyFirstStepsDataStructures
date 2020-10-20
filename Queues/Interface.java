/*********************************************************************************************************************************************************************************************************************
 *
 * Class Name: Interface
 * Author/s Name: Marina Prieto Pech, Ismael Camacho Talavera, Josué Carlos Zenteno Yave
 * Release/Creation date: 7th of november, 2019
 * Class Version: 1.0
 * Class Description: Interface used to define maximum and minimum values needed for Criminals
 *
 *********************************************************************************************************************************************************************************************************************/

public interface Interface {

     int maxDNI = 99999999;  // Maximum DNI assignable value
     int maxHazard = 3;      // Number of possible levels of hazard
     int maxCrime = 6;       // Number of possible offences
     int nCriminals = 50;    // Number of generated "criminals" by the program
     int arrivalTime = 60;   // Time it needs a criminal to arrive
     int registerTime = 90;  // Needed time to register each criminal

}// End of interface