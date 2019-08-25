import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
 
public class Solution {
    static Long result;
    static HashSet<Long> set = new HashSet<>();
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(reader.readLine());
        StringBuilder radix2, radix2BackUp, radix3, radix3BackUp;
        for(int testCase = 1; testCase <= T; testCase++) {
            result = 0L;
            radix2 = new StringBuilder(reader.readLine());
            radix2BackUp = new StringBuilder(radix2.toString());
            radix3 = new StringBuilder(reader.readLine());
            radix3BackUp = new StringBuilder(radix3.toString());
            for(int i = 0, size = radix2.length(); i < size; i++) {
                if(radix2.charAt(i) == '1') {
                    radix2.setCharAt(i, '0');
                }else {
                    radix2.setCharAt(i, '1');
                }
                set.add(Long.parseLong(radix2.toString(),2));
                 
                radix2.setCharAt(i, radix2BackUp.charAt(i));
            }
 
            char data, first ='1', second ='2';
            for(int i = radix3.length()-1 ; i >= 0; i--) {
                data = radix3.charAt(i);
                 
                switch (data) {
                case '0':
                    first = '1';
                    second = '2';
                    break;
                case '1':
                    first = '0';
                    second = '2';
                    break;
                case '2':
                    first = '0';
                    second = '1';
                    break;
 
                }
                radix3.setCharAt(i, first);
                if(set.contains(Long.parseLong(radix3.toString(),3))) {
                    result = Long.parseLong(radix3.toString(),3);
                    break;
                }
                 
                radix3.setCharAt(i, second);
                if(set.contains(Long.parseLong(radix3.toString(),3))) {
                    result = Long.parseLong(radix3.toString(),3);
                    break;
                }
                 
                radix3.setCharAt(i, radix3BackUp.charAt(i));
            }
             
            writer.write(new StringBuilder(16).append('#').append(testCase).append(' ').append(result).append('\n').toString());
            set.clear();
        }
        writer.flush();
        writer.close();
    }
}