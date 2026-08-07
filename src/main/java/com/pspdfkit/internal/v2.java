package com.pspdfkit.internal;

import com.facebook.react.modules.dialog.AlertFragment;
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
@DebugMetadata(c = "com.pspdfkit.internal.views.outline.annotations.AnnotationListProvider$refreshAnnotations$1", f = "AnnotationListProvider.kt", i = {0, 1, 1}, l = {72, 74, 81, 81}, m = "invokeSuspend", n = {"pageIndex", AlertFragment.ARG_ITEMS, "pageIndex"}, nl = {73, 71, 85, 86}, s = {"I$0", "L$0", "I$0"}, v = 2)
public final class v2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public int a;
    public Object b;
    public int c;
    public final /* synthetic */ int d;
    public final /* synthetic */ x2 e;
    public final /* synthetic */ lm f;

    @DebugMetadata(c = "com.pspdfkit.internal.views.outline.annotations.AnnotationListProvider$refreshAnnotations$1$1", f = "AnnotationListProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public final /* synthetic */ x2 a;
        public final /* synthetic */ List<fo> b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(x2 x2Var, List<? extends fo> list, Continuation<? super a> continuation) {
            super(2, continuation);
            this.a = x2Var;
            this.b = list;
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
            this.a.f.addAll(this.b);
            x2 x2Var = this.a;
            x2Var.b.a((List<? extends fo>) x2Var.f, true);
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.pspdfkit.internal.views.outline.annotations.AnnotationListProvider$refreshAnnotations$1$2", f = "AnnotationListProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public final /* synthetic */ x2 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(x2 x2Var, Continuation<? super b> continuation) {
            super(2, continuation);
            this.a = x2Var;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new b(this.a, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return new b(this.a, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ResultKt.throwOnFailure(obj);
            x2 x2Var = this.a;
            x2Var.b.a((List<? extends fo>) x2Var.f, false);
            this.a.g = null;
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v2(int i, x2 x2Var, lm lmVar, Continuation<? super v2> continuation) {
        super(2, continuation);
        this.d = i;
        this.e = x2Var;
        this.f = lmVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new v2(this.d, this.e, this.f, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((v2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0043 A[Catch: all -> 0x0097, TryCatch #0 {all -> 0x0097, blocks: (B:13:0x0031, B:19:0x003f, B:21:0x0043, B:25:0x0057, B:27:0x005f, B:16:0x0037), top: B:42:0x000b }] */
    /* JADX WARN: Code duplicated, block: B:23:0x0053  */
    /* JADX WARN: Code duplicated, block: B:24:0x0054  */
    /* JADX WARN: Code duplicated, block: B:27:0x005f A[Catch: all -> 0x0097, TRY_LEAVE, TryCatch #0 {all -> 0x0097, blocks: (B:13:0x0031, B:19:0x003f, B:21:0x0043, B:25:0x0057, B:27:0x005f, B:16:0x0037), top: B:42:0x000b }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x005d -> B:30:0x007b). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x0078 -> B:30:0x007b). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r11.c
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            if (r1 == 0) goto L3b
            if (r1 == r5) goto L35
            if (r1 == r4) goto L2b
            if (r1 == r3) goto L26
            if (r1 == r2) goto L1d
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L1d:
            java.lang.Object r11 = r11.b
            java.lang.Throwable r11 = (java.lang.Throwable) r11
            kotlin.ResultKt.throwOnFailure(r12)
            goto Laf
        L26:
            kotlin.ResultKt.throwOnFailure(r12)
            goto L94
        L2b:
            int r1 = r11.a
            java.lang.Object r7 = r11.b
            java.util.List r7 = (java.util.List) r7
            kotlin.ResultKt.throwOnFailure(r12)     // Catch: java.lang.Throwable -> L97
            goto L7b
        L35:
            int r1 = r11.a
            kotlin.ResultKt.throwOnFailure(r12)     // Catch: java.lang.Throwable -> L97
            goto L57
        L3b:
            kotlin.ResultKt.throwOnFailure(r12)
            r12 = 0
        L3f:
            int r1 = r11.d     // Catch: java.lang.Throwable -> L97
            if (r12 >= r1) goto L7e
            com.pspdfkit.internal.x2 r1 = r11.e     // Catch: java.lang.Throwable -> L97
            com.pspdfkit.internal.lm r7 = r11.f     // Catch: java.lang.Throwable -> L97
            r11.b = r6     // Catch: java.lang.Throwable -> L97
            r11.a = r12     // Catch: java.lang.Throwable -> L97
            r11.c = r5     // Catch: java.lang.Throwable -> L97
            java.lang.Object r1 = com.pspdfkit.internal.x2.a(r1, r7, r12, r11)     // Catch: java.lang.Throwable -> L97
            if (r1 != r0) goto L54
            goto Lad
        L54:
            r10 = r1
            r1 = r12
            r12 = r10
        L57:
            java.util.List r12 = (java.util.List) r12     // Catch: java.lang.Throwable -> L97
            boolean r7 = r12.isEmpty()     // Catch: java.lang.Throwable -> L97
            if (r7 != 0) goto L7b
            kotlinx.coroutines.MainCoroutineDispatcher r7 = kotlinx.coroutines.Dispatchers.getMain()     // Catch: java.lang.Throwable -> L97
            com.pspdfkit.internal.v2$a r8 = new com.pspdfkit.internal.v2$a     // Catch: java.lang.Throwable -> L97
            com.pspdfkit.internal.x2 r9 = r11.e     // Catch: java.lang.Throwable -> L97
            r8.<init>(r9, r12, r6)     // Catch: java.lang.Throwable -> L97
            java.lang.Object r12 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r12)     // Catch: java.lang.Throwable -> L97
            r11.b = r12     // Catch: java.lang.Throwable -> L97
            r11.a = r1     // Catch: java.lang.Throwable -> L97
            r11.c = r4     // Catch: java.lang.Throwable -> L97
            java.lang.Object r12 = kotlinx.coroutines.BuildersKt.withContext(r7, r8, r11)     // Catch: java.lang.Throwable -> L97
            if (r12 != r0) goto L7b
            goto Lad
        L7b:
            int r12 = r1 + 1
            goto L3f
        L7e:
            kotlinx.coroutines.MainCoroutineDispatcher r12 = kotlinx.coroutines.Dispatchers.getMain()
            com.pspdfkit.internal.v2$b r1 = new com.pspdfkit.internal.v2$b
            com.pspdfkit.internal.x2 r2 = r11.e
            r1.<init>(r2, r6)
            r11.b = r6
            r11.c = r3
            java.lang.Object r11 = kotlinx.coroutines.BuildersKt.withContext(r12, r1, r11)
            if (r11 != r0) goto L94
            goto Lad
        L94:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        L97:
            r12 = move-exception
            kotlinx.coroutines.MainCoroutineDispatcher r1 = kotlinx.coroutines.Dispatchers.getMain()
            com.pspdfkit.internal.v2$b r3 = new com.pspdfkit.internal.v2$b
            com.pspdfkit.internal.x2 r4 = r11.e
            r3.<init>(r4, r6)
            r11.b = r12
            r11.c = r2
            java.lang.Object r11 = kotlinx.coroutines.BuildersKt.withContext(r1, r3, r11)
            if (r11 != r0) goto Lae
        Lad:
            return r0
        Lae:
            r11 = r12
        Laf:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pspdfkit.internal.v2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
