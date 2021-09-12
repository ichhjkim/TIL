answer = []
def solution(n):
    nums = list(range(1, n+1))
    nums.sort()
    recur(nums)
    return answer

def recur(nums):
    global answer
    p = 1
    #print(nums)
    # if len(nums) == 1:
    #     answer += nums
    #     print('#########3', nums)
    #     return

    for x in range(2, len(nums)+1):
        if x == len(nums):
            p=x
            break
        if not len(nums) % x:
            flag = True
            for n in range(2, x**(1//2)):
                if not p % n:
                    flag = False
                    break
            if flag:
                p = x
                break


    if p == len(nums):

        answer += nums
        return

    for i in range(p):
        temp_nums = nums[i::p][:]

        recur(temp_nums)

print(solution(10000000000))


