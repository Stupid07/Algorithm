line = input()
result = list()
for i in range(len(line)):
    result.append(line[i:])
result = sorted(result)
for word in result:
    print(word)