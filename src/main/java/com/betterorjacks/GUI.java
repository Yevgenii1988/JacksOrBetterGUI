package com.betterorjacks;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GUI {

    Deck deck = new Deck();

    private boolean inPlay = false;
    private JLabel cardLabel1 = new JLabel();
    private JLabel cardLabel2 = new JLabel();
    private JLabel cardLabel3 = new JLabel();
    private JLabel cardLabel4 = new JLabel();
    private JLabel cardLabel5 = new JLabel();
    JButton holdButton1 = new JButton();
    JButton holdButton2 = new JButton();
    JButton holdButton3 = new JButton();
    JButton holdButton4 = new JButton();
    JButton holdButton5 = new JButton();
    JButton playButton = new JButton();
    JLabel combinationLabel = new JLabel();

    public GUI() throws IOException {
        JFrame frame = new JFrame("Jacks or better");
        frame.setSize(1100, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        combinationLabel.setPreferredSize(new Dimension(1000, 50));
        combinationLabel.setHorizontalAlignment(SwingConstants.CENTER);
        combinationLabel.setVerticalAlignment(SwingConstants.CENTER);
        Font font = new Font("Comic Sans MS", Font.BOLD, 28);
        combinationLabel.setFont(font);
        frame.add(combinationLabel, BorderLayout.NORTH);

        JPanel panel = new JPanel();

        setInitialState();

        final String backFile = "cards/back/back.png";

        cardLabel1.setIcon(new ImageIcon(backFile));
        cardLabel2.setIcon(new ImageIcon(backFile));
        cardLabel3.setIcon(new ImageIcon(backFile));
        cardLabel4.setIcon(new ImageIcon(backFile));
        cardLabel5.setIcon(new ImageIcon(backFile));

        holdButton1.setPreferredSize(new Dimension(200, 50));
        holdButton2.setPreferredSize(new Dimension(200, 50));
        holdButton3.setPreferredSize(new Dimension(200, 50));
        holdButton4.setPreferredSize(new Dimension(200, 50));
        holdButton5.setPreferredSize(new Dimension(200, 50));
        holdButton1.addActionListener(e -> setHoldState(holdButton1));
        holdButton2.addActionListener(e -> setHoldState(holdButton2));
        holdButton3.addActionListener(e -> setHoldState(holdButton3));
        holdButton4.addActionListener(e -> setHoldState(holdButton4));
        holdButton5.addActionListener(e -> setHoldState(holdButton5));

        playButton.setText("Play!"); playButton.setPreferredSize(new Dimension(200,100));
        playButton.addActionListener(e -> {
            try {
                getState();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });

        panel.add(cardLabel1);
        panel.add(cardLabel2);
        panel.add(cardLabel3);
        panel.add(cardLabel4);
        panel.add(cardLabel5);
        panel.add(holdButton1);
        panel.add(holdButton2);
        panel.add(holdButton3);
        panel.add(holdButton4);
        panel.add(holdButton5);
        panel.add(playButton);
        frame.add(panel);
        frame.setVisible(true);
    }

    private void getState() throws IOException {
        if (inPlay){
            playAgain();
        } else play();
    }

    private void setHoldState(JButton holdButton){
        String text = "Card is held";
        if (!holdButton.getText().equals(text)){
            holdButton.setText(text);
        } else holdButton.setText("HOLD");
    }

    private void play() throws IOException {
        deck.shuffle();
        getCards();
        combinationLabel.setText("");
        Combination combination = deck.evaluateHand();
        if (combination != Combination.NO_COMBINATION){
            combinationLabel.setText("You have " + combination.getName() + " already");
        }
        holdButton1.setEnabled(true);
        holdButton2.setEnabled(true);
        holdButton3.setEnabled(true);
        holdButton4.setEnabled(true);
        holdButton5.setEnabled(true);
        inPlay = true;
    }

    private void playAgain() throws IOException {
        int[] heldCards = getHeldCards();
        deck.updateHand(heldCards);
        getCards();
        Combination combination = deck.evaluateHand();
        combinationLabel.setText(combination.getName());
        setInitialState();
        inPlay = false;
        deck = new Deck();
    }

    private void getCards() throws IOException {
        List<BufferedImage> images = deck.getHand();
        cardLabel1.setIcon(new ImageIcon(images.get(0)));
        cardLabel2.setIcon(new ImageIcon(images.get(1)));
        cardLabel3.setIcon(new ImageIcon(images.get(2)));
        cardLabel4.setIcon(new ImageIcon(images.get(3)));
        cardLabel5.setIcon(new ImageIcon(images.get(4)));
    }

    private int[] getHeldCards(){
        List<JButton> buttons = new ArrayList<>(Arrays.asList(holdButton1, holdButton2, holdButton3, holdButton4, holdButton5));
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

    private void setInitialState(){
        holdButton1.setText("HOLD"); holdButton1.setEnabled(false);
        holdButton2.setText("HOLD"); holdButton2.setEnabled(false);
        holdButton3.setText("HOLD"); holdButton3.setEnabled(false);
        holdButton4.setText("HOLD"); holdButton4.setEnabled(false);
        holdButton5.setText("HOLD"); holdButton5.setEnabled(false);
    }
}
