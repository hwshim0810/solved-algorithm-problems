# Time complexity: O(N**2)
def solution(A):
    res = 0
    while True:
        res = A.pop()
        if res not in A:
            break
        else:
            A.remove(res)

    return res

# Better solution
from collections import Counter


def solution(A):
    return list(filter(lambda x: x[1]%2 == 1,list(Counter(A).items())))[0][0]
