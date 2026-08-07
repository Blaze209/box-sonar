package com.box.android.browse.cpl.recents;

import androidx.compose.material3.SnackbarDuration;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.material3.SnackbarResult;
import com.box.android.browse.cpl.helpers.ItemsFilter;
import com.box.android.cpl.Store;
import external.sdk.pendo.io.mozilla.javascript.Token;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: RecentsScreen.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.browse.cpl.recents.RecentsScreenKt$FiltersUpdatedSnackbarEffect$1$1", f = "RecentsScreen.kt", i = {}, l = {Token.SETCONST}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class RecentsScreenKt$FiltersUpdatedSnackbarEffect$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $label;
    final /* synthetic */ String $message;
    final /* synthetic */ SnackbarHostState $snackbarHostState;
    final /* synthetic */ Store<RecentsReducer.State, RecentsReducer.Action> $store;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RecentsScreenKt$FiltersUpdatedSnackbarEffect$1$1(SnackbarHostState snackbarHostState, String str, String str2, Store<RecentsReducer.State, RecentsReducer.Action> store, Continuation<? super RecentsScreenKt$FiltersUpdatedSnackbarEffect$1$1> continuation) {
        super(2, continuation);
        this.$snackbarHostState = snackbarHostState;
        this.$message = str;
        this.$label = str2;
        this.$store = store;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RecentsScreenKt$FiltersUpdatedSnackbarEffect$1$1(this.$snackbarHostState, this.$message, this.$label, this.$store, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((RecentsScreenKt$FiltersUpdatedSnackbarEffect$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = SnackbarHostState.showSnackbar$default(this.$snackbarHostState, this.$message, this.$label, false, SnackbarDuration.Indefinite, this, 4, null);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        if (((SnackbarResult) obj) == SnackbarResult.ActionPerformed) {
            this.$store.send(RecentsReducerKt.updateRecentsFilter(ItemsFilter.AllRecents.INSTANCE));
        }
        return Unit.INSTANCE;
    }
}
