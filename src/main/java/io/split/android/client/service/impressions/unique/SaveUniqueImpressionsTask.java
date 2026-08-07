package io.split.android.client.service.impressions.unique;

import io.split.android.client.service.executor.SplitTask;
import io.split.android.client.service.executor.SplitTaskExecutionInfo;
import io.split.android.client.service.executor.SplitTaskType;
import io.split.android.client.storage.impressions.PersistentImpressionsUniqueStorage;
import io.split.android.client.utils.Utils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public class SaveUniqueImpressionsTask implements SplitTask {
    private final PersistentImpressionsUniqueStorage mStorage;
    private final Map<String, Set<String>> mUniqueKeys;

    public SaveUniqueImpressionsTask(PersistentImpressionsUniqueStorage storage, Map<String, Set<String>> uniqueKeys) {
        this.mStorage = (PersistentImpressionsUniqueStorage) Utils.checkNotNull(storage);
        this.mUniqueKeys = uniqueKeys == null ? Collections.emptyMap() : uniqueKeys;
    }

    @Override // io.split.android.client.service.executor.SplitTask
    public SplitTaskExecutionInfo execute() {
        if (!this.mUniqueKeys.isEmpty()) {
            this.mStorage.pushMany(mapToModel(this.mUniqueKeys));
        }
        return SplitTaskExecutionInfo.success(SplitTaskType.SAVE_UNIQUE_KEYS_TASK);
    }

    private static List<UniqueKey> mapToModel(Map<String, Set<String>> uniqueKeysMap) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, Set<String>> entry : uniqueKeysMap.entrySet()) {
            arrayList.add(new UniqueKey(entry.getKey(), entry.getValue()));
        }
        return arrayList;
    }
}
