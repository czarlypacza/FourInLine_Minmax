package org.example;

import java.util.Scanner;

import static org.example.MinMax.minimax;
import static org.example.MinMax.whichMove;

public class Main {
    public static void main(String[] args) {
        String[] board = {"0","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15"};
        //String[] board = {"0","1","2","3","4","5","6","7","8"};
        boolean maximize = true;
        int player = 0;

        GameState state = new GameState(0,board);

        Scanner scanner = new Scanner(System.in);

        state.printBoard();

        System.out.println("Gracz 1 czy 2?");

        while(maximize) {
            switch (scanner.nextInt()) {
                case 1:
                    player = 1;
                    maximize = false;
                    break;
                case 2:
                    player = 2;
                    maximize = false;
                    int decision = whichMove(maximize,state);
                    state.makeMove(decision);
                    state.printBoard();
                    break;
                default:
                    System.out.println("Podano blędny numer gracza (1-2)");
            }
        }
        while (!state.IsEnd(false,player)){
            System.out.println("Podaj pozycje na której chcesz dac X");
            int ruch = scanner.nextInt();
            while(!state.makeMove(ruch)){
                System.out.println("Wybrano bledna pozycje, prosze podac inna");
                ruch = scanner.nextInt();
            }
            if (state.IsEnd(true,player)) {
                state.printBoard();
                break;
            }
            int decision = whichMove(maximize,state);
            state.makeMove(decision);
            state.printBoard();
            System.out.println(decision);


        }


    }
}