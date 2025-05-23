import sys
input = sys.stdin.readline

def find_length(m, array):
    left = 1
    right = array[-1]
    answer = 0

    while left <= right:
        mid = (left + right) // 2

        count = 0
        for i in range(1, len(array)):
            d = array[i] - array[i - 1]
            count += (d - 1) // mid

        if count > m:
            left = mid + 1
        else:
            answer = mid
            right = mid - 1

    return answer


N, M, L = map(int, input().split())

array = [0] 
if N > 0:
    array += list(map(int, input().split()))
array.append(L)
array.sort()

print(find_length(M, array))