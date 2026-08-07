package org.tinylog.core;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.tinylog.provider.ContextProvider;

/* JADX INFO: loaded from: classes5.dex */
public class TinylogContextProvider implements ContextProvider {
    private final ThreadLocal<Map<String, String>> data = new InheritableEmptyMapThreadLocal();

    @Override // org.tinylog.provider.ContextProvider
    public Map<String, String> getMapping() {
        return this.data.get();
    }

    @Override // org.tinylog.provider.ContextProvider
    public String get(String str) {
        return this.data.get().get(str);
    }

    @Override // org.tinylog.provider.ContextProvider
    public void put(String str, Object obj) {
        HashMap map = new HashMap(this.data.get());
        if (obj == null) {
            map.remove(str);
        } else {
            map.put(str, obj.toString());
        }
        this.data.set(Collections.unmodifiableMap(map));
    }

    @Override // org.tinylog.provider.ContextProvider
    public void remove(String str) {
        HashMap map = new HashMap(this.data.get());
        map.remove(str);
        this.data.set(map.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(map));
    }

    @Override // org.tinylog.provider.ContextProvider
    public void clear() {
        this.data.set(Collections.emptyMap());
    }

    private static final class InheritableEmptyMapThreadLocal<K, V> extends InheritableThreadLocal<Map<K, V>> {
        private InheritableEmptyMapThreadLocal() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public Map<K, V> initialValue() {
            return Collections.emptyMap();
        }
    }
}
