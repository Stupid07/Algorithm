import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.SortedMap;
import java.util.TreeMap;
 
public class Solution{
    static HashSet<Integer> combi;
    static TreeMap<Integer, Integer> primeNumbers;
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(reader.readLine().trim());
        int N;
        primeNumbers = new TreeMap<>();
         
        boolean[] habSungSu = new boolean[1000];
        for(int i=2, size = habSungSu.length; i < size; i++) {
            if(habSungSu[i])
                continue;
            primeNumbers.put(i,i);
            for(int j = i * i; j < 1000; j +=i)
                habSungSu[j] =true;
        }
        /*
        primeNumbers.put(2, 2);
        boolean isPrime;
        for(int i =3; i < 1000; i++) {
            isPrime = true;
            for(Integer primeNum : primeNumbers.values()) {
                if(i % primeNum == 0) {
                    isPrime=false;
                    break;
                }
            }
            if(isPrime) {
                primeNumbers.put(i,i);
            }
        }
        */
         
        combi = new HashSet<>();
        SortedMap<Integer, Integer> sub;
        for(int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(reader.readLine().trim());
            Integer lastKey = primeNumbers.ceilingKey(N);
            if(lastKey == null)
                lastKey = primeNumbers.lastKey();
            sub = primeNumbers.subMap(primeNumbers.firstKey(), lastKey);
            for(int firstPrime : sub.values()) {
                for(int secendPrime : sub.values()) {
                    int lastPrime = N - firstPrime - secendPrime;
                    if(sub.containsKey(lastPrime)) {
                        int[] temp = new int[] {firstPrime, secendPrime, lastPrime};
                        Arrays.sort(temp);
                        combi.add(((temp[0] * 1000 * 1000) + (temp[1] *1000) + temp[2]));
                    }
                }
            }
             
            writer.write("#"+test_case+" " +combi.size() + "\n");
            combi.clear();
             
        }
        writer.flush();
        writer.close();
    }
     
}