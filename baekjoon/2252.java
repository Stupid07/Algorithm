import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int N = Integer.parseInt(tokens.nextToken());
		int M = Integer.parseInt(tokens.nextToken());
		StringBuilder result = new StringBuilder((N<<1) + 1);
		int[] reverseResult = new int[N];
		List<List<Integer>> adj = new ArrayList<>(N+1);
		int[] inDegree = new int[N+1];
		for(int i = 0 ; i <= N; i++) {
			adj.add(new LinkedList<>());
		}
		int taller, shorter;
		for(int i =0; i < M; i++) {
			tokens = new StringTokenizer(reader.readLine());
			taller = Integer.parseInt(tokens.nextToken());
			shorter = Integer.parseInt(tokens.nextToken());
			if(!adj.get(shorter).contains(taller)) {
				adj.get(shorter).add(taller);
				inDegree[taller]++;
			}
		}
		
		LinkedList<Integer> queue = new LinkedList<>();
		for(int i = 1; i <= N; i++) {
			if(inDegree[i] == 0) {
				queue.offer(i);
			}
		}
		
		int current, idx = 0;
		while(!queue.isEmpty()) {
			current = queue.poll();
			reverseResult[idx++] = current;
			
			for(int connected : adj.get(current)) {
				inDegree[connected]--;
				if(inDegree[connected] == 0) {
					queue.offer(connected);
				}
			}
		}
		for(int i = N-1; i >= 0; i--) {
			result.append(reverseResult[i]).append(' ');
		}
		System.out.println(result.toString().trim());
	}
}
