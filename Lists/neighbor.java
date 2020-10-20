import java.util.Random;
/***********************************************************************************************************************
 *Class Name: neighbor
 *Author/s Name: Josué Carlos Zenteno Yave
 *  *				Marina Prieto Pech
 *  *				Ismael Camacho Talavera
 *Class Version: 1.0
 *Class Descripton: Neighbor class compound by:
 *                      - DNI of the neighbour
 *                      - Constructor of the class
 *                      - Getters and Setters
 *                      - randomDni method
 ***********************************************************************************************************************/
public class neighbor {
    int dni;
    public neighbor(int dni){
        this.dni=dni;
    }
    public int getDni(){
        return dni;
    }
    public void setDni(int dni){
        this.dni=dni;
    }
    /*******************************************************************************************************************
     *Method Name: randomDni
     *Author/s Name:    Josue Carlos Zenteno Yave
     *                    Marina Prieto Pech
     *                    Ismael Camacho Talavera
     *Description of the Method:    Method that creates a random number using Random class from the Java API
     *Calling arguments:
     *Return Value: integer random
     *******************************************************************************************************************/
    public int randomDni(){
        Random rd= new Random();
        int random=rd.nextInt(100000000);
        return random;
    }
    public String toString(){
        return "\n -DNI: " + dni;
    }
}
