import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
 
public class Solution {
     
    static int N, frontIdx, backIdx;
    static char[] arr = new char[2000];
    static char maxChar;
     
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(reader.readLine().trim());
        StringBuilder result;
        for(int testCase = 1; testCase <= T; testCase++) {
            N = Integer.parseInt(reader.readLine().trim());
            result = new StringBuilder(N+8).append('#').append(testCase).append(' ');
             
            for(int i = 0 ; i < N; i++) {
                arr[i] = reader.readLine().charAt(0);
            }
             
            frontIdx = 0;
            backIdx = N-1;
            while(frontIdx < backIdx) {
                if(arr[frontIdx] < arr[backIdx]) {
                    result.append(arr[frontIdx++]);
                }else if(arr[frontIdx] > arr[backIdx]){
                    result.append(arr[backIdx--]);
                }else {
                    int tempFront = frontIdx+1;
                    int tempBack = backIdx-1;
                    while(tempFront < tempBack) {
                        if(arr[tempFront] == arr[tempBack]) {
                            tempFront++;
                            tempBack--;
                        }else if(arr[tempFront] < arr[tempBack]) {
                            result.append(arr[frontIdx++]);
                            break;
                        }else {
                            result.append(arr[backIdx--]);
                            break;
                        }
                    }
                     
                    if(tempFront >= tempBack) {
                        if(arr[frontIdx] <= arr[frontIdx + 1] ) {
                            while(frontIdx < backIdx) {
                                result.append(arr[frontIdx++]);
                                result.append(arr[backIdx--]);
                            }
                            break;
                        }else {
                            result.append(arr[frontIdx++]);
                        }                       
                    }
                }
            }
            if(frontIdx == backIdx)
                result.append(arr[frontIdx]);
 
            writer.write(result.append('\n').toString());
             
        }
        writer.flush();
        writer.close();
    }
}