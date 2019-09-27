import sys

scoreList = list(map(int, sys.stdin.readlines()))
sortedScoreList = sorted(scoreList)[3:]
indexList = sorted([ str(scoreList.index(score)+1) for score in sortedScoreList ])
scoreSum = sum(sortedScoreList)

print(scoreSum)
print(' '.join(indexList))