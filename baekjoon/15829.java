import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	final static long MOD_NUMBER = 1234567891L;
	final static long MUL_NUMBER = 31;
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(reader.readLine());
		String line = reader.readLine();
		long sum = 0;
		long mul = 1;
		long temp = 0;
		for(int i = 0; i < L; i++) {
			sum %= MOD_NUMBER;
			temp = ((long)(line.charAt(i)-'`') * mul) % MOD_NUMBER;
			sum = (sum + temp)% MOD_NUMBER;
			mul = (mul * MUL_NUMBER) % MOD_NUMBER;
		}
		System.out.println(sum);
	}
}
