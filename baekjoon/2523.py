import sys
N = int(sys.stdin.readline())

array = [ '*'*i for i in range(1, N+1)] + [ '*'*i for i in range(N-1,0,-1)]
print('\n'.join(array))