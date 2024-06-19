package com.muench.kaleb.mergesort;

/**
 * Class to wrap data to be sorted. Manly to provide synchronization for data accessing, since the data is accessed by EDT and main thread.
 * @param <T> comparable type for the data
 */
public class  Data <T extends Comparable> {
    private T[] data;

    // Flag to indicate if the data has been updated and hence can be read
    private boolean isUpdated = false;


    public T[] getUpdate() {
        synchronized (this) {
            if(isUpdated) {
                isUpdated = false;
                return data.clone();
            } else return null;
        }
    }

    /**
     * Basically a getter for the data
     * @return a copy of the data held by this object
     */
    public T[] cloneData() {
        synchronized (this) {
           if(data != null) return data.clone();
           else return null;
        }
    }

    /**
     * Update the data held by this object
     * @param data the new data
     */
    public void updateData(T[] data) {
        synchronized (this) {
            if(data == null) return;
            isUpdated = true;
            this.data = data.clone();
        }
    }
}
