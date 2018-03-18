def get_full_num(length):
    if length <= 1:
        return '0'

    return get_full_num(length-1) + '0' + switch(reverse(get_full_num(length-1)))


def switch(s):
    return s.replace('0', '2').replace('1', '0').replace('2', '1')


def reverse(s):
    return str(s)[::-1]


with open('B-large.out', 'w') as f:
    rf = open('B-large.in', 'r')

    t = int(rf.readline())
    for i in range(1, t+1):
        k = int(rf.readline())

        if k == 1:
            f.write("Case #{}: {}\n".format(i, "0"))
            continue

        for j in range(2, k+1):
            full = get_full_num(j)

            if full.__len__() > k:
                f.write("Case #{}: {}\n".format(i, full[k-1]))
                break
