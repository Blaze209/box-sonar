package io.split.android.client.service.impressions;

import io.split.android.client.service.executor.SplitTask;
import io.split.android.client.service.executor.SplitTaskExecutionInfo;
import io.split.android.client.service.executor.SplitTaskType;
import io.split.android.client.storage.impressions.PersistentImpressionsCountStorage;
import io.split.android.client.utils.Utils;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class SaveImpressionsCountTask implements SplitTask {
    private final List<ImpressionsCountPerFeature> mCounts;
    private final PersistentImpressionsCountStorage mCountsStorage;

    public SaveImpressionsCountTask(PersistentImpressionsCountStorage countsStorage, List<ImpressionsCountPerFeature> counts) {
        this.mCountsStorage = (PersistentImpressionsCountStorage) Utils.checkNotNull(countsStorage);
        this.mCounts = (List) Utils.checkNotNull(counts);
    }

    @Override // io.split.android.client.service.executor.SplitTask
    public SplitTaskExecutionInfo execute() {
        this.mCountsStorage.pushMany(this.mCounts);
        return SplitTaskExecutionInfo.success(SplitTaskType.SAVE_IMPRESSIONS_COUNT);
    }
}
