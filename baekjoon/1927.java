import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		MyHeap heap = new MyHeap(N);
		for(int i=0; i < N; i++) {
			int number = Integer.parseInt(reader.readLine());
			if(number != 0) {
				heap.push(number);
			}else {
				System.out.println(heap.pop());
			}
		}
	}
	
	static class MyHeap{
		int[] heap;
		int size;
		
		public MyHeap(int size) {
			heap = new int[size];
			this.size = 0;
		}
		
		public void push(int number) {
			heap[++size] = number;
			
			int idx = size;
			while(idx > 1) {
				int parent = idx>>1;
				if(heap[parent] < heap[idx]) { // min
					break;
				}
				
				int temp = heap[parent];
				heap[parent] = heap[idx];
				heap[idx] = temp;
				
				idx >>= 1;
			}
			
			
		}
		
		public int pop() {
			if(size == 0) {
				return 0;
			}
			int idx = 1;
			int data = heap[idx];
			heap[idx] = heap[size--];
			while((idx<<1) <= size) {
				int child = idx<<1;
				if(child < size && heap[child] > heap[child+1]) {
					child++;
				}
				
				if(heap[idx] < heap[child]) {
					break;
				}
				
				int temp = heap[idx];
				heap[idx] = heap[child];
				heap[child] = temp;
				idx = child;
			}
			
			return data;
		}
	}
}
