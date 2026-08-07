package io.split.android.client.service.attributes;

import io.split.android.client.service.executor.SplitTask;
import io.split.android.client.service.executor.SplitTaskExecutionInfo;
import io.split.android.client.service.executor.SplitTaskType;
import io.split.android.client.storage.attributes.PersistentAttributesStorage;
import io.split.android.client.utils.Utils;

/* JADX INFO: loaded from: classes4.dex */
public class ClearAttributesInPersistentStorageTask implements SplitTask {
    private final String mMatchingKey;
    private final PersistentAttributesStorage mPersistentAttributesStorage;

    public ClearAttributesInPersistentStorageTask(String matchingKey, PersistentAttributesStorage persistentAttributesStorage) {
        this.mMatchingKey = (String) Utils.checkNotNull(matchingKey);
        this.mPersistentAttributesStorage = (PersistentAttributesStorage) Utils.checkNotNull(persistentAttributesStorage);
    }

    @Override // io.split.android.client.service.executor.SplitTask
    public SplitTaskExecutionInfo execute() {
        this.mPersistentAttributesStorage.clear(this.mMatchingKey);
        return SplitTaskExecutionInfo.success(SplitTaskType.GENERIC_TASK);
    }
}
