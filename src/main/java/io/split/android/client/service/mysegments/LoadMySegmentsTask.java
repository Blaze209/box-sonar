package io.split.android.client.service.mysegments;

import io.split.android.client.service.executor.SplitTask;
import io.split.android.client.service.executor.SplitTaskExecutionInfo;
import io.split.android.client.service.executor.SplitTaskType;
import io.split.android.client.storage.mysegments.MySegmentsStorage;
import io.split.android.client.utils.Utils;

/* JADX INFO: loaded from: classes4.dex */
public class LoadMySegmentsTask implements SplitTask {
    private final MySegmentsStorage mMyLargeSegmentsStorage;
    private final MySegmentsStorage mMySegmentsStorage;
    private final SplitTaskType mSplitTaskType;

    public LoadMySegmentsTask(MySegmentsStorage mySegmentsStorage, MySegmentsStorage myLargeSegmentsStorage, LoadMySegmentsTaskConfig config) {
        this.mMySegmentsStorage = (MySegmentsStorage) Utils.checkNotNull(mySegmentsStorage);
        this.mMyLargeSegmentsStorage = (MySegmentsStorage) Utils.checkNotNull(myLargeSegmentsStorage);
        this.mSplitTaskType = config.getTaskType();
    }

    @Override // io.split.android.client.service.executor.SplitTask
    public SplitTaskExecutionInfo execute() {
        this.mMySegmentsStorage.loadLocal();
        this.mMyLargeSegmentsStorage.loadLocal();
        return SplitTaskExecutionInfo.success(this.mSplitTaskType);
    }
}
