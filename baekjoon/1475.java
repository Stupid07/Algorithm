import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	static int[] count = new int[10]; // 0 ~ 9가 몇번 들어오는지 저장하는 배열
	static int checkSize = count.length -1; // 9를 빼고 Max 체크하기 위함
	static int result; // 결과값
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		String line;
        
			result = 0;
			line = reader.readLine().trim();
			for(int i = 0, size = line.length(); i < size; i++) {
				count[line.charAt(i)-'0']++; // 문자열의 숫자값을 그대로 카운팅
			}
			
			int sum = count[6] + count[9];
			count[6] =(sum&1) == 0 ? sum/2 : (sum/2) +1 ; // 6과 9의 총합의 나누기 2값을 넣어줌 단, 홀수이면 한 세트 더 필요하므로 + 1
			
			for(int i = 0; i < checkSize; i++) {
				result = Math.max(result, count[i]);// 나온 숫자들의 카운팅갑을 필요 세트 값으로 보고 제일 큰 세트 값 찾기
			}
			writer.write(new StringBuilder().append(result).append("\n").toString());
			Arrays.fill(count, 0);
		
		
		writer.flush();
		writer.close();
	}
}