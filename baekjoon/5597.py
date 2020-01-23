import sys
attendanceList = list(map(int, sys.stdin.readlines()))
for number in range(1, 31):
	if number not in attendanceList:
		print(number)