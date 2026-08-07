package sdk.pendo.io.a;

/* JADX INFO: loaded from: classes4.dex */
public final class t extends IndexOutOfBoundsException {
    private final String a;
    private final String b;
    private final String c;
    private final int d;

    public t(String str, String str2, String str3, int i) {
        super("Method too large: " + str + "." + str2 + " " + str3);
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = i;
    }
}
