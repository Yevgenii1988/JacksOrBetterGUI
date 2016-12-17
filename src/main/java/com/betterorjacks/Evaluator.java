package com.betterorjacks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Evaluator {
    private List<Rank> ranks = new ArrayList<Rank>();

    public Evaluator(List<Card> cards){
        for (Card card : cards){
            Rank rank = card.getRank();
            ranks.add(rank);
        }
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

    protected boolean checkStraight(List<Rank> ranks) {
        int straightCounter = 0;
        List<List<Rank>> straightsArray = ranks.get(0).getStraightsList();
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
}
