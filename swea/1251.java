import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Solution {
    static double[][] map = new double[1000][1000];
    static long[][] pos = new long[1000][2];
    static boolean[] visited = new boolean[1000];
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(reader.readLine());
        StringTokenizer xTokens, yTokens;
        long preX, preY;
        double env;
        for(int test_case = 1; test_case <= T; test_case++) {
            double result = 0.0;
            int N = Integer.parseInt(reader.readLine());
            xTokens = new StringTokenizer(reader.readLine());
            yTokens = new StringTokenizer(reader.readLine());
            double E = Double.parseDouble(reader.readLine());
            for(int j=0 ; j< N; j++) {
                preX = Long.parseLong(xTokens.nextToken());
                preY = Long.parseLong(yTokens.nextToken());
                pos[j][0] = preX;
                pos[j][1] = preY;
                for(int i = 0; i < j; i++) {
                    env = E * (Math.pow(preX - pos[i][0],2) + Math.pow(preY - pos[i][1], 2));
                    map[j][i] = map[i][j] = env;
                }
            }
             
            //선택한 정점을 저장하는 배열
            ArrayList<Integer> selected = new ArrayList<Integer>(N);
            int index;
            double min;
            selected.add(0);
            visited[0] = true;
            for(int i = 0; i < N-1; i++) {
                min = Double.MAX_VALUE;
                index = -1;         // 가중치가 가장 작은 정점의 값
                for(Integer v : selected) {
                    // 선택된 정점에서 갈수 있는 모든 정점의 가중치를 비교해서 최소가 되는 정점을 찾기
                    for(int j = 0 ; j  < N; j++) { //인접된 정점 탐색
                        // 정점이 인접되어 있고 인접된 정점이 방문하지 않은 정점
                        if(!visited[j] && map[v][j] < min && map[v][j] != 0) {
                            min = map[v][j];
                            index = j;
                        }
                    }
                }
                 
                if(index != -1) {
                    result += min;          // 최소의 합을 구하기
                    selected.add(index);    // 선택한 최저 가중치에 해당하는 정점을 추가
                    visited[index] = true;  // 선택했기 때문에 방문 표시
                }
            }
             
            Arrays.fill(visited, false);
            writer.write("#"+test_case+" "+Math.round(result) + "\n");
        }
        writer.flush();
        writer.close();
    }
}