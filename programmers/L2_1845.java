class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        boolean[] numbers = new boolean[200001];
        int max = nums.length >>1;
        int count = 0;
        for(int i = 0, size = nums.length; i < size; i++){
            if(!numbers[nums[i]]){
                numbers[nums[i]] = true;
                count++;
                if(count == max){
                    break;
                }
                
            }
        }
        answer = count;
        return answer;
    }
}