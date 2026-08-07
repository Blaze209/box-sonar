package com.box.android.preview.annotations.cpl;

import com.box.android.common.utilities.BoxCommonConstants;
import com.facebook.imageutils.JfifUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: AnnotationsReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/preview/annotations/cpl/AnnotationsReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.preview.annotations.cpl.AnnotationsReducer$build$1$4", f = "AnnotationsReducer.kt", i = {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 5}, l = {200, 205, 206, BoxCommonConstants.REQUEST_OPTIONS, BoxCommonConstants.REQUEST_DELETE, JfifUtil.MARKER_RST7}, m = "invokeSuspend", n = {"$this$flow", "it", "$i$a$-let-AnnotationsReducer$build$1$4$1", "$this$flow", "it", "$this$onError$iv", "it", "$i$a$-let-AnnotationsReducer$build$1$4$1", "$i$f$onError", "$i$a$-onError-AnnotationsReducer$build$1$4$1$1", "$this$flow", "it", "$this$onError$iv", "it", "$i$a$-let-AnnotationsReducer$build$1$4$1", "$i$f$onError", "$i$a$-onError-AnnotationsReducer$build$1$4$1$1", "$this$flow", "it", "$this$onSuccess$iv", "it", "$i$a$-let-AnnotationsReducer$build$1$4$1", "$i$f$onSuccess", "$i$a$-onSuccess-AnnotationsReducer$build$1$4$1$2", "$this$flow", "it", "$this$onSuccess$iv", "it", "$i$a$-let-AnnotationsReducer$build$1$4$1", "$i$f$onSuccess", "$i$a$-onSuccess-AnnotationsReducer$build$1$4$1$2", "$this$flow"}, s = {"L$0", "L$1", "I$0", "L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "I$2", "L$0"}, v = 1)
final class AnnotationsReducer$build$1$4 extends SuspendLambda implements Function2<FlowCollector<? super AnnotationsReducer.Action>, Continuation<? super Unit>, Object> {
    final /* synthetic */ AnnotationsReducer.State $state;
    int I$0;
    int I$1;
    int I$2;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ AnnotationsReducer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AnnotationsReducer$build$1$4(AnnotationsReducer.State state, AnnotationsReducer annotationsReducer, Continuation<? super AnnotationsReducer$build$1$4> continuation) {
        super(2, continuation);
        this.$state = state;
        this.this$0 = annotationsReducer;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AnnotationsReducer$build$1$4 annotationsReducer$build$1$4 = new AnnotationsReducer$build$1$4(this.$state, this.this$0, continuation);
        annotationsReducer$build$1$4.L$0 = obj;
        return annotationsReducer$build$1$4;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super AnnotationsReducer.Action> flowCollector, Continuation<? super Unit> continuation) {
        return ((AnnotationsReducer$build$1$4) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:20:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:21:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:23:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:26:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:30:0x011d  */
    /* JADX WARN: Code duplicated, block: B:34:0x0125  */
    /* JADX WARN: Code duplicated, block: B:37:0x0151  */
    /* JADX WARN: Code duplicated, block: B:42:0x017b  */
    /* JADX WARN: Code duplicated, block: B:46:0x0182  */
    /* JADX WARN: Code duplicated, block: B:48:0x0188  */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0176, code lost:
    
        if (r0.emit(r8, r11) == r1) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x017f, code lost:
    
        if (r12 == null) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x01aa, code lost:
    
        if (r0.emit(new com.box.android.preview.annotations.cpl.AnnotationsReducer.Action.AnnotationDeletionCompleted(false), r11) == r1) goto L52;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            Method dump skipped, instruction units count: 452
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.preview.annotations.cpl.AnnotationsReducer$build$1$4.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
