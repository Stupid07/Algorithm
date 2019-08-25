import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
 
public class Solution{
    static int[] rooms = new int[200];
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(reader.readLine().trim());
        String[] line;
        int N, start, end;
        for(int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(reader.readLine().trim());
            for(int i=0; i < N; i++) {
                line = reader.readLine().trim().split(" ");
                start = Integer.parseInt(line[0]);
                end = Integer.parseInt(line[1]);
                start= (start-1)>>1;
                end = (end-1)>>1;
                for(int  j =Math.min(start, end), size = Math.max(start, end); j <= size; j++)  {
                    rooms[j]++;
                }
            }
            Arrays.sort(rooms);
             
            writer.write("#"+test_case+" " + rooms[199] + "\n");
            Arrays.fill(rooms, 0);
             
        }
        writer.flush();
        writer.close();
    }
     
}