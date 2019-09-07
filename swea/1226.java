import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

public class Solution {
	static final int[][] pos = {{1, 0}, {0, 1}, {-1, 0} , {0, -1}};
	static final int MAX = 16;
	
	static boolean isIndex(int x, int y) {
		if(0 <= x && x < MAX && 0 <= y && y < MAX) return true;
		return false;
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCase;
		String line;
		int[] current, next;
		boolean isWay;
		LinkedList<int[]> queue = new LinkedList<>();
		char[][] map = new char[MAX][MAX];
		for(int t = 0 ; t < 10; t++) {
			testCase = Integer.parseInt(reader.readLine());
			for(int i = 0; i < MAX; i++) {
				line = reader.readLine();
				for(int j = 0; j< MAX; j++) {
					map[i][j] = line.charAt(j);
					if(map[i][j] == '2') {
						queue.offer(new int[] {i,j});
					}
				}
			}
			
			isWay = false;
			while(!queue.isEmpty()) {
				current = queue.poll();
				for(int i = 0; i < pos.length; i++) {
					next = new int[] {current[0]+pos[i][0], current[1]+pos[i][1]};
					if(isIndex(next[0], next[1])) {
						if(map[next[0]][next[1]] == '0') {
							queue.offer(next);
							map[next[0]][next[1]] = '1';
						}else if(map[next[0]][next[1]] == '3') {
							isWay = true;
							break;
						}
					}
				}
			}
			writer.write("#"+ testCase + " " + (isWay? "1" : "0")+"\n");
		}
		writer.close();
	}
}
