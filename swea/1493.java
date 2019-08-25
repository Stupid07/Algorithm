import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
 
public class Solution {
    static int[] startValue = new int[1000];
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(reader.readLine().trim());
        startValue[0] =1;
        for(int i = 1 ;startValue[i-1] <= 100000; i++) {
            startValue[i] = startValue[i-1] + i;
        }
         
         
        String[] words; 
        int A,B, Ax=0, Ay=0, Bx=0, By=0,Cx, Cy, C, count;
        boolean isAFind,isBFind;
        for(int test_case = 1; test_case <= T; test_case++) {
            words = reader.readLine().trim().split(" ");
            isAFind = true;
            isBFind = true;
            A = Integer.parseInt(words[0]);
            B = Integer.parseInt(words[1]);
            count = 0;
            while(isAFind || isBFind) {
                if(isAFind && A< startValue[count]) {
                    isAFind = false;
                    Ax= count;
                    Ay= A- startValue[count-1];
                }
                     
                if(isBFind && B < startValue[count]) {
                    isBFind = false;
                    Bx= count;
                    By= B- startValue[count-1];
                }
                count++;
            }
            Cx = Ax + Bx;
            Cy = Ay + By + 1;
            C = startValue[Cx] + Cy;
            writer.write(new StringBuilder(13).append("#").append(test_case).append(" ").append(C).append("\n").toString());
             
        }
        writer.flush();
        writer.close();
    }
}