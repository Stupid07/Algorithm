import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;

public class Main {
	static final int MAX = 9;
	static final int[][] posDirection = {{0,0},{0,1},{0,-1},{1,0},{-1,0},{1,1},{1,-1},{-1,1},{-1,-1}};
	static final int posSize = 9;
	static boolean[][] map = new boolean[MAX][MAX];
	
	static boolean isIndex(int x, int y) {
		if(0 < x && x < MAX && 0 < y && y < MAX) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line;
		LinkedList<Integer> wall = new LinkedList<>();
		LinkedList<Integer> human = new LinkedList<>();
		for(int i = 1; i < MAX; i++) {
			line = reader.readLine();
			for(int j = 1; j < MAX; j++) {
				if(line.charAt(j-1) == '#') {
					map[i][j] = true;
					wall.add(i*10 + j);
				}
			}
		}
		
		if(!map[8][1]) {
			human.add(81);
		}
		Collections.reverse(wall);
		int size;
		while(!wall.isEmpty() && !human.isEmpty()) {
			
			size = human.size();
			for(int i = 0; i < size; i++) {
				int pos = human.poll();
				int posX = pos/10, posY = pos %10, nextX, nextY;
				for(int k=0; k < posSize; k++) {
					nextX = posX + posDirection[k][0];
					nextY = posY + posDirection[k][1];
					if(isIndex(nextX, nextY) && !map[nextX][nextY]) {
						human.add(nextX * 10 + nextY);
					}
				}
				
			}
			
			size = wall.size();
			for(int i = 0; i < size; i++) {
				int pos = wall.poll();
				int posX = pos/10, posY = pos %10;
				if(posX < MAX-1) {
					map[posX][posY] = false;
					posX++;
					map[posX][posY] = true;
					pos+=10;
					
					while(human.indexOf(pos) != -1) {
						human.remove(human.indexOf(pos));
					}
					
					wall.add(pos);
					
				}else {
					map[posX][posY]=false;
				}
			}
			
		}
		
		if(wall.isEmpty() && !human.isEmpty()) {
			System.out.println("1");
		}else {
			System.out.println("0");
		}
		
	}
	
}
