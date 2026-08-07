package com.box.android.hubs.hubDetails.presentation;

import androidx.compose.material3.SnackbarHostState;
import androidx.compose.runtime.MutableState;
import external.sdk.pendo.io.mozilla.javascript.Context;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: HubDetailsScreen.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.hubs.hubDetails.presentation.HubDetailsScreenKt$HubDetailsViewEffectProcessor$2$1", f = "HubDetailsScreen.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class HubDetailsScreenKt$HubDetailsViewEffectProcessor$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CoroutineScope $coroutineScope;
    final /* synthetic */ String $errorMessage;
    final /* synthetic */ SnackbarHostState $snackbarHostState;
    final /* synthetic */ MutableState<Job> $snackbarJob$delegate;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HubDetailsScreenKt$HubDetailsViewEffectProcessor$2$1(CoroutineScope coroutineScope, SnackbarHostState snackbarHostState, String str, MutableState<Job> mutableState, Continuation<? super HubDetailsScreenKt$HubDetailsViewEffectProcessor$2$1> continuation) {
        super(2, continuation);
        this.$coroutineScope = coroutineScope;
        this.$snackbarHostState = snackbarHostState;
        this.$errorMessage = str;
        this.$snackbarJob$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HubDetailsScreenKt$HubDetailsViewEffectProcessor$2$1(this.$coroutineScope, this.$snackbarHostState, this.$errorMessage, this.$snackbarJob$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HubDetailsScreenKt$HubDetailsViewEffectProcessor$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: renamed from: com.box.android.hubs.hubDetails.presentation.HubDetailsScreenKt$HubDetailsViewEffectProcessor$2$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: HubDetailsScreen.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.hubs.hubDetails.presentation.HubDetailsScreenKt$HubDetailsViewEffectProcessor$2$1$1", f = "HubDetailsScreen.kt", i = {}, l = {Context.VERSION_1_7}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $errorMessage;
        final /* synthetic */ SnackbarHostState $snackbarHostState;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(SnackbarHostState snackbarHostState, String str, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$snackbarHostState = snackbarHostState;
            this.$errorMessage = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$snackbarHostState, this.$errorMessage, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (SnackbarHostState.showSnackbar$default(this.$snackbarHostState, this.$errorMessage, null, false, null, this, 14, null) == coroutine_suspended) {
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

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        this.$snackbarJob$delegate.setValue(BuildersKt__Builders_commonKt.launch$default(this.$coroutineScope, null, null, new AnonymousClass1(this.$snackbarHostState, this.$errorMessage, null), 3, null));
        return Unit.INSTANCE;
    }
}
