package sdk.pendo.io.x1;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class d<T> implements Iterable<b<?>> {
    private final List<b<?>> a;
    private final T b;
    private final T c;
    private final k d;

    d(T t, T t2, List<b<?>> list, k kVar) {
        sdk.pendo.io.w1.h.a(t, "lhs", new Object[0]);
        sdk.pendo.io.w1.h.a(t2, "rhs", new Object[0]);
        sdk.pendo.io.w1.h.a(list, "diffList", new Object[0]);
        this.a = list;
        this.b = t;
        this.c = t2;
        if (kVar == null) {
            this.d = k.u;
        } else {
            this.d = kVar;
        }
    }

    public List<b<?>> a() {
        return Collections.unmodifiableList(this.a);
    }

    public int b() {
        return this.a.size();
    }

    @Override // java.lang.Iterable
    public Iterator<b<?>> iterator() {
        return this.a.iterator();
    }

    public String toString() {
        return a(this.d);
    }

    public String a(k kVar) {
        if (this.a.isEmpty()) {
            return "";
        }
        j jVar = new j(this.b, kVar);
        j jVar2 = new j(this.c, kVar);
        for (b<?> bVar : this.a) {
            jVar.a(bVar.c(), bVar.a());
            jVar2.a(bVar.c(), bVar.b());
        }
        return String.format("%s %s %s", jVar.a(), "differs from", jVar2.a());
    }
}
