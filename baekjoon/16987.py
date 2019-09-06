N = int(input())
eggs = list()
life = [False for i in range(N)]
for i in range(N):
    eggs.append([int(x) for x in input().split()])

maxBroken = 0

def findMax(idx, count):
    global maxBroken, N
    if idx == N or maxBroken > ((N-idx)<<1 + count):
        maxBroken = max(maxBroken, count)
        return

    if eggs[idx][0] > 0:
        for i in range(N):
            if eggs[i][0] > 0 and i != idx:
                eggs[i][0] -= eggs[idx][1]
                eggs[idx][0] -= eggs[i][1]
                add = 0
                if eggs[i][0] <= 0:
                    add+=1
                if eggs[idx][0] <= 0:
                    add+=1
                findMax(idx+1, count + add)
                eggs[idx][0] += eggs[i][1]
                eggs[i][0] += eggs[idx][1]
    else:
        findMax(idx+1, count)
    if idx == N-1:
        maxBroken = max(maxBroken, count)


findMax(0, 0)
print(maxBroken)