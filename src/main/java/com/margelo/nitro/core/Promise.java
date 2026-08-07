package com.margelo.nitro.core;

import androidx.exifinterface.media.ExifInterface;
import com.box.android.domain.metrics.Gen204FileActivityEventLogger;
import com.box.brownfieldApi.featuresNavigator.activities.ReactNativeFeatureActivity;
import com.facebook.jni.HybridData;
import com.facebook.react.bridge.BaseJavaModule;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.concurrent.ThreadsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: Promise.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 #*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0003!\"#B\t\b\u0016¢\u0006\u0004\b\u0003\u0010\u0004B\u0011\b\u0013\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0003\u0010\u0007J\u0013\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00028\u0000¢\u0006\u0002\u0010\fJ\u000e\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fJ/\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002!\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\n0\u0012J/\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002!\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\n0\u0012J\u000e\u0010\u0017\u001a\u00028\u0000H\u0086@¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0082 J\u0011\u0010\u001a\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0082 J\u0011\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001dH\u0082 J\u0011\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001fH\u0082 J\t\u0010 \u001a\u00020\u0006H\u0082 R\u0010\u0010\b\u001a\u00020\u00068\u0002X\u0083\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/margelo/nitro/core/Promise;", ExifInterface.GPS_DIRECTION_TRUE, "", "<init>", "()V", "hybridData", "Lcom/facebook/jni/HybridData;", "(Lcom/facebook/jni/HybridData;)V", "mHybridData", Gen204FileActivityEventLogger.ACTION_RESOLVE, "", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "(Ljava/lang/Object;)V", "reject", "error", "", "then", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "catch", "throwable", "await", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "nativeResolve", "nativeReject", "addOnResolvedListener", "callback", "Lcom/margelo/nitro/core/Promise$OnResolvedCallback;", "addOnRejectedListener", "Lcom/margelo/nitro/core/Promise$OnRejectedCallback;", "initHybrid", "OnResolvedCallback", "OnRejectedCallback", "Companion", "react-native-nitro-modules_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Promise<T> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final CoroutineScope defaultScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault());
    private final HybridData mHybridData;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: Promise.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\bã\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'¨\u0006\u0006"}, d2 = {"Lcom/margelo/nitro/core/Promise$OnRejectedCallback;", "", "onRejected", "", "error", "", "react-native-nitro-modules_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    interface OnRejectedCallback {
        void onRejected(Throwable error);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: Promise.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bã\u0080\u0001\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001H'¨\u0006\u0005"}, d2 = {"Lcom/margelo/nitro/core/Promise$OnResolvedCallback;", "", "onResolved", "", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "react-native-nitro-modules_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    interface OnResolvedCallback {
        void onResolved(Object result);
    }

    private final native void addOnRejectedListener(OnRejectedCallback callback);

    private final native void addOnResolvedListener(OnResolvedCallback callback);

    private final native HybridData initHybrid();

    private final native void nativeReject(Throwable error);

    private final native void nativeResolve(Object result);

    public Promise() {
        this.mHybridData = initHybrid();
    }

    private Promise(HybridData hybridData) {
        this.mHybridData = hybridData;
    }

    public final void resolve(T result) {
        nativeResolve(result);
    }

    public final void reject(Throwable error) {
        Intrinsics.checkNotNullParameter(error, "error");
        nativeReject(error);
    }

    public final Promise<T> then(final Function1<? super T, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        addOnResolvedListener(new OnResolvedCallback() { // from class: com.margelo.nitro.core.Promise$$ExternalSyntheticLambda0
            @Override // com.margelo.nitro.core.Promise.OnResolvedCallback
            public final void onResolved(Object obj) {
                Promise.then$lambda$0(listener, obj);
            }
        });
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void then$lambda$0(Function1 function1, Object obj) {
        if (obj == null) {
            obj = null;
        }
        if (obj == null) {
            throw new Error("Failed to cast Object to T!");
        }
        function1.invoke(obj);
    }

    /* JADX INFO: renamed from: catch, reason: not valid java name */
    public final Promise<T> m13840catch(Function1<? super Throwable, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        addOnRejectedListener(new PromiseKt$sam$com_margelo_nitro_core_Promise_OnRejectedCallback$0(listener));
        return this;
    }

    public final Object await(Continuation<? super T> continuation) {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        final SafeContinuation safeContinuation2 = safeContinuation;
        then(new Function1<T, Unit>() { // from class: com.margelo.nitro.core.Promise$await$2$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                invoke2(obj);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(T t) {
                Continuation<T> continuation2 = safeContinuation2;
                Result.Companion companion = Result.INSTANCE;
                continuation2.resumeWith(Result.m14780constructorimpl(t));
            }
        });
        m13840catch(new Function1<Throwable, Unit>() { // from class: com.margelo.nitro.core.Promise$await$2$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable error) {
                Intrinsics.checkNotNullParameter(error, "error");
                Continuation<T> continuation2 = safeContinuation2;
                Result.Companion companion = Result.INSTANCE;
                continuation2.resumeWith(Result.m14780constructorimpl(ResultKt.createFailure(error)));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* JADX INFO: compiled from: Promise.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J?\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007\"\u0004\b\u0001\u0010\b2\b\b\u0002\u0010\t\u001a\u00020\u00052\u001c\u0010\n\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000b¢\u0006\u0002\u0010\rJ \u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007\"\u0004\b\u0001\u0010\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\b0\u000fJ\u001f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007\"\u0004\b\u0001\u0010\b2\u0006\u0010\u0011\u001a\u0002H\b¢\u0006\u0002\u0010\u0012J\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007\"\u0004\b\u0001\u0010\b2\u0006\u0010\u0014\u001a\u00020\u0015R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/margelo/nitro/core/Promise$Companion;", "", "<init>", "()V", "defaultScope", "Lkotlinx/coroutines/CoroutineScope;", BaseJavaModule.METHOD_TYPE_ASYNC, "Lcom/margelo/nitro/core/Promise;", ExifInterface.GPS_DIRECTION_TRUE, "scope", "run", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function1;)Lcom/margelo/nitro/core/Promise;", "parallel", "Lkotlin/Function0;", "resolved", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "(Ljava/lang/Object;)Lcom/margelo/nitro/core/Promise;", "rejected", "error", "", "react-native-nitro-modules_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ Promise async$default(Companion companion, CoroutineScope coroutineScope, Function1 function1, int i, Object obj) {
            if ((i & 1) != 0) {
                coroutineScope = Promise.defaultScope;
            }
            return companion.async(coroutineScope, function1);
        }

        public final <T> Promise<T> async(CoroutineScope scope, Function1<? super Continuation<? super T>, ? extends Object> run) {
            Intrinsics.checkNotNullParameter(scope, "scope");
            Intrinsics.checkNotNullParameter(run, "run");
            Promise<T> promise = new Promise<>();
            BuildersKt__Builders_commonKt.launch$default(scope, null, null, new Promise$Companion$async$1(run, promise, null), 3, null);
            return promise;
        }

        public final <T> Promise<T> parallel(final Function0<? extends T> run) {
            Intrinsics.checkNotNullParameter(run, "run");
            final Promise<T> promise = new Promise<>();
            ThreadsKt.thread$default(false, false, null, null, 0, new Function0() { // from class: com.margelo.nitro.core.Promise$Companion$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Promise.Companion.parallel$lambda$0(run, promise);
                }
            }, 31, null);
            return promise;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public static final Unit parallel$lambda$0(Function0 function0, Promise promise) {
            try {
                promise.resolve(function0.invoke());
            } catch (Throwable th) {
                promise.reject(th);
            }
            return Unit.INSTANCE;
        }

        public final <T> Promise<T> resolved(T result) {
            Promise<T> promise = new Promise<>();
            promise.resolve(result);
            return promise;
        }

        public final <T> Promise<T> rejected(Throwable error) {
            Intrinsics.checkNotNullParameter(error, "error");
            Promise<T> promise = new Promise<>();
            promise.reject(error);
            return promise;
        }
    }
}
