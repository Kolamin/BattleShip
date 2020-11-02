package battleship;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] coord = null;
        Board board = new Board(10);
        int x1, y1, x2, y2;

        char[][] fog_of_war = board.getFog_of_war();

        char[] chars = board.getFillChars(10);
        int[] ints = board.getFillNumbers(10);

        board.drawCells(ints, fog_of_war, chars);

        System.out.println();

        String typeShip = "";
        for (int i = 5; i < 3; i--) {
            if (i == 5)
                typeShip = "Aircraft Carrier";
            else if (i == 4)
                typeShip = "Battleship";
            else if (i == 3)
                typeShip = "Submarine";
            else if (i == 2) {
                typeShip = "Cruiser";
            }
            System.out.printf("Enter the coordinates of the %s (%d cells):%n", i, typeShip);
            System.out.println();
            while (true) {
                coord = sc.nextLine().split(" ");

                int[] coordinates = board.getCoordinates(coord[0], coord[1], chars);
                x1 = coordinates[0];
                y1 = coordinates[1];

                x2 = coordinates[2];
                y2 = coordinates[3];

                System.out.printf("[%d %d] [%d %d]", x1, y1, x2, y2);

                if (fog_of_war[x1][y1] == 'O'
                        || fog_of_war[x2][y2] == 'O'
                        || fog_of_war[x1 + 1][y1 + 1] == 'O'
                        || fog_of_war[x2 + 1][y2 + 1] == 'O'
                        || fog_of_war[x1 - 1][y1 - 1] == 'O'
                        || fog_of_war[x2 - 1][y2 - 1] == 'O') {
                    System.out.println("Error! You placed it too close to another one. Try again:");
                } else if (getLengthShip(x1, y1, x2, y2) != i) {
                    System.out.println("Error! Wrong length of the Submarine! Try again:");
                } else if (x1 < 0 || x1 > 9 || y1 < 0
                        || y1 > 9 || x2< 0
                        || x2 > 9 || y2 < 0
                        || y2 > 9){
                    System.out.println("Error! Wrong ship location! Try again:");
                }else{
                    if(x1 == x2 && y1 < y2){
                        for (int k = y1; k < y2; k++) {
                            fog_of_war[x1][k] = 'O';
                        }
                    }else if(x1 == x2 && y1 > y2){
                        for (int k = y2; k > y1; k--) {
                            fog_of_war[x1][k] = 'O';
                        }
                    }
                }
            }


        }

    }

    public static int getLengthShip(int x1, int y1, int x2, int y2) {
        return Math.abs((x2 - x1) + (y2 - y1));
    }
}
