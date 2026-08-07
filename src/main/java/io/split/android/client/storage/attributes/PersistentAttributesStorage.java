package io.split.android.client.storage.attributes;

import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public interface PersistentAttributesStorage {
    void clear(String matchingKey);

    Map<String, Object> getAll(String matchingKey);

    void set(String matchingKey, Map<String, Object> attributes);
}
