word = input()
words = [0 for i in range(26)]
bias = ord('a')
for key in word:
	words[ord(key)-bias]+=1

print(' '.join(map(str,words)))