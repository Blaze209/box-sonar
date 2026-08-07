package io.split.android.client.service.attributes;

import io.split.android.client.storage.attributes.AttributesStorage;
import io.split.android.client.storage.attributes.PersistentAttributesStorage;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class AttributeTaskFactoryImpl implements AttributeTaskFactory {
    private final AttributesStorage mAttributesStorage;
    private final String mMatchingKey;

    public AttributeTaskFactoryImpl(String matchingKey, AttributesStorage attributesStorage) {
        this.mMatchingKey = matchingKey;
        this.mAttributesStorage = attributesStorage;
    }

    @Override // io.split.android.client.service.attributes.AttributeTaskFactory
    public UpdateAttributesInPersistentStorageTask createAttributeUpdateTask(PersistentAttributesStorage persistentAttributesStorage, Map<String, Object> attributes) {
        return new UpdateAttributesInPersistentStorageTask(this.mMatchingKey, persistentAttributesStorage, attributes);
    }

    @Override // io.split.android.client.service.attributes.AttributeTaskFactory
    public ClearAttributesInPersistentStorageTask createAttributeClearTask(PersistentAttributesStorage persistentAttributesStorage) {
        return new ClearAttributesInPersistentStorageTask(this.mMatchingKey, persistentAttributesStorage);
    }

    @Override // io.split.android.client.service.attributes.AttributeTaskFactory
    public LoadAttributesTask createLoadAttributesTask(PersistentAttributesStorage persistentAttributesStorage) {
        return new LoadAttributesTask(this.mMatchingKey, this.mAttributesStorage, persistentAttributesStorage);
    }
}
