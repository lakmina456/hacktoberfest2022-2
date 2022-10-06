def mergesort(arr):
    if len(arr) <= 1:
        return arr
    else:
        l = mergesort(arr[:len(arr)//2])
        r = mergesort(arr[len(arr)//2:])
        b = merge(l,r)
    return b

def merge(l,r):
    m, n = len(l), len(r)
    c = []
    i, j, k = 0, 0, 0
    while k < m + n:
        if i == m:
            c += r[j:]
            k += (n - j)
        elif j == n:
            c += l[i:]
            k += (m - i)
        elif l[i] < r[j]:
            c.append(l[i])
            i += 1
            k += 1
        else:
            c.append(r[j])
            j += 1
            k += 1
    return c   
from random import randrange
l = [randrange(0,100) for i in range(13)]
print(l)
print(mergesort(l))
