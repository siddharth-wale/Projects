
public class CombineSort implements Sort{

	int[] a;
	@Override
	public int[] sort(int[] arr) {
		a=arr;
	      quickSort(a,0,a.length-1);
	      return a;
	}
	
	public void quickSort(int arr[], int low, int high)
    {
		if (low < high)
        {
            // Insertion Sort Starts!
            if ((high - low) < 9)
            {
                this.InsertionSort(arr, low, high + 1);
            }
            // Merge Sort Starts!
            else
            {
                int pi = this.partition(arr, low, high);
                this.quickSort(arr, low, pi - 1);
                this.quickSort(arr, pi + 1, high);
            }
        }
    }
	public void InsertionSort(int[] arr, int start, int end)
    {
        for (int i = start + 1; i < end; i++)
        {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && key < arr[j])
            {
            	arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
	int partition(int arr[], int low, int high)
    {
        int pivot = arr[high]; 
        int i = (low-1);
        for (int j=low; j<=high-1; j++)
        {

            if (arr[j] <= pivot)
            {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
 
        return i+1;
    }
}
