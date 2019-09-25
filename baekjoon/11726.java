import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static final int DIVIDER = 10007;
	static int[] arr = new int[1001];
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		arr[1]=1;
		arr[2]=2;
		for(int i =3; i <= N; i++) {
			arr[i] = arr[i-2] + arr[i-1];
			arr[i] %= DIVIDER;
		}
		System.out.println(arr[N]);
	}
}