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
        Scanner sc = new Scanner(System.in);
        int row;
        int col;

        while(true) {
            System.out.printf("Current Player: %c\n",currentPlayer.getMarker());
            do {
                System.out.print("row (0-2): ");
                row = sc.nextInt();
                if(row>2 || row<0){
                    System.out.println("Please enter a number between 0 and 2");
                }
            }while(row>2 || row<0);
            do {
                System.out.print("column (0-2): ");
                col = sc.nextInt();
                if(col>2 || col<0){
                    System.out.println("Please enter a number between 0 and 2");
                }
            }while(col>2 || col<0);

            board.place(row, col, currentPlayer.getMarker());

            currentPlayer = currentPlayer==player1 ? player2 : player1;
        }
        //sc.close();
    }


}
