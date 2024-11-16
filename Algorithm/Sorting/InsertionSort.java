public class InsertionSort {

    // Method to perform insertion sort
    public static void insertionSort(int[] arr) {
        int n = arr.length;

        // Traverse from the second element to the end
        for (int i = 1; i < n; i++) {
            int key = arr[i]; // The element to be inserted
            int j = i - 1;

            // Shift elements of the sorted portion of the array
            // that are greater than the key to one position ahead
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            // Place the key in its correct position
            arr[j + 1] = key;
        }
    }

    // Helper method to print the array
    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    // Main method to test the sorting algorithm
    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};
        System.out.println("Original array:");
        printArray(arr);

        insertionSort(arr);

        System.out.println("Sorted array:");
        printArray(arr);
    }
}

