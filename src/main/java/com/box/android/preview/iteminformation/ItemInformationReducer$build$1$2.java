package com.box.android.preview.iteminformation;

import com.box.brownfieldApi.featuresNavigator.activities.ReactNativeFeatureActivity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: ItemInformationReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/preview/iteminformation/ItemInformationReducer$Action$MetadataFetchSuccess;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.preview.iteminformation.ItemInformationReducer$build$1$2", f = "ItemInformationReducer.kt", i = {0, 1, 1}, l = {207, 208}, m = "invokeSuspend", n = {"$this$flow", "$this$flow", ReactNativeFeatureActivity.RESULT_EXTRA_KEY}, s = {"L$0", "L$0", "L$1"}, v = 1)
final class ItemInformationReducer$build$1$2 extends SuspendLambda implements Function2<FlowCollector<? super ItemInformationReducer.Action.MetadataFetchSuccess>, Continuation<? super Unit>, Object> {
    final /* synthetic */ ItemInformationReducer.Action $action;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ ItemInformationReducer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ItemInformationReducer$build$1$2(ItemInformationReducer itemInformationReducer, ItemInformationReducer.Action action, Continuation<? super ItemInformationReducer$build$1$2> continuation) {
        super(2, continuation);
        this.this$0 = itemInformationReducer;
        this.$action = action;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ItemInformationReducer$build$1$2 itemInformationReducer$build$1$2 = new ItemInformationReducer$build$1$2(this.this$0, this.$action, continuation);
        itemInformationReducer$build$1$2.L$0 = obj;
        return itemInformationReducer$build$1$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super ItemInformationReducer.Action.MetadataFetchSuccess> flowCollector, Continuation<? super Unit> continuation) {
        return ((ItemInformationReducer$build$1$2) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0073, code lost:
    
        if (r0.emit(new com.box.android.preview.iteminformation.ItemInformationReducer.Action.MetadataFetchSuccess((java.util.List) ((com.box.android.domain.utils.result.Result.Success) r7).getValue()), r6) == r1) goto L17;
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
            if (r2 == 0) goto L27
            if (r2 == r4) goto L23
            if (r2 != r3) goto L1b
            java.lang.Object r6 = r6.L$1
            com.box.android.domain.utils.result.Result r6 = (com.box.android.domain.utils.result.Result) r6
            kotlin.ResultKt.throwOnFailure(r7)
            goto L96
        L1b:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L23:
            kotlin.ResultKt.throwOnFailure(r7)
            goto L4a
        L27:
            kotlin.ResultKt.throwOnFailure(r7)
            com.box.android.preview.iteminformation.ItemInformationReducer r7 = r6.this$0
            com.box.android.preview.iteminformation.ItemInformationEnvironment r7 = r7.getEnvironment()
            com.box.android.domain.services.IFileMetadataService r7 = r7.getFileMetadataService()
            com.box.android.preview.iteminformation.ItemInformationReducer$Action r2 = r6.$action
            com.box.android.preview.iteminformation.ItemInformationReducer$Action$FetchMetadata r2 = (com.box.android.preview.iteminformation.ItemInformationReducer.Action.FetchMetadata) r2
            com.box.android.domain.models.ItemId r2 = r2.getItemId()
            r5 = r6
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            r6.L$0 = r0
            r6.label = r4
            java.lang.Object r7 = r7.listFileMetadata(r2, r5)
            if (r7 != r1) goto L4a
            goto L75
        L4a:
            com.box.android.domain.utils.result.Result r7 = (com.box.android.domain.utils.result.Result) r7
            boolean r2 = r7 instanceof com.box.android.domain.utils.result.Result.Success
            if (r2 == 0) goto L76
            com.box.android.preview.iteminformation.ItemInformationReducer$Action$MetadataFetchSuccess r2 = new com.box.android.preview.iteminformation.ItemInformationReducer$Action$MetadataFetchSuccess
            r4 = r7
            com.box.android.domain.utils.result.Result$Success r4 = (com.box.android.domain.utils.result.Result.Success) r4
            java.lang.Object r4 = r4.getValue()
            java.util.List r4 = (java.util.List) r4
            r2.<init>(r4)
            r4 = r6
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)
            r6.L$0 = r5
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
            r6.L$1 = r7
            r6.label = r3
            java.lang.Object r6 = r0.emit(r2, r4)
            if (r6 != r1) goto L96
        L75:
            return r1
        L76:
            boolean r6 = r7 instanceof com.box.android.domain.utils.result.Result.Error
            if (r6 == 0) goto L99
            java.lang.String r6 = com.box.android.domain.utils.ExtensionsKt.getTAG(r0)
            com.box.android.domain.utils.result.Result$Error r7 = (com.box.android.domain.utils.result.Result.Error) r7
            java.lang.Object r7 = r7.getValue()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Failed to fetch file metadata: "
            r0.<init>(r1)
            java.lang.StringBuilder r7 = r0.append(r7)
            java.lang.String r7 = r7.toString()
            com.box.androidsdk.content.utils.BoxLogUtils.e(r6, r7)
        L96:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L99:
            kotlin.NoWhenBranchMatchedException r6 = new kotlin.NoWhenBranchMatchedException
            r6.<init>()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.preview.iteminformation.ItemInformationReducer$build$1$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
