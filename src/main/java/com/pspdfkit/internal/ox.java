package com.pspdfkit.internal;

import com.pspdfkit.internal.nx;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class ox<K, V extends nx> extends HashMap<K, V> {
    public final V a(K k, V v) {
        v.getClass();
        V v2 = (V) super.put(k, v);
        if (v2 != null) {
            v2.recycle();
        }
        return v2;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final void clear() {
        Collection<V> collectionValues = super.values();
        collectionValues.getClass();
        Iterator<T> it = collectionValues.iterator();
        while (it.hasNext()) {
            ((nx) it.next()).recycle();
        }
        super.clear();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsValue(Object obj) {
        if (obj instanceof nx) {
            return super.containsValue((nx) obj);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final Object put(Object obj, Object obj2) {
        nx nxVar = (nx) obj2;
        nxVar.getClass();
        nx nxVar2 = (nx) super.put(obj, nxVar);
        if (nxVar2 != null) {
            nxVar2.recycle();
        }
        return nxVar2;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final void putAll(Map<? extends K, ? extends V> map) {
        map.getClass();
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            K key = entry.getKey();
            V value = entry.getValue();
            value.getClass();
            nx nxVar = (nx) super.put(key, value);
            if (nxVar != null) {
                nxVar.recycle();
            }
        }
    }

    @Override // java.util.HashMap, java.util.Map
    public final /* bridge */ boolean remove(Object obj, Object obj2) {
        if (obj2 instanceof nx) {
            return super.remove(obj, (nx) obj2);
        }
        return false;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        nx nxVar = (nx) super.remove(obj);
        if (nxVar != null) {
            nxVar.recycle();
        }
        return nxVar;
    }
}
