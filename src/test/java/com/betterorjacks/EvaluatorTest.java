package com.betterorjacks;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class EvaluatorTest {
    @Test
    public void testCountRanks() throws Exception {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Rank.JACK, Suit.DIAMONDS));
        cards.add(new Card(Rank.TWO, Suit.CLUBS));
        cards.add(new Card(Rank.FIVE, Suit.HEARTS));
        cards.add(new Card(Rank.JACK, Suit.CLUBS));
        cards.add(new Card(Rank.TWO, Suit.SPADES));
        Evaluator evaluator = new Evaluator(cards);
        List<Rank> ranks = evaluator.getRanksArray();
        int numberOfRanks = evaluator.countRanks(ranks);
        assertTrue(numberOfRanks == 3);
    }

    @Test
    public void testCheckSuites() throws Exception {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Rank.JACK, Suit.DIAMONDS));
        cards.add(new Card(Rank.TWO, Suit.DIAMONDS));
        cards.add(new Card(Rank.FIVE, Suit.HEARTS));
        cards.add(new Card(Rank.SIX, Suit.DIAMONDS));
        cards.add(new Card(Rank.ACE, Suit.DIAMONDS));
        Evaluator evaluator = new Evaluator(cards);
        boolean sameSuits = evaluator.checkSuites(cards);
        assertTrue(!sameSuits);
    }

    @Test
    public void testGetStraightCombinations(){
        Evaluator evaluator = new Evaluator();
        List<List<Rank>> straights = evaluator.getStraightCombinations();
        assertEquals(10, straights.size());
    }

    @Test
    public void testGetStraightsList(){
        Evaluator evaluator = new Evaluator();
        List<List<Rank>> straightsAce = evaluator.getStraightsList(Rank.ACE);
        assertEquals(2, straightsAce.size());
        List<List<Rank>> straightsThree = evaluator.getStraightsList(Rank.THREE);
        assertEquals(3, straightsThree.size());
        List<List<Rank>> straightsSeven = evaluator.getStraightsList(Rank.SEVEN);
        assertEquals(5, straightsSeven.size());
        List<List<Rank>> straightsQueen = evaluator.getStraightsList(Rank.QUEEN);
        assertEquals(3, straightsQueen.size());
    }

    @Test
    public void testCheckStraight() throws Exception {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Rank.JACK, Suit.DIAMONDS));
        cards.add(new Card(Rank.NINE, Suit.CLUBS));
        cards.add(new Card(Rank.EIGHT, Suit.HEARTS));
        cards.add(new Card(Rank.SEVEN, Suit.DIAMONDS));
        cards.add(new Card(Rank.SIX, Suit.SPADES));
        Evaluator evaluator = new Evaluator(cards);
        List<Rank> ranks = evaluator.getRanksArray();
        boolean isStraight = evaluator.checkStraight(ranks);
        assertTrue(!isStraight);
    }

    @Test
    public void testCheckRoyalFlush() throws Exception {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Rank.JACK, Suit.DIAMONDS));
        cards.add(new Card(Rank.TEN, Suit.DIAMONDS));
        cards.add(new Card(Rank.NINE, Suit.DIAMONDS));
        cards.add(new Card(Rank.QUEEN, Suit.DIAMONDS));
        cards.add(new Card(Rank.KING, Suit.DIAMONDS));
        Evaluator evaluator = new Evaluator(cards);
        List<Rank> ranks = evaluator.getRanksArray();
        boolean isRoyalFlush = evaluator.checkRoyalFlush(ranks);
        assertFalse(isRoyalFlush);
    }

    @Test
    public void testCheckPairs() throws Exception {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Rank.JACK, Suit.DIAMONDS));
        cards.add(new Card(Rank.TEN, Suit.CLUBS));
        cards.add(new Card(Rank.TEN, Suit.SPADES));
        cards.add(new Card(Rank.QUEEN, Suit.HEARTS));
        cards.add(new Card(Rank.KING, Suit.DIAMONDS));
        Evaluator evaluator = new Evaluator(cards);
        List<Rank> ranks = evaluator.getRanksArray();
        boolean isPair = evaluator.checkPairs(ranks);
        assertTrue(!isPair);
    }

    @Test
    public void testCheckThree() throws Exception {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Rank.TWO, Suit.DIAMONDS));
        cards.add(new Card(Rank.TEN, Suit.CLUBS));
        cards.add(new Card(Rank.TEN, Suit.SPADES));
        cards.add(new Card(Rank.QUEEN, Suit.HEARTS));
        cards.add(new Card(Rank.QUEEN, Suit.DIAMONDS));
        Evaluator evaluator = new Evaluator(cards);
        List<Rank> ranks = evaluator.getRanksArray();
        boolean isThreeOfAKind = evaluator.checkThree(ranks);
        assertTrue(!isThreeOfAKind);
    }

    @Test
    public void testCheckFour() throws Exception {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Rank.TEN, Suit.DIAMONDS));
        cards.add(new Card(Rank.TEN, Suit.CLUBS));
        cards.add(new Card(Rank.TEN, Suit.SPADES));
        cards.add(new Card(Rank.QUEEN, Suit.HEARTS));
        cards.add(new Card(Rank.QUEEN, Suit.DIAMONDS));
        Evaluator evaluator = new Evaluator(cards);
        List<Rank> ranks = evaluator.getRanksArray();
        boolean isFourOfAKind = evaluator.checkFour(ranks);
        assertTrue(!isFourOfAKind);
    }

    @Test
    public void testReturnCombination1(){
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Rank.TEN, Suit.SPADES));
        cards.add(new Card(Rank.JACK, Suit.SPADES));
        cards.add(new Card(Rank.QUEEN, Suit.SPADES));
        cards.add(new Card(Rank.KING, Suit.SPADES));
        cards.add(new Card(Rank.ACE, Suit.SPADES));
        Evaluator evaluator = new Evaluator(cards);
        Combination combination = evaluator.returnCombination();
        assertEquals(Combination.ROYAL_FLUSH, combination);
    }

    @Test
    public void testReturnCombination2(){
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Rank.TEN, Suit.SPADES));
        cards.add(new Card(Rank.JACK, Suit.SPADES));
        cards.add(new Card(Rank.QUEEN, Suit.SPADES));
        cards.add(new Card(Rank.KING, Suit.SPADES));
        cards.add(new Card(Rank.NINE, Suit.SPADES));
        Evaluator evaluator = new Evaluator(cards);
        Combination combination = evaluator.returnCombination();
        assertEquals(Combination.STRAIGHT_FLUSH, combination);
    }

    @Test
    public void testReturnCombination3(){
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Rank.TEN, Suit.SPADES));
        cards.add(new Card(Rank.JACK, Suit.SPADES));
        cards.add(new Card(Rank.QUEEN, Suit.DIAMONDS));
        cards.add(new Card(Rank.KING, Suit.SPADES));
        cards.add(new Card(Rank.NINE, Suit.SPADES));
        Evaluator evaluator = new Evaluator(cards);
        Combination combination = evaluator.returnCombination();
        assertEquals(Combination.STRAIGHT, combination);
    }

    @Test
    public void testReturnCombination4(){
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Rank.SIX, Suit.CLUBS));
        cards.add(new Card(Rank.TWO, Suit.SPADES));
        cards.add(new Card(Rank.TWO, Suit.DIAMONDS));
        cards.add(new Card(Rank.TWO, Suit.CLUBS));
        cards.add(new Card(Rank.TWO, Suit.HEARTS));
        Evaluator evaluator = new Evaluator(cards);
        Combination combination = evaluator.returnCombination();
        assertEquals(Combination.FOUR_OF_A_KIND, combination);
    }

    @Test
    public void testReturnCombination5(){
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Rank.SEVEN, Suit.SPADES));
        cards.add(new Card(Rank.SEVEN, Suit.HEARTS));
        cards.add(new Card(Rank.SEVEN, Suit.DIAMONDS));
        cards.add(new Card(Rank.KING, Suit.CLUBS));
        cards.add(new Card(Rank.KING, Suit.SPADES));
        Evaluator evaluator = new Evaluator(cards);
        Combination combination = evaluator.returnCombination();
        assertEquals(Combination.FULL_HOUSE, combination);
    }
}