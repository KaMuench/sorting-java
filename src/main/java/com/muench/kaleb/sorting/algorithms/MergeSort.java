package com.muench.kaleb.sorting.algorithms;

import com.muench.kaleb.ui.CallBack;

import java.util.concurrent.CountDownLatch;

public class MergeSort<T extends Comparable> implements Sort<T> {

    private T[] currentList;

    // CallBack interface to update the visualizer
    CallBack callBack;

    public MergeSort(CallBack callBack) {
        this.callBack = callBack;
    }

    // Constructor with empty callback method
    public MergeSort() {
        this.callBack = new CallBack() {
            @Override
            public <T> void update(T value) {
            }
        };
    }

    @Override
    public T[] sort(T[] list) {
        T[] copy = list.clone();
        currentList = copy.clone();
        split(copy);
        return copy;
    }

    private void split(T[] list) {
        if (list.length <= 1) {
            return;
        }
        int mid = list.length / 2;
        T[] left = (T[]) new Comparable[mid];
        T[] right = (T[]) new Comparable[list.length - mid];
        System.arraycopy(list, 0, left, 0, mid);
        System.arraycopy(list, mid, right, 0, list.length - mid);

        split(left);
        split(right);
        merge(list, left, right);
    }

    private void splitParallel(T[] list) {
        if (list.length <= 1) {
            return;
        }
        int mid = list.length / 2;
        T[] left = (T[]) new Comparable[mid];
        T[] right = (T[]) new Comparable[list.length - mid];
        System.arraycopy(list, 0, left, 0, mid);
        System.arraycopy(list, mid, right, 0, list.length - mid);

        if (list.length > 100) {
            Thread one = new Thread(() -> splitParallel(left));
            Thread two = new Thread(() -> splitParallel(right));
            one.start();
            two.start();
            try {
                one.join();
                two.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            split(left);
            split(right);
        }
        merge(list, left, right);
    }

    private void merge(T[] list, T[] left, T[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i].compareTo(right[j]) < 0) {
                list[k++] = left[i++];
            } else {
                list[k++] = right[j++];
            }
        }
        while (i < left.length) {
            list[k++] = left[i++];
        }
        while (j < right.length) {
            list[k++] = right[j++];
        }
        for (int l = 0; l < currentList.length; l++) {
            for (T t : list) {
                if (currentList[l].equals(t)) {
                    System.arraycopy(list, 0, currentList, l, list.length);
                    callBack.update(currentList);
                    return;
                }
            }
        }
    }

    public T[] sortParallel(T[] list) {
        T[] copy = list.clone();
        currentList = copy.clone();
        splitParallel(copy);
        return copy;
    }
}
