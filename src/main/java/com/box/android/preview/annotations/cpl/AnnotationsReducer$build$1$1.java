package com.box.android.preview.annotations.cpl;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: AnnotationsReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/preview/annotations/cpl/AnnotationsReducer$Action$Error;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.preview.annotations.cpl.AnnotationsReducer$build$1$1", f = "AnnotationsReducer.kt", i = {0, 1, 1, 1, 1, 1}, l = {134, 138}, m = "invokeSuspend", n = {"$this$flow", "$this$flow", "$this$onError$iv", "it", "$i$f$onError", "$i$a$-onError-AnnotationsReducer$build$1$1$1"}, s = {"L$0", "L$0", "L$1", "L$2", "I$0", "I$1"}, v = 1)
final class AnnotationsReducer$build$1$1 extends SuspendLambda implements Function2<FlowCollector<? super AnnotationsReducer.Action.Error>, Continuation<? super Unit>, Object> {
    final /* synthetic */ AnnotationsReducer.State $state;
    int I$0;
    int I$1;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ AnnotationsReducer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AnnotationsReducer$build$1$1(AnnotationsReducer annotationsReducer, AnnotationsReducer.State state, Continuation<? super AnnotationsReducer$build$1$1> continuation) {
        super(2, continuation);
        this.this$0 = annotationsReducer;
        this.$state = state;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AnnotationsReducer$build$1$1 annotationsReducer$build$1$1 = new AnnotationsReducer$build$1$1(this.this$0, this.$state, continuation);
        annotationsReducer$build$1$1.L$0 = obj;
        return annotationsReducer$build$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super AnnotationsReducer.Action.Error> flowCollector, Continuation<? super Unit> continuation) {
        return ((AnnotationsReducer$build$1$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0082, code lost:
    
        if (r0.emit(r4, r7) == r1) goto L19;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = r7.L$0
            kotlinx.coroutines.flow.FlowCollector r0 = (kotlinx.coroutines.flow.FlowCollector) r0
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r7.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L2a
            if (r2 == r4) goto L26
            if (r2 != r3) goto L1e
            java.lang.Object r0 = r7.L$2
            com.box.android.domain.models.DomainError r0 = (com.box.android.domain.models.DomainError) r0
            java.lang.Object r7 = r7.L$1
            com.box.android.domain.utils.result.Result r7 = (com.box.android.domain.utils.result.Result) r7
            kotlin.ResultKt.throwOnFailure(r8)
            goto L8b
        L1e:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L26:
            kotlin.ResultKt.throwOnFailure(r8)
            goto L51
        L2a:
            kotlin.ResultKt.throwOnFailure(r8)
            com.box.android.preview.annotations.cpl.AnnotationsReducer r8 = r7.this$0
            com.box.android.preview.annotations.cpl.AnnotationsEnvironment r8 = com.box.android.preview.annotations.cpl.AnnotationsReducer.access$getEnvironment$p(r8)
            com.box.android.domain.usecases.fileactivities.annotation.GetAnnotationForFileVersionInteractor r8 = r8.getGetAnnotationsVersionInteractor()
            com.box.android.preview.annotations.cpl.AnnotationsReducer$State r2 = r7.$state
            com.box.android.domain.models.ItemId r2 = r2.getFileId()
            com.box.android.preview.annotations.cpl.AnnotationsReducer$State r5 = r7.$state
            java.lang.String r5 = r5.getFileVersionId()
            r6 = r7
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
            r7.L$0 = r0
            r7.label = r4
            java.lang.Object r8 = r8.refreshAnnotations(r2, r5, r6)
            if (r8 != r1) goto L51
            goto L84
        L51:
            com.box.android.domain.utils.result.Result r8 = (com.box.android.domain.utils.result.Result) r8
            boolean r2 = r8 instanceof com.box.android.domain.utils.result.Result.Success
            if (r2 != 0) goto L8b
            boolean r2 = r8 instanceof com.box.android.domain.utils.result.Result.Error
            if (r2 == 0) goto L85
            r2 = r8
            com.box.android.domain.utils.result.Result$Error r2 = (com.box.android.domain.utils.result.Result.Error) r2
            java.lang.Object r2 = r2.getValue()
            com.box.android.domain.models.DomainError r2 = (com.box.android.domain.models.DomainError) r2
            com.box.android.preview.annotations.cpl.AnnotationsReducer$Action$Error r4 = new com.box.android.preview.annotations.cpl.AnnotationsReducer$Action$Error
            r4.<init>(r2)
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)
            r7.L$0 = r5
            r7.L$1 = r8
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r7.L$2 = r8
            r8 = 0
            r7.I$0 = r8
            r7.I$1 = r8
            r7.label = r3
            java.lang.Object r7 = r0.emit(r4, r7)
            if (r7 != r1) goto L8b
        L84:
            return r1
        L85:
            kotlin.NoWhenBranchMatchedException r7 = new kotlin.NoWhenBranchMatchedException
            r7.<init>()
            throw r7
        L8b:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.preview.annotations.cpl.AnnotationsReducer$build$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
