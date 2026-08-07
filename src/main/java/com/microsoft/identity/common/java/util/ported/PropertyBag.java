package com.microsoft.identity.common.java.util.ported;

import com.microsoft.identity.common.java.interfaces.INameValueStorage;
import java.io.Serializable;
import java.util.Set;

/* JADX INFO: loaded from: classes14.dex */
public class PropertyBag {
    private final INameValueStorage<Object> mMap = new InMemoryStorage();

    public <T extends Serializable> void put(String str, T t) {
        if (str == null) {
            throw new NullPointerException("name is marked non-null but is null");
        }
        this.mMap.put(str, t);
    }

    public <T extends Serializable> T get(String str) {
        if (str == null) {
            throw new NullPointerException("name is marked non-null but is null");
        }
        return (T) getOrDefaultInternal(str, null);
    }

    public <T extends Serializable> T getOrDefault(String str, T t) {
        if (str == null) {
            throw new NullPointerException("name is marked non-null but is null");
        }
        if (t == null) {
            throw new NullPointerException("defaultValue is marked non-null but is null");
        }
        return (T) getOrDefaultInternal(str, t);
    }

    private <T extends Serializable> T getOrDefaultInternal(String str, T t) {
        if (str == null) {
            throw new NullPointerException("name is marked non-null but is null");
        }
        Object obj = this.mMap.get(str);
        if (obj == null) {
            return t;
        }
        try {
            return (T) obj;
        } catch (ClassCastException unused) {
            return t;
        }
    }

    public Set<String> keySet() {
        return this.mMap.keySet();
    }
}
