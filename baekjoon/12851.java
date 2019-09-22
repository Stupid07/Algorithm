import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
	static final int MAX_VALUE = 100001;
	static int[] arr = new int[MAX_VALUE];
	static int[] count = new int[MAX_VALUE];
	static LinkedList<int[]> queue = new LinkedList<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] line = reader.readLine().split(" ");
		int B = Integer.parseInt(line[0]);
		int C = Integer.parseInt(line[1]);
		
		queue.add(new int[] {B, 0});
		count[B]++;
		if(B != C) {
		    while(!queue.isEmpty()) {
			    int[] pos = queue.poll();
			    int preX = pos[0], nextTurn = pos[1] +1, nextX;
			
			
			    nextX = preX-1;
			    if(0 <= nextX) {
				    if(arr[nextX] == 0) {
					    arr[nextX] = nextTurn;
					    count[nextX]++;
					    queue.add(new int[] {nextX, nextTurn});
				    }else if(arr[nextX] == nextTurn) {
					    count[nextX]++;
					    queue.add(new int[] {nextX, nextTurn});
				    }
			    }
			
			    nextX = preX+1;
			    if(nextX < MAX_VALUE) {
				    if(arr[nextX] == 0) {
					    arr[nextX] = nextTurn;
					    count[nextX]++;
					    queue.add(new int[] {nextX, nextTurn});
			    	}else if(arr[nextX] == nextTurn) {
					    count[nextX]++;
					    queue.add(new int[] {nextX, nextTurn});
				    }
			    }
			
			    nextX = preX<<1;
			    if(nextX< MAX_VALUE) {
				    if(arr[nextX] == 0) {
					    arr[nextX] = nextTurn;
					    count[nextX]++;
					    queue.add(new int[] {nextX, nextTurn});
				    }else if(arr[nextX] == nextTurn) {
					    count[nextX]++;
					    queue.add(new int[] {nextX, nextTurn});
				    }
			    }
		    }
        }
		System.out.println(arr[C]);
		System.out.println(count[C]);
		
	}
}