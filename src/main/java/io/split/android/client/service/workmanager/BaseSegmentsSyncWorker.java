package io.split.android.client.service.workmanager;

import android.content.Context;
import androidx.work.WorkerParameters;
import io.split.android.client.network.HttpClient;
import io.split.android.client.service.ServiceConstants;
import io.split.android.client.service.mysegments.MySegmentsBulkSyncTask;
import io.split.android.client.service.mysegments.MySegmentsSyncTask;
import io.split.android.client.storage.db.SplitRoomDatabase;
import io.split.android.client.utils.logger.Logger;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
abstract class BaseSegmentsSyncWorker extends SplitWorker {
    protected abstract MySegmentsSyncTask getTask(boolean shouldRecordTelemetry, HttpClient httpClient, String endPoint, SplitRoomDatabase database, String apiKey, boolean isEncryptionEnabled, String key) throws URISyntaxException;

    BaseSegmentsSyncWorker(Context context, WorkerParameters workerParams) {
        super(context, workerParams);
        String[] stringArray = workerParams.getInputData().getStringArray("key");
        String string = workerParams.getInputData().getString(ServiceConstants.WORKER_PARAM_API_KEY);
        boolean z = workerParams.getInputData().getBoolean(ServiceConstants.WORKER_PARAM_ENCRYPTION_ENABLED, false);
        boolean z2 = workerParams.getInputData().getBoolean(ServiceConstants.SHOULD_RECORD_TELEMETRY, false);
        try {
            if (stringArray == null) {
                Logger.e("Error scheduling segments sync worker: Keys are null");
            } else {
                this.mSplitTask = new MySegmentsBulkSyncTask(Collections.unmodifiableSet(getIndividualMySegmentsSyncTasks(stringArray, z2, getHttpClient(), getEndPoint(), getDatabase(), string, z)));
            }
        } catch (URISyntaxException e) {
            Logger.e("Error creating Split worker: " + e.getMessage());
        }
    }

    private Set<MySegmentsSyncTask> getIndividualMySegmentsSyncTasks(String[] keys, boolean shouldRecordTelemetry, HttpClient httpClient, String endPoint, SplitRoomDatabase database, String apiKey, boolean isEncryptionEnabled) throws URISyntaxException {
        HashSet hashSet = new HashSet();
        for (String str : keys) {
            hashSet.add(getTask(shouldRecordTelemetry, httpClient, endPoint, database, apiKey, isEncryptionEnabled, str));
        }
        return hashSet;
    }
}
