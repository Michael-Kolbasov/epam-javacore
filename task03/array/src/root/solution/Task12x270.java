package root.solution;

/**
 * 12.270
 * Print a string made of four characters from corners of an array (in any order).
 */

public class Task12x270 extends AbstractTask {

    Task12x270() {
        dataArray = fillArray();
        result = resolveTask(dataArray);
    }

    /**
     * @param array Character[5][5] array made by {@link AbstractTask#fillArray()}.
     * @return      String made of four characters from corners of the array.
     *              Order is clockwise and starts from top left corner.
     */
    public String resolveTask(Character[][] array) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if ((i == 0 || i == array[i].length - 1) && ((j == 0) || (j == array[i].length - 1))) {
                    stringBuilder.append(array[i][j]);
                }
            }
        }
        return result = stringBuilder.toString();
    }
}