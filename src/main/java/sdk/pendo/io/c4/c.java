package sdk.pendo.io.c4;

import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import sdk.pendo.io.d4.d;
import sdk.pendo.io.p3.e;

/* JADX INFO: loaded from: classes4.dex */
public enum c implements sdk.pendo.io.j3.c {
    CANCELLED;

    public static boolean a(AtomicReference<sdk.pendo.io.j3.c> atomicReference) {
        sdk.pendo.io.j3.c andSet;
        sdk.pendo.io.j3.c cVar = atomicReference.get();
        c cVar2 = CANCELLED;
        if (cVar == cVar2 || (andSet = atomicReference.getAndSet(cVar2)) == cVar2) {
            return false;
        }
        if (andSet == null) {
            return true;
        }
        andSet.cancel();
        return true;
    }

    public static boolean b(long j) {
        if (j > 0) {
            return true;
        }
        sdk.pendo.io.g4.a.b(new IllegalArgumentException("n > 0 required but it was " + j));
        return false;
    }

    @Override // sdk.pendo.io.j3.c
    public void cancel() {
    }

    @Override // sdk.pendo.io.j3.c
    public void request(long j) {
    }

    public static void a(AtomicReference<sdk.pendo.io.j3.c> atomicReference, AtomicLong atomicLong, long j) {
        sdk.pendo.io.j3.c cVar = atomicReference.get();
        if (cVar != null) {
            cVar.request(j);
            return;
        }
        if (b(j)) {
            d.a(atomicLong, j);
            sdk.pendo.io.j3.c cVar2 = atomicReference.get();
            if (cVar2 != null) {
                long andSet = atomicLong.getAndSet(0L);
                if (andSet != 0) {
                    cVar2.request(andSet);
                }
            }
        }
    }

    public static boolean a(AtomicReference<sdk.pendo.io.j3.c> atomicReference, AtomicLong atomicLong, sdk.pendo.io.j3.c cVar) {
        if (!a(atomicReference, cVar)) {
            return false;
        }
        long andSet = atomicLong.getAndSet(0L);
        if (andSet == 0) {
            return true;
        }
        cVar.request(andSet);
        return true;
    }

    public static void a(long j) {
        sdk.pendo.io.g4.a.b(new e("More produced than requested: " + j));
    }

    public static void a() {
        sdk.pendo.io.g4.a.b(new e("Subscription already set!"));
    }

    public static boolean a(AtomicReference<sdk.pendo.io.j3.c> atomicReference, sdk.pendo.io.j3.c cVar) {
        sdk.pendo.io.s3.b.a(cVar, "s is null");
        if (PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(atomicReference, null, cVar)) {
            return true;
        }
        cVar.cancel();
        if (atomicReference.get() == CANCELLED) {
            return false;
        }
        a();
        return false;
    }

    public static boolean a(AtomicReference<sdk.pendo.io.j3.c> atomicReference, sdk.pendo.io.j3.c cVar, long j) {
        if (!a(atomicReference, cVar)) {
            return false;
        }
        cVar.request(j);
        return true;
    }

    public static boolean a(sdk.pendo.io.j3.c cVar, sdk.pendo.io.j3.c cVar2) {
        if (cVar2 == null) {
            sdk.pendo.io.g4.a.b(new NullPointerException("next is null"));
            return false;
        }
        if (cVar == null) {
            return true;
        }
        cVar2.cancel();
        a();
        return false;
    }
}
