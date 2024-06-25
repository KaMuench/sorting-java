package com.muench.kaleb.sorting.algorithms;

/**
 * Interface for sorting algorithms

 */
public interface Sort  <T extends Comparable>{
     /**
      * Sorts a list of elements
      * @param list an array of a generic type
      * @return the sorted array
      */
     T[] sort(T[] list);
}
