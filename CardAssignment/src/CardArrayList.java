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
    private int size;
    // ************************** Constructors ************************

    /**
     *  This is the default constructor that will set the
     *  cardArray size to 10.
     */
    public CardArrayList() {
        cardArray = new Card[10];
        size = 0;
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
            throw new IllegalArgumentException("The array of Cards must be at least one.");
        } else {
            cardArray = new Card[x];
            size = 0;
        }

    }

    // **************************** Methods ***************************
    @Override
    public String toString() {

        // Properties
        String cardList = "";

        if(size == 0) {
            return "[0: " + size + "]";
        } else {

            for(int i = 0; i < size + 1; i++) {
                if(cardArray[i] != null) {
                    cardList = cardList + "," + cardArray[i].toString();
                }
            }

        }

        return  "[0: " + cardList.substring(1) + " :" + size + "]";
    }

    /**
     * This method will return the total number of elements in
     * the array, not the size of the array its self.
     *
     * @return this is the total number of elements in the array, not the size of the array.
     */
    public int size() {
        return size;
    }

    /**
     * This method will add a given card to the array.
     *
     * @param x this is the card to passed in to add to the array.
     */
    public void add(Card x) {

        if(cardArray[size] == null) {
            cardArray[size + 1] = x;
            size++;
        } else {

            // Expand the array and then add.
            expand();
            cardArray[size + 1] = x;
            size++;
        }

    }

    /**
     * This method will add a given card at a specific index.
     *
     * @param l this is the given index to place the card.
     * @param x is the card to be added into the array.
     */
    public void add(int l, Card x) {

        if(isRoom() == false) {
            expand();
        } else {
            for(int i = 0; i < cardArray.length; i++) {
                if(i == l) {
                    for(int j = i; j < cardArray.length; j++) {
                        cardArray[j + 1] = cardArray[i];
                    }

                    cardArray[i] = x;
                    size++;
                }
            }
        }
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
        removed = cardArray[size];

        // Decrement size
        size--;

        return removed;
    }

    /**
     *
     * @param location
     * @return
     */
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
        if(x > size) {
            throw new IllegalArgumentException("The index is our of bounds");
        } else {
            return cardArray[x - 1];
        }
    }

    /**
     *
     * @param x
     * @return
     */
    public int indexOf(Card x) {

        for(int i = 0; i < size; i++) {

            if((cardArray[i].getCost() == x.getCost()) && (cardArray[i].getPower() == x.getPower()) && (cardArray[i].getToughness() == x.getToughness())) {
                return i; // TODO add a method to compare
            }
        }
        return -1;
    }

    /**
     * This method will sort the array from smallest to biggest.
     */
    public void sort() {

        // TODO Needs recursion

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
       cardArray = new Card[10];
       size = 0;
    }

    // **************************** Private Methods ***************************

    // This method will return true if the array currently has any empty spaces.
    private Boolean isRoom() {
        if(size == cardArray.length) {
            return true;
        } else {
            return false;
        }
    }

    // This will double the size of the array.
    private void expand() {
        cardArray = Arrays.copyOf(cardArray, cardArray.length * 2);
    }

    // This method will swap two card with the specific indexes.
    private void swap(int a, int b) {
        Card tempCard = null;
        tempCard = cardArray[a];
        cardArray[a] = cardArray[b];
        cardArray[b] = tempCard;
    }

}
