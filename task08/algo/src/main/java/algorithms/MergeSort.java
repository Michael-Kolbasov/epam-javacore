package algorithms;

/**
 * A Merge sort realization class.
 */
public class MergeSort {
    private int[] inputArray;
    private int[] helperArray;

    public void sort(int[] target) {
        inputArray = target;
        helperArray = new int[target.length];
        mergeSort(0, target.length - 1);
    }

    private void mergeSort(int lowerBound, int higherBound) {
        if (lowerBound >= higherBound) {
            return;
        }
        int middleBound = lowerBound + (higherBound - lowerBound) / 2;
        mergeSort(lowerBound, middleBound);
        mergeSort(middleBound + 1, higherBound);
        merge(lowerBound, middleBound + 1, higherBound);
    }

    private void merge(int lowerBound, int middleBound, int higherBound) {
        int leftEnd = middleBound - 1;
        int tmpIndex = lowerBound;

        while (lowerBound <= leftEnd && middleBound <= higherBound) {
            if (inputArray[lowerBound] < inputArray[middleBound]) {
                helperArray[tmpIndex++] = inputArray[lowerBound++];
            } else {
                helperArray[tmpIndex++] = inputArray[middleBound++];
            }
        }

        while (lowerBound <= leftEnd) {
            helperArray[tmpIndex++] = inputArray[lowerBound++];
        }

        while (higherBound >= 0) {
            inputArray[higherBound] = helperArray[higherBound--];
        }
    }
}