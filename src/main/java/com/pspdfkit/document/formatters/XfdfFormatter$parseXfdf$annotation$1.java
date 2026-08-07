package com.pspdfkit.document.formatters;

import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.internal.jni.NativeAnnotation;
import com.pspdfkit.internal.lm;
import com.pspdfkit.internal.o3;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/pspdfkit/annotations/Annotation;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "com.pspdfkit.document.formatters.XfdfFormatter$parseXfdf$annotation$1", f = "XfdfFormatter.kt", i = {}, l = {100}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
public final class XfdfFormatter$parseXfdf$annotation$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Annotation>, Object> {
    final /* synthetic */ lm $internalPdfDocument;
    final /* synthetic */ NativeAnnotation $nativeAnnotation;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public XfdfFormatter$parseXfdf$annotation$1(lm lmVar, NativeAnnotation nativeAnnotation, Continuation<? super XfdfFormatter$parseXfdf$annotation$1> continuation) {
        super(2, continuation);
        this.$internalPdfDocument = lmVar;
        this.$nativeAnnotation = nativeAnnotation;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new XfdfFormatter$parseXfdf$annotation$1(this.$internalPdfDocument, this.$nativeAnnotation, continuation);
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
        o3 annotationProvider = this.$internalPdfDocument.getAnnotationProvider();
        NativeAnnotation nativeAnnotation = this.$nativeAnnotation;
        this.label = 1;
        Object objA = annotationProvider.a(nativeAnnotation, true, (ContinuationImpl) this);
        return objA == coroutine_suspended ? coroutine_suspended : objA;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Annotation> continuation) {
        return ((XfdfFormatter$parseXfdf$annotation$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
