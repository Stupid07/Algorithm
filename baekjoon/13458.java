import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] rooms;
	static long result;
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		rooms = new int[N];
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		for(int i = 0; i < N;i++) {
			rooms[i] = Integer.parseInt(tokens.nextToken());
		}
		String[] words = reader.readLine().split(" ");
		int B = Integer.parseInt(words[0]);
		int C = Integer.parseInt(words[1]);
		result+=N;
		for(int i = 0 ; i < N; i++) {
			int mod = rooms[i] - B;
			if(0 < mod) {
				result+=Math.ceil((double)mod / C);
			}
		}
		System.out.println(result);
	}
}