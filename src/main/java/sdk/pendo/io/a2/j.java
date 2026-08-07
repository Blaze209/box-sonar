package sdk.pendo.io.a2;

import java.io.IOException;
import java.io.Writer;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class j extends c {
    private final int b;
    private final int c;
    private final boolean d;

    protected j(int i, int i2, boolean z) {
        this.b = i;
        this.c = i2;
        this.d = z;
    }

    @Override // sdk.pendo.io.a2.c
    public boolean a(int i, Writer writer) throws IOException {
        if (this.d) {
            if (i < this.b || i > this.c) {
                return false;
            }
        } else if (i >= this.b && i <= this.c) {
            return false;
        }
        if (i > 65535) {
            writer.write(b(i));
            return true;
        }
        writer.write("\\u");
        char[] cArr = b.a;
        writer.write(cArr[(i >> 12) & 15]);
        writer.write(cArr[(i >> 8) & 15]);
        writer.write(cArr[(i >> 4) & 15]);
        writer.write(cArr[i & 15]);
        return true;
    }

    protected String b(int i) {
        throw null;
    }
}
