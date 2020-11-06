import java.util.*;
/**
 * This class will make a card object to store certain values.
 *
 * @author Lucas D. Dahl
 * @version 11/1/20
 */
public class Card implements Comparable<Card> {

    // **************************** Fields ****************************
    private int power;
    private int toughness;
    private int cost;
    // ************************** Constructors ************************

    /**
     *  This is the default constructor that randomly sets
     *  the power and toughness.
     */
    public Card() {

        Random rand = new Random();
        power = rand.nextInt(100) + 1;
        toughness = rand.nextInt(100) + 1;

    }

    /**
     * This constructor will take in an int
     * and set the power and toughness to
     * that int.
     *
     * @param x This is the passed in int to set the power and toughness.
     * @IllegalArgumentException will throw and exception if the parameter is not between 1 and 100.
     */
    public Card(int x) {
        if(x >= 1 && x <= 100) {
            power = x;
            toughness = x;
        } else {
            throw new IllegalArgumentException("Card power and toughness must be between 1 and 100");
        }
    }

    /**
     * This constructor will take in an int for both
     * power and toughness.
     *
     * @param p is the passed in int for power.
     * @param t is the passed in int for toughness.
     * @IllegalArgumentException will throw and exception if the parameters are not between 1 and 100.
     */
    public Card(int p, int t) {

        if((p >= 1 && p <= 100) && (t >= 1 && t <= 100)) {
            power = p;
            toughness = t;
        } else {
            throw new IllegalArgumentException("Card power and toughness must be between 1 and 100");
        }

    }

    // **************************** Methods ***************************

    /**
     * 
     * @param o
     * @return
     */
    public int compareTo(Card o) {
        return 0;
    }

    /**
     * This method simply returns the cards
     * power.
     *
     * @return will return the power for the card.
     */
    public int getPower() {

        return power;
    }

    /**
     * This method simply returns the cards
     * toughness.
     *
     * @return will return the toughness for the card.
     */
    public int getToughness() {
        return toughness;
    }

    /**
     * This method will return the cost of the card,
     * using the power and toughness to calculate.
     *
     * @return will return the cost of the card.
     */
    public int getCost() {
        return (int) Math.ceil(Math.pow((2 * power + toughness), 0.5) * 10);
    }

    @Override
    public String toString() {
        return "[" + power + "/" + toughness + ":" + getCost() + "]";
    }

    /**
     * This method will reduce both power
     * and toughness by 2 for the car,
     * while keeping them above 0
     */
    public void weaken() {

        // Reduce both power and toughness by 2.
        power = power - 2;
        toughness = toughness - 2;

        // Makes sure both power and toughness are above 0.
        if(power <= 0) {
            power = 1;
        }

        if(toughness <= 0) {
            toughness = 1;
        }
    }

    /**
     * This method will add 2 to both the
     * power and toughness of the card,
     * while keeping them both below 101.
     */
    public void boost() {

        // Add 2 to both power and toughness.
        power = power + 2;
        toughness = toughness + 2;

        // Makes sure both power and toughness are above 0.
        if(power >= 101) {
            power = 100;
        }

        if(toughness >= 101) {
            toughness = 100;
        }
    }
}
