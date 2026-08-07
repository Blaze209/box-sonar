package io.split.android.client.service.attributes;

import io.split.android.client.service.executor.SplitTask;
import io.split.android.client.service.executor.SplitTaskExecutionInfo;
import io.split.android.client.service.executor.SplitTaskType;
import io.split.android.client.storage.attributes.AttributesStorage;
import io.split.android.client.storage.attributes.PersistentAttributesStorage;
import io.split.android.client.utils.Utils;

/* JADX INFO: loaded from: classes4.dex */
public class LoadAttributesTask implements SplitTask {
    private final AttributesStorage mAttributesStorage;
    private final String mMatchingKey;
    private final PersistentAttributesStorage mPersistentAttributesStorage;

    public LoadAttributesTask(String matchingKey, AttributesStorage attributesStorage, PersistentAttributesStorage persistentAttributesStorage) {
        this.mMatchingKey = (String) Utils.checkNotNull(matchingKey);
        this.mAttributesStorage = attributesStorage;
        this.mPersistentAttributesStorage = persistentAttributesStorage;
    }

    @Override // io.split.android.client.service.executor.SplitTask
    public SplitTaskExecutionInfo execute() {
        AttributesStorage attributesStorage;
        PersistentAttributesStorage persistentAttributesStorage = this.mPersistentAttributesStorage;
        if (persistentAttributesStorage != null && (attributesStorage = this.mAttributesStorage) != null) {
            attributesStorage.set(persistentAttributesStorage.getAll(this.mMatchingKey));
        }
        return SplitTaskExecutionInfo.success(SplitTaskType.LOAD_LOCAL_ATTRIBUTES);
    }
}
