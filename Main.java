//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = 6;
        int column = 7;
        int[] winCounter = {0, 0};
        ArrayList<Character> game = new ArrayList<>();
        System.out.println("Welcome to Player vs Player Connect 4 game.");
        boolean cycle = true;
        while(cycle){
            System.out.println("Choose the mode you want to play: ");
            System.out.println("1.Player vs Player");
            System.out.println("2.Player vs Computer (Random)");
            System.out.println("3.Player vs Computer (Never Loses)");
            int mode = sc.nextInt();
            while (mode < 1 || mode > 3){
                System.out.println("Invalid mode.Enter again: ");
                mode = sc.nextInt();
            }
            System.out.println("Enter how many turns you want to play: ");
            int turn = sc.nextInt();
            boolean over = false;
            game.clear();
            for (int i = 0; i < row * column; i++) {
                game.add('.');
            }
            char[] player = {'X', 'O'};
            for (int i = 0; i < turn; i++) {
                char players = player[i % 2];
                int lastRow = 0;
                int lastColumn = 0;
                int space = -1;
                boolean validInput = false;
                if (mode == 1 || players == 'X') {
                    while (!validInput){
                        System.out.println("Player "+players+" choose a column(0-6): ");
                        space = sc.nextInt();
                        for(int a = row-1;a >= 0;a--){
                            int index = a * column + space;
                            if(game.get(index)=='.'){
                                game.set(index,players);
                                lastRow = a;
                                lastColumn = space;
                                validInput = true;
                                break;
                            }
                        }
                        if (!validInput) {
                            System.out.println("Column is full. Try another.");
                        }
                    }
                } else {
                    for (int col = 0; col < column; col++) {
                        for (int r = row - 1; r >= 0; r--) {
                            int index = r * column + col;
                            if (game.get(index) == '.') {
                                game.set(index, players);
                                lastRow = r;
                                lastColumn = col;
                                System.out.println("Computer (O) drops in column " + col);
                                validInput = true;
                                break;
                            }
                        }
                        if (validInput) break;
                    }
                }
                System.out.print(" ");
                for (int j = 0; j < column; j++) {
                    System.out.print(j + " ");
                }
                System.out.println();
                for (int r = 0; r < row; r++) {
                    System.out.print("|");
                    for (int c = 0; c < column; c++) {
                        System.out.print(game.get(r * column + c) + "|");
                    }
                    System.out.println();
                }
                System.out.println("-----------------");
                int counter = 1;
                for(int s = 1;s < 4;s++){
                    int a = lastRow + s;
                    int c = lastColumn;
                    if(a < row && game.get(a * column + c) == players){
                        counter++;
                    }else{
                        break;
                    }
                }
                if(counter >=4){
                    System.out.println("Player "+players+" wins.");
                    if(players == 'X'){
                        winCounter[0]++;
                    }else{
                        winCounter[1]++;
                    }
                    over = true;
                    break;
                }
                counter=1;
                for(int s = 1;s < 4;s++){
                    int c = lastColumn + s;
                    if(c < column && game.get(lastRow * column + c) == players){
                        counter++;
                    }else{
                        break;
                    }
                }
                for(int s = 1;s < 4;s++){
                    int c = lastColumn - s;
                    if(c >= 0 && game.get(lastRow * column + c) == players){
                        counter++;
                    }else{
                        break;
                    }
                }
                if (counter >= 4) {
                    System.out.println("Player "+players+" wins.");
                    if (players == 'X'){
                        winCounter[0]++;
                    }else{
                        winCounter[1]++;
                    }
                    over = true;
                    break;
                }
                counter = 1;
                for(int s = 1;s < 4;s++){
                    int r = lastRow + s;
                    int c = lastColumn + s;
                    if(r < row && c < column && game.get(r * column + c) == players){
                        counter++;
                    }else{
                        break;
                    }
                }
                for(int s = 1;s < 4;s++){
                    int r = lastRow - s;
                    int c = lastColumn - s;
                    if(r >= 0 && c >= 0 && game.get(r * column + c) == players){
                        counter++;
                    }else{
                        break;
                    }
                }
                if(counter >=4){
                    System.out.println("Player "+players+" wins.");
                    if (players == 'X'){
                        winCounter[0]++;
                    }else{
                        winCounter[1]++;
                    }
                    over = true;
                    break;
                }
                counter = 1;
                for (int s = 1;s < 4;s++){
                    int r = lastRow + s;
                    int c = lastColumn - s;
                    if(r < row && c >= 0 && game.get(r * column + c) == players){
                        counter++;
                    }else{
                        break;
                    }
                }
                for (int s = 1;s < 4;s++){
                    int r = lastRow - s;
                    int c = lastColumn + s;
                    if(r >= 0 && c < column && game.get(r * column + c) == players){
                        counter++;
                    }else{
                        break;
                    }
                }
                if(counter >= 4){
                    System.out.println("Player "+players+" wins.");
                    if (players == 'X'){
                        winCounter[0]++;
                    }else{
                        winCounter[1]++;
                    }
                    over = true;
                    break;
                }
            }
            if (!over) {
                System.out.println("It's a draw!");
            }
            System.out.print(" ");
            for (int j = 0; j < column; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
            for (int r = 0; r < row; r++) {
                System.out.print("|");
                for (int c = 0; c < column; c++) {
                    System.out.print(game.get(r * column + c) + "|");
                }
                System.out.println();
            }
            System.out.println("-----------------");
            System.out.println("Leaderboard:");
            System.out.println("Player X wins: " + winCounter[0]);
            System.out.println("Player O wins: " + winCounter[1]);
            System.out.print("Do you want to play again? (y/n): ");
            String again = sc.next().toLowerCase();
            cycle = again.equals("y");
        }
        System.out.println("Thanks for playing!");
        sc.close();
    }
}

