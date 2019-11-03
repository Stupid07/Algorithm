import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token = null;
        int test_case, data;
        final int MAXSIZE = 100;
        int[][] map = new int[MAXSIZE][2];
        int preIdx = 0,temp, minValue, resultIdx=0;
        boolean isSwap;
         
        for(int t = 0; t < 10; t++) {
            test_case = Integer.parseInt(reader.readLine());
            for(int i = 0; i < MAXSIZE; i++) {
                isSwap = false;
                preIdx = 0;
                token = new StringTokenizer(reader.readLine());
                for(int j = 0; j < MAXSIZE; j++) {
                    data = Integer.parseInt(token.nextToken());
                    if(i == 0) {
                        if(data == 1) {
                            map[j][0] = j;
                            map[j][1] = 1;
                        }else {
                            map[j][0] = -1;
                            map[j][1] = 0;
                        }
                    }
                     
                    if(map[j][0] != -1) {
                    	map[j][1]++;
                        if(isSwap) {
                            temp = map[preIdx][0];
                            map[preIdx][0] = map[j][0];
                            map[j][0] = temp;
                            temp = map[preIdx][1];
                            map[preIdx][1] = map[j][1];
                            map[j][1] = temp;
                            map[preIdx][1] += j-preIdx;
                            map[j][1] += j-preIdx;
                            isSwap = false;
                        }
                        preIdx = j;
                    }else if(data == 1) {
                        isSwap = true;
                    }
                    
 
                }
            }
            minValue = Integer.MAX_VALUE;
            for(int i = MAXSIZE-1; i >= 0; i--) {
            	if(map[i][0] != -1 && map[i][1] < minValue) {
            		minValue = map[i][1];
            		resultIdx = i;
            	}
            }
             
            writer.write(String.format("#%d %d\n",test_case,map[resultIdx][0]));
        }
        writer.close();
    }
}