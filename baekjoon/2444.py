N = input()

st = range(1,N+1);
st = st + range(N-1,0,-1);

for i in st:
	for j in range(N-i):
		print "",
	print "*" *(i *2-1)