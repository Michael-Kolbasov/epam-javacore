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
}