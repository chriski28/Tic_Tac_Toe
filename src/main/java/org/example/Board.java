package org.example;

public class Board {

    public char [][] cells;

    public Board(){
        cells = new char[3][3];
        for(int i = 0; i < cells.length;i++){
            for(int j = 0; j < cells[i].length;j++){
                cells[i][j] = ' ';
            }
            System.out.print("\n");
        }
    };

    public boolean isCellEmpty(int x, int y){
        if(x>=0 && x <3 && y >=0 && y<3){
            if (cells[x][y]==' ')
                return true;
            else
                return false;

        }
        return false;

    }
    public void place(int x, int y, char marker){
        if(isCellEmpty(x,y)){
            cells[x][y] = marker;
        }
    }
    public void print() {
        System.out.print(getBoardForPrint());
    }
    public String getBoardForPrint() {
        String temp = "▁▁▁▁▁▁▁" + System.lineSeparator();
        for (int i = 0; i < cells.length; i++) {
            temp += "|";
            for (int n = 0; n < cells[i].length; n++) {
                temp += cells[i][n] + "|";
            }
            temp += System.lineSeparator();
        }
        temp += "▔▔▔▔▔▔▔";
        temp += System.lineSeparator();
        return temp;
    }

    public char getCell(int r, int c){
        return cells[r][c];
    }
    public boolean isFull(){
        for(int i = 0; i < cells.length;i++){
            for(int j = 0; j < cells[i].length;j++){
                if(cells[i][j] == ' ')
                    return false;
            }
        }
        return true;
    }
    public void clear() {
        for(int i = 0; i < cells.length;i++){
            for(int j = 0; j < cells[i].length;j++){
                cells[i][j] = ' ';
            }
        }
    }
}
