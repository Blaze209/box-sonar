package com.pspdfkit.internal;

import com.pspdfkit.annotations.Annotation;
import java.util.ArrayList;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.views.page.handler.EraserAnnotationModeHandler$extractAnnotations$1", f = "EraserAnnotationModeHandler.kt", i = {}, l = {201}, m = "invokeSuspend", n = {}, nl = {203}, s = {}, v = 2)
public final class hg extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public int a;
    public final /* synthetic */ jg b;
    public final /* synthetic */ o3 c;

    @DebugMetadata(c = "com.pspdfkit.internal.views.page.handler.EraserAnnotationModeHandler$extractAnnotations$1$annotations$1", f = "EraserAnnotationModeHandler.kt", i = {}, l = {202}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Annotation>>, Object> {
        public int a;
        public final /* synthetic */ o3 b;
        public final /* synthetic */ jg c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(o3 o3Var, jg jgVar, Continuation<? super a> continuation) {
            super(2, continuation);
            this.b = o3Var;
            this.c = jgVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new a(this.b, this.c, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends Annotation>> continuation) {
            return new a(this.b, this.c, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            o3 o3Var = this.b;
            int iK = this.c.k();
            this.a = 1;
            Object annotations = o3Var.getAnnotations(iK, this);
            return annotations == coroutine_suspended ? coroutine_suspended : annotations;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hg(jg jgVar, o3 o3Var, Continuation<? super hg> continuation) {
        super(2, continuation);
        this.b = jgVar;
        this.c = o3Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new hg(this.b, this.c, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return new hg(this.b, this.c, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        i4 annotationRenderingCoordinator;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineDispatcher io2 = Dispatchers.getIO();
            a aVar = new a(this.c, this.b, null);
            this.a = 1;
            obj = BuildersKt.withContext(io2, aVar, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : (Iterable) obj) {
            if (jg.a((Annotation) obj2)) {
                arrayList.add(obj2);
            }
        }
        this.b.d.setAnnotations(arrayList);
        au auVarL = this.b.l();
        if (auVarL != null && (annotationRenderingCoordinator = auVarL.getAnnotationRenderingCoordinator()) != null) {
            int size = arrayList.size();
            int i2 = 0;
            while (i2 < size) {
                Object obj3 = arrayList.get(i2);
                i2++;
                annotationRenderingCoordinator.a((Annotation) obj3);
            }
            annotationRenderingCoordinator.a((List<? extends Annotation>) arrayList, false, (Function0<Unit>) null);
        }
        return Unit.INSTANCE;
    }
}
