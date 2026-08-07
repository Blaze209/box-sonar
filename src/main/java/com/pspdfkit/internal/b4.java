package com.pspdfkit.internal;

import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.AnnotationZIndexMove;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.annotations.AnnotationProviderImpl$moveAnnotation$6", f = "AnnotationProviderImpl.kt", i = {1, 1, 1}, l = {736, 746}, m = "invokeSuspend", n = {"annotations", "currentZIndex", "targetZIndex"}, nl = {737, 747}, s = {"L$0", "I$0", "I$1"}, v = 2)
public final class b4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public Object a;
    public int b;
    public final /* synthetic */ Annotation c;
    public final /* synthetic */ o3 d;
    public final /* synthetic */ AnnotationZIndexMove e;

    public static final /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[AnnotationZIndexMove.values().length];
            try {
                iArr[AnnotationZIndexMove.MOVE_FORWARD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AnnotationZIndexMove.MOVE_TO_FRONT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AnnotationZIndexMove.MOVE_TO_BACK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[AnnotationZIndexMove.MOVE_BACKWARD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b4(Annotation annotation, o3 o3Var, AnnotationZIndexMove annotationZIndexMove, Continuation<? super b4> continuation) {
        super(2, continuation);
        this.c = annotation;
        this.d = o3Var;
        this.e = annotationZIndexMove;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new b4(this.c, this.d, this.e, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((b4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0090, code lost:
    
        if (com.pspdfkit.internal.o3.a(r1, r3, r6, r7) == r0) goto L31;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.b
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L23
            if (r1 == r3) goto L1f
            if (r1 != r2) goto L17
            java.lang.Object r7 = r7.a
            java.util.List r7 = (java.util.List) r7
            kotlin.ResultKt.throwOnFailure(r8)
            goto L93
        L17:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L1f:
            kotlin.ResultKt.throwOnFailure(r8)
            goto L49
        L23:
            kotlin.ResultKt.throwOnFailure(r8)
            com.pspdfkit.annotations.Annotation r8 = r7.c
            boolean r8 = r8.isAttached()
            if (r8 == 0) goto L96
            com.pspdfkit.annotations.Annotation r8 = r7.c
            int r8 = r8.getPageIndex()
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r8 == r1) goto L96
            com.pspdfkit.internal.o3 r8 = r7.d
            com.pspdfkit.annotations.Annotation r1 = r7.c
            int r1 = r1.getPageIndex()
            r7.b = r3
            java.lang.Object r8 = r8.getAnnotations(r1, r7)
            if (r8 != r0) goto L49
            goto L92
        L49:
            java.util.List r8 = (java.util.List) r8
            com.pspdfkit.annotations.Annotation r1 = r7.c
            int r1 = r8.indexOf(r1)
            com.pspdfkit.annotations.AnnotationZIndexMove r4 = r7.e
            int[] r5 = com.pspdfkit.internal.b4.a.a
            int r4 = r4.ordinal()
            r4 = r5[r4]
            if (r4 == r3) goto L77
            if (r4 == r2) goto L72
            r5 = 3
            r6 = 0
            if (r4 == r5) goto L80
            r5 = 4
            if (r4 != r5) goto L6c
            int r1 = r1 - r3
            int r6 = kotlin.ranges.RangesKt.coerceAtLeast(r1, r6)
            goto L80
        L6c:
            kotlin.NoWhenBranchMatchedException r7 = new kotlin.NoWhenBranchMatchedException
            r7.<init>()
            throw r7
        L72:
            int r6 = kotlin.collections.CollectionsKt.getLastIndex(r8)
            goto L80
        L77:
            int r1 = r1 + r3
            int r3 = kotlin.collections.CollectionsKt.getLastIndex(r8)
            int r6 = kotlin.ranges.RangesKt.coerceAtMost(r1, r3)
        L80:
            com.pspdfkit.internal.o3 r1 = r7.d
            com.pspdfkit.annotations.Annotation r3 = r7.c
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r7.a = r8
            r7.b = r2
            java.lang.Object r7 = com.pspdfkit.internal.o3.a(r1, r3, r6, r7)
            if (r7 != r0) goto L93
        L92:
            return r0
        L93:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        L96:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            java.lang.String r8 = "Annotation must be attached to change its z-index."
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pspdfkit.internal.b4.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
