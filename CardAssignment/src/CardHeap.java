/**
 * This class makes a heap of Card
 * objects.
 *
 * @author Lucas D. Dahl
 * @version 12/3/2020
 */
public class CardHeap {

    // **************************** Fields ****************************

    private Card[] cards;
    private int size;

    // ************************** Constructors ************************

    /**
     * This is the default constructor that
     * sets the size to zero, and makes the
     * array size 10.
     */
    public CardHeap() {
        cards = new Card[10];
        size = 0;
    }

    // **************************** Methods ***************************

    /**
     * This method simply adds a card.
     *
     * @param card this is the card to add.
     */
    public void add(Card card) {

        //  Properties
        boolean flag = false;
        int index = size + 1;

        // Rehash(expand) if the array is full.
        if(size == cards.length - 1) {
            expand();
        }

        // Add the card(hash value) and increase the size.
        cards[size + 1] = card;

        // Bubble up to fix ordering
        while(!flag && hasParent(index)) {
            int parent = parent(index);
            if(cards[index].compareTo(cards[parent]) == -1) {
                swap(cards, index, parent(index));
                index = parent(index);
            } else {
                flag = true;
            }
        }

        // Increase the size
        size++;
    }

    /**
     * This method returns and removes the smallest
     * card.
     *
     * @return will return the smallest card in the array and remove it.
     */
    public Card remove() {

        // Properties
        Card result = cards[1];
        cards[1] = cards[size];
        boolean factor = false;

        // Decrease the size and set teh index
        size--;
        int index = 1;


        // Bubble down to fix ordering.
        while(!factor && hasLeftChild(index)) {
            int left = leftChild(index);
            int right = rightChild(index);
            int child = left;
            if(hasRightChild(index) && cards[right].compareTo(cards[left]) == -1) {
                child = leftChild(index);
            }
            if(cards[index].compareTo(cards[index]) == 1) {
                swap(cards, index, child);
                index = child;
            } else {
                factor = true;
            }
        }
        return result;
    }

    /**
     * This simply clears the array.
     */
    public void clear() {
        cards = new Card[10];
        size = 0;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {

        // Properties
        String cardString = "";

        if(size > 0) {
            for(int i = 1; i <= size; i++) {

                if(cards[i] != null) {
                    cardString = cardString  + "," + cards[i].toString();
                }
            }

            cardString = "[" + cardString.substring(1) + "]";
        } else {
            cardString = "[]";
        }
        return cardString;
    }

    private void expand() {
        // Properties
        Card[] tempCards = cards;

        // Double the size of teh array and set the size to zero.
        cards = new Card[2 * tempCards.length];
        size = 0;

        // add the elements back.
        for(Card card: tempCards) {
            cards[size + 1] = card;
            size++;
        }
    }

    // **************************** Helper Methods ***************************

    private int parent(int index) { return index / 2; }
    private int leftChild(int index) { return index * 2; }
    private int rightChild(int index) { return index * 2 + 1; }
    private boolean hasParent(int index) { return index > 1; }

    private boolean hasLeftChild(int index) {
        return leftChild(index) <= size;
    }
    private boolean hasRightChild(int index) {
        return rightChild(index) <= size;
    }

    // This method will swap two card with the specific indexes.
    private void swap(Card[] cardArray, int cardOne, int cardTwo) {
        Card tempCard = cardArray[cardOne];
        cardArray[cardOne] = cardArray[cardTwo];
        cardArray[cardTwo] = tempCard;
    }
}
