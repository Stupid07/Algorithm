import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, D, K, C;
	static int MAX, RESULT_MAX;
	static int[] list;
	static int[] check;
	
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(tokens.nextToken());
        D = Integer.parseInt(tokens.nextToken());
        K = Integer.parseInt(tokens.nextToken());
        C = Integer.parseInt(tokens.nextToken());
        list = new int[N];
        check = new int[D+1];
        RESULT_MAX = K + 1;
        int data, removeData, result = 0;
        for(int i = 0 ; i < K; i++) {
            data = Integer.parseInt(reader.readLine());
            list[i] = data;
            
            if(check[data] == 0) {
            	result++;
            }
            check[data]++;
        }
        if(check[C] != 0) {
            MAX = Math.max(MAX, result);
        }else {
            MAX = Math.max(MAX, result + 1);
        }
        
        int removeIndex = 0;
        for(int i = K; i < N && MAX != RESULT_MAX ; i++,removeIndex++) {
            data = Integer.parseInt(reader.readLine());
            removeData = list[removeIndex];
            
            check[removeData]--;
            if(check[removeData] == 0) {
            	result--;
            }
          
            if(check[data] == 0) {
            	result++;
            }
            list[i] = data;
            check[data]++;
            
            if(check[C] != 0) {
                MAX = Math.max(MAX, result);
            }else {
                MAX = Math.max(MAX, result + 1);
            }
        }
        removeIndex = N-K;
        for(int i = 0 ; i < K && MAX != RESULT_MAX; i++, removeIndex++) {
            data = list[i];
            removeData = list[removeIndex];
            
            check[removeData]--;
            if(check[removeData] == 0) {
            	result--;
            }
            
            if(check[data] == 0) {
            	result++;
            }
            check[data]++;
            
            if(check[C] != 0) {
                MAX = Math.max(MAX, result);
            }else {
                MAX = Math.max(MAX, result + 1);
            }
        }
         
        System.out.println(MAX);
	}
}
