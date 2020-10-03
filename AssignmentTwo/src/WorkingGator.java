import java.awt.*;
import java.util.Random;

public class WorkingGator {

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
    public Critter.Action getMove(CritterInfo info) {

        moves ++;

        // Start moving
        if( moves > 1500) {
            isStationary = true;
        }

        // For none moving Gators
//        if(isStationary) {
//
//            if(info.getFront() == Neighbor.OTHER) {
//                return Action.INFECT;
//            } else if(info.getFront() == Neighbor.WALL) {
//
//                if(info.getRight() == Neighbor.SAME && info.getRightDirection() == info.getDirection()) {
//                    return Action.LEFT;
//                } else if(info.getLeft() == Neighbor.SAME && info.getLeftDirection() == info.getDirection()) {
//                    return Action.RIGHT;
//                } else {
//                    return Action.RIGHT;
//                }
//
//            } else if(info.getFront() == Neighbor.SAME) {
//
//                if(info.getLeft() == Neighbor.EMPTY) {
//                    return Action.RIGHT;
//                } else if(info.getLeft() == Neighbor.SAME || info.getLeft() == Neighbor.WALL) {
//                    return Action.RIGHT;
//                } else {
//                    return  Action.LEFT;
//                }
//
//            } else {
//                return Action.HOP;
//            }
//
//        } else {
//
//            // If the Gator is not moving.
//            if(spinsRight) {
//
//                if (info.getFront() == Neighbor.OTHER) {
//                    return Action.INFECT;
//                } else {
//                    return Action.RIGHT;
//                }
//
//            } else {
//                if (info.getFront() == Neighbor.OTHER) {
//                    return Action.INFECT;
//                } else {
//                    return Action.LEFT;
//                }
//            }
//
//
//        }
        if(info.getFront() == Critter.Neighbor.OTHER) {
            return Critter.Action.INFECT;
        } else if(info.getFront() == Critter.Neighbor.WALL) {

            if(info.getRight() == Critter.Neighbor.SAME && info.getRightDirection() == info.getDirection()) {
                return Critter.Action.LEFT;
            } else if(info.getLeft() == Critter.Neighbor.SAME && info.getLeftDirection() == info.getDirection()) {
                return Critter.Action.RIGHT;
            } else {
                return Critter.Action.RIGHT;
            }

        } else if(info.getFront() == Critter.Neighbor.SAME) {

            if(info.getLeft() == Critter.Neighbor.EMPTY) {
                return Critter.Action.RIGHT;
            } else if(info.getLeft() == Critter.Neighbor.SAME || info.getLeft() == Critter.Neighbor.WALL) {
                return Critter.Action.RIGHT;
            } else {
                return  Critter.Action.LEFT;
            }

        } else {
            return Critter.Action.HOP;
        }
    }
}
