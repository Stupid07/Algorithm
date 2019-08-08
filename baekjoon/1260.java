import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class Main{
	static int N;
	static boolean[][] matrix;
	static StringBuilder resultDFS;
	static StringBuilder resultBFS;
	static boolean[] selected;
	
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] line = reader.readLine().split(" ");
		N = Integer.parseInt(line[0]);
		int M = Integer.parseInt(line[1]);
		int V = Integer.parseInt(line[2]);
		resultDFS = new StringBuilder(N*2 +1);
		resultBFS = new StringBuilder(N*2 +1);
		matrix = new boolean[N+1][N+1];
		selected = new boolean[N+1];
		
		int node1, node2;
		for(int i = 0 ; i < M; i++) {
			line = reader.readLine().split(" ");
			node1 = Integer.parseInt(line[0]);
			node2 = Integer.parseInt(line[1]);
			matrix[node1][node2] = matrix[node2][node1] = true;
		}
		
		dfs_stack(V);
		Arrays.fill(selected, false);
		bfs(V);
		
		writer.write(resultDFS.append("\n").toString());
		writer.write(resultBFS.append("\n").toString());
		writer.flush();
		writer.close();
	}
	
	public static void dfs_stack(int startNode) {
		Stack<Integer> stack = new Stack<>();
		stack.push(startNode);
		while(!stack.isEmpty()) {
			int preNode = stack.pop();
			if(!selected[preNode]) {
				selected[preNode] =true;
				resultDFS.append(preNode).append(" ");
				for(int i =N; i >= 1; i--) {
					if(matrix[preNode][i]) {
						stack.push(i);
					}
				}
			}
		}
	}
	
	public static void bfs(int startNode) {
		LinkedList<Integer> queue = new LinkedList<>();
		selected[startNode] = true;
		queue.offer(startNode);
		
		while(!queue.isEmpty()) {
			int preNode = queue.poll();
			resultBFS.append(preNode).append(" ");
			for(int i=1; i <=N; i++) {
				if(matrix[preNode][i] && !selected[i]) {
					selected[i]= true;
					queue.offer(i);
				}
			}
		}
	}
}