package com.pspdfkit.annotations.actions;

import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.AnnotationProvider;
import com.pspdfkit.document.PdfDocument;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/pspdfkit/annotations/Annotation;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "com.pspdfkit.annotations.actions.AbstractMediaAction$getAnnotationAsync$1$1", f = "AbstractMediaAction.kt", i = {}, l = {38}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
public final class AbstractMediaAction$getAnnotationAsync$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Annotation>>, Object> {
    final /* synthetic */ PdfDocument $pdfDocument;
    int label;
    final /* synthetic */ AbstractMediaAction this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractMediaAction$getAnnotationAsync$1$1(PdfDocument pdfDocument, AbstractMediaAction abstractMediaAction, Continuation<? super AbstractMediaAction$getAnnotationAsync$1$1> continuation) {
        super(2, continuation);
        this.$pdfDocument = pdfDocument;
        this.this$0 = abstractMediaAction;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AbstractMediaAction$getAnnotationAsync$1$1(this.$pdfDocument, this.this$0, continuation);
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
        AnnotationProvider annotationProvider = this.$pdfDocument.getAnnotationProvider();
        List listListOf = CollectionsKt.listOf(Boxing.boxInt(this.this$0.getAnnotationObjectNumber()));
        this.label = 1;
        Object annotations = annotationProvider.getAnnotations(listListOf, this);
        return annotations == coroutine_suspended ? coroutine_suspended : annotations;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends Annotation>> continuation) {
        return ((AbstractMediaAction$getAnnotationAsync$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
