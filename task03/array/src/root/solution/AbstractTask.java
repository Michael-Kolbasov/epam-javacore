package root.solution;

/**
 * A superclass for all Tasks.
 * {@code dataArray} and {@code result} are common fields that are used by constructors in all subclasses.
 */
abstract class AbstractTask {
    protected Character[][] dataArray;
    protected String result;

    /**
     * Used by all subclasses.
     * @return a Character[5][5] with first symbol 'a' and last symbol 'y'.
     */
    public Character[][] fillArray() {
        Character[][] array = new Character[5][5];
        Character input = 'a';
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = input;
                input++;
            }
        }
        return array;
    }

    public String getResult() {
        return result;
    }

    /**
     * Used by Task12x272 and Task12x274. Works for 2D arrays with equal sizes.
     * @param array Character[5][5] array
     * @return      new array with same content but with different indexes.
     *              [0][0] -> [0][4], [0][1] -> [1][4];
     *              [1][0] -> [0][3], [1][1] -> [1][3];
     *              and so on.
     */
    public Character[][] turnArray90DegreesRight(Character[][] array) {
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