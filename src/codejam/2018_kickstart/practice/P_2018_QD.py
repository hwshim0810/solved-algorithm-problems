with open('D-small-attempt0.out', 'w') as f:
    rf = open('D-small-attempt0.in', 'r')

    t = int(rf.readline())
    for i in range(1, t+1):
        N, Q = list(map(int, rf.readline().split()))
        elements = list(map(int, rf.readline().split()))

        sub = []

        for j in range(1, N + 1):
            for k in range(N - j + 1):
                sub.append(sum(elements[k:k+j]))

        sub.sort()

        f.write("Case #{}:\n".format(i))
        for j in range(Q):
            [L, R] = list(map(int, rf.readline().split()))
            f.write("{}\n".format(sum(sub[L-1:R])))
