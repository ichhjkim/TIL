def solution(research, n, k):
    answer = 'None'
    archive = [0]*len(research)
    all_words = set()
    candidates = []
    for x in range(len(research)):
        words = list(research[x])
        search_words = set(words)
        archive[x] = {}
        for w in search_words:
            archive[x][w] = research[x].count(w)
            all_words.add(w)

    for search in all_words:
        max_search = 0
        for i in range(len(research)):
            search_count = 0
            for j in range(n):
                if i+j > len(research)-1: break
                if archive[i+j].get(search):
                    if archive[i+j].get(search)>=k:
                        search_count += archive[i+j].get(search)
                    else: break
                else: break

            if search_count >= 2 * n * k:
                flag = False
                for c in range(len(candidates)):
                    if candidates[c][1] == search:
                        candidates[c][0] += 1
                        flag = True
                if not flag:candidates.append([0 , search, max_search])


    if candidates:
        candidates.sort(key=lambda x : (-x[0], x[1]))
        answer = candidates[0][1]
    return answer

print(solution(["abaaaa","aaa","abaaaaaa","fzfffffffa"]	, 2, 2))
print(solution(["yxxy","xxyyy"], 2, 1))
print(solution(["yxxy","xxyyy","yz"]	, 2, 1))