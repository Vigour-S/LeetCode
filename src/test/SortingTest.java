package test;

import org.junit.Test;
import sorting.Sort;

/**
 * Created by xiezhuohan on 12/24/16.
 */
public class SortingTest {

    int[] nums = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    int[] nums2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    @Test
    public void sortingTest() {
        Sort sort = new Sort();
        //sort.bubbleSort(nums);
        //sort.insertionSort(nums);
        //sort.selectionSort(nums);
        sort.heapSort(nums);
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }
}
