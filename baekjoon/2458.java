import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, result;
	static boolean[][] matrix;
	
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		matrix = new boolean[N+1][N+1];
		
		int start, end;
		for(int i = 0; i < M; i++) {
			tokens = new StringTokenizer(reader.readLine());
			start = Integer.parseInt(tokens.nextToken());
			end = Integer.parseInt(tokens.nextToken());
			matrix[start][end] = true;
			
			
		}
		
		for(int k = 1; k <= N; k++) {
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= N; j++) {
					if(matrix[i][k] && matrix[k][j]) {
						matrix[i][j] = true;
					}
				}
			}
		}
		
		
		int subSum;
		for(int i = 1; i <= N; i++) {
			subSum = 1;
			
			for(int j = 1; j <= N; j++) {
				if(matrix[i][j]) {
					subSum++;
				}
				if(matrix[j][i]) {
					subSum++;
				}
			}
			
			
			if(subSum == N) result++;
		}
		
		System.out.println(result);
	}
	
}