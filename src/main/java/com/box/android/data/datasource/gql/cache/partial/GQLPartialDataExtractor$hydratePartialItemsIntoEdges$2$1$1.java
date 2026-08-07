package com.box.android.data.datasource.gql.cache.partial;

import com.box.android.data.datasource.gql.cache.partial.models.PartialMiniItem;
import com.box.android.data.fragment.ItemConnectionFragment;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: GQLPartialDataExtractor.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.data.datasource.gql.cache.partial.GQLPartialDataExtractor$hydratePartialItemsIntoEdges$2$1$1", f = "GQLPartialDataExtractor.kt", i = {}, l = {121}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class GQLPartialDataExtractor$hydratePartialItemsIntoEdges$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<ItemConnectionFragment.Edge> $edges;
    final /* synthetic */ int $index;
    final /* synthetic */ List<PartialMiniItem> $partialItems;
    int label;
    final /* synthetic */ GQLPartialDataExtractor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    GQLPartialDataExtractor$hydratePartialItemsIntoEdges$2$1$1(GQLPartialDataExtractor gQLPartialDataExtractor, List<PartialMiniItem> list, int i, List<ItemConnectionFragment.Edge> list2, Continuation<? super GQLPartialDataExtractor$hydratePartialItemsIntoEdges$2$1$1> continuation) {
        super(2, continuation);
        this.this$0 = gQLPartialDataExtractor;
        this.$partialItems = list;
        this.$index = i;
        this.$edges = list2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GQLPartialDataExtractor$hydratePartialItemsIntoEdges$2$1$1(this.this$0, this.$partialItems, this.$index, this.$edges, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((GQLPartialDataExtractor$hydratePartialItemsIntoEdges$2$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = this.this$0.gqlCacheHelper.gqlReadEdgeForGetFolderItemsFromCache(this.$partialItems.get(this.$index).getId(), this.$partialItems.get(this.$index).getType(), this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        ItemConnectionFragment.Edge edge = (ItemConnectionFragment.Edge) obj;
        if (edge == null) {
            return null;
        }
        this.$edges.set(this.$index, edge);
        return Unit.INSTANCE;
    }
}
