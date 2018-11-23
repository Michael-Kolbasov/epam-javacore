package com.epam;

public interface ArrayTurner {
    /**
     * Used by Task12x272 and Task12x274. Works for 2D arrays with equal sizes.
     * @param array Character[5][5] array
     * @return      new array with same content but with different indexes.
     *              [0][0] -> [0][4], [0][1] -> [1][4];
     *              [1][0] -> [0][3], [1][1] -> [1][3];
     *              and so on.
     */
    default Character[][] turnArray90DegreesClockwise(Character[][] array) {
        Character[][] localArray = new Character[array.length][];
        int column = localArray.length;
        int row = 0;
        for (int i = 0; i < localArray.length; i++) {
            localArray[i] = new Character[array[i].length];
            for (int j = 0; j < localArray[i].length; j++) {
                column--;
                localArray[i][j] = array[column][row];
            }
            column = localArray.length;
            row++;
        }
        return localArray;
    }
}