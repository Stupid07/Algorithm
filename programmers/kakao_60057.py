def solution(s):
    answer = len(s)
    stringLen = len(s)
    for i in range(1,(stringLen>>1)+1):
        words = [""]
        counts = [0]
        result = 0
        if stringLen % i != 0:
            result += stringLen % i
                
        for j in range(i,stringLen+1,i):
            if words[-1] != s[j-i:j]:
                words.append(s[j-i:j])
                counts.append(1)
            else:
                counts[-1] += 1
            
        for count in counts[1:]:
            result += i
            if count != 1:
                result += len(str(count))
        
        if answer > result:
            answer = result
                    
    return answer