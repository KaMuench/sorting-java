package com.muench.kaleb.sorting.algorithms;

import com.muench.kaleb.ui.ColumnPanel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ColumnPanelTests {

    @Test
    public void InterpolationTest() {
        float speed = 0.1f;
        int start = 0;
        int end = 5;
        int[] positions = new int[]{0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5};
        for(float process=0.f; process<=1.f; process+=speed) {
            int interpolated = ColumnPanel.interpolate(start, end, process);
            int index = positions[(int)(process*10)];
            Assertions.assertEquals(index, interpolated, String.format("Iteration: %d", index));
        }
    }
}
