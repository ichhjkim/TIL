def solution(board, skill):
    answer = 0
    skill.sort()
    for s in skill:
        if s[0] == 1:
            for x in range(s[1], s[3]+1):
                for y in range(s[2], s[4]+1):
                    board[x][y] -= s[-1]
        else:
            for x in range(s[1], s[3]+1):
                for y in range(s[2], s[4]+1):
                    if board[x][y] > 0: continue
                    board[x][y] += s[-1]

    for i in range(len(board)):
        for j in range(len(board[0])):
            if board[i][j] > 0 : answer += 1

    return answer

solution([[1,2,3],[4,5,6],[7,8,9]], [[1,1,1,2,2,4],[1,0,0,1,1,2],[2,2,0,2,0,100]])