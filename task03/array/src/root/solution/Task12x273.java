package root.solution;

/**
 *  12.273
 * Print words, built by even elements of every array row.
 */
public class Task12x273 extends AbstractTask {

    public Task12x273() {
        dataArray = fillArray();
        result = resolveTask(dataArray);
    }

    /**
     * @return words, built by even elements of every array row.
     */
    public String resolveTask(Character[][] array) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (j % 2 == 0) {
                    stringBuilder.append(array[i][j]);
                }
            }
        }
        return stringBuilder.toString();
    }
}