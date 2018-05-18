# Wrong...

with open('B-small-attempt2.out', 'w') as f:
    rf = open('B-small-attempt2.in', 'r')
    line = rf.readline()

    t = int(line)
    for i in range(1, t+1):
        total_items, retry = list(map(int, rf.readline().strip().split(' ')))
        values = list(map(int, rf.readline().strip().split(' ')))
        values_cnt = values.__len__()

        if retry == 0:
            res = '%.6f' % (sum(values)/values_cnt)
            f.write("Case #{}: {}\n".format(i, res))
            continue

        max_value = max(values)
        max_cnt = 0

        ex = list()

        for v in values:
            if v != max_value:
                ex.append(v)
            else:
                max_cnt += 1

        if max_cnt == values_cnt:
            max_value = '%.6f' % max_value
            f.write("Case #{}: {}\n".format(i, max_value))
            continue

        max_avr = ((((2*values_cnt)-max_cnt) / (values_cnt * values_cnt)) * max_cnt * max_value)
        avr = 0

        for v in ex:
            avr += ((values_cnt-max_cnt) / (values_cnt * values_cnt)) * v

        res = '%.6f' % (max_avr + avr)
        f.write("Case #{}: {}\n".format(i, res))
