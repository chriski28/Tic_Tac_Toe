package org.example;

public class Board {
    private char [][] cells;

    public Board(){
        cells = new char[3][3];
    };

    public boolean isCellEmpty(int x, int y){
        if(x>=0 && x <3 && y >=0 && y<3){
            if (cells[x][y]==' '){
                return true;
            }
            else{
                return false;
            }
        }
        return false;

    }
    public void place(int x, int y, char marker){
        if(isCellEmpty(x,y)){
            cells[x][y] = marker;
        }
    }

}
