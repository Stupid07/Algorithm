import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		int[] arrayA = new int[N];
		int[] arrayB = new int[N];
		String[] stringA = reader.readLine().split(" ");
		String[] stringB = reader.readLine().split(" ");
		for(int i = 0; i< N; i++) {
			arrayA[i] = Integer.parseInt(stringA[i]);
			arrayB[i] = Integer.parseInt(stringB[i]);
		}
		
		MySort.sort(arrayA, true);
		MySort.sort(arrayB, false);
		int result = 0;
		for(int i= 0; i< N; i++) {
			result += arrayA[i] * arrayB[i];
		}
		System.out.println(result);
	}
	
	static class MySort {
		private static int[] tempArray;
		private static boolean isASC;
		public static void sort(int[] array, boolean sortType) {
			tempArray = new int[array.length];
			isASC = sortType;
			MyMergeSort(0,array.length-1, array);
		}
		
		private static void MyMergeSort(int start, int end, int[] array) {
			if(start < end) {
				int mid = (start+end)>>1;
				MyMergeSort(start, mid, array);
				MyMergeSort(mid+1, end, array);
				Merge(start, mid, end, array);
			}
		}
		
		private static void Merge(int start, int mid, int end, int[] array) {
			int left = start, right = mid+1, tempIdx = start;
			while(left <= mid && right <= end) {
				if((array[left] > array[right]) == isASC) {
					tempArray[tempIdx++] = array[right++];
				}else {
					tempArray[tempIdx++] = array[left++];
				}
			}
			
			if(left <= mid) {
				while(left <= mid) {
					tempArray[tempIdx++] = array[left++];
				}
			}else {
				while(right <= end) {
					tempArray[tempIdx++] = array[right++];
				}
			}
			
			for(int idx= start; idx <= end; idx++) {
				array[idx] = tempArray[idx];
			}
		}
	}
}