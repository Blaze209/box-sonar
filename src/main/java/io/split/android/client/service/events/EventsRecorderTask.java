package io.split.android.client.service.events;

import io.split.android.client.dtos.Event;
import io.split.android.client.service.executor.SplitTask;
import io.split.android.client.service.executor.SplitTaskExecutionInfo;
import io.split.android.client.service.executor.SplitTaskExecutionStatus;
import io.split.android.client.service.executor.SplitTaskType;
import io.split.android.client.service.http.HttpRecorder;
import io.split.android.client.service.http.HttpRecorderException;
import io.split.android.client.service.http.HttpStatus;
import io.split.android.client.storage.events.PersistentEventsStorage;
import io.split.android.client.telemetry.model.OperationType;
import io.split.android.client.telemetry.storage.TelemetryRuntimeProducer;
import io.split.android.client.utils.Utils;
import io.split.android.client.utils.logger.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class EventsRecorderTask implements SplitTask {
    public static final int FAILING_CHUNK_SIZE = 20;
    private final EventsRecorderTaskConfig mConfig;
    private final HttpRecorder<List<Event>> mHttpRecorder;
    private final PersistentEventsStorage mPersistentEventsStorage;
    private final TelemetryRuntimeProducer mTelemetryRuntimeProducer;

    public EventsRecorderTask(HttpRecorder<List<Event>> httpRecorder, PersistentEventsStorage persistentEventsStorage, EventsRecorderTaskConfig config, TelemetryRuntimeProducer telemetryRuntimeProducer) {
        this.mHttpRecorder = (HttpRecorder) Utils.checkNotNull(httpRecorder);
        this.mPersistentEventsStorage = (PersistentEventsStorage) Utils.checkNotNull(persistentEventsStorage);
        this.mConfig = (EventsRecorderTaskConfig) Utils.checkNotNull(config);
        this.mTelemetryRuntimeProducer = (TelemetryRuntimeProducer) Utils.checkNotNull(telemetryRuntimeProducer);
    }

    /* JADX WARN: Code duplicated, block: B:30:0x00e7 A[LOOP:1: B:28:0x00e1->B:30:0x00e7, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:33:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:35:0x0110  */
    /* JADX WARN: Code duplicated, block: B:38:0x0120  */
    /* JADX WARN: Code duplicated, block: B:45:0x00d4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:46:? A[LOOP:0: B:3:0x000d->B:46:?, LOOP_END, SYNTHETIC] */
    @Override // io.split.android.client.service.executor.SplitTask
    public SplitTaskExecutionInfo execute() throws Throwable {
        SplitTaskExecutionStatus splitTaskExecutionStatus;
        boolean z;
        Iterator it;
        HashMap map;
        long j;
        SplitTaskExecutionStatus splitTaskExecutionStatus2 = SplitTaskExecutionStatus.SUCCESS;
        ArrayList arrayList = new ArrayList();
        long j2 = 0;
        long jSumEventBytes = 0;
        int eventsPerPush = 0;
        while (true) {
            List<Event> listPop = this.mPersistentEventsStorage.pop(this.mConfig.getEventsPerPush());
            if (listPop.size() > 0) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                try {
                    Logger.d("Posting %d Split events", Integer.valueOf(listPop.size()));
                    this.mHttpRecorder.execute(listPop);
                    long jCurrentTimeMillis2 = System.currentTimeMillis();
                    j = jCurrentTimeMillis2 - jCurrentTimeMillis;
                    try {
                        try {
                            this.mTelemetryRuntimeProducer.recordSuccessfulSync(OperationType.EVENTS, jCurrentTimeMillis2);
                            this.mPersistentEventsStorage.delete(listPop);
                            Logger.d("%d split events sent", Integer.valueOf(listPop.size()));
                            this.mTelemetryRuntimeProducer.recordSyncLatency(OperationType.EVENTS, j);
                        } catch (HttpRecorderException e) {
                            e = e;
                            splitTaskExecutionStatus = SplitTaskExecutionStatus.ERROR;
                            eventsPerPush += this.mConfig.getEventsPerPush();
                            jSumEventBytes += sumEventBytes(listPop);
                            Logger.e("Event recorder task: Some events couldn't be sentSaving to send them in a new iteration: " + e.getLocalizedMessage());
                            arrayList.addAll(listPop);
                            this.mTelemetryRuntimeProducer.recordSyncError(OperationType.EVENTS, e.getHttpStatus());
                            if (HttpStatus.isNotRetryable(e.getHttpStatus())) {
                                this.mTelemetryRuntimeProducer.recordSyncLatency(OperationType.EVENTS, j);
                                z = true;
                                break;
                            }
                            this.mTelemetryRuntimeProducer.recordSyncLatency(OperationType.EVENTS, j);
                            splitTaskExecutionStatus2 = splitTaskExecutionStatus;
                            it = Utils.partition(arrayList, 20).iterator();
                            while (it.hasNext()) {
                                this.mPersistentEventsStorage.setActive((List) it.next());
                            }
                            if (splitTaskExecutionStatus == SplitTaskExecutionStatus.ERROR) {
                                map = new HashMap();
                                map.put(SplitTaskExecutionInfo.NON_SENT_RECORDS, Integer.valueOf(eventsPerPush));
                                map.put(SplitTaskExecutionInfo.NON_SENT_BYTES, Long.valueOf(jSumEventBytes));
                                if (z) {
                                    map.put(SplitTaskExecutionInfo.DO_NOT_RETRY, true);
                                }
                                return SplitTaskExecutionInfo.error(SplitTaskType.EVENTS_RECORDER, map);
                            }
                            return SplitTaskExecutionInfo.success(SplitTaskType.EVENTS_RECORDER);
                        }
                    } catch (Throwable th) {
                        th = th;
                        j2 = j;
                        this.mTelemetryRuntimeProducer.recordSyncLatency(OperationType.EVENTS, j2);
                        throw th;
                    }
                } catch (HttpRecorderException e2) {
                    e = e2;
                    j = 0;
                } catch (Throwable th2) {
                    th = th2;
                }
                if (listPop.size() != this.mConfig.getEventsPerPush()) {
                    splitTaskExecutionStatus = splitTaskExecutionStatus2;
                    z = false;
                    break;
                }
            } else if (listPop.size() != this.mConfig.getEventsPerPush()) {
                splitTaskExecutionStatus = splitTaskExecutionStatus2;
                z = false;
                break;
            }
        }
        it = Utils.partition(arrayList, 20).iterator();
        while (it.hasNext()) {
            this.mPersistentEventsStorage.setActive((List) it.next());
        }
        if (splitTaskExecutionStatus == SplitTaskExecutionStatus.ERROR) {
            map = new HashMap();
            map.put(SplitTaskExecutionInfo.NON_SENT_RECORDS, Integer.valueOf(eventsPerPush));
            map.put(SplitTaskExecutionInfo.NON_SENT_BYTES, Long.valueOf(jSumEventBytes));
            if (z) {
                map.put(SplitTaskExecutionInfo.DO_NOT_RETRY, true);
            }
            return SplitTaskExecutionInfo.error(SplitTaskType.EVENTS_RECORDER, map);
        }
        return SplitTaskExecutionInfo.success(SplitTaskType.EVENTS_RECORDER);
    }

    private long sumEventBytes(List<Event> events) {
        Iterator<Event> it = events.iterator();
        long sizeInBytes = 0;
        while (it.hasNext()) {
            sizeInBytes += it.next().getSizeInBytes();
        }
        return sizeInBytes;
    }
}
