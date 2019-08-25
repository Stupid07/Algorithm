import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
 
public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(reader.readLine());
        for(int test_case = 1; test_case <= T; test_case++) {
            int result = 0;
            String line = reader.readLine();
            int size = line.length();
            for(int i=1; i <=10; i++) {
                if(line.substring(0, i).equalsIgnoreCase(line.substring(i, i*2))) {
                    result = i;
                    break;
                }
            }
            writer.write("#"+test_case+" "+result + "\n");
        }
        writer.flush();
        writer.close();
    }
}