import sys
input = sys.stdin.readline

N, M, x, y, K = map(int, input().split())
grid = [list(map(int, input().split())) for _ in range(N)]
moves = list(map(int, input().split()))

dice = [0] * 6  # [윗, 바닥, 북, 남, 서, 동]
dx = [0, 0, -1, 1]  # 동, 서, 북, 남
dy = [1, -1, 0, 0]

def move_dice(m):
    global x, y

    nx = x + dx[m - 1]
    ny = y + dy[m - 1]

    if nx < 0 or ny < 0 or nx >= len(grid) or ny >= len(grid[0]):
        return
    
    temp = dice[0]
    if m == 1:  
        dice[0] = dice[4]
        dice[4] = dice[1]
        dice[1] = dice[5]
        dice[5] = temp
    elif m == 2:  
        dice[0] = dice[5]
        dice[5] = dice[1]
        dice[1] = dice[4]
        dice[4] = temp
    elif m == 3:  
        dice[0] = dice[3]
        dice[3] = dice[1]
        dice[1] = dice[2]
        dice[2] = temp
    elif m == 4: 
        dice[0] = dice[2]
        dice[2] = dice[1]
        dice[1] = dice[3]
        dice[3] = temp

    if grid[nx][ny] == 0:
        grid[nx][ny] = dice[1]
    else:
        dice[1] = grid[nx][ny]
        grid[nx][ny] = 0

    print(dice[0])

    x, y = nx, ny

for m in moves:
    move_dice(m)
