package com.muench.kaleb.mergesort;

import com.muench.kaleb.mergesort.sorting.algorithms.BubbleSort;
import com.muench.kaleb.mergesort.ui.CallBack;
import com.muench.kaleb.mergesort.ui.ColumnVisualizer;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static final int SIZE = 20;
    private static final Data<Integer> data = new Data<>();

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(IntStream.range(0, SIZE).boxed().toList());
        Collections.shuffle(list);
        Integer[] values = list.toArray(Integer[]::new);
        data.updateData(values);


        SwingUtilities.invokeLater(() -> {
            ColumnVisualizer visualizer = new ColumnVisualizer();
            visualizer.setVisible(true);

            new Timer(100, e -> {
               while(true) visualizer.updateData(data.getUpdate());
            }).start();
        });

        BubbleSort bubbleSort = new BubbleSort(new CallBack() {
            @Override
            public <T> void update(T value) {
                if(value instanceof Integer[]) {
                    data.updateData((Integer[]) value);
                    System.out.println(Arrays.toString((Integer[]) value));
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        bubbleSort.sort(values);
    }
}