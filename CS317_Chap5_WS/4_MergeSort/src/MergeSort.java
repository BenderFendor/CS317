public class MergeSort {
	/**
	 * MergeSort()
	 * @param arr
	 * @param left
	 * @param right
	 */
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            System.out.println("middle = " + middle);
            
            System.out.println("mergeSort(arr, " + left + ", " + middle + ")");
            mergeSort(arr, left, middle);
            
            System.out.println("mergeSort(arr, " + (middle + 1) + ", " + right + ")");
            mergeSort(arr, middle + 1, right);

            System.out.println("merge(arr, " + left + ", " + middle + ", " + right + ")");
            merge(arr, left, middle, right);
        }
    }//end of mergeSort()

    /**
     * merge(): combine two sorted subarray arr[left..middle] and arr[middle+1 .. right]
     * @param arr
     * @param left
     * @param middle
     * @param right
     */
    private static void merge(int[] arr, int left, int middle, int right) {
        int[] temp = new int[arr.length];
        //copy array A to a temporary array temp
        for (int i = left; i <= right; i++) { //save the current array to temp
            temp[i] = arr[i];
        }

        int i = left;
        int j = middle + 1;
        int k = left;

        //scan the first and second half of temp simultaneously and put smaller element into arr
        while (i <= middle && j <= right) {
            if (temp[i] <= temp[j]) {
                arr[k] = temp[i];
                i++;
            } else {
                arr[k] = temp[j];
                j++;
            }
            k++;
        } //done scanning. One subarray is exhausted.

        while (i <= middle) { //if second half of temp is exhausted, copy the remaining
        					  //part of the first half of temp to arr
            arr[k] = temp[i];
            k++;
            i++;
        }
        //otherwise, the first half of temp is exhausted, and no need to copy the remaining
        //part of the second half of temp to arr, since they are already there.
        printArray(arr, left, right);
    }//end of merge()
    
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
//        int[] arr = {  5, 4, 8, 9, 10, 7, 6 };
        int[] arr = {  5, 4, 8, 9, 3, 7, 6 };
        int n = arr.length;

        System.out.println("Original array:");
        printArray(arr, 0, arr.length-1);
       
        mergeSort(arr, 0, n - 1);

        System.out.println("\nSorted array:");
        printArray(arr, 0, arr.length-1);
    }//end of main()
}//end of class MergeSort
