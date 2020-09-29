import java.awt.*;
/**
 *  This class makes a Giant critter that will extend from
 *  the Critter super class.
 *
 * @author Lucas D. Dahl
 * @version 9/25/20
 *
 */
public class Giant extends Critter {

    // **************************** Fields ****************************
    private Color giantColor;
    private String[] giantMessage = {"fee", "fie", "foe", "fum"};
    private int moves = 0, message = 0;

    // ************************** Constructors ************************

    public Giant() {
        giantColor = Color.GRAY;
    }

    // **************************** Methods ***************************

    @Override
    public String toString() {
        
        if(moves == 6) {
            moves = 0;

            if(message == 3) {
                message = 0;
            } else {
                message ++;
            }
        }

        return giantMessage[message];

    }

    @Override
    public Color getColor() {
        return giantColor;
    }

    @Override
    public Action getMove(CritterInfo info) {

        moves++;

        if(info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;
        } else if(info.getFront() == Neighbor.EMPTY) {
            return Action.HOP;
        } else {
            return Action.RIGHT;
        }

    }
}
