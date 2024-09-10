public class InterpolationSearch {

    // Function to perform interpolation search
    public static int interpolationSearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high && target >= arr[low] && target <= arr[high]) {
            // Check if the array has only one element
            if (low == high) {
                if (arr[low] == target) {
                    return low;
                }
                return -1;
            }

            // Estimate the position using interpolation formula
            int pos = low + ((target - arr[low]) * (high - low) / (arr[high] - arr[low]));

            // If the target is found at the estimated position
            if (arr[pos] == target) {
                return pos;
            }

            // If the target is larger, ignore the left part
            if (arr[pos] < target) {
                low = pos + 1;
            } 
            // If the target is smaller, ignore the right part
            else {
                high = pos - 1;
            }
        }

        // Target not found
        return -1;
    }

}
