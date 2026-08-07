package io.split.android.client.service.mysegments;

import io.split.android.client.service.executor.SplitTask;
import io.split.android.client.service.executor.SplitTaskExecutionInfo;
import io.split.android.client.service.executor.SplitTaskType;
import io.split.android.client.utils.Utils;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public class MySegmentsBulkSyncTask implements SplitTask {
    private final Set<MySegmentsSyncTask> mMySegmentsSyncTasks;

    public MySegmentsBulkSyncTask(Set<MySegmentsSyncTask> mySegmentsSyncTasks) {
        this.mMySegmentsSyncTasks = (Set) Utils.checkNotNull(mySegmentsSyncTasks);
    }

    @Override // io.split.android.client.service.executor.SplitTask
    public SplitTaskExecutionInfo execute() {
        Iterator<MySegmentsSyncTask> it = this.mMySegmentsSyncTasks.iterator();
        while (it.hasNext()) {
            it.next().execute();
        }
        return SplitTaskExecutionInfo.success(SplitTaskType.GENERIC_TASK);
    }
}
