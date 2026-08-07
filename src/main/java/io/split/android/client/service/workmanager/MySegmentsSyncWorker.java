package io.split.android.client.service.workmanager;

import android.content.Context;
import androidx.work.WorkerParameters;
import io.split.android.client.network.HttpClient;
import io.split.android.client.service.ServiceFactory;
import io.split.android.client.service.mysegments.MySegmentsSyncTask;
import io.split.android.client.service.mysegments.MySegmentsSyncTaskConfig;
import io.split.android.client.storage.db.SplitRoomDatabase;
import io.split.android.client.storage.db.StorageFactory;
import java.net.URISyntaxException;

/* JADX INFO: loaded from: classes4.dex */
public class MySegmentsSyncWorker extends BaseSegmentsSyncWorker {
    public MySegmentsSyncWorker(Context context, WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @Override // io.split.android.client.service.workmanager.BaseSegmentsSyncWorker
    protected MySegmentsSyncTask getTask(boolean shouldRecordTelemetry, HttpClient httpClient, String endPoint, SplitRoomDatabase database, String apiKey, boolean isEncryptionEnabled, String key) throws URISyntaxException {
        return new MySegmentsSyncTask(ServiceFactory.getMySegmentsFetcher(httpClient, endPoint, key), StorageFactory.getMySegmentsStorageForWorker(database, apiKey, isEncryptionEnabled).getStorageForKey(key), StorageFactory.getMyLargeSegmentsStorageForWorker(database, apiKey, isEncryptionEnabled).getStorageForKey(key), false, null, StorageFactory.getTelemetryStorage(shouldRecordTelemetry), MySegmentsSyncTaskConfig.get(), null, null);
    }
}
