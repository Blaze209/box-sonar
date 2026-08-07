package sdk.pendo.io.p3;

import sdk.pendo.io.d4.g;

/* JADX INFO: loaded from: classes4.dex */
public final class b {
    public static RuntimeException a(Throwable th) {
        throw g.a(th);
    }

    public static void b(Throwable th) {
        if (th instanceof VirtualMachineError) {
            throw ((VirtualMachineError) th);
        }
        if (th instanceof ThreadDeath) {
            throw ((ThreadDeath) th);
        }
        if (th instanceof LinkageError) {
            throw ((LinkageError) th);
        }
    }
}
