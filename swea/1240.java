import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
 
public class Solution {
    static HashMap<String,Integer> code = new HashMap<>();
    static final String[] codeStr = {"0001101", "0011001", 
            "0010011", "0111101", "0100011", "0110001", 
            "0101111", "0111011", "0110111", "0001011"};
    public static void main(String[] args) throws Exception {
        for(int i=0;i<10; i++) {
            code.put(codeStr[i], i);
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(reader.readLine());
        int[] number = new int[8];
        for(int test_case = 1; test_case <= T; test_case++) {
            int result = 0;
            String[] nums = reader.readLine().split(" ");
             
            int N = Integer.parseInt(nums[0]);
            int M = Integer.parseInt(nums[1]);
            int idx = 7, i = 0;
            for(; i < N; i++) {
                String line = reader.readLine();
                int lastIdx = line.lastIndexOf("1");
                if(lastIdx != -1) {
                    for(int j = lastIdx; j >=0; j-=7) {
                            number[idx--] = code.getOrDefault(line.substring(j-6, j+1), -1);
                            if(idx <0) break;
                    }
                    i++;
                    break;
                }
            }
             
            while(i<N) {
                reader.readLine();
                i++;
            }
             
            result = ((number[0] + number[2] + number[4] + number[6])*3 +(number[1] + number[3] + number[5]+number[7]));
            if(result%10 != 0) {
                result = 0;
            }else {
                result = 0;
                for(int k=0; k < 8; k++)
                    result+=number[k];
            }
            writer.write("#"+test_case+" "+result + "\n");
        }
        writer.flush();
        writer.close();
    }
}