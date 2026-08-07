package io.split.android.client.service.attributes;

import io.split.android.client.service.executor.SplitTask;
import io.split.android.client.service.executor.SplitTaskExecutionInfo;
import io.split.android.client.service.executor.SplitTaskType;
import io.split.android.client.storage.attributes.PersistentAttributesStorage;
import io.split.android.client.utils.Utils;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class UpdateAttributesInPersistentStorageTask implements SplitTask {
    private final Map<String, Object> mAttributes;
    private final String mMatchingKey;
    private final PersistentAttributesStorage mPersistentAttributesStorage;

    public UpdateAttributesInPersistentStorageTask(String matchingKey, PersistentAttributesStorage persistentAttributesStorage, Map<String, Object> attributes) {
        this.mMatchingKey = (String) Utils.checkNotNull(matchingKey);
        this.mPersistentAttributesStorage = (PersistentAttributesStorage) Utils.checkNotNull(persistentAttributesStorage);
        this.mAttributes = (Map) Utils.checkNotNull(attributes);
    }

    @Override // io.split.android.client.service.executor.SplitTask
    public SplitTaskExecutionInfo execute() {
        this.mPersistentAttributesStorage.set(this.mMatchingKey, this.mAttributes);
        return SplitTaskExecutionInfo.success(SplitTaskType.GENERIC_TASK);
    }
}
