def get_res(A, S):
    r = set([i for i in range(1, max(A)+1, 1)]).difference(S)
    return min(r) if r else max(A)+1
    

def solution(A):
    s = set(A)
    if len(s) == len(A):
        if min(s) < 0 and max(s) < 0:
            return 1
        if 1 not in s:
            return 1
            
        return get_res(A,s)
    else:
        return get_res(A,s)

