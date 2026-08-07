package com.pspdfkit.internal;

import com.pspdfkit.document.DocumentPermissions;
import com.pspdfkit.instant.document.InstantDocumentState;
import com.pspdfkit.instant.exceptions.InstantException;
import com.pspdfkit.instant.internal.jni.NativeAsset;
import com.pspdfkit.instant.internal.jni.NativeInstantError;
import com.pspdfkit.instant.internal.jni.NativeInstantJWT;
import com.pspdfkit.instant.internal.jni.NativeLayerCapabilities;
import com.pspdfkit.instant.internal.jni.NativeProgressReporter;
import com.pspdfkit.instant.internal.jni.NativeServerChangeApplicator;
import com.pspdfkit.instant.internal.jni.NativeServerDocumentLayer;
import com.pspdfkit.instant.internal.jni.NativeServerDocumentLayerDelegate;
import com.pspdfkit.instant.internal.jni.NativeSyncRequestType;
import com.pspdfkit.instant.listeners.InstantDocumentListener;
import com.pspdfkit.utils.PdfLog;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.lang.ref.WeakReference;
import java.util.EnumSet;
import java.util.Iterator;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: classes3.dex */
public final class pl extends NativeServerDocumentLayerDelegate {
    public final WeakReference<gm> a;
    public final go<InstantDocumentListener> b = new go<>();
    public WeakReference<v4> c = new WeakReference<>(null);
    public WeakReference<q5> d = new WeakReference<>(null);
    public InstantDocumentState e = InstantDocumentState.UNKNOWN;

    @DebugMetadata(c = "com.pspdfkit.internal.instant.client.InstantDocumentDelegate$wantsToApplyChanges$1", f = "InstantDocumentDelegate.kt", i = {}, l = {136}, m = "invokeSuspend", n = {}, nl = {135}, s = {}, v = 2)
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int a;
        public final /* synthetic */ v4 b;
        public final /* synthetic */ NativeServerDocumentLayer c;
        public final /* synthetic */ NativeServerChangeApplicator d;

        /* JADX INFO: renamed from: com.pspdfkit.internal.pl$a$a, reason: collision with other inner class name */
        @DebugMetadata(c = "com.pspdfkit.internal.instant.client.InstantDocumentDelegate$wantsToApplyChanges$1$completed$1", f = "InstantDocumentDelegate.kt", i = {}, l = {Token.SCRIPT}, m = "invokeSuspend", n = {}, nl = {138}, s = {}, v = 2)
        public static final class C0283a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
            public int a;
            public final /* synthetic */ v4 b;
            public final /* synthetic */ NativeServerDocumentLayer c;
            public final /* synthetic */ NativeServerChangeApplicator d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0283a(v4 v4Var, NativeServerDocumentLayer nativeServerDocumentLayer, NativeServerChangeApplicator nativeServerChangeApplicator, Continuation<? super C0283a> continuation) {
                super(2, continuation);
                this.b = v4Var;
                this.c = nativeServerDocumentLayer;
                this.d = nativeServerChangeApplicator;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C0283a(this.b, this.c, this.d, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
                return ((C0283a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.a;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    v4 v4Var = this.b;
                    NativeServerDocumentLayer nativeServerDocumentLayer = this.c;
                    NativeServerChangeApplicator nativeServerChangeApplicator = this.d;
                    this.a = 1;
                    if (v4Var.a(nativeServerDocumentLayer, nativeServerChangeApplicator, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Boxing.boxBoolean(true);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(v4 v4Var, NativeServerDocumentLayer nativeServerDocumentLayer, NativeServerChangeApplicator nativeServerChangeApplicator, Continuation<? super a> continuation) {
            super(2, continuation);
            this.b = v4Var;
            this.c = nativeServerDocumentLayer;
            this.d = nativeServerChangeApplicator;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new a(this.b, this.c, this.d, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                C0283a c0283a = new C0283a(this.b, this.c, this.d, null);
                this.a = 1;
                obj = TimeoutKt.withTimeoutOrNull(5000L, c0283a, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            if (((Boolean) obj) == null) {
                PdfLog.w("Nutri.InstDocDelegate", "wantsToApplyChanges timed out after 5000ms", new Object[0]);
            }
            return Unit.INSTANCE;
        }
    }

    public pl(gm gmVar) {
        this.a = new WeakReference<>(gmVar);
        gmVar.c.setDelegate(this);
    }

    public final hm a() {
        hm hmVar;
        gm gmVar = this.a.get();
        if (gmVar == null) {
            return null;
        }
        synchronized (gmVar) {
            hmVar = gmVar.g;
        }
        return hmVar;
    }

    public final void b() {
        hm hmVarA = a();
        if (hmVarA == null) {
            return;
        }
        InstantDocumentState instantDocumentStateB = hmVarA.S.getInternal().b();
        instantDocumentStateB.getClass();
        if (this.e == instantDocumentStateB) {
            return;
        }
        this.e = instantDocumentStateB;
        Iterator<InstantDocumentListener> it = this.b.iterator();
        it.getClass();
        while (it.hasNext()) {
            it.next().onDocumentStateChanged(hmVarA, instantDocumentStateB);
        }
    }

    @Override // com.pspdfkit.instant.internal.jni.NativeServerDocumentLayerDelegate
    public final void didBeginLoadingAsset(NativeServerDocumentLayer nativeServerDocumentLayer, String str, NativeProgressReporter nativeProgressReporter) {
        nativeServerDocumentLayer.getClass();
        str.getClass();
        nativeProgressReporter.getClass();
        q5 q5Var = this.d.get();
        if (q5Var != null) {
            q5Var.a(str);
        }
    }

    @Override // com.pspdfkit.instant.internal.jni.NativeServerDocumentLayerDelegate
    public final void didBeginReceivingData(NativeServerDocumentLayer nativeServerDocumentLayer) {
        nativeServerDocumentLayer.getClass();
        v4 v4Var = this.c.get();
        if (v4Var != null) {
            v4Var.a(nativeServerDocumentLayer);
        }
    }

    @Override // com.pspdfkit.instant.internal.jni.NativeServerDocumentLayerDelegate
    public final void didBeginSendingAssetData(NativeServerDocumentLayer nativeServerDocumentLayer, String str, NativeProgressReporter nativeProgressReporter) {
        nativeServerDocumentLayer.getClass();
        str.getClass();
        nativeProgressReporter.getClass();
    }

    @Override // com.pspdfkit.instant.internal.jni.NativeServerDocumentLayerDelegate
    public final void didBeginSyncCycle(NativeServerDocumentLayer nativeServerDocumentLayer) {
        nativeServerDocumentLayer.getClass();
        v4 v4Var = this.c.get();
        if (v4Var != null) {
            v4Var.c(nativeServerDocumentLayer);
        }
    }

    @Override // com.pspdfkit.instant.internal.jni.NativeServerDocumentLayerDelegate
    public final void didBeginTransfer(NativeServerDocumentLayer nativeServerDocumentLayer, NativeSyncRequestType nativeSyncRequestType, NativeProgressReporter nativeProgressReporter, NativeProgressReporter nativeProgressReporter2) {
        nativeServerDocumentLayer.getClass();
        nativeSyncRequestType.getClass();
        nativeProgressReporter.getClass();
        v4 v4Var = this.c.get();
        if (v4Var != null) {
            v4Var.a(nativeServerDocumentLayer, nativeSyncRequestType, nativeProgressReporter2, nativeProgressReporter);
        }
    }

    @Override // com.pspdfkit.instant.internal.jni.NativeServerDocumentLayerDelegate
    public final void didDetectCorruption(NativeServerDocumentLayer nativeServerDocumentLayer) {
        nativeServerDocumentLayer.getClass();
        hm hmVarA = a();
        if (hmVarA == null) {
            return;
        }
        Iterator<InstantDocumentListener> it = this.b.iterator();
        it.getClass();
        while (it.hasNext()) {
            it.next().onDocumentCorrupted(hmVarA);
        }
    }

    @Override // com.pspdfkit.instant.internal.jni.NativeServerDocumentLayerDelegate
    public final void didFailLoadingAsset(NativeServerDocumentLayer nativeServerDocumentLayer, String str, NativeInstantError nativeInstantError) {
        nativeServerDocumentLayer.getClass();
        str.getClass();
        nativeInstantError.getClass();
        q5 q5Var = this.d.get();
        if (q5Var != null) {
            q5Var.a(str, nativeInstantError);
        }
    }

    @Override // com.pspdfkit.instant.internal.jni.NativeServerDocumentLayerDelegate
    public final void didFailSendingAssetData(NativeServerDocumentLayer nativeServerDocumentLayer, String str, NativeInstantError nativeInstantError) {
        nativeServerDocumentLayer.getClass();
        str.getClass();
        nativeInstantError.getClass();
    }

    @Override // com.pspdfkit.instant.internal.jni.NativeServerDocumentLayerDelegate
    public final void didFailSyncing(NativeServerDocumentLayer nativeServerDocumentLayer, NativeInstantError nativeInstantError) {
        nativeServerDocumentLayer.getClass();
        nativeInstantError.getClass();
        v4 v4Var = this.c.get();
        if (v4Var != null) {
            v4Var.a(nativeServerDocumentLayer, nativeInstantError);
        }
    }

    @Override // com.pspdfkit.instant.internal.jni.NativeServerDocumentLayerDelegate
    public final void didFailUpdatingAuthenticationToken(NativeServerDocumentLayer nativeServerDocumentLayer, NativeInstantError nativeInstantError) {
        nativeServerDocumentLayer.getClass();
        nativeInstantError.getClass();
        InstantException instantException = new InstantException(lr.a(nativeInstantError.getCode()), nativeInstantError.getMessage(), nativeInstantError.getUnderlyingError());
        hm hmVarA = a();
        if (hmVarA == null) {
            return;
        }
        Iterator<InstantDocumentListener> it = this.b.iterator();
        it.getClass();
        while (it.hasNext()) {
            it.next().onAuthenticationFailed(hmVarA, instantException);
        }
    }

    @Override // com.pspdfkit.instant.internal.jni.NativeServerDocumentLayerDelegate
    public final void didFinishLoadingAsset(NativeServerDocumentLayer nativeServerDocumentLayer, NativeAsset nativeAsset) {
        nativeServerDocumentLayer.getClass();
        nativeAsset.getClass();
        q5 q5Var = this.d.get();
        if (q5Var != null) {
            q5Var.a(nativeAsset);
        }
    }

    @Override // com.pspdfkit.instant.internal.jni.NativeServerDocumentLayerDelegate
    public final void didFinishSendingAssetData(NativeServerDocumentLayer nativeServerDocumentLayer, String str) {
        nativeServerDocumentLayer.getClass();
        str.getClass();
    }

    @Override // com.pspdfkit.instant.internal.jni.NativeServerDocumentLayerDelegate
    public final void didFinishSyncing(NativeServerDocumentLayer nativeServerDocumentLayer) {
        nativeServerDocumentLayer.getClass();
        v4 v4Var = this.c.get();
        if (v4Var != null) {
            v4Var.b(nativeServerDocumentLayer);
        }
    }

    @Override // com.pspdfkit.instant.internal.jni.NativeServerDocumentLayerDelegate
    public final void didUpdateAuthenticationToken(NativeServerDocumentLayer nativeServerDocumentLayer, NativeInstantJWT nativeInstantJWT, EnumSet<NativeLayerCapabilities> enumSet) {
        nativeServerDocumentLayer.getClass();
        nativeInstantJWT.getClass();
        enumSet.getClass();
        hm hmVarA = a();
        if (hmVarA == null) {
            return;
        }
        synchronized (hmVarA) {
            enumSet.getClass();
            if (!Intrinsics.areEqual(hmVarA.U, enumSet)) {
                hmVarA.U.clear();
                hmVarA.U.addAll(enumSet);
                EnumSet enumSetClone = hmVarA.G.clone();
                enumSetClone.getClass();
                if (enumSet.contains(NativeLayerCapabilities.WRITE)) {
                    enumSetClone.add(DocumentPermissions.ANNOTATIONS_AND_FORMS);
                } else {
                    enumSetClone.remove(DocumentPermissions.ANNOTATIONS_AND_FORMS);
                }
                hmVarA.G = enumSetClone;
            }
        }
        String strRawValue = nativeInstantJWT.rawValue();
        strRawValue.getClass();
        Iterator<InstantDocumentListener> it = this.b.iterator();
        it.getClass();
        while (it.hasNext()) {
            it.next().onAuthenticationFinished(hmVarA, strRawValue);
        }
    }

    @Override // com.pspdfkit.instant.internal.jni.NativeServerDocumentLayerDelegate
    public final void isBecomingInvalid(NativeServerDocumentLayer nativeServerDocumentLayer) {
        nativeServerDocumentLayer.getClass();
        hm hmVarA = a();
        if (hmVarA == null) {
            return;
        }
        hmVarA.setListeningToServerChanges(false);
        hmVarA.T.a(Long.MAX_VALUE);
        Iterator<InstantDocumentListener> it = this.b.iterator();
        it.getClass();
        while (it.hasNext()) {
            it.next().onDocumentInvalidated(hmVarA);
        }
        b();
    }

    @Override // com.pspdfkit.instant.internal.jni.NativeServerDocumentLayerDelegate
    public final void wantsToApplyChanges(NativeServerDocumentLayer nativeServerDocumentLayer, NativeServerChangeApplicator nativeServerChangeApplicator) throws InterruptedException {
        nativeServerDocumentLayer.getClass();
        nativeServerChangeApplicator.getClass();
        v4 v4Var = this.c.get();
        if (v4Var == null) {
            return;
        }
        BuildersKt__BuildersKt.runBlocking$default(null, new a(v4Var, nativeServerDocumentLayer, nativeServerChangeApplicator, null), 1, null);
    }
}
