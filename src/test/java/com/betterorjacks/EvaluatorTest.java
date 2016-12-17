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
}