import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
	private static HashMap<String, Double> records = new HashMap<>();
	private static final String[] keys = {"A+","A0","A-",
			"B+","B0","B-","C+","C0","C-","D+","D0","D-", "F"};
	private static final double[] values= {4.3, 4.0, 3.7,
			3.3, 3.0, 2.7, 2.3, 2.0, 1.7, 1.3, 1.0, 0.7, 0.0};
	static {
		for(int i = 0; i < keys.length; i++) {
			records.put(keys[i], values[i]);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		int count = 0;
		double sum = 0.0;
		String[] trace;
		String record;
		for(int i = 0; i < N; i++) {
			trace = reader.readLine().split(" ");
			record = trace[2].trim();
			count += Integer.parseInt(trace[1]);
			sum += Double.parseDouble(trace[1]) * records.get(record);
		}
		
		System.out.println(String.format("%.2f", sum/count));
	}
}
