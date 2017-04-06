import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Sorting {

	public static final Random gen = new Random();
	
	public static void printArray(int arr[]){
		System.out.println(Arrays.toString(arr));
	}

	public static int[] shuffle (int[] arr) {
	    int n = arr.length;
	    while (n > 1) {
	        int k = gen.nextInt(n--);
	        int temp = arr[n];
	        arr[n] = arr[k];
	        arr[k] = temp;
	    }
	    return arr;
	}
	
	public static int[] createArray(int input){
		int [] a = new int [input];
		for(int i=0; i<input; i++){
			a[i] = gen.nextInt(input);
		}
		return a;
	}
	
	public static void main(String args[]){
		System.out.println("Please Enter Input to generate array");
		Scanner in = new Scanner(System.in);
		int input = in.nextInt();
		in.close();
		
		int[] array = createArray(input);
		
//		Arrays.sort(array);

		int[] quickArray = array.clone();

		int[] insertionArray =array.clone();
		int[] heapArray =array.clone();
		int[] selectionArray =array.clone();
		int[] mergeArray =array.clone();
		int[] combineArray =array.clone();
		
		System.out.println("Generated Array");
		
		printArray(array);
		
//		Arrays.sort(array);
		
		long sumTime =0l;
		
		QuickSort qs = new QuickSort();
		for(int i=0; i<10;i++){
			long startTime = System.nanoTime();
			int[] tempQuick = shuffle(quickArray);
			qs.sort(tempQuick);
			long stopTime = System.nanoTime();
//			long elapsedTime = (stopTime - startTime)/1000000;
			long elapsedTime = (stopTime - startTime);
			sumTime = sumTime +elapsedTime;
			quickArray=tempQuick.clone();
		}
		System.out.println("Average Execution Time for Quick Sort : "+sumTime/10);
		System.out.println("Quick Sort");
		printArray(quickArray);
		
		

		long sumTime1 =0l;
		InsertionSort is = new InsertionSort();
		for(int i=0; i<10;i++){
			long startTime = System.nanoTime();
			int[] tempQuick = shuffle(insertionArray);
			is.sort(tempQuick);
			long stopTime = System.nanoTime();
//			long elapsedTime = (stopTime - startTime)/1000000;
			long elapsedTime = (stopTime - startTime);
			sumTime1 = sumTime1 +elapsedTime;
			insertionArray=tempQuick.clone();
		}
		System.out.println("Average Execution Time for Insertion Sort : "+sumTime1/10);
		System.out.println("Insertion Sort");
		printArray(insertionArray);
		
		long sumTime2 =0l;
		HeapSort hs = new HeapSort();
		for(int i=0; i<10;i++){
			long startTime = System.nanoTime();
			int[] tempQuick = shuffle(heapArray);
			hs.sort(tempQuick);
			long stopTime = System.nanoTime();
//			long elapsedTime = (stopTime - startTime)/1000000;
			long elapsedTime = (stopTime - startTime);
			sumTime2 = sumTime2 +elapsedTime;
			heapArray=tempQuick.clone();
		}
		System.out.println("Average Execution Time for Heap Sort : "+sumTime2/10);
		System.out.println("Heap Sort");
		printArray(heapArray);
		
		long sumTime3 =0l;
		SelectionSort ss = new SelectionSort();
		for(int i=0; i<10;i++){
			long startTime = System.nanoTime();
			int[] tempQuick = shuffle(selectionArray);
			ss.sort(tempQuick);
			long stopTime = System.nanoTime();
//			long elapsedTime = (stopTime - startTime)/1000000;
			long elapsedTime = (stopTime - startTime);
			sumTime3 = sumTime3 +elapsedTime;
			selectionArray=tempQuick.clone();
		}

		System.out.println("Average Execution Time for Selection Sort : "+sumTime3/10);
		System.out.println("Selection Sort");
		printArray(selectionArray);
		
		long sumTime4 =0l;
		MergeSort ms = new MergeSort();
		for(int i=0; i<10;i++){
			long startTime = System.nanoTime();
			int[] tempQuick = shuffle(mergeArray);
			ms.sort(tempQuick);
			long stopTime = System.nanoTime();
//			long elapsedTime = (stopTime - startTime)/1000000;
			long elapsedTime = (stopTime - startTime);
			sumTime4 = sumTime4 +elapsedTime;
			mergeArray=tempQuick.clone();
		}

		System.out.println("Average Execution Time for Merge Sort : "+sumTime4/10);
		System.out.println("Merge Sort");
		printArray(mergeArray);
		
		
		long sumTime5 =0l;
		CombineSort cs = new CombineSort();
		for(int i=0; i<10;i++){
			long startTime = System.nanoTime();
			int[] tempQuick = shuffle(combineArray);
			cs.sort(tempQuick);
			long stopTime = System.nanoTime();
//			long elapsedTime = (stopTime - startTime)/1000000;
			long elapsedTime = (stopTime - startTime);
			sumTime5 = sumTime5 +elapsedTime;
			combineArray=tempQuick.clone();
		}

		System.out.println("Average Execution Time for Combine Sort : "+sumTime5/10);
		System.out.println("Combine Sort");
		printArray(combineArray);
		
	}

}
