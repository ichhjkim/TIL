import itertools

def solution(numbers):
    answer = 0
    nums = list(numbers)
    result = set()
    for i in range(len(numbers)):

        nums_result = itertools.permutations(nums, i+1)
        for n in nums_result:
            result.add(int(''.join(n)))

    for num in result:
        if num < 2: continue
        num = int(num)
        flag = False

        for x in range(2, num):
            if not num % x:
                flag = True
                break

        else:
            if not flag: answer += 1

    return answer


print(solution('17'))
print(solution('011'))