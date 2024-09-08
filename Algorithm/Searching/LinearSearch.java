public class LinearSearch {

    // Method to perform linear search
    public static int linearSearch(int[] arr, int target) {
        // Iterate through each element in the array
        for (int i = 0; i < arr.length; i++) {
            // Check if the current element matches the target
            if (arr[i] == target) {
                return i; // Return the index of the target element
            }
        }
        return -1; // Return -1 if the target is not found
    }

    public static void main(String[] args) {
        int[] numbers = {3, 5, 7, 9, 11, 13, 15};
        int target = 9;

        int result = linearSearch(numbers, target);

        if (result == -1) {
            System.out.println("Element not found in the array.");
        } else {
            System.out.println("Element found at index: " + result);
        }
    }
}
