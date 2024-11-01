public class CountingSort {
    
    public static void countingSort(int[] array) {
        if (array.length == 0) {
            return;
        }

        // Find the maximum value in the array
        int max = findMax(array);

        // Create a count array and initialize it
        int[] count = new int[max + 1];

        // Count the occurrences of each element
        for (int num : array) {
            count[num]++;
        }

        // Modify the count array to store the cumulative counts
        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }

        // Create an output array to hold sorted elements
        int[] output = new int[array.length];

        // Place the elements in the output array based on cumulative counts
        for (int i = array.length - 1; i >= 0; i--) {
            output[count[array[i]] - 1] = array[i];
            count[array[i]]--;
        }

        // Copy the sorted elements back into the original array
        System.arraycopy(output, 0, array, 0, array.length);
    }

    private static int findMax(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] array = {4, 2, 2, 8, 3, 3, 1};
        countingSort(array);
        System.out.println("Sorted array: " + java.util.Arrays.toString(array));
    }
}
