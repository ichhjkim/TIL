def solution(id_list, report, k):
    answer = {}
    response_dict = {}
    for id in id_list:
        response_dict[id] = set()
        answer[id] = 0

    for r in report:
        request, response = r.split()
        response_dict[response].add(request)
    for id,  v in response_dict.items():
        if len(response_dict[id]) >= k:
            for i in v:
                answer[i] += 1

    id_list = [ answer[key] for key in answer.keys()]
    return id_list

solution(["muzi", "frodo", "apeach", "neo"], ["muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"], 2)