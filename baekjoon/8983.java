import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int M, N, L;
	static int result;	
	
	private static class IHateProgramming implements Comparable<IHateProgramming>{
		int x;
		int y;
		public IHateProgramming(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		@Override
		public int compareTo(IHateProgramming o) {
			return this.x - o.x;
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		M = Integer.parseInt(tokens.nextToken());
		N = Integer.parseInt(tokens.nextToken());
		L = Integer.parseInt(tokens.nextToken());
		
		PriorityQueue<IHateProgramming> queue = new PriorityQueue<>(M+N);
		
		tokens = new StringTokenizer(reader.readLine());
		for(int i = 0 ; i < M; i++) {
			queue.add(new IHateProgramming(Integer.parseInt(tokens.nextToken()), 0));
		}
		
		String[] words;
		for(int i =0; i < N; i++) {
			words = reader.readLine().trim().split(" ");
			queue.add(new IHateProgramming(Integer.parseInt(words[0]), Integer.parseInt(words[1])));
		}
		
		LinkedList<IHateProgramming> subQueue = new LinkedList<>();
		IHateProgramming preNode, beforeNode;
		int preX, compareX=Integer.MAX_VALUE>>1;
		while(!queue.isEmpty()) {
			preNode = queue.poll();
			preX = preNode.x;
			if(preNode.y == 0) {
				while(!subQueue.isEmpty()) {
					beforeNode = subQueue.pollLast();
					if(Math.abs(beforeNode.x - preX) +beforeNode.y <= L ){
						result++;
					}
				}
				subQueue.clear();
				compareX = preX;
			}else {
				if(Math.abs(compareX- preX) + preNode.y <= L) {
					result++;
				}else {
					subQueue.add(preNode);
				}
			}
		}
		
		System.out.println(result);
	}
	
	
}