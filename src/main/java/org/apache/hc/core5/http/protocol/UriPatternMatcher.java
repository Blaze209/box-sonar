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
public class UriPatternMatcher<T> implements LookupRegistry<T> {
    private final Map<String, T> map = new LinkedHashMap();
    private final ReentrantLock lock = new ReentrantLock();

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
        this.lock.lock();
        try {
            Args.notNull(str, "Request path");
            T t = this.map.get(str);
            if (t == null) {
                String str2 = null;
                for (String str3 : this.map.keySet()) {
                    if (matchUriRequestPattern(str3, str) && (str2 == null || str2.length() < str3.length() || (str2.length() == str3.length() && str3.endsWith("*")))) {
                        t = this.map.get(str3);
                        str2 = str3;
                    }
                }
            }
            return t;
        } finally {
            this.lock.unlock();
        }
    }

    protected boolean matchUriRequestPattern(String str, String str2) {
        return PathPatternMatcher.INSTANCE.match(str, str2);
    }

    public String toString() {
        return this.map.toString();
    }
}
