package edu.jsu.mcis;

public class TicTacToeModel{

    private static final int DEFAULT_WIDTH = 3;

    /* Mark (represents X, O, or an empty square */

    public enum Mark {

        X("X"),
        O("O"),
        EMPTY(" ");

        private String message;

        private Mark(String msg) {
            message = msg;
        }

        @Override
        public String toString() {
            return message;
        }

    };

    /* Result (represents the final state of the game: X wins, O wins, a tie,
       or NONE if the game is not yet over) */

    public enum Result {

        X("X"),
        O("O"),
        TIE("Tie"),
        NONE("none");

        private String message;

        private Result(String msg) {
            message = msg;
        }

        @Override
        public String toString() {
            return message;
        }

    };

    private Mark[][] grid; /* Game grid */
    private boolean xTurn; /* True if X is current player */
    private int width;     /* Size of game grid */

    /* DEFAULT CONSTRUCTOR */

    public TicTacToeModel() {

        /* No arguments (call main constructor; use default size) */

        this(DEFAULT_WIDTH);

    }

    /* CONSTRUCTOR */

    public TicTacToeModel(int width) {

        /* Initialize width; X goes first */

        this.width = width;
        xTurn = true;

        /* Create grid (width x width) as a 2D Mark array */

        /* INSERT YOUR CODE HERE */
        grid = new Mark[width][width];

        /* Initialize grid by filling every square with empty marks */

        /* INSERT YOUR CODE HERE */
        for(int i = 0; i < width; ++i){
          for(int j = 0; j < width; ++j){
            grid[i][j] = Mark.EMPTY;
          }
        }

    }

    public boolean makeMark(int row, int col) {

        /* Place the current player's mark in the square at the specified
           location, but only if the location is valid and if the square is
           empty! */

        /* INSERT YOUR CODE HERE */
        if(xTurn){
          if(isValidSquare(row,col)  && !isSquareMarked(row,col)){
            grid[row][col] = Mark.X;
            xTurn = false;
            return true;
          }
        }
        else if(!xTurn){
          if(isValidSquare(row,col) && !isSquareMarked(row,col)){
            grid[row][col] = Mark.O;
            xTurn = true;
            return true;
          }
        }

        else{
          return false;
        }


    }

    private boolean isValidSquare(int row, int col) {

        /* Return true if specified location is within grid bounds */

        /* INSERT YOUR CODE HERE */
        if(row > 0 && row < width && col > 0 && col < width){
          return true;
        }
        else{
          return false;
        }

    }

    private boolean isSquareMarked(int row, int col) {

        /* Return true if square at specified location is marked */
        /* INSERT YOUR CODE HERE */
        if(getMark(row,col) == Mark.X || getMark(row,col) == Mark.O){
          return true;
        }
        else{
          return false;
        }

    }

    public Mark getMark(int row, int col) {

        /* Return mark from the square at the specified location */
        /* INSERT YOUR CODE HERE */
        return grid[row][col];

    }

    public Result getResult() {

        /* Use isMarkWin() to see if X or O is the winner, if the game is a
           tie, or if the game is not over, and return the corresponding Result
           value */

        /* INSERT YOUR CODE HERE */
        if(isMarkWin(Mark.X)){
          return Result.X;
        }
        else if(isMarkWin(Mark.O)){
          return Result.O;
        }
        else if(isTie()){
          return Result.TIE;
        }
        else{
          return Result.NONE;
        }





    }

    private boolean isMarkWin(Mark mark) {

        /* Check the squares of the board to see if the specified mark is the
           winner */

        /* INSERT YOUR CODE HERE */
        boolean won = true;

        // Check for a horizontal winner
        for(int i = 0 ; i < width; ++i){
          for(int j = 0; j < width; ++j){
            if(!getMark(i,j).equals(mark)){
              won = false;
            }
            else{
              won = true;

            }
          }

        }
        if(won == true){
          return true;
        }


        // Checking for a Vertical winner
        won = true;
        for(int i = 0 ; i < width; ++i){
          for(int j = 0; j < width; ++j){
            if(!getMark(j,i).equals(mark)){
              won = false;
            }
          }

        }
        if(won == true){
          return true;
        }


        //Checking for a Diagonal Winner
        won = true;
        for(int i = 0; i < width; ++i){
          if(!getMark(i,i).equals(mark)){
            won = false;
          }
        }
        if(won == true){
          return true;
        }

        // Check for the other diagonal winner
        won = true;
        for(int i =0; i < width; ++i){
          for(int j = 0; j < width; ++j){
            if(!grid[width-1-i][j].equals(mark)){
              won = false;
            }
          }

        }

        if(won == true){
          return true;
        }

        return false;



    }

    private boolean isTie() {

        /* Check the squares of the board to see if the game is a tie */

        /* INSERT YOUR CODE HERE */
        for(int i = 0; i < width; ++i){
          for(int j = 0; j < width; ++j){
            if(getMark(i,j) == Mark.EMPTY){
              return false;
            }
          }

        }
        return true;




    }

    public boolean isGameover(){

        /* Return true if the game is over */

        return Result.NONE != getResult();

    }

    public boolean isXTurn(){

        /* Getter for xTurn */

        return xTurn;

    }

    public int getWidth(){

        /* Getter for width */

        return width;

    }

}
