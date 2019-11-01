import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

public class Solution {
	public static void main(String[] args) throws Exception{
		final int[][] pos = {{0,1},{1,0},{-1,0},{0,-1}};
		final int posSize = pos.length;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(reader.readLine());
		int N, nextX, nextY, nextSum;
		int[][] map = new int[100][100];
		int[][] sum = new int[100][100];
		LinkedList<int[]> queue = new LinkedList<>();
		int[] current;
		String line;
		for(int testCase = 1; testCase <= T; testCase++) {
			N = Integer.parseInt(reader.readLine());
			for(int i = 0; i < N; i++) {
				line = reader.readLine();				
				for(int j = 0; j < N; j++) {
					map[i][j] = line.charAt(j)-'0';
					sum[i][j] = Integer.MAX_VALUE;
				}
			}
			queue.offer(new int[] {0, 0, 0});
			while(!queue.isEmpty()) {
				current = queue.poll();
				for(int k = 0; k < posSize; k++) {
					nextX = current[0] + pos[k][0];
					nextY = current[1] + pos[k][1];
					if(isIndex(nextX, nextY, N)) {
						nextSum = current[2] + map[nextX][nextY];
						if(sum[nextX][nextY] > nextSum) {
							sum[nextX][nextY] = nextSum;
							queue.offer(new int[] {nextX, nextY, nextSum});
						}
					}
				}
			}
			
			writer.write(String.format("#%d %d\n", testCase, sum[N-1][N-1]));
		}
		
		writer.close();
	}
	
	public static boolean isIndex(int x, int y, int n) {
		if(0 <= x && x < n && 0 <= y && y < n) return true;
		return false;
	}
}
