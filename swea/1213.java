import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
 
public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int test_case = 1; test_case <= 10; test_case++) {
            int T = Integer.parseInt(reader.readLine());
            int result = 0;
            String pattern = reader.readLine();
            String line = reader.readLine();
            String[] match = line.split(pattern);
            result = match.length -1;
            if(line.endsWith(pattern)) result++;
            writer.write("#"+T+" "+result + "\n");
        }
        writer.flush();
        writer.close();
    }
}