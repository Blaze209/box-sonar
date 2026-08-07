package com.pspdfkit.internal;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import androidx.core.content.ContextCompat;
import io.nutrient.domain.ConnectivityObserver;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: loaded from: classes3.dex */
public final class da implements ConnectivityObserver {
    public final ConnectivityManager a;

    @DebugMetadata(c = "io.nutrient.internal.data.core.ConnectivityObserverImpl$isConnected$1", f = "ConnectivityObserverImpl.kt", i = {0, 0}, l = {68}, m = "invokeSuspend", n = {"$this$callbackFlow", "callback"}, nl = {71}, s = {"L$0", "L$1"}, v = 2)
    public static final class a extends SuspendLambda implements Function2<ProducerScope<? super Boolean>, Continuation<? super Unit>, Object> {
        public Object a;
        public int b;
        public /* synthetic */ Object c;

        /* JADX INFO: renamed from: com.pspdfkit.internal.da$a$a, reason: collision with other inner class name */
        public static final class C0263a extends ConnectivityManager.NetworkCallback {
            public final /* synthetic */ ProducerScope<Boolean> a;

            /* JADX WARN: Multi-variable type inference failed */
            public C0263a(ProducerScope<? super Boolean> producerScope) {
                this.a = producerScope;
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public final void onAvailable(Network network) {
                network.getClass();
                super.onAvailable(network);
                this.a.mo11206trySendJP2dKIU(Boolean.TRUE);
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public final void onLosing(Network network, int i) {
                network.getClass();
                super.onLosing(network, i);
                this.a.mo11206trySendJP2dKIU(Boolean.FALSE);
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public final void onLost(Network network) {
                network.getClass();
                super.onLost(network);
                this.a.mo11206trySendJP2dKIU(Boolean.FALSE);
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public final void onUnavailable() {
                super.onUnavailable();
                this.a.mo11206trySendJP2dKIU(Boolean.FALSE);
            }
        }

        public a(Continuation<? super a> continuation) {
            super(2, continuation);
        }

        public static final Unit a(da daVar, C0263a c0263a) {
            ConnectivityManager connectivityManager = daVar.a;
            if (connectivityManager != null) {
                connectivityManager.unregisterNetworkCallback(c0263a);
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            a aVar = da.this.new a(continuation);
            aVar.c = obj;
            return aVar;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ProducerScope<? super Boolean> producerScope, Continuation<? super Unit> continuation) {
            a aVar = da.this.new a(continuation);
            aVar.c = producerScope;
            return aVar.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            ProducerScope producerScope = (ProducerScope) this.c;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.b;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final C0263a c0263a = new C0263a(producerScope);
                ConnectivityManager connectivityManager = da.this.a;
                if (connectivityManager != null) {
                    connectivityManager.registerDefaultNetworkCallback(c0263a);
                }
                final da daVar = da.this;
                Function0 function0 = new Function0() { // from class: com.pspdfkit.internal.da$a$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return da.a.a(daVar, c0263a);
                    }
                };
                this.c = SpillingKt.nullOutSpilledVariable(producerScope);
                this.a = SpillingKt.nullOutSpilledVariable(c0263a);
                this.b = 1;
                if (ProduceKt.awaitClose(producerScope, function0, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    public da(Context context) {
        context.getClass();
        this.a = (ConnectivityManager) ContextCompat.getSystemService(context, ConnectivityManager.class);
    }

    @Override // io.nutrient.domain.ConnectivityObserver
    public final Flow<Boolean> isConnected() {
        return FlowKt.distinctUntilChanged(FlowKt.callbackFlow(new a(null)));
    }

    @Override // io.nutrient.domain.ConnectivityObserver
    public final boolean isConnectionAvailable() {
        Network activeNetwork;
        NetworkCapabilities networkCapabilities;
        ConnectivityManager connectivityManager = this.a;
        if (connectivityManager == null || (activeNetwork = connectivityManager.getActiveNetwork()) == null || (networkCapabilities = this.a.getNetworkCapabilities(activeNetwork)) == null) {
            return false;
        }
        return networkCapabilities.hasTransport(1) || networkCapabilities.hasTransport(0);
    }
}
