package com.pspdfkit.internal;

import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.AnnotationProvider;
import com.pspdfkit.annotations.AnnotationType;
import com.pspdfkit.annotations.RedactionAnnotation;
import com.pspdfkit.document.PdfDocument;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.ui.redaction.RedactionUiCoordinatorImpl$onDocumentLoaded$1", f = "RedactionUiCoordinator.kt", i = {}, l = {86}, m = "invokeSuspend", n = {}, nl = {85}, s = {}, v = 2)
public final class hy extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public int a;
    public final /* synthetic */ PdfDocument b;
    public final /* synthetic */ iy c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hy(PdfDocument pdfDocument, iy iyVar, Continuation<? super hy> continuation) {
        super(2, continuation);
        this.b = pdfDocument;
        this.c = iyVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new hy(this.b, this.c, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return new hy(this.b, this.c, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                AnnotationProvider annotationProvider = this.b.getAnnotationProvider();
                EnumSet enumSetOf = EnumSet.of(AnnotationType.REDACT);
                enumSetOf.getClass();
                int iMin = Math.min(this.b.getPageCount(), 2000);
                this.a = 1;
                obj = annotationProvider.getAllAnnotationsOfType(enumSetOf, 0, iMin, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            ArrayList arrayList = this.c.e;
            ArrayList arrayList2 = new ArrayList();
            for (Annotation annotation : (List) obj) {
                RedactionAnnotation redactionAnnotation = annotation instanceof RedactionAnnotation ? (RedactionAnnotation) annotation : null;
                if (redactionAnnotation != null) {
                    arrayList2.add(redactionAnnotation);
                }
            }
            arrayList.addAll(arrayList2);
            iy iyVar = this.c;
            boolean zIsEmpty = iyVar.e.isEmpty();
            dv dvVar = iyVar.a;
            if (zIsEmpty) {
                dvVar.d();
            } else {
                dvVar.v();
            }
        } catch (Throwable unused) {
        }
        return Unit.INSTANCE;
    }
}
