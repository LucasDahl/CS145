import java.awt.*;
/**
 *  This class makes a Titan critter that will extend from
 *  the Critter super class.
 *
 * @author Lucas D. Dahl
 * @version 9/25/20
 *
 */
public class Titan extends Giant {

    // **************************** Methods ***************************

    /**
     * This method will return the color of the
     * Titan, which changes based off what String is currently in
     * the toString method based off teh super class.
     * @return This returns the color of the Titan.
     */
    public Color getColor() {

        if(toString().equals("fee") || toString().equals("foe")) {
            return Color.BLACK;
        } else {
            return Color.WHITE;
        }

    }

    /**
     *This method will take in critter info and make
     * moves based on the info by returning and Action
     *
     * @param info this critter info will help with what action the critter should take.
     * @return The action will return INFECT, LEFT, RIGHT, or HOP
     */
    public Action getMove(CritterInfo info) {

        if(info.getFront() != Neighbor.OTHER && info.getFront() != Neighbor.EMPTY) {
            return Action.LEFT;
        } else {
            return super.getMove(info);
        }

    }
}
