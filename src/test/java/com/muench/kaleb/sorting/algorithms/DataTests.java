package com.muench.kaleb.sorting.algorithms;

import com.muench.kaleb.Data;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class DataTests {

    private static ArrayList<Integer[]> list = new ArrayList<>();

    @BeforeAll
    public static void setup() {
        list.add(new Integer[]{5, 4, 3, 2, 1});
        list.add(new Integer[]{1,3,2,6,4,5});
    }

    @Test
    public void GetAndSetDataTest() {
        Data<Integer> data = new Data<>();
        data.insertData(list.get(0));
        data.insertData(list.get(1));
        Integer[] first = data.getNewData();
        Integer[] second = data.getNewData();

        Assertions.assertArrayEquals(first, list.get(0), String.format("Expected %s, got %s", list.get(0), first));
        Assertions.assertArrayEquals(second, list.get(1), String.format("Expected %s, got %s", list.get(1), second));

    }

}
