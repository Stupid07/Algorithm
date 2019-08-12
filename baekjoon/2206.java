import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static final int[][] pos = {{1,0}, {-1,0}, {0,1}, {0,-1}};
	static final int posSize = pos.length;
	static int N, M, result = -1;
	static boolean[][] map;
	static boolean[][][] visited;
	static LinkedList<int[]> queue;
	
	static boolean isIndex(int x, int y) {
		if(0<= x && x < N && 0 <= y && y < M) return true;
		return false;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		map = new boolean[N][M];
		visited = new boolean[N][M][2];
		queue = new LinkedList<>();
		String line;
		for(int i = 0; i < N; i++) {
			line =reader.readLine();
			for(int j = 0; j < M; j++) {
				if(line.charAt(j) =='0') {
					map[i][j] = true;
				}
			}
		}
		queue.add(new int[] {0, 0, 1, 1});
		visited[0][0][1] = true;
		
		while(!queue.isEmpty()) {
			int[] prePos = queue.poll();
			int preX = prePos[0], preY = prePos[1], power = prePos[2], turn = prePos[3], nextX, nextY;
			
			if(preX == N-1 && preY == M-1) {
				result = turn;
				break;
			}
			
			for(int i = 0 ; i < posSize; i++) {
				nextX = preX + pos[i][0];
				nextY = preY + pos[i][1];
				if(isIndex(nextX, nextY) && !visited[nextX][nextY][power]) {
					visited[nextX][nextY][power] = true;
					if(map[nextX][nextY]) {
						queue.add(new int[] {nextX, nextY, power, turn+1});
					}else if(power != 0) {
						queue.add(new int[] {nextX, nextY, 0, turn+1});
					}
				}
			}
		}
		
		System.out.println(result);
	}
	
}