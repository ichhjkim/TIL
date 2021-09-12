nodes = []
max_sheep = 0

def dfs(node, info, sheep, wolve):
    global nodes, max_sheep

    max_sheep = max(max_sheep, sheep)
    if not nodes[node]:

        for n in range(len(info)):
            if info[n] == 0:
                dfs(n, info, sheep + 1, wolve)
            print(node, sheep, wolve)
            if info[n] == 1:
                dfs(n, info, sheep, wolve + 1)
        print(sheep)

        return [sheep, wolve]
    if sheep<=wolve: return
    info[node] = -1
    for n in nodes[node]:
        if info[n] == 0:
            dfs(n, info, sheep+1, wolve)
        print(node, sheep, wolve)
        if info[n] == 1:
            dfs(n, info, sheep, wolve+1)

def solution(info, edges):
    global nodes, max_sheep
    answer = 0
    nodes = [[] for _ in range(len(info))]

    for e in edges:
        nodes[e[0]].append(e[1])
        nodes[e[1]].append(e[0])
    #print(nodes)
    stack = [[0, 1, 0]]
    max_sheep = 1
    while stack:
        t = stack.pop()

        print(t, info)
        max_sheep = max(max_sheep, t[1])
        for n in nodes[t[0]]:
            if info[n] == 0:
                info[t[0]] = -1
                stack.append([n, t[1] + 1, t[2]])
            if info[n] == 1:
                if t[1] > t[2]:
                    info[t[0]] = -1
                    stack.append([n, t[1], t[2] + 1])

        if stack: continue

        for i in range(len(info)):
            if info[n] == 0:
                info[t[0]] = -1
                stack.append([n, t[1] + 1, t[2]])
            if info[n] == 1:
                if t[1] > t[2]:
                    info[t[0]] = -1
                    stack.append([n, t[1], t[2] + 1])
            break
    print(max_sheep)
    print(info)
    return max_sheep+2



solution([0,0,1,1,1,0,1,0,1,0,1,1], [[0,1],[1,2],[1,4],[0,8],[8,7],[9,10],[9,11],[4,3],[6,5],[4,6],[8,9]])