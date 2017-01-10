package com.betterorjacks;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class EvaluatorTest {

    @Test
    public void testReturnCombination1(){
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Rank.TEN, Suit.SPADES));
        cards.add(new Card(Rank.JACK, Suit.SPADES));
        cards.add(new Card(Rank.QUEEN, Suit.SPADES));
        cards.add(new Card(Rank.KING, Suit.SPADES));
        cards.add(new Card(Rank.ACE, Suit.SPADES));
        Evaluator evaluator = new Evaluator();
        Combination combination = evaluator.returnCombination(cards);
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
        Evaluator evaluator = new Evaluator();
        Combination combination = evaluator.returnCombination(cards);
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
        Evaluator evaluator = new Evaluator();
        Combination combination = evaluator.returnCombination(cards);
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
        Evaluator evaluator = new Evaluator();
        Combination combination = evaluator.returnCombination(cards);
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
        Evaluator evaluator = new Evaluator();
        Combination combination = evaluator.returnCombination(cards);
        assertEquals(Combination.FULL_HOUSE, combination);
    }

    @Test
    public void testReturnCombination6(){
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Rank.SEVEN, Suit.CLUBS));
        cards.add(new Card(Rank.KING, Suit.CLUBS));
        cards.add(new Card(Rank.JACK, Suit.CLUBS));
        cards.add(new Card(Rank.TWO, Suit.CLUBS));
        cards.add(new Card(Rank.NINE, Suit.CLUBS));
        Evaluator evaluator = new Evaluator();
        Combination combination = evaluator.returnCombination(cards);
        assertEquals(Combination.FLUSH, combination);
    }

    @Test
    public void testReturnCombination7(){
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Rank.JACK, Suit.DIAMONDS));
        cards.add(new Card(Rank.JACK, Suit.SPADES));
        cards.add(new Card(Rank.JACK, Suit.CLUBS));
        cards.add(new Card(Rank.TWO, Suit.CLUBS));
        cards.add(new Card(Rank.NINE, Suit.CLUBS));
        Evaluator evaluator = new Evaluator();
        Combination combination = evaluator.returnCombination(cards);
        assertEquals(Combination.THREE_OF_A_KIND, combination);
    }

    @Test
    public void testReturnCombination8(){
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Rank.EIGHT, Suit.HEARTS));
        cards.add(new Card(Rank.EIGHT, Suit.SPADES));
        cards.add(new Card(Rank.QUEEN, Suit.CLUBS));
        cards.add(new Card(Rank.TWO, Suit.CLUBS));
        cards.add(new Card(Rank.QUEEN, Suit.DIAMONDS));
        Evaluator evaluator = new Evaluator();
        Combination combination = evaluator.returnCombination(cards);
        assertEquals(Combination.TWO_PAIR, combination);
    }

    @Test
    public void testReturnCombination9(){
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Rank.ACE, Suit.SPADES));
        cards.add(new Card(Rank.NINE, Suit.CLUBS));
        cards.add(new Card(Rank.JACK, Suit.DIAMONDS));
        cards.add(new Card(Rank.ACE, Suit.HEARTS));
        cards.add(new Card(Rank.QUEEN, Suit.CLUBS));
        Evaluator evaluator = new Evaluator();
        Combination combination = evaluator.returnCombination(cards);
        assertEquals(Combination.JACKS_OR_BETTER, combination);
    }

    @Test
    public void testReturnCombination10(){
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Rank.ACE, Suit.SPADES));
        cards.add(new Card(Rank.KING, Suit.CLUBS));
        cards.add(new Card(Rank.QUEEN, Suit.DIAMONDS));
        cards.add(new Card(Rank.JACK, Suit.HEARTS));
        cards.add(new Card(Rank.NINE, Suit.CLUBS));
        Evaluator evaluator = new Evaluator();
        Combination combination = evaluator.returnCombination(cards);
        assertEquals(Combination.NO_COMBINATION, combination);
    }
}