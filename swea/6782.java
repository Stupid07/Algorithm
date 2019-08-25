import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
 
public class Solution {
    static long N;
    static long result;
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(reader.readLine());
        StringBuilder resultStr;
        for(int test_case = 1; test_case <= T; test_case++) {
            result = 0;
            resultStr = new StringBuilder(16).append("#").append(test_case).append(" ");
             
            N = Long.parseLong(reader.readLine());
            makeTwo(N);
            writer.write(resultStr.append(result).append("\n").toString());
        }
        writer.flush();
        writer.close();
    }
     
    public static void makeTwo(long num) {
        if(num == 2)
            return;
         
        long temp = (long)(Math.sqrt((double)num));
        long compare = temp* temp;
        if(compare == num) {
            result++;
            makeTwo(temp);
        }else {
            result += (temp+1) * (temp+1) - num + 1;
            makeTwo(temp+1);
        }
    }
}