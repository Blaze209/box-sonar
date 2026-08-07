package com.box.android.browse.search;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import com.box.android.browse.fragments.SearchFragment;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: FilesSearchScreen.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.browse.search.FilesSearchScreenKt$FilesSearchScreen$2$1", f = "FilesSearchScreen.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class FilesSearchScreenKt$FilesSearchScreen$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<SearchFragment> $searchFragment$delegate;
    final /* synthetic */ State<FilesSearchReducer.State> $state$delegate;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FilesSearchScreenKt$FilesSearchScreen$2$1(MutableState<SearchFragment> mutableState, State<FilesSearchReducer.State> state, Continuation<? super FilesSearchScreenKt$FilesSearchScreen$2$1> continuation) {
        super(2, continuation);
        this.$searchFragment$delegate = mutableState;
        this.$state$delegate = state;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FilesSearchScreenKt$FilesSearchScreen$2$1(this.$searchFragment$delegate, this.$state$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FilesSearchScreenKt$FilesSearchScreen$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            SearchFragment searchFragmentFilesSearchScreen$lambda$2 = FilesSearchScreenKt.FilesSearchScreen$lambda$2(this.$searchFragment$delegate);
            if (searchFragmentFilesSearchScreen$lambda$2 != null) {
                searchFragmentFilesSearchScreen$lambda$2.search(FilesSearchScreenKt.FilesSearchScreen$lambda$0(this.$state$delegate).getQuery());
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
