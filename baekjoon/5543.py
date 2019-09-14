import sys
input = sys.stdin.readlines()
print(str(min(map(int,input[:3])) + min(map(int,input[3:])) -50))