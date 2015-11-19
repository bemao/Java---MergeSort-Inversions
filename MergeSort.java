public class mergeSort {
	
	long inversions;
	Integer[] nums;
	
	public mergeSort(Integer[] nums_in) {
		inversions = 0;
		nums = nums_in;
	}
	
	public void sort() {
		int hi = nums.length;
		sort(nums, 0, hi);
		
	}
	
	public void sort(Integer[] array, int lo, int hi){
		
		if (lo >= hi-1) {
			return;
		}
		
		int mid = (lo+hi)/2;
		
		sort(array, lo, mid);  //sorts the left half
		sort(array, mid, hi);  //sorts the right half
		
		merge(array, lo, hi);  //merges the two sorted halves
		
		
	}
	
	public void merge(Integer[] array, int lo, int hi){
		int[] temp = new int[hi - lo];
		
		int mid = (lo+hi)/2;
		
		int i = lo, j = mid, k = 0;
		
		while (i<mid && j < hi){
			if (array[i] < array[j]){
				temp[k] = array[i];
				i++;
			}
			else {
				temp[k] = array[j];
				j++;
				inversions += mid - i;
			}
			k++;
		}
		
		if (i >= mid){
			while (j < hi) {
				temp[k] = array[j];
				j++;
				k++;
			}
		}
		
		if (j >= hi) {
			while (i<mid) {
				temp[k] = array[i];
				i++;
				k++;
			}
		}
		
		int ctr = 0;
		for (int n = lo; n < hi; n++) {
			array[n] = temp[ctr];
			ctr++;
		}
		
	}
	

	public long get_inversions() {
		return inversions;
	}
