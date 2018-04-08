CHARGE = 'C'
SHOOT = 'S'

t = int(input())
for i in range(1, t+1):
    hp, combo = input().split(' ')
    hp = int(hp)

    if CHARGE not in combo:
        if len(combo) > hp:
            print("Case #{}: {}\n".format(i, 'IMPOSSIBLE'))
            continue
        else:
            print("Case #{}: {}\n".format(i, 0))
            continue

    if SHOOT not in combo:
        print("Case #{}: {}\n".format(i, 0))
        continue

    moved = 0
    more_find = True
    impossible = False

    while True:
        current_dam = 1
        received = 0

        for j, c in enumerate(combo):

            if c == CHARGE:
                current_dam = current_dam << 1

                if current_dam > hp and j < len(combo)-1:
                    break
            else:
                received += current_dam

            if j == len(combo)-1 and received <= hp:
                more_find = False

        if more_find:
            idx = combo.rfind('CS')
            if idx == -1:
                impossible = True
                break
            else:
                combo = combo[:idx] + 'SC' + combo[idx+2:]
                moved += 1
        else:
            break

    if impossible:
        print("Case #{}: {}\n".format(i, 'IMPOSSIBLE'))
    else:
        print("Case #{}: {}\n".format(i, moved))
