import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.TreeMap;
 
public class Solution {
    static int N;
    static TreeMap<Integer, int[]> map = new TreeMap<>();
    static int[][] direction = new int[][] {{1,0}, {-1,0}, {0,1}, {0,-1}};
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(reader.readLine());
        StringTokenizer tokens;
        StringBuilder resultStr;
        for(int test_case = 1; test_case <= T; test_case++) {
            int result = 0,startIndex = 1;
            N = Integer.parseInt(reader.readLine());
            for(int i = 0; i < N; i++) {
                tokens = new StringTokenizer(reader.readLine());
                for(int j = 0; j <N ; j++) {
                    int value = Integer.parseInt(tokens.nextToken());
                    map.put(value, new int[] {i,j});
                }
            }
             
            int tempIndex = 1,count = 1,subMax = 1, preX =-2, preY=-2, nextX, nextY;
            for(int[] pos : map.values()) {
                nextX = pos[0];
                nextY = pos[1];
                 
                int i;
                for(i=0; i < 4; i++) {
                    if(preX + direction[i][0] == nextX && preY + direction[i][1] == nextY) {
                        subMax++;
                        break;
                    }
                }
                 
                if(result < subMax) {
                    result = subMax;
                    startIndex = tempIndex;
                }
                 
                if(i >= 4) {
                    tempIndex = count;
                    subMax = 1;
                }
                 
                preX = nextX;
                preY = nextY;
                count++;
            }
             
            resultStr = new StringBuilder(16).append("#").append(test_case).append(" ").append(startIndex).append(" ").append(result).append("\n");
            writer.write(resultStr.toString());
            map.clear();
        }
        writer.flush();
        writer.close();
    }
}