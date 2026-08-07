package sdk.pendo.io.t1;

/* JADX INFO: loaded from: classes5.dex */
public class e extends Exception {
    private int a;
    private Object b;
    private int c;

    public e(int i, int i2, Object obj) {
        super(a(i, i2, obj));
        this.c = i;
        this.a = i2;
        this.b = obj;
    }

    private static String a(int i, int i2, Object obj) {
        String str;
        String str2;
        StringBuilder sb = new StringBuilder();
        if (i2 != 0) {
            if (i2 == 1) {
                str2 = "Unexpected token ";
            } else {
                if (i2 != 2) {
                    if (i2 == 3) {
                        sb.append("Unexpected End Of File position ");
                        sb.append(i);
                        sb.append(": ");
                        sb.append(obj);
                    } else if (i2 == 4) {
                        str2 = "Unexpected unicode escape sequence ";
                    } else if (i2 == 5) {
                        str2 = "Unexpected duplicate key:";
                    } else if (i2 == 6) {
                        str2 = "Unexpected leading 0 in digit for token:";
                    } else {
                        str = "Unkown error at position ";
                    }
                    return sb.toString();
                }
                sb.append("Unexpected exception ");
                sb.append(obj);
                str = " occur at position ";
            }
            sb.append(str2);
            sb.append(obj);
            sb.append(" at position ");
            sb.append(i);
            sb.append(".");
            return sb.toString();
        }
        sb.append("Unexpected character (");
        sb.append(obj);
        str = ") at position ";
        sb.append(str);
        sb.append(i);
        sb.append(".");
        return sb.toString();
    }

    public e(int i, Throwable th) {
        super(a(i, 2, th), th);
        this.c = i;
        this.a = 2;
        this.b = th;
    }
}
