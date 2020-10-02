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

    /**
     * This constructor sets the color of Giant.
     */
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

    /**
     * This will return the color of the Giant
     * which is set with teh constructor.
     * @return returns the color of the Giant.
     */
    public Color getColor() {
        return giantColor;
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

        if(info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;
        } else if(info.getFront() == Neighbor.EMPTY) {
            return Action.HOP;
        } else {
            return Action.RIGHT;
        }

    }
}
