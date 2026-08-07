package org.apache.hc.core5.http.config;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.hc.core5.util.TextUtils;

/* JADX INFO: loaded from: classes5.dex */
public final class Registry<I> implements Lookup<I> {
    private final Map<String, I> map;

    Registry(Map<String, I> map) {
        this.map = new ConcurrentHashMap(map);
    }

    @Override // org.apache.hc.core5.http.config.Lookup
    public I lookup(String str) {
        if (str == null) {
            return null;
        }
        return this.map.get(TextUtils.toLowerCase(str));
    }

    public String toString() {
        return this.map.toString();
    }
}
