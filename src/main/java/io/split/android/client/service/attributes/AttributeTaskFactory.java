package io.split.android.client.service.attributes;

import io.split.android.client.storage.attributes.PersistentAttributesStorage;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public interface AttributeTaskFactory {
    ClearAttributesInPersistentStorageTask createAttributeClearTask(PersistentAttributesStorage persistentAttributesStorage);

    UpdateAttributesInPersistentStorageTask createAttributeUpdateTask(PersistentAttributesStorage persistentAttributesStorage, Map<String, Object> attributes);

    LoadAttributesTask createLoadAttributesTask(PersistentAttributesStorage persistentAttributesStorage);
}
