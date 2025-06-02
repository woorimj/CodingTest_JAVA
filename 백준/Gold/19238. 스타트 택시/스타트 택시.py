import sys
from collections import deque
input = sys.stdin.readline

dx = [0, 0, -1, 1]
dy = [1, -1, 0, 0]
def choose_passenger(taxiX, taxiY):
    visited = [[False]*N for _ in range(N)]
    queue = deque()
    queue.append((taxiX-1, taxiY-1, 0))
    visited[taxiX-1][taxiY-1] = True

    distances = []
    while queue:
        x, y, dist = queue.popleft()
        
        for i, passenger in enumerate(passengers):
            sx, sy, ex, ey = passenger

            # 현 위치 = 승객 위치
            if (x+1, y+1) == (sx, sy): 
                distances.append((dist, x, y, i)) 

        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            if 0 <= nx < N and 0 <= ny < N and not visited[nx][ny]:
                if road[nx][ny] == 0:
                    visited[nx][ny] = True
                    queue.append((nx, ny, dist+1))
    
    if not distances:
        return -1 
    
    distances.sort()  
    return distances[0][3] 

def get_distance(start, end):
    visited = [[False]*N for _ in range(N)]
    queue = deque()
    x1, y1 = start
    x2, y2 = end
    queue.append((x1-1, y1-1, 0))
    visited[x1-1][y1-1] = True

    while queue:
        x, y, dist = queue.popleft()
        if (x, y) == (x2-1, y2-1):
            return dist
        
        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            if 0 <= nx < N and 0 <= ny < N and not visited[nx][ny]:
                if road[nx][ny] == 0:
                    visited[nx][ny] = True
                    queue.append((nx, ny, dist+1))
    return -1

def find_oil(idx, dist1, dist2):
    global oil, taxiX, taxiY
    
    if oil < dist1 + dist2:
        return False
    
    oil -= dist1
    oil -= dist2
    oil += dist2 * 2
    
    taxiX, taxiY = passengers[idx][2], passengers[idx][3] # 택시의 위치가 승객의 목적지 위치값으로 바뀜
    passengers[idx] = (-1, -1, -1, -1)  # 승객 제거
    return True

# 입력 처리
N, M, oil = map(int, input().split())
road = [list(map(int, input().split())) for _ in range(N)]
taxiX, taxiY = map(int, input().split())
passengers = [list(map(int, input().split())) for _ in range(M)] # (시작x, 시작y, 도착x, 도착y)

for _ in range(M):
    idx = choose_passenger(taxiX, taxiY)
  
    if idx == -1:
        print(-1)
        exit()

    start = (taxiX, taxiY)
    pickup = (passengers[idx][0], passengers[idx][1])
    dest = (passengers[idx][2], passengers[idx][3])

    dist1 = get_distance(start, pickup)
    dist2 = get_distance(pickup, dest)

    if dist1 == -1 or dist2 == -1 or not find_oil(idx, dist1, dist2):
        print(-1)
        exit()

print(oil)