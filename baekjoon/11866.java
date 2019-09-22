import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] words = reader.readLine().split(" ");
		int N = Integer.parseInt(words[0]);
		int M = Integer.parseInt(words[1]);
		StringBuilder result = new StringBuilder(N*3 +3);
		result.append('<');
		LinkedList<Integer> queue = new LinkedList<>();
		for(int i = 1; i <=N; i++) {
			queue.add(i);
		}
		int index;
		int size = queue.size();
		while(!queue.isEmpty()) {
			index = (M-1) % size;
			for(int i = 0; i< index; i++) {
				queue.addLast(queue.removeFirst());
			}
			result.append(queue.removeFirst()).append(", ");
			size--;
		}
		result.replace(result.length()-2, result.length()-1, ">");
		writer.write(result.toString());
		writer.flush();
		writer.close();
	}
}