package sdk.pendo.io.a4;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;
import org.apache.commons.codec.language.Soundex;

/* JADX INFO: loaded from: classes4.dex */
public final class h extends AtomicLong implements ThreadFactory {
    final String a;
    final int b;
    final boolean c;

    static final class a extends Thread implements g {
        a(Runnable runnable, String str) {
            super(runnable, str);
        }
    }

    public h(String str) {
        this(str, 5, false);
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        String str = this.a + Soundex.SILENT_MARKER + incrementAndGet();
        Thread aVar = this.c ? new a(runnable, str) : new Thread(runnable, str);
        aVar.setPriority(this.b);
        aVar.setDaemon(true);
        return aVar;
    }

    @Override // java.util.concurrent.atomic.AtomicLong
    public String toString() {
        return "RxThreadFactory[" + this.a + "]";
    }

    public h(String str, int i) {
        this(str, i, false);
    }

    public h(String str, int i, boolean z) {
        this.a = str;
        this.b = i;
        this.c = z;
    }
}
