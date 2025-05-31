from collections import deque
import sys
input = sys.stdin.readline

def calculate_dslr(n):
    return [
        ((n * 2) % 10000, 'D'),
        (9999 if n == 0 else n - 1, 'S'),
        ((n % 1000) * 10 + n // 1000, 'L'),
        ((n % 10) * 1000 + n // 10, 'R')
    ]

T = int(input())
for _ in range(T):
    A, B = map(int, input().split())
    
    visited = [False] * 10000
    
    q = deque()
    q.append((A, ''))
    visited[A] = True
    while q:
        n, command = q.popleft()
        if n == B:
            print(command)
            break

        for num, c in calculate_dslr(n):
            if not visited[num]:
                visited[num] = True
                q.append((num, command + c))