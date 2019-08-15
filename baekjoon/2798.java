import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] words = reader.readLine().split(" ");
		int N = Integer.parseInt(words[0]);
		int M = Integer.parseInt(words[1]);
		words = reader.readLine().split(" ");
		int[] numbers = new int[N];
		LinkedList<Integer> queue = new LinkedList<>();
		for(int i = 0 ; i < N; i++) {
			numbers[i]= Integer.parseInt(words[i]);
		}
		int number, numberDiff, minimumDiff = M;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(i == j) continue;
				for(int k = 0; k < N; k++) {
					if(i == k || j == k) continue;
					
					number = numbers[i]+numbers[j]+numbers[k];
					if(number <= M) {
						numberDiff = M-number;
						if(numberDiff < minimumDiff) {
							minimumDiff = numberDiff;
						}
					}
				}
			}
		}
		System.out.println(M-minimumDiff);
		
	}
}
