public class BubbleSort {                    
               
    // Method to perform Bubble Sort        
    public static void bubbleSort(int[] arr) {       
        int n = arr.length;     
        boolean swapped;   
          
        // Traverse through all elements in the array 
        for (int i = 0; i < n - 1; i++) {
            swapped = false; 
            
            // Last i elements are already in place
            for (int j = 0; j < n - i - 1; j++) {
                // Swap if the element found is greater than the next element
                if (arr[j] > arr[j + 1]) {
                    
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                   arr[j + 1] = temp;
                    swapped = true;
                }
            }
            // If no two elements were swapped by inner loop, then break
            if (!swapped) {
                break;
            }
        }
    }

    // Method to print the array
    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        
        System.out.println();
    }

    // Main method to test the Bubble Sort implementation
    public static void main(String[] args) {
        int[] array = {64, 34, 25, 12, 22, 11, 90};

        System.out.println("Original array:");
        printArray(array);

        bubbleSort(array);

        System.out.println("Sorted array:");
        printArray(array);
    }
}
