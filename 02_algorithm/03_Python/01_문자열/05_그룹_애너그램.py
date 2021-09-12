# 문자열 배열을 받아 애너그램 단위로 그룹핑 하라 -> 애너그램을 판단하는 가장 간단한 방법은 정렬하여 비교하는 것

test = ['eat', 'tea', 'tan', 'ate', 'nat', 'bat']

def solution(tmp):
    anagrams = {}

    for word in tmp:
        w = ''.join(sorted(word))
        if anagrams.get(w): anagrams[w].append(word)
        else: anagrams[w] = [word]
    return anagrams.values()

print(solution(test))