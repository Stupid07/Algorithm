import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
 
public class Solution {
    static final char U ='^', D = 'v', L = '<', R= '>';
    static int H, W, N, x, y, direction; // direction : 0~3 UDLR
    static int[][] pos = new int[][]{{-1,0},{1,0},{0,-1},{0,1}}; // UDLR
    static char[][] map = new char[20][];
    static char[] commends;
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(reader.readLine());
        String[] words;
        String line;
        for(int test_case = 1; test_case <= T; test_case++) {
            words = reader.readLine().split(" ");
            H = Integer.parseInt(words[0]);
            W = Integer.parseInt(words[1]);
             
            for(int i=0; i < H; i++) {
                line = reader.readLine();
                map[i] = line.toCharArray();
                if(line.matches(".*[<\\^>v]+.*")) {
                    x = i;
                    y = line.split("[<\\^>v]")[0].length();
                    switch(map[x][y]) {
                        case U: direction =0; break;
                        case D: direction =1; break;
                        case L: direction =2; break;
                        case R: direction =3; break;
                    }
                }
            }
             
            N = Integer.parseInt(reader.readLine());
            commends = reader.readLine().toCharArray();
             
            execution();
             
            writer.write("#"+test_case+" ");
            for(int i = 0; i < H; i++) {
                writer.write(String.valueOf(map[i]));
                writer.write("\n");
            }
        }
        writer.flush();
        writer.close();
    }
     
     
     
    static void move() {
        int nextX = x + pos[direction][0];
        int nextY = y + pos[direction][1];
        if(isIndex(nextX,nextY) &&  map[nextX][nextY] == '.') {
            map[nextX][nextY] = map[x][y];
            map[x][y] = '.';
            x = nextX;
            y = nextY;
        }
    }
     
    static void execution() {
        for(int i =0, size = commends.length; i < size; i++) {
            switch(commends[i]) {
            case 'U':
                map[x][y] = U;
                direction = 0;
                move();
                break;
            case 'D':
                map[x][y] = D;
                direction = 1;
                move();
                break;
            case 'L':
                map[x][y] = L;
                direction = 2;
                move();
                break;
            case 'R':
                map[x][y] = R;
                direction = 3;
                move();
                break;
            case 'S':
                int nextX = x;
                int nextY = y;
                do {
                    nextX += pos[direction][0];
                    nextY += pos[direction][1];
                }while(isIndex(nextX,nextY) && (map[nextX][nextY] == '.' || map[nextX][nextY] == '-'));
                if(isIndex(nextX,nextY) && map[nextX][nextY] == '*') map[nextX][nextY] = '.';
                break;
            }
        }
    }
     
    static boolean isIndex(int x, int y) {
        if(0 <= x && x < H && 0 <= y && y < W)
            return true;
        return false;
    }
}