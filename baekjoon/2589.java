import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {
	static final int[][] pos = new int[][] {{-1,0}, {1,0}, {0,-1}, {0,1}};
	static final int POS_SIZE = 4;
	
	static int MAX_DISTANCE = 0;
	static int X, Y;
	static boolean[][] map;
	static boolean[][] selected;
	
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] words = reader.readLine().trim().split(" ");
		X = Integer.parseInt(words[0]);
		Y = Integer.parseInt(words[1]);
		map = new boolean[X][Y];
		selected = new boolean[X][Y];
		for(int i = 0; i < X; i++) {
			String line = reader.readLine();
			for(int j = 0; j < Y; j++) {
				if(line.charAt(j) == 'L') {
					map[i][j] = true;
				}
			}
		}
		
		
		for(int i = 0 ; i < X; i++) {
			for(int j = 0; j < Y; j++) {
				if(map[i][j]) {
					findDistance(i, j);
				}
			}
		}
		
		System.out.println(MAX_DISTANCE);
	}
	
	static void findDistance(int x, int y) {
		LinkedList<int[]> queue = new LinkedList<>();
		LinkedList<int[]> maxQueue = new LinkedList<>();
		selected[x][y]=true;
		queue.offer(new int[] {x, y, 0});
		
		int subMax = 0;
		int[] prePos;
		int preX, preY, nextX, nextY, preCount;
		while(!queue.isEmpty()) {
			prePos = queue.poll();
			preX = prePos[0];
			preY = prePos[1];
			preCount = prePos[2];
			for(int i = 0; i < POS_SIZE; i++) {
				nextX = preX + pos[i][0];
				nextY = preY + pos[i][1];
				if(isIndex(nextX, nextY) && map[nextX][nextY] && !selected[nextX][nextY]) {
					selected[nextX][nextY] = true;
					queue.offer(new int[] {nextX, nextY, preCount +1});
				}
			}
			
			if(subMax < preCount) {
				maxQueue.clear();
				maxQueue.add(new int[] {preX, preY, 0});
				subMax = preCount;
			}
			
		}
		
		MAX_DISTANCE = Math.max(MAX_DISTANCE, subMax);
		
		for(int i =0; i < X; i++) {
			Arrays.fill(selected[i], false);
		}
		
	}
	
	static boolean isIndex(int x, int y) {
		if(0<= x && x < X && 0<= y && y < Y)
			return true;
		return false;
	}
}