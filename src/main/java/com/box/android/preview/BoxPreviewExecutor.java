package com.box.android.preview;

import android.content.Context;
import android.content.Intent;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.box.android.domain.identity.PreviewExecutor;
import java.util.Collection;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes12.dex */
public class BoxPreviewExecutor extends PreviewExecutor {
    public static final String ACTION_ENDING_PREVIEW_TASK = "com.box.android.preview.ending_task";
    public static final String EXTRA_POSITION = "extraPosition";
    final Context mContext;
    final ConcurrentHashMap<Integer, ConcurrentLinkedQueue<FutureTask<?>>> mCurrentTasks;
    final Queue<PreviewFutureTask> mQueue;

    public BoxPreviewExecutor(Context context, int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue) {
        super(i, i2, j, timeUnit, blockingQueue);
        this.mCurrentTasks = new ConcurrentHashMap<>();
        this.mContext = context;
        this.mQueue = new LinkedBlockingQueue();
    }

    private void execute(PreviewFutureTask previewFutureTask) {
        this.mCurrentTasks.putIfAbsent(Integer.valueOf(previewFutureTask.getPosition()), new ConcurrentLinkedQueue<>());
        this.mCurrentTasks.get(Integer.valueOf(previewFutureTask.getPosition())).add(previewFutureTask.getTask());
        super.execute((Runnable) previewFutureTask);
    }

    @Override // com.box.android.domain.identity.PreviewExecutor
    public void execute(FutureTask futureTask, int i, String str) {
        execute(new PreviewFutureTask(futureTask, i, str));
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected void afterExecute(Runnable runnable, Throwable th) {
        super.afterExecute(runnable, th);
        if (runnable instanceof PreviewFutureTask) {
            PreviewFutureTask previewFutureTask = (PreviewFutureTask) runnable;
            PreviewMessage previewMessage = new PreviewMessage(this.mQueue, previewFutureTask.getPosition());
            this.mQueue.add(previewFutureTask);
            LocalBroadcastManager.getInstance(this.mContext).sendBroadcast(previewMessage);
        }
    }

    @Override // com.box.android.domain.identity.PreviewExecutor
    public Collection<FutureTask<?>> getTasks(int i) {
        return this.mCurrentTasks.get(Integer.valueOf(i));
    }

    public static class PreviewFutureTask implements Runnable {
        final String mBoxItemId;
        final int mPreviewPosition;
        final FutureTask mRunnable;

        public PreviewFutureTask(FutureTask futureTask, int i, String str) {
            this.mPreviewPosition = i;
            this.mRunnable = futureTask;
            this.mBoxItemId = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.mRunnable.run();
        }

        public String getBoxItemId() {
            return this.mBoxItemId;
        }

        public int getPosition() {
            return this.mPreviewPosition;
        }

        public FutureTask getTask() {
            return this.mRunnable;
        }
    }

    public static class PreviewMessage extends Intent {
        private final Queue<PreviewFutureTask> mQueue;

        public PreviewMessage(Queue<PreviewFutureTask> queue, int i) {
            this.mQueue = queue;
            setAction(BoxPreviewExecutor.ACTION_ENDING_PREVIEW_TASK);
            putExtra(BoxPreviewExecutor.EXTRA_POSITION, i);
        }

        public Queue<PreviewFutureTask> getPreviewQueue() {
            return this.mQueue;
        }
    }
}
