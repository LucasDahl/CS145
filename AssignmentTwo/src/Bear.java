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

    @Override
    public Color getColor() {
        return bearColor;
    }

    @Override
    public Action getMove(CritterInfo info) {

        moves++;

        if (info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;
        } else if(info.getFront() == Neighbor.EMPTY) {
            return Action.HOP;
        } else {
            return super.getMove(info);
        }

    }
}
