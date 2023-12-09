def part1(arr):
    diffArr = [arr[x + 1] - arr[x] for x in range(len(arr) - 1)]
    
    if all(x == diffArr[0] for x in diffArr):
        return arr[-1] + diffArr[0]
    
    return arr[-1] + part1(diffArr)

def part2(arr):
    diffArr = [arr[x + 1] - arr[x] for x in range(len(arr) - 1)]
    
    if all(x == diffArr[0] for x in diffArr):
        return arr[0] - diffArr[0]
    
    return arr[0] - part2(diffArr)

file = open("text.txt")
print(sum(list(part1(list(map(int , line.strip().split()))) for line in file)))
file.close()
file = open("text.txt")
print(sum(list(part2(list(map(int , line.strip().split()))) for line in file)))
