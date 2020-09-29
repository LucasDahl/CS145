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

    // **************************** Fields ****************************

    // ************************** Constructors ************************

    // **************************** Methods ***************************

    @Override
    public Color getColor() {
        if(toString().equals("fee") || toString().equals("foe")) {
            return Color.BLACK;
        } else {
            return Color.WHITE;
        }
    }

    @Override
    public Action getMove(CritterInfo info) {

        if(info.getFront() != Neighbor.OTHER && info.getFront() != Neighbor.EMPTY) {
            return Action.LEFT;
        } else {
            return super.getMove(info);
        }
    }
}
