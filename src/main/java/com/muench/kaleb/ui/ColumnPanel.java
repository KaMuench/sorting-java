package com.muench.kaleb.ui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * This class is responsible for drawing the columns in the window
 */
public class ColumnPanel extends JPanel {
    private static final int PADDING = 10;
    private static final int ARC_WIDTH = 15;
    private static final int ARC_HEIGHT = 15;
    private static final double ANIMATION_SPEED = 0.1f;

    private int position = 0;
    private final ArrayList<Integer[]> dataList = new ArrayList<>();
    private Integer[] nextData;
    private Integer[] lastData;
    private int[] lastNextDataMapping;
    private double process = 0.f;
    private boolean isSorted = false;
    private Timer guiTimer;

    public ColumnPanel() {
        guiTimer = new Timer(50, e -> {
            updateGUI();
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(nextData == null) return;
        drawColumns(g);
    }

    /**
     * Draw the columns in the window
     * @param g The graphics object
     */
    private void drawColumns(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        int panelWidth = getWidth();
        int panelHeight = getHeight();
        int columnWidth = (panelWidth - 2 * PADDING) / lastData.length; // Adjust column width considering padding
        int unit = (panelHeight-20)/ lastData.length; // Adjust unit considering panel height



        for (int i = 0; i < lastData.length; i++) {
            int columnHeight = lastData[i]*unit;
            int x = PADDING + (interpolate(i * columnWidth, lastNextDataMapping[i] * columnWidth, process)); // Adjust x position considering padding
            int y = panelHeight - columnHeight - PADDING; // Adjust y position considering padding

            // Draw shadow
            g2d.setColor(Color.GRAY); // Shadow color
            g2d.fillRoundRect(x + 3, y + 3, columnWidth - PADDING, columnHeight, ARC_WIDTH, ARC_HEIGHT); // Shadow offset


            g2d.setColor(Color.GREEN); // Set the color for the columns
            g2d.fillRoundRect(x, y, columnWidth - PADDING, columnHeight, ARC_WIDTH, ARC_HEIGHT); // Rounded corners
        }
        process += ANIMATION_SPEED;
        if(process > 1.001f) {
            position++;
            process = 0f;
        }
    }

    public void updateGUI() {

        if (dataList.size() == position) {
            if (isSorted) guiTimer.stop();      // If the data is sorted and all data in the dataList was displayed, stop the timer
            return;                        // If there is no data, don't draw anything
        }


        if(process == 0f) {
            nextData = dataList.get(position);
            lastNextDataMapping = new int[dataList.get(position).length];
            System.out.printf("%-20s: %-70s%n", "Next", Arrays.toString( nextData));


            if (position != 0) lastData = dataList.get(position - 1);
            else lastData = nextData;
            for (int i = 0, index = 0; i < lastData.length; i++) {
                for (int j = 0; j < nextData.length; j++) {
                    if (lastData[i].equals(nextData[j])) {
                        lastNextDataMapping[index] = j;
                        index++;
                        break;
                    }
                }
            }
            System.out.printf("%-20s: %-70s%n", "Last", Arrays.toString( lastData));
            System.out.printf("%-20s: %-70s%n%n", "Position", Arrays.toString( lastNextDataMapping));
        }

        repaint();
    }

    public void setData(Integer[] data) {
        this.dataList.add(data);
    }

    public static int interpolate(int startPosition, int endPosition, double process) {
        return (int) (startPosition + (endPosition -startPosition) * process);
    }

    public void startTimer() {
        guiTimer.start();
    }

    public void stopTimer() {
        guiTimer.stop();
    }

    public void isSorted(boolean isSorted) {
        this.isSorted = isSorted;
    }
}