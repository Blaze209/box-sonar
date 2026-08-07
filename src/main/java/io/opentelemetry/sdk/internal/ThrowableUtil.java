package io.opentelemetry.sdk.internal;

/* JADX INFO: loaded from: classes4.dex */
public final class ThrowableUtil {
    public static void propagateIfFatal(Throwable th) {
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

    private ThrowableUtil() {
    }
}
