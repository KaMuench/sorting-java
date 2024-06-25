package com.muench.kaleb;

import java.util.*;

/**
 * Class to wrap data to be sorted. Manly to provide synchronization for data accessing, since the data is accessed by EDT and main thread.
 * @param <T> comparable type for the data
 */
public class  Data <T extends Comparable<T>> {

    private final Queue<T[]> data = new ArrayDeque<>();


    public T[] getNewData() {
        synchronized (this) {
            if(!this.data.isEmpty()) return this.data.poll();
            else return null;
        }
    }

    /**
     * Basically a getter for the data
     * @return a copy of the data held by this object
     */
    public T[] cloneData() {
        synchronized (this) {
           if(!this.data.isEmpty()) return this.data.peek().clone();
           else return null;
        }
    }

    /**
     * Update the data held by this object
     * @param data the new data
     */
    public void insertData(T[] data) {
        synchronized (this) {
            Objects.requireNonNull(data, "Parameter cannot be null");
            this.data.add(data.clone());
        }
    }

    public boolean newDataAvailable() {
        synchronized (this) {
            return !this.data.isEmpty();
        }
    }
}
