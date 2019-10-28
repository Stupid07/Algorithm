import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		int N, answer;
		int[] building = new int[1000];
		int[] checkBuilding = new int[1002];
		StringTokenizer tokens;
		for(int testCase = 1; testCase <= 10; testCase++) {
			answer = 0;
			N = Integer.parseInt(reader.readLine());
			tokens = new StringTokenizer(reader.readLine());
			for(int i = 0; i < N; i++) {
				building[i] = Integer.parseInt(tokens.nextToken());
				checkBuilding[i+1] = Math.max(building[i], checkBuilding[i+1]);
				checkBuilding[i+2] = Math.max(building[i], checkBuilding[i+2]);
			}
			
			for(int i = N-3; i >= 2; i--) {
				checkBuilding[i-1] = Math.max(building[i], checkBuilding[i-1]);
				checkBuilding[i-2] = Math.max(building[i], checkBuilding[i-2]);
				
				if(building[i] > checkBuilding[i]) {
					answer += (building[i]-checkBuilding[i]);
				}
				building[i] = checkBuilding[i] = 0;
			}
			
			writer.write(String.format("#%d %d\n", testCase, answer));
		}
		writer.close();
	}
}