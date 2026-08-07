package sdk.pendo.io.a0;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class f extends i implements Iterable<i> {
    private final List<i> a = new ArrayList();

    public void a(i iVar) {
        if (iVar == null) {
            iVar = k.a;
        }
        this.a.add(iVar);
    }

    @Override // sdk.pendo.io.a0.i
    public float b() {
        if (this.a.size() == 1) {
            return this.a.get(0).b();
        }
        throw new IllegalStateException();
    }

    @Override // sdk.pendo.io.a0.i
    public int c() {
        if (this.a.size() == 1) {
            return this.a.get(0).c();
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object obj) {
        if (obj != this) {
            return (obj instanceof f) && ((f) obj).a.equals(this.a);
        }
        return true;
    }

    @Override // sdk.pendo.io.a0.i
    public String g() {
        if (this.a.size() == 1) {
            return this.a.get(0).g();
        }
        throw new IllegalStateException();
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    @Override // java.lang.Iterable
    public Iterator<i> iterator() {
        return this.a.iterator();
    }

    public int size() {
        return this.a.size();
    }

    public i a(int i) {
        return this.a.get(i);
    }

    @Override // sdk.pendo.io.a0.i
    public boolean a() {
        if (this.a.size() == 1) {
            return this.a.get(0).a();
        }
        throw new IllegalStateException();
    }
}
