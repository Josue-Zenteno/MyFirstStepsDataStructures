/*********************************************************************************************************************************************************************************************************************
 *
 * Class Name: Criminal
 * Author/s Name: Marina Prieto Pech, Ismael Camacho Talavera, Josué Carlos Zenteno Yave
 * Release/Creation date: 7th of november, 2019
 * Class Version: 1.0
 * Class Description: Class which stores the information for each criminal arriving, by creating an object ("criminal")
 *                   Here, we also create the compareTo method in order to then establish priority between objects
 *
 *********************************************************************************************************************************************************************************************************************/

public class Criminal implements Comparable<Criminal>{

     private int DNI;	    // DNI number
     private String crime;  // Crime type
     private String level;  // Level of hazard
     private int time;      // Time of arrival of a criminal starting at police office opening

     /*********************************************************************************************************************************************************************************************************************
      *
      * Method Name: Criminal
      * Description of the Method: Constructor method with defined variables
      * Calling arguments: int d, String c, String l, int a, int r. All of those are the variables that conform the object
      *
      *********************************************************************************************************************************************************************************************************************/

     public Criminal (int d, String c, String l, int t) {

         DNI = d;
         crime = c;
         level = l;
         time = t;
     }// End of constructor, which determines values of the object

     /*********************************************************************************************************************************************************************************************************************
      *
      * Method Name: getLevel
      * Description of the Method: Getter for the variables "level""
      * Return Values: String level
      *
      *********************************************************************************************************************************************************************************************************************/

     public String getLevel () {

         return level;
     }// End of getlevel method

     /*********************************************************************************************************************************************************************************************************************
      *
      * Method Name: toString
      * Description of the Method: Prints information of each criminal (DNI, crime, hazard, time)
      * Return Value: String, to be printed on screen
      *
      *********************************************************************************************************************************************************************************************************************/

    public String toString() {

        return "DNI: " + DNI + " || Crime type: " + crime + " || Hazard level: " + level + " || Time: " + time + " seconds from police station opening";
    }

     /*********************************************************************************************************************************************************************************************************************
      *
      * Method Name: compareTo
      * Description of the Method: Comparator of priorities for our priority queue, where the options of position are established
      * Calling arguments: Criminal offender
      * Return value: int of comparison between both given values
      *
      *********************************************************************************************************************************************************************************************************************/

     public int compareTo(Criminal offender) {

         int level1 = numericLevel(this.getLevel());// We translate first level to a natural number
         int level2 = numericLevel(offender.getLevel());// We translate second level to a natural number

         if(level1 < level2) {

             return 1;
         } else if (level1 > level2) {

             return -1;
         } else {

             if (this.time < offender.time) {

                 return -1;
             } else {

                 return 1;
             }// If-else loop that sorts by time when compared elements are equal
         }// If-elseif-else loop to return priority level of the queue, leaving high to the top
     }// End of compareTo method

    /*********************************************************************************************************************************************************************************************************************
     *
     * Method Name: numericLevel
     * Description of the Method: Takes the level string and translates it again into a number in order to evaluate priority
     * Calling arguments: String level
     * Return value: int level (priority as a number)
     *
     *********************************************************************************************************************************************************************************************************************/

    public int  numericLevel(String level) {

         int numLevel = 0;

         if (level == "Low-dangerous") {

             numLevel = 0;
         } else if (level == "Contentious") {

             numLevel = 1;
         } else if (level == "High-dangerous") {

             numLevel = 2;
         }// We translate string level to numeric level so we can compare

         return numLevel;
     }// End of numericLevel method

 }// End of class