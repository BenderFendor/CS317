
public class CountInversion {
	public static void main(String[] args) {
		int[] arr = {8, 5, 2, 6, 1, 3, 9};
		int[] arr1 = {5, 4, 3, 2, 1};
		System.out.println(inversionCounting1(arr, 0, 6));
	}
	
	public static int inversionCounting(int[] a) {
		int inversionCount = 0;
		for (int i = 0; i <= a.length - 2; i++) {
			for (int j = i + 1; j <= a.length - 1; j++) {
				if (a[i] > a[j]) {//an inversed pair
					inversionCount++;
				}
			}//for
		}//for
		
		return inversionCount;
	}//end inversionCount()

	public static int inversionCounting1(int[] a, int left, int right) {
		int mid = (left + right)/2;
		if (left == right) {
			return 0;
		}
		else {
			//left subarray: a[left.. mid]; 
			int leftCount = inversionCounting1(a, left, mid);
			
			//right subarray: a[mid+ 1.. right]
			int rightCount = inversionCounting1(a, mid + 1, right);
			
			int crossCount = inversionCrosscount(a, left, mid, right);
			
			return leftCount + rightCount + crossCount;
		
		}
	}//end inversionCount()
	
	public static int inversionCrosscount(int[] a, int left, int mid, int right) {
		int reverseCount = 0;
		for (int i = left; i <= mid; i++) {
			for (int j = mid+1; j<= right; j++) {
				if (a[i] > a[j]) {
					reverseCount++;
				}
			}
		}
		return reverseCount;
	}
}









