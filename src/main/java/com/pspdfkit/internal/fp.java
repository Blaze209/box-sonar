package com.pspdfkit.internal;

import android.os.Bundle;
import com.pspdfkit.analytics.Analytics;
import com.pspdfkit.annotations.BaseRectsAnnotation;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.views.page.handler.MarkupAnnotationModeHandler$updateAnnotationData$2", f = "MarkupAnnotationModeHandler.kt", i = {}, l = {335, 336}, m = "invokeSuspend", n = {}, nl = {336, 344}, s = {}, v = 2)
public final class fp extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public int a;
    public final /* synthetic */ lm b;
    public final /* synthetic */ BaseRectsAnnotation c;
    public final /* synthetic */ dp d;

    @DebugMetadata(c = "com.pspdfkit.internal.views.page.handler.MarkupAnnotationModeHandler$updateAnnotationData$2$1", f = "MarkupAnnotationModeHandler.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public final /* synthetic */ dp a;
        public final /* synthetic */ BaseRectsAnnotation b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(dp dpVar, BaseRectsAnnotation baseRectsAnnotation, Continuation<? super a> continuation) {
            super(2, continuation);
            this.a = dpVar;
            this.b = baseRectsAnnotation;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new a(this.a, this.b, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return new a(this.a, this.b, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ResultKt.throwOnFailure(obj);
            dp dpVar = this.a;
            dpVar.a(this.b, dpVar.a);
            i0 i0VarA = ar.a();
            i0VarA.getClass();
            Bundle bundle = new Bundle();
            BaseRectsAnnotation baseRectsAnnotation = this.b;
            bundle.putString(Analytics.Data.ANNOTATION_TYPE, baseRectsAnnotation.getType().name());
            bundle.putInt(Analytics.Data.PAGE_INDEX, baseRectsAnnotation.getPageIndex());
            i0VarA.a(Analytics.Event.CREATE_ANNOTATION, bundle);
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fp(lm lmVar, BaseRectsAnnotation baseRectsAnnotation, dp dpVar, Continuation<? super fp> continuation) {
        super(2, continuation);
        this.b = lmVar;
        this.c = baseRectsAnnotation;
        this.d = dpVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new fp(this.b, this.c, this.d, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((fp) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0046, code lost:
    
        if (kotlinx.coroutines.BuildersKt.withContext(r7, r1, r6) == r0) goto L15;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.a
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1e
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.ResultKt.throwOnFailure(r7)
            goto L49
        L12:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L1a:
            kotlin.ResultKt.throwOnFailure(r7)
            goto L32
        L1e:
            kotlin.ResultKt.throwOnFailure(r7)
            com.pspdfkit.internal.lm r7 = r6.b
            com.pspdfkit.internal.o3 r7 = r7.getAnnotationProvider()
            com.pspdfkit.annotations.BaseRectsAnnotation r1 = r6.c
            r6.a = r3
            java.lang.Object r7 = r7.addAnnotationToPage(r1, r6)
            if (r7 != r0) goto L32
            goto L48
        L32:
            kotlinx.coroutines.MainCoroutineDispatcher r7 = kotlinx.coroutines.Dispatchers.getMain()
            com.pspdfkit.internal.fp$a r1 = new com.pspdfkit.internal.fp$a
            com.pspdfkit.internal.dp r3 = r6.d
            com.pspdfkit.annotations.BaseRectsAnnotation r4 = r6.c
            r5 = 0
            r1.<init>(r3, r4, r5)
            r6.a = r2
            java.lang.Object r6 = kotlinx.coroutines.BuildersKt.withContext(r7, r1, r6)
            if (r6 != r0) goto L49
        L48:
            return r0
        L49:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pspdfkit.internal.fp.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
