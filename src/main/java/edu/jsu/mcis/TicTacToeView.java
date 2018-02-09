package edu.jsu.mcis;

public class TicTacToeView {

    private TicTacToeModel model;

    /* CONSTRUCTOR */

    public TicTacToeView(TicTacToeModel model) {

        this.model = model;

    }

    public void viewModel() {

        /* Print the board to the console (see examples) */

        /* INSERT YOUR CODE HERE */
        for(int a = 0; a < model.getWidth(); ++a){
          System.out.print(a);
        }
        System.out.println("\n");
        for(int i = 0; i < model.getWidth(); ++i){
          System.out.print(i + " ");
          for(int )
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

}
