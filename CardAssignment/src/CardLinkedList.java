import java.util.*;
/**
 * This class will make a custom Linked List
 * that implements CardList and stores card
 * objects.
 *
 * @author Lucas D. Dahl
 * @version 11/12/20
 */
public class CardLinkedList implements CardList {

    // **************************** Fields ****************************
    private CardNode headCard;
    private int size;

    // ************************** Inner Class **************************
    private class CardNode {

        // Properties
        /**
         * This is the card data fir the node.
         */
        public Card card;

        /**
         * This is the node that comes after the current node.
         */
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
     * This is the constructor that will
     * set the size to 0, and the headCard
     * to null.
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
     * @param card the Card object to be added.
     */
    public void add(Card card) {

        if(headCard == null) {
            headCard = new CardNode(card);
        } else {

            // Make a traversal card and set it to the head
            CardNode traversalCard  = headCard;

            // Find the last spot
            while(traversalCard.next != null) {
                traversalCard = traversalCard.next;
            }

            // Once an empty spot is set, add the passed in card.
            traversalCard.next = new CardNode(card);

        }

        size++;
    }

    /**
     * This method will a card at the given
     * location.
     *
     * @param location the desired index of the card to be added.
     * @param card the Card object to be added.
     * @IllegalArgumentExceptio will throw if the index is either below 0, or larger than the size.
     */
    public void add(int location, Card card) {

        // Properties
        CardNode currentCard = headCard;
        CardNode cardToAdd = new CardNode(card);

        // Make sure the location is not out of bounds.
        if(location < 0 || location > size) throw new IllegalArgumentException("Index out of bounds");

        if(location == size) {
            // The card is at the end
            add(card);
        } else if(location == 0) {

            // Card goes at the front.
            cardToAdd.card = card;
            cardToAdd.next = headCard;
            headCard = cardToAdd;
            size++;

        } else {

            // Card is not at the front.
            for(int i = 1; i < location; i++) currentCard = currentCard.next;

            // Once we are at the given position insert the car, and move everything over.
            cardToAdd.card = card;
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
     * @param location the index of the card to be removed.
     * @return is the card that is being removed.
     * @IllegalArgumentExceptio will throw if the index is either below 0, or larger than the size.
     */
    public Card remove(int location) {

        // Properties
        CardNode traversalCard = headCard, endingCard = headCard;

        // Make sure the location is not out of bounds.
        if(location < 0 || location > size) throw new IllegalArgumentException("Index cannot be negatives");

        if(location == 0) {
            traversalCard = headCard;
            headCard = headCard.next;
        } else {
            for(int i = 0; i < location; i++) {
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

        // Make sure the index is not out of bounds.
        if(index < 0 || index > size) throw new IllegalArgumentException("Index out of bounds.");

        // Get the card at the index
        for(int i = 0; i < index; i++) currentCard = currentCard.next;

        return currentCard.card;

    }

    /**
     * This method will return the index of
     * the card that is passed in.
     *
     * @param card Card object
     * @return This is the index of the card in the list.
     */
    public int indexOf(Card card) {

        // Properties
        CardNode currentCard = headCard;

        // Check if their is a card of the parameter inside the list.
        for(int i = 0; i < size; i++) {
            if(currentCard.card.compareTo(card) == 2) {
                return i;
            }

            currentCard = currentCard.next;

        }

        return -1;
    }

    /**
     * This method will sort the elements
     * in the LinkedList from smallest to greatest.
     */
    public void sort() {
       sort(this);
    }

    /**
     * This method will randomly shuffle
     * the list a random amount of times
     * the size of the list.
     */
    public void shuffle() {

        // Properties
        Random rand = new Random();

        // Randomly shuffle the list.
        for(int i = 0; i < (size * rand.nextInt(5) + 1); i++) {
            swap(rand.nextInt(size), rand.nextInt(size));
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

    // **************************** Private Methods ***************************

    // This method will swap two elements.
    private void swap(int a, int b) {

        // Properties
        CardNode cardA = headCard, cardB = headCard;

        // Return if the parameters are the same.
        if(a == b) {
            return;
        }

        // Get the card for index a
        for(int i = 0; i < a; i++) {
            cardA = cardA.next;
        }

        // Get the card for index b
        for(int i = 0; i < b; i++) {
            cardB = cardB.next;
        }

        // Swap the cards(node data)
        Card c = cardA.card;
        cardA.card = cardB.card;
        cardB.card = c;

    }

    // This method will sort a list and merge it.
    private void sort(CardLinkedList list) {

        // Properties
        CardLinkedList leftList = new CardLinkedList();
        CardLinkedList rightList = new CardLinkedList();

        // If the list as less than 2 elements simply return
        if(list.size() < 2) {
            return;
        }

        // Remove from the initial list and add the first half to
        // the left and the second half to the right.
        while(list.size() > 0) {

            if(leftList.size() < (list.size() / 2)) {
                leftList.add(list.remove(0));
            } else {
                rightList.add(list.remove(0));
            }
        }

        // sort each list
        sort(leftList);
        sort(rightList);

        // Merge the lists together.
        merge(leftList, rightList, list);

    }

    // This merges all the the elements of to CardLinkedLists into another.
    private void merge(CardLinkedList leftList, CardLinkedList rightList, CardLinkedList list) {

        // Combine the two lists into one.
        while(leftList.size() + rightList.size() > 0) {

            // Check if the left or right side is empty or not
            if(leftList.size() == 0) {

                // The left size is empty, so add from the right and remove(to eventually destroy the list).
                list.add(rightList.remove(0));

            } else if(rightList.size() == 0) {

                // The right size is empty, so add from the left and remove(to eventually destroy the list).
                list.add(leftList.remove(0));

            } else if(leftList.get(0).compareTo(rightList.get(0)) == 2 || leftList.get(0).compareTo(rightList.get(0)) == -1) {

                // The list is not empty so we need to compare the current card from both sides.
                // The left card is smaller so we add it to the list.
                list.add(leftList.remove(0));

            } else {

                // The right card is smaller so we add it to the list.
                list.add(rightList.remove(0));
            }
        }
    }
}
