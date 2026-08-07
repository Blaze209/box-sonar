package io.split.android.client.service.executor;

import android.os.Handler;
import android.os.Looper;
import io.split.android.client.utils.Utils;
import io.split.android.client.utils.logger.Logger;
import io.split.android.engine.scheduler.PausableScheduledThreadPoolExecutor;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes4.dex */
public abstract class SplitBaseTaskExecutor implements SplitTaskExecutor {
    private static final int SHUTDOWN_WAIT_TIME = 15;
    private Handler mMainHandler;
    private final PausableScheduledThreadPoolExecutor mScheduler = buildScheduler();
    private final Map<String, ScheduledFuture> mScheduledTasks = new ConcurrentHashMap();

    protected abstract PausableScheduledThreadPoolExecutor buildScheduler();

    @Override // io.split.android.client.service.executor.SplitTaskExecutor
    public String schedule(SplitTask task, long initialDelayInSecs, long periodInSecs, SplitTaskExecutionListener executionListener) {
        Utils.checkNotNull(task);
        Utils.checkArgument(periodInSecs > 0);
        if (this.mScheduler.isShutdown()) {
            return null;
        }
        ScheduledFuture<?> scheduledFutureScheduleWithFixedDelay = this.mScheduler.scheduleWithFixedDelay(new TaskWrapper(task, executionListener), initialDelayInSecs, periodInSecs, TimeUnit.SECONDS);
        String string = UUID.randomUUID().toString();
        this.mScheduledTasks.put(string, scheduledFutureScheduleWithFixedDelay);
        return string;
    }

    @Override // io.split.android.client.service.executor.SplitTaskExecutor
    public String schedule(SplitTask task, long initialDelayInSecs, SplitTaskExecutionListener executionListener) {
        Utils.checkNotNull(task);
        if (this.mScheduler.isShutdown()) {
            return null;
        }
        ScheduledFuture<?> scheduledFutureSchedule = this.mScheduler.schedule(new TaskWrapper(task, executionListener), initialDelayInSecs, TimeUnit.SECONDS);
        String string = UUID.randomUUID().toString();
        this.mScheduledTasks.put(string, scheduledFutureSchedule);
        return string;
    }

    @Override // io.split.android.client.service.executor.SplitTaskExecutor
    public void submit(SplitTask task, SplitTaskExecutionListener executionListener) {
        Utils.checkNotNull(task);
        if (this.mScheduler.isShutdown()) {
            return;
        }
        this.mScheduler.submit(new TaskWrapper(task, executionListener));
    }

    @Override // io.split.android.client.service.executor.SplitTaskExecutor
    public void stopTask(String taskId) {
        if (taskId == null) {
            return;
        }
        ScheduledFuture scheduledFuture = this.mScheduledTasks.get(taskId);
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.mScheduledTasks.remove(taskId);
    }

    @Override // io.split.android.client.service.executor.SplitTaskExecutor
    public void executeSerially(List<SplitTaskBatchItem> taskQueue) {
        if (this.mScheduler.isShutdown()) {
            return;
        }
        this.mScheduler.submit(new SplitTaskBatchWrapper(taskQueue));
    }

    public void submitOnMainThread(Handler handler, final SplitTask splitTask) {
        if (this.mScheduler.isShutdown()) {
            return;
        }
        handler.post(new Runnable() { // from class: io.split.android.client.service.executor.SplitBaseTaskExecutor.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    splitTask.execute();
                } catch (Exception e) {
                    Logger.e("Error executing task on main thread: " + e.getLocalizedMessage());
                }
            }
        });
    }

    @Override // io.split.android.client.service.executor.SplitTaskExecutor
    public void submitOnMainThread(SplitTask splitTask) {
        submitOnMainThread(getMainHandler(), splitTask);
    }

    @Override // io.split.android.client.service.executor.SplitTaskExecutor
    public void pause() {
        this.mScheduler.pause();
    }

    @Override // io.split.android.client.service.executor.SplitTaskExecutor
    public void resume() {
        this.mScheduler.resume();
    }

    @Override // io.split.android.client.service.executor.SplitTaskExecutor
    public void stop() {
        if (this.mScheduler.isShutdown()) {
            return;
        }
        this.mScheduler.shutdown();
        try {
            if (this.mScheduler.awaitTermination(15L, TimeUnit.SECONDS)) {
                return;
            }
            this.mScheduler.shutdownNow();
            if (this.mScheduler.awaitTermination(15L, TimeUnit.SECONDS)) {
                return;
            }
            Logger.e("Split task executor did not terminate");
        } catch (InterruptedException unused) {
            this.mScheduler.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }

    private Handler getMainHandler() {
        if (this.mMainHandler == null) {
            this.mMainHandler = new Handler(Looper.getMainLooper());
        }
        return this.mMainHandler;
    }
}
