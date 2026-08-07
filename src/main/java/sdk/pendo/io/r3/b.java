package sdk.pendo.io.r3;

import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
public enum b implements sdk.pendo.io.o3.b {
    DISPOSED;

    public static boolean a(AtomicReference<sdk.pendo.io.o3.b> atomicReference) {
        sdk.pendo.io.o3.b andSet;
        sdk.pendo.io.o3.b bVar = atomicReference.get();
        b bVar2 = DISPOSED;
        if (bVar == bVar2 || (andSet = atomicReference.getAndSet(bVar2)) == bVar2) {
            return false;
        }
        if (andSet == null) {
            return true;
        }
        andSet.dispose();
        return true;
    }

    public static boolean b(AtomicReference<sdk.pendo.io.o3.b> atomicReference, sdk.pendo.io.o3.b bVar) {
        sdk.pendo.io.o3.b bVar2;
        do {
            bVar2 = atomicReference.get();
            if (bVar2 == DISPOSED) {
                if (bVar == null) {
                    return false;
                }
                bVar.dispose();
                return false;
            }
        } while (!PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(atomicReference, bVar2, bVar));
        if (bVar2 == null) {
            return true;
        }
        bVar2.dispose();
        return true;
    }

    public static boolean c(AtomicReference<sdk.pendo.io.o3.b> atomicReference, sdk.pendo.io.o3.b bVar) {
        sdk.pendo.io.s3.b.a(bVar, "d is null");
        if (PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(atomicReference, null, bVar)) {
            return true;
        }
        bVar.dispose();
        if (atomicReference.get() == DISPOSED) {
            return false;
        }
        a();
        return false;
    }

    public static boolean d(AtomicReference<sdk.pendo.io.o3.b> atomicReference, sdk.pendo.io.o3.b bVar) {
        if (PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(atomicReference, null, bVar)) {
            return true;
        }
        if (atomicReference.get() != DISPOSED) {
            return false;
        }
        bVar.dispose();
        return false;
    }

    @Override // sdk.pendo.io.o3.b
    public void dispose() {
    }

    @Override // sdk.pendo.io.o3.b
    public boolean isDisposed() {
        return true;
    }

    public static boolean a(sdk.pendo.io.o3.b bVar) {
        return bVar == DISPOSED;
    }

    public static boolean a(AtomicReference<sdk.pendo.io.o3.b> atomicReference, sdk.pendo.io.o3.b bVar) {
        sdk.pendo.io.o3.b bVar2;
        do {
            bVar2 = atomicReference.get();
            if (bVar2 == DISPOSED) {
                if (bVar == null) {
                    return false;
                }
                bVar.dispose();
                return false;
            }
        } while (!PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(atomicReference, bVar2, bVar));
        return true;
    }

    public static void a() {
        sdk.pendo.io.g4.a.b(new sdk.pendo.io.p3.e("Disposable already set!"));
    }

    public static boolean a(sdk.pendo.io.o3.b bVar, sdk.pendo.io.o3.b bVar2) {
        if (bVar2 == null) {
            sdk.pendo.io.g4.a.b(new NullPointerException("next is null"));
            return false;
        }
        if (bVar == null) {
            return true;
        }
        bVar2.dispose();
        a();
        return false;
    }
}
