from operator import eq
'''
path의 current_path로 들어온 경로를
cd method를 이용해 경로를 바꿀 수 있게 설계

'''


class Path:
    def __init__(self, path):
        self.current_path = path

    def cd(self, new_path):
        new_list = new_path.split('/')
        new_list.remove('')
        old_list = self.current_path.split('/')
        old_len = len(old_list)
        new_len = len(new_list)
        res = '/'
        up_count = 0

        for cmd in new_list:
            if eq(cmd, '..'):
                up_count += 1

        for i in range(0, old_len - up_count):
            if not eq(old_list[i], ''):
                res += old_list[i] + '/'

        for i in range(0, new_len):
            if not eq(new_list[i], '..'):
                if i == new_len - 1 or eq(new_list[i], ''):
                    res += new_list[i]
                else:
                    res += new_list[i] + '/'

        if eq(res[-1], '/'):
            res = res[:len(res) - 1]

        self.current_path = res

        return self

path = Path('/a/b/c/d')
path = path.cd('../d/x')
print(path and path.current_path)