def is_complete(number, plus=True):
    total = 0

    while True:
        cnt = 0
        for c in number:
            if int(c) % 2 != 0:
                cnt += 1

        if cnt == 0:
            break
        else:
            if plus:
                number = str(int(number) + 1)
            else:
                number = str(int(number) - 1)
            total += 1

    return total


with open('A-large.out', 'w') as f:
    rf = open('A-large.in', 'r')
    line = rf.readline()

    t = int(line)
    for i in range(1, t+1):
        number = rf.readline().strip()

        p_total = is_complete(number)
        m_total = is_complete(number, False)

        if p_total > m_total:
            f.write("Case #{}: {}\n".format(i, m_total))
        else:
            f.write("Case #{}: {}\n".format(i, p_total))

