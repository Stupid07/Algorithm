import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		
		int[] baseNumbers = new int[N];
		for(int i = 0, size = tokens.countTokens(); i < size; i++) {
			baseNumbers[i] = Integer.parseInt(tokens.nextToken());
		}
		MyUtil.sort(baseNumbers);
		
		int M = Integer.parseInt(reader.readLine());
		StringBuilder result = new StringBuilder(M*2);
		tokens = new StringTokenizer(reader.readLine());
		while(tokens.hasMoreTokens()) {
			int number = Integer.parseInt(tokens.nextToken());
			result.append(MyUtil.mySearch(baseNumbers, number)).append(' ');
		}
		result.setLength(result.length()-1);
		System.out.println(result.toString());
	}
	
	static class MyUtil{
		private static int[] temp;
		
		public static void sort(int[] array) {
			temp = new int[array.length];
			mergeSort(0, array.length-1, array);
		}
		
		private static void mergeSort(int start, int end, int[] array) {
			if(start < end) {
				int mid = (start+end)>>1;
				mergeSort(start, mid, array);
				mergeSort(mid+1, end, array);
				merge(start, mid, end, array);
			}
		}
		
		private static void merge(int start, int mid, int end, int[] array) {
			int left = start, right = mid+1, tempIdx=start;
			
			while(left <= mid && right <= end) {
				if(array[left] > array[right]) {
					temp[tempIdx++] = array[right++];
				}else {
					temp[tempIdx++] = array[left++];
				}
			}
			
			if(left <= mid) {
				while(left <= mid) {
					temp[tempIdx++] = array[left++];
				}
			}else {
				while(right <= end){
					temp[tempIdx++] = array[right++];
				}
			}
			
			for(int idx = start; idx <= end; idx++) {
				array[idx] = temp[idx];
			}
		}
		
		
		public static char mySearch(int[] array, int key) {
			int start = 0, end = array.length-1;
			int mid = (start+end)>>1;
			
			while(start <= end) {
				mid = (start+end)>>1;
				if(array[mid] < key) {
					start = mid+1;
				}else if(array[mid] > key) {
					end = mid-1;
				}else {
					return '1';
				}
			}
			
			return '0';
		}
		
	}
}
