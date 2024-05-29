package org.example;

public class Board {
    public char [][] cells;

    public Board(){
        cells = new char[3][3];
        for(int i = 0; i < cells.length;i++){
            for(int n = 0; n < cells[i].length;n++){
                cells[i][n]=' ';
            }
        }
    };

    public boolean isCellEmpty(int x, int y){
        if(x>=0 && x <3 && y >=0 && y<3){
            if (this.cells[x][y]!=' '){
                return false;
            }
            else {
                return true;
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
