import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
 
public class Solution {
    static final int MAX_DIRECTION = 4, MAX_MEMORY = 16;
    static int ROW, COLUMN;
    static char[][] map = new char[20][20];
    static boolean[][][][] visited = new boolean[20][20][MAX_DIRECTION][MAX_MEMORY];
    static boolean isStop;
    static boolean isEnd;
     
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(reader.readLine());
        String[] words;
        for(int test_case = 1; test_case <= T; test_case++) {
            isStop = isEnd = false;
            words = reader.readLine().split(" ");
            ROW = Integer.parseInt(words[0]);
            COLUMN = Integer.parseInt(words[1]);
            for(int row = 0; row < ROW ;row++) {
                String line = reader.readLine();
                for(int column = 0; column < COLUMN; column++) {
                    map[row][column] = line.charAt(column);
                    if(map[row][column] == '@') isEnd = true;
                }
            }
             
             
            if(isEnd) {
                findEnd(0, 0, 0, 1);
            }
             
            if(isStop) {
                writer.write(String.format("#%d YES\n",test_case));
            }else {
                writer.write(String.format("#%d NO\n",test_case));
            }
             
            for(int row = 0; row < ROW; row++) {
                for(int column = 0; column < COLUMN; column++) {
                    for(int direction = 0; direction < MAX_DIRECTION; direction++) {
                        Arrays.fill(visited[row][column][direction], 0, MAX_MEMORY, false);
                    }
                }
            }
        }
        writer.flush();
        writer.close();
    }
    // direction 0 : <  //  1 : > // 2 : ^ // 3 : v
    static void findEnd(int x, int y, int memory, int direction) {
        char data = map[x][y];
        visited[x][y][direction][memory] = true;
        boolean isQuestion = false;
        switch (data) {
        case '<':            
            direction = 0;
            break;
        case '>':
            direction = 1;
            break;
        case '^':
             
            direction = 2;
            break;
        case 'v':
            direction = 3;
            break;
        case '_':
            if(memory == 0) {
                direction = 1;
            }else {
                direction = 0;
            }
            break;
        case '|':
            if(memory == 0) {
                direction = 3;
            }else {
                direction = 2;
            }
            break;
        case '?': // 특이 케이스
            isQuestion = true;
            break;
        case '.':// 아무것도 하지않음
            break;
        case '@':
            isStop = true;
            return;
        case '0':
        case '1':
        case '2':
        case '3':
        case '4':
        case '5':
        case '6':
        case '7':
        case '8':
        case '9':
            memory = data - '0'; 
            break;
        case '+':
            if(memory == 15) {
                memory = 0;
            }else {
                memory++;
            }
            break;
        case '-':
            if(memory == 0) {
                memory = 15;
            }else {
                memory--;
            }
            break;
        }
         
         
        if(isStop) {
            return;
        }else if(isQuestion) {
            if(y == 0) {
                if(!visited[x][COLUMN-1][0][memory])
                    findEnd(x, COLUMN-1, memory, 0);
            }else {
                if(!visited[x][y-1][0][memory])
                    findEnd(x, y-1, memory, 0);
            }
             
            if(y == COLUMN-1) {
                if(!visited[x][0][1][memory])
                    findEnd(x, 0, memory, 1);
            }else {
                if(!visited[x][y+1][1][memory])
                    findEnd(x, y+1, memory, 1);
            }
             
            if(x == 0) {
                if(!visited[ROW-1][y][2][memory])
                    findEnd(ROW-1, y, memory, 2);
            }else {
                if(!visited[x-1][y][2][memory])
                    findEnd(x-1, y, memory, 2);
            }
             
            if(x == ROW-1) {
                if(!visited[0][y][3][memory])
                    findEnd(0, y, memory, 3);
            }else {
                if(!visited[x+1][y][3][memory])
                    findEnd(x+1, y, memory, 3);
            }
             
        }else {
            // direction 0 : <  //  1 : > // 2 : ^ // 3 : v
            switch (direction) {
            case 0:
                if(y == 0) {
                    if(!visited[x][COLUMN-1][direction][memory])
                        findEnd(x, COLUMN-1, memory, direction);
                }else {
                    if(!visited[x][y-1][direction][memory])
                        findEnd(x, y-1, memory, direction);
                }
                break;
            case 1:
                if(y == COLUMN-1) {
                    if(!visited[x][0][direction][memory])
                        findEnd(x, 0, memory, direction);
                }else {
                    if(!visited[x][y+1][direction][memory])
                        findEnd(x, y+1, memory, direction);
                }
                break;
            case 2:
                if(x == 0) {
                    if(!visited[ROW-1][y][direction][memory])
                        findEnd(ROW-1, y, memory, direction);
                }else {
                    if(!visited[x-1][y][direction][memory])
                        findEnd(x-1, y, memory, direction);
                }
                break;
            case 3:
                if(x == ROW-1) {
                    if(!visited[0][y][direction][memory])
                        findEnd(0, y, memory, direction);
                }else {
                    if(!visited[x+1][y][direction][memory])
                        findEnd(x+1, y, memory, direction);
                }
                break;
            }
        }
         
    }
}