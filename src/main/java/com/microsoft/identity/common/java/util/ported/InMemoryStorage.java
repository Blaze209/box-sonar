package com.microsoft.identity.common.java.util.ported;

import com.microsoft.identity.common.java.interfaces.INameValueStorage;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes14.dex */
public class InMemoryStorage<T> implements INameValueStorage<T> {
    private final Map<String, T> mMap = new ConcurrentHashMap();

    @Override // com.microsoft.identity.common.java.interfaces.INameValueStorage
    public T get(String str) {
        if (str == null) {
            throw new NullPointerException("key is marked non-null but is null");
        }
        return this.mMap.get(str);
    }

    @Override // com.microsoft.identity.common.java.interfaces.INameValueStorage
    public Map<String, T> getAll() {
        return this.mMap;
    }

    @Override // com.microsoft.identity.common.java.interfaces.INameValueStorage
    public void put(String str, T t) {
        if (str == null) {
            throw new NullPointerException("key is marked non-null but is null");
        }
        if (t == null) {
            this.mMap.remove(str);
        } else {
            this.mMap.put(str, t);
        }
    }

    @Override // com.microsoft.identity.common.java.interfaces.INameValueStorage
    public void remove(String str) {
        if (str == null) {
            throw new NullPointerException("name is marked non-null but is null");
        }
        this.mMap.remove(str);
    }

    @Override // com.microsoft.identity.common.java.interfaces.INameValueStorage
    public void clear() {
        this.mMap.clear();
    }

    @Override // com.microsoft.identity.common.java.interfaces.INameValueStorage
    public Set<String> keySet() {
        return this.mMap.keySet();
    }

    @Override // com.microsoft.identity.common.java.interfaces.INameValueStorage
    public Iterator<Map.Entry<String, T>> getAllFilteredByKey(Predicate<String> predicate) {
        HashMap map = new HashMap();
        for (Map.Entry<String, T> entry : this.mMap.entrySet()) {
            if (predicate.test(entry.getKey())) {
                map.put(entry.getKey(), entry.getValue());
            }
        }
        return map.entrySet().iterator();
    }

    public int size() {
        return this.mMap.size();
    }
}
