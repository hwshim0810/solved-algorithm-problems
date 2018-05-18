def solution(A, K):
    l = len(A)

    if K == 0 or l <= 2:
        if K % 2 == 1:
            A.reverse()
        return A

    for i in range(K):
        A = A[l - 1:l] + A[:l - 1]

    return A
