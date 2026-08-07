package com.box.android.fileactivity.presentation;

import androidx.compose.foundation.lazy.LazyListState;
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

/* JADX INFO: compiled from: FileActivitiesScreen.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.fileactivity.presentation.FileActivitiesScreenKt$LoadedScreen$2$1", f = "FileActivitiesScreen.kt", i = {}, l = {412}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class FileActivitiesScreenKt$LoadedScreen$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FileActivitiesReducer.State $fileActivitiesState;
    final /* synthetic */ LazyListState $listState;
    final /* synthetic */ Store<FileActivitiesReducer.State, FileActivitiesReducer.Action> $store;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FileActivitiesScreenKt$LoadedScreen$2$1(LazyListState lazyListState, FileActivitiesReducer.State state, Store<FileActivitiesReducer.State, FileActivitiesReducer.Action> store, Continuation<? super FileActivitiesScreenKt$LoadedScreen$2$1> continuation) {
        super(2, continuation);
        this.$listState = lazyListState;
        this.$fileActivitiesState = state;
        this.$store = store;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FileActivitiesScreenKt$LoadedScreen$2$1(this.$listState, this.$fileActivitiesState, this.$store, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FileActivitiesScreenKt$LoadedScreen$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (LazyListState.animateScrollToItem$default(this.$listState, this.$fileActivitiesState.getScrollToCommentIndex(), 0, this, 2, null) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        this.$store.send(FileActivitiesReducer.Action.HandledScrollToComment.INSTANCE);
        return Unit.INSTANCE;
    }
}
