import java.util.*;

class Solution {
    int count = 0;
    int[] numberArray;
    boolean[] checkArray;
    boolean[] primeNumbers;
    
    public int solution(String numbers) {
        int answer =0;
        int numberSize = numbers.length();
        int primeNumbersSize = pow(10, numberSize);
        primeNumbers = new boolean[primeNumbersSize];
        
        Arrays.fill(primeNumbers, true);
        primeNumbers[0] = primeNumbers[1] = false;
        for(int i = 2, size = primeNumbersSize >> 1; i < size; i++){
            if(!primeNumbers[i]) continue;
            for(int j = i+i ; j < primeNumbersSize; j+=i){
                primeNumbers[j] = false;
            }
        }
        
        numberArray = new int[numberSize];
        checkArray = new boolean[numberSize];
        for(int i = 0; i < numberSize; i++){
            numberArray[i] = numbers.charAt(i)-'0';
        }
        
        solve(0);
        answer = count;
        return answer;
    }
    
    public void solve(int number){
        if(primeNumbers[number]){
            count++;
            primeNumbers[number] = false;
        }
        
        for(int i = 0; i < numberArray.length; i++){
            if(!checkArray[i]){
                checkArray[i] = true;
                solve((number * 10) + numberArray[i]);
                checkArray[i] = false;
            }
        }
    }
    
    public int pow(int base, int count){
        int result = base;
        for(int i = 1; i < count; i++){
            result *= base;
        }
        return result;
    }
}