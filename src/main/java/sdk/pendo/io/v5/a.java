package sdk.pendo.io.v5;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
public final class a<K, V> extends AbstractMap<K, V> {
    private HashMap<K, a<K, V>.C0502a<V>> a;
    private ReferenceQueue<V> b;

    /* JADX INFO: renamed from: sdk.pendo.io.v5.a$a, reason: collision with other inner class name */
    private class C0502a<T> extends WeakReference<T> {
        private final K a;

        private C0502a(K k, T t, ReferenceQueue<T> referenceQueue) {
            super(t, referenceQueue);
            this.a = k;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public K a() {
            return this.a;
        }
    }

    public a() {
        this(16);
    }

    private V a(a<K, V>.C0502a<V> c0502a) {
        if (c0502a == null) {
            return null;
        }
        return c0502a.get();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.a.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        a();
        return this.a.containsKey(obj);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        a();
        Iterator<Map.Entry<K, a<K, V>.C0502a<V>>> it = this.a.entrySet().iterator();
        while (it.hasNext()) {
            if (obj == a(it.next().getValue())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        a();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Map.Entry<K, a<K, V>.C0502a<V>> entry : this.a.entrySet()) {
            linkedHashSet.add(new AbstractMap.SimpleEntry(entry.getKey(), a(entry.getValue())));
        }
        return linkedHashSet;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        a();
        return a(this.a.get(obj));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        a();
        return this.a.keySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k, V v) {
        a();
        return a(this.a.put(k, new C0502a<>(k, v, this.b)));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        return a(this.a.remove(obj));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        a();
        return this.a.size();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        a();
        ArrayList arrayList = new ArrayList();
        Iterator<a<K, V>.C0502a<V>> it = this.a.values().iterator();
        while (it.hasNext()) {
            arrayList.add(a(it.next()));
        }
        return arrayList;
    }

    public a(int i) {
        this.a = new HashMap<>(i);
        this.b = new ReferenceQueue<>();
    }

    private void a() {
        while (true) {
            C0502a c0502a = (C0502a) this.b.poll();
            if (c0502a == null) {
                return;
            } else {
                this.a.remove(c0502a.a());
            }
        }
    }
}
