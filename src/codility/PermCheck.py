def solution(A):
    if len(A) == 1:
        return 1 if A[0] == 1 else 0
    
    A.sort()
    prev = 0
    for i in A:
        if i != (prev + 1):
            return 0
        else:
            prev = i
    return 1

