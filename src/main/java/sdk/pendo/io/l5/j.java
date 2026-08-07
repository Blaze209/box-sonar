package sdk.pendo.io.l5;

import java.util.ArrayList;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes4.dex */
public final class j {
    private static ThreadLocal<List<j>> e = new ThreadLocal<>();
    private c a;
    private h b;
    private h c;
    private boolean d;

    protected j(c cVar, h hVar, boolean z) {
        this.a = cVar;
        this.c = hVar;
        this.d = z;
        a(this);
    }

    protected static List<j> a() {
        List<j> list = e.get();
        e.remove();
        return list;
    }

    public c b() {
        return this.a;
    }

    public h c() {
        return this.b;
    }

    public h d() {
        return this.c;
    }

    public boolean e() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || j.class != obj.getClass()) {
            return false;
        }
        j jVar = (j) obj;
        return this.a.equals(jVar.a) && this.b.equals(jVar.b);
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "Transition{event=" + this.a + ", stateFrom=" + this.b + ", stateTo=" + this.c + AbstractJsonLexerKt.END_OBJ;
    }

    private static void a(j jVar) {
        List<j> arrayList = e.get();
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            e.set(arrayList);
        }
        arrayList.add(jVar);
    }

    protected void a(h hVar) {
        this.b = hVar;
    }

    public j a(j... jVarArr) {
        for (j jVar : jVarArr) {
            jVar.a(this.c);
        }
        return this;
    }
}
