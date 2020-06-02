package com.lamonjush.libui.util;

import androidx.annotation.WorkerThread;

import java.net.InetAddress;

public class TaskUtil {

    /**
     * check whatever internet is available
     * should not be called from mainThread or else exception will be thrown
     * @return internet availability status
     */
    @WorkerThread
    public static synchronized boolean isInternetAvailable() {
        try {
            InetAddress ipAddr = InetAddress.getByName("google.com");
            return !ipAddr.equals(""); //FIXME: replace "" with something meaningful

        } catch (Exception e) {
            return false;
        }
    }
}