package io.split.android.client.service.workmanager;

import android.content.Context;
import androidx.work.Data;
import androidx.work.WorkerParameters;
import io.split.android.client.service.ServiceConstants;
import io.split.android.client.service.ServiceFactory;
import io.split.android.client.service.impressions.unique.UniqueKeysRecorderTask;
import io.split.android.client.service.impressions.unique.UniqueKeysRecorderTaskConfig;
import io.split.android.client.storage.db.StorageFactory;
import io.split.android.client.utils.logger.Logger;

/* JADX INFO: loaded from: classes4.dex */
public class UniqueKeysRecorderWorker extends SplitWorker {
    public UniqueKeysRecorderWorker(Context context, WorkerParameters workerParams) {
        super(context, workerParams);
        try {
            Data inputData = workerParams.getInputData();
            this.mSplitTask = new UniqueKeysRecorderTask(ServiceFactory.getUniqueKeysRecorder(getHttpClient(), getEndPoint()), StorageFactory.getPersistentImpressionsUniqueStorageForWorker(getDatabase(), inputData.getString(ServiceConstants.WORKER_PARAM_API_KEY), inputData.getBoolean(ServiceConstants.WORKER_PARAM_ENCRYPTION_ENABLED, false)), new UniqueKeysRecorderTaskConfig(inputData.getInt(ServiceConstants.WORKER_PARAM_UNIQUE_KEYS_PER_PUSH, 100), inputData.getLong(ServiceConstants.WORKER_PARAM_UNIQUE_KEYS_ESTIMATED_SIZE_IN_BYTES, 150L)));
        } catch (Exception e) {
            Logger.e("Error creating unique keys Split worker: " + e.getMessage());
        }
    }
}
