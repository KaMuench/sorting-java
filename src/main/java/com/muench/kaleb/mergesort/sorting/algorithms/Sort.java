package com.muench.kaleb.mergesort.sorting.algorithms;

/**
 * Interface for sorting algorithms

 */
public interface Sort {
     /**
      * Sorts a list of elements
      * @param list an array of a generic type
      * @return the sorted array
      * @param <T> any comparable type
      */
     <T extends Comparable> T[] sort(T[] list);
}
