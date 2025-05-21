import sys
input = sys.stdin.readline 

N = int(input())

dp = []
for length in range(N + 1): # 길이
    number_layer = []
    for num in range(10):  # 0 ~ 9 숫자
        bitmask_layer = [0] * (1 << 10)  # 숫자사용여부
        number_layer.append(bitmask_layer)
    dp.append(number_layer)


for i in range(1, 10):
    dp[1][i][1 << i] = 1

for i in range(2, N + 1):
    for j in range(10):
        for k in range(1 << 10): 
            if j == 0:
                dp[i][0][k | (1 << 0)] += dp[i-1][1][k]
            elif j == 9:
                dp[i][9][k | (1 << 9)] += dp[i-1][8][k]
            else:
                dp[i][j][k | (1 << j)] += dp[i-1][j-1][k]
                dp[i][j][k | (1 << j)] += dp[i-1][j+1][k]
                
result = 0
for i in range(10):
    result += dp[N][i][(1 << 10) - 1]
    result %= 1000000000

print(result)