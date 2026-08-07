package io.split.android.client.service.impressions;

import io.split.android.client.dtos.KeyImpression;
import io.split.android.client.service.executor.SplitTask;
import io.split.android.client.service.executor.SplitTaskExecutionInfo;
import io.split.android.client.service.executor.SplitTaskExecutionStatus;
import io.split.android.client.service.executor.SplitTaskType;
import io.split.android.client.service.http.HttpRecorder;
import io.split.android.client.service.http.HttpRecorderException;
import io.split.android.client.service.http.HttpStatus;
import io.split.android.client.storage.impressions.PersistentImpressionsStorage;
import io.split.android.client.telemetry.model.OperationType;
import io.split.android.client.telemetry.storage.TelemetryRuntimeProducer;
import io.split.android.client.utils.Utils;
import io.split.android.client.utils.logger.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class ImpressionsRecorderTask implements SplitTask {
    public static final int FAILING_CHUNK_SIZE = 20;
    private final ImpressionsRecorderTaskConfig mConfig;
    private final HttpRecorder<List<KeyImpression>> mHttpRecorder;
    private final PersistentImpressionsStorage mPersistenImpressionsStorage;
    private final TelemetryRuntimeProducer mTelemetryRuntimeProducer;

    public ImpressionsRecorderTask(HttpRecorder<List<KeyImpression>> httpRecorder, PersistentImpressionsStorage persistenEventsStorage, ImpressionsRecorderTaskConfig config, TelemetryRuntimeProducer telemetryRuntimeProducer) {
        this.mHttpRecorder = (HttpRecorder) Utils.checkNotNull(httpRecorder);
        this.mPersistenImpressionsStorage = (PersistentImpressionsStorage) Utils.checkNotNull(persistenEventsStorage);
        this.mConfig = (ImpressionsRecorderTaskConfig) Utils.checkNotNull(config);
        this.mTelemetryRuntimeProducer = (TelemetryRuntimeProducer) Utils.checkNotNull(telemetryRuntimeProducer);
    }

    /* JADX WARN: Code duplicated, block: B:29:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:32:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:34:0x0103  */
    /* JADX WARN: Code duplicated, block: B:37:0x0113  */
    /* JADX WARN: Code duplicated, block: B:44:0x00d8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:45:? A[LOOP:0: B:3:0x000d->B:45:?, LOOP_END, SYNTHETIC] */
    @Override // io.split.android.client.service.executor.SplitTask
    public SplitTaskExecutionInfo execute() throws Throwable {
        SplitTaskExecutionStatus splitTaskExecutionStatus;
        boolean z;
        HashMap map;
        long j;
        SplitTaskExecutionStatus splitTaskExecutionStatus2 = SplitTaskExecutionStatus.SUCCESS;
        ArrayList arrayList = new ArrayList();
        long j2 = 0;
        long jSumImpressionsBytes = 0;
        int impressionsPerPush = 0;
        while (true) {
            List<KeyImpression> listPop = this.mPersistenImpressionsStorage.pop(this.mConfig.getImpressionsPerPush());
            if (listPop.size() > 0) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                try {
                    Logger.d("Posting %d Split impressions", Integer.valueOf(listPop.size()));
                    this.mHttpRecorder.execute(listPop);
                    long jCurrentTimeMillis2 = System.currentTimeMillis();
                    j = jCurrentTimeMillis2 - jCurrentTimeMillis;
                    try {
                        try {
                            this.mTelemetryRuntimeProducer.recordSuccessfulSync(OperationType.IMPRESSIONS, jCurrentTimeMillis2);
                            this.mPersistenImpressionsStorage.delete(listPop);
                            Logger.d("%d split impressions sent", Integer.valueOf(listPop.size()));
                            this.mTelemetryRuntimeProducer.recordSyncLatency(OperationType.IMPRESSIONS, j);
                        } catch (HttpRecorderException e) {
                            e = e;
                            splitTaskExecutionStatus = SplitTaskExecutionStatus.ERROR;
                            impressionsPerPush += this.mConfig.getImpressionsPerPush();
                            jSumImpressionsBytes += sumImpressionsBytes(listPop);
                            Logger.e("Impressions recorder task: Some impressions couldn't be sent. Saving to send them in a new iteration\n" + e.getLocalizedMessage());
                            arrayList.addAll(listPop);
                            this.mTelemetryRuntimeProducer.recordSyncError(OperationType.IMPRESSIONS, e.getHttpStatus());
                            if (HttpStatus.isNotRetryable(HttpStatus.fromCode(e.getHttpStatus()))) {
                                this.mTelemetryRuntimeProducer.recordSyncLatency(OperationType.IMPRESSIONS, j);
                                z = true;
                                break;
                            }
                            this.mTelemetryRuntimeProducer.recordSyncLatency(OperationType.IMPRESSIONS, j);
                            splitTaskExecutionStatus2 = splitTaskExecutionStatus;
                            if (arrayList.size() > 0) {
                                this.mPersistenImpressionsStorage.setActive(arrayList);
                            }
                            if (splitTaskExecutionStatus == SplitTaskExecutionStatus.ERROR) {
                                map = new HashMap();
                                map.put(SplitTaskExecutionInfo.NON_SENT_RECORDS, Integer.valueOf(impressionsPerPush));
                                map.put(SplitTaskExecutionInfo.NON_SENT_BYTES, Long.valueOf(jSumImpressionsBytes));
                                if (z) {
                                    map.put(SplitTaskExecutionInfo.DO_NOT_RETRY, true);
                                }
                                return SplitTaskExecutionInfo.error(SplitTaskType.IMPRESSIONS_RECORDER, map);
                            }
                            return SplitTaskExecutionInfo.success(SplitTaskType.IMPRESSIONS_RECORDER);
                        }
                    } catch (Throwable th) {
                        th = th;
                        j2 = j;
                        this.mTelemetryRuntimeProducer.recordSyncLatency(OperationType.IMPRESSIONS, j2);
                        throw th;
                    }
                } catch (HttpRecorderException e2) {
                    e = e2;
                    j = 0;
                } catch (Throwable th2) {
                    th = th2;
                }
                if (listPop.size() != this.mConfig.getImpressionsPerPush()) {
                    splitTaskExecutionStatus = splitTaskExecutionStatus2;
                    z = false;
                    break;
                }
            } else if (listPop.size() != this.mConfig.getImpressionsPerPush()) {
                splitTaskExecutionStatus = splitTaskExecutionStatus2;
                z = false;
                break;
            }
        }
        if (arrayList.size() > 0) {
            this.mPersistenImpressionsStorage.setActive(arrayList);
        }
        if (splitTaskExecutionStatus == SplitTaskExecutionStatus.ERROR) {
            map = new HashMap();
            map.put(SplitTaskExecutionInfo.NON_SENT_RECORDS, Integer.valueOf(impressionsPerPush));
            map.put(SplitTaskExecutionInfo.NON_SENT_BYTES, Long.valueOf(jSumImpressionsBytes));
            if (z) {
                map.put(SplitTaskExecutionInfo.DO_NOT_RETRY, true);
            }
            return SplitTaskExecutionInfo.error(SplitTaskType.IMPRESSIONS_RECORDER, map);
        }
        return SplitTaskExecutionInfo.success(SplitTaskType.IMPRESSIONS_RECORDER);
    }

    private long sumImpressionsBytes(List<KeyImpression> impressions) {
        long estimatedSizeInBytes = 0;
        for (KeyImpression keyImpression : impressions) {
            estimatedSizeInBytes += this.mConfig.getEstimatedSizeInBytes();
        }
        return estimatedSizeInBytes;
    }
}
