package com.muench.kaleb.mergesort.sorting.algorithms;

import org.junit.jupiter.api.*;
public class BubbleSortTest  {

    @Test
    public void testSort() {
        BubbleSort bubbleSort = new BubbleSort(null);
        Integer[] list = {5, 4, 3, 2, 1};
        Integer[] sortedList = bubbleSort.sort(list);
        Assertions.assertArrayEquals(new Integer[]{1, 2, 3, 4, 5}, sortedList);
    }
}