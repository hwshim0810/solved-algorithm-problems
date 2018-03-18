with open('A-large.out', 'w') as f:
    rf = open('A-large.in', 'r')
    line = rf.readline()

    t = int(line)
    for i in range(1, t+1):
        bus_couples = int(rf.readline())
        temp_line = rf.readline().strip().split(' ')
        buses = []

        for j in range(0, len(temp_line), 2):
            couple = (int(temp_line[j]), int(temp_line[j+1]))
            buses.append(couple)

        len_city = int(rf.readline())

        score = [0 for _ in range(len_city)]

        for j in range(len_city):
            city = int(rf.readline())
            for bus in buses:
                if city < bus[0] or city > bus[1]:
                    continue
                else:
                    score[j] = score[j] + 1

        score_line = ' '.join(str(x) for x in score)

        f.write("Case #{}: {}\n".format(i, score_line))
        rf.readline()
