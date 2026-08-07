package com.pspdfkit.annotations.actions;

import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.AnnotationProvider;
import com.pspdfkit.document.PdfDocument;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/pspdfkit/annotations/Annotation;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "com.pspdfkit.annotations.actions.HideAction$getAnnotationsAsync$1$2", f = "HideAction.kt", i = {}, l = {91}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
public final class HideAction$getAnnotationsAsync$1$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Annotation>>, Object> {
    final /* synthetic */ HashSet<Integer> $annotationObjectNumbers;
    final /* synthetic */ PdfDocument $document;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HideAction$getAnnotationsAsync$1$2(PdfDocument pdfDocument, HashSet<Integer> hashSet, Continuation<? super HideAction$getAnnotationsAsync$1$2> continuation) {
        super(2, continuation);
        this.$document = pdfDocument;
        this.$annotationObjectNumbers = hashSet;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HideAction$getAnnotationsAsync$1$2(this.$document, this.$annotationObjectNumbers, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return obj;
        }
        ResultKt.throwOnFailure(obj);
        AnnotationProvider annotationProvider = this.$document.getAnnotationProvider();
        HashSet<Integer> hashSet = this.$annotationObjectNumbers;
        this.label = 1;
        Object annotations = annotationProvider.getAnnotations(hashSet, this);
        return annotations == coroutine_suspended ? coroutine_suspended : annotations;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends Annotation>> continuation) {
        return ((HideAction$getAnnotationsAsync$1$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
