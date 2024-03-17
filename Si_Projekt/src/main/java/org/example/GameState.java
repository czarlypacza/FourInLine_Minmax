package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class GameState {
    private int pos;
    private String[] board;

    public GameState(int pos, String[] board) {
        this.pos = pos;
        this.board = board;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public String[] getBoard() {
        return board;
    }

    public String getBoardIndex(int i) {
        return board[i];
    }

    public void setBoard(String[] board) {
        this.board = board;
    }

    public boolean makeMove(int i){
        if(board[i]!="X"){
            board[i] = "X";
            return true;
        }
        return false;
    }
    @Override
    public String toString() {
        return "GameState{" +
                "pos=" + pos +
                ", board=" + Arrays.toString(board) +
                '}';
    }

    public void printBoard(){
        for (int i = 0; i < board.length; i=i+4) {
            for (int j = i; j < i+4; j++) {
                System.out.print(board[j]+"\t");
            }
            System.out.println();
        }
    }

    int[][] checks = {{0,1,2,3},{4,5,6,7},{8,9,10,11},{12,13,14,15},{0,4,8,12},{1,5,9,13},{2,6,10,14},{3,7,11,15}};
    //int[][] checks = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{2,4,6},{0,4,8}};
    public boolean IsEnd(){
        for (int i = 0; i < checks.length; i++) {
            String[] args = {board[checks[i][0]],board[checks[i][1]],board[checks[i][2]],board[checks[i][3]]};
            //String[] args = {board[checks[i][0]],board[checks[i][1]],board[checks[i][2]]};
            if (String.format("%s%s%s%s",args).equals("XXXX")) return true;
            //if (String.format("%s%s%s%s",args).equals("XXXX")) return true;
        }
        return false;
    }
    public boolean IsEnd(boolean max,int player){
        for (int i = 0; i < checks.length; i++) {
            String[] args = {board[checks[i][0]],board[checks[i][1]],board[checks[i][2]],board[checks[i][3]]};
            //String[] args = {board[checks[i][0]],board[checks[i][1]],board[checks[i][2]]};
            if (String.format("%s%s%s%s",args).equals("XXXX")){
                if (max){
                    if (player==1){
                        System.out.println("Gracz 2 wygrywa  "+ i);
                    }else System.out.println("Gracz 1 wygrywa");

                }else {
                    if (player==1){
                        System.out.println("Gracz 1 wygrywa");
                    }else System.out.println("Gracz 2 wygrywa  "+ i);
                }
                return true;
            }
        }
        return false;
    }

    public ArrayList<GameState> possibleMoves(){
        ArrayList<GameState> possibleMoves = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            String[] newBoard = board.clone();

            if (!Objects.equals(newBoard[i], "X")){
                newBoard[i] = "X";
                possibleMoves.add(new GameState(i,newBoard));
            }
        }

        return possibleMoves;
    }


}
