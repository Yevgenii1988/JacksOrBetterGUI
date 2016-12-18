package com.betterorjacks;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> cards = new ArrayList<>(52);
    private List<Card> hand = new ArrayList<>();
    private Combination combination;

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
        for (int i = 0; i < 5; i++) {
            hand.add(cards.get(i));
        }
    }

    public List<BufferedImage> getHand() throws IOException {

        List<BufferedImage> handImages = new ArrayList<>();
        for (Card card : hand){
            handImages.add(card.getImage());
        }

        return handImages;
    }

    public void updateHand(int[] heldCards){
        int nextCard = 5;
        for (int i = 0; i < heldCards.length; i++){
            if (heldCards[i] == 0){
                hand.set(i, cards.get(nextCard));
                nextCard++;
            }
        }
    }

    public Combination evaluateHand() {
        Evaluator evaluator = new Evaluator(hand);
        List<Rank> ranks = evaluator.getRanksArray();
        int uniqueRanks = evaluator.countRanks(ranks);
        if (uniqueRanks == 5) {
            boolean sameSuits = evaluator.checkSuites(hand);
            boolean isStraight = evaluator.checkStraight(ranks);
            if (sameSuits) {
                if (isStraight) {
                    boolean isRoyalFlush = evaluator.checkRoyalFlush(ranks);
                    if (isRoyalFlush) {
                        combination = Combination.ROYAL_FLUSH;
                    } else combination = Combination.STRAIGHT_FLUSH;
                } else combination = Combination.FLUSH;
            } else if (isStraight) {
                combination = Combination.STRAIGHT;
            } else combination = Combination.NO_COMBINATION;
        } else if (uniqueRanks == 4) {
            boolean isHighPair = evaluator.checkPairs(ranks);
            if (isHighPair) {
                combination = Combination.JACKS_OR_BETTER;
            } else combination = Combination.NO_COMBINATION;
        } else if (uniqueRanks == 3) {
            boolean isThree = evaluator.checkThree(ranks);
            if (isThree) {
                combination = Combination.THREE_OF_A_KIND;
            } else combination = Combination.TWO_PAIR;
        } else if (uniqueRanks == 2) {
            boolean isFour = evaluator.checkFour(ranks);
            if (isFour) {
                combination = Combination.FOUR_OF_A_KIND;
            } else combination = Combination.FULL_HOUSE;
        }
        return combination;
    }
}
