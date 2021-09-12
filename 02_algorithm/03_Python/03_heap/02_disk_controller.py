import heapq as hp
def solution(jobs):
    jobs.sort()
    count, last = 0, -1
    wait = []
    hp.heapify(wait)
    time = jobs[0][0]
    length = len(jobs)
    answer = 0

    while count < length:
        for s, t in jobs:
            if last < s <= time:
                hp.heappush(wait, [t, s])
        if len(wait) > 0:
            last = time
            term , start = hp.heappop(wait)
            count += 1


print(solution([[0, 3], [1, 9], [2, 6]]))