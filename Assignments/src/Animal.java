
import java.util.Random;
/**
 *
 * This program makes animal objects.
 *
 * @author Lucas D. Dahl
 * @version 9/22/20
 *
 */
public class Animal {

    // **************************** Fields ****************************
    private String name;
    private int xCoor, yCoor;

    // ************************** Constructors ************************

    /**
     * This is the default constructor setting hardcoded values for
     * the fields.
     *
     */
    public Animal() {

        name = "Rabbit";
        xCoor = 0;
        yCoor = 0;

    }

    /**
     * This constructor sets all fields for the animal
     *
     * @param name will be the name of the animal.
     * @param x is the x coordinate of the animal.
     * @param y is the y coordinate of the animal.
     */
    public Animal(String name, int x, int y) {

        this.name = name;
        xCoor = x;
        yCoor = y;

    }

    // **************************** Methods ***************************

    /**
     * This method returns the name of the animal.
     * @return the name of the animal.
     */
    public String getName() {
        return name;
    }

    /**
     * This method simply returns the x coordinate.
     * @return the x coordinate of the animal.
     */
    public int getX() {
        return xCoor;
    }

    /**
     * This method simply returns the y coordinate.
     * @return the y coordinate of the animal.
     */
    public int getY() {
        return yCoor;
    }

   @Override // Java Doc annotation, replaces manual java doc.
    public String toString() {

        String describe = "";

        describe = describe + name;
        describe = describe + " is at (";
        describe = describe + xCoor;
        describe = describe + ", ";
        describe = describe + yCoor;
        describe = describe + ").";

        return describe;
    }

    /**
     * This method determines if two animals are touching.
     *
     * @param x is the second animal object
     * @return will return a boolean as true if the animals are touching, and false if they are not.
     */
    public boolean touching(Animal x) {

        if(this.xCoor == x.xCoor && this.yCoor == x.yCoor) {
            return true;
        } else {
            return false;
        }

    }

    public void move() {

        // Properties
        Random randomNum = new Random();
        int min = - 3, max = 3;

        // Move the animal
        xCoor = randomNum.nextInt(max - min) + min;
        yCoor = randomNum.nextInt(max - min) + min;

        // Put the animal back on the grid if they went off
        // but put them on the other side.

        // Check the x coordinate
        if(xCoor > 25) {
            xCoor = xCoor - 50;
        } else if (xCoor < -25) {
            xCoor = xCoor + 50;
        }

        // Check the y coordinate
        if(yCoor > 25) {
            yCoor = yCoor - 50;
        } else if (yCoor < -25) {
            yCoor = yCoor + 50;
        }


    }

}
