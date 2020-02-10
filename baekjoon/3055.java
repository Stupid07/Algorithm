import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
	static final int[][] POS = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	static boolean isAlive;
	static int R, C, turn;
	static char[][] map;
	static boolean[][] visited;
	static LinkedList<Integer> hedgehog;
	static LinkedList<Integer> fire;
	
	public static boolean isIndex(int r, int c) {
		if(0 <= r && r < R && 0 <= c && c < C) return true;
		return false;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] line = reader.readLine().split(" ");
		R = Integer.parseInt(line[0]);
		C = Integer.parseInt(line[1]);
		map = new char[R][C];
		visited = new boolean[R][C];
		hedgehog = new LinkedList<>();
		fire = new LinkedList<>();
		isAlive = false;
		
		for(int r = 0 ; r < R; r++) {
			String mapLine = reader.readLine();
			for(int c = 0 ; c < C; c++) {
				char data = mapLine.charAt(c);
				map[r][c] = data;
				if(data == 'S') {
					visited[r][c] = true;
					hedgehog.add(r);
					hedgehog.add(c);
					map[r][c] = '.';
				}else if(data == '*') {
					fire.add(r);
					fire.add(c);
				}
			}
		}
		int size, preR, preC, nextR, nextC;
		while(!hedgehog.isEmpty() && !isAlive) {
			turn++;
			size = fire.size() / 2;
			for(int i = 0 ; i < size; i++) {
				preR = fire.poll();
				preC = fire.poll();
				
				for(int[] pos : POS) {
					nextR = preR + pos[0];
					nextC = preC + pos[1];
					
					if(isIndex(nextR, nextC) && map[nextR][nextC] == '.') {
						map[nextR][nextC] = '*';
						fire.add(nextR);
						fire.add(nextC);
					}
				}
			}
			
			size = hedgehog.size() / 2;
			for(int i = 0; i < size; i++) {
				preR = hedgehog.poll();
				preC = hedgehog.poll();
				
				
				for(int[] pos : POS) {
					nextR = preR + pos[0];
					nextC = preC + pos[1];
					
					if(isIndex(nextR, nextC) && !visited[nextR][nextC]) {
						visited[nextR][nextC] = true;
						if(map[nextR][nextC] == '.') {
							hedgehog.add(nextR);
							hedgehog.add(nextC);
						}else if(map[nextR][nextC] == 'D') {
							isAlive = true;
							break;
						}
					}
				}
			}
			
		
		}
		
		if(isAlive) {
			System.out.println(turn);
		}else{
			System.out.println("KAKTUS");
		}
	}
	
}