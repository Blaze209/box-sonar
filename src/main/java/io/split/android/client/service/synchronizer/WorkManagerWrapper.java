package io.split.android.client.service.synchronizer;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ProcessLifecycleOwner;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.ListenableWorker;
import androidx.work.NetworkType;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;
import io.split.android.android_client.BuildConfig;
import io.split.android.client.SplitClientConfig;
import io.split.android.client.SplitFilter;
import io.split.android.client.service.ServiceConstants;
import io.split.android.client.service.executor.SplitTaskExecutionInfo;
import io.split.android.client.service.executor.SplitTaskExecutionListener;
import io.split.android.client.service.executor.SplitTaskType;
import io.split.android.client.service.impressions.ImpressionManagerConfig;
import io.split.android.client.service.synchronizer.mysegments.MySegmentsWorkManagerWrapper;
import io.split.android.client.service.workmanager.EventsRecorderWorker;
import io.split.android.client.service.workmanager.ImpressionsRecorderWorker;
import io.split.android.client.service.workmanager.MySegmentsSyncWorker;
import io.split.android.client.service.workmanager.UniqueKeysRecorderWorker;
import io.split.android.client.service.workmanager.splits.SplitsSyncWorker;
import io.split.android.client.utils.Json;
import io.split.android.client.utils.Utils;
import io.split.android.client.utils.logger.Logger;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes4.dex */
public class WorkManagerWrapper implements MySegmentsWorkManagerWrapper {
    private final String mApiKey;
    private final String mDatabaseName;
    private WeakReference<SplitTaskExecutionListener> mFetcherExecutionListener;
    private final SplitFilter mFilter;
    private final SplitClientConfig mSplitClientConfig;
    private final WorkManager mWorkManager;
    private final Set<String> mShouldLoadFromLocal = new HashSet();
    private final Constraints mConstraints = buildConstraints();

    public WorkManagerWrapper(WorkManager workManager, SplitClientConfig splitClientConfig, String apiKey, String databaseName, SplitFilter filter) {
        this.mWorkManager = (WorkManager) Utils.checkNotNull(workManager);
        this.mDatabaseName = (String) Utils.checkNotNull(databaseName);
        this.mSplitClientConfig = (SplitClientConfig) Utils.checkNotNull(splitClientConfig);
        this.mApiKey = (String) Utils.checkNotNull(apiKey);
        this.mFilter = filter;
    }

    public void setFetcherExecutionListener(SplitTaskExecutionListener fetcherExecutionListener) {
        this.mFetcherExecutionListener = new WeakReference<>(fetcherExecutionListener);
    }

    @Override // io.split.android.client.service.synchronizer.mysegments.MySegmentsWorkManagerWrapper
    public void removeWork() {
        this.mWorkManager.cancelUniqueWork(SplitTaskType.SPLITS_SYNC.toString());
        this.mWorkManager.cancelUniqueWork(SplitTaskType.MY_SEGMENTS_SYNC.toString());
        this.mWorkManager.cancelUniqueWork(SplitTaskType.EVENTS_RECORDER.toString());
        this.mWorkManager.cancelUniqueWork(SplitTaskType.IMPRESSIONS_RECORDER.toString());
        this.mWorkManager.cancelUniqueWork(SplitTaskType.UNIQUE_KEYS_RECORDER_TASK.toString());
        WeakReference<SplitTaskExecutionListener> weakReference = this.mFetcherExecutionListener;
        if (weakReference != null) {
            weakReference.clear();
        }
    }

    public void scheduleWork() {
        scheduleWork(SplitTaskType.SPLITS_SYNC.toString(), SplitsSyncWorker.class, buildSplitSyncInputData());
        scheduleWork(SplitTaskType.EVENTS_RECORDER.toString(), EventsRecorderWorker.class, buildEventsRecorderInputData());
        scheduleWork(SplitTaskType.IMPRESSIONS_RECORDER.toString(), ImpressionsRecorderWorker.class, buildImpressionsRecorderInputData());
        if (isNoneImpressionsMode()) {
            scheduleWork(SplitTaskType.UNIQUE_KEYS_RECORDER_TASK.toString(), UniqueKeysRecorderWorker.class, buildUniqueKeysRecorderInputData());
        }
    }

    @Override // io.split.android.client.service.synchronizer.mysegments.MySegmentsWorkManagerWrapper
    public void scheduleMySegmentsWork(Set<String> keys) {
        scheduleWork(SplitTaskType.MY_SEGMENTS_SYNC.toString(), MySegmentsSyncWorker.class, buildMySegmentsSyncInputData(keys));
    }

    private void scheduleWork(String requestType, Class<? extends ListenableWorker> workerClass, Data inputData) {
        this.mWorkManager.enqueueUniquePeriodicWork(requestType, ExistingPeriodicWorkPolicy.REPLACE, new PeriodicWorkRequest.Builder(workerClass, this.mSplitClientConfig.backgroundSyncPeriod(), TimeUnit.MINUTES).setInputData(buildInputData(inputData)).setConstraints(this.mConstraints).setInitialDelay(15L, TimeUnit.MINUTES).build());
        observeWorkState(workerClass.getCanonicalName());
    }

    private void observeWorkState(final String tag) {
        Logger.d("Adding work manager observer for request id " + tag);
        ThreadUtils.runInMainThread(new Runnable() { // from class: io.split.android.client.service.synchronizer.WorkManagerWrapper.1
            @Override // java.lang.Runnable
            public void run() {
                WorkManagerWrapper.this.mWorkManager.getWorkInfosByTagLiveData(tag).observe(ProcessLifecycleOwner.get(), new Observer<List<WorkInfo>>() { // from class: io.split.android.client.service.synchronizer.WorkManagerWrapper.1.1
                    @Override // androidx.lifecycle.Observer
                    public void onChanged(List<WorkInfo> workInfoList) {
                        if (workInfoList == null) {
                            return;
                        }
                        for (WorkInfo workInfo : workInfoList) {
                            Logger.d("Work manager task: " + workInfo.getTags() + ", state: " + workInfo.getState());
                            WorkManagerWrapper.this.updateTaskStatus(workInfo);
                        }
                    }
                });
            }
        });
    }

    private Data buildInputData(Data customData) {
        Data.Builder builder = new Data.Builder();
        builder.putString(ServiceConstants.WORKER_PARAM_DATABASE_NAME, this.mDatabaseName);
        builder.putString(ServiceConstants.WORKER_PARAM_API_KEY, this.mApiKey);
        builder.putBoolean(ServiceConstants.WORKER_PARAM_ENCRYPTION_ENABLED, this.mSplitClientConfig.encryptionEnabled());
        if (this.mSplitClientConfig.certificatePinningConfiguration() != null) {
            try {
                builder.putString(ServiceConstants.WORKER_PARAM_CERTIFICATE_PINS, Json.toJson(this.mSplitClientConfig.certificatePinningConfiguration().getPins()));
            } catch (Exception e) {
                Logger.e("Error converting pins to JSON for BG sync", e.getLocalizedMessage());
            }
        }
        if (customData != null) {
            builder.putAll(customData);
        }
        return builder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTaskStatus(WorkInfo workInfo) {
        SplitTaskType splitTaskTypeTaskTypeFromTags;
        if (this.mFetcherExecutionListener == null || workInfo == null || workInfo.getTags() == null || !WorkInfo.State.ENQUEUED.equals(workInfo.getState()) || (splitTaskTypeTaskTypeFromTags = taskTypeFromTags(workInfo.getTags())) == null) {
            return;
        }
        if (!this.mShouldLoadFromLocal.contains(splitTaskTypeTaskTypeFromTags.toString())) {
            Logger.d("Avoiding update for " + splitTaskTypeTaskTypeFromTags);
            this.mShouldLoadFromLocal.add(splitTaskTypeTaskTypeFromTags.toString());
            return;
        }
        SplitTaskExecutionListener splitTaskExecutionListener = this.mFetcherExecutionListener.get();
        if (splitTaskExecutionListener != null) {
            Logger.d("Updating for " + splitTaskTypeTaskTypeFromTags);
            splitTaskExecutionListener.taskExecuted(SplitTaskExecutionInfo.success(splitTaskTypeTaskTypeFromTags));
        }
    }

    private SplitTaskType taskTypeFromTags(Set<String> tags) {
        if (tags.contains(SplitsSyncWorker.class.getCanonicalName())) {
            return SplitTaskType.SPLITS_SYNC;
        }
        if (tags.contains(MySegmentsSyncWorker.class.getCanonicalName())) {
            return SplitTaskType.MY_SEGMENTS_SYNC;
        }
        return null;
    }

    private Data buildSplitSyncInputData() {
        Data.Builder builder = new Data.Builder();
        builder.putString(ServiceConstants.WORKER_PARAM_ENDPOINT, this.mSplitClientConfig.endpoint());
        builder.putBoolean(ServiceConstants.SHOULD_RECORD_TELEMETRY, this.mSplitClientConfig.shouldRecordTelemetry());
        SplitFilter splitFilter = this.mFilter;
        builder.putString(ServiceConstants.WORKER_PARAM_CONFIGURED_FILTER_TYPE, splitFilter != null ? splitFilter.getType().queryStringField() : null);
        SplitFilter splitFilter2 = this.mFilter;
        builder.putStringArray(ServiceConstants.WORKER_PARAM_CONFIGURED_FILTER_VALUES, splitFilter2 != null ? (String[]) splitFilter2.getValues().toArray(new String[0]) : new String[0]);
        builder.putString("flagsSpec", BuildConfig.FLAGS_SPEC);
        return buildInputData(builder.build());
    }

    private Data buildMySegmentsSyncInputData(Set<String> keys) {
        Data.Builder builder = new Data.Builder();
        String[] strArr = new String[keys.size()];
        keys.toArray(strArr);
        builder.putString(ServiceConstants.WORKER_PARAM_ENDPOINT, this.mSplitClientConfig.endpoint());
        builder.putStringArray("key", strArr);
        builder.putBoolean(ServiceConstants.SHOULD_RECORD_TELEMETRY, this.mSplitClientConfig.shouldRecordTelemetry());
        return buildInputData(builder.build());
    }

    private Data buildEventsRecorderInputData() {
        Data.Builder builder = new Data.Builder();
        builder.putString(ServiceConstants.WORKER_PARAM_ENDPOINT, this.mSplitClientConfig.eventsEndpoint());
        builder.putInt(ServiceConstants.WORKER_PARAM_EVENTS_PER_PUSH, this.mSplitClientConfig.eventsPerPush());
        builder.putBoolean(ServiceConstants.SHOULD_RECORD_TELEMETRY, this.mSplitClientConfig.shouldRecordTelemetry());
        return buildInputData(builder.build());
    }

    private Data buildImpressionsRecorderInputData() {
        Data.Builder builder = new Data.Builder();
        builder.putString(ServiceConstants.WORKER_PARAM_ENDPOINT, this.mSplitClientConfig.eventsEndpoint());
        builder.putInt(ServiceConstants.WORKER_PARAM_IMPRESSIONS_PER_PUSH, this.mSplitClientConfig.impressionsPerPush());
        builder.putBoolean(ServiceConstants.SHOULD_RECORD_TELEMETRY, this.mSplitClientConfig.shouldRecordTelemetry());
        return buildInputData(builder.build());
    }

    private Data buildUniqueKeysRecorderInputData() {
        Data.Builder builder = new Data.Builder();
        builder.putString(ServiceConstants.WORKER_PARAM_ENDPOINT, this.mSplitClientConfig.telemetryEndpoint());
        builder.putInt(ServiceConstants.WORKER_PARAM_UNIQUE_KEYS_PER_PUSH, this.mSplitClientConfig.mtkPerPush());
        builder.putLong(ServiceConstants.WORKER_PARAM_UNIQUE_KEYS_ESTIMATED_SIZE_IN_BYTES, 150L);
        return buildInputData(builder.build());
    }

    private Constraints buildConstraints() {
        Constraints.Builder builder = new Constraints.Builder();
        builder.setRequiredNetworkType(this.mSplitClientConfig.backgroundSyncWhenBatteryWifiOnly() ? NetworkType.UNMETERED : NetworkType.CONNECTED);
        builder.setRequiresBatteryNotLow(this.mSplitClientConfig.backgroundSyncWhenBatteryNotLow());
        return builder.build();
    }

    private boolean isNoneImpressionsMode() {
        return ImpressionManagerConfig.Mode.fromImpressionMode(this.mSplitClientConfig.impressionsMode()).isNone();
    }
}
