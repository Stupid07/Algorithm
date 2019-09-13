import sys

frm = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
to = "BCDEFGHIJKLMNOPQRSTUVWXYZA"
transTable = str.maketrans(frm,to)
readline = sys.stdin.readline
N = int(readline())
for i in range(1, N+1):
	print("String #{}\n{}".format(i, readline().translate(transTable)))