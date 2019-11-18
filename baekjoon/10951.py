import sys

for line in sys.stdin:
	sum = 0
	for num in line.split():
		sum += int(num)
	print(sum)