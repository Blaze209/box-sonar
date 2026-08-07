package org.tinylog.provider;

import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public interface ContextProvider {
    void clear();

    String get(String str);

    Map<String, String> getMapping();

    void put(String str, Object obj);

    void remove(String str);
}
