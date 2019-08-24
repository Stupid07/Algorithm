import java.util.Arrays;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        int checkerSize = skill.length();
        boolean isRight;
        boolean[] skillChecker = new boolean[checkerSize];
        int index;
        for(String userSkill : skill_trees){
            isRight = true;
            for(int i = 0, end = userSkill.length(); i < end && isRight; i++){
                index = skill.indexOf(userSkill.charAt(i));
                if(index != -1){
                    for(int j = 0; j < index; j++ ){
                        if(!skillChecker[j]){
                            isRight = false;
                            break;
                        }
                    }
                    skillChecker[index] = true;
                }
            }
            if(isRight){
                answer++;
            }
            Arrays.fill(skillChecker, false);
        }
        return answer;
    }
}