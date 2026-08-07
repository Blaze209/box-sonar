package sdk.pendo.io.d4;

import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
public final class f {
    public static String a(String str) {
        return "It is not allowed to subscribe with a(n) " + str + " multiple times. Please create a fresh instance of " + str + " and subscribe that to the target source instead.";
    }

    public static void a(Class<?> cls) {
        sdk.pendo.io.g4.a.b(new sdk.pendo.io.p3.e(a(cls.getName())));
    }

    public static boolean a(AtomicReference<sdk.pendo.io.o3.b> atomicReference, sdk.pendo.io.o3.b bVar, Class<?> cls) {
        sdk.pendo.io.s3.b.a(bVar, "next is null");
        if (PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(atomicReference, null, bVar)) {
            return true;
        }
        bVar.dispose();
        if (atomicReference.get() == sdk.pendo.io.r3.b.DISPOSED) {
            return false;
        }
        a(cls);
        return false;
    }
}
