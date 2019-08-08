import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
	static final int MAX_VALUE = 100001;
	static int[] arr = new int[MAX_VALUE];
	static LinkedList<int[]> queue = new LinkedList<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] line = reader.readLine().split(" ");
		int B = Integer.parseInt(line[0]);
		int C = Integer.parseInt(line[1]);
		
		queue.add(new int[] {B, 0});
		
		while(!queue.isEmpty()) {
			int[] pos = queue.poll();
			int preX = pos[0], turn = pos[1], nextX;
			if(preX == C) {
				break;
			}
			nextX = preX-1;
			if(0 <= nextX && arr[nextX] == 0) {
				arr[nextX] = turn+1;
				queue.add(new int[] {nextX, turn+1});
			}
			nextX = preX+1;
			if(nextX < MAX_VALUE && arr[nextX] == 0) {
				arr[nextX] = turn+1;
				queue.add(new int[] {nextX, turn+1});
			}
			nextX = preX<<1;
			if(nextX< MAX_VALUE && arr[nextX] == 0) {
				arr[nextX] = turn+1;
				queue.add(new int[] {nextX, turn+1});
			}
		}
		
		System.out.println(arr[C]);
		
	}
}