import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] numbers;
	static int[] opers = new int[4];
	static int MAX = Integer.MIN_VALUE;
	static int MIN = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(reader.readLine());
		numbers = new int[N];
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		for(int i = 0 ; i < N; i++) {
			numbers[i] = Integer.parseInt(tokens.nextToken());
		}
		tokens = new StringTokenizer(reader.readLine());
		for(int i = 0; i < 4; i++) {
			opers[i] = Integer.parseInt(tokens.nextToken());
		}
		combiCal(1,numbers[0]);
		
		System.out.println(MAX);
		System.out.println(MIN);
	}
	
	static void combiCal(int index, int result) {
		if(index == N) {
			MAX = Math.max(MAX, result);
			MIN = Math.min(MIN, result);
			return;
		}
		
		for(int i=0; i < 4; i++) {
			if(opers[i] > 0) {
				opers[i]--;
				combiCal(index+1, operCal(i,index,result));
				opers[i]++;
			}
		}
			
	}
	
	static int operCal(int operType,int index, int preResult) {
		int result = preResult;
		int nextNum = numbers[index];
		switch(operType) {
		case 0: result += nextNum;
			break;
		case 1: result -= nextNum;
			break;
		case 2: result *= nextNum;
			break;
		case 3: result /= nextNum;
			break;
		}
		return result;
	}
}