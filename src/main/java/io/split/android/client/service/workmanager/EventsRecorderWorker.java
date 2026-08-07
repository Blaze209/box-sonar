package io.split.android.client.service.workmanager;

import android.content.Context;
import androidx.work.WorkerParameters;
import io.split.android.client.service.ServiceConstants;
import io.split.android.client.service.ServiceFactory;
import io.split.android.client.service.events.EventsRecorderTask;
import io.split.android.client.service.events.EventsRecorderTaskConfig;
import io.split.android.client.storage.db.StorageFactory;
import io.split.android.client.utils.logger.Logger;
import java.net.URISyntaxException;

/* JADX INFO: loaded from: classes4.dex */
public class EventsRecorderWorker extends SplitWorker {
    public EventsRecorderWorker(Context context, WorkerParameters workerParams) {
        super(context, workerParams);
        try {
            this.mSplitTask = new EventsRecorderTask(ServiceFactory.getEventsRecorder(getHttpClient(), getEndPoint()), StorageFactory.getPersistentEventsStorageForWorker(getDatabase(), workerParams.getInputData().getString(ServiceConstants.WORKER_PARAM_API_KEY), workerParams.getInputData().getBoolean(ServiceConstants.WORKER_PARAM_ENCRYPTION_ENABLED, false)), new EventsRecorderTaskConfig(workerParams.getInputData().getInt(ServiceConstants.WORKER_PARAM_EVENTS_PER_PUSH, 100)), StorageFactory.getTelemetryStorage(workerParams.getInputData().getBoolean(ServiceConstants.SHOULD_RECORD_TELEMETRY, false)));
        } catch (URISyntaxException e) {
            Logger.e("Error creating Split worker: " + e.getMessage());
        }
    }
}
