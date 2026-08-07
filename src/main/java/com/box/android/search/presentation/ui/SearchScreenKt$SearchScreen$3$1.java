package com.box.android.search.presentation.ui;

import androidx.compose.material3.SnackbarHostState;
import androidx.compose.runtime.State;
import com.box.android.cpl.Store;
import com.box.android.search.presentation.cpl.SearchReducer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: SearchScreen.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.search.presentation.ui.SearchScreenKt$SearchScreen$3$1", f = "SearchScreen.kt", i = {}, l = {126}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class SearchScreenKt$SearchScreen$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $errorMessage;
    final /* synthetic */ SnackbarHostState $snackbarHostState;
    final /* synthetic */ State<SearchReducer.State> $state$delegate;
    final /* synthetic */ Store<SearchReducer.State, SearchReducer.Action> $store;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SearchScreenKt$SearchScreen$3$1(SnackbarHostState snackbarHostState, String str, Store<SearchReducer.State, SearchReducer.Action> store, State<SearchReducer.State> state, Continuation<? super SearchScreenKt$SearchScreen$3$1> continuation) {
        super(2, continuation);
        this.$snackbarHostState = snackbarHostState;
        this.$errorMessage = str;
        this.$store = store;
        this.$state$delegate = state;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SearchScreenKt$SearchScreen$3$1(this.$snackbarHostState, this.$errorMessage, this.$store, this.$state$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SearchScreenKt$SearchScreen$3$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (SearchScreenKt.SearchScreen$lambda$1(this.$state$delegate).getErrorShown()) {
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
        this.$store.send(SearchReducer.Action.ErrorShown.INSTANCE);
        return Unit.INSTANCE;
    }
}
