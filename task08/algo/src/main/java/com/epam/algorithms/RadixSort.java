package com.epam.algorithms;

import java.util.Arrays;

/**
 * A Radix sort realization class.
 */
public class RadixSort {

    public void sort(int[] target) {
        radixSort(target);
    }

    private void radixSort(int[] target) {
        int maxNumber = getMaxNumber(target);

        for (int rank = 1; maxNumber / rank > 0; rank *= 10) {
            countSort(target, rank);
        }
    }

    private void countSort(int[] target, int rank) {
        int[] outputArray = new int[target.length];
        int i;
        int[] count = new int[10];
        Arrays.fill(count, 0);

        for (i = 0; i < target.length; i++) {
            count[(target[i] / rank) % 10]++;
        }

        for (i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (i = target.length - 1;i >= 0 ; i--) {
            outputArray[count[(target[i] / rank) % 10] - 1] = target[i];
            count[(target[i] / rank) % 10]--;
        }

        for (i = 0; i < target.length; i++) {
            target[i] = outputArray[i];
        }
    }

    private int getMaxNumber(int[] target) {
        int maxNumber = target[0];
        for (int i = 1; i < target.length; i++) {
            if (maxNumber < target[i]) {
                maxNumber = target[i];
            }
        }
        return maxNumber;
    }
}
