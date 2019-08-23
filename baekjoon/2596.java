import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
	
	static int N;
	
	static HashMap<Integer, Character> map = new HashMap<>();
	static {
		map.put(0, 'A');
		map.put(Integer.parseInt("001111",2), 'B');
		map.put(Integer.parseInt("010011",2), 'C');
		map.put(Integer.parseInt("011100",2), 'D');
		map.put(Integer.parseInt("100110",2), 'E');
		map.put(Integer.parseInt("101001",2), 'F');
		map.put(Integer.parseInt("110101",2), 'G');
		map.put(Integer.parseInt("111010",2), 'H');
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(reader.readLine());
		String line = reader.readLine();
		StringBuilder result = new StringBuilder(N);
		int i;
		
		for(i = 0; i < N; i++) {
			String word = line.substring(6*i, 6* (i+1));
			int key = Integer.parseInt(word,2);
			if(map.containsKey(key)) {
				result.append(map.get(key));
			}else {
				int tempKey, j;
				for(j = 0 ; j < 6; j++) {
					tempKey = key ^ (1<<j);
					if(map.containsKey(tempKey)) {
						result.append(map.get(tempKey));
						break;
					}
				}
				
				if(j == 6) {
					break;
				}
			}
		}
		
		if(i == N) {
			System.out.println(result.toString());
		}else {
			System.out.println(i+1);
		}
	}
	
	
}