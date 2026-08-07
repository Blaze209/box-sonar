package sdk.pendo.io.n3;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Callable;
import sdk.pendo.io.k3.p;

/* JADX INFO: loaded from: classes4.dex */
public final class a {
    private static final p a = sdk.pendo.io.m3.a.b(new CallableC0428a());

    /* JADX INFO: renamed from: sdk.pendo.io.n3.a$a, reason: collision with other inner class name */
    class CallableC0428a implements Callable<p> {
        CallableC0428a() {
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public p call() {
            return b.a;
        }
    }

    private static final class b {
        static final p a = new sdk.pendo.io.n3.b(new Handler(Looper.getMainLooper()), false);
    }

    public static p a() {
        return sdk.pendo.io.m3.a.a(a);
    }
}
