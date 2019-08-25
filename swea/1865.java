import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Solution {
    static final int MAX_N = 16;
    static int N;
    static double[][] percentage = new double[MAX_N][MAX_N];
    static boolean[] selected = new boolean[MAX_N];
    static double result;
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(reader.readLine());
        StringTokenizer tokens;
        for(int test_case = 1; test_case <= T; test_case++) {
            result = 0.0;
            N = Integer.parseInt(reader.readLine());
            for(int i = 0; i < N; i++) {
                tokens = new StringTokenizer(reader.readLine());
                for(int j = 0; j < N; j++) {
                    percentage[i][j] = Double.parseDouble(tokens.nextToken()) / 100.0;
                }
            }
            findSuccess(0, 1.0);
            writer.write(String.format("#%d %.6f\n", test_case,result*100.0));
            Arrays.fill(selected, false);
        }
        writer.flush();
        writer.close();
    }
     
    static void findSuccess(int idx,double subResult) {
        if(idx == N) {
            result = Math.max(result, subResult);
            return;
        }else if(subResult <= result) {
            return;
        }
         
        for(int i = 0; i < N; i++) {
            if(!selected[i]) {
                selected[i] = true;
                findSuccess(idx + 1, subResult * percentage[idx][i]);
                selected[i] = false;
            }
        }
    }
}