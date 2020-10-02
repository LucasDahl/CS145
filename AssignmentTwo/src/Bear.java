import com.sun.org.apache.xpath.internal.operations.Bool;

import java.awt.*;
/**
 *  This class makes a Bear critter that will extend from
 *  the Critter super class.
 *
 * @author Lucas D. Dahl
 * @version 9/25/20
 *
 */
public class Bear extends Critter {

    // **************************** Fields ****************************
    private Color bearColor;
    private int moves = 0;


    // ************************** Constructors ************************

    /**
     * This constructor will set the color of the Bear.
     *
     * @param polar is a boolean that will make the bear a Polar bear or not.
     */
    public Bear(Boolean polar) {
        if(polar) {
            bearColor = Color.WHITE;
        } else {
            bearColor = Color.BLACK;
        }
    }

    // **************************** Methods ***************************

    @Override
    public String toString() {
        if (moves % 2 == 0) {
            return "\\";
        } else {
            return "/";
        }
    }

    /**
     * This method will return the given color of the bear
     * which is determined on initialization.
     * @return this returns the color of the bear.
     */
    public Color getColor() {
        return bearColor;
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
        } else if(info.getFront() == Neighbor.EMPTY) {
            return Action.HOP;
        } else if(info.getFront() == Neighbor.WALL) {

            if(info.getLeft() == Neighbor.EMPTY) {
                return Action.LEFT;
            } else {
                return Action.RIGHT;
            }

        } else {
            return super.getMove(info);
        }

    }
}
