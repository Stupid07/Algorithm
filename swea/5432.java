import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
 
public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(reader.readLine());
        int result,count;
        char data, preData;
        for(int test_case = 1; test_case <= T; test_case++) {
            result = 0;
            String line = reader.readLine();
            preData = line.charAt(0);
            count = 1;
            for(int i = 1, size = line.length(); i < size; i++) {
                data = line.charAt(i);
                if(data == '(') {
                    count++;
                }else {
                    count--;
                    if(preData == '(') {
                        result += count;
                    }else {
                        result++;
                    }
                }
                preData = data;
            }
            writer.write("#"+test_case+" "+result + "\n");
        }
        writer.flush();
        writer.close();
    }
}