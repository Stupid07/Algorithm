N = int(input())
result = 2
add = 2
for i in range(1,N):
	result += add
	if i&1 == 0:
		add+=1

print(result)