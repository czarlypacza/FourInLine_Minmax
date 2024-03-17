package org.example;

import java.util.ArrayList;
import java.util.Random;


public class MinMax {

    private static int counter = 0;

    public static int whichMove(boolean maximum,GameState state){
        ArrayList<Integer> results = new ArrayList<>();
        ArrayList<GameState> possibleMoves = state.possibleMoves();
        Random rand = new Random();
        for (GameState move : state.possibleMoves()) {
            int score = minimax(false, move, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
            results.add(score);
        }
        int index = 0;

        if (!maximum){
            int max = results.get(0);
            for (int i = 1; i < results.size(); i++) {
                if (max!=1) {
                    if (results.get(i) >= max) {
                        max = results.get(i);
                        index = i;
                    }
                }else {
                    if (results.get(i) >= max  && (rand.nextInt(6))+1==1) {
                        max = results.get(i);
                        index = i;
                    }
                }
            }
            //System.out.println(results);
            //System.out.println("licznik: "+counter);
            return possibleMoves.get(index).getPos();
        }else {
            int min = results.get(0);
            for (int i = 1; i < results.size(); i++) {

                if( results.get(i) <= min){
                    min = results.get(i);
                    index = i;
                }
            }
            //System.out.println("licznik: "+counter);
            return possibleMoves.get(index).getPos();
        }
    }

    public static int minimax(boolean maximum,GameState state,int iter,int alpha , int beta){
        counter++;
        if (state.IsEnd()){
            if (!maximum) return -1;// jezeli maks jest true (tura gracza) to zwroc -1 bo w poprzednim stanie bylo false a wtedy generowane byly ruchy cpu i w tym ruchu zakonczyla sie rozgrywka
            else return 1;
        }
        int aaa = iter;
        //int bestIndex = 0;
        ArrayList<GameState> possibleMoves = state.possibleMoves();
        //ArrayList<Integer> results = new ArrayList<>();
        //System.out.println("aaa   "+iter);
        if (!maximum) {
            int maxEval = Integer.MIN_VALUE;
            for (GameState move : possibleMoves) {
                int score = minimax(!maximum, move, iter--, alpha, beta);
                maxEval = Math.max(maxEval, score);
                alpha = Math.max(alpha, score);
                if (beta <= alpha) {
                    break;
                }
            }
            return maxEval;
        }else {
            int minEval = Integer.MAX_VALUE;
            for (GameState move : possibleMoves) {
                int score = minimax(!maximum, move, iter++, alpha, beta);
                minEval = Math.min(minEval, score);
                beta = Math.min(beta, score);
                if (beta <= alpha) {
                    break;
                }
            }
            return minEval;
        }


        //System.out.println(iter);
        /*System.out.println(maximum);
        System.out.println(possibleMoves);*/
        /*System.out.println(results);

        if (aaa==0){
            int max = results.get(0);
            for (int i = 1; i < results.size(); i++) {
                if( results.get(i) > max){
                    max = results.get(i);
                    bestIndex = i;
                }
            }
            System.out.println("licznik: "+counter);
            return possibleMoves.get(bestIndex).getPos();
        }
        if (!maximum){
            int max = results.get(0);
            for (int i = 1; i < results.size(); i++) {
                if( results.get(i) > max){
                    max = results.get(i);
                }
            }
            return max;
        }else {
            int min = results.get(0);
            for (int i = 1; i < results.size(); i++) {

                if( results.get(i) < min){
                    min = results.get(i);
                }
            }
            return min;
        }*/

    }


}
