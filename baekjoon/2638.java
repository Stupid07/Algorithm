import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	
	static int X, Y;
	static boolean[][] map;
	static int[][] visited;
	static int count;
	static int turn;
	
	static final int[][] pos = new int[][] {{1,0}, {-1,0}, {0,1}, {0,-1}};
	static final int posSize = 4;
	static boolean isIndex(int x, int y) {
		if(0 <= x && x < X && 0 <= y && y < Y) return true;
		return false;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine().trim());
		X = Integer.parseInt(tokens.nextToken());
		Y = Integer.parseInt(tokens.nextToken());
		map = new boolean[X][Y];
		visited = new int[X][Y];
		LinkedList<int[]> queue = new LinkedList<>();
		
		for (int i = 0; i < X; i++) {
			tokens = new StringTokenizer(reader.readLine().trim());
			for (int j = 0; j < Y; j++) {
				int value = Integer.parseInt(tokens.nextToken());
				if (value == 1) {
					count++;
					map[i][j] = true;
				}
			}
		}
		
		while (count != 0) {
			turn++;
			int preX, preY, nextX, nextY;
			queue.add(new int[] { 0, 0 });
			visited[0][0] = -1;
			while (!queue.isEmpty()) {
				int[] temp = queue.poll();
				preX = temp[0];
				preY = temp[1];
				
				for(int i = 0; i < posSize; i++) {
					nextX = preX + pos[i][0];
					nextY = preY + pos[i][1];
					if(isIndex(nextX, nextY) && visited[nextX][nextY] >= 0) {
						if(map[nextX][nextY]) {
							if(visited[nextX][nextY] < 1) {
								visited[nextX][nextY]++;
							}else {
								visited[nextX][nextY] = -1;
								count--;
								map[nextX][nextY] = false;
							}
						}else {
							visited[nextX][nextY] = -1;
							queue.add(new int[] {nextX, nextY});
						}
					}
				}
				
			}
            
			for(int i = 0; i < X; i++) {
				Arrays.fill(visited[i], 0);
			}
			
		}
		
		System.out.println(turn);
	}
	
}