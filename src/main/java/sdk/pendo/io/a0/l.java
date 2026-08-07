package sdk.pendo.io.a0;

import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public final class l extends i {
    private final sdk.pendo.io.c0.g<String, i> a = new sdk.pendo.io.c0.g<>();

    public void a(String str, i iVar) {
        sdk.pendo.io.c0.g<String, i> gVar = this.a;
        if (iVar == null) {
            iVar = k.a;
        }
        gVar.put(str, iVar);
    }

    public f b(String str) {
        return (f) this.a.get(str);
    }

    public n c(String str) {
        return (n) this.a.get(str);
    }

    public boolean d(String str) {
        return this.a.containsKey(str);
    }

    public i e(String str) {
        return this.a.remove(str);
    }

    public boolean equals(Object obj) {
        if (obj != this) {
            return (obj instanceof l) && ((l) obj).a.equals(this.a);
        }
        return true;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public Set<Map.Entry<String, i>> l() {
        return this.a.entrySet();
    }

    public void a(String str, Boolean bool) {
        a(str, bool == null ? k.a : new n(bool));
    }

    public void a(String str, Number number) {
        a(str, number == null ? k.a : new n(number));
    }

    public void a(String str, String str2) {
        a(str, str2 == null ? k.a : new n(str2));
    }

    public i a(String str) {
        return this.a.get(str);
    }
}
