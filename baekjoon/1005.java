import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(reader.readLine());
		StringTokenizer tokens;
		String[] words;
		int N, K, W, result, start, end;
		int[] nodes = new int[1000], inDegree = new int[1000], delay = new int[1000];
		List<List<Integer>> adjacencyList = new ArrayList<>(1000);
		for(int i = 0; i < 1000; i++) {
			adjacencyList.add(new LinkedList<>());
		}
		
		
		for(int testCase = 0; testCase < T; testCase++) {
			tokens = new StringTokenizer(reader.readLine());
			N = Integer.parseInt(tokens.nextToken());
			K = Integer.parseInt(tokens.nextToken());
			
			tokens = new StringTokenizer(reader.readLine());
			for(int i = 0; i < N; i++) {
				nodes[i] = Integer.parseInt(tokens.nextToken());
				inDegree[i] = 0;
				delay[i] = 0;
				adjacencyList.get(i).clear();
			}
			
			for(int i = 0; i < K; i++) {
				words = reader.readLine().split(" ");
				start = Integer.parseInt(words[0])-1;
				end = Integer.parseInt(words[1]) -1;
				adjacencyList.get(start).add(end);
				inDegree[end]++;
			}
			
			W = Integer.parseInt(reader.readLine());
			result = topologySort(W-1, adjacencyList, inDegree, nodes, delay);
			writer.write(String.format("%d\n", result));
		}
		writer.close();
		
	}
	
	public static int topologySort(int goal, List<List<Integer>> adjacencyList, int[] inDegree, int[] nodes, int[] delay){
        LinkedList<Integer> queue = new LinkedList<>();
        int size = inDegree.length;
        
        for(int i = 0 ; i < size; i++){
            if(inDegree[i] == 0){
                queue.offer(i);
                delay[i] = nodes[i];
            }
        }

        int currentNode, connectedNode;
        List<Integer> currentList;
        
        for(int i = 0 ; i < size; i++){
            currentNode = queue.poll();
            if(currentNode == goal) {
            	break;
            }
            currentList = adjacencyList.get(currentNode);
            for(int j = 0, len = currentList.size(); j < len; j++){
                connectedNode = currentList.get(j);
                inDegree[connectedNode]--;
                delay[connectedNode] = Math.max(delay[connectedNode], delay[currentNode] + nodes[connectedNode]);
                if(inDegree[connectedNode] == 0){
                    queue.offer(connectedNode);
                }
            }
        }
        
        return delay[goal];
    }
}
