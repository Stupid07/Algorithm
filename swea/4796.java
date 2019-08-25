import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;
 
public class Solution{
    static int N;
    static boolean isDown;
    public static void main(String[] args) throws Exception {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        StringTokenizer tokens;
        for(int testCase = 1; testCase <= T; testCase++) {
            int result = 0;
            N = sc.nextInt();
            isDown = true;
            int upCount = 0, downCount = 0;
            int preNum = sc.nextInt(), nextNum;
            for(int i = 1 ; i < N; i++) {
                nextNum = sc.nextInt();
                if(preNum < nextNum) {
                    if(isDown) {
                        isDown = false;
                        result += upCount * downCount;
                        upCount = 1;
                        downCount = 0;
                    }else {
                        upCount++;
                    }
                }else if(preNum > nextNum) {
                    if(isDown) {
                        downCount++;
                    }else {
                        isDown = true;
                        downCount = 1;
                    }
                }else {
                    isDown = true;
                    result += upCount * downCount;
                    upCount = downCount = 0;
                }
                 
                preNum = nextNum;
            }
             
            result += upCount * downCount;
             
            writer.write(new StringBuilder(16).append('#').append(testCase).append(' ').append(result).append('\n').toString());
        }
        writer.flush();
        writer.close();
    }
}