import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucketSort {

    // Function to perform bucket sort
    public static void bucketSort(float[] array) {
        if (array.length <= 0) return;

        // Step 1: Create buckets
        int n = array.length;
        List<Float>[] buckets = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<>();
        }

        // Step 2: Insert elements into buckets
        for (float num : array) {
            int bucketIndex = (int) (num * n);
            if (bucketIndex >= n) {
                bucketIndex = n - 1;
            }
            buckets[bucketIndex].add(num);
        }

        // Step 3: Sort each bucket and concatenate results
        int index = 0;
        for (List<Float> bucket : buckets) {
            Collections.sort(bucket);
            for (float num : bucket) {
                array[index++] = num;
            }
        }
    }

    // Main method to test bucket sort
    public static void main(String[] args) {
        float[] array = {0.42f, 0.32f, 0.54f, 0.22f, 0.74f, 0.12f, 0.63f};
        System.out.println("Original array:");
        for (float num : array) {
            System.out.print(num + " ");
        }
        System.out.println();

        bucketSort(array);

        System.out.println("Sorted array:");
        for (float num : array) {
            System.out.print(num + " ");
        }
    }
}
