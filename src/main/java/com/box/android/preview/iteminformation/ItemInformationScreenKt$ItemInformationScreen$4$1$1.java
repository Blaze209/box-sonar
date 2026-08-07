package com.box.android.preview.iteminformation;

import androidx.compose.material3.SnackbarHostState;
import com.box.android.base.cpl.StringResourceWrapper;
import com.box.android.cpl.Store;
import com.box.android.preview.fileactions.UpdateItemInfoReducer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: ItemInformationScreen.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.preview.iteminformation.ItemInformationScreenKt$ItemInformationScreen$4$1$1", f = "ItemInformationScreen.kt", i = {}, l = {213}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class ItemInformationScreenKt$ItemInformationScreen$4$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ StringResourceWrapper $it;
    final /* synthetic */ SnackbarHostState $snackbarHostState;
    final /* synthetic */ Store<ItemInformationReducer.State, ItemInformationReducer.Action> $store;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ItemInformationScreenKt$ItemInformationScreen$4$1$1(SnackbarHostState snackbarHostState, StringResourceWrapper stringResourceWrapper, Store<ItemInformationReducer.State, ItemInformationReducer.Action> store, Continuation<? super ItemInformationScreenKt$ItemInformationScreen$4$1$1> continuation) {
        super(2, continuation);
        this.$snackbarHostState = snackbarHostState;
        this.$it = stringResourceWrapper;
        this.$store = store;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ItemInformationScreenKt$ItemInformationScreen$4$1$1(this.$snackbarHostState, this.$it, this.$store, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ItemInformationScreenKt$ItemInformationScreen$4$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (SnackbarHostState.showSnackbar$default(this.$snackbarHostState, this.$it.getString(), null, false, null, this, 14, null) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        this.$store.send(new ItemInformationReducer.Action.UpdateItemInfo(UpdateItemInfoReducer.Action.HandledError.INSTANCE));
        return Unit.INSTANCE;
    }
}
