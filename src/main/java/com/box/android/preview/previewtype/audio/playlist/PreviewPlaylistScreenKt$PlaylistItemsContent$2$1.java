package com.box.android.preview.previewtype.audio.playlist;

import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.State;
import com.box.android.domain.services.AudioItem;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: PreviewPlaylistScreen.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.preview.previewtype.audio.playlist.PreviewPlaylistScreenKt$PlaylistItemsContent$2$1", f = "PreviewPlaylistScreen.kt", i = {0}, l = {96}, m = "invokeSuspend", n = {FirebaseAnalytics.Param.INDEX}, s = {"I$0"}, v = 1)
final class PreviewPlaylistScreenKt$PlaylistItemsContent$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ PreviewPlaylistReducer.ActivePlaylistItem $activeItem;
    final /* synthetic */ int $activeItemTopPadding;
    final /* synthetic */ LazyListState $listState;
    final /* synthetic */ State<PreviewPlaylistReducer.State> $state$delegate;
    int I$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PreviewPlaylistScreenKt$PlaylistItemsContent$2$1(LazyListState lazyListState, int i, State<PreviewPlaylistReducer.State> state, PreviewPlaylistReducer.ActivePlaylistItem activePlaylistItem, Continuation<? super PreviewPlaylistScreenKt$PlaylistItemsContent$2$1> continuation) {
        super(2, continuation);
        this.$listState = lazyListState;
        this.$activeItemTopPadding = i;
        this.$state$delegate = state;
        this.$activeItem = activePlaylistItem;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PreviewPlaylistScreenKt$PlaylistItemsContent$2$1(this.$listState, this.$activeItemTopPadding, this.$state$delegate, this.$activeItem, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PreviewPlaylistScreenKt$PlaylistItemsContent$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            List<AudioItem> items = PreviewPlaylistScreenKt.PlaylistItemsContent$lambda$0(this.$state$delegate).getItems();
            PreviewPlaylistReducer.ActivePlaylistItem activePlaylistItem = this.$activeItem;
            Iterator<AudioItem> it = items.iterator();
            int i2 = 0;
            while (true) {
                if (!it.hasNext()) {
                    i2 = -1;
                    break;
                }
                if (Intrinsics.areEqual(it.next().getFileModel().getItemId(), activePlaylistItem.getItem().getFileModel().getItemId())) {
                    break;
                }
                i2++;
            }
            Integer numBoxInt = Boxing.boxInt(i2);
            if (numBoxInt.intValue() < 0) {
                numBoxInt = null;
            }
            int iIntValue = numBoxInt != null ? numBoxInt.intValue() : 0;
            this.I$0 = iIntValue;
            this.label = 1;
            if (this.$listState.animateScrollToItem(iIntValue, -this.$activeItemTopPadding, this) == coroutine_suspended) {
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
}
