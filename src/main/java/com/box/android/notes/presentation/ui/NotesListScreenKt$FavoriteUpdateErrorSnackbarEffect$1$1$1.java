package com.box.android.notes.presentation.ui;

import androidx.compose.material3.SnackbarDuration;
import androidx.compose.material3.SnackbarHostState;
import com.box.android.cpl.Store;
import com.box.android.notes.presentation.cpl.NotesListReducer;
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

/* JADX INFO: compiled from: NotesListScreen.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.notes.presentation.ui.NotesListScreenKt$FavoriteUpdateErrorSnackbarEffect$1$1$1", f = "NotesListScreen.kt", i = {}, l = {Token.LOCAL_BLOCK}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class NotesListScreenKt$FavoriteUpdateErrorSnackbarEffect$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $message;
    final /* synthetic */ SnackbarHostState $snackbarHostState;
    final /* synthetic */ Store<NotesListReducer.State, NotesListReducer.Action> $store;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    NotesListScreenKt$FavoriteUpdateErrorSnackbarEffect$1$1$1(SnackbarHostState snackbarHostState, String str, Store<NotesListReducer.State, NotesListReducer.Action> store, Continuation<? super NotesListScreenKt$FavoriteUpdateErrorSnackbarEffect$1$1$1> continuation) {
        super(2, continuation);
        this.$snackbarHostState = snackbarHostState;
        this.$message = str;
        this.$store = store;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NotesListScreenKt$FavoriteUpdateErrorSnackbarEffect$1$1$1(this.$snackbarHostState, this.$message, this.$store, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((NotesListScreenKt$FavoriteUpdateErrorSnackbarEffect$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (SnackbarHostState.showSnackbar$default(this.$snackbarHostState, this.$message, null, false, SnackbarDuration.Short, this, 6, null) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        this.$store.send(NotesListReducer.Action.FavoriteUpdateFailureHandled.INSTANCE);
        return Unit.INSTANCE;
    }
}
