import com.sun.org.apache.xpath.internal.operations.Bool;
import javafx.scene.control.RadioMenuItem;

import java.awt.*;
import java.util.Random;

/**
 *  This class makes a Gator critter that will extend from
 *  the Critter super class.
 *
 * @author Lucas D. Dahl
 * @version 9/25/20
 *
 */
public class Gator extends Critter  {

    // **************************** Fields ****************************
    private Boolean isStationary;
    private int moves = 0;
    private Color[] colors = {Color.RED, Color.GREEN, Color.YELLOW, Color.BLUE, Color.CYAN, Color.BLACK, Color.MAGENTA, Color.ORANGE};

    // ************************** Constructors ************************

    /**
     * This constructor only set the field for if the Gator
     * it's stationary(all are stationary at first).
     */
    public Gator() {

        isStationary = true;

    }

    // **************************** Methods ***************************


    /**
     * This method will return the color of
     * the Gator, which changes every step,
     * all though the same color can be chosen
     * multiple steps in a row.
     * @return This returns the color of the Gator.
     */
    public Color getColor() {
        Random rand = new Random();
        return colors[rand.nextInt(8)];
    }

    @Override
    public String toString() {
        return "G";
    }

    /**
     *This method will take in critter info and make
     * moves based on the info by returning and Action.
     * Gators start off as stationary, but after 2500 steps
     * they begin to move. The idea behind this is if it comes down
     * to another stationary enemy the Gators can go out and Infect,
     * this will create more traps that will grow. The inner most Gators
     * will be able to move before the outside Gators in order to be able to
     * reinfect the outside Gators who may be turned. This will also cause
     * the Gator groups expand and infect more enemies. An also out come is the inner
     * Gator will reinfect the previously turned Gator and continue to move and make more
     * Gator groups.
     *
     * @param info this critter info will help with what action the critter should take.
     * @return The action will return INFECT, LEFT, RIGHT, or HOP
     */
    public Action getMove(CritterInfo info) {

        moves ++;

        // Start moving
        if( moves > 3000) {
            isStationary = false;
        }

        // For none moving Gators
        if(!isStationary) {

            // For Gators that move.
            if(info.getFront() == Neighbor.OTHER) {
                return Action.INFECT;
            } else if(info.getFront() == Neighbor.WALL) {

                if(info.getRight() == Neighbor.SAME && info.getRightDirection() == info.getDirection()) {
                    return Action.LEFT;
                } else if(info.getLeft() == Neighbor.SAME && info.getLeftDirection() == info.getDirection()) {
                    return Action.RIGHT;
                } else {
                    return Action.RIGHT;
                }

            } else if(info.getFront() == Neighbor.SAME) {

                if(info.getLeft() == Neighbor.SAME || info.getLeft() == Neighbor.WALL) {
                    return Action.RIGHT;
                } else {
                    return  Action.LEFT;
                }

            } else {
                return Action.HOP;
            }

        }

        if (info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;
        } else {
            return Action.RIGHT;
        }

    }
}
