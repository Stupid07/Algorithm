import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	
	static int M, N, H;
	static int result;	
	
	static class IDontWantToDo{
		int x;
		int y;
		int h;
		int count; 
		public IDontWantToDo(int h, int x, int y) {
			this.x = x;
			this.y = y;
			this.h = h;
			this.count = 0;
		}
		
		public IDontWantToDo(int h, int x, int y,int count) {
			this.x = x;
			this.y = y;
			this.h = h;
			this.count = count;
		}
	}
	
	static int[][][] map;
	
	static int count;
	static int MAX = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine().trim());
		M = Integer.parseInt(tokens.nextToken());
		N = Integer.parseInt(tokens.nextToken());
		H = Integer.parseInt(tokens.nextToken());
		map = new int[H][N][M];
		LinkedList<IDontWantToDo> queue = new LinkedList<>();
		for(int h = 0; h < H; h++) {
			for(int i = 0 ; i < N; i++) {
				tokens = new StringTokenizer(reader.readLine().trim());
				for(int j = 0; j < M; j++) {
					int value = Integer.parseInt(tokens.nextToken());
					if(value == 1) {
						queue.add(new IDontWantToDo(h,i,j));
					}else if(value == 0) {
						count++;
					}
					map[h][i][j] = value;
				}
			}
		}

		while(!queue.isEmpty()) {
			IDontWantToDo what = queue.poll();
			MAX = Math.max(MAX, what.count);
			
			
			if(0 < what.h  && map[what.h-1][what.x][what.y] == 0) {
				count--;
				
				map[what.h-1][what.x][what.y] = 1;
				queue.add(new IDontWantToDo(what.h-1, what.x, what.y, what.count+1));
			}
			
			if(what.h < (H-1)  && map[what.h+1][what.x][what.y] == 0) {
				count--;
				map[what.h+1][what.x][what.y] = 1;
				queue.add(new IDontWantToDo(what.h+1, what.x, what.y, what.count+1));
			}
			
			if(0 < what.x  && map[what.h][what.x-1][what.y] == 0) {
				count--;
				map[what.h][what.x-1][what.y] = 1;
				queue.add(new IDontWantToDo(what.h, what.x-1, what.y, what.count+1));
			}
			
			if((what.x < (N-1))  && map[what.h][what.x+1][what.y] == 0) {
				count--;
				map[what.h][what.x+1][what.y] = 1;
				queue.add(new IDontWantToDo(what.h, what.x+1, what.y, what.count+1));
			}
			
			if(0 < what.y  && map[what.h][what.x][what.y-1] == 0) {
				count--;
				map[what.h][what.x][what.y-1] = 1;
				queue.add(new IDontWantToDo(what.h, what.x, what.y-1, what.count+1));
			}
			
			if((what.y < (M-1)) && map[what.h][what.x][what.y+1] == 0) {
				count--;
				map[what.h][what.x][what.y+1] = 1;
				queue.add(new IDontWantToDo(what.h, what.x, what.y+1, what.count+1));
			}
		}
		
		if(count == 0)
			System.out.println(MAX);
		else
			System.out.println("-1");
	}
	
	
}