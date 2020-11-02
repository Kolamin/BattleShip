package battleship;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] coord = null;
        Board board = new Board(10);

        char[][] fog_of_war = board.getFog_of_war();

        char[] chars = board.getFillChars(10);
        int[] ints = board.getFillNumbers(10);

        board.drawCells(ints, fog_of_war, chars);

        System.out.println();

        System.out.println("Enter the coordinates of the Aircraft Carrier (5 cells):");
        coord = sc.nextLine().split(" ");

        int[] coordinates = board.getCoordinates(coord[0], coord[1], chars);

        System.out.println();

        System.out.println(Arrays.toString(coordinates));
    }
}
