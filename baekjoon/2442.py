import sys
N = int(sys.stdin.readline())
result = []
for i in range(1, N+1):
    result.append(" " * (N-i)  + "*" * ((i<<1)-1))

print('\n'.join(result).rstrip())