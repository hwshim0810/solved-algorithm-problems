def get_result(dic, res, s):
    try:
        next_dest = dic.pop(s)
        res = res + ' {}-{}'.format(s, next_dest)
        return get_result(dic, res, next_dest)
    except KeyError:
        return res


with open('C-large.out', 'w') as f:
    rf = open('C-large.in', 'r')

    t = int(rf.readline())
    for i in range(1, t+1):
        k = int(rf.readline()) * 2

        ticks = {}
        first = ''

        for j in range(0, k, 2):
            start = rf.readline().strip()
            end = rf.readline().strip()
            ticks[start] = end

        starts = ticks.keys()
        ends = ticks.values()

        for start in starts:
            if start in ends:
                continue
            else:
                first = start
                break

        result = []
        source = start
        while len(ticks) > 0:
            destination = ticks.pop(source)
            result.append("%s-%s" % (source, destination))
            source = destination

        # second = ticks.pop(first)
        #
        # result = get_result(ticks, '{}-{}'.format(first, second), second)

        f.write("Case #{}: {}\n".format(i, " ".join(result)))

