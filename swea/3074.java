import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
 
public class Solution{
     
    static long[] time = new long[100000];
    static long minTime, maxTime, midTime;
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(reader.readLine());
        String[] words;
        for(int test_case = 1; test_case <= T; test_case++) {
            words = reader.readLine().split(" ");
            int N = Integer.parseInt(words[0]);
            int M = Integer.parseInt(words[1]);
            minTime = Long.MAX_VALUE;
            maxTime = Long.MIN_VALUE;
            for(int i = 0; i < N; i++) {
                long preTime = Long.parseLong(reader.readLine());
                time[i] = preTime;
                minTime = Math.min(minTime, preTime);
                maxTime = Math.max(maxTime, preTime);
            }
             
            maxTime *= M;
            long count;
            while(minTime <= maxTime) {
                midTime = (maxTime + minTime)>>1;
                count =0;
                for(int i = 0; i < N; i++) {
                    count += midTime/time[i];
                }
                 
                if(count < M) {
                    minTime = midTime +1;
                }else {
                    maxTime = midTime -1;
                }
                 
            }
             
            if(maxTime == midTime) midTime++;
             
            writer.write(new StringBuilder(16).append("#").append(test_case).append(" ").append(midTime).append("\n").toString());
        }
        writer.flush();
        writer.close();
    }
}