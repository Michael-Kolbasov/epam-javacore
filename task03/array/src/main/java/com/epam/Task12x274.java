package com.epam;

/**
 *  12.274
 * Print words, built by odd elements of every array column.
 */
public class Task12x274 extends AbstractTask implements ArrayTurner {

    public Task12x274() {
        dataArray = fillArray();
        result = resolveTask(dataArray);
    }

    /**
     * @return words, built by odd elements of every array column.
     */
    public String resolveTask(Character[][] array) {
        Character[][] localArray = turnArray90DegreesClockwise(array);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < localArray.length; i++) {
            for (int j = localArray[i].length - 1; j >= 0; j--) {
                if (j % 2 != 0) {
                    stringBuilder.append(localArray[i][j]);
                }
            }
        }
        return stringBuilder.toString();
    }
}