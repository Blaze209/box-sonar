package sdk.pendo.io.d4;

/* JADX INFO: loaded from: classes4.dex */
public final class e {
    public static void a() {
        if (sdk.pendo.io.g4.a.a()) {
            if ((Thread.currentThread() instanceof sdk.pendo.io.a4.g) || sdk.pendo.io.g4.a.b()) {
                throw new IllegalStateException("Attempt to block on a Scheduler " + Thread.currentThread().getName() + " that doesn't support blocking operators as they may lead to deadlock");
            }
        }
    }
}
