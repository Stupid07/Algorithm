import sys
N = int(sys.stdin.readline())
result = [['*'for j in range(N)]for i in range(N)]

def removeStar(result, x, y, size):
	if size == 3:
		result[x+1][y+1] = ' '
		return
	
	division = size//3
	for i in range(division):
		for j in range(division):
			result[x+division+i][y+division+j] =' '
	
	for i in range(3):
		for j in range(3):
			if i == 1 and j == 1:
				continue
			else:
				removeStar(result, x+(division*i), y + (division*j), division)

removeStar(result, 0, 0, N)
for list in result:
	print("".join(list))