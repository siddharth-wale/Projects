
public class QuickSort implements Sort{

	int[] a;
	
	@Override
	public int[] sort(int[] arr) {
	      a=arr;
	      quickSort(0,a.length-1);
	      return a;
	}
	
	public void quickSort(int lI, int hI){
	      int i=lI;
	      int j=hI;
	      int pivot=a[i+(j-i)/2];
	      while(i<=j){
	          while(a[i]<pivot){
	              i++;
	          }
	          while(a[j]>pivot){
	              j--;
	          }
	          if(i<=j){
	              int temp=a[i];
	              a[i]=a[j];
	              a[j]=temp;
	              i++;
	              j--;
	          }
	      }
	      if(lI<j)
	          quickSort(lI, j);
	      if(i<hI)
	          quickSort(i, hI);
	    }

}
