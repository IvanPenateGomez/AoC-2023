from collections import Counter

values = {
    "A": 10,
    "K": 9,
    "Q": 8,
    "T": 6,
    "9": 5,
    "8": 4,
    "7": 3,
    "6": 2,
    "5": 1,
    "4": 0,
    "3": -1,
    "2": -2,
    "J": -3
}

def merge_sort(arr):
    if len(arr) == 1:
        return arr
    else:
        arr1 = merge_sort(arr[:len(arr) // 2])
        arr2 = merge_sort(arr[len(arr)//2:])
        
        new_arr = []
        while arr1 and arr2:
            new_arr.append(arr1.pop(0) if sortingCondition(arr1[0] , arr2[0]) else arr2.pop(0))
        new_arr.extend(arr2 if not arr1 else arr1)
        return new_arr

def get_repetitions(nums):
    counts = Counter(nums[0].replace("J", ""))
    joker_count = nums[0].count("J")
    most_common = counts.most_common(2)
    if most_common:
        if len(most_common) > 1:
            return [most_common[0][1], most_common[1][1]] , joker_count
        else:
            return [most_common[0][1] , 0] , joker_count
    else:
        return [0,0] , joker_count

def compare_hands(hand1, hand2):
    for card1, card2 in zip(hand1, hand2):
        if values[card1] > values[card2]:
            return True
        elif values[card1] < values[card2]:
            return False
    return False

def sortingCondition(hand1, hand2):
    repetitions1 , joker1 = get_repetitions(hand1)
    repetitions2 , joker2 = get_repetitions(hand2)
    repetitions1[0] += joker1
    repetitions2[0] += joker2
    
    if repetitions1[0] > repetitions2[0]:
        return True
    elif repetitions1[0] < repetitions2[0]:
        return False
    
    if repetitions1[0] == repetitions2[0] and repetitions1[1] > repetitions2[1]:
        return True
    elif repetitions1[0] == repetitions2[0] and repetitions1[1] < repetitions2[1] : 
        return False
    return compare_hands(hand1[0], hand2[0])
  
file = open("text.txt")
bets = [list(line.strip().split()) for line in file]
ordered = merge_sort(bets)

total_winnings = sum(int(hand[1]) * (len(ordered) - idx) for idx, hand in enumerate(ordered))
print(total_winnings)
