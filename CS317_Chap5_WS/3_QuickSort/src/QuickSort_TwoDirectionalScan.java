import java.util.Arrays;
import java.util.Random;

public class QuickSort_TwoDirectionalScan {
    
	/**
	 * quickSort(): quickSort using two-directional scan.
	 * @param arr
	 * @param left
	 * @param right
	 */
    public static void quickSort(int[] arr, int left, int right) {
    	System.out.println("quickSort(arr[" + left + ".." + right + "])");
        if (left < right) {//at least two elements in the array
            int pivotIndex = partition(arr, left, right);
            System.out.println("\tpivotIndex = " +  pivotIndex + "\n\t");
            printArray(arr, left, right);
            System.out.println();
            
            System.out.println("\tcall quickSort(arr[" + left + ".." + (pivotIndex-1) + "]\n");
            quickSort(arr, left, pivotIndex - 1);
            
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
//            quickSort(arr, left, pivotIndex - 1);
//            
//            quickSort(arr, pivotIndex + 1, right);
//        }
//    }//end of quicksort()
    
    /**
     * partition(): two-directional scanning. 
     * 		partition the array using a revised version of Hoare's partition. 
     * 		Use the leftmost element as the pivot.
     * @param arr
     * @param left
     * @param right
     * @return: position pivotIndex - 1.
     */

    public static int partition(int[] arr, int left, int right) {
        int pivot = arr[left];
        int i = left;
        int j = right + 1;
        
        System.out.println("\t---------");
        printArray(arr, left, right);
        System.out.println();
        
        while (true) {
        	//bi-directional scan
        	do {
        		i++;        		
        	}while( arr[i] < pivot && i < right); //if i == right, i++ will cause an outOfBoundary error.
        	
        	do {
        		j--;        		
        	}while( arr[j] > pivot && j > left); //if j == left, j-- will cause an outOfBoundary error.
        	
            if (i >= j) { //i and j meet. Array is exhausted. Stop two=directional scanning.
                break;
            }
            
            System.out.println("\ti = " + i + ", j = " + j);
            printArray(arr, left, right);
            System.out.println();
            
            swap(arr, i, j); //swap arr[i] and arr[j], and continue to scan      
            
            System.out.println("\tswap A["+ i + "] and A[" +j + "]");
            printArray(arr, left, right);
            System.out.println();
            
        }//end while
        
        swap(arr, left, j); //swap arr[left] (the pivot) with arr[j], last element in the <= pivot section.
        
        System.out.println("\ti = " + i + ", j = " + j);
        printArray(arr, left, right);
        System.out.println();
        
        return j;
    }//end of partition
    
    public static int partition_nocomment(int[] arr, int left, int right) {
        int pivot = arr[left];
        int i = left;
        int j = right + 1;
        
        while (true) {
        	//bi-directional scan
        	do {
        		i++;        		
        	}while( arr[i] < pivot && i < right); //if i == right, i++ will cause an outOfBoundary error.
        	
        	do {
        		j--;        		
        	}while( arr[j] > pivot && j > left); //if j == left, j-- will cause an outOfBoundary error.
        	
            if (i >= j) { //i and j meet. Array is exhausted. Stop two=directional scanning.
                break;
            }
            
            swap(arr, i, j); //swap arr[i] and arr[j], and continue to scan       
            
        }//end while
        
        swap(arr, left, j); //swap arr[left] (the pivot) with arr[j], last element in the <= pivot section.
        
        return j;
    }//end of partition
    /**
     * partition_hoare(): Hoare's partition. Pivot is not swapped into its final position. 
     * 					  Instead, the pivot is left in one of the two subarrays, no element 
     * 					  is fixed in its final position.
     * @param arr
     * @param left
     * @param right
     * @return
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
//                return j; 
                return j+1; //j+1: pivotIndex
            }
            
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            
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
    
    
    
    /**
     * insertion sort
     * @param arr
     */
    public static void insertionSort(int[] arr, int left, int right) {
        for (int i = left + 1; i <= right ; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }//end insertionSort()
    
    public static void main(String[] args) {
//        int[] arr = {5, 2, 9, 3, 1, 6, 8, 7, 4};
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
    
//TODO: Revise your program and make use of the following run() method to  
//		compare quickSort, quickInsertionSort and insertionSort.
//		You need to create a quickInsertionSort() method based on the 
//		following idea:
    
//     		Note that there are many small subarrays generated during 
//     		the quicksort() process, which has extra costs due to a large 
//     		number of method calls. Therefore, it pays to switch to 
//     		insertion sort for tiny subarrays. A simple change is to do
//     			
//     			if (size of the current array is < cutoff value) {
//     				insertionSort(arr, left, right)
//     			}
//    		Try different cutoff values, e.g., values from 1 to 50 and 
//    		see which value(s) improve the performance the most. 
	
    
//    public static void run(String algorithm) {
//    	long startTime = System.nanoTime();
//    	
//    	for (int n = 0; n < 10; n++) {
//	   	 	int[] arr = new int[50000];
//	
//	        Random random = new Random(123);//random seed: 123
//	
//	        for (int i = 0; i < 50000; i++) {
//	            arr[i] = random.nextInt(100000);
//	        }
//	        switch (algorithm) {
//	        	case "QuickSort":
//	        		quickSort(arr, 0, arr.length-1);
//	        		break;
//	        	case "QuickInsertionSort":
//	        		quickInsertionSort(arr, 0, arr.length-1);
//	        		break;
//	        	case "InsertionSort":
//	        		insertionSort(arr, 0, arr.length-1);
//	        		break;       	
//	        }//end switch
//    	}//end for
//         long endTime = System.nanoTime();
//         long totalTime = endTime - startTime;
//         System.out.println("Running time for " + algorithm + " for 50,000 elements: " + totalTime/1000000 + " ms");
//         System.out.println();
//    }
    
}//end of class.
