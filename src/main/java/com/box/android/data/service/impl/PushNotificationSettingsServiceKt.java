package com.box.android.data.service.impl;

import android.content.SharedPreferences;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: PushNotificationSettingsService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\"\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0002¨\u0006\u0007"}, d2 = {"observe", "Lkotlinx/coroutines/flow/Flow;", "", "Landroid/content/SharedPreferences;", "key", "", "default", "data_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class PushNotificationSettingsServiceKt {

    /* JADX INFO: renamed from: com.box.android.data.service.impl.PushNotificationSettingsServiceKt$observe$1, reason: invalid class name */
    /* JADX INFO: compiled from: PushNotificationSettingsService.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.PushNotificationSettingsServiceKt$observe$1", f = "PushNotificationSettingsService.kt", i = {0, 0}, l = {255}, m = "invokeSuspend", n = {"$this$channelFlow", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER}, s = {"L$0", "L$1"}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<ProducerScope<? super Boolean>, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $default;
        final /* synthetic */ String $key;
        final /* synthetic */ SharedPreferences $this_observe;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(SharedPreferences sharedPreferences, String str, boolean z, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$this_observe = sharedPreferences;
            this.$key = str;
            this.$default = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$this_observe, this.$key, this.$default, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ProducerScope<? super Boolean> producerScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            final ProducerScope producerScope = (ProducerScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                producerScope.mo11206trySendJP2dKIU(Boxing.boxBoolean(this.$this_observe.getBoolean(this.$key, this.$default)));
                final String str = this.$key;
                final SharedPreferences sharedPreferences = this.$this_observe;
                final boolean z = this.$default;
                final SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener = new SharedPreferences.OnSharedPreferenceChangeListener() { // from class: com.box.android.data.service.impl.PushNotificationSettingsServiceKt$observe$1$$ExternalSyntheticLambda0
                    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
                    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences2, String str2) {
                        PushNotificationSettingsServiceKt.AnonymousClass1.invokeSuspend$lambda$0(str, producerScope, sharedPreferences, z, sharedPreferences2, str2);
                    }
                };
                this.$this_observe.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
                final SharedPreferences sharedPreferences2 = this.$this_observe;
                this.L$0 = SpillingKt.nullOutSpilledVariable(producerScope);
                this.L$1 = SpillingKt.nullOutSpilledVariable(onSharedPreferenceChangeListener);
                this.label = 1;
                if (ProduceKt.awaitClose(producerScope, new Function0() { // from class: com.box.android.data.service.impl.PushNotificationSettingsServiceKt$observe$1$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PushNotificationSettingsServiceKt.AnonymousClass1.invokeSuspend$lambda$1(sharedPreferences2, onSharedPreferenceChangeListener);
                    }
                }, this) == coroutine_suspended) {
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

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$lambda$0(String str, ProducerScope producerScope, SharedPreferences sharedPreferences, boolean z, SharedPreferences sharedPreferences2, String str2) {
            if (Intrinsics.areEqual(str2, str)) {
                producerScope.mo11206trySendJP2dKIU(Boolean.valueOf(sharedPreferences.getBoolean(str, z)));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$1(SharedPreferences sharedPreferences, SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
            sharedPreferences.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
            return Unit.INSTANCE;
        }
    }

    public static final Flow<Boolean> observe(SharedPreferences sharedPreferences, String key, boolean z) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        return FlowKt.channelFlow(new AnonymousClass1(sharedPreferences, key, z, null));
    }

    public static /* synthetic */ Flow observe$default(SharedPreferences sharedPreferences, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return observe(sharedPreferences, str, z);
    }
}
