import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
 
public class Solution {
 
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] boxCounts = new int[101];
        for(int test_case = 1; test_case <= 10; test_case++) {
            int dumpCount = Integer.parseInt(reader.readLine());
            Arrays.fill(boxCounts, 0);
            String[] numbers = reader.readLine().split(" ");
            for(int i = 0; i < 100; i++) {
                boxCounts[Integer.parseInt(numbers[i])]++;
            }
             
            int dump=0,minidx =1, maxidx =100;
            int maxBoxs,minBoxs;
            while(dump <=dumpCount && minidx < maxidx) {
                while(boxCounts[minidx]== 0) minidx++;
                while(boxCounts[maxidx]== 0) maxidx--;
                 
                if(minidx < maxidx) {
                    if(maxidx - minidx <= 1) // 발표때 배움 0일때와 1일때는 더 돌려도 의미가 없다
                        break;
                    maxBoxs = boxCounts[maxidx];
                    minBoxs = boxCounts[minidx];
                    int m = Math.min(maxBoxs, minBoxs);
                    dump+= m;
                    boxCounts[minidx] -= m;
                    boxCounts[minidx+1] += m;
                    boxCounts[maxidx] -= m;
                    boxCounts[maxidx-1] += m;
                }
                 
            }
            int result = maxidx-minidx;
             
            writer.write("#"+test_case+" "+result + "\n");
        }
        writer.flush();
        writer.close();
    }
 
}