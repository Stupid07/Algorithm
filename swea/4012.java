import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Solution {
    static final int MAX_FOOD = 16;
    static int N;
    static int HALF_N;
    static int[][] map = new int[MAX_FOOD][MAX_FOOD];
    static boolean[] selected = new boolean[MAX_FOOD];
    static int result;
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(reader.readLine());
        StringTokenizer tokens;
        for(int test_case = 1; test_case <= T; test_case++) {
            result = Integer.MAX_VALUE;
            N = Integer.parseInt(reader.readLine());
            HALF_N = N/2;
            for(int i = 0; i < N; i++) {
                tokens = new StringTokenizer(reader.readLine());
                for(int j = 0; j< N; j++) {
                    int data = Integer.parseInt(tokens.nextToken());
                    if(i < j) {
                        map[i][j] +=data;
                    }else if(i > j) {
                        map[j][i] +=data;
                    }
                }
            }
             
            findMin(0, 0);
             
            writer.write(new StringBuilder(16).append("#").append(test_case).append(" ").append(result).append("\n").toString());
            for(int i = 0 ; i < N; i++) {
                Arrays.fill(map[i], 0, N, 0);
            }
            Arrays.fill(selected, false);
        }
        writer.flush();
        writer.close();
    }
     
    static void findMin(int idx, int count) {
        if(count == HALF_N) {
            int resultA = 0, resultB = 0;
            for(int i = 0; i < N; i++) {
                for(int j = i+1; j < N; j++) {
                    if(selected[i] && selected[j]) {
                        resultA+=map[i][j];
                    }else if(!selected[i] && !selected[j]){
                        resultB+=map[i][j];
                    }
                }
            }
            result = Math.min(result, Math.abs(resultA-resultB));
            return;
        }
         
        for(int i = idx; i < N; i++) {
            if(!selected[i]) {
                selected[i] = true;
                findMin(i+1, count+1);
                selected[i] = false;
            }
        }
         
         
    }
}