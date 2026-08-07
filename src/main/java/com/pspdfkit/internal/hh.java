package com.pspdfkit.internal;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.forms.FormCache$createFormElements$1", f = "FormCache.kt", i = {0}, l = {85}, m = "invokeSuspend", n = {FirebaseAnalytics.Param.INDEX}, nl = {82}, s = {"I$0"}, v = 2)
public final class hh extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public int a;
    public int b;
    public int c;
    public final /* synthetic */ kh d;

    @DebugMetadata(c = "com.pspdfkit.internal.forms.FormCache$createFormElements$1$1", f = "FormCache.kt", i = {}, l = {84}, m = "invokeSuspend", n = {}, nl = {85}, s = {}, v = 2)
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int a;
        public final /* synthetic */ kh b;
        public final /* synthetic */ int c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(kh khVar, int i, Continuation<? super a> continuation) {
            super(2, continuation);
            this.b = khVar;
            this.c = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new a(this.b, this.c, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return new a(this.b, this.c, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                kh khVar = this.b;
                List list = CollectionsKt.toList(((Map) khVar.e.get(this.c)).values());
                int i2 = this.c;
                this.a = 1;
                if (kh.a(khVar, list, i2, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hh(kh khVar, Continuation<? super hh> continuation) {
        super(2, continuation);
        this.d = khVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new hh(this.d, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return new hh(this.d, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0027  */
    /* JADX WARN: Code duplicated, block: B:12:0x0050 A[RETURN] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x004e -> B:13:0x0051). Please report as a decompilation issue!!! */
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
            r2 = 1
            if (r1 == 0) goto L1b
            if (r1 != r2) goto L13
            int r1 = r11.b
            int r3 = r11.a
            kotlin.ResultKt.throwOnFailure(r12)
            goto L51
        L13:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L1b:
            kotlin.ResultKt.throwOnFailure(r12)
            com.pspdfkit.internal.kh r12 = r11.d
            int r12 = r12.d
            r1 = 0
            r3 = r1
            r1 = r12
        L25:
            if (r3 >= r1) goto L53
            com.pspdfkit.internal.kh r12 = r11.d
            com.pspdfkit.internal.lm r4 = r12.b
            com.pspdfkit.internal.hh$a r8 = new com.pspdfkit.internal.hh$a
            r5 = 0
            r8.<init>(r12, r3, r5)
            com.pspdfkit.configuration.rendering.PageRenderConfiguration r12 = com.pspdfkit.internal.lm.Q
            kotlin.coroutines.EmptyCoroutineContext r6 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
            r4.getClass()
            r6.getClass()
            kotlinx.coroutines.CoroutineScope r5 = r4.b
            r9 = 2
            r10 = 0
            r7 = 0
            kotlinx.coroutines.Deferred r12 = kotlinx.coroutines.BuildersKt.async$default(r5, r6, r7, r8, r9, r10)
            r11.a = r3
            r11.b = r1
            r11.c = r2
            java.lang.Object r12 = r12.await(r11)
            if (r12 != r0) goto L51
            return r0
        L51:
            int r3 = r3 + r2
            goto L25
        L53:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pspdfkit.internal.hh.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
