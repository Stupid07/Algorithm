import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
 
public class Solution {
    static int N;
    static int MIN;
    static boolean[][] matrix = new boolean[8][8];
    static int[] colors = new int[8];
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(reader.readLine());
        StringTokenizer tokens;
        for(int test_case = 1; test_case <= T; test_case++) {
            int result = 0;
            MIN = Integer.MAX_VALUE;
            N = Integer.parseInt(reader.readLine());
            tokens = new StringTokenizer(reader.readLine());
            for(int i = 0; i <N; i++) {
                colors[i] = Integer.parseInt(tokens.nextToken());
            }
             
            for(int i = 0; i< N; i++) {
                tokens = new StringTokenizer(reader.readLine());
                for(int j = 0; j< N; j++) {
                    if(tokens.nextToken().charAt(0) == '1') {
                        matrix[i][j] = true;
                    }else {
                        matrix[i][j] = false;
                    }
                }
            }
             
            findMin(0, 0);
             
            writer.write(new StringBuilder(8).append("#").append(test_case).append(" ").append(MIN).append("\n").toString());
        }
        writer.flush();
        writer.close();
    }
     
    static void findMin(int idx, int count) {
        if(idx == N) {
            boolean isTrue = true;
            for(int i = 0 ; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(matrix[i][j]  &&colors[i] == colors[j]) {
                        isTrue = false;
                        break;
                    }
                }
            }
            if(isTrue) { 
                MIN = Math.min(MIN, count);
            }
            return;
        }
         
        int tempColor;
        for(int i = 1; i < 5; i++) {
            if(colors[idx] == i) {
                findMin(idx+1, count);
            }else {
                tempColor = colors[idx];
                colors[idx] = i;
                findMin(idx+1, count+1);
                colors[idx] = tempColor;
            }
             
        }
         
    }
}