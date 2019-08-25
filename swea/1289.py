t = int(input())
 
for testCase in range(t):
    line = input()
    result = 0
    bBin = False
    for word in line:
        if word == '0':
            if bBin :
                result +=1
                bBin = False
        else:
            if not bBin :
                result += 1
                bBin = True
     
    print("#"+str(testCase+1),result)