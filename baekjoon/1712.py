import sys, math
A, B, C = map(int, sys.stdin.readline().split(' '))
profit = C-B
if profit <= 0:
	print(-1)
else:
	result = math.ceil(A/profit)
	if result == (A//profit):
		result+=1
	print(result)