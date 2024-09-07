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