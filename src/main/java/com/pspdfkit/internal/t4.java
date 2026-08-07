package com.pspdfkit.internal;

import androidx.work.PeriodicWorkRequest;
import com.facebook.imageutils.JfifUtil;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.AnnotationProvider;
import com.pspdfkit.instant.annotations.InstantAnnotationProvider;
import com.pspdfkit.instant.client.InstantProgress;
import com.pspdfkit.instant.exceptions.InstantErrorCode;
import com.pspdfkit.instant.exceptions.InstantSyncException;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeoutException;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: loaded from: classes3.dex */
public final class t4 implements AnnotationProvider.OnAnnotationUpdatedListener, InstantAnnotationProvider.OnNonAnnotationChangeListener {
    public final hm a;
    public final gm b;
    public final Random c;
    public final ExecutorCoroutineDispatcher d;
    public final CoroutineScope e;
    public boolean f;
    public Job g;
    public Job h;
    public long i;
    public boolean j;
    public long k;

    public static final class a implements ThreadFactory {
        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            runnable.getClass();
            Thread thread = new Thread(runnable, "pspdfkit-instant-sync");
            thread.setDaemon(true);
            return thread;
        }
    }

    @DebugMetadata(c = "com.pspdfkit.internal.instant.document.AnnotationSyncCoordinator$createSyncFlow$1", f = "AnnotationSyncCoordinator.kt", i = {0}, l = {Token.COLONCOLON}, m = "invokeSuspend", n = {"$this$flow"}, nl = {Token.XMLATTR}, s = {"L$0"}, v = 2)
    public static final class b extends SuspendLambda implements Function2<FlowCollector<? super InstantProgress>, Continuation<? super Unit>, Object> {
        public int a;
        public /* synthetic */ Object b;
        public final /* synthetic */ long c;
        public final /* synthetic */ Flow<InstantProgress> d;

        @DebugMetadata(c = "com.pspdfkit.internal.instant.document.AnnotationSyncCoordinator$createSyncFlow$1$1", f = "AnnotationSyncCoordinator.kt", i = {}, l = {Token.XML}, m = "invokeSuspend", n = {}, nl = {Token.DOTQUERY}, s = {}, v = 2)
        public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            public int a;
            public final /* synthetic */ Flow<InstantProgress> b;
            public final /* synthetic */ FlowCollector<InstantProgress> c;

            /* JADX INFO: renamed from: com.pspdfkit.internal.t4$b$a$a, reason: collision with other inner class name */
            public static final class C0287a<T> implements FlowCollector {
                public final /* synthetic */ FlowCollector<InstantProgress> a;

                /* JADX WARN: Multi-variable type inference failed */
                public C0287a(FlowCollector<? super InstantProgress> flowCollector) {
                    this.a = flowCollector;
                }

                @Override // kotlinx.coroutines.flow.FlowCollector
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Object emit(InstantProgress instantProgress, Continuation<? super Unit> continuation) {
                    Object objEmit = this.a.emit(instantProgress, continuation);
                    return objEmit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objEmit : Unit.INSTANCE;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public a(Flow<InstantProgress> flow, FlowCollector<? super InstantProgress> flowCollector, Continuation<? super a> continuation) {
                super(2, continuation);
                this.b = flow;
                this.c = flowCollector;
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
                    Flow<InstantProgress> flow = this.b;
                    C0287a c0287a = new C0287a(this.c);
                    this.a = 1;
                    if (flow.collect(c0287a, this) == coroutine_suspended) {
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
        public b(long j, Flow<InstantProgress> flow, Continuation<? super b> continuation) {
            super(2, continuation);
            this.c = j;
            this.d = flow;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            b bVar = new b(this.c, this.d, continuation);
            bVar.b = obj;
            return bVar;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super InstantProgress> flowCollector, Continuation<? super Unit> continuation) {
            return ((b) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r7v7, types: [java.lang.Object, kotlin.Unit] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws TimeoutException {
            FlowCollector flowCollector = (FlowCollector) this.b;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    long j = this.c;
                    a aVar = new a(this.d, flowCollector, null);
                    this.b = SpillingKt.nullOutSpilledVariable(flowCollector);
                    this.a = 1;
                    if (TimeoutKt.withTimeout(j, aVar, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                this = Unit.INSTANCE;
                return this;
            } catch (TimeoutCancellationException unused) {
                throw new TimeoutException("Instant annotation sync timed out after " + this.c + " ms");
            }
        }
    }

    @DebugMetadata(c = "com.pspdfkit.internal.instant.document.AnnotationSyncCoordinator$createSyncFlow$2", f = "AnnotationSyncCoordinator.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    public static final class c extends SuspendLambda implements Function3<FlowCollector<? super InstantProgress>, Throwable, Continuation<? super Unit>, Object> {
        public /* synthetic */ Throwable a;

        public c(Continuation<? super c> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(FlowCollector<? super InstantProgress> flowCollector, Throwable th, Continuation<? super Unit> continuation) throws Throwable {
            c cVar = t4.this.new c(continuation);
            cVar.a = th;
            cVar.invokeSuspend(Unit.INSTANCE);
            throw null;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            boolean z;
            Throwable th = this.a;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ResultKt.throwOnFailure(obj);
            InstantSyncException instantSyncException = th instanceof InstantSyncException ? (InstantSyncException) th : null;
            if (instantSyncException == null) {
                throw th;
            }
            t4 t4Var = t4.this;
            InstantErrorCode errorCode = instantSyncException.getErrorCode();
            errorCode.getClass();
            switch (jj.a[errorCode.ordinal()]) {
                case 1:
                    z = false;
                    break;
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                case 15:
                case 16:
                case 17:
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                    z = true;
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            t4Var.a(z);
            throw th;
        }
    }

    @DebugMetadata(c = "com.pspdfkit.internal.instant.document.AnnotationSyncCoordinator$scheduleSyncAction$1", f = "AnnotationSyncCoordinator.kt", i = {}, l = {224}, m = "invokeSuspend", n = {}, nl = {JfifUtil.MARKER_APP1}, s = {}, v = 2)
    public static final class d extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int a;
        public final /* synthetic */ long b;
        public final /* synthetic */ Function0<Unit> c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(long j, Function0<Unit> function0, Continuation<? super d> continuation) {
            super(2, continuation);
            this.b = j;
            this.c = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new d(this.b, this.c, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return new d(this.b, this.c, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                long j = this.b;
                this.a = 1;
                if (DelayKt.delay(j, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            this.c.invoke();
            return Unit.INSTANCE;
        }
    }

    public t4(hm hmVar) {
        this.a = hmVar;
        gm internal = hmVar.S.getInternal();
        internal.getClass();
        this.b = internal;
        this.c = new Random();
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(new a());
        executorServiceNewSingleThreadExecutor.getClass();
        ExecutorCoroutineDispatcher executorCoroutineDispatcherFrom = ExecutorsKt.from(executorServiceNewSingleThreadExecutor);
        this.d = executorCoroutineDispatcherFrom;
        this.e = CoroutineScopeKt.CoroutineScope(executorCoroutineDispatcherFrom.plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
        this.f = true;
        this.k = Long.MIN_VALUE;
        a(1000L);
        wk annotationProvider = hmVar.getAnnotationProvider();
        annotationProvider.getClass();
        annotationProvider.q.add(this);
    }

    public static final Unit b(t4 t4Var) {
        synchronized (t4Var) {
            t4Var.a();
            t4Var.g = BuildersKt__Builders_commonKt.launch$default(t4Var.e, null, null, new u4(t4Var, false, null), 3, null);
        }
        return Unit.INSTANCE;
    }

    public final Flow<InstantProgress> a(boolean z, boolean z2) {
        zk zkVar;
        long j = z ? 10000L : PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS;
        gm gmVar = this.b;
        synchronized (gmVar) {
            zkVar = gmVar.i;
            if (zkVar == null) {
                throw new IllegalStateException("getAnnotationSyncManager() must be called only after InstantPdfDocument has been opened!");
            }
        }
        return FlowKt.flowOn(FlowKt.m16356catch(FlowKt.flow(new b(j, FlowKt.callbackFlow(new cl(zkVar, z, z2, null)), null)), new c(null)), this.d);
    }

    public final void c() {
        long j = this.k;
        if (j < 0 || j == Long.MAX_VALUE) {
            return;
        }
        a(new Function0() { // from class: com.pspdfkit.internal.t4$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return t4.a(this.f$0);
            }
        }, this.k);
    }

    public final void d() {
        if (this.j) {
            a(new Function0() { // from class: com.pspdfkit.internal.t4$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return t4.b(this.f$0);
                }
            }, 100L);
        }
    }

    @Override // com.pspdfkit.annotations.AnnotationProvider.OnAnnotationUpdatedListener
    public final void onAnnotationCreated(Annotation annotation) {
        annotation.getClass();
        annotation.getClass();
        c();
    }

    @Override // com.pspdfkit.annotations.AnnotationProvider.OnAnnotationUpdatedListener
    public final void onAnnotationRemoved(Annotation annotation) {
        annotation.getClass();
        annotation.getClass();
        c();
    }

    @Override // com.pspdfkit.annotations.AnnotationProvider.OnAnnotationUpdatedListener
    public final void onAnnotationUpdated(Annotation annotation) {
        annotation.getClass();
        c();
    }

    @Override // com.pspdfkit.annotations.AnnotationProvider.OnAnnotationUpdatedListener
    public final void onAnnotationZOrderChanged(int i, List<? extends Annotation> list, List<? extends Annotation> list2) {
        list.getClass();
        list2.getClass();
        c();
    }

    @Override // com.pspdfkit.instant.annotations.InstantAnnotationProvider.OnNonAnnotationChangeListener
    public final void onNonAnnotationChange(InstantAnnotationProvider.NonAnnotationChange nonAnnotationChange) {
        nonAnnotationChange.getClass();
        c();
    }

    public static final Unit c(t4 t4Var) {
        synchronized (t4Var) {
            t4Var.a();
            t4Var.g = BuildersKt__Builders_commonKt.launch$default(t4Var.e, null, null, new u4(t4Var, false, null), 3, null);
        }
        return Unit.INSTANCE;
    }

    public final synchronized void b() {
        Job job = this.h;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.h = null;
    }

    public static final Unit a(t4 t4Var) {
        synchronized (t4Var) {
            t4Var.a();
            t4Var.g = BuildersKt__Builders_commonKt.launch$default(t4Var.e, null, null, new u4(t4Var, true, null), 3, null);
        }
        return Unit.INSTANCE;
    }

    public final synchronized void a(boolean z) {
        if (this.j && this.f) {
            if (!z) {
                this.i = 100L;
            } else {
                long j = this.i;
                this.i = Math.min(((long) 1000) + j + ((long) this.c.nextInt((int) j)), 60000L);
            }
            a(new Function0() { // from class: com.pspdfkit.internal.t4$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return t4.c(this.f$0);
                }
            }, this.i);
        }
    }

    public final synchronized void a(Function0<Unit> function0, long j) {
        if (this.f) {
            b();
            this.h = BuildersKt__Builders_commonKt.launch$default(this.e, null, null, new d(j, function0, null), 3, null);
        }
    }

    public final synchronized void a() {
        b();
        Job job = this.g;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.g = null;
    }

    public final synchronized void a(long j) {
        if (this.k == j) {
            return;
        }
        this.k = j;
        if (j >= 0 && j != Long.MAX_VALUE) {
            wk annotationProvider = this.a.getAnnotationProvider();
            annotationProvider.getClass();
            annotationProvider.h.a(this);
        } else {
            wk annotationProvider2 = this.a.getAnnotationProvider();
            annotationProvider2.getClass();
            annotationProvider2.h.b(this);
        }
    }
}
