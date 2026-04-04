/**
 * Hoare's original quicksort. 
 * Implement a version of Hoare's original quicksort algorithm. It's similar to the two-way partitioning algorithm in QuickSort_TwoDirectionalScan.java 
 * except that the pivot is not swapped into its final position. Instead, the pivot is left in one of the two subarrays, no element 
 * is fixed in its final position, and the two subarrays where the pointers cross are sorted recursively.
 */
import java.util.Arrays;

public class QuickSort_HoarePartition {
    
	/**
	 * 
	 * @param arr
	 * @param left
	 * @param right
	 */
    public static void quickSort(int[] arr, int left, int right) {
    	System.out.println("quickSort(arr[" + left + ".." + right + "])");
        if (left < right) {
            int pivotIndex = partition_hoare(arr, left, right);
            System.out.println("\tpivotIndex = " +  pivotIndex);
            
            System.out.println("\tcall quickSort(arr[" + left + ".." + pivotIndex + "]\n");
            quickSort(arr, left, pivotIndex);
            
            System.out.println("\tcall quickSort(arr[" + (pivotIndex+1) + ".." + right + "]\n");
            quickSort(arr, pivotIndex + 1, right);
        }
        System.out.println();
    }//end of quicksort()
    
//    public static void quickSort_noComment(int[] arr, int left, int right) {
//    	 
//        if (left < right) {
//            int pivotIndex = partition(arr, left, right);
//            
//            quickSort(arr, left, pivotIndex);
//            
//            quickSort(arr, pivotIndex + 1, right);
//        }
//    }//end of quicksort()
    
    /**
     * partition the array using Hoare's partition. pivot is the leftmost element.
     * @param arr
     * @param left
     * @param right
     * @return: position pivotIndex - 1.
     */

  
    public static int partition_hoare(int[] arr, int left, int right) {
        int pivot = arr[left];
        int i = left - 1;
        int j = right + 1;
        
        System.out.println("\t---------");
        printArray(arr, left, right);
        System.out.println();
        
        while (true) {
            do {
                i++;
            } while (arr[i] < pivot);
            
            do {
                j--;
            } while (arr[j] > pivot);
            
            if (i >= j) {
            	System.out.println("\ti = " + i + ", j = " + j);
                printArray(arr, left, right);
                System.out.println();
                return j; 
            }
            
            swap(arr, i, j);
            
            System.out.println("\ti = " + i + ", j = " + j);
            printArray(arr, left, right);
            System.out.println();
        }
    }//end of partition
    
    
    private static void swap(int[] arr, int i1, int i2) {
    	 int temp = arr[i1];
         arr[i1] = arr[i2];
         arr[i2] = temp;
    }
    
    private static void printArray(int[] arr, int left, int right) {
	    System.out.print("\t ");
	  	for(int i = left; i <= right; i++) {
	    	System.out.print(i + " ");
	    }
	  	System.out.println();
	  	
	  	System.out.print("\t[");
	  	for(int i = left; i <= right; i++) {
	    	System.out.print(arr[i] + " ");
	    }
	    System.out.println("]");
  }
    public static void main(String[] args) {
        //int[] arr = {5, 2, 9, 3, 1, 6, 8, 7, 4};
//        int[] arr = {5, 2, 9, 3, 1, 6, 8, 4, 7};
//        int[] arr = {5, 2, 9, 3, 1, 6, 8, 5, 7};
          int[] arr = {5, 5, 9, 3, 5, 6, 8, 5, 7 };
        
        System.out.println("Original array: ");
        printArray(arr, 0, arr.length - 1);
        System.out.println();
        
        quickSort(arr, 0, arr.length-1);
        
        System.out.println("Sorted array: ");
        System.out.println(Arrays.toString(arr));
    }
}
