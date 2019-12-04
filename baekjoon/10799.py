line = input()
result = 0
count = 1
preWord = line[0]
for word in line[1:]:
    if word == '(':
        count += 1
    else:
        count -= 1
        if preWord == '(':
            result += count
        else:
            result += 1
    preWord = word

print(result)