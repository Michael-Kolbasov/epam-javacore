package launch;
import java.util.Arrays;
import algorithms.BinarySearch;
import algorithms.BubbleSort;
import algorithms.MergeSort;
import algorithms.QuickSort;
import algorithms.RadixSort;

public class AppLauncher {

    public void launch() {
        ArrayInput input = new ArrayInput();
        System.out.println("Input array is: " + Arrays.toString(input.getArrayToSort()));
        System.out.println();

        System.out.println("Bubble sort result:");
        int[] bubbleSortResult = new BubbleSort().sort(input.getArrayToSort());
        System.out.println(Arrays.toString(bubbleSortResult));
        System.out.println();

        System.out.println("Binary search result:");
        System.out.println(new BinarySearch().search(bubbleSortResult));
        System.out.println();

        System.out.println("Merge sort result:");
        int[] mergeSortResult = input.getCopyOfInputArray();
        new MergeSort().sort(mergeSortResult);
        System.out.println(Arrays.toString(mergeSortResult));
        System.out.println();

        System.out.println("Radix sort result:");
        int[] radixSortResult = input.getCopyOfInputArray();
        new RadixSort().sort(radixSortResult);
        System.out.println(Arrays.toString(radixSortResult));
        System.out.println();

        System.out.println("Quick sort result:");
        int[] quickSortResult = input.getCopyOfInputArray();
        new QuickSort().sort(quickSortResult);
        System.out.println(Arrays.toString(quickSortResult));
    }
}