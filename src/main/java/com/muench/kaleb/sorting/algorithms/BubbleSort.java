package com.muench.kaleb.sorting.algorithms;

import com.muench.kaleb.ui.CallBack;

/**
 * Implementation of the bubblesort algorithm
 */
public class BubbleSort <T extends Comparable> implements Sort<T> {

    // CallBack interface to update the visualizer
    CallBack callBack;

    public BubbleSort (CallBack callBack) {
        this.callBack = callBack;
    }

    // Constructor with empty callback method
    public BubbleSort () {
        this.callBack = new CallBack() {
            @Override
            public <T> void update(T value) {
            }
        };
    }

    @Override
    public T[] sort(T[] list) {
        T[] newArray = list.clone();

        for(int i=0;i<newArray.length;i++){
            for(int j=0;j<newArray.length-1;j++){
                if(newArray[j].compareTo(newArray[j+1]) > 0){
                    T temp = newArray[j];
                    newArray[j] = newArray[j+1];
                    newArray[j+1] = temp;
                    callBack.update(newArray);
                }
            }
        }
        return newArray;
    }
}
