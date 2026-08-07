package sdk.pendo.io.e;

import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public final class e extends IOException {
    private final int a;

    public e(int i) {
        this("Http request failed", i);
    }

    public e(String str, int i) {
        this(str, i, null);
    }

    public e(String str, int i, Throwable th) {
        super(str + ", status code: " + i, th);
        this.a = i;
    }
}
