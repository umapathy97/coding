	public static void quickSort(int[] nums, int l, int h) {
	    if (l >= h)
	     return;
	     
	    int partitionIndex = partition(nums, l, h);
	    quickSort(nums, l, partitionIndex - 1);
	    quickSort(nums, partitionIndex + 1, h);
	}
	
	private static int partition(int[] nums, int low, int high) {
	    int pivot = nums[high];
	    int partitionIndex = low;
	    for (int i = low; i < high; i++) {
	        if (nums[i] < pivot) {
	           swap(nums, partitionIndex, i);
	           partitionIndex++;
	        }
	    }
	    
	    swap(nums, high, partitionIndex);
	    return partitionIndex;
	    
	}
	
	private static void swap(int[] arr, int a, int b) {
	    int temp = arr[a];
	    arr[a] = arr[b];
	    arr[b] = temp;
	}
