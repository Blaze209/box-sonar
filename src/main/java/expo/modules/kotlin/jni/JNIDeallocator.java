package expo.modules.kotlin.jni;

import com.facebook.jni.HybridData;
import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.hc.core5.http.HeaderElements;

/* JADX INFO: compiled from: JNIDeallocator.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0001\u001bB\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\tH\u0007J\u0011\u0010\u0013\u001a\u0004\u0018\u00010\u0011H\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\r0\u0017J\f\u0010\u0018\u001a\u00020\u0011*\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u0011H\u0016R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\n\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\f\u0012\u0004\u0012\u00020\r0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0018\u00010\u000fR\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lexpo/modules/kotlin/jni/JNIDeallocator;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "shouldCreateDestructorThread", "", "<init>", "(Z)V", "referenceQueue", "Ljava/lang/ref/ReferenceQueue;", "Lexpo/modules/kotlin/jni/Destructible;", "destructorMap", "", "Ljava/lang/ref/PhantomReference;", "Lcom/facebook/jni/HybridData;", "destructorThread", "Lexpo/modules/kotlin/jni/JNIDeallocator$DeallocatorThread;", "addReference", "", "destructible", "deallocate", "deallocate$expo_modules_core_release", "()Lkotlin/Unit;", "inspectMemory", "", "deallocator", "Ljava/lang/Thread;", HeaderElements.CLOSE, "DeallocatorThread", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class JNIDeallocator implements AutoCloseable {
    public static final int $stable = 8;
    private final Map<PhantomReference<Destructible>, HybridData> destructorMap;
    private final DeallocatorThread destructorThread;
    private final ReferenceQueue<Destructible> referenceQueue;

    public JNIDeallocator() {
        this(false, 1, null);
    }

    /* JADX INFO: compiled from: JNIDeallocator.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"Lexpo/modules/kotlin/jni/JNIDeallocator$DeallocatorThread;", "Ljava/lang/Thread;", "<init>", "(Lexpo/modules/kotlin/jni/JNIDeallocator;)V", "run", "", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private final class DeallocatorThread extends Thread {
        public DeallocatorThread() {
            super("Expo JNI deallocator");
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            JNIDeallocator.this.deallocator(this);
        }
    }

    public JNIDeallocator(boolean z) {
        DeallocatorThread deallocatorThread;
        this.referenceQueue = new ReferenceQueue<>();
        this.destructorMap = new LinkedHashMap();
        if (z) {
            deallocatorThread = new DeallocatorThread();
            deallocatorThread.start();
        } else {
            deallocatorThread = null;
        }
        this.destructorThread = deallocatorThread;
    }

    public /* synthetic */ JNIDeallocator(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? true : z);
    }

    public final void addReference(Destructible destructible) {
        Intrinsics.checkNotNullParameter(destructible, "destructible");
        synchronized (this) {
            this.destructorMap.put(new PhantomReference<>(destructible, this.referenceQueue), destructible.getMHybridData());
            Unit unit = Unit.INSTANCE;
        }
    }

    public final Unit deallocate$expo_modules_core_release() {
        Unit unit;
        synchronized (this) {
            Iterator<T> it = this.destructorMap.values().iterator();
            while (it.hasNext()) {
                ((HybridData) it.next()).resetNative();
            }
            this.destructorMap.clear();
            DeallocatorThread deallocatorThread = this.destructorThread;
            if (deallocatorThread != null) {
                deallocatorThread.interrupt();
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
        }
        return unit;
    }

    public final List<HybridData> inspectMemory() {
        ArrayList arrayList;
        boolean zIsValid;
        synchronized (this) {
            Collection<HybridData> collectionValues = this.destructorMap.values();
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : collectionValues) {
                HybridData hybridData = (HybridData) obj;
                synchronized (hybridData) {
                    zIsValid = hybridData.isValid();
                }
                if (zIsValid) {
                    arrayList2.add(obj);
                }
            }
            ArrayList arrayList3 = arrayList2;
            ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList3, 10));
            Iterator it = arrayList3.iterator();
            while (it.hasNext()) {
                arrayList4.add((HybridData) it.next());
            }
            arrayList = arrayList4;
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void deallocator(Thread thread) {
        while (!thread.isInterrupted()) {
            try {
                Reference<? extends Destructible> referenceRemove = this.referenceQueue.remove();
                HybridData hybridData = this.destructorMap.get(referenceRemove);
                if (hybridData != null) {
                    hybridData.resetNative();
                }
                synchronized (this) {
                    try {
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } catch (InterruptedException unused) {
                return;
            }
        }
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        deallocate$expo_modules_core_release();
    }
}
