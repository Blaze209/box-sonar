package kotlinx.coroutines.reactive;

import androidx.exifinterface.media.ExifInterface;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.intrinsics.CancellableKt;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: ReactiveFlow.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0000\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003B-\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u000e\u0010\u0007\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u0011H\u0002J\u000e\u0010\u0015\u001a\u00020\u0004H\u0082@¢\u0006\u0002\u0010\u0016J\u000e\u0010\u0017\u001a\u00020\u0004H\u0082@¢\u0006\u0002\u0010\u0016J\b\u0010\u0018\u001a\u00020\u0004H\u0017J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u001bH\u0016R\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0007\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\t\u0010\r\u001a\u00020\u000eX\u0082\u0004R\u0017\u0010\u000f\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00110\u0010X\u0082\u0004R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lkotlinx/coroutines/reactive/FlowSubscription;", ExifInterface.GPS_DIRECTION_TRUE, "Lorg/reactivestreams/Subscription;", "Lkotlinx/coroutines/AbstractCoroutine;", "", "flow", "Lkotlinx/coroutines/flow/Flow;", "subscriber", "Lorg/reactivestreams/Subscriber;", "context", "Lkotlin/coroutines/CoroutineContext;", "<init>", "(Lkotlinx/coroutines/flow/Flow;Lorg/reactivestreams/Subscriber;Lkotlin/coroutines/CoroutineContext;)V", "requested", "Lkotlinx/atomicfu/AtomicLong;", "producer", "Lkotlinx/atomicfu/AtomicRef;", "Lkotlin/coroutines/Continuation;", "cancellationRequested", "", "createInitialContinuation", "flowProcessing", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "consumeFlow", "cancel", "request", "n", "", "kotlinx-coroutines-reactive"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowSubscription<T> extends AbstractCoroutine<Unit> implements Subscription {
    private volatile boolean cancellationRequested;
    public final Flow<T> flow;
    private volatile /* synthetic */ Object producer$volatile;
    private volatile /* synthetic */ long requested$volatile;
    public final Subscriber<? super T> subscriber;
    private static final /* synthetic */ AtomicLongFieldUpdater requested$volatile$FU = AtomicLongFieldUpdater.newUpdater(FlowSubscription.class, "requested$volatile");
    private static final /* synthetic */ AtomicReferenceFieldUpdater producer$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(FlowSubscription.class, Object.class, "producer$volatile");

    /* JADX INFO: renamed from: kotlinx.coroutines.reactive.FlowSubscription$flowProcessing$1, reason: invalid class name */
    /* JADX INFO: compiled from: ReactiveFlow.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.reactive.FlowSubscription", f = "ReactiveFlow.kt", i = {0}, l = {205}, m = "flowProcessing", n = {"this"}, s = {"L$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ FlowSubscription<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(FlowSubscription<T> flowSubscription, Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
            this.this$0 = flowSubscription;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.flowProcessing(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final /* synthetic */ long getAndUpdate$atomicfu$ATOMIC_FIELD_UPDATER$Long(AtomicLongFieldUpdater atomicLongFieldUpdater, Object obj, Function1<? super Long, Long> function1) {
        AtomicLongFieldUpdater atomicLongFieldUpdater2 = atomicLongFieldUpdater;
        while (true) {
            long j = atomicLongFieldUpdater2.get(obj);
            AtomicLongFieldUpdater atomicLongFieldUpdater3 = atomicLongFieldUpdater2;
            Object obj2 = obj;
            if (atomicLongFieldUpdater3.compareAndSet(obj2, j, function1.invoke(Long.valueOf(j)).longValue())) {
                return j;
            }
            atomicLongFieldUpdater2 = atomicLongFieldUpdater3;
            obj = obj2;
        }
    }

    private final /* synthetic */ Object getProducer$volatile() {
        return this.producer$volatile;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ AtomicReferenceFieldUpdater getProducer$volatile$FU() {
        return producer$volatile$FU;
    }

    private final /* synthetic */ long getRequested$volatile() {
        return this.requested$volatile;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ AtomicLongFieldUpdater getRequested$volatile$FU() {
        return requested$volatile$FU;
    }

    private final /* synthetic */ void setProducer$volatile(Object obj) {
        this.producer$volatile = obj;
    }

    private final /* synthetic */ void setRequested$volatile(long j) {
        this.requested$volatile = j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FlowSubscription(Flow<? extends T> flow, Subscriber<? super T> subscriber, CoroutineContext coroutineContext) {
        super(coroutineContext, false, true);
        this.flow = flow;
        this.subscriber = subscriber;
        this.producer$volatile = createInitialContinuation();
    }

    private final Continuation<Unit> createInitialContinuation() {
        final CoroutineContext coroutineContext = getCoroutineContext();
        return new Continuation<Unit>() { // from class: kotlinx.coroutines.reactive.FlowSubscription$createInitialContinuation$$inlined$Continuation$1
            @Override // kotlin.coroutines.Continuation
            /* JADX INFO: renamed from: getContext, reason: from getter */
            public CoroutineContext get$context() {
                return coroutineContext;
            }

            @Override // kotlin.coroutines.Continuation
            public void resumeWith(Object result) throws Throwable {
                CancellableKt.startCoroutineCancellable(new FlowSubscription$createInitialContinuation$1$1(this), this);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object flowProcessing(Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(this, continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(this, continuation);
        }
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                anonymousClass1.L$0 = this;
                anonymousClass1.label = 1;
                if (consumeFlow(anonymousClass1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                this = (FlowSubscription) anonymousClass1.L$0;
                ResultKt.throwOnFailure(obj);
            }
            try {
                this.subscriber.onComplete();
            } catch (Throwable th) {
                CoroutineExceptionHandlerKt.handleCoroutineException(this.getCoroutineContext(), th);
            }
            return Unit.INSTANCE;
        } catch (Throwable th2) {
            Throwable thUnwrapImpl = !DebugKt.getRECOVER_STACK_TRACES() ? th2 : StackTraceRecoveryKt.unwrapImpl(th2);
            if (!this.cancellationRequested || this.isActive() || thUnwrapImpl != this.getCancellationException()) {
                try {
                    this.subscriber.onError(th2);
                } catch (Throwable th3) {
                    ExceptionsKt.addSuppressed(th2, th3);
                    CoroutineExceptionHandlerKt.handleCoroutineException(this.getCoroutineContext(), th2);
                }
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object consumeFlow(Continuation<? super Unit> continuation) {
        Object objCollect = this.flow.collect(new FlowCollector(this) { // from class: kotlinx.coroutines.reactive.FlowSubscription.consumeFlow.2
            final /* synthetic */ FlowSubscription<T> this$0;

            {
                this.this$0 = this;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public final Object emit(T t, Continuation<? super Unit> continuation2) {
                this.this$0.subscriber.onNext(t);
                if (FlowSubscription.getRequested$volatile$FU().decrementAndGet(this.this$0) <= 0) {
                    FlowSubscription<T> flowSubscription = this.this$0;
                    CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation2), 1);
                    cancellableContinuationImpl.initCancellability();
                    FlowSubscription.getProducer$volatile$FU().set(flowSubscription, cancellableContinuationImpl);
                    Object result = cancellableContinuationImpl.getResult();
                    if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        DebugProbesKt.probeCoroutineSuspended(continuation2);
                    }
                    return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
                }
                JobKt.ensureActive(this.this$0.getCoroutineContext());
                return Unit.INSTANCE;
            }
        }, continuation);
        return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.JobSupport, kotlinx.coroutines.Job
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public /* synthetic */ void cancel() {
        this.cancellationRequested = true;
        cancel((CancellationException) null);
    }

    @Override // org.reactivestreams.Subscription
    public void request(long n) {
        long j;
        FlowSubscription<T> flowSubscription;
        Continuation continuation;
        if (n <= 0) {
            return;
        }
        AtomicLongFieldUpdater atomicLongFieldUpdater = requested$volatile$FU;
        while (true) {
            j = atomicLongFieldUpdater.get(this);
            long j2 = j + n;
            if (j2 <= 0) {
                j2 = Long.MAX_VALUE;
            }
            flowSubscription = this;
            if (atomicLongFieldUpdater.compareAndSet(flowSubscription, j, j2)) {
                break;
            } else {
                this = flowSubscription;
            }
        }
        if (j <= 0) {
            do {
                continuation = (Continuation) producer$volatile$FU.getAndSet(flowSubscription, null);
            } while (continuation == null);
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m14780constructorimpl(Unit.INSTANCE));
        }
    }
}
