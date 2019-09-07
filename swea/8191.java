import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(reader.readLine());
		boolean[] numbers = new boolean[200001];
		numbers[0] = true;
		StringTokenizer tokens;
		int N, count, number;
		for(int testCase = 1; testCase <= T; testCase++) {
			N = Integer.parseInt(reader.readLine());
			tokens = new StringTokenizer(reader.readLine());
			count = 1;
			while(tokens.hasMoreTokens()) {
				number = Integer.parseInt(tokens.nextToken());
				if(!numbers[number-1]) {
					count++;
				}
				numbers[number] = true;
			}
			for(int i = 1; i <= N; i++) {
				numbers[i] = false;
			}
			writer.write(String.format("#%d %d\n", testCase, count));
		}
		writer.close();
	}
}
