package com.box.android.preview.previewtype.boxnote;

import androidx.compose.runtime.MutableIntState;
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

/* JADX INFO: compiled from: BoxNotePreviewScreen.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.preview.previewtype.boxnote.BoxNotePreviewScreenKt$BoxNotePreviewScreen$2$1", f = "BoxNotePreviewScreen.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class BoxNotePreviewScreenKt$BoxNotePreviewScreen$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableIntState $containerHeightPx$delegate;
    final /* synthetic */ int $imeHeightPx;
    final /* synthetic */ Store<BoxNotePreviewReducer.State, BoxNotePreviewReducer.Action> $store;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BoxNotePreviewScreenKt$BoxNotePreviewScreen$2$1(int i, Store<BoxNotePreviewReducer.State, BoxNotePreviewReducer.Action> store, MutableIntState mutableIntState, Continuation<? super BoxNotePreviewScreenKt$BoxNotePreviewScreen$2$1> continuation) {
        super(2, continuation);
        this.$imeHeightPx = i;
        this.$store = store;
        this.$containerHeightPx$delegate = mutableIntState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BoxNotePreviewScreenKt$BoxNotePreviewScreen$2$1(this.$imeHeightPx, this.$store, this.$containerHeightPx$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BoxNotePreviewScreenKt$BoxNotePreviewScreen$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            if (BoxNotePreviewScreenKt.BoxNotePreviewScreen$lambda$3(this.$containerHeightPx$delegate) > 0) {
                this.$store.send(new BoxNotePreviewReducer.Action.EditModeAction(new BoxNoteEditModeReducer.Action.ScreenHeightChanged(BoxNotePreviewScreenKt.BoxNotePreviewScreen$lambda$3(this.$containerHeightPx$delegate) - this.$imeHeightPx)));
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
