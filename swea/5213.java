import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
 
public class Solution{
    static final int MAX_NUM = 1000000;
    static long[] numbers = new long[MAX_NUM +1];
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(reader.readLine());
         
        Arrays.fill(numbers, 1);
        for(int i =3; i <= MAX_NUM; i+=2 ) {
            for(int j = i; j <= MAX_NUM; j+=i) {
                numbers[j]+=i;
            }
        }
        numbers[0] = 0;
        for(int i =2; i <= MAX_NUM; i++) {
            numbers[i] += numbers[i-1];
        }
         
        String[] line;
        int start, end;
        long result;
        StringBuilder resultStr;
        for(int test_case = 1; test_case <= T; test_case++) {
            result = 0;
            line = reader.readLine().split(" ");
            start = Integer.parseInt(line[0]);
            end = Integer.parseInt(line[1]);
            result = numbers[end] - numbers[start-1];
            resultStr = new StringBuilder(25).append("#").append(test_case).append(" ").append(result).append("\n");
            writer.write(resultStr.toString());
        }
        writer.flush();
        writer.close();
    }
     
}