import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	
	public static boolean isIndex(int x, int y, int N, int M) {
		if(0 <= x && x < N && 0 <= y && y < M) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] words = reader.readLine().split(" ");
		int N = Integer.parseInt(words[0]);
		int M = Integer.parseInt(words[1]);
		int[][] map = new int[N][M];
		
		StringTokenizer tokens;
		char next;
		for(int i = 0 ; i < N; i++) {
			tokens = new StringTokenizer(reader.readLine());
			for(int j = 0 ; j < M; j++) {
				next = tokens.nextToken().charAt(0);
				if(next != '0') {
					map[i][j] = -1;
				}
			}
		}
		
		int islandCount = islandCounting(N, M, map);
		
		LinkedList<int[]> edgeList = edgeSearching(N, M, map);
		Collections.sort(edgeList, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2]-o2[2];
			}
			
		});
		
		
		int result = findMST(islandCount, edgeList);
		System.out.println(result);
	}
	
	public static int findMST(int count, LinkedList<int[]> edgeList) {
		int result = -1;
		int[] parent = new int[count+1];
		for(int i = 1; i <= count; i++) {
			parent[i] = -1;
		}
		
		int island1, island2, sum = 0;
		for(int[] edge : edgeList) {
			island1 = edge[0];
			island2 = edge[1];
			while(parent[island1] >= 0) {
				island1 = parent[island1];
			}
			while(parent[island2] >= 0) {
				island2 = parent[island2];
			}
			
			if(island1 != island2) {
				parent[island1] += parent[island2];
				parent[island2] = island1;
				sum += edge[2];
				if(parent[island1] == -count) {
					result = sum;
					break;
				}
			}
		}
		return result;
	}
	
	public static LinkedList<int[]> edgeSearching(int N, int M, int[][] map){
		LinkedList<int[]> edgeList = new LinkedList<>();
		int rowStart, rowCount, columnStart, columnCount;
		
		for(int i = 0 ; i < N; i++) {
			rowStart = rowCount =  0;
			for (int j = 0; j < M; j++) {
				if(map[i][j] != 0) {
					if(rowStart != 0 && rowStart != map[i][j] && rowCount >= 2) {
						edgeList.offer(new int[] {rowStart, map[i][j], rowCount});
					}
					rowStart = map[i][j];
					rowCount = 0;
				}else{
					rowCount++;
				}
			}
		}
		
		
		for(int j = 0 ; j < M; j++) {
			columnStart = columnCount = 0;
			for (int i = 0; i < N; i++) {
				if(map[i][j] != 0) {
					if(columnStart != 0 && columnStart != map[i][j] && columnCount >= 2) {
						edgeList.offer(new int[] {columnStart, map[i][j], columnCount});
					}
					columnStart = map[i][j];
					columnCount = 0;
				}else{
					columnCount++;
				}
			}
		}
		
		
		return edgeList;
	}
	
	public static int islandCounting(int N, int M, int[][] map) {
		final int[][] pos = {{1,0},{0,1},{-1,0},{0,-1}};
		
		int count = 1, nextX, nextY;
		int[] current;
		LinkedList<int[]> queue = new LinkedList<>();
		for(int i = 0; i < N; i++) {
			for(int j = 0 ; j <M; j++) {
				if(map[i][j] == -1) {
					map[i][j] = count;
					queue.offer(new int[] {i,j});
					while(!queue.isEmpty()) {
						current = queue.poll();
						for(int k = 0 ; k < pos.length; k++) {
							nextX = current[0] + pos[k][0];
							nextY = current[1] + pos[k][1];
							if(isIndex(nextX, nextY, N, M) && map[nextX][nextY] == -1) {
								map[nextX][nextY] = count;
								queue.offer(new int[] {nextX, nextY});
							}
						}
					}
					count++;
				}
			}
		}
		
		return count - 1;
	}
}