/**
 * This class
 *
 * @author Lucas D. Dahl
 * @version 11/1/20
 */
public class CardArrayList implements CardList {
    // **************************** Fields ****************************
    // ************************** Constructors ************************

    /**
     *  This is the default constructor.
     */
    public CardArrayList() {

    }

    /**
     *
     * @param x
     */
    public CardArrayList(int x) {

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
     * @param x
     */
    public void add(Card x) {

    }

    /**
     *
     * @param l
     * @param x
     */
    public void add(int l, Card x) {

    }

    /**
     *
     * @return
     */
    public Card remove() {
        Card t = new Card();
        return t;
    }

    @Override //!!!!!!!!!!!!!!!!!!!!!!!!!
    public Card remove(int loc) {
        return null;
    }

    /**
     *
     * @param x
     * @return
     */
    public Card get(int x) {
        Card t = new Card();
        return t;
    }

    /**
     *
     * @param x
     * @return
     */
    public int indexOf(Card x) {
        return 0;
    }

    @Override
    public void sort() {

    }

    @Override
    public void shuffle() {

    }

    /**
     *
     */
    public void expand() {

    }

    /**
     *
     * @param a
     * @param b
     */
    public void swap(int a, int b) {

    }

    /**
     *
     */
    public void clear() {

    }

    private Boolean isRoom() {
        return false;
    }

}
