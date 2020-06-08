import sys
N = int(sys.stdin.readline())
result = []
for i in range(1, N+1):
    result.append(" " * (N-i)  + "*" * i)

result = result + result[-2::-1]
print('\n'.join(result).rstrip())