package root.solution;

/**
 *  12.272
 * Given a two-dimensional array 5 * 5, filled with letters.
 * Print a word, built by array elements marked with stars while reading them:
 *      A) Left to right in every row
 *      B) Up to down in every column
 *
 *       0   1   2   3   4
 *   0   *       *       *
 *   1       *       *
 *   2   *       *       *
 *   3       *       *
 *   4   *       *       *
 */

public class Task12x272 extends AbstractTask {
    private String resultA;
    private String resultB;

    public Task12x272() {
        dataArray = fillArray();
        resultA = resolveTaskA(dataArray);
        resultB = resolveTaskB(dataArray);
    }

    public String getResultA() {
        return resultA;
    }

    public String getResultB() {
        return resultB;
    }

    public String getResult() {
        return "\n\tA) " + getResultA() + "\n\tB) " + getResultB();
    }

    /**
     * @return a word, built by array elements marked with stars while reading them:
     *  *      A) Left to right in every row
     */
    public String resolveTaskA(Character[][] array) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (i % 2 == 0) {
                    if (j % 2 == 0) {
                        stringBuilder.append(array[i][j]);
                    }
                } else {
                    if (j % 2 != 0) {
                        stringBuilder.append(array[i][j]);
                    }
                }
            }
        }
        return stringBuilder.toString();
    }

    /**
     * @return a word, built by array elements marked with stars while reading them:
     *  *      B) Up to down in every column
     */
    public String resolveTaskB(Character[][] array) {
        Character[][] localArray = turnArray90DegreesRight(array);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < localArray.length; i++) {
            for (int j = localArray[i].length - 1; j >= 0; j--) {
                if (i % 2 == 0) {
                    if (j % 2 == 0) {
                        stringBuilder.append(localArray[i][j]);
                    }
                } else {
                    if  (j % 2 != 0) {
                        stringBuilder.append(localArray[i][j]);
                    }
                }
            }
        }
        return stringBuilder.toString();
    }
}