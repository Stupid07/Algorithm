N, K = map(int, input().split())
winMap = list()
notSelected = list()
for i in range(N):
    winMap.append(list(map(int, input().split())))
    notSelected.append(True)

kList = [int(x) -1 for x in input().split()]
mList = [int(x) -1 for x in input().split()]

isPossible = 0

# 0 : me 1 : k 2 : m
def find(kIdx,mIdx, pre, next, wins):
    if wins[0] == K:
        global isPossible
        isPossible = 1
        return
    if wins[1] == K or wins[2] == K:
        return

    if(pre == 0):
        if(next == 1): # 0 vs 1
            nextPic = kList[kIdx]
            for i in range(N):
                if notSelected[i]:
                    notSelected[i] = False
                    if winMap[i][nextPic] == 2:
                        wins[0] += 1
                        find(kIdx+1, mIdx, 0, 2, wins)
                        wins[0] -= 1
                    else:
                        wins[1] += 1
                        find(kIdx + 1, mIdx, 1, 2, wins)
                        wins[1] -= 1
                    notSelected[i] = True
        else: # 0 vs 2
            nextPic = mList[mIdx]
            for i in range(N):
                if notSelected[i]:
                    notSelected[i] = False
                    if winMap[i][nextPic] == 2:
                        wins[0] += 1
                        find(kIdx, mIdx+1, 0, 1, wins)
                        wins[0] -= 1
                    else:
                        wins[2] += 1
                        find(kIdx, mIdx+1, 2, 1, wins)
                        wins[2] -= 1
                    notSelected[i] = True
    elif(pre == 1):
        if(next == 0): # 1 vs 0
            nextPic = kList[kIdx]
            for i in range(N):
                if notSelected[i]:
                    notSelected[i] = False
                    if winMap[i][nextPic] == 2:
                        wins[0] += 1
                        find(kIdx + 1, mIdx, 0, 2, wins)
                        wins[0] -= 1
                    else:
                        wins[1] += 1
                        find(kIdx + 1, mIdx, 1, 2, wins)
                        wins[1] -= 1
                    notSelected[i] = True
        else: # 1 vs 2
            if winMap[kList[kIdx]][mList[mIdx]] == 2:
                wins[1] +=1
                find(kIdx+1, mIdx +1, 1, 0, wins)
                wins[1] -=1
            else:
                wins[2] += 1
                find(kIdx + 1, mIdx + 1, 2, 0, wins)
                wins[2] -= 1
    else:
        if(next == 0): # 2 vs 0
            nextPic = mList[mIdx]
            for i in range(N):
                if notSelected[i]:
                    notSelected[i] = False
                    if winMap[i][nextPic] == 2:
                        wins[0] += 1
                        find(kIdx, mIdx + 1, 0, 1, wins)
                        wins[0] -= 1
                    else:
                        wins[2] += 1
                        find(kIdx, mIdx + 1, 2, 1, wins)
                        wins[2] -= 1
                    notSelected[i] = True
        else: # 2 vs 1
            if winMap[kList[kIdx]][mList[mIdx]] == 2:
                wins[1] +=1
                find(kIdx+1, mIdx +1, 1, 0, wins)
                wins[1] -=1
            else:
                wins[2] += 1
                find(kIdx + 1, mIdx + 1, 2, 0, wins)
                wins[2] -= 1


find(0,0,0,1,[0,0,0])
print(isPossible)
