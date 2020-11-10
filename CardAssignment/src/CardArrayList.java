import java.util.Arrays;
import java.util.Random;

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
            return "[0: " + ":"+ size + "]";
        } else {

            for(int i = 0; i < size; i++) {
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
     * @param card this is the card to passed in to add to the array.
     */
    public void add(Card card) {

        // Check if there is room.
        if(!isRoom()) {
            expand();
        }

        // Find the first null value to place the card at.
        for(int i = 0; i < cardArray.length; i++) {
            if(cardArray[i] == null) {
                cardArray[i] = card;
                size++;
                return;
            }
        }
    }


    /**
     * This method will add a given card at a specific index.
     *
     * @param location this is the given index to place the card.
     * @param card is the card to be added into the array.
     * @IndexOutOfBoundsException will throw an error if the location is out of range.
     */
    public void add(int location, Card card) {

       if(location > (cardArray.length + 1)) {
           throw new IllegalArgumentException("The position is out of bounds");
        }

        // Make the array bigger by one to add the element.
        Card[] newArray = new Card[cardArray.length + 1];

        for(int i = 0; i < cardArray.length; i++) {

            if(i == location) {
                newArray[i] = card;
            } else if(i > location) {
                newArray[i] = cardArray[i - 1];
            } else {
                newArray[i] = cardArray[i];
            }
        }

        size++;

        cardArray = newArray;
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

        // Decrement size
        size--;

        // Get the card to remove.
        removed = cardArray[size];

        return removed;
    }

    /**
     * This method will remove a card at the given index
     * and slide all other elements over.
     *
     * @param location
     * @return this is the card at a given location
     * @IndexOutOfBoundsException will throw an error if the location is out of range.
     */
    public Card remove(int location) {

        if(location - 1 > cardArray.length) {
            throw new IndexOutOfBoundsException("There is no card at that location.");
        } else {

            Card[] tempArray = new Card[cardArray.length];
            Card tempCard = null;
            
            for(int i = 0; i < cardArray.length; i++) {

                if(i == location) {
                    tempCard = cardArray[i];
                } else if(i < location) {
                    tempArray[i] = cardArray[i];
                } else {
                    tempArray[i - 1] = cardArray[i];
                }
            }

            size--;
            cardArray = tempArray;
            return tempCard;

        }
    }

    /**
     * This method will take in an int and return the card
     * at at the given index from the array.
     *
     * @param x the given index to retrieve a card from the array.
     * @return the car to return at a given index.
     * @IndexOutOfBoundsException will throw an error if the location is out of range.
     */
    public Card get(int x) {

        if(x > cardArray.length) {
            throw new IllegalArgumentException("The index is out of bounds");
        } else {
            return cardArray[x];
        }
    }

    /**
     *This method will accept a Card and return the index of that card.
     *
     * @param card is the card passed into the array to retrieve the index for.
     * @return this is in the index of the card that was passed in.
     */
    public int indexOf(Card card) {

        for(int i = 0; i < size; i++) {

            if(cardArray[i].compareTo(card) == 2) {
                return i; // TODO add compareTo?
            }
        }
        return -1;
    }

    /**
     * This method will sort the array from smallest to biggest.
     */
    public void sort() {
        mergeSort(cardArray);
    }

    /**
     * This method will randomly shuffle the elements in the array.
     */
    public void shuffle() {

        // Properties
        Random rand = new Random();
        int totalShuffle = size * rand.nextInt(10 - 5) +5 ;

        for(int i = 0; i < totalShuffle; i++) {
            swap(rand.nextInt(size - 1) + 1, rand.nextInt(size - 1) + 1);
        }

    }

    /**
     * this method clears the array, and sets the size back to zero.
     */
    public void clear() {
       cardArray = new Card[10];
       size = 0;
    }

    // **************************** Private Methods ***************************

    private static Card[] mergeSort(Card[] cards) {

        //TODO clean up
        int tempNum = 0;
        Card[] tempArray;

        // Return the array if its empty(hit the bottom)
        if(cards.length < 2) {
            return cards;
        }

        if(cards[cards.length -1] == null) {
            for (int i = 0; i < cards.length; i++) {
                if (cards[i] != null) {
                    tempNum++;
                }
            }

            //tempNum++;
            tempArray = new Card[tempNum];
            for(int i = 0; i < cards.length; i++) {
                if (cards[i] != null) {
                    tempArray[i] = cards[i];
                }
            }
        } else {
            tempArray = cards;
        }

        // Split the array
        Card[] cardsLH = new Card[tempArray.length / 2];
        Card[] cardsRH = new Card[tempArray.length - cardsLH.length];

        // Set both arrays
        for(int i = 0; i < tempArray.length; i++) {

            if(i < cardsLH.length) {
                cardsLH[i] = tempArray[i];
            }

            if(i < cardsRH.length) {
                cardsRH[i] = tempArray[cardsLH.length + i];
            }

        }


        // Call mergeSort on both arrays.
        mergeSort(cardsLH);
        mergeSort(cardsRH);

        // Merge the arrays
        mergeArray(cardsLH, cardsRH, cards);

        return cards;
    }

    private static void mergeArray(Card[] left, Card[] right, Card[] cardArray) {

        // Properties
        int leftIndex = 0, rightIndex = 0, mergeIndex = 0;

        while(leftIndex < left.length && rightIndex < right.length) {

            if(left[leftIndex].compareTo(right[rightIndex]) == -1 || left[leftIndex].compareTo(right[rightIndex]) == 2) {
                cardArray[mergeIndex] = left[leftIndex];
                leftIndex++;
            } else {
                cardArray[mergeIndex] = right[rightIndex];
                rightIndex++;
            }
            mergeIndex++;
        }

        while(leftIndex < left.length) {
            cardArray[mergeIndex] = left[leftIndex];
            leftIndex++;
            mergeIndex++;
        }
        while(rightIndex < right.length) {
            cardArray[mergeIndex] = right[rightIndex];
            rightIndex++;
            mergeIndex++;
        }


    }

    // This method will return true if the array currently has any empty spaces.
    private Boolean isRoom() {
        if(size == cardArray.length) {
            return false;
        } else {
            return true;
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
