import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	final static char HEIGHT = '0', WIDTH = '1';
	
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] words = reader.readLine().trim().split(" ");
		int width = Integer.parseInt(words[0]);
		int height = Integer.parseInt(words[1]);
		int count = Integer.parseInt(reader.readLine().trim());
		MyHeap minWidthHeap = new MyHeap(count+1);
		MyHeap minHeightHeap = new MyHeap(count+1);
		
		for(int i = 0; i < count; i++) {
			words = reader.readLine().trim().split(" ");
			if(words[0].charAt(0) == HEIGHT) {
				minHeightHeap.push(Integer.parseInt(words[1].trim()));
			}else {
				minWidthHeap.push(Integer.parseInt(words[1].trim()));
			}
		}
		
		minHeightHeap.push(height);
		minWidthHeap.push(width);
		
		int lastValue = 0, popValue, nowLength, maxHorizontal = 0, maxVertical = 0;
		for(int i = 0, size=minHeightHeap.size(); i < size; i++) {
			popValue = minHeightHeap.pop();
			nowLength = popValue-lastValue;
			if(maxHorizontal < nowLength) {
				maxHorizontal = nowLength;
			}
			lastValue = popValue;
		}
		
		lastValue = 0;
		for(int i = 0, size=minWidthHeap.size(); i < size; i++) {
			popValue = minWidthHeap.pop();
			nowLength = popValue-lastValue;
			if(maxVertical < nowLength) {
				maxVertical = nowLength;
			}
			lastValue = popValue;
		}
		
		System.out.println(maxHorizontal * maxVertical);
	}
	
	static class MyHeap{
		private int[] heap;
		private int size;
		private boolean isMax; // min, max 둘다 가능
		
		public MyHeap(int maxSize) {
			this.heap = new int[maxSize];
			this.size = 0;
			this.isMax = false;
		}
		
		public MyHeap(int maxSize, boolean isMax) {
			this(maxSize);
			this.isMax = isMax;
		}
		
		public void push(int number) {
			if(size == heap.length - 1) {
				int[] newHeap = new int[heap.length<<1];
				for(int i = 0 ; i< heap.length; i++) {
					newHeap[i] = heap[i];
				}
				heap = newHeap;
			}
			
			heap[++size] = number;
			int idx = size, temp;
			int parentIdx = idx>>1;
			while(idx > 1) {// 부모가 있을때
				if(heap[parentIdx] >= heap[idx] == isMax) {
					break;
				}
				
				temp = heap[parentIdx];
				heap[parentIdx] = heap[idx];
				heap[idx] = temp;
				
				idx = parentIdx;
				parentIdx = idx>>1;
			}
			
		}
		
		
		public int pop() {
			if(size == 0) {
				return -1;
			}
			
			int idx = 1;
			int data = heap[idx];
			heap[idx] = heap[size];
			heap[size--] = 0;
			
			int childIdx = idx<<1, temp;
			while(childIdx <= size) {
				if(childIdx+1 <= size) {
					if(heap[childIdx] < heap[childIdx+1] == isMax) {
						childIdx = childIdx+1;
					}
				}
				
				if(heap[idx] >= heap[childIdx] == isMax) {
					break;
				}
				
				temp = heap[childIdx];
				heap[childIdx] = heap[idx];
				heap[idx] = temp;
				idx = childIdx;
				childIdx = idx<<1;
			}
			
			return data;
		}
		
		public int size() {
			return size;
		}
		
	}
}
