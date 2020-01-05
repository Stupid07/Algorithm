N = int(input())
words =list()
for i in range(N):
    words.append(input())
for word in words:
    if word[::-1] in words:
        print(len(word), word[int(len(word)/2)])
        break
