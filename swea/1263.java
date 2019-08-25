import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
 
public class Solution {
    static int[][] graph = new int[1000][1000];
    static final int GRAPH_MAX = 1000;
     
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(reader.readLine());
        StringTokenizer tokens;
        for(int test_case = 1; test_case <= T; test_case++) {
            int result = 0;
            tokens = new StringTokenizer(reader.readLine());
            int N = Integer.parseInt(tokens.nextToken());
            for(int i =0; i < N; i++) {
                for(int j=0; j < N; j++) {
                    int temp = Integer.parseInt(tokens.nextToken());
                    if(i==j) continue;
                    graph[i][j] = temp != 0 ? temp : GRAPH_MAX;
                }
            }
             
            for(int k =0; k < N; k++) {
                for(int i=0; i < N; i++) {
                    for(int j = 0; j < N; j++) {
                        graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                    }
                }
            }
            int min = Integer.MAX_VALUE;
            for(int i = 0; i < N; i++) {
                int sum = 0;
                for(int j = 0; j < N; j++) {
                    sum+=graph[i][j];
                }
                min = Math.min(sum, min);
            }
             
            writer.write("#"+test_case+" "+min + "\n");
        }
        writer.flush();
        writer.close();
    }
}