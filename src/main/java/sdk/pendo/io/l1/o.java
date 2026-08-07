package sdk.pendo.io.l1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes4.dex */
class o extends j {
    static final /* synthetic */ boolean h = true;
    private final List<String> f;
    private final String g;

    public o(List<String> list, char c) {
        if (list.isEmpty()) {
            throw new sdk.pendo.io.d1.f("Empty properties");
        }
        this.f = list;
        this.g = Character.toString(c);
    }

    @Override // sdk.pendo.io.l1.j
    public void a(String str, sdk.pendo.io.e1.h hVar, Object obj, g gVar) {
        boolean z = h;
        if (!z && !sdk.pendo.io.e1.i.a(k(), j(), i())) {
            throw new AssertionError();
        }
        if (!gVar.d().a(obj)) {
            if (f()) {
                throw new sdk.pendo.io.d1.k(String.format("Expected to find an object with property %s in path %s but found '%s'. This is not a json object according to the JsonProvider: '%s'.", a(), str, obj == null ? AbstractJsonLexerKt.NULL : obj.getClass().getName(), gVar.a().f().getClass().getName()));
            }
            return;
        }
        if (k() || j()) {
            a(str, obj, gVar, this.f);
            return;
        }
        if (!z && !i()) {
            throw new AssertionError();
        }
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(null);
        Iterator<String> it = this.f.iterator();
        while (it.hasNext()) {
            arrayList.set(0, it.next());
            a(str, obj, gVar, arrayList);
        }
    }

    @Override // sdk.pendo.io.l1.j
    public boolean e() {
        return k() || j();
    }

    public List<String> h() {
        return this.f;
    }

    public boolean i() {
        return !b() && this.f.size() > 1;
    }

    public boolean j() {
        return b() && this.f.size() > 1;
    }

    public boolean k() {
        return this.f.size() == 1;
    }

    @Override // sdk.pendo.io.l1.j
    public String a() {
        return "[" + sdk.pendo.io.e1.i.a(",", this.g, this.f) + "]";
    }
}
