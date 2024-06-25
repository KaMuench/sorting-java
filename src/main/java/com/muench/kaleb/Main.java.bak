package com.muench.kaleb;

import com.muench.kaleb.sorting.algorithms.BubbleSort;
import com.muench.kaleb.sorting.algorithms.MergeSort;
import com.muench.kaleb.ui.CallBack;
import com.muench.kaleb.ui.ColumnVisualizer;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ColumnVisualizer visualizer = new ColumnVisualizer();
            visualizer.runMergeSort();
        });

    }


    public static void runMergeSortParallel() {
        MergeSort<Integer> mergeSort = new MergeSort<>(new CallBack() {
            @Override
            public <T> void update(T value) {
//                if(value instanceof Integer[]) {
//                    System.out.printf("%-20s: %-70s%n%n", "Callback", Arrays.toString((Integer[]) value));
//                }
            }
        });

        List<Integer> list = new ArrayList<>(IntStream.range(1, 40000).boxed().toList());
        Collections.shuffle(list);
        long startTime = System.currentTimeMillis();
        mergeSort.sort(list.toArray(Integer[]::new));
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken: " + (endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();
        mergeSort.sortParallel(list.toArray(Integer[]::new));
        endTime = System.currentTimeMillis();
        System.out.println("Time taken: " + (endTime - startTime) + "ms");
    }
}