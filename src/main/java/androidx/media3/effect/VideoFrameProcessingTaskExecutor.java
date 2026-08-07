package androidx.media3.effect;

import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.util.GlUtil;
import androidx.media3.common.util.Util;
import com.google.common.base.Preconditions;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes8.dex */
final class VideoFrameProcessingTaskExecutor {
    private static final long EXECUTOR_SERVICE_TIMEOUT_MS;
    private final ErrorListener errorListener;
    private boolean shouldCancelTasks;
    private final boolean shouldShutdownExecutorService;
    private final ExecutorService singleThreadExecutorService;
    private final Future<Thread> threadFuture;
    private final Object lock = new Object();
    private final Queue<Task> highPriorityTasks = new ArrayDeque();

    interface ErrorListener {
        void onError(VideoFrameProcessingException videoFrameProcessingException);
    }

    interface Task {
        void run() throws VideoFrameProcessingException, GlUtil.GlException;
    }

    static /* synthetic */ void lambda$submitWithHighPriority$1() throws VideoFrameProcessingException, GlUtil.GlException {
    }

    static {
        EXECUTOR_SERVICE_TIMEOUT_MS = Util.isRunningOnEmulator() ? 5000L : 500L;
    }

    public VideoFrameProcessingTaskExecutor(ExecutorService executorService, boolean z, ErrorListener errorListener) {
        this.singleThreadExecutorService = executorService;
        this.threadFuture = executorService.submit(new Callable() { // from class: androidx.media3.effect.VideoFrameProcessingTaskExecutor$$ExternalSyntheticLambda3
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return Thread.currentThread();
            }
        });
        this.shouldShutdownExecutorService = z;
        this.errorListener = errorListener;
    }

    public void submit(Task task, boolean z) {
        synchronized (this.lock) {
            if (this.shouldCancelTasks && z) {
                return;
            }
            try {
                wrapTaskAndSubmitToExecutorService(task, z);
                e = null;
            } catch (RejectedExecutionException e) {
                e = e;
            }
            if (e != null) {
                handleException(e);
            }
        }
    }

    public void submit(Task task) {
        submit(task, true);
    }

    public void invoke(final Task task) throws InterruptedException {
        if (isRunningOnVideoFrameProcessingThread()) {
            try {
                task.run();
                return;
            } catch (Exception e) {
                handleException(e);
                return;
            }
        }
        try {
            this.singleThreadExecutorService.submit(new Runnable() { // from class: androidx.media3.effect.VideoFrameProcessingTaskExecutor$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m10441x1decd05c(task);
                }
            }).get(EXECUTOR_SERVICE_TIMEOUT_MS, TimeUnit.MILLISECONDS);
        } catch (RuntimeException | ExecutionException | TimeoutException e2) {
            handleException(e2);
        }
    }

    /* JADX INFO: renamed from: lambda$invoke$0$androidx-media3-effect-VideoFrameProcessingTaskExecutor, reason: not valid java name */
    /* synthetic */ void m10441x1decd05c(Task task) {
        try {
            task.run();
        } catch (Exception e) {
            handleException(e);
        }
    }

    public void submitWithHighPriority(Task task) {
        synchronized (this.lock) {
            if (this.shouldCancelTasks) {
                return;
            }
            this.highPriorityTasks.add(task);
            submit(new Task() { // from class: androidx.media3.effect.VideoFrameProcessingTaskExecutor$$ExternalSyntheticLambda1
                @Override // androidx.media3.effect.VideoFrameProcessingTaskExecutor.Task
                public final void run() throws VideoFrameProcessingException, GlUtil.GlException {
                    VideoFrameProcessingTaskExecutor.lambda$submitWithHighPriority$1();
                }
            });
        }
    }

    public void flush() throws InterruptedException {
        synchronized (this.lock) {
            this.shouldCancelTasks = true;
            this.highPriorityTasks.clear();
        }
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        wrapTaskAndSubmitToExecutorService(new Task() { // from class: androidx.media3.effect.VideoFrameProcessingTaskExecutor$$ExternalSyntheticLambda4
            @Override // androidx.media3.effect.VideoFrameProcessingTaskExecutor.Task
            public final void run() throws VideoFrameProcessingException, GlUtil.GlException {
                this.f$0.m10440xc4cabbd0(countDownLatch);
            }
        }, false);
        countDownLatch.await();
    }

    /* JADX INFO: renamed from: lambda$flush$2$androidx-media3-effect-VideoFrameProcessingTaskExecutor, reason: not valid java name */
    /* synthetic */ void m10440xc4cabbd0(CountDownLatch countDownLatch) throws VideoFrameProcessingException, GlUtil.GlException {
        synchronized (this.lock) {
            this.shouldCancelTasks = false;
        }
        countDownLatch.countDown();
    }

    public void release(Task task) throws InterruptedException {
        Preconditions.checkState(!isRunningOnVideoFrameProcessingThread());
        synchronized (this.lock) {
            this.shouldCancelTasks = true;
            this.highPriorityTasks.clear();
        }
        wrapTaskAndSubmitToExecutorService(task, false);
        if (this.shouldShutdownExecutorService) {
            this.singleThreadExecutorService.shutdown();
            if (this.singleThreadExecutorService.awaitTermination(EXECUTOR_SERVICE_TIMEOUT_MS, TimeUnit.MILLISECONDS)) {
                return;
            }
            this.errorListener.onError(new VideoFrameProcessingException("Release timed out. OpenGL resources may not be cleaned up properly."));
        }
    }

    public void verifyVideoFrameProcessingThread() {
        try {
            Preconditions.checkState(isRunningOnVideoFrameProcessingThread());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            handleException(e);
        }
    }

    private boolean isRunningOnVideoFrameProcessingThread() throws InterruptedException {
        try {
            return Thread.currentThread() == this.threadFuture.get(EXECUTOR_SERVICE_TIMEOUT_MS, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            throw e;
        } catch (Exception e2) {
            handleException(e2);
            return false;
        }
    }

    private Future<?> wrapTaskAndSubmitToExecutorService(final Task task, final boolean z) {
        return this.singleThreadExecutorService.submit(new Runnable() { // from class: androidx.media3.effect.VideoFrameProcessingTaskExecutor$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m10442xa211ca4e(z, task);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$wrapTaskAndSubmitToExecutorService$3$androidx-media3-effect-VideoFrameProcessingTaskExecutor, reason: not valid java name */
    /* synthetic */ void m10442xa211ca4e(boolean z, Task task) {
        Task taskPoll;
        try {
            synchronized (this.lock) {
                if (this.shouldCancelTasks && z) {
                    return;
                }
                while (true) {
                    synchronized (this.lock) {
                        taskPoll = this.highPriorityTasks.poll();
                    }
                    if (taskPoll != null) {
                        taskPoll.run();
                    } else {
                        task.run();
                        return;
                    }
                }
            }
        } catch (Exception e) {
            handleException(e);
        }
    }

    private void handleException(Exception exc) {
        synchronized (this.lock) {
            if (this.shouldCancelTasks) {
                return;
            }
            this.shouldCancelTasks = true;
            this.errorListener.onError(VideoFrameProcessingException.from(exc));
        }
    }
}
