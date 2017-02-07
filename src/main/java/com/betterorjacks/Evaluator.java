package com.betterorjacks;

import java.util.*;

public class Evaluator {
    private List<Rank> ranks = new ArrayList<>();
    private List<Card> cards = new ArrayList<>();

    public Evaluator(){

    }

    /**
     * Forms the list of ranks of cards in hand
     *
     * @return  list of ranks
     */
    private List<Rank> getRanksArray(){
        for (Card card : cards){
            Rank rank = card.getRank();
            ranks.add(rank);
        }
        return ranks;
    }

    /**
     * Forms the set of unique ranks of cards in hand
     *
     * @param ranks     list of ranks
     *
     * @return          number of unique ranks
     */
    private int countRanks(List<Rank> ranks) {
        Set<Rank> uniqueRanks = new HashSet<>();
        for (Rank rank : ranks){
            uniqueRanks.add(rank);
        }
        return uniqueRanks.size();
    }

    /**
     * Compares the suits of all the cards in hand with the first card,
     * if one the cards have different suit, cycle breaks immediately
     *
     * @param cards     list of cards
     *
     * @return          whether all the cards have the same suites
     */
    private boolean checkSuites(List<Card> cards) {
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

    /**
     * Forms the list of all possible rank combinations that can appear if the combination is STRAIGHT
     *
     * @return      list of rank combinations
     */
    private List<List<Rank>> getStraightCombinations(){
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

    /**
     * Loops through the previously created straights combinations list,
     * and adds to the new list combinations which contain the first card of the hand, passed as parameter
     *
     * @param rank      rank of first card in the hand
     *
     * @return          list of rank combinations
     */
    private List<List<Rank>> getStraightsList(Rank rank){
        List<List<Rank>> straightsArray = getStraightCombinations();
        List<List<Rank>> straights = new ArrayList<>();
        for (List<Rank> list : straightsArray){
            if (list.contains(rank)){
                straights.add(list);
            }
        }
        return straights;
    }

    /**
     * Checks if the previously created straights list of ranks contain all the ranks passed as parameter
     *
     * @param ranks     list of ranks
     *
     * @return          true if the combination is STRAIGHT
     */
    private boolean checkStraight(List<Rank> ranks) {
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

    /**
     * Checks if the ranks of cards passed as parameter belong to the ranks of ROYAL FLUSH combination
     *
     * @param ranks     list of ranks
     *
     * @return          true if the combination is ROYAL FLUSH
     */
    private boolean checkRoyalFlush(List<Rank> ranks){
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

    /**
     * Checks if pair of cards belongs to the high cards
     *
     * @param ranks     list of ranks
     *
     * @return          true if the pair is Jacks or higher
     */
    private boolean checkPairs(List<Rank> ranks) {
        int cardPosition = 0;
        ArrayList highCards = new ArrayList(Arrays.asList(Rank.JACK, Rank.QUEEN, Rank.KING, Rank.ACE));

        for(int i = 0; i < ranks.size(); i++) {
            for(int j = ranks.size() - 1; j > i; j--) {
                if(ranks.get(i) == ranks.get(j)) {
                    cardPosition = i;
                    break;
                }
            }
        }
        return highCards.contains(ranks.get(cardPosition));
    }

    /**
     * Checks if combination of cards contains three same ranks
     *
     * @param ranks     list of ranks
     *
     * @return          true : combination is THREE OF A KIND, false : TWO PAIR
     */
    private boolean checkThree(List<Rank> ranks){
        int threeCount = 0;
        for(int i = 0; i < ranks.size(); i++){
            for(int j = ranks.size() - 1; j > i; j--){
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

    /**
     * Checks if combination of cards contain four same ranks
     *
     * @param ranks     list of ranks
     *
     * @return          true : combination is FOUR OF A KIND, false : FULL HOUSE
     */
    private boolean checkFour(List<Rank> ranks){
        int fourCount = 0;
        int i = 0;
        for(int j = ranks.size() - 1; j > i; j--){
            if (ranks.get(i) == ranks.get(j)){
                fourCount++;
            }
        }
        return (fourCount == 3) || (fourCount == 0);
    }

    /**
     * Performs evaluation of the combination of the cards of the hand.
     * Evaluation is based on how many unique ranks the hand contain.
     *
     * @param cards     list of cards of the hand
     *
     * @return          name of the combination of cards
     */
    public Combination returnCombination(List<Card> cards){
        this.cards = cards;
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
