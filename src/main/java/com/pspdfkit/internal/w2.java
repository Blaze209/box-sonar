package com.pspdfkit.internal;

import com.pspdfkit.annotations.Annotation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.views.outline.annotations.AnnotationListProvider$removeAllItems$1", f = "AnnotationListProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
public final class w2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ ArrayList a;
    public final /* synthetic */ x2 b;
    public final /* synthetic */ lm c;
    public final /* synthetic */ ArrayList d;

    @DebugMetadata(c = "com.pspdfkit.internal.views.outline.annotations.AnnotationListProvider$removeAllItems$1$2$1$1$1", f = "AnnotationListProvider.kt", i = {}, l = {201}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int a;
        public final /* synthetic */ o3 b;
        public final /* synthetic */ fo.a c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(o3 o3Var, fo.a aVar, Continuation<? super a> continuation) {
            super(2, continuation);
            this.b = o3Var;
            this.c = aVar;
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
                o3 o3Var = this.b;
                Annotation annotation = this.c.b;
                this.a = 1;
                if (o3Var.removeAnnotationFromPage(annotation, this) == coroutine_suspended) {
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
    public w2(ArrayList arrayList, x2 x2Var, lm lmVar, ArrayList arrayList2, Continuation continuation) {
        super(2, continuation);
        this.a = arrayList;
        this.b = x2Var;
        this.c = lmVar;
        this.d = arrayList2;
    }

    public static final void a(List list, o3 o3Var) throws InterruptedException {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            BuildersKt__BuildersKt.runBlocking$default(null, new a(o3Var, (fo.a) it.next(), null), 1, null);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new w2(this.a, this.b, this.c, this.d, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((w2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        ArrayList arrayList = this.a;
        x2 x2Var = this.b;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj2 = arrayList.get(i);
            i++;
            x2Var.getClass();
            ((fo.b) obj2).c.getFormField().reset();
        }
        final o3 annotationProvider = this.c.getAnnotationProvider();
        x2 x2Var2 = this.b;
        final ArrayList arrayList2 = this.d;
        annotationProvider.a(x2Var2.c, new Runnable() { // from class: com.pspdfkit.internal.w2$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() throws InterruptedException {
                w2.a(arrayList2, annotationProvider);
            }
        });
        return Unit.INSTANCE;
    }
}
