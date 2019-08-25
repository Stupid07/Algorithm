import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
 
public class Solution {
    static int result;
    static int N;
    static int[] weight = new int[10];
    static boolean[] visited = new boolean[10];
     
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(reader.readLine());
        StringTokenizer tokens;
        for(int testCase = 1; testCase <= T; testCase++) {
            result = 0;
            N = Integer.parseInt(reader.readLine());
            tokens = new StringTokenizer(reader.readLine());
            int sum = 0;
            for(int i = 0 ; i < N; i++) {
                weight[i] = Integer.parseInt(tokens.nextToken());
                sum += weight[i];
            }
            find(0, 0, sum);
            writer.write(new StringBuilder(16).append('#').append(testCase).append(' ').append(result).append('\n').toString());
        }
        writer.flush();
        writer.close();
    }
     
    static void find(int count, int leftWeight, int anotherWeight ) {
        if(count == N) {
            result++;
            return;
        }
         
        if(leftWeight >= anotherWeight) {
            int num = N-count;
            int mul = (1<<num);
            for(int i = 2; i <= num; i++) {
                mul *= i;
            }
            result+= mul;
            return;
        }
         
        for(int i = 0 ; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                if(leftWeight >= weight[i]) {
                    find(count+1, leftWeight-weight[i], anotherWeight-weight[i]);
                }
                find(count+1, leftWeight+weight[i], anotherWeight-weight[i]);
                visited[i] = false;
            }
        }
         
         
    }
}