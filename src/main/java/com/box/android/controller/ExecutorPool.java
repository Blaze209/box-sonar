package com.box.android.controller;

import android.content.Context;
import com.box.android.common.utilities.threading.NamingThreadFactory;
import com.box.android.coreservices.modelcontroller.PriorityFutureTask;
import com.box.android.domain.identity.IExecutorPool;
import com.box.android.domain.identity.PreviewExecutor;
import com.box.android.preview.BoxPreviewExecutor;
import com.box.android.usercontext.UserContextComponent;
import com.box.android.utilities.LinkedBlockingLifoDeque;
import com.box.android.utilities.PausableThreadPoolExecutor;
import com.box.androidsdk.content.utils.BoxLogUtils;
import java.util.NoSuchElementException;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes10.dex */
public class ExecutorPool extends UserContextComponent implements IExecutorPool {
    ThreadPoolExecutor apiExecutor;
    private Context context;
    ThreadPoolExecutor fileTransferServiceExecutor;
    ThreadPoolExecutor localModelExecutor;
    private ThreadPoolExecutor mAudioRecordingCallbackExecutor;
    private ThreadPoolExecutor mDocumentProviderThumbnailExecutor;
    private ThreadPoolExecutor mNotificationExecutor;
    private ThreadPoolExecutor mOfflinePreviewExecutor;
    private ThreadPoolExecutor mOfflineStatusExecutor;
    PreviewExecutor mPreviewExecutor;
    ThreadPoolExecutor mPriorityJobManagerExecutor;
    private ThreadPoolExecutor mSyncExecutor;
    private PausableThreadPoolExecutor mThumbnailsExecutor;
    private final int apiPoolSize = 3;
    private final int localModelPoolSize = 20;
    private final int jobPoolSize = 2;
    private final AtomicBoolean isShuttingDown = new AtomicBoolean();

    public ExecutorPool(Context context) {
        this.context = context.getApplicationContext();
        constructExecutors(context);
    }

    private void constructExecutors(Context context) {
        this.apiExecutor = new PriorityThreadPoolExecutor(3, 3, 3600L, TimeUnit.SECONDS, new PriorityBlockingQueue(11, new PriorityFutureTask.PriorityFutureTaskComparator()), new NamingThreadFactory("apiExecutor"));
        this.localModelExecutor = new ThreadPoolExecutor(20, 20, 3600L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new NamingThreadFactory("localModelExecutor"));
        this.fileTransferServiceExecutor = new ThreadPoolExecutor(2, 2, 600L, TimeUnit.SECONDS, new LinkedBlockingQueue(10000), new NamingThreadFactory("fileTransferServiceExecutor"));
        this.mPriorityJobManagerExecutor = new ThreadPoolExecutor(2, 2, 600L, TimeUnit.SECONDS, new LinkedBlockingQueue(10000), new NamingThreadFactory("JobManagerExecutor"));
        this.mPreviewExecutor = new BoxPreviewExecutor(context, 3, 3, 10L, TimeUnit.MINUTES, new LinkedBlockingDeque<Runnable>() { // from class: com.box.android.controller.ExecutorPool.1
            @Override // java.util.concurrent.LinkedBlockingDeque, java.util.Queue, java.util.concurrent.BlockingDeque, java.util.concurrent.BlockingQueue, java.util.Deque
            public boolean offer(Runnable runnable) {
                return super.offerFirst(runnable);
            }
        });
        this.mSyncExecutor = new ThreadPoolExecutor(1, 1, 3600L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new NamingThreadFactory("mSyncExecutor"));
        this.mDocumentProviderThumbnailExecutor = new ThreadPoolExecutor(1, 1, 600L, TimeUnit.SECONDS, new LinkedBlockingLifoDeque(), new NamingThreadFactory("mDocumentProviderThumbnailExecutor"));
        this.mOfflineStatusExecutor = new ThreadPoolExecutor(1, 1, 3600L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new NamingThreadFactory("mOfflineStatusExecutor"));
        this.mAudioRecordingCallbackExecutor = new ThreadPoolExecutor(1, 1, 3600L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new NamingThreadFactory("mAudioRecordingCallbackExecutor"));
        this.mOfflinePreviewExecutor = new ThreadPoolExecutor(1, 1, 3600L, TimeUnit.SECONDS, new PriorityBlockingQueue(), new NamingThreadFactory("mOfflinePreviewExecutor"));
        this.mThumbnailsExecutor = new PausableThreadPoolExecutor(3, 5, 3600L, TimeUnit.SECONDS, new LinkedBlockingLifoDeque(40), new RejectedExecutionHandler() { // from class: com.box.android.controller.ExecutorPool.2
            @Override // java.util.concurrent.RejectedExecutionHandler
            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                try {
                    ((LinkedBlockingLifoDeque) threadPoolExecutor.getQueue()).removeLast();
                    threadPoolExecutor.submit(runnable);
                } catch (NoSuchElementException unused) {
                }
            }
        });
        this.mNotificationExecutor = new ThreadPoolExecutor(1, 1, 3600L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new NamingThreadFactory("mNotificationExecutor"));
    }

    @Override // com.box.android.usercontext.UserContextComponent, com.box.android.domain.identity.IUserContextComponent
    public void onSoftDestroy() {
        guaranteedShutDownAndRestart();
        super.onSoftDestroy();
    }

    @Override // com.box.android.usercontext.UserContextComponent, com.box.android.domain.identity.IUserContextComponent
    public void onHardDestroy() {
        guaranteedShutDownAndRestart();
        super.onHardDestroy();
    }

    private void guaranteedShutDownAndRestart() {
        if (this.isShuttingDown.get()) {
            return;
        }
        this.isShuttingDown.set(true);
        ThreadPoolExecutor[] threadPoolExecutorArr = {this.apiExecutor, this.localModelExecutor, this.mSyncExecutor, this.mOfflineStatusExecutor, this.mOfflinePreviewExecutor, this.fileTransferServiceExecutor, this.mPriorityJobManagerExecutor, this.mDocumentProviderThumbnailExecutor, this.mThumbnailsExecutor, this.mPreviewExecutor};
        for (int i = 0; i < 10; i++) {
            threadPoolExecutorArr[i].shutdownNow();
        }
        boolean z = false;
        while (!z) {
            int i2 = 0;
            while (i2 < 10) {
                if (!threadPoolExecutorArr[i2].isTerminated()) {
                    try {
                        Thread.sleep(50L);
                        break;
                    } catch (InterruptedException e) {
                        BoxLogUtils.logException(e);
                        Thread.currentThread().interrupt();
                        break;
                    }
                }
                i2++;
                z = true;
            }
        }
        constructExecutors(this.context);
        this.isShuttingDown.set(false);
    }

    @Override // com.box.android.domain.identity.IExecutorPool
    public ThreadPoolExecutor getApiExecutor() {
        return this.apiExecutor;
    }

    @Override // com.box.android.domain.identity.IExecutorPool
    public ThreadPoolExecutor getLocalModelExecutor() {
        return this.localModelExecutor;
    }

    @Override // com.box.android.domain.identity.IExecutorPool
    public ThreadPoolExecutor getFileTransferServiceExecutor() {
        return this.fileTransferServiceExecutor;
    }

    @Override // com.box.android.domain.identity.IExecutorPool
    public ThreadPoolExecutor getPriorityJobManagerExecutor() {
        return this.mPriorityJobManagerExecutor;
    }

    @Override // com.box.android.domain.identity.IExecutorPool
    public ThreadPoolExecutor getDocumentProviderThumbnailExecutor() {
        return this.mDocumentProviderThumbnailExecutor;
    }

    @Override // com.box.android.domain.identity.IExecutorPool
    public ThreadPoolExecutor getSyncExecutor() {
        return this.mSyncExecutor;
    }

    @Override // com.box.android.domain.identity.IExecutorPool
    public ThreadPoolExecutor getOfflinePreviewExecutor() {
        return this.mOfflinePreviewExecutor;
    }

    @Override // com.box.android.domain.identity.IExecutorPool
    public PreviewExecutor getPreviewExecutor() {
        return this.mPreviewExecutor;
    }

    @Override // com.box.android.domain.identity.IExecutorPool
    public PausableThreadPoolExecutor getThumbnailsExecutor() {
        return this.mThumbnailsExecutor;
    }

    @Override // com.box.android.domain.identity.IExecutorPool
    public ThreadPoolExecutor getAudioRecordingCallbackExecutor() {
        return this.mAudioRecordingCallbackExecutor;
    }

    @Override // com.box.android.domain.identity.IExecutorPool
    public ThreadPoolExecutor getOfflineStatusExecutor() {
        return this.mOfflineStatusExecutor;
    }

    @Override // com.box.android.domain.identity.IExecutorPool
    public ThreadPoolExecutor getNotificationExecutor() {
        return this.mNotificationExecutor;
    }
}
