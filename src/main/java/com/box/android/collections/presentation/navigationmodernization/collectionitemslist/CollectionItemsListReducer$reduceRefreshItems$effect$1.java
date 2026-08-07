package com.box.android.collections.presentation.navigationmodernization.collectionitemslist;

import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.DomainErrorKt;
import com.box.android.domain.utils.result.Result;
import com.facebook.imageutils.JfifUtil;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CollectionItemsListReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/box/android/collections/presentation/navigationmodernization/collectionitemslist/CollectionItemsListReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListReducer$reduceRefreshItems$effect$1", f = "CollectionItemsListReducer.kt", i = {}, l = {JfifUtil.MARKER_RST7}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class CollectionItemsListReducer$reduceRefreshItems$effect$1 extends SuspendLambda implements Function1<Continuation<? super CollectionItemsListReducer.Action>, Object> {
    final /* synthetic */ CollectionItemsListReducer.State $state;
    int label;
    final /* synthetic */ CollectionItemsListReducer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CollectionItemsListReducer$reduceRefreshItems$effect$1(CollectionItemsListReducer collectionItemsListReducer, CollectionItemsListReducer.State state, Continuation<? super CollectionItemsListReducer$reduceRefreshItems$effect$1> continuation) {
        super(1, continuation);
        this.this$0 = collectionItemsListReducer;
        this.$state = state;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new CollectionItemsListReducer$reduceRefreshItems$effect$1(this.this$0, this.$state, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super CollectionItemsListReducer.Action> continuation) {
        return ((CollectionItemsListReducer$reduceRefreshItems$effect$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = this.this$0.environment.getListCollectionItemsInteractor().fetchCollectionItemsFromRemote(this.$state.getCollectionId(), this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        Result.Error error = (Result) obj;
        if (error instanceof Result.Success) {
            ((Boolean) ((Result.Success) error).getValue()).booleanValue();
            error = new Result.Success(CollectionItemsListReducer.Action.RefreshCompleted.INSTANCE);
        } else if (!(error instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (!(error instanceof Result.Success)) {
            if (!(error instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            error = new Result.Error(new CollectionItemsListReducer.Action.RefreshFailed(DomainErrorKt.unwrapCachedDomainError((DomainError) ((Result.Error) error).getValue())));
        }
        Object obj2 = com.box.android.domain.utils.result.ResultKt.get(error);
        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListReducer.Action");
        return (CollectionItemsListReducer.Action) obj2;
    }
}
