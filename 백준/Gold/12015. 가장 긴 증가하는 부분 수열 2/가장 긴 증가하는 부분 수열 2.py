import sys
input = sys.stdin.readline

def find_index(arr, num):
    left, right = 0, len(arr)
    while left < right:
        mid = (left + right) // 2
        if arr[mid] < num:
            left = mid + 1
        else:
            right = mid
    return left


N = int(input())
A = list(map(int, input().split()))

LIS = []
for a in A:
    index = find_index(LIS, a)
    if index == len(LIS):
        LIS.append(a)
    else:
        LIS[index] = a

print(len(LIS))
