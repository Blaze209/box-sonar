package io.split.android.client.service.splits;

import io.split.android.client.service.executor.SplitTask;
import io.split.android.client.service.executor.SplitTaskExecutionInfo;
import io.split.android.client.service.executor.SplitTaskType;
import io.split.android.client.storage.splits.SplitsStorage;
import io.split.android.client.utils.Utils;
import io.split.android.client.utils.logger.Logger;

/* JADX INFO: loaded from: classes4.dex */
public class LoadSplitsTask implements SplitTask {
    private final String mFlagsSpecFromConfig;
    private final String mSplitsFilterQueryStringFromConfig;
    private final SplitsStorage mSplitsStorage;

    public LoadSplitsTask(SplitsStorage splitsStorage, String splitsFilterQueryStringFromConfig, String flagsSpecFromConfig) {
        this.mSplitsStorage = (SplitsStorage) Utils.checkNotNull(splitsStorage);
        this.mSplitsFilterQueryStringFromConfig = splitsFilterQueryStringFromConfig == null ? "" : splitsFilterQueryStringFromConfig;
        this.mFlagsSpecFromConfig = flagsSpecFromConfig == null ? "" : flagsSpecFromConfig;
    }

    @Override // io.split.android.client.service.executor.SplitTask
    public SplitTaskExecutionInfo execute() {
        System.currentTimeMillis();
        this.mSplitsStorage.loadLocal();
        String splitsFilterQueryString = this.mSplitsStorage.getSplitsFilterQueryString();
        String flagsSpec = this.mSplitsStorage.getFlagsSpec();
        if (splitsFilterQueryString == null) {
            splitsFilterQueryString = "";
        }
        if (flagsSpec == null) {
            flagsSpec = "";
        }
        boolean z = this.mSplitsStorage.getTill() > -1;
        boolean zEquals = this.mSplitsFilterQueryStringFromConfig.equals(splitsFilterQueryString);
        boolean zEquals2 = this.mFlagsSpecFromConfig.equals(flagsSpec);
        if (z && zEquals && zEquals2) {
            return SplitTaskExecutionInfo.success(SplitTaskType.LOAD_LOCAL_SPLITS);
        }
        boolean z2 = !zEquals;
        boolean z3 = !zEquals2;
        if (!zEquals || !zEquals2) {
            this.mSplitsStorage.clear();
            logClearingMessage(z2, z3);
            if (!zEquals) {
                this.mSplitsStorage.updateSplitsFilterQueryString(this.mSplitsFilterQueryStringFromConfig);
            }
            if (!zEquals2) {
                this.mSplitsStorage.updateFlagsSpec(this.mFlagsSpecFromConfig);
            }
        }
        return SplitTaskExecutionInfo.error(SplitTaskType.LOAD_LOCAL_SPLITS);
    }

    private static void logClearingMessage(boolean filterHasChanged, boolean flagsSpecHasChanged) {
        if (filterHasChanged && flagsSpecHasChanged) {
            Logger.v("Cleared storage due to filter & spec change");
        } else if (filterHasChanged) {
            Logger.v("Cleared storage due to filter change");
        } else if (flagsSpecHasChanged) {
            Logger.v("Cleared storage due to spec change");
        }
    }
}
