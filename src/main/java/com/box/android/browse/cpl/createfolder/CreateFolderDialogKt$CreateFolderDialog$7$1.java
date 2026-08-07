package com.box.android.browse.cpl.createfolder;

import android.content.Context;
import androidx.compose.runtime.State;
import com.box.android.base.presentation.BoxPresentationUtils;
import com.box.android.cpl.Store;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: CreateFolderDialog.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.browse.cpl.createfolder.CreateFolderDialogKt$CreateFolderDialog$7$1", f = "CreateFolderDialog.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class CreateFolderDialogKt$CreateFolderDialog$7$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ State<CreateFolderReducer.State> $state$delegate;
    final /* synthetic */ Store<CreateFolderReducer.State, CreateFolderReducer.Action> $store;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CreateFolderDialogKt$CreateFolderDialog$7$1(State<CreateFolderReducer.State> state, Context context, Store<CreateFolderReducer.State, CreateFolderReducer.Action> store, Continuation<? super CreateFolderDialogKt$CreateFolderDialog$7$1> continuation) {
        super(2, continuation);
        this.$state$delegate = state;
        this.$context = context;
        this.$store = store;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CreateFolderDialogKt$CreateFolderDialog$7$1(this.$state$delegate, this.$context, this.$store, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CreateFolderDialogKt$CreateFolderDialog$7$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            String createFolderError = CreateFolderDialogKt.CreateFolderDialog$lambda$0(this.$state$delegate).getCreateFolderError();
            if (createFolderError != null) {
                Context context = this.$context;
                Store<CreateFolderReducer.State, CreateFolderReducer.Action> store = this.$store;
                BoxPresentationUtils.displayToast(createFolderError, context);
                store.send(CreateFolderReducer.Action.CreateFolderErrorHandled.INSTANCE);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
