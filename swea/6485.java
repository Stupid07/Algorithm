import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
 
public class Solution{
    static int[] stations = new int[5001];
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(reader.readLine());
        String[] line;
        int N, P, start, end;
        StringBuilder result;
        for(int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(reader.readLine());
            for(int i=0; i < N; i++) {
                line = reader.readLine().trim().split(" ");
                start = Integer.parseInt(line[0]);
                end = Integer.parseInt(line[1]);
                for(int  j =start;j <= end; j++)  {
                    stations[j]++;
                }
            }
            P = Integer.parseInt(reader.readLine());
            result = new StringBuilder(P*2 + 4).append("#").append(test_case).append(" ");
            for(int i=0; i < P; i++) {
                result.append(stations[Integer.parseInt(reader.readLine())]).append(" ");
            }
            writer.write(result.append("\n").toString());
            Arrays.fill(stations, 0);
             
        }
        writer.flush();
        writer.close();
    }
     
}