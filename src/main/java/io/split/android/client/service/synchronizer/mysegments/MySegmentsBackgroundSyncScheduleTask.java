package io.split.android.client.service.synchronizer.mysegments;

import io.split.android.client.service.executor.SplitTask;
import io.split.android.client.service.executor.SplitTaskExecutionInfo;
import io.split.android.client.service.executor.SplitTaskType;
import io.split.android.client.utils.Utils;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public class MySegmentsBackgroundSyncScheduleTask implements SplitTask {
    private final Set<String> mKeySet;
    private final MySegmentsWorkManagerWrapper mWorkManagerWrapper;

    public MySegmentsBackgroundSyncScheduleTask(MySegmentsWorkManagerWrapper workManagerWrapper, Set<String> keySet) {
        this.mWorkManagerWrapper = (MySegmentsWorkManagerWrapper) Utils.checkNotNull(workManagerWrapper);
        this.mKeySet = (Set) Utils.checkNotNull(keySet);
    }

    @Override // io.split.android.client.service.executor.SplitTask
    public SplitTaskExecutionInfo execute() {
        this.mWorkManagerWrapper.scheduleMySegmentsWork(this.mKeySet);
        return SplitTaskExecutionInfo.success(SplitTaskType.GENERIC_TASK);
    }
}
