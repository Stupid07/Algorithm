import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
 
public class Solution {
     
    static int maxNum;
    static int maxIdx;
    public static void findMax(char[] number, int change) {
        if(change <= 0) {
            int num = Integer.parseInt(Arrays.toString(number).replace(" ", "").replace(",", "").replace("[","").replace("]", ""));
             
            if(num > maxNum) maxNum = num;
             
            return;
        }
         
        for(int i = 0; i < maxIdx ;i++) {
            for(int j = i+1; j < maxIdx; j++) {
                char temp = number[i];
                number[i] = number[j];
                number[j] = temp;
                findMax(number, change-1);
                number[j] = number[i];
                number[i] = temp;
            }
        }
    }
     
     
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(reader.readLine());
        for(int test_case = 1; test_case <= T; test_case++) {
            int result = 0;
            String[] words = reader.readLine().split(" ");
            int changeCount = Integer.parseInt(words[1]);
            StringBuilder number = new StringBuilder(words[0]);
             
            /*
            char[] keys = words[0].toCharArray();
            Arrays.sort(keys);
            int keyIndex = keys.length-1;
            int numIndex = 0; 
            int change;
            boolean isSame = false;
            char preKey = keys[0];
            for(int i = 1 ; i <= keyIndex; i++) {
                if(preKey == keys[i]) {
                    isSame = true;
                }else {
                    preKey = keys[i];
                }
            }
             
            for(change = 0 ; change < changeCount;) {
                if(number.charAt(numIndex) != keys[keyIndex]) {
                    number.replace(number.lastIndexOf(String.valueOf(keys[keyIndex])), number.lastIndexOf(String.valueOf(keys[keyIndex])) +1, number.substring(numIndex, numIndex+1));
                    number.replace(numIndex, numIndex+1, String.valueOf(keys[keyIndex]));
                    change++;
                     
                }
                numIndex++; keyIndex--;
                if(numIndex >= number.length() || keyIndex < 0)
                    break;
            }
             
            int temp = changeCount-change;
            if(temp %2 != 0 && !isSame) {
                String changeStr = "" + number.charAt(number.length()-1) + number.charAt(number.length()-2);
                number.replace(number.length()-2, number.length(), changeStr);
            }
            result = Integer.parseInt(number.toString());
            */
             
             
             
            maxNum = Integer.parseInt(number.toString());
            maxIdx = number.length();
              
            findMax(number.toString().toCharArray(), changeCount >= maxIdx ? maxIdx-1 : changeCount);
            if(changeCount >= maxIdx && (changeCount-maxIdx-1) %2 != 0) {
                result = (maxNum%10) * 10 + maxNum/100 *100 + (maxNum%100)/10;
            }else {
                result = maxNum;
            }
             
            writer.write("#"+test_case+" "+result + "\n");
        }
        writer.flush();
        writer.close();
    }
}