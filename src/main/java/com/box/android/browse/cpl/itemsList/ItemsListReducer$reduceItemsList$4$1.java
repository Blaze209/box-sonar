package com.box.android.browse.cpl.itemsList;

import com.box.android.browse.utilities.BoxFeatureBanner;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ItemsListReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.browse.cpl.itemsList.ItemsListReducer$reduceItemsList$4$1", f = "ItemsListReducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class ItemsListReducer$reduceItemsList$4$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ BoxFeatureBanner $it;
    int label;
    final /* synthetic */ ItemsListReducer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ItemsListReducer$reduceItemsList$4$1(ItemsListReducer itemsListReducer, BoxFeatureBanner boxFeatureBanner, Continuation<? super ItemsListReducer$reduceItemsList$4$1> continuation) {
        super(1, continuation);
        this.this$0 = itemsListReducer;
        this.$it = boxFeatureBanner;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new ItemsListReducer$reduceItemsList$4$1(this.this$0, this.$it, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((ItemsListReducer$reduceItemsList$4$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        this.this$0.getEnvironment().getFeatureBannerUtils().setBannerDisplayed(this.$it);
        return Unit.INSTANCE;
    }
}
