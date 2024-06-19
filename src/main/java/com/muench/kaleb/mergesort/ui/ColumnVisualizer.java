package com.muench.kaleb.mergesort.ui;

import javax.swing.*;
import java.awt.*;

/**
 * This class is responsible for visualizing the sorting algorithms.
 * It creates a window with columns that represent the data to be sorted.
 * The data displayed, can be updated continuously.
 */
public class ColumnVisualizer extends JFrame {

    ColumnPanel columnPanel;

    public ColumnVisualizer() {
        this.setSize(800, 600);
        this.setTitle("Sorting Algorithms Visualizer");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        columnPanel = new ColumnPanel();
        this.add(columnPanel);
    }

    /**
     * Update the data displayed in the window
     * @param data The data to be displayed, must be an array of integers
     */
    public void updateData(Integer[] data) {
        if(data == null) return;// If data is null, don't update
        columnPanel.setData(data);
        columnPanel.repaint();
    }


    /**
     * This class is responsible for drawing the columns in the window
     */
    class ColumnPanel extends JPanel {
        private Integer[] data = new Integer[0];
        private static final int PADDING = 10;
        private static final int ARC_WIDTH = 15;
        private static final int ARC_HEIGHT = 15;

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            drawColumns(g);
        }

        /**
         * Draw the columns in the window
         * @param g The graphics object
         */
        private void drawColumns(Graphics g) {

            if (data.length == 0) return;       // If there is no data, don't draw anything

            Graphics2D g2d = (Graphics2D) g;
            int panelWidth = getWidth();
            int panelHeight = getHeight();
            int columnWidth = (panelWidth - 2 * PADDING) / data.length; // Adjust column width considering padding
            int unit = panelHeight/ data.length; // Adjust unit considering panel height

            g2d.setColor(Color.BLUE); // Set the color for the columns

            for (int i = 0; i < data.length; i++) {
                int columnHeight = data[i]*unit;
                int x = PADDING + i * columnWidth; // Adjust x position considering padding
                int y = panelHeight - columnHeight - PADDING; // Adjust y position considering padding
                g2d.fillRoundRect(x, y, columnWidth - PADDING, columnHeight, ARC_WIDTH, ARC_HEIGHT); // Rounded corners
            }
        }

        public void setData(Integer[] data) {
            this.data = data;
        }
    }
}
