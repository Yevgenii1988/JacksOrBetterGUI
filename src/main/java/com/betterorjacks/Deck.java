package com.betterorjacks;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private static Deck deckInstance = null;

    private List<Card> cards = new ArrayList<>(52);
    private List<Card> hand = new ArrayList<>();

    /**
     * Forms the deck of cards
     */
    private Deck() {
        for (Rank rank : Rank.values()) {
            for (Suit suit : Suit.values()){
                Card card = new Card(rank, suit);
                cards.add(card);
            }
        }
    }

    /**
     * Static method to create the instance of the Deck class.
     * This instance is singleton
     *
     * @return  the instance of the Deck
     */
    public static Deck getDeck(){
        if (deckInstance == null){
            deckInstance = new Deck();
        }
        return deckInstance;
    }

    /**
     * Shuffles the deck of cards
     */
    public void shuffle(){
        Collections.shuffle(cards);
    }

    /**
     * Receives the first five cards from the shuffled deck
     */
    public void composeHand(){
        for (int i = 0; i < 5; i++) {
            hand.add(cards.get(i));
        }
    }

    /**
     * Receives the images of the cards in hand
     *
     * @return  the List of buffered images of the cards
     */
    public List<BufferedImage> getHand() {

        List<BufferedImage> handImages = new ArrayList<>();
        for (Card card : hand){
            handImages.add(card.getImage());
        }

        return handImages;
    }

    /**
     * Receives the array of card states, and updates cards which are not being held
     *
     * @param heldCards array of card states: 1 - card is held, 0 - card is not held
     */
    public void updateHand(int[] heldCards){
        int nextCard = 5;
        for (int card = 0; card < heldCards.length; card++){
            if (heldCards[card] == 0){
                hand.set(card, cards.get(nextCard));
                nextCard++;
            }
        }
    }

    /**
     * Empties the hand cards list
     */
    public void reset(){
        hand.clear();
    }

    /**
     * Passes the List of hand cards to the newly created instance of Evaluator class to evaluate the combination
     * After receiving the combination, evaluator instance is set to null for garbage collection
     *
     * @return  evaluated combination of cards
     */
    public Combination evaluateHand() {
        Evaluator evaluator = new Evaluator();
        Combination combination = evaluator.returnCombination(hand);
        evaluator = null;
        return combination;
    }
}
