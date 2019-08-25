import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;
 
public class Solution {
    static final char SCAT = 'S', VILLAIN = 'V', ESCAPE = 'E';
    static final char SPACE = 'A', PASS_WALL = 'W', NOT_PASS_WALL = 'X', FIRE = 'F';
    static final int[][] pos = new int[][] {{-1,0}, {1,0}, {0,-1}, {0,1}};
    static final int posSize = pos.length;
     
    static int ROW, COLUMN, K;
    static char[][] map = new char[1000][1000];
    static int result;
     
    static LinkedList<int[]> scatQueue = new LinkedList<>();
    static boolean[][] scatVisited = new boolean[1000][1000];
     
    static LinkedList<int[]> villainQueue = new LinkedList<>();
    static boolean[][] villainVisited = new boolean[1000][1000];
     
    static LinkedList<int[]> fireQueue = new LinkedList<>();
     
    static LinkedList<int[]> tempQueue = new LinkedList<>();
     
    static boolean isIndex(int x, int y) {
        if(0<= x && x < ROW && 0<= y && y < COLUMN) return true;
        return false;
    }
     
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(reader.readLine().trim());
        StringTokenizer tokens;
        String line;
        for(int test_case = 1; test_case <= T; test_case++) {
            tokens = new StringTokenizer(reader.readLine().trim());
            ROW = Integer.parseInt(tokens.nextToken());
            COLUMN = Integer.parseInt(tokens.nextToken());
            K = Integer.parseInt(tokens.nextToken());
            for(int i = 0; i < ROW; i++) {
                line = reader.readLine();
                for(int j = 0; j< COLUMN; j++) {
                    map[i][j] = line.charAt(j);
                    switch(map[i][j]) {
                    case SCAT:
                        scatQueue.add(new int[] {i, j, K});
                        map[i][j] = PASS_WALL;
                        scatVisited[i][j] = true;
                        break;
                    case VILLAIN:
                        villainQueue.add(new int[] {i, j});
                        map[i][j] = PASS_WALL;
                        villainVisited[i][j] = true;
                        break;
                    case FIRE:
                        fireQueue.add(new int[] {i, j});
                        break;
                    }
                }
            }
             
            boolean isScatEscape = true, arriveEscape = false;
            int turn = 0; 
            int scatX, scatY,scatK, villainX, villainY, fireX, fireY, nextX, nextY;
            int[] tempPos;
             
            while(isScatEscape) {
                turn++;
                while(!fireQueue.isEmpty()) {
                    tempPos = fireQueue.poll();
                    fireX = tempPos[0];
                    fireY = tempPos[1];
                    for(int i = 0; i < posSize; i++) {
                        nextX = fireX + pos[i][0];
                        nextY = fireY + pos[i][1];
                        if(isIndex(nextX, nextY) && (map[nextX][nextY] == SPACE)) {
                            tempQueue.add(new int[] {nextX, nextY});
                            map[nextX][nextY] = FIRE;
                        }
                    }
                }
                fireQueue.addAll(tempQueue);
                tempQueue.clear();
                 
                while(!scatQueue.isEmpty()) {
                    tempPos = scatQueue.poll();
                    scatX = tempPos[0];
                    scatY = tempPos[1];
                    scatK = tempPos[2];
                     
                    for(int i = 0; i < posSize; i++) {
                        nextX = scatX + pos[i][0];
                        nextY = scatY + pos[i][1];
                         
                        if(isIndex(nextX, nextY) && !scatVisited[nextX][nextY]) {
                            if(map[nextX][nextY] == SPACE) {
                                scatVisited[nextX][nextY] = true;
                                tempQueue.add(new int[] {nextX, nextY, K});
                            }else if(map[nextX][nextY] == PASS_WALL && scatK > 0) {
                                tempQueue.add(new int[] {nextX, nextY, scatK -1});
                            }else if(map[nextX][nextY] == ESCAPE) {
                                arriveEscape = true;
                                break;
                                //탈출!
                            }
                        }
                    }
                }
                scatQueue.addAll(tempQueue);
                tempQueue.clear();
                 
                 
                while(!villainQueue.isEmpty()) {
                    tempPos = villainQueue.poll();
                    villainX = tempPos[0];
                    villainY = tempPos[1];
                    for(int i = 0; i < posSize; i++) {
                        nextX = villainX + pos[i][0];
                        nextY = villainY + pos[i][1];
                         
                        if(isIndex(nextX, nextY) && !villainVisited[nextX][nextY]) {
                            villainVisited[nextX][nextY] = true;
                            if(map[nextX][nextY] == SPACE) {
                                tempQueue.add(new int[] {nextX, nextY});
                            }else if(map[nextX][nextY] == FIRE) {
                                tempQueue.add(new int[] {nextX, nextY});
                            }else if(map[nextX][nextY] == ESCAPE) {
                                arriveEscape = true;
                                turn = -1;
                                break;
                                //탈출!
                            }
                        }
                    }
                }
                villainQueue.addAll(tempQueue);
                tempQueue.clear();
                 
                if(arriveEscape) {
                    break;
                }
                 
                if(scatQueue.isEmpty()) {
                    isScatEscape = false;
                    turn =-1;
                    break;
                }
                 
                 
                 
            }
             
             
            writer.write("#"+test_case+" "+turn + "\n");
             
            scatQueue.clear();
            villainQueue.clear();
            fireQueue.clear();
            tempQueue.clear();
             
            for(int i = 0; i < ROW; i++) {
                Arrays.fill(scatVisited[i], 0, COLUMN, false);
                Arrays.fill(villainVisited[i], 0, COLUMN, false);
            }
             
        }
        writer.flush();
        writer.close();
    }
}