package org.example;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;


class TicTacToeTest {
    @Test
    void hasWinner_test_rowWin(){
        TicTacToe ticTacToe = new TicTacToe();

        for(int r = 0; r<3;r++){
            Board board = new Board();

            board.place(r, 0, 'X');
            board.place(r, 1, 'X');
            board.place(r, 2, 'X');

            ticTacToe.setBoard(board);  // Set the test board to the game
            ticTacToe.setCurrentPlayer(new Player('X'));  // Ensure current player is 'X'
            assertTrue(ticTacToe.hasWinner());
        }
    }
    @Test
    void hasWinner_test_colWin(){
        TicTacToe ticTacToe = new TicTacToe();

        for(int c = 0; c<3;c++){
            Board board = new Board();

            board.place(0, c, 'O');
            board.place(1, c, 'O');
            board.place(2, c, 'O');

            ticTacToe.setBoard(board);  // Set the test board to the game
            ticTacToe.setCurrentPlayer(new Player('O'));  // Ensure current player is 'O'
            assertTrue(ticTacToe.hasWinner());
        }
    }
    @Test
    void hasWinner_test_d1Win(){
        TicTacToe ticTacToe = new TicTacToe();
        Board board = new Board();

        board.place(0, 0, 'X');
        board.place(1, 1, 'X');
        board.place(2, 2, 'X');

        ticTacToe.setBoard(board);  // Set the test board to the game
        ticTacToe.setCurrentPlayer(new Player('X'));  // Ensure current player is 'X'
        assertTrue(ticTacToe.hasWinner());
    }
    @Test
    void hasWinner_test_d2Win(){
        TicTacToe ticTacToe = new TicTacToe();
        Board board = new Board();

        board.place(2, 0, 'O');
        board.place(1, 1, 'O');
        board.place(0, 2, 'O');

        ticTacToe.setBoard(board);  // Set the test board to the game
        ticTacToe.setCurrentPlayer(new Player('O'));  // Ensure current player is 'O'
        assertTrue(ticTacToe.hasWinner());
    }
    @Test
    void hasWinner_test_noWin1(){
        //when it is empty
        TicTacToe ticTacToe = new TicTacToe();
        Board board = new Board();
        ticTacToe.setBoard(board);
        assertFalse(ticTacToe.hasWinner());
    }
    @Test
    void hasWinner_test_noWin2(){
        //when it is full
        TicTacToe ticTacToe = new TicTacToe();
        Board board = new Board();

        board.place(0, 0, 'X');
        board.place(1, 1, 'O');
        board.place(2, 2, 'X');
        board.place(0, 2, 'O');
        board.place(1, 1, 'X');
        board.place(2, 0, 'O');

        ticTacToe.setBoard(board);  // Set the test board to the game
        ticTacToe.setCurrentPlayer(new Player('X'));  // Ensure current player is 'X'
        assertFalse(ticTacToe.hasWinner());
    }
    @Test
    public void testSwitchCurrentPlayer() {
        TicTacToe ticTacToe = new TicTacToe();

        // at first, it should be 'X'
        assertEquals('X', ticTacToe.getCurrentPlayer().getMarker());

        // After switching, currentPlayer should be 'O'
        ticTacToe.switchCurrentPlayer();
        assertEquals('O', ticTacToe.getCurrentPlayer().getMarker());

        // After another switch, currentPlayer should be 'X' again
        ticTacToe.switchCurrentPlayer();
        assertEquals('X', ticTacToe.getCurrentPlayer().getMarker());
    }












}