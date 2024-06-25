# sorting-java (IntellijIDEA)
This project contains several implementations of sorting algorithms. A GUI is there to visualize the sorting.

## Implemented Algorithms

### Bubblesort O(n^2)
This is probably the simplest sorting algorithm there is. The algorithm starts with the first element in the list and compares it to the second element. If the first one is bigger than the second they switch places. Now the element at the second position is compared with the thrid one. Same thing here. This process is done for all elements in the list. Then it starts from the beginning. If all elements are in order the algorithm stops. The elements are then ordered from smallest to biggest. The algorithm got its name, because the elements move from the one site of the list to the other, like bubbles in water ascent to the surface.  

![Bubblesort](https://github.com/KaMuench/sorting-java/blob/main/assets/bubblesort.gif)

### Mergesort O(n*log(n))
This algorithm is a little more complex. It splits the list into two parts. The emerging lists are again split into two halfs. This process is repeated until the sublists can not be split further. For each split the two halfs are sorted. The first elements of both halfs are compared. The bigger element is added to a third list. Now the second element of one half is compared with the remaining first element of the other half. Again the greate element is added to the third list. This is done for all elements in both halfs. The third list is one half of the previous split, if it not contains all elements of the very first list. The sorting process is called merging. Therefore the name mergeosrt.  

![Mergesort](https://github.com/KaMuench/sorting-java/blob/main/assets/mergesort.gif)
