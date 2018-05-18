def solution(A):
    if not A:
        return 1
    elif len(A) == 1:
        if A[0] == 1:
            return 2
        else:
            return 1

    A.sort()
    prev = 0
    for i in A:
        if i != (prev + 1):
            return i - 1
        else:
            prev = i

    return prev + 1
