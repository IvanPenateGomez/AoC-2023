def getSeeds(seeds):
    newSeeds = [(seeds[0][0] , seeds[0][0] + seeds[0][1])]
    
    for i in range(len(seeds)):
        start = seeds[i][0]
        end = seeds[i][0] + seeds[i][1]
        for x in range(len(newSeeds)):
            start2 = seeds[x][0]
            end2 = seeds[x][0] + seeds[x][1]
            
            if start > start2 and end < end2:
                break
            elif start < start2 and end < end2 and end > start2:
                newSeeds[x] = (start , end2)
            elif start > start2 and end > end2 and start < end2:
                newSeeds[x] = (start2 , end)
            else:
                if (start, end) not in newSeeds:
                    newSeeds.append((start,end))
                
    return newSeeds


file = open("text.txt")
seeds = []
ranges = []
inside = False
smallRange = []
for line in file:
    if "seeds" in line:
        line = line.replace("seeds:" , "")
        seeds = [int(x) for x in line.split()]
        
    elif "-" in line:
        inside = True
    elif "\n" == line:
        ranges.append(smallRange)
        smallRange = []
        inside = False
    elif inside:
        smallRange.append([int(num) for num in line.split()])
ranges.append(smallRange)
ranges = ranges[1:]

lowest = -1
for s in seeds:
    for ran in ranges:
        for dest , sour , l in ran:
            if s >= sour and s < sour + l:
                s = s - sour + dest
                break
    if lowest == -1 or s < lowest:
        lowest = s

print(lowest)
