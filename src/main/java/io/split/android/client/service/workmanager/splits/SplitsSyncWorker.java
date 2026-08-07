package io.split.android.client.service.workmanager.splits;

import android.content.Context;
import androidx.work.WorkerParameters;
import io.split.android.client.service.rules.RuleBasedSegmentChangeProcessor;
import io.split.android.client.service.workmanager.SplitWorker;

/* JADX INFO: loaded from: classes4.dex */
public class SplitsSyncWorker extends SplitWorker {
    public SplitsSyncWorker(Context context, WorkerParameters workerParams) {
        super(context, workerParams);
        SplitsSyncWorkerParams splitsSyncWorkerParams = new SplitsSyncWorkerParams(workerParams);
        this.mSplitTask = new SplitsSyncWorkerTaskBuilder(new StorageProvider(getDatabase(), splitsSyncWorkerParams.apiKey(), splitsSyncWorkerParams.encryptionEnabled(), splitsSyncWorkerParams.shouldRecordTelemetry()), new FetcherProvider(getHttpClient(), getEndPoint()), new SplitChangeProcessorProvider().provideSplitChangeProcessor(splitsSyncWorkerParams.configuredFilterType(), splitsSyncWorkerParams.configuredFilterValues()), new RuleBasedSegmentChangeProcessor(), new SyncHelperProvider(), splitsSyncWorkerParams.flagsSpec()).getTask();
    }
}
