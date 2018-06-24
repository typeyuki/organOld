package com.organOld.service.thread;

/**
 * This interface is to indicate the basic method to update data.
 * Two types of updaters are full update and incremental update.
 */
public interface Updater {

    /**
     * Checks if the data can be updated now.
     * For full update, you should check if the data is first update, the data is expiration and the last update is finished.
     *
     * @return {@code true} if the data can be updated currently, otherwise {@code false}.
     */
    boolean needToUpdate();

    /**
     * Update the data for both full update and incremental update.
     * The events ({@link BeforeUpdateEvent} and {@link AfterUpdateEvent})will occur in the process of updating the data.
     */
    void update();

    /**
     * The event will occur when the data is beginning to update.
     */
    interface BeforeUpdateEvent {

        /**
         * The event occurs when the data is beginning to update.
         *
         * @param eventArgs the event args.
         */
        void before(Object eventArgs);
    }

    /**
     * The event will occur when the data has been updated.
     */
    interface AfterUpdateEvent {

        /**
         * The event occurs when the data has been updated.
         *
         * @param eventArgs the event args.
         */
        void after(Object eventArgs);
    }
}
