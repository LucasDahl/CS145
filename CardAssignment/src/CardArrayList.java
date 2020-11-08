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

        // Check if there is room.
        if(!isRoom()) {
            expand();
        }

        // Find the first null value to place the card at.
        for(int i = 0; i < cardArray.length; i++) {
            if(cardArray[i] == null) {
                cardArray[i] = x;
                size++;
                return;
            }
        }
    }


    /**
     * This method will add a given card at a specific index.
     *
     * @param l this is the given index to place the card.
     * @param x is the card to be added into the array.
     */
    public void add(int l, Card x) {

       if(l > (cardArray.length + 1)) {
           throw new IllegalArgumentException("The position is out of bounds");
        }

        // Make the array bigger by one to add the element.
        Card[] newArray = new Card[cardArray.length + 1];
        //System.arraycopy(cardArray, 0, newArray, 0, cardArray.length); // Check with teacher
        //cardArray = newArray;


        for(int i = 0; i < cardArray.length; i++) {

            if(i == l) {
                newArray[i] = x;
            } else if(i > l) {
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
            return cardArray[size - 1];
        }
    }

    /**
     *
     * @param x
     * @return
     */
    public int indexOf(Card x) {

        for(int i = 0; i < size; i++) {

            if(cardArray[i].compareTo(x) == 1) {
                return i; // TODO add compareTo
            }
        }
        return -1;
    }

    /**
     * This method will sort the array from smallest to biggest.
     */
    public void sort() {
        // TODO Needs recursion(maybe) Needs a helper method (Check pictures) probably compare to
        mergeSort(cardArray);
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

    private static Card[] mergeSort(Card[] cards) {

        //TODO maybe try a for loop to take out null values
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

        System.arraycopy(tempArray, 0, cardsLH, 0, cardsLH.length);
        System.arraycopy(tempArray, cardsLH.length, cardsRH, 0, cardsRH.length);

        mergeSort(cardsLH);
        mergeSort(cardsRH);

        // Merge the arrays
        merge(cardsLH, cardsRH, cards);

        return cards;
    }

    private static void merge(Card[] left, Card[] right, Card[] initCard) {

        // Properties
        int iFirst =0, iSecond = 0, iMerged = 0;

        while(iFirst < left.length && iSecond < right.length) {

            if(left[iFirst].compareTo(right[iSecond]) == 1) {
                initCard[iMerged] = left[iFirst];
                iFirst++;
            } else {
                initCard[iMerged] = right[iSecond];
                iSecond++;
            }
            iMerged++;
        }

        System.arraycopy(left, iFirst, initCard, iMerged, left.length - iFirst);
        System.arraycopy(right, iSecond, initCard, iMerged, right.length - iSecond);
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
