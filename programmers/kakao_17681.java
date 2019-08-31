class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        StringBuilder builder;
        int result, compare;
        for(int i = 0; i < n; i++){
            result = arr1[i]|arr2[i];
            compare = 1<<(n-1);
            builder = new StringBuilder(n);
            while(compare > 0){
                if((result&compare) != 0){
                    builder.append('#');
                }else{
                    builder.append(' ');
                }
                compare >>=1;
            }
            answer[i] = builder.toString();
        }
        
        return answer;
    }
  }