import sys
numberList = list(map(int, sys.stdin.readlines()[1].split(' ')))
print(sorted(numberList)[(len(numberList)-1)>>1])