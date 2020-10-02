import java.awt.*;
import java.util.Random;

/**
 *  This class makes a Lion critter that will extend from
 *  the Critter super class.
 *
 * @author Lucas D. Dahl
 * @version 9/25/20
 *
 */
public class Lion extends Critter  {

    // **************************** Fields ****************************
    private Color lionColor;
    private Color[] colorArray = {Color.RED, Color.GREEN, Color.YELLOW, Color.BLUE};
    private Random randomColorNum = new Random();
    private int moves = 0;

    // ************************** Constructors ************************

    /**
     * This is the default constructor that sets
     * the lions initial color.
     */
    public Lion() {

        lionColor = colorArray[randomColorNum.nextInt(4)];

    }

    // **************************** Methods ***************************

    @Override
    public String toString() {
        return "L";
    }

    /**
     * This method will return the color of the
     * Lion which is randomly chosen from an array
     * after every 3 steps
     * @return returns the color of the Lion.
     */
    public Color getColor() {

        if(moves > 3) {
            lionColor = colorArray[randomColorNum.nextInt(4)];
            moves = 0;
        }

        return lionColor;
    }

    /**
     *This method will take in critter info and make
     * moves based on the info by returning and Action
     *
     * @param info this critter info will help with what action the critter should take.
     * @return The action will return INFECT, LEFT, RIGHT, or HOP
     */
    public Action getMove(CritterInfo info) {

        moves++;

        if (info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;
        } else if(info.getFront() == Neighbor.WALL && info.getRight() == Neighbor.WALL) {
            return Action.LEFT;
        } else if (info.getFront() == Neighbor.SAME) {
            return Action.RIGHT;
        } else {
            return Action.HOP;
        }

    }
}
