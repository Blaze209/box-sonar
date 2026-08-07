package kotlinx.coroutines.rx3;

import androidx.exifinterface.media.ExifInterface;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.exceptions.UndeliverableException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.selects.SelectClause2;
import kotlinx.coroutines.selects.SelectClause2Impl;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.apache.hc.core5.http.HeaderElements;

/* JADX INFO: compiled from: RxObservable.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u00032\b\u0012\u0004\u0012\u0002H\u00010\u0005B\u001d\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\t¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\u0015\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u001e\u0010\u0018\u001a\u00020\u00192\u0014\u0010\u001a\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0012\u0004\u0012\u00020\u00040\u001bH\u0016J\u001e\u0010$\u001a\u00020\u00042\n\u0010%\u001a\u0006\u0012\u0002\b\u00030&2\b\u0010'\u001a\u0004\u0018\u00010\u0002H\u0002J\u001e\u0010(\u001a\u0004\u0018\u00010\u00022\b\u0010'\u001a\u0004\u0018\u00010\u00022\b\u0010)\u001a\u0004\u0018\u00010\u0002H\u0002J\u001d\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00040+2\u0006\u0010'\u001a\u00028\u0000H\u0016¢\u0006\u0004\b,\u0010-J\u0016\u0010.\u001a\u00020\u00042\u0006\u0010'\u001a\u00028\u0000H\u0096@¢\u0006\u0002\u0010/J\u0017\u00100\u001a\u0004\u0018\u00010\u00172\u0006\u00101\u001a\u00028\u0000H\u0002¢\u0006\u0002\u00102J\b\u00103\u001a\u00020\u0004H\u0002J\u001a\u00104\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u00105\u001a\u00020\u0013H\u0002J\u001a\u00106\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u00105\u001a\u00020\u0013H\u0002J\u0015\u00107\u001a\u00020\u00042\u0006\u00108\u001a\u00020\u0004H\u0014¢\u0006\u0002\u00109J\u0018\u0010:\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u00105\u001a\u00020\u0013H\u0014R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\t\u0010\u0010\u001a\u00020\u0011X\u0082\u0004R\u0014\u0010\u0012\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0014R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R,\u0010\u001e\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\r0\u001f8VX\u0096\u0004¢\u0006\f\u0012\u0004\b \u0010!\u001a\u0004\b\"\u0010#¨\u0006;"}, d2 = {"Lkotlinx/coroutines/rx3/RxObservableCoroutine;", ExifInterface.GPS_DIRECTION_TRUE, "", "Lkotlinx/coroutines/AbstractCoroutine;", "", "Lkotlinx/coroutines/channels/ProducerScope;", "parentContext", "Lkotlin/coroutines/CoroutineContext;", "subscriber", "Lio/reactivex/rxjava3/core/ObservableEmitter;", "<init>", "(Lkotlin/coroutines/CoroutineContext;Lio/reactivex/rxjava3/core/ObservableEmitter;)V", "channel", "Lkotlinx/coroutines/channels/SendChannel;", "getChannel", "()Lkotlinx/coroutines/channels/SendChannel;", "_signal", "Lkotlinx/atomicfu/AtomicInt;", "isClosedForSend", "", "()Z", HeaderElements.CLOSE, "cause", "", "invokeOnClose", "", "handler", "Lkotlin/Function1;", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "onSend", "Lkotlinx/coroutines/selects/SelectClause2;", "getOnSend$annotations", "()V", "getOnSend", "()Lkotlinx/coroutines/selects/SelectClause2;", "registerSelectForSend", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "element", "processResultSelectSend", "selectResult", "trySend", "Lkotlinx/coroutines/channels/ChannelResult;", "trySend-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "send", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "doLockedNext", "elem", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "unlockAndCheckCompleted", "doLockedSignalCompleted", "handled", "signalCompleted", "onCompleted", "value", "(Lkotlin/Unit;)V", "onCancelled", "kotlinx-coroutines-rx3"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class RxObservableCoroutine<T> extends AbstractCoroutine<Unit> implements ProducerScope<T> {
    private static final /* synthetic */ AtomicIntegerFieldUpdater _signal$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(RxObservableCoroutine.class, "_signal$volatile");
    private volatile /* synthetic */ int _signal$volatile;
    private final Mutex mutex;
    private final ObservableEmitter<T> subscriber;

    /* JADX INFO: renamed from: kotlinx.coroutines.rx3.RxObservableCoroutine$send$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RxObservable.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.rx3.RxObservableCoroutine", f = "RxObservable.kt", i = {0, 0}, l = {113}, m = "send", n = {"this", "element"}, s = {"L$0", "L$1"})
    static final class C20241 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ RxObservableCoroutine<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C20241(RxObservableCoroutine<T> rxObservableCoroutine, Continuation<? super C20241> continuation) {
            super(continuation);
            this.this$0 = rxObservableCoroutine;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.send(null, this);
        }
    }

    public static /* synthetic */ void getOnSend$annotations() {
    }

    private final /* synthetic */ int get_signal$volatile() {
        return this._signal$volatile;
    }

    private final /* synthetic */ void set_signal$volatile(int i) {
        this._signal$volatile = i;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    /* JADX INFO: renamed from: invokeOnClose */
    public /* bridge */ /* synthetic */ void mo16402invokeOnClose(Function1 function1) {
        invokeOnClose((Function1<? super Throwable, Unit>) function1);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'trySend' method", replaceWith = @ReplaceWith(expression = "trySend(element).isSuccess", imports = {}))
    public boolean offer(T t) {
        return ProducerScope.DefaultImpls.offer(this, t);
    }

    public RxObservableCoroutine(CoroutineContext coroutineContext, ObservableEmitter<T> observableEmitter) {
        super(coroutineContext, false, true);
        this.subscriber = observableEmitter;
        this.mutex = MutexKt.Mutex$default(false, 1, null);
    }

    @Override // kotlinx.coroutines.channels.ProducerScope
    public SendChannel<T> getChannel() {
        return this;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean isClosedForSend() {
        return !isActive();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean close(Throwable cause) {
        return cancelCoroutine(cause);
    }

    public Void invokeOnClose(Function1<? super Throwable, Unit> handler) {
        throw new UnsupportedOperationException("RxObservableCoroutine doesn't support invokeOnClose");
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public SelectClause2<T, SendChannel<T>> getOnSend() {
        RxObservableCoroutine$onSend$1 rxObservableCoroutine$onSend$1 = RxObservableCoroutine$onSend$1.INSTANCE;
        Intrinsics.checkNotNull(rxObservableCoroutine$onSend$1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"select\")] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = \"param\")] kotlin.Any?, kotlin.Unit>");
        Function3 function3 = (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(rxObservableCoroutine$onSend$1, 3);
        RxObservableCoroutine$onSend$2 rxObservableCoroutine$onSend$2 = RxObservableCoroutine$onSend$2.INSTANCE;
        Intrinsics.checkNotNull(rxObservableCoroutine$onSend$2, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"param\")] kotlin.Any?, @[ParameterName(name = \"clauseResult\")] kotlin.Any?, kotlin.Any?>");
        return new SelectClause2Impl(this, function3, (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(rxObservableCoroutine$onSend$2, 3), null, 8, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void registerSelectForSend(SelectInstance<?> select, Object element) {
        if (!Mutex.DefaultImpls.tryLock$default(this.mutex, null, 1, null)) {
            BuildersKt__Builders_commonKt.launch$default(this, null, null, new AnonymousClass1(this, select, null), 3, null);
        } else {
            select.selectInRegistrationPhase(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.rx3.RxObservableCoroutine$registerSelectForSend$1, reason: invalid class name */
    /* JADX INFO: compiled from: RxObservable.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.rx3.RxObservableCoroutine$registerSelectForSend$1", f = "RxObservable.kt", i = {}, l = {89}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ SelectInstance<?> $select;
        int label;
        final /* synthetic */ RxObservableCoroutine<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(RxObservableCoroutine<T> rxObservableCoroutine, SelectInstance<?> selectInstance, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = rxObservableCoroutine;
            this.$select = selectInstance;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$select, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (Mutex.DefaultImpls.lock$default(((RxObservableCoroutine) this.this$0).mutex, null, this, 1, null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            if (!this.$select.trySelect(this.this$0, Unit.INSTANCE)) {
                Mutex.DefaultImpls.unlock$default(((RxObservableCoroutine) this.this$0).mutex, null, 1, null);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final Object processResultSelectSend(Object element, Object selectResult) throws Throwable {
        Intrinsics.checkNotNull(element, "null cannot be cast to non-null type T of kotlinx.coroutines.rx3.RxObservableCoroutine");
        Throwable thDoLockedNext = doLockedNext(element);
        if (thDoLockedNext == null) {
            return this;
        }
        throw thDoLockedNext;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    /* JADX INFO: renamed from: trySend-JP2dKIU */
    public Object mo11206trySendJP2dKIU(T element) {
        if (!Mutex.DefaultImpls.tryLock$default(this.mutex, null, 1, null)) {
            return ChannelResult.INSTANCE.m16348failurePtdJZtk();
        }
        Throwable thDoLockedNext = doLockedNext(element);
        if (thDoLockedNext == null) {
            return ChannelResult.INSTANCE.m16349successJP2dKIU(Unit.INSTANCE);
        }
        return ChannelResult.INSTANCE.m16347closedJP2dKIU(thDoLockedNext);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // kotlinx.coroutines.channels.SendChannel
    public Object send(T t, Continuation<? super Unit> continuation) throws Throwable {
        C20241 c20241;
        if (continuation instanceof C20241) {
            c20241 = (C20241) continuation;
            if ((c20241.label & Integer.MIN_VALUE) != 0) {
                c20241.label -= Integer.MIN_VALUE;
            } else {
                c20241 = new C20241(this, continuation);
            }
        } else {
            c20241 = new C20241(this, continuation);
        }
        Object obj = c20241.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c20241.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Mutex mutex = this.mutex;
            c20241.L$0 = this;
            c20241.L$1 = t;
            c20241.label = 1;
            if (Mutex.DefaultImpls.lock$default(mutex, null, c20241, 1, null) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            t = (T) c20241.L$1;
            this = (RxObservableCoroutine) c20241.L$0;
            ResultKt.throwOnFailure(obj);
        }
        Throwable thDoLockedNext = this.doLockedNext(t);
        if (thDoLockedNext != null) {
            throw thDoLockedNext;
        }
        return Unit.INSTANCE;
    }

    private final Throwable doLockedNext(T elem) {
        if (!isActive()) {
            doLockedSignalCompleted(getCompletionCause(), getCompletionCauseHandled());
            return getCancellationException();
        }
        try {
            this.subscriber.onNext(elem);
            unlockAndCheckCompleted();
            return null;
        } catch (Throwable th) {
            UndeliverableException undeliverableException = new UndeliverableException(th);
            boolean zClose = close(undeliverableException);
            unlockAndCheckCompleted();
            if (zClose) {
                return undeliverableException;
            }
            RxCancellableKt.handleUndeliverableException(undeliverableException, getContext());
            return getCancellationException();
        }
    }

    private final void unlockAndCheckCompleted() {
        Mutex.DefaultImpls.unlock$default(this.mutex, null, 1, null);
        if (isActive() || !Mutex.DefaultImpls.tryLock$default(this.mutex, null, 1, null)) {
            return;
        }
        doLockedSignalCompleted(getCompletionCause(), getCompletionCauseHandled());
    }

    private final void doLockedSignalCompleted(Throwable cause, boolean handled) {
        Throwable thUnwrapImpl;
        try {
            if (_signal$volatile$FU.get(this) != -2) {
                _signal$volatile$FU.set(this, -2);
                if (cause != null) {
                    thUnwrapImpl = !DebugKt.getRECOVER_STACK_TRACES() ? cause : StackTraceRecoveryKt.unwrapImpl(cause);
                } else {
                    thUnwrapImpl = null;
                }
                if (thUnwrapImpl == null) {
                    try {
                        this.subscriber.onComplete();
                    } catch (Exception e) {
                        RxCancellableKt.handleUndeliverableException(e, getContext());
                    }
                } else if ((thUnwrapImpl instanceof UndeliverableException) && !handled) {
                    RxCancellableKt.handleUndeliverableException(cause, getContext());
                } else if (thUnwrapImpl != getCancellationException() || !this.subscriber.isDisposed()) {
                    try {
                        this.subscriber.onError(cause);
                    } catch (Exception e2) {
                        ExceptionsKt.addSuppressed(cause, e2);
                        RxCancellableKt.handleUndeliverableException(cause, getContext());
                    }
                }
            }
            Mutex.DefaultImpls.unlock$default(this.mutex, null, 1, null);
        } catch (Throwable th) {
            Mutex.DefaultImpls.unlock$default(this.mutex, null, 1, null);
            throw th;
        }
    }

    private final void signalCompleted(Throwable cause, boolean handled) {
        if (_signal$volatile$FU.compareAndSet(this, 0, -1) && Mutex.DefaultImpls.tryLock$default(this.mutex, null, 1, null)) {
            doLockedSignalCompleted(cause, handled);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.AbstractCoroutine
    public void onCompleted(Unit value) {
        signalCompleted(null, false);
    }

    @Override // kotlinx.coroutines.AbstractCoroutine
    protected void onCancelled(Throwable cause, boolean handled) {
        signalCompleted(cause, handled);
    }
}
