package org.tinylog.provider;

import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public final class NopContextProvider implements ContextProvider {
    @Override // org.tinylog.provider.ContextProvider
    public void clear() {
    }

    @Override // org.tinylog.provider.ContextProvider
    public String get(String str) {
        return null;
    }

    @Override // org.tinylog.provider.ContextProvider
    public void put(String str, Object obj) {
    }

    @Override // org.tinylog.provider.ContextProvider
    public void remove(String str) {
    }

    @Override // org.tinylog.provider.ContextProvider
    public Map<String, String> getMapping() {
        return Collections.emptyMap();
    }
}
