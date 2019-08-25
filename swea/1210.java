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
        int test_case, result, data;
        final int MAXSIZE = 100;
        int[] goal = new int[MAXSIZE];
        int preIdx = 0,temp, resultIdx=0;
        boolean isSwap;
         
        for(int t = 0; t < 10; t++) {
            test_case = Integer.parseInt(reader.readLine());
            result = 0;
            for(int i = 0; i < MAXSIZE; i++) {
                isSwap = false;
                preIdx = 0;
                token = new StringTokenizer(reader.readLine());
                for(int j = 0; j < MAXSIZE; j++) {
                    data = Integer.parseInt(token.nextToken());
                    if(i == 0) {
                        if(data == 1)
                            goal[j] = j;
                        else
                            goal[j] = -1;
                    }
                     
                    if(goal[j] != -1) {
                        if(isSwap) {
                            temp = goal[preIdx];
                            goal[preIdx] = goal[j];
                            goal[j] = temp;
                            isSwap = false;
                        }
                        preIdx = j;
                    }else if(data == 1) {
                        isSwap = true;
                    }
                     
                    if(data == 2)
                        resultIdx = j;
 
                }
            }
             
            result = goal[resultIdx];
             
            writer.write("#"+test_case+" "+result + "\n");
        }
        writer.flush();
        writer.close();
    }
}