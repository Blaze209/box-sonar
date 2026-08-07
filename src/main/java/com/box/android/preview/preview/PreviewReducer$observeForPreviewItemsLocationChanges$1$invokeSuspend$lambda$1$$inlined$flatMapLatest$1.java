package com.box.android.preview.preview;

import androidx.exifinterface.media.ExifInterface;
import androidx.media3.extractor.ts.PsExtractor;
import com.box.android.domain.models.item.ItemModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: Merge.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u0005\u001a\u0002H\u0003H\n¨\u0006\u0006"}, d2 = {"<anonymous>", "", "R", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/FlowCollector;", "it", "kotlinx/coroutines/flow/FlowKt__MergeKt$flatMapLatest$1"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.preview.preview.PreviewReducer$observeForPreviewItemsLocationChanges$1$invokeSuspend$lambda$1$$inlined$flatMapLatest$1", f = "PreviewReducer.kt", i = {0, 0}, l = {PsExtractor.PRIVATE_STREAM_1}, m = "invokeSuspend", n = {"$this$transformLatest", "it"}, s = {"L$0", "L$1"}, v = 1)
public final class PreviewReducer$observeForPreviewItemsLocationChanges$1$invokeSuspend$lambda$1$$inlined$flatMapLatest$1 extends SuspendLambda implements Function3<FlowCollector<? super PreviewReducer.Action.RefreshPreviewItems>, ItemModel, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ PreviewReducer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PreviewReducer$observeForPreviewItemsLocationChanges$1$invokeSuspend$lambda$1$$inlined$flatMapLatest$1(Continuation continuation, PreviewReducer previewReducer) {
        super(3, continuation);
        this.this$0 = previewReducer;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(FlowCollector<? super PreviewReducer.Action.RefreshPreviewItems> flowCollector, ItemModel itemModel, Continuation<? super Unit> continuation) {
        PreviewReducer$observeForPreviewItemsLocationChanges$1$invokeSuspend$lambda$1$$inlined$flatMapLatest$1 previewReducer$observeForPreviewItemsLocationChanges$1$invokeSuspend$lambda$1$$inlined$flatMapLatest$1 = new PreviewReducer$observeForPreviewItemsLocationChanges$1$invokeSuspend$lambda$1$$inlined$flatMapLatest$1(continuation, this.this$0);
        previewReducer$observeForPreviewItemsLocationChanges$1$invokeSuspend$lambda$1$$inlined$flatMapLatest$1.L$0 = flowCollector;
        previewReducer$observeForPreviewItemsLocationChanges$1$invokeSuspend$lambda$1$$inlined$flatMapLatest$1.L$1 = itemModel;
        return previewReducer$observeForPreviewItemsLocationChanges$1$invokeSuspend$lambda$1$$inlined$flatMapLatest$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            Object obj2 = this.L$1;
            Flow flow = FlowKt.flow(new PreviewReducer$observeForPreviewItemsLocationChanges$1$itemFlows$1$3$1(this.this$0, (ItemModel) obj2, null));
            this.L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
            this.L$1 = SpillingKt.nullOutSpilledVariable(obj2);
            this.label = 1;
            if (FlowKt.emitAll(flowCollector, flow, this) == coroutine_suspended) {
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
