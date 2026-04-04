public class BinarySearch {
	/**
	 * 
	 * @param arr: a sorted array
	 * @param key: search key
	 * @return location of the key; -1 if not found
	 */
    public static int binarySearch(int[] arr, int key) {
        int left = 0;
        int right = arr.length - 1;
        int countComparisons = 0;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            countComparisons++;
            
            if (arr[mid] == key) {
            	System.out.println(countComparisons + " comparisons. ");
                return mid;
            } else if (arr[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        System.out.println(countComparisons + " comparisons. ");
        
        return -1; // target not found
    }//end of binarySearch()
    
    public static void main(String[] args) {
        int[] arr = { 3, 14, 27, 31, 39, 42, 55, 60, 74, 81, 85, 93, 98 }; 
        int searchKey = 74;
        int index = binarySearch(arr, searchKey);
        if (index == -1) {
            System.out.println("Target not found.");
        } else {
            System.out.println("Target found at index " + index);
        }
    }
}//end of class BinarySearch
