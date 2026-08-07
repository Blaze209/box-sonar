package com.pspdfkit.internal;

import java.util.concurrent.Callable;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.utilities.threading.ThreadingHelpersKt$runOnMainThread$2", f = "ThreadingHelpers.kt", i = {}, l = {49}, m = "invokeSuspend", n = {}, nl = {51}, s = {}, v = 2)
public final class i60 extends SuspendLambda implements Function2<CoroutineScope, Continuation<Object>, Object> {
    public int a;
    public final /* synthetic */ Callable<Object> b;

    @DebugMetadata(c = "com.pspdfkit.internal.utilities.threading.ThreadingHelpersKt$runOnMainThread$2$1", f = "ThreadingHelpers.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<Object>, Object> {
        public final /* synthetic */ Callable<Object> a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Callable<Object> callable, Continuation<? super a> continuation) {
            super(2, continuation);
            this.a = callable;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new a(this.a, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<Object> continuation) {
            Callable<Object> callable = this.a;
            new a(callable, continuation);
            Unit unit = Unit.INSTANCE;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ResultKt.throwOnFailure(unit);
            return callable.call();
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ResultKt.throwOnFailure(obj);
            return this.a.call();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i60(Callable<Object> callable, Continuation<? super i60> continuation) {
        super(2, continuation);
        this.b = callable;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new i60(this.b, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<Object> continuation) {
        return new i60(this.b, continuation).invokeSuspend(Unit.INSTANCE);
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
        MainCoroutineDispatcher main = Dispatchers.getMain();
        a aVar = new a(this.b, null);
        this.a = 1;
        Object objWithContext = BuildersKt.withContext(main, aVar, this);
        return objWithContext == coroutine_suspended ? coroutine_suspended : objWithContext;
    }
}
