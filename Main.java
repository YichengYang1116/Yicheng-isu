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
        ArrayList<Character> game = new ArrayList<>();
        System.out.println("Welcome to Player vs Player Connect 4 game.");
        System.out.println("Enter how many turns you want to play: ");
        int turn = sc.nextInt();
        for (int i = 0; i < row * column; i++) {
            game.add('.');
        }
        char[] player = {'X', 'O'};
        for (int i = 0; i < turn; i++) {
            char players = player[i % 2];
            System.out.print(" ");
            for (int j = 0; j < column; j++){
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
            System.out.println("Player "+players+" choose a column(0-6): ");
            int space = sc.nextInt();
            for(int a = row-1;a >= 0;a--){
                int index = a * column + space;
                if(game.get(index)=='.'){
                    game.set(index,players);
                    break;
                }
            }
            int counter = 1;
            for()
        }
        sc.close();
    }
}

