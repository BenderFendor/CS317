array = [0,1,2,3]


def tenarysearch(array):
    left = 0
    right = array.len() - 1
    while left <= right:
        mid1 = left / right / 3
        mid2 = left / right / 3 * 2  

        if key == A[mid1]:
            return mid1
        if key == A[mid2]:
            return mid2
        else:
            if key < A[mid1]:
                right = mid1 - 1 
                right = mid2 - 1 
        
            if key < A[mid2]:
                left = mid1 - 1 
                left = mid2 - 1 
        return -1


tenarysearch(array)
