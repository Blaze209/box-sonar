package io.split.android.client.service.workmanager;

import android.content.Context;
import androidx.work.WorkerParameters;
import io.split.android.client.service.ServiceConstants;
import io.split.android.client.service.ServiceFactory;
import io.split.android.client.service.impressions.ImpressionsRecorderTask;
import io.split.android.client.service.impressions.ImpressionsRecorderTaskConfig;
import io.split.android.client.storage.db.StorageFactory;
import io.split.android.client.utils.logger.Logger;
import java.net.URISyntaxException;

/* JADX INFO: loaded from: classes4.dex */
public class ImpressionsRecorderWorker extends SplitWorker {
    public ImpressionsRecorderWorker(Context context, WorkerParameters workerParams) {
        super(context, workerParams);
        try {
            int i = workerParams.getInputData().getInt(ServiceConstants.WORKER_PARAM_IMPRESSIONS_PER_PUSH, 100);
            boolean z = workerParams.getInputData().getBoolean(ServiceConstants.SHOULD_RECORD_TELEMETRY, false);
            String string = workerParams.getInputData().getString(ServiceConstants.WORKER_PARAM_API_KEY);
            boolean z2 = workerParams.getInputData().getBoolean(ServiceConstants.WORKER_PARAM_ENCRYPTION_ENABLED, false);
            ImpressionsRecorderTaskConfig impressionsRecorderTaskConfig = new ImpressionsRecorderTaskConfig(i, 150L, z);
            this.mSplitTask = new ImpressionsRecorderTask(ServiceFactory.getImpressionsRecorder(getHttpClient(), getEndPoint()), StorageFactory.getPersistentImpressionsStorageForWorker(getDatabase(), string, z2), impressionsRecorderTaskConfig, StorageFactory.getTelemetryStorage(impressionsRecorderTaskConfig.shouldRecordTelemetry()));
        } catch (URISyntaxException e) {
            Logger.e("Error creating Split worker: " + e.getMessage());
        }
    }
}
