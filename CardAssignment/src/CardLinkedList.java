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
    private CardNode headCard;
    private int size;

    // ************************** Inner Class **************************
    private class CardNode {

        // Properties
        public Card card;
        public CardNode next;

        /**
         * This is the constructor for the node.
         *
         * @param card this is the card to add to the node.
         */
        public CardNode(Card card) {
            this.card = card;
            next = null;
        }

    }

    // ************************** Constructors ************************

    /**
     *
     */
    public CardLinkedList() {

        headCard = null;
        size = 0;

    }

    // **************************** Methods ***************************

    @Override
    public String toString() {

        // Properties
        String cardsString = "";
        CardNode currentCard;

        if(headCard == null) {
            cardsString = "[0: " + ":" + size + "]";
            return cardsString;
        }

        // Set the current node.
        currentCard = headCard;

        while(currentCard != null) {

            // Update the string
            cardsString = cardsString + "," + currentCard.card.toString();

            // Update the current card.
            currentCard = currentCard.next;

        }

        return "[0: " + cardsString.substring(1) + " :" + size +"]";
    }

    /**
     * This method will return the total size of the
     * list that has elements.
     *
     * @return This will return the size of the list with elements.
     */
    public int size() {
        return size;
    }

    /**
     * This method will add a card at the back of
     * the list.
     *
     * @param c the Card object to be added.
     */
    public void add(Card c) {

        if(headCard == null) {
            headCard = new CardNode(c);
            size++;
        } else {

            // Make a traversal card and set it to the head
            CardNode traversalCard  = headCard;

            // Find the last spot
            while(traversalCard.next != null) {
                traversalCard = traversalCard.next;
            }

            // Once an empty spot is set, add the passed in card.
            traversalCard.next = new CardNode(c);
            size++;

        }

    }

    /**
     * This method will a card at the given
     * location.
     *
     * @param loc the desired index of the card to be added.
     * @param c the Card object to be added.
     * @IllegalArgumentExceptio will throw if the index is either below 0, or larger than the size.
     */
    public void add(int loc, Card c) {

        // Properties
        CardNode currentCard = headCard;
        CardNode cardToAdd = new CardNode(c);

        if(loc < 0) throw new IllegalArgumentException("Index cannot be negatives");
        if(loc > size) throw new IllegalArgumentException("Index cannot be greater than the size.");
        if(loc == size) {
            add(c);
        } else if(loc == 0) {
            cardToAdd.card = c;
            cardToAdd.next = headCard;
            headCard = cardToAdd;
            size++;

        } else {

            for(int i = 1; i < loc; i++) currentCard = currentCard.next;

            // Once we are at the given position insert the car, and move everything over.
            cardToAdd.card = c;
            cardToAdd.next = currentCard.next;
            currentCard.next = cardToAdd;

            size++;

        }

    }

    /**
     * This method will remove the last in the
     * list and return it after its removed.
     *
     * @return will return the last card in the list after taking it out of the list.
     */
    public Card remove() {

        // If the list is empty, simply return.
        if(headCard == null) {
            return null;
        }

        // Make a traversal card and set it to the head
        CardNode traversalCard = headCard, endingCard = headCard;

        // Find the last spot
        while(traversalCard.next != null) {
            endingCard = traversalCard;
            traversalCard = traversalCard.next;
        }

        // Decrement the size and make the ending node next be null.
        size--;
        endingCard.next = null;

        return traversalCard.card;
    }

    /**
     * This card will remove a card at a specific index.
     *
     * @param loc the index of the card to be removed.
     * @return is the card that is being removed.
     * @IllegalArgumentExceptio will throw if the index is either below 0, or larger than the size.
     */
    public Card remove(int loc) {

        // Properties
        CardNode traversalCard = headCard, endingCard = headCard;

        if(loc < 0) throw new IllegalArgumentException("Index cannot be negatives");
        if(loc > size) throw new IllegalArgumentException("Index cannot be greater than the size.");
        if(loc == 0) {
            traversalCard = headCard;
            headCard = headCard.next;
        } else {
            for(int i = 0; i < loc; i++) {
                endingCard = traversalCard;
                traversalCard = traversalCard.next;
            }

            endingCard.next = traversalCard.next;
            traversalCard.next = null;

        }

        size--;

        return traversalCard.card;
    }

    /**
     * This method will return a card at a
     * specific index.
     *
     * @param index The index of the desired card.
     * @return This is the card at the specific index.
     * @IllegalArgumentExceptio will throw if the index is either below 0, or larger than the size.
     */
    public Card get(int index) {

        // Properties
        CardNode currentCard = headCard;

        if(index < 0) throw new IllegalArgumentException("Index cannot be negatives");
        if(index > size) throw new IllegalArgumentException("Index cannot be greater than the size.");

        for(int i = 0; i < index; i++) currentCard = currentCard.next;

        return currentCard.card;

    }

    /**
     * This method will return the index of
     * the card that is passed in.
     *
     * @param c Card object
     * @return This is the index of the card in the list.
     */
    public int indexOf(Card c) {

        // Properties
        CardNode currentCard = headCard;

        for(int i = 0; i < size; i++) {
            if(currentCard.card.compareTo(c) == 2) {
                return i;
            }
            currentCard = currentCard.next;

        }

        return -1;
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
        // Properties
        Random rand = new Random();

        for(int i = 0; i < size; i++) {
            swap(rand.nextInt(size-1), rand.nextInt(size-1));
        }
    }

    /**
     * This method simply clears the list by
     * setting the head to null and size to zero.
     * The garbage collector will clean up after
     * the head is set to null.
     */
    public void clear() {
        headCard = null;
        size = 0;
    }

    // This method will swap two elements.
    private void swap(int a, int b) {

        // Properties
        Card tempCardOne = new Card(), tempCardTwo = new Card();
        CardNode traversalCard = headCard;
        int loop = 0;

        while(traversalCard.next != null) {

            if(a == loop ) {
                tempCardOne = traversalCard.card;
            }

            if(b == loop) {
                tempCardTwo = traversalCard.card;
                traversalCard.card = tempCardOne;
            }

            traversalCard = traversalCard.next;
            loop++;

        }

        traversalCard = headCard;
        for(int i = 0; i < a; i++) traversalCard = traversalCard.next;

        traversalCard.card = tempCardTwo;

    }

}
