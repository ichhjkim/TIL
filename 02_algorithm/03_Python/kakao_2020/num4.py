import math

def combinations_with_replacement(arr,r):

    for i in range(len(arr)):
        if r == 1:
            yield [arr[i]]
        else:
            for next in combinations_with_replacement(arr[i:],r-1):
                yield [arr[i]] + next

def solution(n, info):
    answer = [-1]
    max_score = -math.inf
    candis = {}
    flag = False
    for scs in combinations_with_replacement(list(range(11)), n):
        scores = [scs.count(i) for i in range(10, -1, -1)]
        lion = 0
        peach = 0
        for x in range(11):
            if scores[x] == info[x] == 0: continue
            if scores[x] > info[x]: lion += 10-x
            else: peach += 10-x
        if lion > peach:
            flag = True
            print(peach, lion)
            if max_score <= lion-peach:
                if candis.get(lion-peach):
                    candis[lion-peach].append(scores)
                else:
                    candis[lion-peach] = [scores]

    if not flag: return answer
    max_num = max(candis.keys())

    for c in candis[max_num]:
        c.reverse()
    candis[max_num].sort()

    candis[max_num][-1].reverse()
    return candis[max_num][-1]

print(solution(9, [0, 0, 1, 2, 0, 1, 1, 1, 1, 1, 1]))

