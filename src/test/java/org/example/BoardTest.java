package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    void isCellEmpty_test_empty() {
        Board board = new Board();
        assertTrue(board.isCellEmpty(1, 1));
    }
    @Test
    void isCellEmpty_test_full() {
        Board board = new Board();
        board.cells[0][0]='X';
        assertFalse(board.isCellEmpty(0, 0));
    }

    @Test
    void isCellEmpty_test_invalid_input(){
        Board board = new Board();
        assertFalse(board.isCellEmpty(-1, 0));
        assertFalse(board.isCellEmpty(0, -1));
        assertFalse(board.isCellEmpty(4, -1));
    }

    @Test
    void place_test_placement(){
        Board board = new Board();
        board.place(1,2,'X');
        assertEquals('X',board.cells[1][2]);
    }

    @Test
    void print_test() {
        Board board = new Board();
        assertEquals("▁▁▁▁▁▁▁"+System.lineSeparator()+"| | | |"+System.lineSeparator()+"| | | |"+System.lineSeparator()+"| | | |"+System.lineSeparator()+"▔▔▔▔▔▔▔"+System.lineSeparator(), board.getBoardForPrint());
    }
    @Test
    public void isFull_test_boardIsFull(){
        Board board = new Board();
        for(int i = 0; i < 3;i++){
            for(int j = 0; j < 3;j++){
                board.place(i,j,'X');
            }
    }
        assertTrue(board.isFull());
    }
    @Test
    public void isFull_test_boardIsLeer(){
        Board board = new Board();
        assertFalse(board.isFull());
    }
}