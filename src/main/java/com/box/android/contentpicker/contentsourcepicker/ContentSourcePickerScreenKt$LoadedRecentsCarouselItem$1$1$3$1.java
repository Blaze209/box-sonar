package com.box.android.contentpicker.contentsourcepicker;

import androidx.compose.runtime.State;
import com.box.android.base.cpl.ItemThumbnailReducer;
import com.box.android.browse.cpl.itemsList.ItemReducer;
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

/* JADX INFO: compiled from: ContentSourcePickerScreen.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.contentpicker.contentsourcepicker.ContentSourcePickerScreenKt$LoadedRecentsCarouselItem$1$1$3$1", f = "ContentSourcePickerScreen.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class ContentSourcePickerScreenKt$LoadedRecentsCarouselItem$1$1$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ State<ItemReducer.State> $itemState$delegate;
    final /* synthetic */ Store<ItemReducer.State, ItemReducer.Action> $store;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ContentSourcePickerScreenKt$LoadedRecentsCarouselItem$1$1$3$1(Store<ItemReducer.State, ItemReducer.Action> store, State<ItemReducer.State> state, Continuation<? super ContentSourcePickerScreenKt$LoadedRecentsCarouselItem$1$1$3$1> continuation) {
        super(2, continuation);
        this.$store = store;
        this.$itemState$delegate = state;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ContentSourcePickerScreenKt$LoadedRecentsCarouselItem$1$1$3$1(this.$store, this.$itemState$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ContentSourcePickerScreenKt$LoadedRecentsCarouselItem$1$1$3$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            if (!ContentSourcePickerScreenKt.LoadedRecentsCarouselItem$lambda$0(this.$itemState$delegate).getThumbnailState().isThumbnailFetchAttempted()) {
                this.$store.send(new ItemReducer.Action.ThumbnailAction(ItemThumbnailReducer.Action.FetchThumbnail.INSTANCE));
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
