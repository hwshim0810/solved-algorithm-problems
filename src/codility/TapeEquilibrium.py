def solution(A):
    leng = len(A)

    if leng == 2:
        return abs(A[0] - A[1])
    res = 999999999999
    prevs = A[0]
    nexts = sum(A[1:])

    for idx, p in enumerate(A, 2):
        cur = idx - 1
        val = abs(prevs - nexts)
        if val < res:
            res = val

        prevs += A[cur]
        nexts -= A[cur]

        if idx == leng:
            break

    return res
