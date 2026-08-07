package io.split.android.client.service.synchronizer;

import io.split.android.client.service.executor.SplitTask;
import io.split.android.client.service.executor.SplitTaskExecutionInfo;
import io.split.android.client.service.executor.SplitTaskExecutionListener;
import io.split.android.client.service.executor.SplitTaskExecutionStatus;
import io.split.android.client.service.executor.SplitTaskExecutor;
import io.split.android.client.service.executor.SplitTaskType;
import io.split.android.client.storage.common.InBytesSizable;
import io.split.android.client.storage.common.StoragePusher;
import io.split.android.client.utils.Utils;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes4.dex */
public class RecorderSyncHelperImpl<T extends InBytesSizable> implements RecorderSyncHelper<T> {
    private final int mMaxQueueSize;
    private final long mMaxQueueSizeInBytes;
    private final SplitTaskExecutor mSplitTaskExecutor;
    private final StoragePusher<T> mStorage;
    private final SplitTaskType mTaskType;
    private final AtomicInteger mPushedCount = new AtomicInteger(0);
    private final AtomicLong mTotalPushedSizeInBytes = new AtomicLong(0);
    private final Set<WeakReference<SplitTaskExecutionListener>> mTaskExecutionListener = new HashSet();

    public RecorderSyncHelperImpl(SplitTaskType taskType, StoragePusher<T> storage, int maxQueueSize, long maxQueueSizeInBytes, SplitTaskExecutor splitTaskExecutor) {
        this.mTaskType = (SplitTaskType) Utils.checkNotNull(taskType);
        this.mStorage = (StoragePusher) Utils.checkNotNull(storage);
        this.mSplitTaskExecutor = (SplitTaskExecutor) Utils.checkNotNull(splitTaskExecutor);
        this.mMaxQueueSize = maxQueueSize;
        this.mMaxQueueSizeInBytes = maxQueueSizeInBytes;
    }

    @Override // io.split.android.client.service.synchronizer.RecorderSyncHelper
    public boolean pushAndCheckIfFlushNeeded(T entity) {
        pushAsync(entity);
        int iAddAndGet = this.mPushedCount.addAndGet(1);
        long jAddAndGet = this.mTotalPushedSizeInBytes.addAndGet(entity.getSizeInBytes());
        if (iAddAndGet <= this.mMaxQueueSize && jAddAndGet < this.mMaxQueueSizeInBytes) {
            return false;
        }
        this.mPushedCount.set(0);
        this.mTotalPushedSizeInBytes.set(0L);
        return true;
    }

    @Override // io.split.android.client.service.executor.SplitTaskExecutionListener
    public void taskExecuted(SplitTaskExecutionInfo taskInfo) {
        if (this.mTaskType.equals(taskInfo.getTaskType()) && taskInfo.getStatus().equals(SplitTaskExecutionStatus.ERROR)) {
            this.mPushedCount.addAndGet(taskInfo.getIntegerValue(SplitTaskExecutionInfo.NON_SENT_RECORDS).intValue());
            this.mTotalPushedSizeInBytes.addAndGet(taskInfo.getLongValue(SplitTaskExecutionInfo.NON_SENT_BYTES).longValue());
        }
        Iterator<WeakReference<SplitTaskExecutionListener>> it = this.mTaskExecutionListener.iterator();
        while (it.hasNext()) {
            SplitTaskExecutionListener splitTaskExecutionListener = it.next().get();
            if (splitTaskExecutionListener != null) {
                splitTaskExecutionListener.taskExecuted(taskInfo);
            }
        }
    }

    @Override // io.split.android.client.service.synchronizer.RecorderSyncHelper
    public void addListener(SplitTaskExecutionListener listener) {
        this.mTaskExecutionListener.add(new WeakReference<>(listener));
    }

    @Override // io.split.android.client.service.synchronizer.RecorderSyncHelper
    public void removeListener(SplitTaskExecutionListener listener) {
        for (WeakReference<SplitTaskExecutionListener> weakReference : this.mTaskExecutionListener) {
            SplitTaskExecutionListener splitTaskExecutionListener = weakReference.get();
            if (splitTaskExecutionListener != null && splitTaskExecutionListener.equals(listener)) {
                this.mTaskExecutionListener.remove(weakReference);
                return;
            }
        }
    }

    private void pushAsync(final T entity) {
        this.mSplitTaskExecutor.submit(new SplitTask() { // from class: io.split.android.client.service.synchronizer.RecorderSyncHelperImpl.1
            @Override // io.split.android.client.service.executor.SplitTask
            public SplitTaskExecutionInfo execute() {
                RecorderSyncHelperImpl.this.mStorage.push(entity);
                return SplitTaskExecutionInfo.success(SplitTaskType.GENERIC_TASK);
            }
        }, null);
    }
}
