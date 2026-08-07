package com.pspdfkit.internal;

import android.graphics.PointF;
import android.graphics.RectF;
import com.pspdfkit.internal.jni.NativeRectDescriptor;
import com.pspdfkit.internal.jni.NativeTextParser;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.views.page.pageview.data.PageTextBlockRetrievalHelper$getFirstMatchingTextBlockAsync$1", f = "Utility.kt", i = {0}, l = {82}, m = "invokeSuspend", n = {"$this$launch"}, nl = {81}, s = {"L$0"}, v = 2)
public final class ru extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public int a;
    public /* synthetic */ Object b;
    public final /* synthetic */ Function1<qu, Unit> c;
    public final /* synthetic */ List<pu> d;

    @DebugMetadata(c = "com.pspdfkit.internal.views.page.pageview.data.PageTextBlockRetrievalHelper$getFirstMatchingTextBlockAsync$1$result$1", f = "Utility.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super qu>, Object> {
        public final /* synthetic */ List<pu> a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(List<pu> list, Continuation<? super a> continuation) {
            super(2, continuation);
            this.a = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new a(this.a, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super qu> continuation) {
            return new a(this.a, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            qu quVar;
            NativeRectDescriptor nativeRectDescriptorTextRectAt;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ResultKt.throwOnFailure(obj);
            Iterator<T> it = this.a.iterator();
            do {
                quVar = null;
                if (!it.hasNext()) {
                    break;
                }
                pu puVar = (pu) it.next();
                lm lmVar = puVar.a;
                int i = puVar.b;
                PointF pointF = puVar.d;
                PointF pointF2 = new PointF(pointF.x, pointF.y);
                float f = puVar.e;
                NativeTextParser nativeTextParserA = lmVar.c.b(i).a();
                RectF rect = (nativeTextParserA == null || (nativeRectDescriptorTextRectAt = nativeTextParserA.textRectAt(pointF2, f)) == null) ? null : nativeRectDescriptorTextRectAt.getRect();
                if (rect != null) {
                    puVar.c.mapRect(rect);
                    float f2 = -puVar.e;
                    rect.inset(f2, f2);
                    quVar = new qu(puVar.b, rect);
                }
            } while (quVar == null);
            return quVar;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ru(Function1<? super qu, Unit> function1, List<pu> list, Continuation<? super ru> continuation) {
        super(2, continuation);
        this.c = function1;
        this.d = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ru ruVar = new ru(this.c, this.d, continuation);
        ruVar.b = obj;
        return ruVar;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ru) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope = (CoroutineScope) this.b;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ExecutorCoroutineDispatcher executorCoroutineDispatcher = su.a;
            a aVar = new a(this.d, null);
            this.b = coroutineScope;
            this.a = 1;
            obj = BuildersKt.withContext(executorCoroutineDispatcher, aVar, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        qu quVar = (qu) obj;
        if (CoroutineScopeKt.isActive(coroutineScope)) {
            this.c.invoke(quVar);
        }
        return Unit.INSTANCE;
    }
}
