import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Integer> heightStack = new Stack<Integer>();
		Stack<Integer> indexStack = new Stack<Integer>();
		StringBuilder result;
		int N = Integer.parseInt(reader.readLine());
		StringTokenizer	st = new StringTokenizer(reader.readLine());
		result = new StringBuilder(N*2+1);
		for(int i = 1; i <= N; i++) {
			int height = Integer.parseInt(st.nextToken());
			while(!heightStack.isEmpty() && heightStack.peek() < height) {
				heightStack.pop();
				indexStack.pop();
			}
				
			if(heightStack.isEmpty()) {
				result.append(0).append(' ');
			}else {
				result.append(indexStack.peek()).append(' ');
			}
				
			heightStack.push(height);
			indexStack.push(i);
		}
		result.append("\n");
		writer.write(result.toString());
		writer.flush();
		writer.close();
	}
}