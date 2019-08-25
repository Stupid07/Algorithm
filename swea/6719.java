import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Solution {
    static int T,N,K;
    static int[] num;
    static double result;
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(reader.readLine());
        num = new int[201];
        String[] line;
        StringTokenizer M;
        StringBuilder resultStr;
        for(int test_case = 1; test_case <= T; test_case++) {
            result = 0.0;
            Arrays.fill(num, 0);
            resultStr = new StringBuilder(20).append("#").append(test_case).append(" ");
             
            line = reader.readLine().split(" ");
            N = Integer.parseInt(line[0]);
            K = Integer.parseInt(line[1]);
            num = new int[N];
            M = new StringTokenizer(reader.readLine());
            for(int i = 0; i < N; i++) {
                num[i] = Integer.parseInt(M.nextToken());
                 
            }
            Arrays.sort(num);
            for(int i =N-K; i < N; i++) {
                result = (result + num[i])/2;
            }
            writer.write(resultStr.append(String.format("%.6f", result)).append("\n").toString());
        }
        writer.flush();
        writer.close();
    }
}