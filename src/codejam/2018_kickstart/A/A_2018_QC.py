# Wrong...

with open('C-small-practice.out', 'w') as f:
    rf = open('C-small-practice.in', 'r')
    line = rf.readline()

    t = int(line)
    for i in range(1, t+1):
        dic_len = int(rf.readline().strip())
        ex_dic = rf.readline().strip().split(' ')
        s1, s2, s_len, a, b, c, d = rf.readline().strip().split(' ')

        a, b, c, d, s_len = list(map(int, [a, b, c, d, s_len]))

        res_s = s1 + s2
        x_list = [ord(s1), ord(s2)]

        for x in range(3, s_len+1):
            asc = ((a * x_list[x-2]) + (b * x_list[x-3]) + c) % d
            x_list.append(asc)
            res_s += chr(97 + int(asc % 26))

        count = 0

        for c in ex_dic:
            c_len = len(c)
            c_first = c[0]
            c_end = c[c_len-1]
            c_lest = c[1:c_len-1]
            find = set()

            for j, s in enumerate(res_s, 0):
                if s == c_first:
                    temp = res_s[j:c_len+j]

                    if len(temp) < c_len:
                        count += find.__len__()
                        break

                    if temp[len(temp)-1] == c_end:
                        flag = True
                        for c2 in c_lest:
                            if c2 not in temp:
                                flag = False
                                break

                        if flag:
                            find.add(temp)

            count += find.__len__()

        f.write("Case #{}: {}\n".format(i, count))
