package org.example;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

class TicTacToeTest {

    TicTacToe ticTacToe;
    Board board;
    @BeforeEach
    public void setUp(){
        ticTacToe = new TicTacToe();
        board = new Board();
    }


    @Test
    void hasWinner_test_rowWin(){
        for(int r = 0; r<3;r++){
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
        for(int c = 0; c<3;c++){
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
        board.place(0, 0, 'X');
        board.place(1, 1, 'X');
        board.place(2, 2, 'X');
        ticTacToe.setBoard(board);  // Set the test board to the game
        ticTacToe.setCurrentPlayer(new Player('X'));  // Ensure current player is 'X'
        assertTrue(ticTacToe.hasWinner());
    }
    @Test
    void hasWinner_test_d2Win(){
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
        ticTacToe.setBoard(board);
        assertFalse(ticTacToe.hasWinner());
    }
    @Test
    void hasWinner_test_noWin2(){
        //when it is full
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
        // at first, it should be 'X'
        assertEquals('X', ticTacToe.getCurrentPlayer().getMarker());
        // After switching, currentPlayer should be 'O'
        ticTacToe.switchCurrentPlayer();
        assertEquals('O', ticTacToe.getCurrentPlayer().getMarker());
        // After another switch, currentPlayer should be 'X' again
        ticTacToe.switchCurrentPlayer();
        assertEquals('X', ticTacToe.getCurrentPlayer().getMarker());
    }
    @Test
    void getValidInput_test_validInput() {
        //read the following value
        String input = "1\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        int row = ticTacToe.getValidInput("row");
        assertEquals(1, row);
    }
    @Test
    void getValidInput_test_invalidThenValidInput() {
        //read the following value
        String input = "-1\n5\n1\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        int row = ticTacToe.getValidInput("row");
        assertEquals(1, row);
    }
    @Test
    void restart_test_rightOutput() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        // fill some place in board
        ticTacToe.getBoard().place(0, 0, 'X');
        ticTacToe.getBoard().place(1, 1, 'O');
        ticTacToe.switchCurrentPlayer(); // Switch to player2
        ticTacToe.restart();
        //test board.clear() in restart();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertTrue(ticTacToe.getBoard().isCellEmpty(i, j));
            }
        }
        //test  System.out.println("Play again!");
        assertTrue(outContent.toString().contains("Play again!"));
        //test currentPlayer = player1;
        assertEquals(ticTacToe.getCurrentPlayer(),ticTacToe.getPlayer1());
    }
}










