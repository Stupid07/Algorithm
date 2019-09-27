import sys, math
inputs = list(map(int, sys.stdin.readlines()))
result = int(inputs[0])-math.ceil(max(inputs[1]/inputs[3], inputs[2]/inputs[4]))
print(str(result))