import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
 
public class Solution {
    static int MAX;
    static String N;
    static int[] maxHate = new int[100000];
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(reader.readLine());
        for(int test_case = 1; test_case <= T; test_case++) {
            N = reader.readLine();
            MAX = hate(N) -1;
            writer.write(new StringBuilder(16).append("#").append(test_case).append(" ").append(MAX).append("\n").toString());
        }
        writer.flush();
        writer.close();
    }
     
    private static int hate(String preStr) {
        int subSize = preStr.length();
        if(subSize == 1) {
            return 1;
        }
         
        int preNum = Integer.parseInt(preStr);
         
        if (maxHate[preNum] == 0) {
            int maxFlag = (1 << subSize - 1) - 1;
            int temp, subResult, startIndex, endIndex, tempResult;
            int subMax = 0;
            for (int flag = 1; flag <= maxFlag; flag++) {
                subResult = 1;
                startIndex = 0;
                endIndex = 1;
                temp = flag;
                while (temp != 0) {
                    if ((temp & 1) != 0) {
                        subResult *= Integer.parseInt(preStr.substring(startIndex, endIndex));
                        startIndex = endIndex;
                    }
                    endIndex++;
                    temp >>= 1;
                }
                 
                subResult *= Integer.parseInt(preStr.substring(startIndex, subSize));
                 
                tempResult = hate(String.valueOf(subResult));
                subMax = Math.max(subMax, tempResult);
            }
            return (maxHate[preNum] = subMax)+1;
 
        } else {
            return maxHate[preNum] +1;
        }
         
    }
}