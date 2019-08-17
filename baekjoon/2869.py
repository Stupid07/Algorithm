import sys, math
A, B, V = map(int, sys.stdin.readline().split(' '))
speed = A-B
result = math.ceil((V-A)/speed) +1
print(result)