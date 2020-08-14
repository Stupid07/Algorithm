function solution(answers) {
    const answerPatterns = [[1, 2, 3, 4, 5], 
                            [2, 1, 2, 3, 2, 4, 2, 5], 
                            [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]];
    let scores = answers.reduce((scores, cur, idx)=>{
        answerPatterns.forEach((pattern, patternIdx)=>{
            if(cur == pattern[idx%pattern.length]){
                scores[patternIdx]++;
            }
        })
        return scores;
    },[0,0,0]);
    let maxScore = Math.max(...scores);
    let answer = scores.reduce((answer, cur, idx)=>{
        if(cur == maxScore){
            answer.push(idx+1);
        }
        return answer;
    },[]);
    return answer;
}