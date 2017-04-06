
public class SelectionSort implements Sort {

	@Override
	public int[] sort(int[] arr) {
		int n = arr.length;
		 for(int i=0; i<n-1 ; i++){
			 int mid = i;
			 for(int j=i+1;j<n;j++){
				 if(arr[mid]>arr[j]){
					 mid =j;
				 }
				 
			 }
			 int temp = arr[mid];
			 arr[mid] = arr[i];
			 arr[i] = temp;
		 }
		 return arr;
	}
}
