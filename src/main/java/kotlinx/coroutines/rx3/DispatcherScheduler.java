package kotlinx.coroutines.rx3;

import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.SendChannel;

/* JADX INFO: compiled from: RxScheduler.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u001bB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J$\u0010\f\u001a\u00020\r2\n\u0010\u000e\u001a\u00060\u000fj\u0002`\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\t\u0010\n\u001a\u00020\u000bX\u0082\u0004¨\u0006\u001c"}, d2 = {"Lkotlinx/coroutines/rx3/DispatcherScheduler;", "Lio/reactivex/rxjava3/core/Scheduler;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "(Lkotlinx/coroutines/CoroutineDispatcher;)V", "schedulerJob", "Lkotlinx/coroutines/CompletableJob;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "workerCounter", "Lkotlinx/atomicfu/AtomicLong;", "scheduleDirect", "Lio/reactivex/rxjava3/disposables/Disposable;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", SemanticAttributes.MessagingRocketmqMessageTypeValues.DELAY, "", "unit", "Ljava/util/concurrent/TimeUnit;", "createWorker", "Lio/reactivex/rxjava3/core/Scheduler$Worker;", "shutdown", "", "toString", "", "DispatcherWorker", "kotlinx-coroutines-rx3"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class DispatcherScheduler extends Scheduler {
    private static final /* synthetic */ AtomicLongFieldUpdater workerCounter$volatile$FU = AtomicLongFieldUpdater.newUpdater(DispatcherScheduler.class, "workerCounter$volatile");
    public final CoroutineDispatcher dispatcher;
    private final CompletableJob schedulerJob;
    private final CoroutineScope scope;
    private volatile /* synthetic */ long workerCounter$volatile;

    private final /* synthetic */ long getWorkerCounter$volatile() {
        return this.workerCounter$volatile;
    }

    private final /* synthetic */ void setWorkerCounter$volatile(long j) {
        this.workerCounter$volatile = j;
    }

    public DispatcherScheduler(CoroutineDispatcher coroutineDispatcher) {
        this.dispatcher = coroutineDispatcher;
        CompletableJob completableJobSupervisorJob$default = SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null);
        this.schedulerJob = completableJobSupervisorJob$default;
        this.scope = CoroutineScopeKt.CoroutineScope(completableJobSupervisorJob$default.plus(coroutineDispatcher));
        this.workerCounter$volatile = 1L;
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    public Disposable scheduleDirect(Runnable block, long delay, TimeUnit unit) {
        return RxSchedulerKt.scheduleTask(this.scope, block, unit.toMillis(delay), new Function1() { // from class: kotlinx.coroutines.rx3.DispatcherScheduler$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DispatcherScheduler.scheduleDirect$lambda$1(this.f$0, (Function1) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Runnable scheduleDirect$lambda$1(final DispatcherScheduler dispatcherScheduler, final Function1 function1) {
        return new Runnable() { // from class: kotlinx.coroutines.rx3.DispatcherScheduler$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                DispatcherScheduler.scheduleDirect$lambda$1$lambda$0(this.f$0, function1);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void scheduleDirect$lambda$1$lambda$0(DispatcherScheduler dispatcherScheduler, Function1 function1) {
        BuildersKt__Builders_commonKt.launch$default(dispatcherScheduler.scope, null, null, new DispatcherScheduler$scheduleDirect$1$1$1(function1, null), 3, null);
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    public Scheduler.Worker createWorker() {
        return new DispatcherWorker(workerCounter$volatile$FU.getAndIncrement(this), this.dispatcher, this.schedulerJob);
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    public void shutdown() {
        Job.DefaultImpls.cancel$default((Job) this.schedulerJob, (CancellationException) null, 1, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: RxScheduler.kt */
    @Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ$\u0010\u0014\u001a\u00020\u00152\n\u0010\u0016\u001a\u00060\u0017j\u0002`\u00182\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u0012H\u0016J\b\u0010\u001f\u001a\u00020 H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u000e\u001a\u001e\u0012\u001a\u0012\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lkotlinx/coroutines/rx3/DispatcherScheduler$DispatcherWorker;", "Lio/reactivex/rxjava3/core/Scheduler$Worker;", "counter", "", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "parentJob", "Lkotlinx/coroutines/Job;", "<init>", "(JLkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/Job;)V", "workerJob", "Lkotlinx/coroutines/CompletableJob;", "workerScope", "Lkotlinx/coroutines/CoroutineScope;", "blockChannel", "Lkotlinx/coroutines/channels/Channel;", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "", "schedule", "Lio/reactivex/rxjava3/disposables/Disposable;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", SemanticAttributes.MessagingRocketmqMessageTypeValues.DELAY, "unit", "Ljava/util/concurrent/TimeUnit;", "isDisposed", "", "dispose", "toString", "", "kotlinx-coroutines-rx3"}, k = 1, mv = {2, 1, 0}, xi = 48)
    static final class DispatcherWorker extends Scheduler.Worker {
        private final Channel<Function1<Continuation<? super Unit>, Object>> blockChannel;
        private final long counter;
        private final CoroutineDispatcher dispatcher;
        private final CompletableJob workerJob;
        private final CoroutineScope workerScope;

        public DispatcherWorker(long j, CoroutineDispatcher coroutineDispatcher, Job job) {
            this.counter = j;
            this.dispatcher = coroutineDispatcher;
            CompletableJob completableJobSupervisorJob = SupervisorKt.SupervisorJob(job);
            this.workerJob = completableJobSupervisorJob;
            CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(completableJobSupervisorJob.plus(coroutineDispatcher));
            this.workerScope = CoroutineScope;
            this.blockChannel = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
            BuildersKt__Builders_commonKt.launch$default(CoroutineScope, null, null, new AnonymousClass1(null), 3, null);
        }

        /* JADX INFO: renamed from: kotlinx.coroutines.rx3.DispatcherScheduler$DispatcherWorker$1, reason: invalid class name */
        /* JADX INFO: compiled from: RxScheduler.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "kotlinx.coroutines.rx3.DispatcherScheduler$DispatcherWorker$1", f = "RxScheduler.kt", i = {0, 1}, l = {183, 78}, m = "invokeSuspend", n = {"$this$consume$iv$iv", "$this$consume$iv$iv"}, s = {"L$0", "L$0"})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            Object L$0;
            Object L$1;
            int label;

            AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return DispatcherWorker.this.new AnonymousClass1(continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Code duplicated, block: B:18:0x004c  */
            /* JADX WARN: Code duplicated, block: B:19:0x004d  */
            /* JADX WARN: Code duplicated, block: B:22:0x0058 A[Catch: all -> 0x0073, TryCatch #0 {all -> 0x0073, blocks: (B:7:0x0017, B:16:0x0040, B:20:0x0050, B:22:0x0058, B:25:0x006b, B:12:0x002c, B:15:0x003c), top: B:33:0x0009 }] */
            /* JADX WARN: Code duplicated, block: B:25:0x006b A[Catch: all -> 0x0073, TRY_LEAVE, TryCatch #0 {all -> 0x0073, blocks: (B:7:0x0017, B:16:0x0040, B:20:0x0050, B:22:0x0058, B:25:0x006b, B:12:0x002c, B:15:0x003c), top: B:33:0x0009 }] */
            /* JADX WARN: Code restructure failed: missing block: B:23:0x0068, code lost:
            
                if (r8.invoke(r7) == r0) goto L24;
             */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0068 -> B:8:0x001a). Please report as a decompilation issue!!! */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r8) {
                /*
                    r7 = this;
                    java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r1 = r7.label
                    r2 = 2
                    r3 = 1
                    r4 = 0
                    if (r1 == 0) goto L30
                    if (r1 == r3) goto L24
                    if (r1 != r2) goto L1c
                    java.lang.Object r1 = r7.L$1
                    kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
                    java.lang.Object r5 = r7.L$0
                    kotlinx.coroutines.channels.ReceiveChannel r5 = (kotlinx.coroutines.channels.ReceiveChannel) r5
                    kotlin.ResultKt.throwOnFailure(r8)     // Catch: java.lang.Throwable -> L73
                L1a:
                    r8 = r1
                    goto L40
                L1c:
                    java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                    java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                    r7.<init>(r8)
                    throw r7
                L24:
                    java.lang.Object r1 = r7.L$1
                    kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
                    java.lang.Object r5 = r7.L$0
                    kotlinx.coroutines.channels.ReceiveChannel r5 = (kotlinx.coroutines.channels.ReceiveChannel) r5
                    kotlin.ResultKt.throwOnFailure(r8)     // Catch: java.lang.Throwable -> L73
                    goto L50
                L30:
                    kotlin.ResultKt.throwOnFailure(r8)
                    kotlinx.coroutines.rx3.DispatcherScheduler$DispatcherWorker r8 = kotlinx.coroutines.rx3.DispatcherScheduler.DispatcherWorker.this
                    kotlinx.coroutines.channels.Channel r8 = kotlinx.coroutines.rx3.DispatcherScheduler.DispatcherWorker.access$getBlockChannel$p(r8)
                    r5 = r8
                    kotlinx.coroutines.channels.ReceiveChannel r5 = (kotlinx.coroutines.channels.ReceiveChannel) r5
                    kotlinx.coroutines.channels.ChannelIterator r8 = r5.iterator()     // Catch: java.lang.Throwable -> L73
                L40:
                    r7.L$0 = r5     // Catch: java.lang.Throwable -> L73
                    r7.L$1 = r8     // Catch: java.lang.Throwable -> L73
                    r7.label = r3     // Catch: java.lang.Throwable -> L73
                    java.lang.Object r1 = r8.hasNext(r7)     // Catch: java.lang.Throwable -> L73
                    if (r1 != r0) goto L4d
                    goto L6a
                L4d:
                    r6 = r1
                    r1 = r8
                    r8 = r6
                L50:
                    java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch: java.lang.Throwable -> L73
                    boolean r8 = r8.booleanValue()     // Catch: java.lang.Throwable -> L73
                    if (r8 == 0) goto L6b
                    java.lang.Object r8 = r1.next()     // Catch: java.lang.Throwable -> L73
                    kotlin.jvm.functions.Function1 r8 = (kotlin.jvm.functions.Function1) r8     // Catch: java.lang.Throwable -> L73
                    r7.L$0 = r5     // Catch: java.lang.Throwable -> L73
                    r7.L$1 = r1     // Catch: java.lang.Throwable -> L73
                    r7.label = r2     // Catch: java.lang.Throwable -> L73
                    java.lang.Object r8 = r8.invoke(r7)     // Catch: java.lang.Throwable -> L73
                    if (r8 != r0) goto L1a
                L6a:
                    return r0
                L6b:
                    kotlin.Unit r7 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L73
                    kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r5, r4)
                    kotlin.Unit r7 = kotlin.Unit.INSTANCE
                    return r7
                L73:
                    r7 = move-exception
                    throw r7     // Catch: java.lang.Throwable -> L75
                L75:
                    r8 = move-exception
                    kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r5, r7)
                    throw r8
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.rx3.DispatcherScheduler.DispatcherWorker.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        @Override // io.reactivex.rxjava3.core.Scheduler.Worker
        public Disposable schedule(Runnable block, long delay, TimeUnit unit) {
            return RxSchedulerKt.scheduleTask(this.workerScope, block, unit.toMillis(delay), new Function1() { // from class: kotlinx.coroutines.rx3.DispatcherScheduler$DispatcherWorker$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return DispatcherScheduler.DispatcherWorker.schedule$lambda$1(this.f$0, (Function1) obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Runnable schedule$lambda$1(final DispatcherWorker dispatcherWorker, final Function1 function1) {
            return new Runnable() { // from class: kotlinx.coroutines.rx3.DispatcherScheduler$DispatcherWorker$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    DispatcherScheduler.DispatcherWorker.schedule$lambda$1$lambda$0(this.f$0, function1);
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void schedule$lambda$1$lambda$0(DispatcherWorker dispatcherWorker, Function1 function1) {
            dispatcherWorker.blockChannel.mo11206trySendJP2dKIU(function1);
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return !CoroutineScopeKt.isActive(this.workerScope);
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            SendChannel.DefaultImpls.close$default(this.blockChannel, null, 1, null);
            Job.DefaultImpls.cancel$default((Job) this.workerJob, (CancellationException) null, 1, (Object) null);
        }

        public String toString() {
            return this.dispatcher + " (worker " + this.counter + ", " + (isDisposed() ? "disposed" : "active") + ')';
        }
    }

    public String toString() {
        return this.dispatcher.getName();
    }
}
