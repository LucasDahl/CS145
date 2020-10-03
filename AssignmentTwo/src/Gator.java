
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
    private Boolean isStationary, spinsRight;
    private int moves = 0;
    private Color[] colors = {Color.RED, Color.GREEN, Color.YELLOW, Color.BLUE, Color.CYAN, Color.BLACK, Color.MAGENTA, Color.ORANGE};
    Random rand = new Random();

    // ************************** Constructors ************************

    /**
     * This constructor only set the field for if the Gator
     * it's stationary(all are stationary at first).
     */
    public Gator() {

        spinsRight = rand.nextBoolean();
        isStationary = false;

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
        return colors[rand.nextInt(8)];
    }

    @Override
    public String toString() {
        return "G";
    }

    /**
     *Gators will attack at first, but after 1500 moves will become stationary to try
     * Infect enemy Critters. The Gator will start to move again after 3000 steps,
     * in an attempt to get any Flytraps or other stationary Critters.
     *
     * @param info this critter info will help with what action the critter should take.
     * @return The action will return INFECT, LEFT, RIGHT, or HOP
     */
    public Action getMove(CritterInfo info) {

        moves ++;

        // Start moving
        if( moves > 1500 && moves < 3000) {
            isStationary = true;
        }

        // For none moving Gators
        if(!isStationary) {

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

                if(info.getLeft() == Neighbor.EMPTY) {
                    return Action.RIGHT;
                } else if(info.getLeft() == Neighbor.SAME || info.getLeft() == Neighbor.WALL) {
                    return Action.RIGHT;
                } else {
                    return  Action.LEFT;
                }

            } else {
                return Action.HOP;
            }

        } else {

            // If the Gator is not moving.
            if(spinsRight) {

                if (info.getFront() == Neighbor.OTHER) {
                    return Action.INFECT;
                } else {
                    return Action.RIGHT;
                }

            } else {
                if (info.getFront() == Neighbor.OTHER) {
                    return Action.INFECT;
                } else {
                    return Action.LEFT;
                }
            }


        }
    }
}
