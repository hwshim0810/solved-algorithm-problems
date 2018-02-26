input()

while 1:
    ps = str(input())

    while '()' in ps:
        ps = ps.replace('()', '')

    print('NO' if ps else 'YES')
