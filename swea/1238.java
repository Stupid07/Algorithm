import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
 
public class Solution {
    static int startNode;
    static int N;
    static boolean[][] map = new boolean[101][101];
    static boolean[] visited = new boolean[101];
     
    static class Node implements Comparable<Node>{
        int number;
        int count;
         
        public Node(int number, int count) {
            this.number = number;
            this.count = count;
        }
 
        @Override
        public int compareTo(Node o) {
            if(this.count > o.count) {
                return 1;
            }else if(this.count < o.count) {
                return -1;
            }else {
                return this.number - o.number;
            }
        }
    }
     
    static PriorityQueue<Node> queue =new PriorityQueue<>();
     
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        //int T = Integer.parseInt(reader.readLine());
        String[] line;
        StringTokenizer tokens;
        for(int test_case = 1; test_case <= 10; test_case++) {
            line = reader.readLine().split(" ");
            N = Integer.parseInt(line[0]);
            startNode = Integer.parseInt(line[1]);
            tokens = new StringTokenizer(reader.readLine());
            for(int i = 0; i < N; i+=2) {
                map[Integer.parseInt(tokens.nextToken())][Integer.parseInt(tokens.nextToken())] = true;
            }
             
            visited[startNode] = true;
            Node preNode;
            int preNumber= startNode, preCount = 0;
            queue.add(new Node(preNumber, preCount));
            while(!queue.isEmpty()) {
                preNode = queue.poll();
                preNumber = preNode.number;
                preCount = preNode.count;
                 
                for(int i = 1; i <= 100; i++) {
                    if(map[preNumber][i] && !visited[i]) {
                        queue.add(new Node(i, preCount +1));
                        visited[i] = true;
                    }
                }
            }
             
            writer.write(new StringBuilder(8).append("#").append(test_case).append(" ").append(preNumber).append("\n").toString());
            Arrays.fill(visited, false);
            for(int i = 0 ; i <= 100; i++) {
                Arrays.fill(map[i], false);
            }
        }
        writer.flush();
        writer.close();
    }
}