import sys
readInput = sys.stdin.readline
parser = lambda x : list(map(int, x.split()))
N, M = parser(readInput())
myArray = list()
myArray.append([0 for i in range(N+1)])

for i in range(N):
    myArray.append(parser(readInput()))
    myArray[-1][0:0] = [0]
    for idx in range(1, N+1):
        myArray[-1][idx] += myArray[-1][idx-1] + myArray[-2][idx] - myArray[-2][idx-1]

result = list()
for i in range(M):
    x1, y1, x2, y2 = parser(readInput())
    result.append(str(myArray[x2][y2]-myArray[x1-1][y2]-myArray[x2][y1-1]+myArray[x1-1][y1-1]))

print('\n'.join(result))