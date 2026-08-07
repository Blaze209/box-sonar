package sdk.pendo.io.e6;

/* JADX INFO: loaded from: classes4.dex */
public class a {
    private long a;
    private String b;
    private String c;
    private String d;

    public a(long j, String str, String str2) {
        this.d = str2;
        this.b = str;
        this.a = j;
    }

    public final String toString() {
        return "[Timestamp: " + Long.toString(this.a) + ", Logging Level: " + this.d + ", Message: " + this.b + ", " + (this.c != null ? "Exception: " + this.c + ", " : "") + "]";
    }

    public a(long j, String str, String str2, String str3) {
        this.d = str3;
        this.b = str;
        this.a = j;
        this.c = str2;
    }
}
