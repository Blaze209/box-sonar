package com.microsoft.identity.common.java.util.ported;

import com.microsoft.identity.common.java.logging.Logger;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes14.dex */
public enum LocalBroadcaster {
    INSTANCE;

    private static final String TAG = "LocalBroadcaster";
    private static ExecutorService sBroadcastExecutor = Executors.newSingleThreadExecutor();
    final ConcurrentHashMap<String, IReceiverCallback> mReceivers = new ConcurrentHashMap<>();

    public interface IReceiverCallback {
        void onReceive(PropertyBag propertyBag);
    }

    LocalBroadcaster() {
    }

    public void registerCallback(String str, IReceiverCallback iReceiverCallback) {
        if (str == null) {
            throw new NullPointerException("alias is marked non-null but is null");
        }
        if (iReceiverCallback == null) {
            throw new NullPointerException("callback is marked non-null but is null");
        }
        if (this.mReceivers.containsKey(str)) {
            Logger.warn(TAG + ":registerCallback", "The alias: " + str + " has already been registered. It will be overwritten");
        }
        Logger.info(TAG + ":registerCallback", "Registering alias: " + str);
        this.mReceivers.put(str, iReceiverCallback);
    }

    public void unregisterCallback(String str) {
        if (str == null) {
            throw new NullPointerException("alias is marked non-null but is null");
        }
        Logger.info(TAG + ":unregisterCallback", "Removing alias: " + str);
        this.mReceivers.remove(str);
    }

    public boolean hasReceivers(String str) {
        if (str == null) {
            throw new NullPointerException("alias is marked non-null but is null");
        }
        return this.mReceivers.containsKey(str);
    }

    public void broadcast(final String str, final PropertyBag propertyBag) {
        if (str == null) {
            throw new NullPointerException("alias is marked non-null but is null");
        }
        if (propertyBag == null) {
            throw new NullPointerException("propertyBag is marked non-null but is null");
        }
        sBroadcastExecutor.execute(new Runnable() { // from class: com.microsoft.identity.common.java.util.ported.LocalBroadcaster.1
            @Override // java.lang.Runnable
            public void run() {
                IReceiverCallback iReceiverCallback = LocalBroadcaster.this.mReceivers.get(str);
                if (iReceiverCallback != null) {
                    Logger.info(LocalBroadcaster.TAG + ":broadcast", "broadcasting to alias: " + str);
                    iReceiverCallback.onReceive(propertyBag);
                } else {
                    Logger.info(LocalBroadcaster.TAG + ":broadcast", "No callback is registered with alias: " + str + ". Do nothing.");
                }
            }
        });
    }

    public void clearReceivers() {
        this.mReceivers.clear();
    }

    public static void resetBroadcast() {
        shutdownAndAwaitTerminationForBroadcasterService();
        sBroadcastExecutor = Executors.newSingleThreadExecutor();
    }

    private static void shutdownAndAwaitTerminationForBroadcasterService() {
        sBroadcastExecutor.shutdown();
        try {
            if (sBroadcastExecutor.awaitTermination(20L, TimeUnit.SECONDS)) {
                return;
            }
            sBroadcastExecutor.shutdownNow();
            if (sBroadcastExecutor.awaitTermination(5L, TimeUnit.SECONDS)) {
                return;
            }
            Logger.info(TAG + ":shutdownAndAwaitTerminationForBroadcasterService", "broadcastExecutor did not terminate");
        } catch (InterruptedException unused) {
            sBroadcastExecutor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
