package org.example;

import java.util.Scanner;

public class TicTacToe {
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Board board;

    public TicTacToe(){
        board = new Board();
        player1 = new Player('X');
        player2 = new Player('O');
        currentPlayer = player1;
    }

    public void start(){
        int row;
        int col;
        while(true) {
            System.out.printf("Current Player: %c\n",currentPlayer.getMarker());
            board.print();
            row = getValidInput("row");
            col = getValidInput("col");
            // Check if the cell is empty; if not, prompt the current player to try again
            if(board.isCellEmpty(row,col)){
                board.place(row, col, currentPlayer.getMarker());
                //check Winner
                if(hasWinner()){
                    board.print();
                    System.out.printf("Congratulations! Player %c wins! \n",
                            currentPlayer.getMarker());
                    restart();
                }else if(board.isFull()){
                    board.print();
                    System.out.println("It's a draw!");
                    restart();
                }else{
                    switchCurrentPlayer();
                }
            }else{
                System.out.println("Cell is not empty! Try again.");
            }
        }
    }
    public boolean hasWinner(){
        char marker = currentPlayer.getMarker();
        // Check rows and columns
        for(int n = 0; n<3; n++){
            //row
            if(board.getCell(n, 0) == marker && board.getCell(n, 1) == marker &&
                    board.getCell(n, 2) == marker)   return true;
                //columns
            else if (board.getCell(0,n) == marker &&board.getCell(1,n) == marker &&
                    board.getCell(2,n) == marker)    return true;
        }
        // Check diagonals
        //d1
        if(board.getCell(0,0) == marker &&board.getCell(1,1) == marker &&
                board.getCell(2,2) == marker)  return true;
            //d2
        else if(board.getCell(2,0) == marker &&board.getCell(1,1) == marker &&
                board.getCell(0,2) == marker)  return true;

        return false;

    }
    public void switchCurrentPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }
    public int getValidInput(String nameOfValue){
        Scanner sc = new Scanner(System.in);
        int value;
        do {
            System.out.printf("%s (0-2): ",nameOfValue);
            value = sc.nextInt();
            if(value>2 || value<0){
                System.out.println("Please enter a number between 0 and 2");
            }
        }while(value>2 || value<0);
        return value;
    }
    public void restart(){
        board.clear();
        System.out.println("Play again!");
        currentPlayer = player1;
    }

    //getter and setter
    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }
    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }




}
