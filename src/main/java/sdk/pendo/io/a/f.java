package sdk.pendo.io.a;

/* JADX INFO: loaded from: classes4.dex */
public final class f extends IndexOutOfBoundsException {
    private final String a;
    private final int b;

    public f(String str, int i) {
        super("Class too large: " + str);
        this.a = str;
        this.b = i;
    }
}
