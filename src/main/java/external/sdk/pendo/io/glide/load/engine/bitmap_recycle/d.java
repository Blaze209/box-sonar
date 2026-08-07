package external.sdk.pendo.io.glide.load.engine.bitmap_recycle;

import external.sdk.pendo.io.glide.load.engine.bitmap_recycle.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes4.dex */
class d<K extends f, V> {
    private final a<K, V> a = new a<>();
    private final Map<K, a<K, V>> b = new HashMap();

    private static class a<K, V> {
        final K a;
        private List<V> b;
        a<K, V> c;
        a<K, V> d;

        a() {
            this(null);
        }

        public void a(V v) {
            if (this.b == null) {
                this.b = new ArrayList();
            }
            this.b.add(v);
        }

        public int b() {
            List<V> list = this.b;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        a(K k) {
            this.d = this;
            this.c = this;
            this.a = k;
        }

        public V a() {
            int iB = b();
            if (iB > 0) {
                return this.b.remove(iB - 1);
            }
            return null;
        }
    }

    d() {
    }

    private void b(a<K, V> aVar) {
        c(aVar);
        a<K, V> aVar2 = this.a;
        aVar.d = aVar2.d;
        aVar.c = aVar2;
        d(aVar);
    }

    private static <K, V> void c(a<K, V> aVar) {
        a<K, V> aVar2 = aVar.d;
        aVar2.c = aVar.c;
        aVar.c.d = aVar2;
    }

    private static <K, V> void d(a<K, V> aVar) {
        aVar.c.d = aVar;
        aVar.d.c = aVar;
    }

    public V a(K k) {
        a<K, V> aVar = this.b.get(k);
        if (aVar == null) {
            aVar = new a<>(k);
            this.b.put(k, aVar);
        } else {
            k.a();
        }
        a(aVar);
        return aVar.a();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GroupedLinkedMap( ");
        a aVar = this.a.c;
        boolean z = false;
        while (!aVar.equals(this.a)) {
            sb.append(AbstractJsonLexerKt.BEGIN_OBJ).append(aVar.a).append(AbstractJsonLexerKt.COLON).append(aVar.b()).append("}, ");
            aVar = aVar.c;
            z = true;
        }
        if (z) {
            sb.delete(sb.length() - 2, sb.length());
        }
        return sb.append(" )").toString();
    }

    private void a(a<K, V> aVar) {
        c(aVar);
        a<K, V> aVar2 = this.a;
        aVar.d = aVar2;
        aVar.c = aVar2.c;
        d(aVar);
    }

    public void a(K k, V v) {
        a<K, V> aVar = this.b.get(k);
        if (aVar == null) {
            aVar = new a<>(k);
            b(aVar);
            this.b.put(k, aVar);
        } else {
            k.a();
        }
        aVar.a(v);
    }

    public V a() {
        a aVar = this.a;
        while (true) {
            aVar = aVar.d;
            if (aVar.equals(this.a)) {
                return null;
            }
            V v = (V) aVar.a();
            if (v != null) {
                return v;
            }
            c(aVar);
            this.b.remove(aVar.a);
            ((f) aVar.a).a();
        }
    }
}
