package sdk.pendo.io.f1;

/* JADX INFO: loaded from: classes4.dex */
public enum f {
    AND("&&"),
    NOT("!"),
    OR("||");

    private final String operatorString;

    f(String str) {
        this.operatorString = str;
    }

    public String b() {
        return this.operatorString;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.operatorString;
    }
}
