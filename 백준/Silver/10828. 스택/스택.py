import sys
input = sys.stdin.read
output = sys.stdout.write

def operator(l, s):
    if s[0] == 'push':
        l.append(s[1])
    elif s[0] == 'pop':
        if not l:
            return -1
        else:
            return l.pop()
    elif s[0] == 'empty':
        return 1 if not l else 0
    elif s[0] == 'top':
        if not l:
            return -1
        else:
            return l[-1]
    elif s[0] == 'size':
        return len(l)

def main():
    input_data = input().strip().split('\n')
    a = int(input_data[0])
    l = []
    results = []
    for i in range(1, a + 1):
        s = input_data[i].split()
        result = operator(l, s)
        if result is not None:
            results.append(result)
    output('\n'.join(map(str, results)) + '\n')

if __name__ == "__main__":
    main()
