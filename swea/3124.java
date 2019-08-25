import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeSet;
 
public class Solution {
     
    static class Node implements Comparable<Node>{
        int vertex1;
        int vertex2;        
        int weight;
         
        public Node(int vertex1, int vertex2, int weight) {
            this.vertex1 = vertex1;
            this.vertex2 = vertex2;
            this.weight = weight;
        }
 
        @Override
        public int compareTo(Node o) {
            return (this.weight - o.weight) > 0 ? 1 : -1; // 오름 차순
        }
         
    }
     
     
    static int[] p;
    static long result;
    static int vCount;
     
    public static void makeSet(int x) {
        p[x] = x; 
    }
     
    public static int findSet(int x) {
        if(p[x] == x) return x;
         
        return p[x] = findSet(p[x]);
    }
     
    public static void union(Node node) {
        int root1 = findSet(node.vertex1);
        int root2 = findSet(node.vertex2);
        if(root1 == root2) return;
         
        p[root1] = root2;
        result += node.weight;
        vCount++;
    }
     
    public static void main(String[] args) throws Exception {
        BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        String[] line;
        // TreeSet - Compareable을 구현한 객체만 저장, 또는 생성시 Comparator 객체를 설정
        TreeSet<Node> ts = new TreeSet<Node>();
        p = new int[100001];
        for(int tc = 1 ; tc <=T; tc++) {
            vCount = 0;
            result = 0;
            line = reader.readLine().split(" ");
            int V = Integer.parseInt(line[0]);
            int E = Integer.parseInt(line[1]);
             
            for(int i = 0, end = V+1; i < end; i++) {
                makeSet(i);
            }
             
            for(int i = 0; i < E; i++) {
                line = reader.readLine().split(" ");
                ts.add(new Node(Integer.parseInt(line[0]), Integer.parseInt(line[1]), Integer.parseInt(line[2])));
            }
             
            int breakPoint = V-1;
            // 가중치를 기준으로 오름 차순으로 정렬된 데이터
            for(Node node : ts) {
                union(node);
                if(vCount == breakPoint) break;
            }
             
            System.out.println("#" + tc + " " + result);
            ts.clear();
        }
    }
}