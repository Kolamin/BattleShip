package battleship;

public class Board {

    private final char[][] fog_of_war;

    public Board(int count) {
        fog_of_war = new char[count][count];
        for (int i = 0; i < fog_of_war.length; i++) {
            for (int j = 0; j < fog_of_war.length; j++) {
                fog_of_war[i][j] = '~';
            }
        }
    }

    //fill and return fogs array
    public char[][] getFog_of_war() {
        return fog_of_war;
    }

    //fill and return numbers
    public int[] getFillNumbers(int n) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        return nums;
    }

    public char[] getFillChars(int n) {
        // new array
        char[] chars = new char[n];
        // fills chars array with the chars
        for (char ch = 'A'; ch <= 'J'; ++ch) {
            chars[ch - 'A'] = ch;
        }
        return chars;
    }

    /**
     * Draw board
     *
     * @param nums  Arrays of numbers
     * @param fogs  Arrays of '~'
     * @param chars Arrays of chars
     */
    public void drawCells(int[] nums, char[][] fogs, char[] chars) {

        for (int i = 0; i < nums.length; i++) {
            System.out.print(" " + nums[i]);
        }
        System.out.println();

        for (int i = 0; i < chars.length; i++) {
            System.out.print(chars[i]);
            for (int j = 0; j < fogs.length; j++) {
                System.out.print(" " + fogs[i][j]);
            }
            System.out.println();
        }
    }

    public int[] getCoordinates(String start, String end, char[] chars) {

        String[] coordStart = start.split("");
        String[] coordEnd = end.split("");

        int x1 = 0, y1 = 0, x2 = 0, y2 = 0;

        if (coordStart[0].equals(coordEnd[0])) {
            y1 = Integer.parseInt(coordStart[1]) - 1;
            y2 = Integer.parseInt(coordEnd[1]) - 1;
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == coordStart[0].charAt(0)) {
                    x1 = i;
                    x2 = i;
                }
            }
        } else if (coordStart[1].equals(coordEnd[1])) {
            y1 = Integer.parseInt(coordStart[1]) - 1;
            y2 = Integer.parseInt(coordEnd[1]) - 1;
            for (int i = 0; i < chars.length; i++) {
                if (coordStart[0].charAt(0) == chars[i]) {
                    x1 = i;
                } else if (coordEnd[0].charAt(0) == chars[i]) {
                    x2 = i;
                }
            }
        }


        return new int[]{x1, y1, x2, y2};
    }
}
