import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
 
public class Solution {
    static int[] arr = new int[26];
    static int result;
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(reader.readLine());
        String word, line, subString;
        StringBuilder newWord;
        int lineLen;
        for(int testCase = 1; testCase <= T; testCase++) {
            result = 0;
            line = reader.readLine();
            lineLen = line.length();
            for(int i = 0; i < lineLen; i++) {
                arr[line.charAt(i)-'a']++;
            }
             
            newWord = new StringBuilder(lineLen);
            int count = 0;
            while(count < lineLen) {
                int subMax = 0, index = 0;
                for(int i = 0 ; i < 26; i++) {
                    if(subMax < arr[i]) {
                        subMax = arr[i];
                        index = i;
                    }
                }
                 
                boolean bFirst = true;
                for(int i =0; i < subMax; i++) {
                    if(bFirst) {
                        newWord.insert(0, (char)('a'+index));
                    }else {
                        newWord.append((char)('a'+index));
                    }
                    bFirst = !bFirst;
                    arr[index]--;
                    count++;
                }
            }
             
            word = newWord.toString();
            for(int i = 1, max = word.length(); i <= max; i++) {
                 
                for(int j = 0; j+i <= max; j++) {
                    subString = word.substring(j, j+i);
                    if(isPalindrome(subString)) {
                        result++;
                    }
                     
                }
                 
            }
             
             
            writer.write(new StringBuilder(16).append('#').append(testCase).append(' ').append(result).append('\n').toString());
        }
        writer.flush();
        writer.close();
    }
     
    public static boolean isPalindrome(String word) {
        StringBuilder reverseStr = new StringBuilder(word);
        reverseStr.reverse();
        return reverseStr.toString().equals(word);
    }
}