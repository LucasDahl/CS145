import java.util.Arrays;

/**
 * This class will create an array of Card and PremiumCard
 * objects. This class will also allow for various methods
 * to be applied on the array its self.
 *
 * @author Lucas D. Dahl
 * @version 11/1/20
 */
public class CardArrayList implements CardList {

    // **************************** Fields ****************************
    private Card[] cardArray;
    private int size = 0;
    // ************************** Constructors ************************

    /**
     *  This is the default constructor that will set the
     *  cardArray size to 10.
     */
    public CardArrayList() {
        cardArray = new Card[10];
    }

    /**
     * This method allows an integer to be passed in
     * to set the size of the array.
     *
     * @param x this integer will set the size of the cardArray.
     * @IllegalArgumentException will throw an exception if the value is less than one.
     */
    public CardArrayList(int x) {

        if(x < 1) {
            throw new IllegalArgumentException("The array of Cards must be greater than one.");
        } else {
            cardArray = new Card[x];
        }

    }

    // **************************** Methods ***************************
    @Override
    public String toString() {

        // Properties
        String cardList = "[0: ";

        for(int i = 0; i < cardArray.length; i++) {
            cardList += cardArray[i].toString() + ",";
        }

        cardList += ":" + cardArray.length + "]";

        return cardList;
    }

    /**
     * This method will return the total number of elements in
     * the array, not the size of the array its self.
     *
     * @return this is the total number of elements in the array, not the size of the array.
     */
    public int size() {

        // Get the total number of elements in the array
        for(int i = 0; i < cardArray.length; i++) {

            if(cardArray[i] != null) {
                size++;
            }
        }

        return size;
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
     * This method will remove a card from
     * the card array.
     *
     * @return this will return the card that's removed.
     */
    public Card remove() {

        // Properties
        Card removed;

        // Get the card to remove.
        removed = cardArray[cardArray.length - 1];

        // Decrement size
        size--;

        return removed;
    }

    @Override //!!!!!!!!!!!!!!!!!!!!!!!!!
    public Card remove(int location) {

        if(location - 1 > cardArray.length) {
            throw new IndexOutOfBoundsException("There is no card at that location.");
        } else {
            return cardArray[location - 1];
        }
    }

    /**
     * This method will take in an int and return the card
     * at at the given index from the array.
     *
     * @param x the given index to retrieve a card from the array.
     * @return the car to return at a given index.
     */
    public Card get(int x) {
        return cardArray[x - 1];
    }

    /**
     *
     * @param x
     * @return
     */
    public int indexOf(Card x) {

        for(int i = 0; i < size; i++) {

            if((cardArray[i].getCost() == x.getCost()) && (cardArray[i].getPower() == x.getPower()) && (cardArray[i].getToughness() == x.getToughness())) {
                return i;
            }
        }
        return -1;
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
