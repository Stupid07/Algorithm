import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
/*
 * 벡터의 합
 * 예) 4개의 점 A(x1, y1), B(x2, y2), C(x3, y3), D(x4, y4)의 연결 벡터
 * 두 그룹으로 나눠서 짝을 찾게되면 어떻게 짝을 연결하더라도 벡터의 총 합은 동일 하다.
 * groubA (A + B) - groubB(C + D)
 */
 
 
public class Solution {
    static int[][]  pos;
    static boolean[] visited;
    static long min;
    static int N;
    static int MID;
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        StringTokenizer tokens;
        for(int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(reader.readLine());
            MID = N>>1;
            min = Long.MAX_VALUE;
            pos = new int[N][2];
            visited = new boolean[N];
            for(int i = 0; i < N; i++) {
                tokens = new StringTokenizer(reader.readLine());
                pos[i][0] = Integer.parseInt(tokens.nextToken());
                pos[i][1] = Integer.parseInt(tokens.nextToken());
            }
            dfs(0, 0);
            System.out.println("#" + test_case + " " +min);
        }
    }
     
     
    private static void dfs(int from, int cnt) {
        if(cnt == MID) {    // 두 그룹으로 나눠서 선택한 그룹의 카운트
            long x = 0, y = 0;
            //visited에 있는 값을 기준으로 선택한 그룹(A그룹)과 선택되지 않은 그룹(B그룹)으로 나눔
            for(int i = 0; i< N; i++) {
                if(visited[i]) {
                    x+= pos[i][0];
                    y+= pos[i][1];
                }else {
                    x-= pos[i][0];
                    y-= pos[i][1];
                }
            }
            min = Math.min(min, x*x + y*y);
            return;
        }
        for(int i = from; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(i+1, cnt+1);
                visited[i] = false;
            }
        }
    }
}