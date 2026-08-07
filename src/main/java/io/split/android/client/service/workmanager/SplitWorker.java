package io.split.android.client.service.workmanager;

import android.content.Context;
import androidx.work.Data;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import io.split.android.android_client.BuildConfig;
import io.split.android.client.network.CertificatePinningConfiguration;
import io.split.android.client.network.CertificatePinningConfigurationProvider;
import io.split.android.client.network.HttpClient;
import io.split.android.client.network.HttpClientImpl;
import io.split.android.client.network.SplitHttpHeadersBuilder;
import io.split.android.client.service.ServiceConstants;
import io.split.android.client.service.executor.SplitTask;
import io.split.android.client.storage.db.SplitRoomDatabase;

/* JADX INFO: loaded from: classes4.dex */
public abstract class SplitWorker extends Worker {
    private final SplitRoomDatabase mDatabase;
    private final String mEndpoint;
    private final HttpClient mHttpClient;
    protected SplitTask mSplitTask;

    public SplitWorker(Context context, WorkerParameters workerParams) {
        super(context, workerParams);
        Data inputData = workerParams.getInputData();
        String string = inputData.getString(ServiceConstants.WORKER_PARAM_DATABASE_NAME);
        String string2 = inputData.getString(ServiceConstants.WORKER_PARAM_API_KEY);
        this.mEndpoint = inputData.getString(ServiceConstants.WORKER_PARAM_ENDPOINT);
        this.mDatabase = SplitRoomDatabase.getDatabase(context, string);
        this.mHttpClient = buildHttpClient(string2, buildCertPinningConfig(inputData.getString(ServiceConstants.WORKER_PARAM_CERTIFICATE_PINS)));
    }

    @Override // androidx.work.Worker
    public ListenableWorker.Result doWork() {
        SplitTask splitTask = this.mSplitTask;
        if (splitTask != null) {
            splitTask.execute();
            return ListenableWorker.Result.success();
        }
        return ListenableWorker.Result.failure();
    }

    protected SplitRoomDatabase getDatabase() {
        return this.mDatabase;
    }

    public HttpClient getHttpClient() {
        return this.mHttpClient;
    }

    public String getEndPoint() {
        return this.mEndpoint;
    }

    private static HttpClient buildHttpClient(String apiKey, CertificatePinningConfiguration certificatePinningConfiguration) {
        HttpClientImpl.Builder builder = new HttpClientImpl.Builder();
        if (certificatePinningConfiguration != null) {
            builder.setCertificatePinningConfiguration(certificatePinningConfiguration);
        }
        HttpClient httpClientBuild = builder.build();
        SplitHttpHeadersBuilder splitHttpHeadersBuilder = new SplitHttpHeadersBuilder();
        splitHttpHeadersBuilder.setClientVersion(BuildConfig.SPLIT_VERSION_NAME);
        splitHttpHeadersBuilder.setApiToken(apiKey);
        splitHttpHeadersBuilder.addJsonTypeHeaders();
        httpClientBuild.addHeaders(splitHttpHeadersBuilder.build());
        return httpClientBuild;
    }

    private static CertificatePinningConfiguration buildCertPinningConfig(String pinsJson) {
        if (pinsJson == null || pinsJson.trim().isEmpty()) {
            return null;
        }
        return CertificatePinningConfigurationProvider.getCertificatePinningConfiguration(pinsJson);
    }
}
