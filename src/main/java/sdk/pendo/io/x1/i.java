package sdk.pendo.io.x1;

/* JADX INFO: loaded from: classes6.dex */
final class i {
    private final Object a;
    private final int b;

    i(Object obj) {
        this.b = System.identityHashCode(obj);
        this.a = obj;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return this.b == iVar.b && this.a == iVar.a;
    }

    public int hashCode() {
        return this.b;
    }
}
