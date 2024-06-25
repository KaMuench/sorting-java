package com.muench.kaleb.sorting.algorithms;

import org.junit.jupiter.api.*;
public class SortingTests {

    @Test
    public void testSort() {
        BubbleSort<Integer> bubbleSort = new BubbleSort<>(null);
        Integer[] list = {5, 4, 3, 2, 1};
        Integer[] sortedList = bubbleSort.sort(list);
        Assertions.assertArrayEquals(new Integer[]{1, 2, 3, 4, 5}, sortedList);
    }

    @Test
    public void testMergeSort() {
        MergeSort<Integer> mergeSort = new MergeSort<>();
        Integer[][] list = {
                {5, 4, 3, 2, 1},
                {1,3,2,6,4,5}

        };
        Integer[][] sortedListVerify = {
                {1, 2, 3, 4, 5},
                {1,2,3,4,5,6}
        };
        for(int i=0;i<list.length;i++){
            Integer[] sortedList = mergeSort.sort(list[i]);
            Assertions.assertArrayEquals(sortedList, sortedListVerify[i]);
        }
    }
}