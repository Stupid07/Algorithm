import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
	final static int HEAVY = 0, LIGHT = 1;
	
	public static void main(String[] args) throws Exception{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] words = reader.readLine().trim().split(" ");
		int N = Integer.parseInt(words[0]);
		int M = Integer.parseInt(words[1]);
		boolean[][][] relation = new boolean[N+1][2][N+1];
		boolean[] updateRelation = new boolean[N+1];
		LinkedList<int[]> queue = new LinkedList<>();
		int heavy, light, updateNode, parentNode, result = 0;
		int[] data;
		
		for(int i = 0; i < M; i++) {
			words = reader.readLine().trim().split(" ");
			heavy = Integer.parseInt(words[0]);
			light = Integer.parseInt(words[1]);
			
			for(int j=1; j <= N; j++) {
				updateRelation[j] = true;
			}
			queue.offer(new int[] {light, heavy});
			relation[light][HEAVY][heavy] = true;
			updateRelation[light] = false;
			while(!queue.isEmpty()) {
				data = queue.poll();
				updateNode = data[0];
				parentNode = data[1];
				for(int j = 1; j <= N; j++) {
					relation[updateNode][HEAVY][j] |= relation[parentNode][HEAVY][j];
					
					if(relation[updateNode][LIGHT][j] && updateRelation[j]) {
						queue.offer(new int[]{j, updateNode});
						updateRelation[j] = false;
					}
				}
			}
			
			for(int j=1; j <= N; j++) {
				updateRelation[j] = true;
			}
			queue.offer(new int[] {heavy, light});
			relation[heavy][LIGHT][light] = true;
			updateRelation[heavy] = false;
			while(!queue.isEmpty()) {
				data = queue.poll();
				updateNode = data[0];
				parentNode = data[1];
				for(int j = 1; j <= N; j++) {
					relation[updateNode][LIGHT][j] |= relation[parentNode][LIGHT][j];
					
					if(relation[updateNode][HEAVY][j] && updateRelation[j]) {
						queue.offer(new int[]{j, updateNode});
						updateRelation[j] = false;
					}
				}
			}
			
		}
		
		
		int half = N>>1, heavyCount, lightCount;
		for(int i =1; i <= N; i++) {
			heavyCount = lightCount = 0;
			for(int j=1; j <= N; j++) {
				if(relation[i][HEAVY][j]) {
					heavyCount++;
				}
				if(relation[i][LIGHT][j]) {
					lightCount++;
				}
			}
			
			if(heavyCount > half || lightCount > half) {
				result++;
			}
			
		}
		
		System.out.println(result);
	}
}
