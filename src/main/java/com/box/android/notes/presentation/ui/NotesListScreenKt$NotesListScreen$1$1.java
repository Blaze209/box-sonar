package com.box.android.notes.presentation.ui;

import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.State;
import com.box.android.cpl.Store;
import com.box.android.notes.presentation.cpl.NotesListReducer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: NotesListScreen.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.notes.presentation.ui.NotesListScreenKt$NotesListScreen$1$1", f = "NotesListScreen.kt", i = {}, l = {72}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class NotesListScreenKt$NotesListScreen$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ LazyListState $lazyListState;
    final /* synthetic */ State<NotesListReducer.State> $state$delegate;
    final /* synthetic */ Store<NotesListReducer.State, NotesListReducer.Action> $store;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    NotesListScreenKt$NotesListScreen$1$1(LazyListState lazyListState, Store<NotesListReducer.State, NotesListReducer.Action> store, State<NotesListReducer.State> state, Continuation<? super NotesListScreenKt$NotesListScreen$1$1> continuation) {
        super(2, continuation);
        this.$lazyListState = lazyListState;
        this.$store = store;
        this.$state$delegate = state;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NotesListScreenKt$NotesListScreen$1$1(this.$lazyListState, this.$store, this.$state$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((NotesListScreenKt$NotesListScreen$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (!NotesListScreenKt.NotesListScreen$lambda$0(this.$state$delegate).getShouldScrollToTop()) {
                return Unit.INSTANCE;
            }
            this.label = 1;
            if (LazyListState.scrollToItem$default(this.$lazyListState, 0, 0, this, 2, null) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        this.$store.send(NotesListReducer.Action.ScrollToTopHandled.INSTANCE);
        return Unit.INSTANCE;
    }
}
