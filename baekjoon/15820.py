import sys
inputs = sys.stdin.readlines()
s1, s2 = map(int,inputs.pop(0).strip().split(' '))
isAccepted = True
isWrong = True
for i in range(len(inputs)):
	testCase = inputs.pop().strip().split(' ')
	if testCase[0] != testCase[1]:
		if i < s2:
			isWrong = False
		else:
			isAccepted = False
			break

if isAccepted and isWrong:
	print('Accepted')
elif isAccepted:
	print('Why Wrong!!!')
else:
	print('Wrong Answer')