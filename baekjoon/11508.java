import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Integer[] arr = new Integer[N];
		for(int i = 0 ; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		MySort.sort(arr, true);
		int sum = 0;
		for(int i = 0 ; i < N; i++) {
			if((i+1)%3 == 0) {
				continue;
			}
			sum += arr[i];
		}
		System.out.println(sum);
	}
	
	
	private static class MySort{
		
		private static boolean reverse = false;
		
		
		public static<T> void sort(T[] arr, boolean reverse) {
			MySort.reverse = reverse;
			
			mergeSort(0,arr.length-1, arr, arr.clone());
		}
		
		private static<T> void mergeSort(int start, int end, T[] arr, T[] temp) {
			if(start < end) {
				int mid = (start + end)>>1;
				mergeSort(start, mid, arr, temp);
				mergeSort(mid+1, end, arr, temp);
				
				merge(start, mid, end, arr, temp);
			}
		}

		private static<T> void merge(int start, int mid, int end, T[] arr, T[] temp) {
			int s = start, e = mid+1, k = start;
			while(s <= mid && e <= end) {
				if(compare(arr[s], arr[e]) >= 0) {
					// arr[s] 가 더 작거나 같은것  // reverse : true 이면 arr[s]가 더 크거나 같은것
					temp[k++]= arr[s++];
				}else {
					temp[k++]= arr[e++];
				}
			}
			
			if(s <= mid) {//s 남음
				while(s <= mid) {
					temp[k++]=arr[s++];
				}
			}else if(e <= end) {// e남음
				while(e <= mid) {
					temp[k++]=arr[e++];
				}
			}
			
			for(k= start; k <= end; k++) {
				arr[k]=temp[k];
			}
		}
		
		// 일단 int만...
		private static int compareTo(Integer a, Integer b) {
			if(a<b) {
				return reverse ?-1 : 1;
			}else if(a>b) {
				return reverse ? 1 :-1;
			}else {
				return 0;
			}
		}
		
		private static int compare(Object a, Object b) throws RuntimeException {
			if(a instanceof Integer && b instanceof Integer) {
				return compareTo((Integer)a,(Integer) b);
			}
			
			if(a instanceof MyCompareable && b instanceof MyCompareable) {
				return ((MyCompareable)a).compareTo(a, b);
			}
			
			throw new RuntimeException("MyCompareable을 상속하세요");
		}
		
	}
	
	public static interface MyCompareable{
		public<T> int compareTo(T a, T b);
	}
}