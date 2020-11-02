package battleship;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class BoardTest {

    int[] ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    char[] chars = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};

    Board board = new Board(10);


    @Test
    void getArray() {
        assertArrayEquals(ints, board.getFillNumbers(10));

        assertArrayEquals(chars, board.getFillChars(10));
    }

    @Test
    void getCoordinates(){
        assertArrayEquals(new int[]{5, 2, 5, 6}, board.getCoordinates("F3", "F7", chars));
    }

}