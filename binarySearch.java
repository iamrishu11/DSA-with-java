public class BinarySearch {

    // Method to perform binary search on a sorted array
    public static int binarySearch(int[] arr, int target) {
        int left = 0;         // Start index of the search range
        int right = arr.length - 1; // End index of the search range

        // Continue searching while the search range is valid
        while (left <= right) {
            int mid = left + (right - left) / 2; // Calculate the middle index

            // Check if the target is at the middle index
            if (arr[mid] == target) {
                return mid; // Target found, return its index
            }

            // If the target is greater than the middle element,
            // ignore the left half by adjusting the left index
            if (arr[mid] < target) {
                left = mid + 1;
            }
            // If the target is smaller than the middle element,
            // ignore the right half by adjusting the right index
            else {
                right = mid - 1;
            }
        }

        // Target is not present in the array
        return -1;
    }

    // Main method to test the binary search implementation
    public static void main(String[] args) {
        int[] sortedArray = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        int target = 7;

        // Perform binary search
        int result = binarySearch(sortedArray, target);

        // Output the result
        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found in the array.");
        }
    }
}

