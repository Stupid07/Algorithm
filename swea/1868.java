import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
 
public class Solution {
    static final int[][] pos = {{-1,0}, {-1,1},{0,1}, {1,1}, {1,0}, {1,-1}, {0,-1}, {-1,-1}};
    static final int posSize = pos.length;
    static int N;
    static int[][] map = new int[300][300];
    static LinkedList<int[]> queue = new LinkedList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(reader.readLine());
        StringBuilder result;
        String line;
        int nextX, nextY, preX, preY;
        int count;
        for(int test_case = 1; test_case <= T; test_case++) {
            result = new StringBuilder(8).append("#").append(test_case).append(" ");
            N = Integer.parseInt(reader.readLine());
            count = 0;
            for(int i = 0; i < N; i++) {
                line = reader.readLine();
                for(int j = 0; j< N; j++) {
                    if(line.charAt(j) == '*') {
                        map[i][j] = -1;
                        for(int k = 0 ; k < posSize; k++) {
                            nextX = i + pos[k][0];
                            nextY = j + pos[k][1];
                            if(isIndex(nextX, nextY) && map[nextX][nextY] != -1) {
                                map[nextX][nextY]++;
                            }
                        }
                    }
                }
            }
             
            for(int i = 0 ; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(map[i][j] == 0) {
                        count++;
                        queue.add(new int[] {i, j});
                        map[i][j] = -1;
                        while(!queue.isEmpty()) {
                            int[] temp = queue.poll();
                            preX = temp[0];
                            preY = temp[1];
                            for(int k = 0; k < posSize; k++) {
                                nextX = preX + pos[k][0];
                                nextY = preY + pos[k][1];
                                if(isIndex(nextX, nextY) && map[nextX][nextY] != -1) {
                                    if(map[nextX][nextY] == 0) {
                                        queue.add(new int[] {nextX,nextY});
                                    }
                                    map[nextX][nextY] = -1;
                                }
                            }
                        }
                         
                    }else if(map[i][j] != -1){
                         
                        boolean isZero = false;
                         
                        for(int k = 0; k < posSize; k++) {
                            nextX = i + pos[k][0];
                            nextY = j + pos[k][1];
                            if(isIndex(nextX, nextY) && map[nextX][nextY] == 0) {
                                isZero = true;
                                break;
                            }
                        }
                         
                        if(!isZero) {
                            count++;
                        }
                         
                    }
                     
                }
            }
            result.append(count);
            writer.write(result.append("\n").toString());
            for(int i = 0; i < N ;i++) {
                Arrays.fill(map[i], 0, N, 0);
            }
        }
        writer.flush();
        writer.close();
    }
     
    static boolean isIndex(int x, int y) {
        if(0<= x && x < N && 0 <= y && y < N)
            return true;
        return false;
    }
}