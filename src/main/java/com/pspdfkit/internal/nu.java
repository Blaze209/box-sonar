package com.pspdfkit.internal;

import android.graphics.Bitmap;
import com.box.android.common.utilities.BoxCommonConstants;
import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.rendering.PageRendererCoroutines$renderWithPriority$2", f = "PageRendererCoroutines.kt", i = {0, 0, 0, 0, 0}, l = {313}, m = "invokeSuspend", n = {"$this$coroutineScope", "taskId", "deferred", "task", "renderJob"}, nl = {-1}, s = {"L$0", "L$1", "L$2", "L$3", "L$4"}, v = 2)
public final class nu extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Bitmap>, Object> {
    public Object a;
    public Object b;
    public Object c;
    public Object d;
    public int e;
    public /* synthetic */ Object f;
    public final /* synthetic */ jm g;
    public final /* synthetic */ int h;
    public final /* synthetic */ mu i;

    @DebugMetadata(c = "com.pspdfkit.internal.rendering.PageRendererCoroutines$renderWithPriority$2$renderJob$1", f = "PageRendererCoroutines.kt", i = {0}, l = {289}, m = "invokeSuspend", n = {"$this$launch"}, nl = {290}, s = {"L$0"}, v = 2)
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int a;
        public /* synthetic */ Object b;
        public final /* synthetic */ jm c;
        public final /* synthetic */ int d;
        public final /* synthetic */ mu e;
        public final /* synthetic */ CompletableDeferred<Bitmap> f;
        public final /* synthetic */ String g;

        /* JADX INFO: renamed from: com.pspdfkit.internal.nu$a$a, reason: collision with other inner class name */
        @DebugMetadata(c = "com.pspdfkit.internal.rendering.PageRendererCoroutines$renderWithPriority$2$renderJob$1$1", f = "PageRendererCoroutines.kt", i = {}, l = {BoxCommonConstants.REQUEST_CHOOSE_LOCAL_UPLOAD_DIR}, m = "invokeSuspend", n = {}, nl = {BoxCommonConstants.REQUEST_CHOOSE_REMOTE_UPLOAD_DIR}, s = {}, v = 2)
        public static final class C0278a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            public int a;
            public final /* synthetic */ jm b;
            public final /* synthetic */ int c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0278a(jm jmVar, int i, Continuation continuation) {
                super(2, continuation);
                this.b = jmVar;
                this.c = i;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C0278a(this.b, this.c, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return new C0278a(this.b, this.c, continuation).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.a;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    ConcurrentHashMap<String, ju.a> concurrentHashMap = ju.a;
                    jm jmVar = this.b;
                    int i2 = this.c;
                    this.a = 1;
                    if (BuildersKt.withContext(Dispatchers.getIO(), new ku(jmVar, i2, null), this) == coroutine_suspended) {
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
        public a(jm jmVar, int i, mu muVar, CompletableDeferred completableDeferred, String str, Continuation continuation) {
            super(2, continuation);
            this.c = jmVar;
            this.d = i;
            this.e = muVar;
            this.f = completableDeferred;
            this.g = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            a aVar = new a(this.c, this.d, this.e, this.f, this.g, continuation);
            aVar.b = obj;
            return aVar;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineScope coroutineScope = (CoroutineScope) this.b;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            try {
                try {
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        ConcurrentHashMap<String, ju.a> concurrentHashMap = ju.a;
                        jm jmVar = this.c;
                        int i2 = this.d;
                        mu muVar = this.e;
                        this.b = coroutineScope;
                        this.a = 1;
                        obj = ju.a(jmVar, "HighResProvider", i2, muVar, this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    this.f.complete((Bitmap) obj);
                } catch (CancellationException e) {
                    if (this.d > 0) {
                        BuildersKt__Builders_commonKt.launch$default(coroutineScope, Dispatchers.getIO(), null, new C0278a(this.c, this.d, null), 2, null);
                    }
                    this.f.cancel(e);
                } catch (Exception e2) {
                    this.f.completeExceptionally(e2);
                }
                ju.a.remove(this.g);
                return Unit.INSTANCE;
            } catch (Throwable th) {
                ju.a.remove(this.g);
                throw th;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public nu(jm jmVar, int i, mu muVar, Continuation continuation) {
        super(2, continuation);
        this.g = jmVar;
        this.h = i;
        this.i = muVar;
    }

    public static final Unit a(Job job, Throwable th) {
        if (th instanceof CancellationException) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        nu nuVar = new nu(this.g, this.h, this.i, continuation);
        nuVar.f = obj;
        return nuVar;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Bitmap> continuation) {
        return ((nu) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope = (CoroutineScope) this.f;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.e;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return obj;
        }
        ResultKt.throwOnFailure(obj);
        String str = this.g.b + CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR + System.nanoTime();
        CompletableDeferred completableDeferredCompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        ju.a aVar = new ju.a(str, this.g.h, System.currentTimeMillis(), completableDeferredCompletableDeferred$default, this.h);
        ju.a.put(str, aVar);
        int i2 = this.g.h;
        Map<Integer, CoroutineDispatcher> map = ju.b;
        CoroutineDispatcher coroutineDispatcher = map.get(Integer.valueOf(i2));
        if (coroutineDispatcher == null) {
            CoroutineDispatcher coroutineDispatcher2 = map.get(5);
            coroutineDispatcher2.getClass();
            coroutineDispatcher = coroutineDispatcher2;
        }
        final Job jobLaunch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope, coroutineDispatcher, null, new a(this.g, this.h, this.i, completableDeferredCompletableDeferred$default, str, null), 2, null);
        completableDeferredCompletableDeferred$default.invokeOnCompletion(new Function1() { // from class: com.pspdfkit.internal.nu$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                return nu.a(jobLaunch$default, (Throwable) obj2);
            }
        });
        this.f = SpillingKt.nullOutSpilledVariable(coroutineScope);
        this.a = SpillingKt.nullOutSpilledVariable(str);
        this.b = SpillingKt.nullOutSpilledVariable(completableDeferredCompletableDeferred$default);
        this.c = SpillingKt.nullOutSpilledVariable(aVar);
        this.d = SpillingKt.nullOutSpilledVariable(jobLaunch$default);
        this.e = 1;
        Object objAwait = completableDeferredCompletableDeferred$default.await(this);
        return objAwait == coroutine_suspended ? coroutine_suspended : objAwait;
    }
}
