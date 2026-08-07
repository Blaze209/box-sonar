package sdk.pendo.io.c0;

import com.j256.ormlite.stmt.query.SimpleComparison;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public final class g<K, V> extends AbstractMap<K, V> implements Serializable {
    private static final Comparator<Comparable> h = new a();
    static final /* synthetic */ boolean i = true;
    Comparator<? super K> a;
    e<K, V> b;
    int c;
    int d;
    final e<K, V> e;
    private g<K, V>.b f;
    private g<K, V>.c g;

    class a implements Comparator<Comparable> {
        a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    }

    class b extends AbstractSet<Map.Entry<K, V>> {

        class a extends g<K, V>.d<Map.Entry<K, V>> {
            a() {
                super();
            }

            @Override // java.util.Iterator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Map.Entry<K, V> next() {
                return a();
            }
        }

        b() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            g.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return (obj instanceof Map.Entry) && g.this.a((Map.Entry<?, ?>) obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            e<K, V> eVarA;
            if (!(obj instanceof Map.Entry) || (eVarA = g.this.a((Map.Entry<?, ?>) obj)) == null) {
                return false;
            }
            g.this.b(eVarA, true);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return g.this.c;
        }
    }

    final class c extends AbstractSet<K> {

        class a extends g<K, V>.d<K> {
            a() {
                super();
            }

            @Override // java.util.Iterator
            public K next() {
                return a().f;
            }
        }

        c() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            g.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return g.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return g.this.b(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return g.this.c;
        }
    }

    private abstract class d<T> implements Iterator<T> {
        e<K, V> a;
        e<K, V> b = null;
        int c;

        d() {
            this.a = g.this.e.d;
            this.c = g.this.d;
        }

        final e<K, V> a() {
            e<K, V> eVar = this.a;
            g gVar = g.this;
            if (eVar == gVar.e) {
                throw new NoSuchElementException();
            }
            if (gVar.d != this.c) {
                throw new ConcurrentModificationException();
            }
            this.a = eVar.d;
            this.b = eVar;
            return eVar;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.a != g.this.e;
        }

        @Override // java.util.Iterator
        public final void remove() {
            e<K, V> eVar = this.b;
            if (eVar == null) {
                throw new IllegalStateException();
            }
            g.this.b(eVar, true);
            this.b = null;
            this.c = g.this.d;
        }
    }

    static final class e<K, V> implements Map.Entry<K, V> {
        e<K, V> a;
        e<K, V> b;
        e<K, V> c;
        e<K, V> d;
        e<K, V> e;
        final K f;
        V g;
        int h;

        e() {
            this.f = null;
            this.e = this;
            this.d = this;
        }

        public e<K, V> a() {
            e<K, V> eVar;
            do {
                eVar = this;
                this = this.b;
            } while (this != null);
            return eVar;
        }

        public e<K, V> b() {
            e<K, V> eVar;
            do {
                eVar = this;
                this = this.c;
            } while (this != null);
            return eVar;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                K k = this.f;
                if (k != null ? k.equals(entry.getKey()) : entry.getKey() == null) {
                    V v = this.g;
                    if (v == null) {
                        if (entry.getValue() == null) {
                            return true;
                        }
                    } else if (v.equals(entry.getValue())) {
                        return true;
                    }
                }
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.g;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K k = this.f;
            int iHashCode = k == null ? 0 : k.hashCode();
            V v = this.g;
            return iHashCode ^ (v != null ? v.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            V v2 = this.g;
            this.g = v;
            return v2;
        }

        public String toString() {
            return this.f + SimpleComparison.EQUAL_TO_OPERATION + this.g;
        }

        e(e<K, V> eVar, K k, e<K, V> eVar2, e<K, V> eVar3) {
            this.a = eVar;
            this.f = k;
            this.h = 1;
            this.d = eVar2;
            this.e = eVar3;
            eVar3.d = this;
            eVar2.e = this;
        }
    }

    public g() {
        this(h);
    }

    private boolean a(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    void b(e<K, V> eVar, boolean z) {
        int i2;
        if (z) {
            e<K, V> eVar2 = eVar.e;
            eVar2.d = eVar.d;
            eVar.d.e = eVar2;
        }
        e<K, V> eVar3 = eVar.b;
        e<K, V> eVar4 = eVar.c;
        e<K, V> eVar5 = eVar.a;
        int i3 = 0;
        if (eVar3 == null || eVar4 == null) {
            if (eVar3 != null) {
                a((e) eVar, (e) eVar3);
                eVar.b = null;
            } else if (eVar4 != null) {
                a((e) eVar, (e) eVar4);
                eVar.c = null;
            } else {
                a((e) eVar, (e) null);
            }
            a((e) eVar5, false);
            this.c--;
            this.d++;
            return;
        }
        e<K, V> eVarB = eVar3.h > eVar4.h ? eVar3.b() : eVar4.a();
        b(eVarB, false);
        e<K, V> eVar6 = eVar.b;
        if (eVar6 != null) {
            i2 = eVar6.h;
            eVarB.b = eVar6;
            eVar6.a = eVarB;
            eVar.b = null;
        } else {
            i2 = 0;
        }
        e<K, V> eVar7 = eVar.c;
        if (eVar7 != null) {
            i3 = eVar7.h;
            eVarB.c = eVar7;
            eVar7.a = eVarB;
            eVar.c = null;
        }
        eVarB.h = Math.max(i2, i3) + 1;
        a((e) eVar, (e) eVarB);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.b = null;
        this.c = 0;
        this.d++;
        e<K, V> eVar = this.e;
        eVar.e = eVar;
        eVar.d = eVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return a(obj) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        g<K, V>.b bVar = this.f;
        if (bVar != null) {
            return bVar;
        }
        g<K, V>.b bVar2 = new b();
        this.f = bVar2;
        return bVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        e<K, V> eVarA = a(obj);
        if (eVarA != null) {
            return eVarA.g;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        g<K, V>.c cVar = this.g;
        if (cVar != null) {
            return cVar;
        }
        g<K, V>.c cVar2 = new c();
        this.g = cVar2;
        return cVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k, V v) {
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        e<K, V> eVarA = a((Object) k, true);
        V v2 = eVarA.g;
        eVarA.g = v;
        return v2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        e<K, V> eVarB = b(obj);
        if (eVarB != null) {
            return eVarB.g;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.c;
    }

    public g(Comparator<? super K> comparator) {
        this.c = 0;
        this.d = 0;
        this.e = new e<>();
        this.a = comparator == null ? h : comparator;
    }

    e<K, V> a(K k, boolean z) {
        int iCompareTo;
        e<K, V> eVar;
        Comparator<? super K> comparator = this.a;
        e<K, V> eVar2 = this.b;
        if (eVar2 != null) {
            Comparable comparable = comparator == h ? (Comparable) k : null;
            while (true) {
                K k2 = eVar2.f;
                iCompareTo = comparable != null ? comparable.compareTo(k2) : comparator.compare(k, k2);
                if (iCompareTo == 0) {
                    return eVar2;
                }
                e<K, V> eVar3 = iCompareTo < 0 ? eVar2.b : eVar2.c;
                if (eVar3 == null) {
                    break;
                }
                eVar2 = eVar3;
            }
        } else {
            iCompareTo = 0;
        }
        if (!z) {
            return null;
        }
        e<K, V> eVar4 = this.e;
        if (eVar2 != null) {
            eVar = new e<>(eVar2, k, eVar4, eVar4.e);
            if (iCompareTo < 0) {
                eVar2.b = eVar;
            } else {
                eVar2.c = eVar;
            }
            a((e) eVar2, true);
        } else {
            if (comparator == h && !(k instanceof Comparable)) {
                throw new ClassCastException(k.getClass().getName() + " is not Comparable");
            }
            eVar = new e<>(eVar2, k, eVar4, eVar4.e);
            this.b = eVar;
        }
        this.c++;
        this.d++;
        return eVar;
    }

    e<K, V> b(Object obj) {
        e<K, V> eVarA = a(obj);
        if (eVarA != null) {
            b(eVarA, true);
        }
        return eVarA;
    }

    private void b(e<K, V> eVar) {
        e<K, V> eVar2 = eVar.b;
        e<K, V> eVar3 = eVar.c;
        e<K, V> eVar4 = eVar2.b;
        e<K, V> eVar5 = eVar2.c;
        eVar.b = eVar5;
        if (eVar5 != null) {
            eVar5.a = eVar;
        }
        a((e) eVar, (e) eVar2);
        eVar2.c = eVar;
        eVar.a = eVar2;
        int iMax = Math.max(eVar3 != null ? eVar3.h : 0, eVar5 != null ? eVar5.h : 0) + 1;
        eVar.h = iMax;
        eVar2.h = Math.max(iMax, eVar4 != null ? eVar4.h : 0) + 1;
    }

    e<K, V> a(Map.Entry<?, ?> entry) {
        e<K, V> eVarA = a(entry.getKey());
        if (eVarA == null || !a(eVarA.g, entry.getValue())) {
            return null;
        }
        return eVarA;
    }

    /* JADX WARN: Multi-variable type inference failed */
    e<K, V> a(Object obj) {
        if (obj != 0) {
            try {
                return a(obj, false);
            } catch (ClassCastException unused) {
            }
        }
        return null;
    }

    private void a(e<K, V> eVar, boolean z) {
        while (eVar != null) {
            e<K, V> eVar2 = eVar.b;
            e<K, V> eVar3 = eVar.c;
            int i2 = eVar2 != null ? eVar2.h : 0;
            int i3 = eVar3 != null ? eVar3.h : 0;
            int i4 = i2 - i3;
            if (i4 == -2) {
                e<K, V> eVar4 = eVar3.b;
                e<K, V> eVar5 = eVar3.c;
                int i5 = (eVar4 != null ? eVar4.h : 0) - (eVar5 != null ? eVar5.h : 0);
                if (i5 != -1 && (i5 != 0 || z)) {
                    if (!i && i5 != 1) {
                        throw new AssertionError();
                    }
                    b((e) eVar3);
                }
                a((e) eVar);
                if (z) {
                    return;
                }
            } else if (i4 == 2) {
                e<K, V> eVar6 = eVar2.b;
                e<K, V> eVar7 = eVar2.c;
                int i6 = (eVar6 != null ? eVar6.h : 0) - (eVar7 != null ? eVar7.h : 0);
                if (i6 != 1 && (i6 != 0 || z)) {
                    if (!i && i6 != -1) {
                        throw new AssertionError();
                    }
                    a((e) eVar2);
                }
                b((e) eVar);
                if (z) {
                    return;
                }
            } else if (i4 == 0) {
                eVar.h = i2 + 1;
                if (z) {
                    return;
                }
            } else {
                if (!i && i4 != -1 && i4 != 1) {
                    throw new AssertionError();
                }
                eVar.h = Math.max(i2, i3) + 1;
                if (!z) {
                    return;
                }
            }
            eVar = eVar.a;
        }
    }

    private void a(e<K, V> eVar, e<K, V> eVar2) {
        e<K, V> eVar3 = eVar.a;
        eVar.a = null;
        if (eVar2 != null) {
            eVar2.a = eVar3;
        }
        if (eVar3 == null) {
            this.b = eVar2;
            return;
        }
        if (eVar3.b == eVar) {
            eVar3.b = eVar2;
        } else {
            if (!i && eVar3.c != eVar) {
                throw new AssertionError();
            }
            eVar3.c = eVar2;
        }
    }

    private void a(e<K, V> eVar) {
        e<K, V> eVar2 = eVar.b;
        e<K, V> eVar3 = eVar.c;
        e<K, V> eVar4 = eVar3.b;
        e<K, V> eVar5 = eVar3.c;
        eVar.c = eVar4;
        if (eVar4 != null) {
            eVar4.a = eVar;
        }
        a((e) eVar, (e) eVar3);
        eVar3.b = eVar;
        eVar.a = eVar3;
        int iMax = Math.max(eVar2 != null ? eVar2.h : 0, eVar4 != null ? eVar4.h : 0) + 1;
        eVar.h = iMax;
        eVar3.h = Math.max(iMax, eVar5 != null ? eVar5.h : 0) + 1;
    }
}
