import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
 
public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(reader.readLine());
        String line;
        for(int testCase = 1; testCase <= T; testCase++) {
            line = reader.readLine();
            if(line.matches("((F+F+M+C+M+)+|(F+C+MF)+)+")) {
                writer.write(String.format("#%d DETECTED!\n", testCase));
            }else {
                writer.write(String.format("#%d NOTHING!\n", testCase));
            }
        }
        writer.close();
    }
}