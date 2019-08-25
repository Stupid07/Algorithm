import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
 
public class Solution {
    static final int MAX_SIZE = 4;
    static final int FIN = 7;
    static int[][] map= new int[MAX_SIZE][MAX_SIZE];
    static HashSet<Integer> counter = new HashSet<>();
     
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder(10);
        int T = Integer.parseInt(reader.readLine());
        for(int test_case = 1; test_case <= T; test_case++) {
            for(int i=0; i < MAX_SIZE; i++) {
                String[] line = reader.readLine().split(" ");
                for(int j=0; j < MAX_SIZE; j++) {
                    map[i][j] = Integer.parseInt(line[j]);
                }
            }
            for(int i=0; i< MAX_SIZE; i++) {
                for(int j=0; j < MAX_SIZE; j++) {
                    findCombi(0, i, j, 0);
                }
            }
            writer.write(sb.append("#").append(test_case).append(" ").append(counter.size()).append("\n").toString());
            sb.setLength(0);
            counter.clear();
        }
        writer.flush();
        writer.close();
    }
     
    public static void findCombi(int num,int x, int y, int count) {
        num = num * 10 + map[x][y];
        count++;
         
        if(count == FIN) {
            counter.add(num);
            return;
        }
         
        if(isIndex(x+1,y)) findCombi(num,x+1,y,count);
        if(isIndex(x,y+1)) findCombi(num,x,y+1,count);
        if(isIndex(x-1,y)) findCombi(num,x-1,y,count);
        if(isIndex(x,y-1)) findCombi(num,x,y-1,count);
    }
     
    public static boolean isIndex(int x, int y) {
        if(0<= x && x < MAX_SIZE && 0<= y && y < MAX_SIZE)
            return true;
         
        return false;
    }
}