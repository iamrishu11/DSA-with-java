public class ExponentialSearch {

    // Method to perform binary search in a given range of the array
    private static int binarySearch(int[] arr, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid; // Target found
            }
            if (arr[mid] < target) {
                left = mid + 1; // Target is in the right half
            } else {
                right = mid - 1; // Target is in the left half
            }
        }
        return -1; // Target not found
    }

    // Method to perform exponential search
    public static int exponentialSearch(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1; // Array is empty
        }
        
        // If the target is at the first position
        if (arr[0] == target) {
            return 0;
        }

        // Find the range where the target could be present
        int i = 1;
        while (i < arr.length && arr[i] <= target) {
            i = i * 2;
        }

        // Perform binary search in the identified range
        int left = i / 2;
        int right = Math.min(i, arr.length - 1);
        return binarySearch(arr, left, right, target);
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 10, 40};
        int target = 10;
        int result = exponentialSearch(arr, target);

        if (result == -1) {
            System.out.println("Element not present in the array");
        } else {
            System.out.println("Element found at index " + result);
        }
    }
}
