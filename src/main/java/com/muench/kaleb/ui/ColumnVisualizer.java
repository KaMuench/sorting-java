package com.muench.kaleb.ui;

import javax.swing.*;
import com.muench.kaleb.Data;
import com.muench.kaleb.sorting.algorithms.BubbleSort;
import com.muench.kaleb.sorting.algorithms.MergeSort;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.IntStream;

/**
 * This class is responsible for visualizing the sorting algorithms.
 * It creates a window with columns that represent the data to be sorted.
 * The data displayed, can be updated continuously.
 */
public class ColumnVisualizer extends JFrame {

    private static CallBack callBack = new CallBack() {
        @Override
        public <T> void update(T value) {
            if(value instanceof Integer[]) {
                data.insertData((Integer[]) value);
                System.out.printf("%-20s: %-70s%n%n", "Callback", Arrays.toString((Integer[]) value));
            }
        }
    };
    private static final int SIZE = 20;
    private static final Data<Integer> data = new Data<>();
    private AtomicBoolean isSorted = new AtomicBoolean(false);

    BubbleSort<Integer> bubbleSort = new BubbleSort<>(callBack);
    MergeSort<Integer> mergeSort = new MergeSort<>(callBack);
    ColumnPanel columnPanel;

    Timer dataTimer = new Timer(50, e -> {
        Integer[] array = data.getNewData();
        if(isSorted.get()) columnPanel.isSorted(true);
        if(array == null) return;                              // If data is null, don't update
        System.out.printf("%-20s: %-70s%n", "ColumnVisualizer", Arrays.toString(array));
        columnPanel.setData(array);
    });

    public ColumnVisualizer() {
        this.setSize(800, 600);
        this.setTitle("Sorting Algorithms Visualizer");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setUpData();


        columnPanel = new ColumnPanel();
        this.add(columnPanel);
        setVisible(true);
    }

    private void setUpData() {
        List<Integer> list = new ArrayList<>(IntStream.range(1, SIZE).boxed().toList());
        Collections.shuffle(list);
        data.insertData(list.toArray(Integer[]::new));
    }

    public void runMergeSort() {
        this.dataTimer.start();
        columnPanel.startTimer();
        new Thread(() -> {
            mergeSort.sort(data.cloneData());
            isSorted.set(true);
        }).start();
    }
}
