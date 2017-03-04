package sorting;

/**
 * Created by xiezhuohan on 12/24/16.
 */


public class Sort {

    /*
        O(n^2) Ω(n) θ(n^2)
        advantages: stable, in place, simple
    */
    public void bubbleSort(int[] nums) {
        boolean swapped;
        for (int i = 0; i < nums.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    swapped = true;
                }
            }
            //if no elements are swapped, then break
            if (!swapped) {
                break;
            }
            try {

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /*
        O(n^2) Ω(n) θ(n^2)
        stable, in place, online
        Insertion sort is used when number of elements is small.
        It can also be useful when input array is almost sorted, only few elements are misplaced in complete big array.
        We can use binary search to reduce the number of comparisons in normal insertion sort.
     */
    public void insertionSort(int nums[]) {
        for (int i = 1; i < nums.length; i++) {
            insert(nums, i);
        }
    }

    private void insert(int arr[], int i) {
        int target = arr[i];
        int j = i - 1;
        while (j >= 0 && arr[j] > target) {
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = target;
    }


    /*
        O(n^2) Ω(n^2) θ(n^2)
        The good thing about selection sort is it never makes more than O(n) swaps and can be useful when memory write is a costly operation.
    */
    public void selectionSort(int nums[]) {
        // One by one move boundary of unsorted subarray
        for (int i = 0; i < nums.length - 1; i++) {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[min_idx]) {
                    min_idx = j;
                }
            }
            // Swap the found minimum element with the first element
            int temp = nums[min_idx];
            nums[min_idx] = nums[i];
            nums[i] = temp;
        }
    }

    /*
        Ω(n log(n))	θ(n log(n))	O(n log(n))
     */
    public void heapSort(int[] nums) {
        // Build heap (rearrange array) build a max-heap bottom up
        int n = nums.length;
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            heapify(nums, n, i);
        }

        // One by one extract an element from heap
        for (int i=n-1; i>=0; i--)
        {
            // Move current root to end
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;

            // call max heapify on the reduced heap
            heapify(nums, i, 0);
        }
    }

    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    private void heapify(int arr[], int n, int i) {
        int largest = i;  // Initialize largest as root
        int l = 2*i + 1;  // left = 2*i + 1
        int r = 2*i + 2;  // right = 2*i + 2

        // If left child is larger than root
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest])
            largest = r;

        // If largest is not root
        if (largest != i)
        {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }


    public void quickSort(int[] nums, int low, int high) {
        if (low < high) {
            int p = partition(nums, low, high);

            //recursively sort elements before and after partition
            quickSort(nums, low, p-1);
            quickSort(nums, p+1, high);
        }
    }

    // Lomuto partition scheme
    private int partition(int[] nums, int low, int high) {
        int i = low - 1;    //index of smaller element
        int pivot = nums[high];

        for (int j=low; j<high; j++) {
            if (nums[j] <= pivot) {
                i++;
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
            }
        }
        nums[high] = nums[i+1];
        nums[i+1] = pivot;
        return i+1;
    }
}
