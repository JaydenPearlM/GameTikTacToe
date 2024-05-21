package gametiktactoe;

import java.util.Scanner;

public class TicTacToe {

    String [][] board = new String[3][3]; // represents the 3x3 Tic Tac Toe board
    int numMoves;          // keeps track of how many moves have been made

    String turn;            // keeps track of whose turn it is (either "X" or "O")
    
    boolean gameOver;       // keeps track of whether the game has ended (either through a win or draw)
    Scanner scanner;        // scanner variable for getting input

 

    public TicTacToe() 
    {
        for (int i = 0; i < 3; i++) 
        {
            for (int j = 0; j < 3; j++) 
            {
              board[i][j] = "-";
            }
        }
        printBoard();
        
        numMoves = 0;
        turn = "X";
        gameOver = false;
        scanner = new Scanner(System.in);
    }   
    
    
    // initialize all the instance variables//
    // for the board 2D array, assign the "-" symbol to each of the elements//
    // to represent that all the squares are empty at the start of the game//
    // also call the printBoard() method so that it displays the board when the game first starts//

    public void playGame() 
    {
        while(!gameOver)
        {
            playTurn();
        }
        // Keep calling the playTurn() method as long as the game has not ended
    }

    public void playTurn() 
    {   
//        String player = "X";
//        String player = "O";
       
       
        System.out.println("It's " + turn + " turn");
        makeMove();
        printBoard();
        
        if (isGameWon(turn))
        {
          
            gameOver = true;
            
            System.out.println(turn + " has won the game!");
        }
        else if (numMoves == 9) 
        {
            gameOver = true;
            System.out.println("It's a Draw!!");
        }
        if (turn.equals("X"))
        {
            turn = "O";
        }
        else 
        {
            turn = "X";
        }
      
    }
     
        
        
        
       
        
   
//            Print out a message saying whose turn it is.//
//            Call the makeMove() method.
//            Call the printBoard() method.
//            Call the isGameWon() method and if the game has been won, print a message
//            saying which player won the game.
//            Check if the game has ended in a draw and if so, print a message for that.
//         */
    

    private void makeMove() 
    {
        int row;
        int column;
        while (true) 
        {
                System.out.println(" Enter Row Number:");
                row = scanner.nextInt();

                System.out.println(" Enter Column Number:");
                column = scanner.nextInt();

                if (row < 0 || column < 0 || row > 2 || column > 2) 
                {
                    System.out.println(" Numbers Invalid Try Again!");
                } 
                else if (!board[row][column].equals("-")) 
                {
                    System.out.print(" This Has Already Been Played");
                } 
                else 
                {
                   break;
                }
        }
        
        board[row][column] = turn;
        
        numMoves++;
    }
     
/*
            Ask the user for the row and the column of the square they want to play.//
            You'll need to validate the input.//
            If the square does not exist, tell them it's invalid and prompt them again.//
            If the square does exist, but it's already been played, let them know and
            prompt them again.//
            Otherwise if it's valid, set that square to either "X" or "O" (whoever's turn it is).
            Also update any instance variables that might need updating.
 */

    private boolean isGameWon(String player)
    { 
        
        
           
        if (board[0][0].equals(player) && board[0][1].equals(player) && (board[0][2].equals(player))  ) 
        {
            return true;
        }
         if (board[1][0].equals(player) && board[1][1].equals(player) && (board[1][2].equals(player))  ) 
        {
            return true;
        }
        if (board[2][0].equals(player) && board[2][1].equals(player) && (board[2][2].equals(player))  ) 
        {
            return true;
        }
       //Diagnoal
        if (board[0][0].equals(player) && board[1][1].equals(player) && (board[2][2].equals(player))  ) 
        {
            return true;
        }
        
        if (board[0][2].equals(player) && board[1][1].equals(player) && (board[2][0].equals(player))  ) 
        {
            return true;
        }
        // vertical
        if (board[0][0].equals(player) && board[1][0].equals(player) && (board[2][0].equals(player))  ) 
        {
            return true;
        }
        if (board[0][1].equals(player) && board[1][1].equals(player) && (board[2][1].equals(player))  ) 
        {
            return true;
        }
         if (board[2][0].equals(player) && board[2][1].equals(player) && (board[2][2].equals(player))  ) 
        {
          return true;  
        }       
        
          return false;
        
        
        /*
            The player parameter will be either "X" or "O", representing whichever player just made a move.
            You have to check if the player won the game and return true if so.
            There are several ways to win Tic Tac Toe (horizontally, vertically, diagonally).
            Make sure to check each possible way.
            For example, you can check if the player won across the top row by checking if each of those squares
            is equal to the player.
         */
       
    } 

    
    
// THIS METHOD IS COMPLETE, DON'T EDIT THIS METHOD
    
    private void printBoard()
    {
        for (int i = 0; i < board.length; i++)
        {
            printRow(i);
        }
    }

    // THIS METHOD IS COMPLETE, DON'T EDIT THIS METHOD
    private void printRow(int rowIndex)
    {
        System.out.println(board[rowIndex][0] + "\t" + board[rowIndex][1] + "\t" + board[rowIndex][2]);
    }
}