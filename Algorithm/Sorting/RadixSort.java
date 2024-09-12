import java.util.Arrays;

public class RadixSort {
    
    // Method to perform Radix Sort
    public static void radixSort(int[] arr) {
        // Find the maximum number to determine the number of digits
        int max = Arrays.stream(arr).max().orElse(0);
        
        // Perform counting sort for every digit. The exp is 10^i
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSortByDigit(arr, exp);
        }
    }
    
    // A function to do counting sort of arr[] according to the digit represented by exp
    private static void countingSortByDigit(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n]; // Output array that will have sorted numbers
        int[] count = new int[10]; // Count array for digit occurrence
        
        // Initialize count array with 0
        Arrays.fill(count, 0);
        
        // Store count of occurrences of (arr[i]/exp)%10
        for (int i = 0; i < n; i++) {
            int digit = (arr[i] / exp) % 10;
            count[digit]++;
        }
        
        // Change count[i] so that count[i] now contains actual position of this digit in output[]
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }
        
        // Build the output array
        for (int i = n - 1; i >= 0; i--) {
            int digit = (arr[i] / exp) % 10;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }
        
        // Copy the output array to arr[] so that arr[] contains sorted numbers
        System.arraycopy(output, 0, arr, 0, n);
    }
    
    // Main method to test the radix sort
    public static void main(String[] args) {
        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};
        System.out.println("Original array: " + Arrays.toString(arr));
        radixSort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}
