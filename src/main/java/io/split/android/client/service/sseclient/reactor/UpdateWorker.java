package io.split.android.client.service.sseclient.reactor;

import io.split.android.client.utils.logger.Logger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes4.dex */
public abstract class UpdateWorker {
    private static final int SHUTDOWN_WAIT_TIME = 30;
    private final ExecutorService mExecutorService = Executors.newSingleThreadExecutor();

    protected abstract void onWaitForNotificationLoop() throws InterruptedException;

    public void start() {
        waitForNotifications();
    }

    public void stop() {
        if (this.mExecutorService.isShutdown()) {
            return;
        }
        try {
            this.mExecutorService.shutdownNow();
            if (this.mExecutorService.awaitTermination(30L, TimeUnit.SECONDS)) {
                return;
            }
            Logger.e("Update worker did not terminate");
        } catch (InterruptedException unused) {
            this.mExecutorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }

    private void waitForNotifications() {
        if (this.mExecutorService.isShutdown()) {
            return;
        }
        this.mExecutorService.execute(new Runnable() { // from class: io.split.android.client.service.sseclient.reactor.UpdateWorker.1
            @Override // java.lang.Runnable
            public void run() {
                while (true) {
                    try {
                        UpdateWorker.this.onWaitForNotificationLoop();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
            }
        });
    }
}
