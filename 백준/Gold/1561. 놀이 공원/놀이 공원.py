import sys
input = sys.stdin.readline

def find_number(N, M, times):
    left = 1
    right = max(times) * N
    answer = 0

    # 이분탐색으로 N명이 타려면 몇분이 걸리는지 구하기
    while left <= right:
        mid = (left + right) // 2
        
        total = M 
        for t in times:
            total += mid // t

        if total >= N:
            answer = mid
            right = mid - 1
        else:
            left = mid + 1
 
    # 마지막 아이가 어디 놀이기구에 타있는지 구하기
    total = M
    for t in times:
        total += (answer - 1) // t

    i = 0
    while i < len(times):
        time = times[i]  
        if answer % time == 0:
            total += 1
            if total == N:
                print(i + 1)
                return
        i += 1


N, M = map(int, input().split())
times = list(map(int, input().split()))

if N <= M:
    print(N)
else:
    find_number(N, M, times)

