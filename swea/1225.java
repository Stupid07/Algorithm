import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
 
public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        final int MAX = 8;
        final int[] minus = {1,2,3,4,5};
        int[] num = new int[MAX];
        boolean isMinus;
        int idx, testCase;
        StringBuilder result;
        while(reader.ready()) {
            result = new StringBuilder();
            testCase = Integer.parseInt(reader.readLine());
            String[] line = reader.readLine().split(" ");
            for(int i = 0; i < MAX; i++)
                num[i] = Integer.parseInt(line[i]);
             
            isMinus = true;
            idx =0;
            while(isMinus) {
                for(int m : minus) {
                    num[idx]-=m;
                    if(num[idx] <= 0) {
                        isMinus =false;
                        num[idx] = 0;
                        break;
                    }
                    idx = (++idx) % MAX;
                }
            }
             
            result.append("#").append(testCase).append(" ");
            for(int i=0; i < MAX; i++) {
                idx = (++idx) % MAX;
                result.append(num[idx]).append(" ");
            }
            result.append("\n");
            writer.write(result.toString());
        }
         
        writer.flush();
        writer.close();
    }
}