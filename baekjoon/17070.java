import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	final static int HORIZONTAL= 0, VERTICAL = 1, DIAGONAL= 2;
	static int N, result;
	static boolean[][] map;
	static int[][][] cases;
	
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(reader.readLine());
		result = 0;
		map = new boolean[N][N];
		cases = new int[N][N][3];
		
		String[] tokens;
		for(int i = 0; i < N; i++) {
			tokens = reader.readLine().split(" ");
			for(int j = 0; j < N; j++) {
				if(tokens[j].charAt(0) == '0') {
					map[i][j] = true;
				}
			}
		}
		
		cases[0][1][HORIZONTAL] = 1;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!map[i][j]) { // 벽이면 pass
					continue;
				}
				
				if(0 < j && map[i][j-1]) {// 왼쪽에서 오는 것
					cases[i][j][HORIZONTAL] += cases[i][j-1][HORIZONTAL];
					cases[i][j][HORIZONTAL] += cases[i][j-1][DIAGONAL];
				}
				
				if(0 < i && map[i-1][j]) {// 위에서 오는 것
					cases[i][j][VERTICAL] += cases[i-1][j][VERTICAL];
					cases[i][j][VERTICAL] += cases[i-1][j][DIAGONAL];
				}
				
				if(0 < i && 0 < j && map[i-1][j] && map[i][j-1] && map[i-1][j-1]) {// 대각선에서 오는 것
					cases[i][j][DIAGONAL] += cases[i-1][j-1][HORIZONTAL];
					cases[i][j][DIAGONAL] += cases[i-1][j-1][VERTICAL];
					cases[i][j][DIAGONAL] += cases[i-1][j-1][DIAGONAL];
				}
			}
		}
        
		for(int i = 0; i < 3; i++) {
			result += cases[N-1][N-1][i];
		}
		System.out.println(result);
	}
}