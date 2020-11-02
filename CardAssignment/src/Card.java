/**
 * This class
 *
 * @author Lucas D. Dahl
 * @version 11/1/20
 */
public class Card {

    // **************************** Fields ****************************
    private int power;
    private int toughness;
    private int cost;
    // ************************** Constructors ************************

    /**
     *  This is the default constructor.
     */
    public Card() {

    }

    /**
     *
     * @param x
     */
    public Card(int x) {

    }

    /**
     *
     * @param p
     * @param t
     */
    public Card(int p, int t) {

    }

    // **************************** Methods ***************************

    /**
     *
     * @return
     */
    public int getPower() {
        return power;
    }

    /**
     *
     * @return
     */
    public int getToughness() {
        return toughness;
    }

    /**
     *
     * @return
     */
    public int getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "";
    }

    /**
     *
     */
    public void weaken() {

    }

    /**
     *
     */
    public void boost() {

    }
}
