def solution(X, A):
    leng = len(set(A))
    if leng != X:
        return -1
    elif leng == 1:
        if A[0] == 1:
            return 0
        else:
            return -1

    ready = [False for _ in range(len(A) + 1)]

    for idx, l in enumerate(A):
        if not ready[l]:
            ready[l] = True
            X -= 1

        if X == 0:
            return idx
