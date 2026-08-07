package com.box.android.preview.preview;

import com.box.android.domain.models.item.ItemModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: PreviewReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/preview/preview/PreviewReducer$Action$RefreshPreviewItems;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.preview.preview.PreviewReducer$observeForPreviewItemsLocationChanges$1$itemFlows$1$3$1", f = "PreviewReducer.kt", i = {0, 1}, l = {542, 543}, m = "invokeSuspend", n = {"$this$flow", "$this$flow"}, s = {"L$0", "L$0"}, v = 1)
final class PreviewReducer$observeForPreviewItemsLocationChanges$1$itemFlows$1$3$1 extends SuspendLambda implements Function2<FlowCollector<? super PreviewReducer.Action.RefreshPreviewItems>, Continuation<? super Unit>, Object> {
    final /* synthetic */ ItemModel $item;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PreviewReducer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PreviewReducer$observeForPreviewItemsLocationChanges$1$itemFlows$1$3$1(PreviewReducer previewReducer, ItemModel itemModel, Continuation<? super PreviewReducer$observeForPreviewItemsLocationChanges$1$itemFlows$1$3$1> continuation) {
        super(2, continuation);
        this.this$0 = previewReducer;
        this.$item = itemModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PreviewReducer$observeForPreviewItemsLocationChanges$1$itemFlows$1$3$1 previewReducer$observeForPreviewItemsLocationChanges$1$itemFlows$1$3$1 = new PreviewReducer$observeForPreviewItemsLocationChanges$1$itemFlows$1$3$1(this.this$0, this.$item, continuation);
        previewReducer$observeForPreviewItemsLocationChanges$1$itemFlows$1$3$1.L$0 = obj;
        return previewReducer$observeForPreviewItemsLocationChanges$1$itemFlows$1$3$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super PreviewReducer.Action.RefreshPreviewItems> flowCollector, Continuation<? super Unit> continuation) {
        return ((PreviewReducer$observeForPreviewItemsLocationChanges$1$itemFlows$1$3$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0048, code lost:
    
        if (r0.emit(com.box.android.preview.preview.PreviewReducer.Action.RefreshPreviewItems.INSTANCE, r6) == r1) goto L15;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = r6.L$0
            kotlinx.coroutines.flow.FlowCollector r0 = (kotlinx.coroutines.flow.FlowCollector) r0
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r6.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L22
            if (r2 == r4) goto L1e
            if (r2 != r3) goto L16
            kotlin.ResultKt.throwOnFailure(r7)
            goto L4b
        L16:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L1e:
            kotlin.ResultKt.throwOnFailure(r7)
            goto L37
        L22:
            kotlin.ResultKt.throwOnFailure(r7)
            com.box.android.preview.preview.PreviewReducer r7 = r6.this$0
            com.box.android.domain.models.item.ItemModel r2 = r6.$item
            r5 = r6
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            r6.L$0 = r0
            r6.label = r4
            java.lang.Object r7 = com.box.android.preview.preview.PreviewReducer.access$awaitUntilLocalCacheUpdated(r7, r2, r5)
            if (r7 != r1) goto L37
            goto L4a
        L37:
            com.box.android.preview.preview.PreviewReducer$Action$RefreshPreviewItems r7 = com.box.android.preview.preview.PreviewReducer.Action.RefreshPreviewItems.INSTANCE
            r2 = r6
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)
            r6.L$0 = r4
            r6.label = r3
            java.lang.Object r6 = r0.emit(r7, r2)
            if (r6 != r1) goto L4b
        L4a:
            return r1
        L4b:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.preview.preview.PreviewReducer$observeForPreviewItemsLocationChanges$1$itemFlows$1$3$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
