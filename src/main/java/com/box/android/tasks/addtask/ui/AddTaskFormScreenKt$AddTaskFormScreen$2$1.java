package com.box.android.tasks.addtask.ui;

import androidx.compose.material3.SnackbarHostState;
import androidx.compose.runtime.State;
import com.box.android.cpl.Store;
import com.box.android.tasks.addtask.cpl.AddTaskFormReducer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: AddTaskFormScreen.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.tasks.addtask.ui.AddTaskFormScreenKt$AddTaskFormScreen$2$1", f = "AddTaskFormScreen.kt", i = {}, l = {55}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class AddTaskFormScreenKt$AddTaskFormScreen$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $errorMessage;
    final /* synthetic */ SnackbarHostState $snackbarHostState;
    final /* synthetic */ State<AddTaskFormReducer.State> $state$delegate;
    final /* synthetic */ Store<AddTaskFormReducer.State, AddTaskFormReducer.Action> $store;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AddTaskFormScreenKt$AddTaskFormScreen$2$1(SnackbarHostState snackbarHostState, String str, Store<AddTaskFormReducer.State, AddTaskFormReducer.Action> store, State<AddTaskFormReducer.State> state, Continuation<? super AddTaskFormScreenKt$AddTaskFormScreen$2$1> continuation) {
        super(2, continuation);
        this.$snackbarHostState = snackbarHostState;
        this.$errorMessage = str;
        this.$store = store;
        this.$state$delegate = state;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AddTaskFormScreenKt$AddTaskFormScreen$2$1(this.$snackbarHostState, this.$errorMessage, this.$store, this.$state$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AddTaskFormScreenKt$AddTaskFormScreen$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (AddTaskFormScreenKt.AddTaskFormScreen$lambda$1(this.$state$delegate).getSubmitError()) {
                this.label = 1;
                if (SnackbarHostState.showSnackbar$default(this.$snackbarHostState, this.$errorMessage, null, false, null, this, 14, null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        this.$store.send(AddTaskFormReducer.Action.ErrorShown.INSTANCE);
        return Unit.INSTANCE;
    }
}
