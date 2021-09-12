def solution(jobs):
    answer = []
    count = 0
    length = len(jobs)
    time = 0
    wait = []
    cate = 0
    for job in jobs:
        wait.append([job[0]-time, job[2]-cate, -job[3], job[2], job[0], job[1]])

    while count < length:
        print(wait)
        j = wait.pop(0)
        for x in range(len(jobs)):
            if x == jobs[x][-2]:
                jobs.pop(x)
                break

        if time < j[-2] : time = j[-2]
        time += j[-1]

        answer.append(j[-3])
        count += 1

        wait = []
        for job in jobs:
            wait.append([job[0]-time, job[2] - cate, -job[3], job[2], job[0], job[1]])
        wait.sort()

    print(answer)
    return answer

# 어떤 작업 시작 하면, 끝까지
# 처리 도중, 끝남과 동시에 작업이 새로 요청되면 새로운 작업
# 한 분류 작업 다 하면 -> 새로운 분류의 작업(죽요도 합이 가낭 높은 분류)
# 중요도 합이 여러개면, 분류번호가 가장 낮은 분류

solution([[1, 5, 2, 3], [2, 2, 3, 2], [3, 1, 3, 3], [5, 2, 1, 5], [7, 1, 1, 1], [9, 1, 1, 1], [10, 2, 2, 9]])