from itertools import combinations


def solution(student, k):
    answer = 0
    ing_st = student.count(1)

    if ing_st < k: return answer

    for x in range(1, len(student)+1):
        for y in range(len(student)-x+1):
            temp = sum(student[y:y+x])
            if temp == k:
                answer += 1

    return answer


solution([0,1,0,0], 1)