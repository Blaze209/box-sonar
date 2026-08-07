package com.pspdfkit.ui.thumbnail;

import androidx.compose.foundation.lazy.LazyListItemInfo;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.SnapshotStateKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "com.pspdfkit.ui.thumbnail.PdfScrollableThumbnailBarKt$PdfScrollableThumbnailBar$2$1", f = "PdfScrollableThumbnailBar.kt", i = {}, l = {118}, m = "invokeSuspend", n = {}, nl = {121}, s = {}, v = 2)
public final class PdfScrollableThumbnailBarKt$PdfScrollableThumbnailBar$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ LazyListState $lazyListState;
    final /* synthetic */ ThumbnailBarStateManager $stateManager;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PdfScrollableThumbnailBarKt$PdfScrollableThumbnailBar$2$1(LazyListState lazyListState, ThumbnailBarStateManager thumbnailBarStateManager, Continuation<? super PdfScrollableThumbnailBarKt$PdfScrollableThumbnailBar$2$1> continuation) {
        super(2, continuation);
        this.$lazyListState = lazyListState;
        this.$stateManager = thumbnailBarStateManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Set invokeSuspend$lambda$0(LazyListState lazyListState) {
        List<LazyListItemInfo> visibleItemsInfo = lazyListState.getLayoutInfo().getVisibleItemsInfo();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(visibleItemsInfo, 10));
        Iterator<T> it = visibleItemsInfo.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(((LazyListItemInfo) it.next()).getIndex()));
        }
        return CollectionsKt.toSet(arrayList);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PdfScrollableThumbnailBarKt$PdfScrollableThumbnailBar$2$1(this.$lazyListState, this.$stateManager, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final LazyListState lazyListState = this.$lazyListState;
            Flow flowDistinctUntilChanged = FlowKt.distinctUntilChanged(SnapshotStateKt.snapshotFlow(new Function0() { // from class: com.pspdfkit.ui.thumbnail.PdfScrollableThumbnailBarKt$PdfScrollableThumbnailBar$2$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return PdfScrollableThumbnailBarKt$PdfScrollableThumbnailBar$2$1.invokeSuspend$lambda$0(lazyListState);
                }
            }));
            final ThumbnailBarStateManager thumbnailBarStateManager = this.$stateManager;
            FlowCollector flowCollector = new FlowCollector() { // from class: com.pspdfkit.ui.thumbnail.PdfScrollableThumbnailBarKt$PdfScrollableThumbnailBar$2$1.2
                @Override // kotlinx.coroutines.flow.FlowCollector
                public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                    return emit((Set<Integer>) obj2, (Continuation<? super Unit>) continuation);
                }

                public final Object emit(Set<Integer> set, Continuation<? super Unit> continuation) {
                    thumbnailBarStateManager.onEvent(new ThumbnailBarEvent.ScrollableVisiblePagesChanged(set));
                    return Unit.INSTANCE;
                }
            };
            this.label = 1;
            if (flowDistinctUntilChanged.collect(flowCollector, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PdfScrollableThumbnailBarKt$PdfScrollableThumbnailBar$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
