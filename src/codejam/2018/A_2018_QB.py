t = int(input())

for i in range(1, t+1):
    total = int(input())
    nums = list(map(int, input().split(' ')))

    sorted_nums = nums[:]
    sorted_nums.sort()

    done = False
    err = pow(10, 9)

    while not done:
        done = True

        for j in range(len(nums)-2):
            if nums[j] > nums[j+2]:
                done = False

                temp = nums[j+2]
                nums[j+2] = nums[j]
                nums[j] = temp

    if sorted_nums == nums:
        print("Case #{}: {}\n".format(i, 'OK'))
    else:
        for k in range(len(nums)):
            if nums[k] > nums[k+1]:
                err = k
                break

        print("Case #{}: {}\n".format(i, err))
