/**
 * This
 *
 * @author Lucas D. Dahl
 * @version 12/3/2020
 */
public class CardHeap {

    //TODO: Use chapter 18

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

        // Rehash(expand) if the array is to full.
        if((double) size / cards.length >= 0.75) {
            expand();
        } else {

            // Add the card(hash value) and increase the size.
            cards[cards.length - 1] = card;
            size++;
        }
    }

    /**
     * This method returns and removes the last card.
     *
     * @return will return the last card in the array and remove it.
     */
    public Card remove() {
        Card card = new Card();
        return card;
    }

    /**
     * This simply clears the array.
     */
    public void Clear() {
        cards = new Card[10];
        size = 0;
    }

    @Override
    public String toString() {

        // Properties
        String cardString = "";

        for(int i = 0; i < cards.length; i++) {

            if(cards[i] != null) {
                cardString = cardString + cards[i].toString();
            }

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

        }
    }

}
