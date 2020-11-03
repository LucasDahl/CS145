/**
 * This class
 *
 * @author Lucas D. Dahl
 * @version 11/1/20
 */
public class PremiumCard extends Card {

    // ************************** Constructors ************************

    /**
     * This is the default constructor that calls
     * the default super constructor.
     */
    public PremiumCard() {
        super();
    }

    /**
     * This constructor will accept and int
     * to call the super constructor that uses the
     * passed in int to set both the power and toughness.
     *
     * @param x is the int to set both the power and toughness to.
     */
    public PremiumCard(int x) {
        super(x);
    }

    /**
     * This constructor will take in an int for toughness
     * and power to call the super constructor using those
     * parameters.
     *
     * @param p this will be the power parameter passed in.
     * @param t this will be the toughness parameter passed in.
     */
    public PremiumCard(int p, int t) {
        super(p, t);
    }

    // **************************** Methods ***************************
    @Override
    public String toString() {
        return "{{" + super.getPower() + "/" + super.getToughness() + ":" + getCost() + "}}";
    }
}
