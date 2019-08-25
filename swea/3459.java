import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
 
public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(reader.readLine());
        long N, compareValue;
        int count;
        StringBuilder result;
        for(int test_case = 1; test_case <= T; test_case++) {
            N = Long.parseLong(reader.readLine());
            count = 0;
            compareValue = N;
            result = new StringBuilder(16).append("#").append(test_case).append(" ");
            while(compareValue != 0) {
                compareValue>>=1;
                count++;
            }
             
            compareValue = 1;
            boolean attack = (count & 1) == 0 ? true : false; // 짝수면 엘리스답변(true) 홀수면 밥답변(false)
             
            for(int i=1; i < count; i++) {
                if(attack) {//  엘리스 답변차례 라서 엘리스 수비
                    if((i & 1) != 0) {
                        compareValue<<=1;
                    }else {
                        compareValue = (compareValue<<1) + 1;
                    }
                }else {// 밥 답변 차례라서 밥 수비
                    if((i & 1) != 0) {
                        compareValue = (compareValue<<1) + 1;
                    }else {
                        compareValue<<=1;
                    }
                }
            }
             
            if(attack) {
                if(compareValue <= N) { // 엘리스 수비 성공
                    result.append("Alice");
                }else {
                    result.append("Bob");
                }
            }else {
                if(compareValue <= N) { // 밥 수비 성공
                    result.append("Bob");
                }else {
                    result.append("Alice");
                }
            }
             
             
            writer.write(result.append("\n").toString());
        }
        writer.flush();
        writer.close();
    }
}