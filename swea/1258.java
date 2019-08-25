import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
 
public class Solution {
    static int N;
    static int[] rows = new int[100];
     
    static PriorityQueue<Matrix> matrixs = new PriorityQueue<>();
     
    static class Matrix implements Comparable<Matrix>{
        int row;
        int column;
        int weight;
         
        public Matrix(int row, int column) {
            this.row = row;
            this.column = column;
            weight = row* column;
        }
 
        @Override
        public int compareTo(Matrix o) {
            if(this.weight > o.weight) return 1;
            else if(this.weight < o.weight) return -1;
            else return this.row - o.row;
        }
         
    }
     
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(reader.readLine());
        StringBuilder result;
        String[] words;
        for(int test_case = 1; test_case <= T; test_case++) {
            result = new StringBuilder(32).append("#").append(test_case).append(" ");
            N = Integer.parseInt(reader.readLine());
             
            for(int i = 0; i < N; i++) {
                String line = reader.readLine();
                words = line.replace(" ","").split("[0]+");
                for(int j =0, end = words.length; j < end; j++) {
                    rows[words[j].length()]++;
                }
                 
            }
             
            for(int i = 1; i < N; i++) {
                if(rows[i] != 0) {
                    matrixs.add(new Matrix(rows[i], i));
                }
            }
             
             
            result.append(matrixs.size()).append(" ");
            while(!matrixs.isEmpty()) {
                Matrix preMatrix = matrixs.poll();
                result.append(preMatrix.row).append(" ").append(preMatrix.column).append(" ");
            }
             
            Arrays.fill(rows, 0,N,0);
            writer.write(result.append("\n").toString());
        }
        writer.flush();
        writer.close();
    }
     
     
}