package com.betterorjacks;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GUI {

    private Deck deck = Deck.getDeck();

    private boolean inPlay = false;

    private JLabel cardLabel1 = new JLabel();
    private JLabel cardLabel2 = new JLabel();
    private JLabel cardLabel3 = new JLabel();
    private JLabel cardLabel4 = new JLabel();
    private JLabel cardLabel5 = new JLabel();
    private JButton holdButton1 = new JButton();
    private JButton holdButton2 = new JButton();
    private JButton holdButton3 = new JButton();
    private JButton holdButton4 = new JButton();
    private JButton holdButton5 = new JButton();
    private List<JButton> buttons = new ArrayList<>(Arrays.asList(holdButton1, holdButton2, holdButton3, holdButton4, holdButton5));
    private List<JLabel> labels = new ArrayList<>(Arrays.asList(cardLabel1, cardLabel2, cardLabel3, cardLabel4, cardLabel5));
    private JButton playButton = new JButton();
    private JLabel combinationLabel = new JLabel();

    /**
     * Building the Graphic User Interface
     */
    public GUI() {
        JFrame frame = new JFrame("Jacks or better");
        frame.setSize(1100, 500);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        combinationLabel.setPreferredSize(new Dimension(1000, 50));
        combinationLabel.setHorizontalAlignment(SwingConstants.CENTER);
        combinationLabel.setVerticalAlignment(SwingConstants.CENTER);
        Font font = new Font("Comic Sans MS", Font.BOLD, 28);
        combinationLabel.setFont(font);
        frame.add(combinationLabel, BorderLayout.NORTH);

        JPanel panel = new JPanel();


        String backFile = "cards/back/back.png";

        for (JLabel label : labels) {
            label.setIcon(new ImageIcon(backFile));
            panel.add(label);
        }

        for (JButton button : buttons){
            button.setPreferredSize(new Dimension(200, 50));
            button.addActionListener(e -> setHoldState(button));
            panel.add(button);
        }

        setInitialState();

        playButton.setText("Play!"); playButton.setPreferredSize(new Dimension(200,100));
        playButton.addActionListener(e -> getState());

        panel.add(playButton);
        frame.add(panel);
        frame.setVisible(true);
    }

    /**
     * Receives the state of the play,
     * whether the user finished the game getting the combination,
     * or just finished the firs round of the game
     */
    private void getState() {
        if (inPlay){
            playAgain();
        } else play();
    }

    /**
     * Sets the pressed button in the state of hold,
     * when pressed again, returns to the initial state
     *
     * @param holdButton    pressed button
     */
    private void setHoldState(JButton holdButton){
        String text = "Card is held";
        if (!holdButton.getText().equals(text)){
            holdButton.setText(text);
            holdButton.setBackground(Color.RED);
        } else {
            holdButton.setText("HOLD");
            holdButton.setBackground(null);
        }
    }

    /**
     * Invokes the methods from the Deck class to shuffle the deck and compose the hand of cards,
     * displays the pictures of the cards, and sets the "IN PLAY" state
     */
    private void play() {
        deck.shuffle();
        deck.composeHand();
        getCards();
        combinationLabel.setText("");
        for (JButton button : buttons){
            button.setEnabled(true);
        }
        inPlay = true;
    }

    /**
     * Receives the cards being held and passes them to the Deck instance to get the updated hand images.
     * Then the evaluation of the updated hand is happening and name of the combination appears on the screen.
     * "IN PLAY" state is over, and the game returns to the initial state.
     */
    private void playAgain() {
        int[] heldCards = getHeldCards();
        deck.updateHand(heldCards);
        getCards();
        Combination combination = deck.evaluateHand();
        combinationLabel.setText(combination.getName());
        setInitialState();
        inPlay = false;
        deck.reset();
    }

    /**
     * Receives the images of the cards in the hand
     * and each label icon is set to the corresponding image in the hand.
     */
    private void getCards() {
        List<BufferedImage> images = deck.getHand();
        int imageNumber = 0;
        for (JLabel label : labels){
            label.setIcon(new ImageIcon(images.get(imageNumber)));
            imageNumber++;
        }
    }

    /**
     * Forms the array of 0's and 1's based on what state every button is currently in.
     * 1 - the button is pressed, so it is in the "held" state, 0 - otherwise.
     *
     * @return  the array of held cards, which is then should be passed to the Deck instance
     */
    private int[] getHeldCards(){
        int[] heldCards = new int[5];
        String text = "Card is held";
        int i = 0;
        for (JButton button : buttons){
            if (button.getText().equals(text)){
                heldCards[i] = 1;
            } else heldCards[i] = 0;
            i++;
        }
        return heldCards;
    }

    /**
     * Sets the initial state of the game.
     */
    private void setInitialState(){
        for (JButton button : buttons){
            button.setText("HOLD");
            button.setBackground(null);
            button.setEnabled(false);
        }
    }
}
