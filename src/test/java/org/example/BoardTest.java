package org.example;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    Board board;
    @BeforeEach
    public void setUp(){
        board = new Board();
    }

    @Test
    void isCellEmpty_test_empty() {
        assertTrue(board.isCellEmpty(1, 1));
    }
    @Test
    void isCellEmpty_test_full() {
        board.cells[0][0]='X';
        assertFalse(board.isCellEmpty(0, 0));
    }

    @Test
    void isCellEmpty_test_invalid_input(){
        assertFalse(board.isCellEmpty(-1, 0));
        assertFalse(board.isCellEmpty(0, -1));
        assertFalse(board.isCellEmpty(4, -1));
    }

    @Test
    void place_test_placement(){
        board.place(1,2,'X');
        assertEquals('X',board.cells[1][2]);
    }
    @Test
    void print_test() {
        assertEquals("▁▁▁▁▁▁▁"+System.lineSeparator()+"| | | |"+System.lineSeparator()+"| | | |"+System.lineSeparator()+"| | | |"+System.lineSeparator()+"▔▔▔▔▔▔▔"+System.lineSeparator(), board.getBoardForPrint());
    }
    @Test
    public void isFull_test_boardIsFull(){
        for(int i = 0; i < 3;i++){
            for(int j = 0; j < 3;j++){
                board.place(i,j,'X');
            }
        }
        assertTrue(board.isFull());
    }
    @Test
    public void isFull_test_boardIsLeer(){
        assertFalse(board.isFull());
    }

    @Test
    void clear_test_nonEmptyBoard(){
        board.place(0,0,'X');
        board.place(1,1,'O');
        board.place(2,2,'X');
        board.clear();

        for(int i = 0; i < board.cells.length;i++){
            for(int j = 0; j < board.cells[i].length;j++){
                assertEquals(' ', board.cells[i][j]);
            }
        }
    }
    @Test
    void clear_test_emptyBoard(){
        board.clear();

        for(int i = 0; i < board.cells.length;i++){
            for(int j = 0; j < board.cells[i].length;j++){
                assertEquals(' ', board.cells[i][j]);
            }
        }
    }
}
/*
*
private IntSet set;

@BeforeEach
    public void setUp(){
        set = new IntSet(4);
    }
*/