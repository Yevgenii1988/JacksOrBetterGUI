package com.betterorjacks;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> cards = new ArrayList<>(52);
    private List<Card> hand = new ArrayList<>();

    public Deck() {
        for (Rank rank : Rank.values()) {
            for (Suit suit : Suit.values()){
                Card card = new Card(rank, suit);
                cards.add(card);
            }
        }
    }

    public void shuffle(){
        Collections.shuffle(cards);
    }

    public void composeHand(){
        for (int i = 0; i < 5; i++) {
            hand.add(cards.get(i));
        }
    }

    public List<BufferedImage> getHand() {

        List<BufferedImage> handImages = new ArrayList<>();
        for (Card card : hand){
            handImages.add(card.getImage());
        }

        return handImages;
    }

    public void updateHand(int[] heldCards){
        int nextCard = 5;
        for (int card = 0; card < heldCards.length; card++){
            if (heldCards[card] == 0){
                hand.set(card, cards.get(nextCard));
                nextCard++;
            }
        }
    }

    public Combination evaluateHand() {
        Evaluator evaluator = new Evaluator(hand);
        Combination combination = evaluator.returnCombination();
        return combination;
    }
}
