import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer tokens = null;
		
		int baseNumberArrayLength = Integer.parseInt(reader.readLine());
		int[] baseNumberArray = new int[baseNumberArrayLength];
		tokens = new StringTokenizer(reader.readLine());
		for(int i = 0; i < baseNumberArrayLength; i++) {
			baseNumberArray[i] = Integer.parseInt(tokens.nextToken());
		}
		Arrays.sort(baseNumberArray);
		
		int compareNumberArrayLength = Integer.parseInt(reader.readLine());
		int[] compareNumberArray = new int[compareNumberArrayLength];
		int[] sortedCompareNumberArray = new int[compareNumberArrayLength];
		tokens = new StringTokenizer(reader.readLine());
		for(int i = 0; i < compareNumberArrayLength; i++) {
			compareNumberArray[i] = Integer.parseInt(tokens.nextToken());
			sortedCompareNumberArray[i] = compareNumberArray[i];
		}
		Arrays.sort(sortedCompareNumberArray);
		
		HashSet<Integer> searchNumber = new HashSet<>();
		int baseIndex = 0, compareIndex = 0;
		while(baseIndex < baseNumberArrayLength 
				&& compareIndex < compareNumberArrayLength) {
			if(baseNumberArray[baseIndex] < sortedCompareNumberArray[compareIndex]) {
				baseIndex++;
			}else if(baseNumberArray[baseIndex] > sortedCompareNumberArray[compareIndex]) {
				compareIndex++;
			}else {
				searchNumber.add(sortedCompareNumberArray[compareIndex]);
				compareIndex++;
			}
		}
		
		for(int i = 0; i < compareNumberArrayLength; i++) {
			if(searchNumber.contains(compareNumberArray[i])) {
				writer.write("1\n");
			}else {
				writer.write("0\n");
			}
		}
		
		writer.flush();
		writer.close();
	}
}