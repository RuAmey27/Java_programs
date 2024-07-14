def reverse_sort_cost(arr):
    n = len(arr)
    return n * (3 * n + 2)

arr = [9, 8, 7, 6, 5, 4, 3, 2, 1]
print("The reverse sort cost for a 9 element array is:", reverse_sort_cost(arr), "units")
