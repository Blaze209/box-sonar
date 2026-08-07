package io.split.android.client.service.workmanager.splits;

import androidx.work.WorkerParameters;
import io.split.android.client.service.ServiceConstants;

/* JADX INFO: loaded from: classes4.dex */
class SplitsSyncWorkerParams {
    private final String mApiKey;
    private final String mConfiguredFilterType;
    private final String[] mConfiguredFilterValues;
    private final boolean mEncryptionEnabled;
    private final String mFlagsSpec;
    private final boolean mShouldRecordTelemetry;

    SplitsSyncWorkerParams(WorkerParameters workerParameters) {
        this(workerParameters.getInputData().getBoolean(ServiceConstants.SHOULD_RECORD_TELEMETRY, false), workerParameters.getInputData().getString(ServiceConstants.WORKER_PARAM_API_KEY), workerParameters.getInputData().getBoolean(ServiceConstants.WORKER_PARAM_ENCRYPTION_ENABLED, false), workerParameters.getInputData().getString(ServiceConstants.WORKER_PARAM_CONFIGURED_FILTER_TYPE), workerParameters.getInputData().getStringArray(ServiceConstants.WORKER_PARAM_CONFIGURED_FILTER_VALUES), workerParameters.getInputData().getString("flagsSpec"));
    }

    SplitsSyncWorkerParams(boolean shouldRecordTelemetry, String apiKey, boolean encryptionEnabled, String configuredFilterType, String[] configuredFilterValues, String flagsSpec) {
        this.mShouldRecordTelemetry = shouldRecordTelemetry;
        this.mApiKey = apiKey;
        this.mEncryptionEnabled = encryptionEnabled;
        this.mConfiguredFilterType = configuredFilterType;
        this.mConfiguredFilterValues = configuredFilterValues;
        this.mFlagsSpec = flagsSpec;
    }

    boolean shouldRecordTelemetry() {
        return this.mShouldRecordTelemetry;
    }

    String apiKey() {
        return this.mApiKey;
    }

    boolean encryptionEnabled() {
        return this.mEncryptionEnabled;
    }

    String configuredFilterType() {
        return this.mConfiguredFilterType;
    }

    String[] configuredFilterValues() {
        return this.mConfiguredFilterValues;
    }

    String flagsSpec() {
        return this.mFlagsSpec;
    }
}
