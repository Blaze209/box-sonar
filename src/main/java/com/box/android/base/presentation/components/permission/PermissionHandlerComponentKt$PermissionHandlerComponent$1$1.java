package com.box.android.base.presentation.components.permission;

import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: PermissionHandlerComponent.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.base.presentation.components.permission.PermissionHandlerComponentKt$PermissionHandlerComponent$1$1", f = "PermissionHandlerComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class PermissionHandlerComponentKt$PermissionHandlerComponent$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $permission;
    final /* synthetic */ ManagedActivityResultLauncher<String, Boolean> $permissionRequestLauncher;
    final /* synthetic */ State<PermissionReducer.State> $state$delegate;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PermissionHandlerComponentKt$PermissionHandlerComponent$1$1(ManagedActivityResultLauncher<String, Boolean> managedActivityResultLauncher, String str, State<PermissionReducer.State> state, Continuation<? super PermissionHandlerComponentKt$PermissionHandlerComponent$1$1> continuation) {
        super(2, continuation);
        this.$permissionRequestLauncher = managedActivityResultLauncher;
        this.$permission = str;
        this.$state$delegate = state;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PermissionHandlerComponentKt$PermissionHandlerComponent$1$1(this.$permissionRequestLauncher, this.$permission, this.$state$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PermissionHandlerComponentKt$PermissionHandlerComponent$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            if (PermissionHandlerComponentKt.PermissionHandlerComponent$lambda$0(this.$state$delegate).getPermissionRequest() != null) {
                this.$permissionRequestLauncher.launch(this.$permission);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
