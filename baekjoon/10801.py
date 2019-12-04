import sys

result = [0, 0, 0]
resultString = ['D','A','B']
compareFunc = lambda a,b : (1 if a > b else ( 2 if a < b else 0))
numberList = list(map(lambda x: list(map(int, x.split(" "))), sys.stdin.readlines()))
for i in range(10):
	result[compareFunc(numberList[0][i], numberList[1][i])] += 1

print(resultString[compareFunc(result[1], result[2])])