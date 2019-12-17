import org.junit.Assert;
import org.junit.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import junit.framework.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

class Game {
    private static final int MAX_LIFE_COUNT = 5;
    private static int currentLifes;
    private static String currentString;
    private static String fullLine;
    private static char[] charArray;
    private static char[] currentCharArray;
    private static char[] usedSymbols;
    private static int usedSymbolsPointer;

    public static void startGame(String word){

        try {
            currentLifes = MAX_LIFE_COUNT;
            usedSymbols = new char[word.length() + 6];
            usedSymbolsPointer = 0;
            charArray = word.toCharArray();
            currentCharArray = new char[charArray.length];

            for (int i = 0; i < currentCharArray.length; i++) {
                currentCharArray[i] = '*';
            }
            currentCharArray[0] = charArray[0];
            currentCharArray[charArray.length - 1] = charArray[charArray.length - 1];
            usedSymbols[usedSymbolsPointer] = charArray[0];
            usedSymbolsPointer++;
            usedSymbols[usedSymbolsPointer] = charArray[charArray.length - 1];
            usedSymbolsPointer++;
            revealLetter(charArray[0]);
            revealLetter(charArray[charArray.length - 1]);

            currentString = new String(currentCharArray);
            fullLine = currentLifes + " | " + currentString;
        }
        catch (Exception e) {fullLine = "Error!";}
    }

    public static void trySymbol(char symbol) {
        for (int i = 0; i < usedSymbols.length; i++) {
            if (usedSymbols[i] == symbol) {
                fullLine = currentLifes + " | " + currentString;
                currentLifes++;
                break;
            }
        }
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == symbol && currentCharArray[i] == '*') {
                currentCharArray[i] = symbol;
                revealLetter(symbol);
                currentString = new String(currentCharArray);
                currentLifes++;
                break;
            }
        }
        usedSymbols[usedSymbolsPointer] = symbol;
        usedSymbolsPointer++;
        currentLifes--;
        if (currentLifes == 0)
            fullLine = "Game over!";
        else if (!currentString.contains("*"))
            fullLine = "You win!";
        else
            fullLine = currentLifes + " | " + currentString;
    }

    private static void revealLetter(char letter) {
        for (int i = 0; i < currentCharArray.length; i++) {
            if (charArray[i] == letter)
                currentCharArray[i] = letter;
        }
    }

    public static String getFullLine(){
        return fullLine;
    }
}

class Word{
    static String [] words = {"Ukraine", "USA", "Russia", "Canada", "Denmark", "China"};

    public static String getWord(){
        return words[(int)(Math.random() * words.length)];
    }
    
}

class Program {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Lab 4 oop");
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(320,150);

        JTextField input = new JTextField();
        frame.getContentPane().add(input);
        input.setBounds(10,10, 100, 50);

        JLabel label = new JLabel();
        frame.getContentPane().add(label);
        label.setBounds(10,50, 290, 50);
        Game.startGame(Word.getWord());
        label.setText(Game.getFullLine());

        JButton btn1=new JButton("Try");
        frame.getContentPane().add(btn1);
        btn1.setBounds(110,9, 90, 50);
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                if(input.getText().length() == 1) {
                    Game.trySymbol(input.getText().charAt(0));
                    label.setText(Game.getFullLine());
                }
                input.setText("");
            }
        });
        JButton btn2=new JButton("Restart");
        frame.getContentPane().add(btn2);
        btn2.setBounds(200,9, 90, 50);
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                input.setText("");
                Game.startGame(Word.getWord());
                label.setText(Game.getFullLine());
            }
        });
    }
}