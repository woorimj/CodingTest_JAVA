import sys
input = sys.stdin.readline
from collections import deque

dx = [0, 0, -1, 1] 
dy = [1, -1, 0, 0]

def check_visited():
    visited = [[False]*M for _ in range(N)]
    
    queue = deque()
    queue.append((0, 0))
    visited[0][0] = True
    while queue:
        x, y = queue.popleft()

        for d in range(4):
            nx, ny = x + dx[d], y + dy[d]
            if 0 <= nx < N and 0 <= ny < M and not visited[nx][ny]:
                if board[nx][ny] == 0:
                    visited[nx][ny] = True
                    queue.append((nx, ny))
    return visited

def melt_cheese(visited):
    cheese = []
    for i in range(N):
        for j in range(M):
            if board[i][j] == 1:
                count = 0 
                for d in range(4):
                    ni, nj = i + dx[d], j + dy[d]
                    if 0 <= ni < N and 0 <= nj < M:
                        if board[ni][nj] == 0 and visited[ni][nj]:
                            count += 1
                if count >= 2:
                    cheese.append((i, j))

    for x, y in cheese:
        board[x][y] = 0 

    return bool(cheese) 


N, M = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(N)]

time = 0
while True:
    visited = check_visited()
    if not melt_cheese(visited):
        break
    time += 1

print(time)