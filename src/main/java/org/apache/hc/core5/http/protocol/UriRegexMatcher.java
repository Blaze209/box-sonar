package org.apache.hc.core5.http.protocol;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Pattern;
import org.apache.hc.core5.util.Args;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class UriRegexMatcher<T> implements LookupRegistry<T> {
    private final Map<String, T> objectMap = new LinkedHashMap();
    private final Map<String, Pattern> patternMap = new LinkedHashMap();
    private final ReentrantLock lock = new ReentrantLock();

    @Override // org.apache.hc.core5.http.protocol.LookupRegistry
    public void register(String str, T t) {
        this.lock.lock();
        try {
            Args.notNull(str, "URI request regex");
            this.objectMap.put(str, t);
            this.patternMap.put(str, Pattern.compile(str));
        } finally {
            this.lock.unlock();
        }
    }

    @Override // org.apache.hc.core5.http.protocol.LookupRegistry
    public void unregister(String str) {
        this.lock.lock();
        if (str != null) {
            try {
                this.objectMap.remove(str);
                this.patternMap.remove(str);
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
            T t = this.objectMap.get(str);
            if (t == null) {
                for (Map.Entry<String, Pattern> entry : this.patternMap.entrySet()) {
                    if (entry.getValue().matcher(str).matches()) {
                        return this.objectMap.get(entry.getKey());
                    }
                }
            }
            return t;
        } finally {
            this.lock.unlock();
        }
    }

    public String toString() {
        return this.objectMap.toString();
    }
}
