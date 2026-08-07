package com.box.android.preview.previewtype.document;

import com.box.brownfieldApi.featuresNavigator.activities.ReactNativeFeatureActivity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: CitationHighlightReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/preview/previewtype/document/CitationHighlightReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.preview.previewtype.document.CitationHighlightReducer$build$1$1", f = "CitationHighlightReducer.kt", i = {0, 1, 1, 2, 2}, l = {33, 35, 37}, m = "invokeSuspend", n = {"$this$flow", "$this$flow", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "$this$flow", ReactNativeFeatureActivity.RESULT_EXTRA_KEY}, s = {"L$0", "L$0", "L$1", "L$0", "L$1"}, v = 1)
final class CitationHighlightReducer$build$1$1 extends SuspendLambda implements Function2<FlowCollector<? super CitationHighlightReducer.Action>, Continuation<? super Unit>, Object> {
    final /* synthetic */ CitationHighlightReducer.Action $action;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ CitationHighlightReducer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CitationHighlightReducer$build$1$1(CitationHighlightReducer citationHighlightReducer, CitationHighlightReducer.Action action, Continuation<? super CitationHighlightReducer$build$1$1> continuation) {
        super(2, continuation);
        this.this$0 = citationHighlightReducer;
        this.$action = action;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CitationHighlightReducer$build$1$1 citationHighlightReducer$build$1$1 = new CitationHighlightReducer$build$1$1(this.this$0, this.$action, continuation);
        citationHighlightReducer$build$1$1.L$0 = obj;
        return citationHighlightReducer$build$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super CitationHighlightReducer.Action> flowCollector, Continuation<? super Unit> continuation) {
        return ((CitationHighlightReducer$build$1$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0081, code lost:
    
        if (r0.emit(new com.box.android.preview.previewtype.document.CitationHighlightReducer.Action.TextFound((com.pspdfkit.document.search.SearchResult) r13.get(0)), r12) == r1) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x009b, code lost:
    
        if (r0.emit(com.box.android.preview.previewtype.document.CitationHighlightReducer.Action.Close.INSTANCE, r12) == r1) goto L22;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) {
        /*
            r12 = this;
            java.lang.Object r0 = r12.L$0
            kotlinx.coroutines.flow.FlowCollector r0 = (kotlinx.coroutines.flow.FlowCollector) r0
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r12.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L2b
            if (r2 == r5) goto L27
            if (r2 == r4) goto L1e
            if (r2 != r3) goto L16
            goto L1e
        L16:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L1e:
            java.lang.Object r12 = r12.L$1
            java.util.List r12 = (java.util.List) r12
            kotlin.ResultKt.throwOnFailure(r13)
            goto L9e
        L27:
            kotlin.ResultKt.throwOnFailure(r13)
            goto L55
        L2b:
            kotlin.ResultKt.throwOnFailure(r13)
            com.box.android.preview.previewtype.document.CitationHighlightReducer r13 = r12.this$0
            com.box.android.preview.previewtype.document.CitationHighlightEnvironment r13 = r13.getEnvironment()
            com.box.android.preview.previewtype.document.search.TextSearchManager r6 = r13.getTextSearchManager()
            com.box.android.preview.previewtype.document.CitationHighlightReducer$Action r13 = r12.$action
            com.box.android.preview.previewtype.document.CitationHighlightReducer$Action$HighlightText r13 = (com.box.android.preview.previewtype.document.CitationHighlightReducer.Action.HighlightText) r13
            com.box.android.domain.models.boxai.AiCitationModel r13 = r13.getCitation()
            java.lang.String r7 = r13.getContent()
            r9 = r12
            kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9
            r12.L$0 = r0
            r12.label = r5
            r8 = 0
            r10 = 2
            r11 = 0
            java.lang.Object r13 = com.box.android.preview.previewtype.document.search.TextSearchManager.search$default(r6, r7, r8, r9, r10, r11)
            if (r13 != r1) goto L55
            goto L9d
        L55:
            java.util.List r13 = (java.util.List) r13
            r2 = r13
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r2 = r2.isEmpty()
            if (r2 != 0) goto L84
            com.box.android.preview.previewtype.document.CitationHighlightReducer$Action$TextFound r2 = new com.box.android.preview.previewtype.document.CitationHighlightReducer$Action$TextFound
            r3 = 0
            java.lang.Object r3 = r13.get(r3)
            com.pspdfkit.document.search.SearchResult r3 = (com.pspdfkit.document.search.SearchResult) r3
            r2.<init>(r3)
            r3 = r12
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)
            r12.L$0 = r5
            java.lang.Object r13 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r13)
            r12.L$1 = r13
            r12.label = r4
            java.lang.Object r12 = r0.emit(r2, r3)
            if (r12 != r1) goto L9e
            goto L9d
        L84:
            com.box.android.preview.previewtype.document.CitationHighlightReducer$Action$Close r2 = com.box.android.preview.previewtype.document.CitationHighlightReducer.Action.Close.INSTANCE
            r4 = r12
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)
            r12.L$0 = r5
            java.lang.Object r13 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r13)
            r12.L$1 = r13
            r12.label = r3
            java.lang.Object r12 = r0.emit(r2, r4)
            if (r12 != r1) goto L9e
        L9d:
            return r1
        L9e:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.preview.previewtype.document.CitationHighlightReducer$build$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
