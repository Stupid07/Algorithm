import sys

maxTime = [24, 60]
time = list(map(int,sys.stdin.readline().strip().split()))
add = int(sys.stdin.readline())

for i in range(-1, -3, -1):
	nextTime = time[i] + add
	time[i] = nextTime%maxTime[i]
	add = nextTime//maxTime[i]

print(" ".join(map(str,time)))