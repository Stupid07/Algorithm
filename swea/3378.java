import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;
 
public class Solution {
    static int p, q, resultR, resultC, resultS;
    static HashMap<Integer, Integer> map;
    static StringBuilder result;
    static boolean ihate;
    static boolean bR,bC,bS;
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(reader.readLine());
        StringTokenizer tokens;
        map = new HashMap<>();
        for(int testCase = 1; testCase <= T; testCase++) {
            resultR = resultC = resultS = 0;
            bR = bC = bS = true;
            map.put(0, 0);
            tokens = new StringTokenizer(reader.readLine());
            p = Integer.parseInt(tokens.nextToken());
            q = Integer.parseInt(tokens.nextToken());
             
            int preR = 0, preC = 0, preS = 0, len, count, key;
             
            for(int i = 0; i < p; i++) {
                count = 0;
                String line = reader.readLine();
                len = line.length();
                 
                for(int j = 0; j < len; j++) {
                    if(line.charAt(j) != '.') {
                        break;
                    }
                    count++;
                }
                key = preR * 10000 + preC * 100 + preS;
                if(!map.containsKey(key)) {
                    map.put(key, count);
                }
                 
                 
                preR += len - line.replaceAll("[(]", "").length();
                preR -= len - line.replaceAll("[)]", "").length();
                preC += len - line.replaceAll("[{]", "").length();
                preC -= len - line.replaceAll("[}]", "").length();
                preS += len - line.replaceAll("[\\[]", "").length();
                preS -= len - line.replaceAll("[\\]]", "").length();
            }
             
             
            check(0, new int[] {0, 0, 0});
             
            result = new StringBuilder(32).append('#').append(testCase).append(' ');
             
            preR = preC = preS = 0;
            for(int i = 0 ; i < q; i++) {
                String line = reader.readLine();
                len = line.length();
                 
                key = preR * 10000 + preC * 100 + preS;
                if(map.containsKey(key)) {
                    result.append(map.get(key)).append(' ');
                }else {
                    int val = 0;
                    if((preR == 0 || (preR != 0 && resultR != 0)) &&
                            (preC == 0 || (preC != 0 && resultC != 0)) &&
                            (preS == 0 || (preS != 0 && resultS != 0))) {
                        val += preR * resultR;
                        val += preC * resultC;
                        val += preS * resultS;
                        result.append(val).append(' ');
                    }else {
                        result.append("-1 ");
                    }
                     
                }
                 
                preR += len - line.replaceAll("[(]", "").length();
                preR -= len - line.replaceAll("[)]", "").length();
                preC += len - line.replaceAll("[{]", "").length();
                preC -= len - line.replaceAll("[}]", "").length();
                preS += len - line.replaceAll("[\\[]", "").length();
                preS -= len - line.replaceAll("[\\]]", "").length();
            }
             
            writer.write(result.append('\n').toString());
            map.clear();
        }
        writer.flush();
        writer.close();
    }
     
    static void check(int idx, int[] rcs) {
        if(idx == 3) {
            boolean isTrue = true;
            for(int key : map.keySet()) {
                int val = ((key /10000) * rcs[0]) + (((key %10000) /100) * rcs[1]) + (key%100 * rcs[2]);
                if(map.get(key) != val) {
                    isTrue = false;
                    break;
                }
            }
             
            if(isTrue) {
                 
                if((resultR == 0 || resultR == rcs[0]) && bR) {
                    resultR = rcs[0];
                }else {
                    resultR = 0;
                    bR = false;
                }
                 
                if((resultC == 0 || resultC == rcs[1]) && bC) {
                    resultC = rcs[1];
                }else {
                    resultC = 0;
                    bC = false;
                }
                 
                if((resultS == 0 || resultS == rcs[2])&& bS) {
                    resultS = rcs[2];
                }else {
                    resultS = 0;
                    bS = false;
                }
            }
             
             
            return;
        }
         
         
        for(int i = 1; i <= 20; i++) {
            rcs[idx] = i;
            check(idx+1,rcs);
        }
    }
}