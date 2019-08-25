import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
 
public class Solution {
    static char[] tree = new char[201];
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result;
        for(int test_case = 1; test_case <= 10; test_case++) {
            N = Integer.parseInt(reader.readLine());
            result = new StringBuilder(8).append("#").append(test_case).append(" ");
            for(int i=1; i <= N; i++) {
                tree[i] = reader.readLine().split(" ")[1].charAt(0);
            }
            if(isCal(1)) {
                result.append("1");
            }else {
                result.append("0");
            }
            result.append("\n");
            writer.write(result.toString());
        }
        writer.flush();
        writer.close();
         
    }
     
    public static boolean isCal( int index) {
        int nextIndex = index<<1;
        if(nextIndex > N) {//숫자면 true 연산자면  false - 단말
            return Character.isDigit(tree[index]);
        }else if(nextIndex+1 > N) { //한쪽만 붙어있는경우 - 왼쪽은 더있으나 오른쪽은 단말
            return false;
        }else {
            return isCal(nextIndex) && isCal(nextIndex + 1) && !Character.isDigit(tree[index]);
        }
    }
}