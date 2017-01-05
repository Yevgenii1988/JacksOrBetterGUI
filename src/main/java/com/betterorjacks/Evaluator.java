package com.betterorjacks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Evaluator {
    private List<Rank> ranks = new ArrayList<>();
    private List<Card> cards = new ArrayList<>();

    public Evaluator(List<Card> cards){
        this.cards = cards;
        for (Card card : cards){
            Rank rank = card.getRank();
            ranks.add(rank);
        }
    }

    public Evaluator(){

    }

    protected List<Rank> getRanksArray(){
        return ranks;
    }

    protected int countRanks(List<Rank> ranks) {
        HashSet uniqueRanks = new HashSet();
        for (Rank rank : ranks){
            uniqueRanks.add(rank);
        }
        return uniqueRanks.size();
    }

    protected boolean checkSuites(List<Card> cards) {
        int cardCounter = 0;
        int firstCard = 0;
        for(int i = 1; i < cards.size(); i++) {
            if ((cards.get(i)).getSuit() != (cards.get(firstCard)).getSuit()) {
                break;
            }
            cardCounter++;
        }
        return cardCounter == 4;
    }

    protected List<List<Rank>> getStraightCombinations(){
        List<Rank> ranks = new ArrayList<>();
        List<List<Rank>> straightsArray = new ArrayList<>();
        for (Rank rank : Rank.values()){
            ranks.add(rank);
        }
        ranks.add(Rank.ACE);
        for (int i = 0; i < ranks.size()-4; i++){
            List<Rank> straights = new ArrayList<>();
            straights.add(ranks.get(i));
            straights.add(ranks.get(i+1));
            straights.add(ranks.get(i+2));
            straights.add(ranks.get(i+3));
            straights.add(ranks.get(i+4));
            straightsArray.add(straights);
        }
        return straightsArray;
    }

    protected List<List<Rank>> getStraightsList(Rank rank){
        List<List<Rank>> straightsArray = getStraightCombinations();
        List<List<Rank>> straights = new ArrayList<>();
        for (List<Rank> list : straightsArray){
            if (list.contains(rank)){
                straights.add(list);
            }
        }
        return straights;
    }

    protected boolean checkStraight(List<Rank> ranks) {
        int straightCounter = 0;
        List<List<Rank>> straightsArray = getStraightsList(ranks.get(0));
        for (List<Rank> array : straightsArray) {
            for (Rank rank : ranks) {
                if (array.contains(rank)) {
                    straightCounter++;
                }
            }
            if (straightCounter == 5){
                break;
            } else straightCounter = 0;
        }

        return straightCounter == 5;
    }

    protected boolean checkRoyalFlush(List<Rank> ranks){
        int royalFlushCounter = 0;
        ArrayList royalFlush = new ArrayList(Arrays.asList(Rank.TEN, Rank.JACK, Rank.QUEEN, Rank.KING, Rank.ACE));
        for (Rank rank : ranks){
            if (!(royalFlush.contains(rank))){
                break;
            }
            royalFlushCounter++;
        }
        return royalFlushCounter == 5;
    }

    protected boolean checkPairs(List<Rank> ranks) {
        int cardPosition = 0;
        ArrayList highCards = new ArrayList(Arrays.asList(Rank.JACK, Rank.QUEEN, Rank.KING, Rank.ACE));

        for(int i = 0; i < ranks.size(); ++i) {
            for(int j = ranks.size() - 1; j > i; --j) {
                if(ranks.get(i) == ranks.get(j)) {
                    cardPosition = i;
                    break;
                }
            }
        }
        return highCards.contains(ranks.get(cardPosition));
    }

    protected boolean checkThree(List<Rank> ranks){
        int threeCount = 0;
        for(int i = 0; i < ranks.size(); ++i){
            for(int j = ranks.size() - 1; j > i; --j){
                if (ranks.get(i) == ranks.get(j)){
                    threeCount++;
                }
            }
            if (threeCount > 0){
                break;
            }
        }
        return threeCount == 2;
    }

    protected boolean checkFour(List<Rank> ranks){
        int fourCount = 0;
        int i = 0;
        for(int j = ranks.size() - 1; j > i; --j){
            if (ranks.get(i) == ranks.get(j)){
                fourCount++;
            }
        }
        return (fourCount == 3) || (fourCount == 0);
    }

    public Combination returnCombination(){
        Combination combination = null;
        List<Rank> ranks = getRanksArray();
        int uniqueRanks = countRanks(ranks);
        if (uniqueRanks == 5) {
            boolean sameSuits = checkSuites(cards);
            boolean isStraight = checkStraight(ranks);
            if (sameSuits) {
                if (isStraight) {
                    boolean isRoyalFlush = checkRoyalFlush(ranks);
                    if (isRoyalFlush) {
                        combination = Combination.ROYAL_FLUSH;
                    } else combination = Combination.STRAIGHT_FLUSH;
                } else combination = Combination.FLUSH;
            } else if (isStraight) {
                combination = Combination.STRAIGHT;
            } else combination = Combination.NO_COMBINATION;
        } else if (uniqueRanks == 4) {
            boolean isHighPair = checkPairs(ranks);
            if (isHighPair) {
                combination = Combination.JACKS_OR_BETTER;
            } else combination = Combination.NO_COMBINATION;
        } else if (uniqueRanks == 3) {
            boolean isThree = checkThree(ranks);
            if (isThree) {
                combination = Combination.THREE_OF_A_KIND;
            } else combination = Combination.TWO_PAIR;
        } else if (uniqueRanks == 2) {
            boolean isFour = checkFour(ranks);
            if (isFour) {
                combination = Combination.FOUR_OF_A_KIND;
            } else combination = Combination.FULL_HOUSE;
        }
        return combination;
    }
}
