package sdk.pendo.io.p0;

/* JADX INFO: loaded from: classes4.dex */
public class c extends Exception {
    private int a;
    private Object b;
    private int c;

    public c(int i, int i2, Object obj) {
        this.c = i;
        this.a = i2;
        this.b = obj;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        StringBuilder sbAppend;
        String str;
        StringBuilder sbAppend2;
        StringBuilder sb = new StringBuilder();
        int i = this.a;
        if (i != 0) {
            if (i == 1) {
                sbAppend = sb.append("Unexpected token ").append(this.b);
                str = " at position ";
            } else if (i != 2) {
                sbAppend2 = sb.append("Unknown error at position ");
                sbAppend2.append(this.c).append(".");
            } else {
                sb.append("Unexpected exception at position ").append(this.c).append(": ").append(this.b);
            }
            return sb.toString();
        }
        sbAppend = sb.append("Unexpected character (").append(this.b);
        str = ") at position ";
        sbAppend2 = sbAppend.append(str);
        sbAppend2.append(this.c).append(".");
        return sb.toString();
    }
}
