def solution(board, skill):
    answer = 0
    skill.sort()

    for i in range(len(board)):
        for j in range(len(board[0])):
            for s in skill:
                print(i, j, ':', [s[1], s[2]], [s[3], s[4]], s)
                if s[0] == 1:
                    if s[1] <= i <= s[3] and s[2] <= j <= s[4]:
                        #print('#',i, j, ':', [s[1], s[2]], [s[3], s[4]], s)
                        board[i][j] -= s[-1]
                else:
                    if board[i][j] > 0: break
                    else:
                        if s[1] <= i <= s[3] and s[2] <= j <= s[4]:
                            #print('$', i, j, ':', [s[1], s[2]], [s[3], s[4]], s)
                            board[i][j] += s[-1]

            if board[i][j] > 0: answer+=1
    #print(answer)
    return answer

solution([[5,5,5,5,5],[5,5,5,5,5],[5,5,5,5,5],[5,5,5,5,5]], [[1,0,0,3,4,4],[1,2,0,2,3,2],[2,1,0,3,1,2],[1,0,1,3,3,1]])
#solution([[1,2,3],[4,5,6],[7,8,9]], [[1,1,1,2,2,4],[1,0,0,1,1,2],[2,2,0,2,0,100]])