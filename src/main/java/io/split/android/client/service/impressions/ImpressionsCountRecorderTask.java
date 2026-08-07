package io.split.android.client.service.impressions;

import io.split.android.client.service.executor.SplitTask;
import io.split.android.client.service.executor.SplitTaskExecutionInfo;
import io.split.android.client.service.executor.SplitTaskExecutionStatus;
import io.split.android.client.service.executor.SplitTaskType;
import io.split.android.client.service.http.HttpRecorder;
import io.split.android.client.service.http.HttpRecorderException;
import io.split.android.client.service.http.HttpStatus;
import io.split.android.client.storage.impressions.PersistentImpressionsCountStorage;
import io.split.android.client.telemetry.model.OperationType;
import io.split.android.client.telemetry.storage.TelemetryRuntimeProducer;
import io.split.android.client.utils.Utils;
import io.split.android.client.utils.logger.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class ImpressionsCountRecorderTask implements SplitTask {
    private static int POP_COUNT = 200;
    private final HttpRecorder<ImpressionsCount> mHttpRecorder;
    private final PersistentImpressionsCountStorage mPersistentStorage;
    private final TelemetryRuntimeProducer mTelemetryRuntimeProducer;

    public ImpressionsCountRecorderTask(HttpRecorder<ImpressionsCount> httpRecorder, PersistentImpressionsCountStorage persistentStorage, TelemetryRuntimeProducer telemetryRuntimeProducer) {
        this.mHttpRecorder = (HttpRecorder) Utils.checkNotNull(httpRecorder);
        this.mPersistentStorage = (PersistentImpressionsCountStorage) Utils.checkNotNull(persistentStorage);
        this.mTelemetryRuntimeProducer = (TelemetryRuntimeProducer) Utils.checkNotNull(telemetryRuntimeProducer);
    }

    /* JADX WARN: Code duplicated, block: B:28:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:31:0x00db  */
    /* JADX WARN: Code duplicated, block: B:33:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:36:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:43:0x00ca A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:44:? A[LOOP:0: B:3:0x000c->B:44:?, LOOP_END, SYNTHETIC] */
    @Override // io.split.android.client.service.executor.SplitTask
    public SplitTaskExecutionInfo execute() throws Throwable {
        boolean z;
        SplitTaskExecutionStatus splitTaskExecutionStatus;
        HashMap map;
        SplitTaskExecutionStatus splitTaskExecutionStatus2 = SplitTaskExecutionStatus.SUCCESS;
        new ArrayList();
        ArrayList arrayList = new ArrayList();
        while (true) {
            List<ImpressionsCountPerFeature> listPop = this.mPersistentStorage.pop(POP_COUNT);
            if (listPop.size() > 0) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                long j = 0;
                try {
                    try {
                        Logger.d("Posting %d Split impressions count", Integer.valueOf(listPop.size()));
                        this.mHttpRecorder.execute(new ImpressionsCount(listPop));
                        long jCurrentTimeMillis2 = System.currentTimeMillis();
                        long j2 = jCurrentTimeMillis2 - jCurrentTimeMillis;
                        try {
                            this.mTelemetryRuntimeProducer.recordSuccessfulSync(OperationType.IMPRESSIONS_COUNT, jCurrentTimeMillis2);
                            this.mPersistentStorage.delete(listPop);
                            Logger.d("%d split impressions count sent", Integer.valueOf(listPop.size()));
                            this.mTelemetryRuntimeProducer.recordSyncLatency(OperationType.IMPRESSIONS_COUNT, j2);
                        } catch (HttpRecorderException e) {
                            e = e;
                            j = j2;
                            splitTaskExecutionStatus = SplitTaskExecutionStatus.ERROR;
                            Logger.e("Impressions count recorder task: Some counts couldn't be sent. Saving to send them in a new iteration\n" + e.getLocalizedMessage());
                            arrayList.addAll(listPop);
                            this.mTelemetryRuntimeProducer.recordSyncError(OperationType.IMPRESSIONS_COUNT, e.getHttpStatus());
                            if (HttpStatus.isNotRetryable(HttpStatus.fromCode(e.getHttpStatus()))) {
                                this.mTelemetryRuntimeProducer.recordSyncLatency(OperationType.IMPRESSIONS_COUNT, j);
                                z = true;
                                break;
                            }
                            this.mTelemetryRuntimeProducer.recordSyncLatency(OperationType.IMPRESSIONS_COUNT, j);
                            splitTaskExecutionStatus2 = splitTaskExecutionStatus;
                            if (arrayList.size() > 0) {
                                this.mPersistentStorage.setActive(arrayList);
                            }
                            if (splitTaskExecutionStatus == SplitTaskExecutionStatus.ERROR) {
                                map = new HashMap();
                                if (z) {
                                    map.put(SplitTaskExecutionInfo.DO_NOT_RETRY, true);
                                }
                                return SplitTaskExecutionInfo.error(SplitTaskType.IMPRESSIONS_COUNT_RECORDER, map);
                            }
                            return SplitTaskExecutionInfo.success(SplitTaskType.IMPRESSIONS_COUNT_RECORDER);
                        } catch (Throwable th) {
                            th = th;
                            j = j2;
                            this.mTelemetryRuntimeProducer.recordSyncLatency(OperationType.IMPRESSIONS_COUNT, j);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (HttpRecorderException e2) {
                    e = e2;
                }
                if (listPop.size() != POP_COUNT) {
                    z = false;
                    splitTaskExecutionStatus = splitTaskExecutionStatus2;
                    break;
                }
            } else if (listPop.size() != POP_COUNT) {
                z = false;
                splitTaskExecutionStatus = splitTaskExecutionStatus2;
                break;
            }
        }
        if (arrayList.size() > 0) {
            this.mPersistentStorage.setActive(arrayList);
        }
        if (splitTaskExecutionStatus == SplitTaskExecutionStatus.ERROR) {
            map = new HashMap();
            if (z) {
                map.put(SplitTaskExecutionInfo.DO_NOT_RETRY, true);
            }
            return SplitTaskExecutionInfo.error(SplitTaskType.IMPRESSIONS_COUNT_RECORDER, map);
        }
        return SplitTaskExecutionInfo.success(SplitTaskType.IMPRESSIONS_COUNT_RECORDER);
    }
}
