import sys
T = int(sys.stdin.readline())
for id in range(T):
	count = 0
	PS = sys.stdin.readline().strip()
	for x in PS:
		if(x == '('):
			count+=1
		else:
			count-=1
			if(count<0):
				break
	if(count == 0):
		print("YES")
	else:
		print("NO")