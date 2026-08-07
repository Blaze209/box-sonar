package io.split.android.client.storage.attributes;

import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public interface AttributesStorage {
    void clear();

    void destroy();

    Object get(String name);

    Map<String, Object> getAll();

    void remove(String name);

    void set(String name, Object value);

    void set(Map<String, Object> attributes);
}
