package edu.jsu.mcis;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class TicTacToeView extends JPanel implements ActionListener{

    private TicTacToeModel model;
    private JButton[][] squares;
    private JPanel squaresPanel;
    private JLabel resultLabel;
    int width;


    /* CONSTRUCTOR */

    public TicTacToeView(TicTacToeModel model) {

        this.model = model;
        width = model.getWidth();
        setLayout(new GridLayout(width +1 , width+1));
        squares = new JButton[width][width];
        for(int i = 0; i < width; ++i){
            for(int j = 0 ; j < width; ++j){
                squares[i][j] = new JButton();
                squares[i][j].addActionListener(this);
                squares[i][j].setName("Square" + i + j);
                squares[i][j].setPreferredSize(new Dimension(64,64));
                add(squares[i][j]);
            }
        }
        resultLabel = new JLabel();
        resultLabel.setName("ResultLabel");
        add(resultLabel);
        JPanel squaresPanel = new JPanel(new GridLayout(width,width));
        add(squaresPanel);
    }

    public void viewModel() {

        /* Print the board to the console (see examples) */

        /* INSERT YOUR CODE HERE */
        // Printing the Column headings
        System.out.print("  ");
        for(int a = 0; a < model.getWidth(); ++a){
          System.out.print(a);
        }
        System.out.print("    ");
        System.out.println("\n");
        for(int i = 0; i < model.getWidth(); ++i){
          System.out.print(i + " ");
          for(int j = 0; j < model.getWidth(); ++j){
              if(model.getMark(i, j) == TicTacToeModel.Mark.EMPTY){
                  System.out.print("-");
              }
              else{
                  System.out.print(model.getMark(i, j));
              }






          }
        System.out.println();

        }



    }

    public void showNextMovePrompt() {

        /* Display a prompt for the player's next move (see examples) */



        /* INSERT YOUR CODE HERE */
        if(model.isXTurn()){
          System.out.println("Player 1 (X) Move:");
          System.out.println("Enter the row and column numbers, separated by a space: ");
        }
        else{
          System.out.println("Player 2 (O) Move:");
          System.out.println("Enter the row and column numbers, separated by a space: ");
        }

    }

    public void showInputError() {

        /* Display an error if input is invalid (see examples) */

        /* INSERT YOUR CODE HERE */
        System.out.println("ERROR! Invalid Input");

    }

    public void showResult(String r) {

        /* Display final winner */

        System.out.println(r + "!");

    }

    @Override
    public void actionPerformed(ActionEvent e) {


        JButton pressed = (JButton)e.getSource();

        int row = (int) (pressed.getName().charAt(6)) - 48;
        int col = (int) (pressed.getName().charAt(7)) - 48;

        //Only changes the squares if the game is still ongoing
        if(!model.isGameover()){
        model.makeMark(row, col);
        pressed.setText(model.getMark(row, col).toString());

        if(model.isMarkWin(model.getMark(row, col))){
            resultLabel.setText(model.getResult().toString().toUpperCase());
        }

        if(model.isTie()){
            resultLabel.setText(model.getResult().toString().toUpperCase());
        }


        }
    }

}
