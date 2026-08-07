package io.split.android.client.storage.attributes;

import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public interface AttributesStorageContainer {
    void destroy();

    Map<String, AttributesStorage> getCurrentStorages();

    AttributesStorage getStorageForKey(String matchingKey);
}
