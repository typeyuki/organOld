package com.organOld.service.service;

/**
 * The full updater is to update the data with the full strategy.
 */
public interface FullUpdater extends Updater {

    /**
     * Gets the expiration of the updated data.
     *
     * @return the expiration to the updated data.
     */
    long getExpiredTime();

    /**
     * Sets the expiration of the updated data. The value must be grater than zero, otherwise an runtime exception will be thrown.
     *
     * @return the expiration to the updated data.
     */
    void setExpiredTime(long expiredTime);

    /**
     * Returns the maximum update progress, which is to indicate how many tasks this round of full update need to do,
     * or what is the terminal condition. Usually, if the {@link #getCurrent()} is equal or greater than {@link #getMax()}.
     *
     * @return the maximum update progress.
     */
    long getMax();

    /**
     * Sets the maximum update progress. The value must be grater than zero, otherwise an runtime exception will be thrown.
     *
     * @param max the maximum update progress.
     */
    void setMax(long max);

    /**
     * Returns the current update progress, which is to indicate how many tasks have been updated successfully.
     *
     * @return the current update progress.
     */
    long getCurrent();

    /**
     * Sets a new update progress. You don't need to care this value is equal or greater than {@link #getMax()}.
     *
     * @param current the new update progress.
     */
    void setCurrent(long current);
}
