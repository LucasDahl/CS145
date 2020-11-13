import java.util.*;
/**
 * This class
 *
 * @author Lucas D. Dahl
 * @version 11/12/20
 */
public class CardLinkedList implements CardList {

    // **************************** Fields ****************************
    private List<Card> cards;
    private int size;
    // ************************** Constructors ************************

    public CardLinkedList() {

    }

    // **************************** Methods ***************************

    @Override
    public String toString() {
        return "";
    }

    /**
     *
     * @return
     */
    public int size() {
        return 0;
    }

    /**
     *
     * @param c the Card object to be added.
     */
    public void add(Card c) {

    }

    /**
     *
     * @param loc the desired index of the card to be added.
     * @param c the Card object to be added.
     */
    public void add(int loc, Card c) {

    }

    /**
     *
     * @return
     */
    public Card remove() {
        return null;
    }

    /**
     *
     * @param loc the index of the card to be removed.
     * @return
     */
    public Card remove(int loc) {
        return null;
    }

    /**
     *
     * @param i The index of the desired card.
     * @return
     */
    public Card get(int i) {
        return null;
    }

    /**
     *
     * @param c Card object
     * @return
     */
    public int indexOf(Card c) {
        return 0;
    }

    /**
     *
     */
    public void sort() {

    }

    /**
     *
     */
    public void shuffle() {

    }

    /**
     *
     */
    public void clear() {

    }
}
