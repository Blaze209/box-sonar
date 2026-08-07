package org.apache.hc.core5.http.protocol;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
import org.apache.hc.core5.http.impl.routing.PathPatternMatcher;
import org.apache.hc.core5.util.Args;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class UriPatternOrderedMatcher<T> implements LookupRegistry<T> {
    private final ReentrantLock lock = new ReentrantLock();
    private final Map<String, T> map = new LinkedHashMap();

    public Set<Map.Entry<String, T>> entrySet() {
        this.lock.lock();
        try {
            return new HashSet(this.map.entrySet());
        } finally {
            this.lock.unlock();
        }
    }

    @Override // org.apache.hc.core5.http.protocol.LookupRegistry
    public void register(String str, T t) {
        this.lock.lock();
        try {
            Args.notNull(str, "URI request pattern");
            this.map.put(str, t);
        } finally {
            this.lock.unlock();
        }
    }

    @Override // org.apache.hc.core5.http.protocol.LookupRegistry
    public void unregister(String str) {
        this.lock.lock();
        if (str != null) {
            try {
                this.map.remove(str);
            } finally {
                this.lock.unlock();
            }
        }
    }

    @Override // org.apache.hc.core5.http.protocol.LookupRegistry
    public T lookup(String str) {
        T value;
        this.lock.lock();
        try {
            Args.notNull(str, "Request path");
            for (Map.Entry<String, T> entry : this.map.entrySet()) {
                String key = entry.getKey();
                if (str.equals(key)) {
                    value = entry.getValue();
                } else if (matchUriRequestPattern(key, str)) {
                    value = this.map.get(key);
                }
                this.lock.unlock();
                return value;
            }
            this.lock.unlock();
            return null;
        } catch (Throwable th) {
            this.lock.unlock();
            throw th;
        }
    }

    protected boolean matchUriRequestPattern(String str, String str2) {
        return PathPatternMatcher.INSTANCE.match(str, str2);
    }

    public String toString() {
        return this.map.toString();
    }
}
