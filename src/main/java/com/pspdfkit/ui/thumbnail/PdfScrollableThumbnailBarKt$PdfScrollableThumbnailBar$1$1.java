package com.pspdfkit.ui.thumbnail;

import androidx.compose.foundation.lazy.LazyListItemInfo;
import androidx.compose.foundation.lazy.LazyListState;
import com.pspdfkit.utils.PdfLog;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.SharedFlow;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "com.pspdfkit.ui.thumbnail.PdfScrollableThumbnailBarKt$PdfScrollableThumbnailBar$1$1", f = "PdfScrollableThumbnailBar.kt", i = {}, l = {88}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
public final class PdfScrollableThumbnailBarKt$PdfScrollableThumbnailBar$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ LazyListState $lazyListState;
    final /* synthetic */ Function1<Integer, Unit> $onPageChanged;
    final /* synthetic */ ThumbnailBarStateManager $stateManager;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public PdfScrollableThumbnailBarKt$PdfScrollableThumbnailBar$1$1(ThumbnailBarStateManager thumbnailBarStateManager, Function1<? super Integer, Unit> function1, LazyListState lazyListState, Continuation<? super PdfScrollableThumbnailBarKt$PdfScrollableThumbnailBar$1$1> continuation) {
        super(2, continuation);
        this.$stateManager = thumbnailBarStateManager;
        this.$onPageChanged = function1;
        this.$lazyListState = lazyListState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PdfScrollableThumbnailBarKt$PdfScrollableThumbnailBar$1$1(this.$stateManager, this.$onPageChanged, this.$lazyListState, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            SharedFlow<ThumbnailBarEffect> effects = this.$stateManager.getEffects();
            final Function1<Integer, Unit> function1 = this.$onPageChanged;
            final LazyListState lazyListState = this.$lazyListState;
            FlowCollector<? super ThumbnailBarEffect> flowCollector = new FlowCollector() { // from class: com.pspdfkit.ui.thumbnail.PdfScrollableThumbnailBarKt$PdfScrollableThumbnailBar$1$1.1
                @Override // kotlinx.coroutines.flow.FlowCollector
                public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                    return emit((ThumbnailBarEffect) obj2, (Continuation<? super Unit>) continuation);
                }

                public final Object emit(ThumbnailBarEffect thumbnailBarEffect, Continuation<? super Unit> continuation) {
                    if (thumbnailBarEffect instanceof ThumbnailBarEffect.NavigateToPage) {
                        function1.invoke(Boxing.boxInt(((ThumbnailBarEffect.NavigateToPage) thumbnailBarEffect).getPageIndex()));
                    } else {
                        if (thumbnailBarEffect instanceof ThumbnailBarEffect.ScrollToPage) {
                            List<LazyListItemInfo> visibleItemsInfo = lazyListState.getLayoutInfo().getVisibleItemsInfo();
                            int size = visibleItemsInfo.size();
                            LazyListItemInfo lazyListItemInfo = (LazyListItemInfo) CollectionsKt.firstOrNull((List) visibleItemsInfo);
                            ThumbnailBarEffect.ScrollToPage scrollToPage = (ThumbnailBarEffect.ScrollToPage) thumbnailBarEffect;
                            Object objScrollToItemCentered = PdfScrollableThumbnailBarKt.scrollToItemCentered(lazyListState, scrollToPage.getPageIndex(), Math.abs(scrollToPage.getPageIndex() - (lazyListItemInfo != null ? lazyListItemInfo.getIndex() : 0)) <= size * 2, continuation);
                            return objScrollToItemCentered == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objScrollToItemCentered : Unit.INSTANCE;
                        }
                        if (thumbnailBarEffect instanceof ThumbnailBarEffect.ShowError) {
                            PdfLog.d("ScrollableThumbnailBar", "ShowError ignored in scrollable mode: " + ((ThumbnailBarEffect.ShowError) thumbnailBarEffect).getMessage(), new Object[0]);
                        } else {
                            if (!(thumbnailBarEffect instanceof ThumbnailBarEffect.RequestFocus)) {
                                throw new NoWhenBranchMatchedException();
                            }
                            PdfLog.d("ScrollableThumbnailBar", "RequestFocus ignored in scrollable mode: page " + ((ThumbnailBarEffect.RequestFocus) thumbnailBarEffect).getPageIndex(), new Object[0]);
                        }
                    }
                    return Unit.INSTANCE;
                }
            };
            this.label = 1;
            if (effects.collect(flowCollector, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PdfScrollableThumbnailBarKt$PdfScrollableThumbnailBar$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
