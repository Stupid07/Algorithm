import sys
a, b = map(int,sys.stdin.readline().split())
result = ''
if a > b:
	result = '>'
elif a < b:
	result = '<'
else:
	result = '=='
print(result)