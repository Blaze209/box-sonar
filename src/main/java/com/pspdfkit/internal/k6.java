package com.pspdfkit.internal;

import android.media.AudioRecord;
import android.os.Process;
import com.pspdfkit.annotations.SoundAnnotation;
import com.pspdfkit.annotations.sound.AudioEncoding;
import com.pspdfkit.annotations.sound.EmbeddedAudioSource;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.schedulers.Schedulers;
import io.reactivex.rxjava3.subjects.PublishSubject;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes3.dex */
public final class k6 {
    public final int a;
    public final int b;
    public t6 c;
    public final float d;
    public final int e;
    public boolean f;
    public a g;
    public long h;
    public Thread i;
    public ByteBuffer j;
    public final PublishSubject<ByteBuffer> k;

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v1 com.pspdfkit.internal.k6$a[], still in use, count: 1, list:
      (r0v1 com.pspdfkit.internal.k6$a[]) from 0x0038: INVOKE (r0v1 com.pspdfkit.internal.k6$a[]) STATIC call: kotlin.enums.EnumEntriesKt.enumEntries(java.lang.Enum[]):kotlin.enums.EnumEntries A[MD:<E extends java.lang.Enum<E>>:(E extends java.lang.Enum<E>[]):kotlin.enums.EnumEntries<E extends java.lang.Enum<E>> (m)]
    	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
    	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
    	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:101)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:100)
    	at jadx.core.utils.InsnRemover.removeAllAndUnbind(InsnRemover.java:257)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:187)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    public static final class a {
        RECORDING,
        PAUSED,
        STOPPED,
        ERROR,
        SAVED;

        static {
            EnumEntriesKt.enumEntries(aVarArr);
        }

        public a() {
            super(str, i);
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) f.clone();
        }
    }

    public k6(int i, int i2) {
        this.a = i;
        this.b = i2;
        float f = (i / 1000.0f) * 2;
        this.d = f;
        int minBufferSize = AudioRecord.getMinBufferSize(i, 16, 2);
        this.e = (minBufferSize == -2 || minBufferSize == -1) ? i * 2 : minBufferSize;
        this.g = a.PAUSED;
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect((int) (f * i2));
        ByteOrder byteOrderNativeOrder = ByteOrder.nativeOrder();
        byteOrderNativeOrder.getClass();
        ByteBuffer byteBufferOrder = byteBufferAllocateDirect.order(byteOrderNativeOrder);
        byteBufferOrder.getClass();
        this.j = byteBufferOrder;
        PublishSubject<ByteBuffer> publishSubjectCreate = PublishSubject.create();
        publishSubjectCreate.getClass();
        this.k = publishSubjectCreate;
    }

    public static final void a(k6 k6Var) {
        boolean z;
        k6Var.getClass();
        Process.setThreadPriority(-16);
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(k6Var.e);
        ByteOrder byteOrderNativeOrder = ByteOrder.nativeOrder();
        byteOrderNativeOrder.getClass();
        ByteBuffer byteBufferOrder = byteBufferAllocateDirect.order(byteOrderNativeOrder);
        try {
            AudioRecord audioRecord = new AudioRecord(0, k6Var.a, 16, 2, k6Var.e);
            boolean z2 = true;
            if (audioRecord.getState() != 1) {
                k6Var.a(a.ERROR, new IllegalStateException("Could not initialize audio recording"));
                return;
            }
            audioRecord.startRecording();
            if (audioRecord.getRecordingState() != 3) {
                k6Var.a(a.ERROR, new IllegalStateException("Could not start audio recording"));
                return;
            }
            k6Var.h = System.currentTimeMillis() - ((long) k6Var.a());
            k6Var.a(a.RECORDING, (Throwable) null);
            ByteBuffer byteBuffer = k6Var.j;
            while (true) {
                try {
                    synchronized (k6Var) {
                        z = k6Var.f;
                    }
                    if (!z) {
                        z2 = false;
                        break;
                    }
                    if (!byteBuffer.hasRemaining()) {
                        break;
                    }
                    byteBufferOrder.clear();
                    int iMin = Math.min(audioRecord.read(byteBufferOrder, byteBufferOrder.capacity(), 1), byteBuffer.remaining());
                    if (iMin > 0) {
                        byteBufferOrder.limit(iMin);
                        byteBufferOrder.rewind();
                        byteBuffer.put(byteBufferOrder);
                        byteBufferOrder.rewind();
                        k6Var.k.onNext(byteBufferOrder);
                    }
                } catch (Throwable th) {
                    audioRecord.stop();
                    audioRecord.release();
                    throw th;
                }
            }
            audioRecord.stop();
            audioRecord.release();
            if (z2) {
                k6Var.a(a.STOPPED, (Throwable) null);
            } else {
                k6Var.a(a.PAUSED, (Throwable) null);
            }
        } catch (Throwable th2) {
            k6Var.a(a.ERROR, th2);
        }
    }

    public final synchronized void b() {
        if (!this.f && this.g == a.PAUSED) {
            this.f = true;
            Thread thread = new Thread(new Runnable() { // from class: com.pspdfkit.internal.k6$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    k6.a(this.f$0);
                }
            });
            this.i = thread;
            thread.start();
        }
    }

    public final synchronized int a() {
        if (this.g == a.RECORDING) {
            return (int) (System.currentTimeMillis() - this.h);
        }
        return (int) (this.j.position() / this.d);
    }

    public final Completable a(final SoundAnnotation soundAnnotation) {
        soundAnnotation.getClass();
        Completable completableFromAction = Completable.fromAction(new Action() { // from class: com.pspdfkit.internal.k6$$ExternalSyntheticLambda0
            @Override // io.reactivex.rxjava3.functions.Action
            public final void run() throws InterruptedException {
                k6.a(this.f$0, soundAnnotation);
            }
        });
        synchronized (ar.class) {
            q10.c();
        }
        Scheduler schedulerIo = Schedulers.io();
        schedulerIo.getClass();
        Completable completableSubscribeOn = completableFromAction.subscribeOn(schedulerIo);
        completableSubscribeOn.getClass();
        return completableSubscribeOn;
    }

    public static final void a(k6 k6Var, SoundAnnotation soundAnnotation) throws InterruptedException {
        int i;
        if (k6Var.j.position() > 0) {
            synchronized (k6Var) {
                k6Var.f = false;
            }
            Thread thread = k6Var.i;
            if (thread != null) {
                thread.join(5000L);
            }
            k6Var.j.flip();
            int iLimit = k6Var.j.limit();
            byte[] bArr = new byte[iLimit];
            k6Var.j.get(bArr);
            k6Var.j.clear();
            ByteOrder byteOrderNativeOrder = ByteOrder.nativeOrder();
            byteOrderNativeOrder.getClass();
            if (Intrinsics.areEqual(byteOrderNativeOrder, ByteOrder.LITTLE_ENDIAN)) {
                for (i = 0; i < iLimit - 1; i += 2) {
                    byte b = bArr[i];
                    int i2 = i + 1;
                    bArr[i] = bArr[i2];
                    bArr[i2] = b;
                }
            }
            soundAnnotation.setAudioSource(new EmbeddedAudioSource(bArr, AudioEncoding.SIGNED, k6Var.a, 16, 1, (String) null));
        }
        k6Var.a(a.SAVED, (Throwable) null);
    }

    public final synchronized void a(a aVar, Throwable th) {
        if (this.g != aVar) {
            this.g = aVar;
            t6 t6Var = this.c;
            if (t6Var != null) {
                int iOrdinal = aVar.ordinal();
                if (iOrdinal == 0) {
                    t6Var.a(j30.RECORDING);
                    BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new p6(t6Var, null), 3, null);
                    return;
                }
                if (iOrdinal == 1) {
                    t6Var.a(j30.RECORDING_PAUSED);
                    BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new n6(t6Var, null), 3, null);
                    return;
                }
                if (iOrdinal == 2) {
                    t6Var.a(j30.STOPPED);
                    BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new r6(t6Var, null), 3, null);
                } else {
                    if (iOrdinal != 3) {
                        if (iOrdinal != 4) {
                            throw new NoWhenBranchMatchedException();
                        }
                        t6Var.a(j30.STOPPED);
                        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new q6(t6Var, null), 3, null);
                        return;
                    }
                    t6Var.a(j30.STOPPED);
                    if (th == null) {
                        th = new IllegalStateException("Can't record audio");
                    }
                    BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new m6(t6Var, th, null), 3, null);
                }
            }
        }
    }
}
