package com.pspdfkit.internal;

import com.pspdfkit.instant.client.InstantProgress;
import com.pspdfkit.instant.exceptions.InstantErrorCode;
import com.pspdfkit.instant.exceptions.InstantSyncException;
import com.pspdfkit.instant.internal.jni.NativeInstantError;
import com.pspdfkit.instant.internal.jni.NativeProgressObserver;
import com.pspdfkit.instant.internal.jni.NativeProgressReporter;
import com.pspdfkit.instant.internal.jni.NativeServerChangeApplicator;
import com.pspdfkit.instant.internal.jni.NativeServerDocumentLayer;
import com.pspdfkit.instant.internal.jni.NativeSyncRequestType;
import com.pspdfkit.instant.listeners.InstantDocumentListener;
import com.pspdfkit.utils.PdfLog;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.SendChannel;

/* JADX INFO: loaded from: classes3.dex */
public final class zk implements v4 {
    public static final InstantProgress g = new InstantProgress(100, true);
    public final hm a;
    public final gm b;
    public final pl c;
    public NativeProgressReporter d;
    public a e;
    public volatile SendChannel<? super InstantProgress> f;

    public static final class a extends NativeProgressObserver {
        public final SendChannel<InstantProgress> a;

        /* JADX WARN: Multi-variable type inference failed */
        public a(SendChannel<? super InstantProgress> sendChannel) {
            sendChannel.getClass();
            this.a = sendChannel;
        }

        @Override // com.pspdfkit.instant.internal.jni.NativeProgressObserver
        public final void onCancellation(NativeProgressReporter nativeProgressReporter) {
            nativeProgressReporter.getClass();
        }

        @Override // com.pspdfkit.instant.internal.jni.NativeProgressObserver
        public final void onError(NativeProgressReporter nativeProgressReporter, NativeInstantError nativeInstantError) {
            nativeProgressReporter.getClass();
            nativeInstantError.getClass();
        }

        @Override // com.pspdfkit.instant.internal.jni.NativeProgressObserver
        public final void onProgress(NativeProgressReporter nativeProgressReporter) {
            nativeProgressReporter.getClass();
            ChannelResult.m16344isSuccessimpl(this.a.mo11206trySendJP2dKIU(new InstantProgress((int) nativeProgressReporter.getCurrentProgress(), nativeProgressReporter.isInFinalState())));
        }

        @Override // com.pspdfkit.instant.internal.jni.NativeProgressObserver
        public final void onSuccess(NativeProgressReporter nativeProgressReporter) {
            nativeProgressReporter.getClass();
        }
    }

    public zk(hm hmVar) {
        hmVar.getClass();
        this.a = hmVar;
        gm internal = hmVar.S.getInternal();
        internal.getClass();
        this.b = internal;
        pl plVarA = internal.a();
        plVarA.getClass();
        plVarA.c = new WeakReference<>(this);
        this.c = plVarA;
    }

    @Override // com.pspdfkit.internal.v4
    public final synchronized void a(NativeServerDocumentLayer nativeServerDocumentLayer, NativeSyncRequestType nativeSyncRequestType, NativeProgressReporter nativeProgressReporter, NativeProgressReporter nativeProgressReporter2) {
        nativeServerDocumentLayer.getClass();
        nativeSyncRequestType.getClass();
        nativeProgressReporter2.getClass();
        NativeProgressReporter nativeProgressReporter3 = this.d;
        if (nativeProgressReporter3 == null || Intrinsics.areEqual(nativeProgressReporter3, nativeProgressReporter)) {
            this.d = nativeProgressReporter2;
            SendChannel<? super InstantProgress> sendChannel = this.f;
            if (sendChannel != null) {
                a aVar = new a(sendChannel);
                this.e = aVar;
                nativeProgressReporter2.addObserver(aVar);
            }
            if (nativeSyncRequestType != NativeSyncRequestType.LISTEN_FOR_CHANGES) {
                this.c.b();
            }
        }
    }

    @Override // com.pspdfkit.internal.v4
    public final void b(NativeServerDocumentLayer nativeServerDocumentLayer) {
        a aVar;
        nativeServerDocumentLayer.getClass();
        InstantProgress instantProgress = g;
        SendChannel<? super InstantProgress> sendChannel = this.f;
        if (sendChannel != null) {
            ChannelResult.m16344isSuccessimpl(sendChannel.mo11206trySendJP2dKIU(instantProgress));
        }
        SendChannel<? super InstantProgress> sendChannel2 = this.f;
        if (sendChannel2 != null) {
            this.f = null;
            sendChannel2.close(null);
        }
        synchronized (this) {
            NativeProgressReporter nativeProgressReporter = this.d;
            if (nativeProgressReporter != null && (aVar = this.e) != null) {
                nativeProgressReporter.removeObserver(aVar);
                this.d = null;
                this.e = null;
            }
        }
        pl plVar = this.c;
        hm hmVarA = plVar.a();
        if (hmVarA != null) {
            Iterator<InstantDocumentListener> it = plVar.b.iterator();
            it.getClass();
            while (it.hasNext()) {
                it.next().onSyncFinished(hmVarA);
            }
        }
        this.c.b();
    }

    @Override // com.pspdfkit.internal.v4
    public final void c(NativeServerDocumentLayer nativeServerDocumentLayer) {
        nativeServerDocumentLayer.getClass();
        pl plVar = this.c;
        hm hmVarA = plVar.a();
        if (hmVarA == null) {
            return;
        }
        Iterator<InstantDocumentListener> it = plVar.b.iterator();
        it.getClass();
        while (it.hasNext()) {
            it.next().onSyncStarted(hmVarA);
        }
    }

    @Override // com.pspdfkit.internal.v4
    public final void a(NativeServerDocumentLayer nativeServerDocumentLayer) {
        nativeServerDocumentLayer.getClass();
        this.c.b();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // com.pspdfkit.internal.v4
    public final Object a(NativeServerDocumentLayer nativeServerDocumentLayer, NativeServerChangeApplicator nativeServerChangeApplicator, ContinuationImpl continuationImpl) {
        dl dlVar;
        if (continuationImpl instanceof dl) {
            dlVar = (dl) continuationImpl;
            int i = dlVar.e;
            if ((i & Integer.MIN_VALUE) != 0) {
                dlVar.e = i - Integer.MIN_VALUE;
            } else {
                dlVar = new dl(this, continuationImpl);
            }
        } else {
            dlVar = new dl(this, continuationImpl);
        }
        Object obj = dlVar.c;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = dlVar.e;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            dlVar.a = SpillingKt.nullOutSpilledVariable(nativeServerDocumentLayer);
            dlVar.b = nativeServerChangeApplicator;
            dlVar.e = 1;
            if (a(nativeServerChangeApplicator, dlVar) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            nativeServerChangeApplicator = dlVar.b;
            ResultKt.throwOnFailure(obj);
        }
        try {
            this.b.c.didRefreshAfterApplyingChanges(nativeServerChangeApplicator, this.a.T.j);
        } catch (Exception e) {
            PdfLog.w("Nutri.InstAnnotSyncMgr", "Error during didRefreshAfterApplyingChanges: " + e.getMessage(), new Object[0]);
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:35:0x00a3 A[Catch: all -> 0x00ea, TryCatch #0 {all -> 0x00ea, blocks: (B:18:0x004d, B:38:0x00c4, B:21:0x0056, B:33:0x0098, B:35:0x00a3, B:24:0x005e, B:30:0x007e, B:27:0x006d), top: B:47:0x0026 }] */
    /* JADX WARN: Code duplicated, block: B:37:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:38:0x00c4 A[Catch: all -> 0x00ea, PHI: r10 r11
      0x00c4: PHI (r10v6 com.pspdfkit.instant.internal.jni.NativeServerChangeApplicator) = 
      (r10v3 com.pspdfkit.instant.internal.jni.NativeServerChangeApplicator)
      (r10v16 com.pspdfkit.instant.internal.jni.NativeServerChangeApplicator)
     binds: [B:36:0x00c1, B:18:0x004d] A[DONT_GENERATE, DONT_INLINE]
      0x00c4: PHI (r11v17 java.lang.Object) = (r11v14 java.lang.Object), (r11v1 java.lang.Object) binds: [B:36:0x00c1, B:18:0x004d] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #0 {all -> 0x00ea, blocks: (B:18:0x004d, B:38:0x00c4, B:21:0x0056, B:33:0x0098, B:35:0x00a3, B:24:0x005e, B:30:0x007e, B:27:0x006d), top: B:47:0x0026 }] */
    /* JADX WARN: Code duplicated, block: B:39:0x00c6 A[PHI: r10
      0x00c6: PHI (r10v4 com.pspdfkit.instant.internal.jni.NativeServerChangeApplicator) = 
      (r10v3 com.pspdfkit.instant.internal.jni.NativeServerChangeApplicator)
      (r10v6 com.pspdfkit.instant.internal.jni.NativeServerChangeApplicator)
     binds: [B:34:0x00a1, B:38:0x00c4] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00e4, code lost:
    
        if (r9.a(r0) == r1) goto L41;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(com.pspdfkit.instant.internal.jni.NativeServerChangeApplicator r10, kotlin.coroutines.jvm.internal.ContinuationImpl r11) {
        /*
            Method dump skipped, instruction units count: 244
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pspdfkit.internal.zk.a(com.pspdfkit.instant.internal.jni.NativeServerChangeApplicator, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    public final synchronized void a() {
        a aVar;
        NativeProgressReporter nativeProgressReporter = this.d;
        if (nativeProgressReporter == null || (aVar = this.e) == null) {
            return;
        }
        nativeProgressReporter.removeObserver(aVar);
        this.d = null;
        this.e = null;
    }

    @Override // com.pspdfkit.internal.v4
    public final void a(NativeServerDocumentLayer nativeServerDocumentLayer, NativeInstantError nativeInstantError) {
        a aVar;
        nativeServerDocumentLayer.getClass();
        nativeInstantError.getClass();
        InstantSyncException instantSyncException = new InstantSyncException(lr.a(nativeInstantError.getCode()), nativeInstantError.getMessage(), nativeInstantError.getUnderlyingError());
        if (instantSyncException.getErrorCode() == InstantErrorCode.ALREADY_SYNCING) {
            PdfLog.w("Nutri.InstAnnotSyncMgr", "Sync skipped (already in progress). ID: %s; Message: %s", instantSyncException.getErrorCode().name(), instantSyncException.getMessage());
            SendChannel<? super InstantProgress> sendChannel = this.f;
            if (sendChannel != null) {
                this.f = null;
                sendChannel.close(null);
            }
            synchronized (this) {
                NativeProgressReporter nativeProgressReporter = this.d;
                if (nativeProgressReporter == null || (aVar = this.e) == null) {
                    return;
                }
                nativeProgressReporter.removeObserver(aVar);
                this.d = null;
                this.e = null;
                return;
            }
        }
        SendChannel<? super InstantProgress> sendChannel2 = this.f;
        if (sendChannel2 != null) {
            this.f = null;
            sendChannel2.close(instantSyncException);
        }
        a();
        pl plVar = this.c;
        plVar.getClass();
        hm hmVarA = plVar.a();
        if (hmVarA != null) {
            Iterator<InstantDocumentListener> it = plVar.b.iterator();
            it.getClass();
            while (it.hasNext()) {
                it.next().onSyncError(hmVarA, instantSyncException);
            }
        }
        this.c.b();
        InstantErrorCode errorCode = instantSyncException.getErrorCode();
        errorCode.getClass();
        switch (jj.a[errorCode.ordinal()]) {
            case 1:
                t4 t4Var = this.a.T;
                if (t4Var.j) {
                    t4Var.d();
                    return;
                }
                return;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
                PdfLog.e("Nutri.InstAnnotSyncMgr", "Failed sync. ID: %s; Message: %s", instantSyncException.getErrorCode().name(), instantSyncException.getMessage());
                return;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
