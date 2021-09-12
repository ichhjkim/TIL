import heapq

def solution(scoville, K):
    answer = 0
    heapq.heapify(scoville)
    mixed_count = 0
    while scoville:
        s1 = heapq.heappop(scoville)
        if s1 >= K: break
        if not scoville: return -1
        s2 = heapq.heappop(scoville)

        mixed = s1 + (s2*2)
        mixed_count += 1
        heapq.heappush(scoville, mixed)
    return mixed_count

print(solution([1, 2, 3, 9, 10, 12], 7))