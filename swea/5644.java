import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;
 
public class Solution {
    static final int[][] pos = new int[][] {{0,0}, {-1,0}, {0,1}, {1,0}, {0,-1}}; // 제자리, 상, 우, 하, 좌
    static int M, BC, aX, aY, bX, bY;
    static int result;
    static int[] moveA = new int[101];
    static int[] moveB = new int[101];
    static LinkedList<Integer> passibleMoveA = new LinkedList<>();
    static LinkedList<Integer> passibleMoveB = new LinkedList<>();
    static int[][] batteryChargers = new int[8][4];
     
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(reader.readLine());
        StringTokenizer tokens;
        for(int testCase = 1; testCase <= T; testCase++) {
            result = 0;
            aX = aY = 1;
            bX = bY = 10;
            tokens = new StringTokenizer(reader.readLine());
            M = Integer.parseInt(tokens.nextToken());
            BC = Integer.parseInt(tokens.nextToken());
             
            tokens = new StringTokenizer(reader.readLine());
            for(int i = 1; i <= M; i++) {
                moveA[i] = Integer.parseInt(tokens.nextToken());
            }
             
            tokens = new StringTokenizer(reader.readLine());
            for(int i = 1; i <= M; i++) {
                moveB[i] = Integer.parseInt(tokens.nextToken());
            }
             
            int x, y, c, p;
            for(int i = 0; i < BC; i++) {
                tokens = new StringTokenizer(reader.readLine());
                x = Integer.parseInt(tokens.nextToken());
                y = Integer.parseInt(tokens.nextToken());
                c = Integer.parseInt(tokens.nextToken());
                p = Integer.parseInt(tokens.nextToken());
                batteryChargers[i][0] = y;
                batteryChargers[i][1] = x;// 주어지는값 반대(내가 사용하는값과)
                batteryChargers[i][2] = c;
                batteryChargers[i][3] = p;
            }
            //0에는 제자리인 0값이 들어가있어서 자기자리부터 마지막 이동까지 처리
            for(int i = 0 ; i <= M; i++) {
                aX += pos[moveA[i]][0];
                aY += pos[moveA[i]][1];
                bX += pos[moveB[i]][0];
                bY += pos[moveB[i]][1];
                 
                for(int bc = 0; bc < BC; bc++) {
                    x = batteryChargers[bc][0];
                    y = batteryChargers[bc][1];
                    c = batteryChargers[bc][2];
                    p = batteryChargers[bc][3];
                    if((Math.abs(aX-x) + Math.abs(aY-y)) <= c) {
                        passibleMoveA.add(bc);
                    }
                     
                    if((Math.abs(bX-x) + Math.abs(bY-y)) <= c) {
                        passibleMoveB.add(bc);
                    }
                }
                 
                 
                 
                int subMax = 0;
                for(int chargerA : passibleMoveA) {
                    for(int chargerB : passibleMoveB) {
                        if(chargerA != chargerB) {
                            subMax = Math.max(subMax, batteryChargers[chargerA][3] + batteryChargers[chargerB][3] );
                        }
                    }
                }
                     
                if(subMax == 0) {
                    for(int chargerA : passibleMoveA) {
                        subMax = Math.max(subMax, batteryChargers[chargerA][3]);
                    }
                         
                    for(int chargerB : passibleMoveB) {
                        subMax = Math.max(subMax, batteryChargers[chargerB][3]);
                    }
                }
                     
                    result += subMax;
             
                 
                 
                passibleMoveA.clear();
                passibleMoveB.clear();
            }
             
            writer.write(new StringBuilder(16).append('#').append(testCase).append(' ').append(result).append('\n').toString());
        }
        writer.flush();
        writer.close();
    }
}