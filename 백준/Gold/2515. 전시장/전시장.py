import sys
input = sys.stdin.readline

def find_index(heights, current_height, S):
    target = current_height - S 
    left = 0
    right = len(heights) - 1
    result = -1 

    while left <= right:
        mid = (left + right) // 2
        if heights[mid] <= target:
            result = mid
            left = mid + 1 
        else:
            right = mid - 1 

    return result

N, S = map(int, input().split())
pictures = sorted([list(map(int, input().split())) for _ in range(N)]) #[높이, 가격]
heights = [h for h, _ in pictures]

dp = [0] * N
max_dp = [0] * N

for i in range(N):
    h, c = pictures[i]
    index = find_index(heights, h, S)

    if index >= 0:
        dp[i] = max(dp[i-1], max_dp[index] + c)
    else:
        dp[i] = max(dp[i-1], c)
  
    max_dp[i] = max(max_dp[i-1], dp[i])

print(dp[N-1]) 
