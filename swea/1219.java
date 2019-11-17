import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer tokens;
		String line;
		Stack<Integer> stack = new Stack<>();
		int[][] adj = new int[100][2];
		boolean[] check = new boolean[100];
		int testCase, lineCount, start, end, current, result = 0;
		while((line = reader.readLine()) != null) {
			for(int i = 0 ; i < 100; i++) {
				adj[i][0] = adj[i][1] = -1;
				check[i] = false;
			}
			stack.clear();
			tokens = new StringTokenizer(line);
			testCase = Integer.parseInt(tokens.nextToken());
			lineCount = Integer.parseInt(tokens.nextToken());
			
			tokens = new StringTokenizer(reader.readLine());
			for(int i = 0; i < lineCount; i++) {
				start = Integer.parseInt(tokens.nextToken());
				end = Integer.parseInt(tokens.nextToken());
				if(adj[start][0] == -1) {
					adj[start][0] = end;
				}else {
					adj[start][1] = end;
				}
			}
			
			stack.push(0);
			while(!stack.isEmpty()) {
				current = stack.pop();
				for(int i = 0; i < 2; i++) {
					if(adj[current][i] != -1 && !check[adj[current][i]]) {
						check[adj[current][i]] =true;
						stack.push(adj[current][i]);
					}
				}
			}
			
			writer.write(String.format("#%d %d\n", testCase, check[99]? 1 : 0));
		}
		writer.close();
	}
}