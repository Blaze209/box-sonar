package sdk.pendo.io.a;

import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class i {
    private final String a;
    private final String b;
    private final q c;
    private final Object[] d;

    public i(String str, String str2, q qVar, Object... objArr) {
        this.a = str;
        this.b = str2;
        this.c = qVar;
        this.d = objArr;
    }

    public q a() {
        return this.c;
    }

    Object[] b() {
        return this.d;
    }

    public String c() {
        return this.b;
    }

    public String d() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return this.a.equals(iVar.a) && this.b.equals(iVar.b) && this.c.equals(iVar.c) && Arrays.equals(this.d, iVar.d);
    }

    public int hashCode() {
        return Integer.rotateLeft(Arrays.hashCode(this.d), 24) ^ ((this.a.hashCode() ^ Integer.rotateLeft(this.b.hashCode(), 8)) ^ Integer.rotateLeft(this.c.hashCode(), 16));
    }

    public String toString() {
        return this.a + " : " + this.b + ' ' + this.c + ' ' + Arrays.toString(this.d);
    }
}
