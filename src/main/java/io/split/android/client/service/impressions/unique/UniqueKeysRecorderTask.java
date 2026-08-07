package io.split.android.client.service.impressions.unique;

import io.split.android.client.service.executor.SplitTask;
import io.split.android.client.service.executor.SplitTaskExecutionInfo;
import io.split.android.client.service.executor.SplitTaskExecutionStatus;
import io.split.android.client.service.executor.SplitTaskType;
import io.split.android.client.service.http.HttpRecorder;
import io.split.android.client.service.http.HttpRecorderException;
import io.split.android.client.service.http.HttpStatus;
import io.split.android.client.storage.impressions.PersistentImpressionsUniqueStorage;
import io.split.android.client.utils.Utils;
import io.split.android.client.utils.logger.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public class UniqueKeysRecorderTask implements SplitTask {
    private final UniqueKeysRecorderTaskConfig mConfig;
    private final HttpRecorder<MTK> mHttpRecorder;
    private final PersistentImpressionsUniqueStorage mStorage;

    public UniqueKeysRecorderTask(HttpRecorder<MTK> uniqueImpressionsRecorder, PersistentImpressionsUniqueStorage storage, UniqueKeysRecorderTaskConfig config) {
        this.mHttpRecorder = (HttpRecorder) Utils.checkNotNull(uniqueImpressionsRecorder);
        this.mStorage = (PersistentImpressionsUniqueStorage) Utils.checkNotNull(storage);
        this.mConfig = (UniqueKeysRecorderTaskConfig) Utils.checkNotNull(config);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x009b  */
    /* JADX WARN: Code duplicated, block: B:20:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:22:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:25:0x00cd  */
    @Override // io.split.android.client.service.executor.SplitTask
    public SplitTaskExecutionInfo execute() {
        SplitTaskExecutionStatus splitTaskExecutionStatus;
        HashMap map;
        SplitTaskExecutionStatus splitTaskExecutionStatus2 = SplitTaskExecutionStatus.SUCCESS;
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        long jSumImpressionsBytes = 0;
        int elementsPerPush = 0;
        while (true) {
            List<UniqueKey> listPop = this.mStorage.pop(this.mConfig.getElementsPerPush());
            if (listPop.size() > 0) {
                try {
                    Logger.d("Posting %d Split MTKs", Integer.valueOf(listPop.size()));
                    this.mHttpRecorder.execute(buildMTK(listPop));
                    this.mStorage.delete(listPop);
                    Logger.d("%d split MTKs sent", Integer.valueOf(listPop.size()));
                } catch (HttpRecorderException e) {
                    splitTaskExecutionStatus = SplitTaskExecutionStatus.ERROR;
                    elementsPerPush += this.mConfig.getElementsPerPush();
                    jSumImpressionsBytes += sumImpressionsBytes(listPop);
                    Logger.e("MTKs recorder task: Some keys couldn't be sent. Saving to send them in a new iteration\n" + e.getLocalizedMessage());
                    arrayList.addAll(listPop);
                    if (HttpStatus.isNotRetryable(HttpStatus.fromCode(e.getHttpStatus()))) {
                        z = true;
                        break;
                    }
                    splitTaskExecutionStatus2 = splitTaskExecutionStatus;
                    if (arrayList.size() > 0) {
                        this.mStorage.setActive(arrayList);
                    }
                    if (splitTaskExecutionStatus == SplitTaskExecutionStatus.ERROR) {
                        map = new HashMap();
                        map.put(SplitTaskExecutionInfo.NON_SENT_RECORDS, Integer.valueOf(elementsPerPush));
                        map.put(SplitTaskExecutionInfo.NON_SENT_BYTES, Long.valueOf(jSumImpressionsBytes));
                        if (z) {
                            map.put(SplitTaskExecutionInfo.DO_NOT_RETRY, true);
                        }
                        return SplitTaskExecutionInfo.error(SplitTaskType.UNIQUE_KEYS_RECORDER_TASK, map);
                    }
                    return SplitTaskExecutionInfo.success(SplitTaskType.UNIQUE_KEYS_RECORDER_TASK);
                }
            }
            if (listPop.size() != this.mConfig.getElementsPerPush()) {
                splitTaskExecutionStatus = splitTaskExecutionStatus2;
                break;
            }
        }
        if (arrayList.size() > 0) {
            this.mStorage.setActive(arrayList);
        }
        if (splitTaskExecutionStatus == SplitTaskExecutionStatus.ERROR) {
            map = new HashMap();
            map.put(SplitTaskExecutionInfo.NON_SENT_RECORDS, Integer.valueOf(elementsPerPush));
            map.put(SplitTaskExecutionInfo.NON_SENT_BYTES, Long.valueOf(jSumImpressionsBytes));
            if (z) {
                map.put(SplitTaskExecutionInfo.DO_NOT_RETRY, true);
            }
            return SplitTaskExecutionInfo.error(SplitTaskType.UNIQUE_KEYS_RECORDER_TASK, map);
        }
        return SplitTaskExecutionInfo.success(SplitTaskType.UNIQUE_KEYS_RECORDER_TASK);
    }

    private static MTK buildMTK(List<UniqueKey> keys) {
        HashMap map = new HashMap();
        for (UniqueKey uniqueKey : keys) {
            String key = uniqueKey.getKey();
            if (!map.containsKey(key)) {
                map.put(key, new UniqueKey(key, new HashSet()));
            }
            UniqueKey uniqueKey2 = (UniqueKey) map.get(key);
            if (uniqueKey2 != null) {
                Set<String> features = uniqueKey2.getFeatures();
                Set<String> features2 = uniqueKey.getFeatures();
                features2.addAll(features);
                map.put(key, new UniqueKey(key, features2));
            }
        }
        return new MTK(new ArrayList(map.values()));
    }

    private long sumImpressionsBytes(List<UniqueKey> keys) {
        long estimatedSizeInBytes = 0;
        for (UniqueKey uniqueKey : keys) {
            estimatedSizeInBytes += this.mConfig.getEstimatedSizeInBytes();
        }
        return estimatedSizeInBytes;
    }
}
