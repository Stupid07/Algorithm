S = {"CIRCLE" : -1, "TRIANGLE" : 0, "SQUARE" : 1}
C = {"YELLOW" : -1, "RED" : 0, "BLUE" : 1}
B = {"GRAY" : -1, "WHITE" : 0, "BLACK" : 1}

cards = list()
combi = dict()
for i in range(9):
    line = input().split()
    cards.append([S[line[0]], C[line[1]], B[line[2]]])

for i in range(9):
    for j in range(i+1,9):
        for k in range(j+1, 9):
            isHap = True
            for index in range(3):
                comp = cards[i][index] + cards[j][index] + cards[k][index]
                if comp != 0 and comp != -3 and comp != 3:
                    isHap = False
                    break
            if isHap :
                combi[str(i+1) +str(j+1) +str(k+1)] = True

N = int(input())
result = 0
isGhul = True
for i in range(N):
    line = input().split()
    command = line[0]
    if command == "H":
        compare = "".join(sorted(line[1:]))
        if compare in combi:
            combi.pop(compare)
            result+=1
        else:
            result-=1
    else :
        if len(combi) == 0 and isGhul:
            isGhul = False
            result +=3
        else:
            result-=1

print(result)