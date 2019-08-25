import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;
 
public class Solution {
    static final int MAX_H = 15, MAX_W = 12;
    static int[][] map = new int[MAX_H][MAX_W];
    static int[] columns = new int[MAX_W];
    static int N, H, W;
    static int result;
     
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(reader.readLine());
        StringTokenizer tokens;
        for(int testCase = 1; testCase <= T; testCase++) {
            result = Integer.MAX_VALUE;
            tokens = new StringTokenizer(reader.readLine());
            N = Integer.parseInt(tokens.nextToken());
            W = Integer.parseInt(tokens.nextToken());
            H = Integer.parseInt(tokens.nextToken());
             
            for(int i = 0; i < H; i++) {
                tokens = new StringTokenizer(reader.readLine());
                for(int j = 0 ; j < W; j++) {
                    map[i][j] = Integer.parseInt(tokens.nextToken());
                    if(columns[j] == 0 && map[i][j] != 0) {
                        columns[j] = H - i;
                    }
                }
            }
             
            findMin(0, map, columns);
            if(result == Integer.MAX_VALUE) result = 0;
            writer.write(new StringBuilder(16).append('#').append(testCase).append(' ').append(result).append('\n').toString());
            Arrays.fill(columns, 0);
        }
        writer.flush();
        writer.close();
    }
     
    static void findMin(int turn,int[][] preMap, int[] preColumns) {
         
         
        if(turn == N) {
            int sum = 0;
            for(int j = 0; j < W; j++) {
                sum += preColumns[j];
            }
            result = Math.min(result, sum);
            return;
        }
         
         
        for(int j = 0; j < W; j++) {
            if(preColumns[j] != 0) {
                int[] newColumns = preColumns.clone();
                int[][] newMap = attack(preMap, j, newColumns);
                 
                clearMap(newMap, newColumns);
                 
                findMin(turn + 1, newMap, newColumns);
                 
            }
        }
    }
     
    static void printMap(int[][] preMap) {
        System.out.println("map");
        for(int i = 0 ; i < H; i++) {
            for(int j = 0; j < W; j++) {
                System.out.print(preMap[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
     
    static boolean isIndex(int x, int y) {
        if(0<= x && x < H && 0 <= y && y < W) return true;
        return false;
    }
     
    static final int[][] pos = new int[][] {{1, 0},{-1, 0},{0, 1},{0, -1}};
    static final int posSize = pos.length;
     
     
    static int[][] attack(int[][] pastMap, int attackPoint, int[] preColumns){
        int[][] newMap = new int[H][];
        for(int i = 0; i < H; i++) {
            newMap[i] = pastMap[i].clone();
        }
         
         
        LinkedList<Integer> queue = new LinkedList<>();
         
        int preX = H - preColumns[attackPoint];
        int preY = attackPoint;
        int power = newMap[preX][preY];
        newMap[preX][preY] = 0;
        queue.add(preX);
        queue.add(preY);
        queue.add(power);
         
        int nextX,nextY;
        while(!queue.isEmpty()) {
            preX = queue.poll();
            preY = queue.poll();
            power = queue.poll();
             
            for(int i = 0 ; i < posSize; i++) {
                nextX = preX +pos[i][0];
                nextY = preY +pos[i][1];
                 
                for(int k = 1; k < power; k++) {
                    if(isIndex(nextX, nextY) && newMap[nextX][nextY] != 0) {
                        queue.add(nextX);
                        queue.add(nextY);
                        queue.add(newMap[nextX][nextY]);
                        newMap[nextX][nextY] = 0;
                    }
                    nextX += pos[i][0];
                    nextY += pos[i][1];
                }
                 
            }
             
        }
         
        return newMap;
    }
     
    static void clearMap(int[][] preMap, int[] preColumns) {
         
        for(int j= 0; j < W; j++) {
            for(int i = H-1, end = H -  preColumns[j]; i >= end; i--) {
                if(preMap[i][j] != 0) {
                 
                    int downIndex = i+1;
                    while(downIndex < H && preMap[downIndex][j] == 0) {
                         
                        preMap[downIndex][j] = preMap[downIndex-1][j];
                        preMap[downIndex-1][j] = 0; 
                        downIndex++;
                    }
                     
                }
            }
        }
         
        for(int j = 0; j < W; j++) {
            int i = H-1, count = 0;
            while(i>=0 && preMap[i][j] != 0 ) {
                i--;
                count++;
            }
            preColumns[j]= count;
        }
    }
}