package kotlinx.coroutines.rx3;

import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.Disposable;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.reactive.ReactiveFlowKt;

/* JADX INFO: compiled from: RxConvert.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a+\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\b\u0002H\u00070\u0006\"\u0004\b\u0000\u0010\u0007*\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00070\b2\u0006\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000\u001a(\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\n\"\b\b\u0000\u0010\u0007*\u00020\u000b*\b\u0012\u0004\u0012\u0002H\u00070\b2\u0006\u0010\u0003\u001a\u00020\u0004\u001a \u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00070\r\"\b\b\u0000\u0010\u0007*\u00020\u000b*\b\u0012\u0004\u0012\u0002H\u00070\u000e\u001a*\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0010\"\b\b\u0000\u0010\u0007*\u00020\u000b*\b\u0012\u0004\u0012\u0002H\u00070\r2\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u001a*\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0012\"\b\b\u0000\u0010\u0007*\u00020\u000b*\b\u0012\u0004\u0012\u0002H\u00070\r2\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u001a1\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0012\"\b\b\u0000\u0010\u0007*\u00020\u000b*\b\u0012\u0004\u0012\u0002H\u00070\r2\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\b\u0014\u001a1\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0010\"\b\b\u0000\u0010\u0007*\u00020\u000b*\b\u0012\u0004\u0012\u0002H\u00070\r2\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\b\u0014\u0082\u0002\u0004\n\u0002\b9¨\u0006\u0016"}, d2 = {"asCompletable", "Lio/reactivex/rxjava3/core/Completable;", "Lkotlinx/coroutines/Job;", "context", "Lkotlin/coroutines/CoroutineContext;", "asMaybe", "Lio/reactivex/rxjava3/core/Maybe;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/Deferred;", "asSingle", "Lio/reactivex/rxjava3/core/Single;", "", "asFlow", "Lkotlinx/coroutines/flow/Flow;", "Lio/reactivex/rxjava3/core/ObservableSource;", "asObservable", "Lio/reactivex/rxjava3/core/Observable;", "asFlowable", "Lio/reactivex/rxjava3/core/Flowable;", "_asFlowable", TypedValues.TransitionType.S_FROM, "_asObservable", "kotlinx-coroutines-rx3"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class RxConvertKt {

    /* JADX INFO: renamed from: kotlinx.coroutines.rx3.RxConvertKt$asCompletable$1, reason: invalid class name */
    /* JADX INFO: compiled from: RxConvert.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.rx3.RxConvertKt$asCompletable$1", f = "RxConvert.kt", i = {}, l = {26}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Job $this_asCompletable;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Job job, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$this_asCompletable = job;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$this_asCompletable, continuation);
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
                if (this.$this_asCompletable.join(this) == coroutine_suspended) {
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

    public static final Completable asCompletable(Job job, CoroutineContext coroutineContext) {
        return RxCompletableKt.rxCompletable(coroutineContext, new AnonymousClass1(job, null));
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: kotlinx.coroutines.rx3.RxConvertKt$asMaybe$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RxConvert.kt */
    @Metadata(d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.rx3.RxConvertKt$asMaybe$1", f = "RxConvert.kt", i = {}, l = {42}, m = "invokeSuspend", n = {}, s = {})
    static final class C20221<T> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super T>, Object> {
        final /* synthetic */ Deferred<T> $this_asMaybe;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C20221(Deferred<? extends T> deferred, Continuation<? super C20221> continuation) {
            super(2, continuation);
            this.$this_asMaybe = deferred;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C20221(this.$this_asMaybe, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super T> continuation) {
            return ((C20221) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            Object objAwait = this.$this_asMaybe.await(this);
            return objAwait == coroutine_suspended ? coroutine_suspended : objAwait;
        }
    }

    public static final <T> Maybe<T> asMaybe(Deferred<? extends T> deferred, CoroutineContext coroutineContext) {
        return RxMaybeKt.rxMaybe(coroutineContext, new C20221(deferred, null));
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: kotlinx.coroutines.rx3.RxConvertKt$asSingle$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RxConvert.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002*\u00020\u0003H\n"}, d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.rx3.RxConvertKt$asSingle$1", f = "RxConvert.kt", i = {}, l = {58}, m = "invokeSuspend", n = {}, s = {})
    static final class C20231<T> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super T>, Object> {
        final /* synthetic */ Deferred<T> $this_asSingle;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C20231(Deferred<? extends T> deferred, Continuation<? super C20231> continuation) {
            super(2, continuation);
            this.$this_asSingle = deferred;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C20231(this.$this_asSingle, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super T> continuation) {
            return ((C20231) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            Object objAwait = this.$this_asSingle.await(this);
            return objAwait == coroutine_suspended ? coroutine_suspended : objAwait;
        }
    }

    public static final <T> Single<T> asSingle(Deferred<? extends T> deferred, CoroutineContext coroutineContext) {
        return RxSingleKt.rxSingle(coroutineContext, new C20231(deferred, null));
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: kotlinx.coroutines.rx3.RxConvertKt$asFlow$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RxConvert.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u0004H\n"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "", "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.rx3.RxConvertKt$asFlow$1", f = "RxConvert.kt", i = {}, l = {91}, m = "invokeSuspend", n = {}, s = {})
    static final class C20211<T> extends SuspendLambda implements Function2<ProducerScope<? super T>, Continuation<? super Unit>, Object> {
        final /* synthetic */ ObservableSource<T> $this_asFlow;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C20211(ObservableSource<T> observableSource, Continuation<? super C20211> continuation) {
            super(2, continuation);
            this.$this_asFlow = observableSource;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C20211 c20211 = new C20211(this.$this_asFlow, continuation);
            c20211.L$0 = obj;
            return c20211;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ProducerScope<? super T> producerScope, Continuation<? super Unit> continuation) {
            return ((C20211) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final ProducerScope producerScope = (ProducerScope) this.L$0;
                final AtomicReference atomicReference = new AtomicReference();
                this.$this_asFlow.subscribe(new Observer<T>() { // from class: kotlinx.coroutines.rx3.RxConvertKt$asFlow$1$observer$1
                    @Override // io.reactivex.rxjava3.core.Observer
                    public void onComplete() {
                        SendChannel.DefaultImpls.close$default(producerScope, null, 1, null);
                    }

                    @Override // io.reactivex.rxjava3.core.Observer
                    public void onSubscribe(Disposable d) {
                        if (PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(atomicReference, null, d)) {
                            return;
                        }
                        d.dispose();
                    }

                    @Override // io.reactivex.rxjava3.core.Observer
                    public void onNext(T t) {
                        try {
                            ChannelsKt.trySendBlocking(producerScope, t);
                        } catch (InterruptedException unused) {
                        }
                    }

                    @Override // io.reactivex.rxjava3.core.Observer
                    public void onError(Throwable e) {
                        producerScope.close(e);
                    }
                });
                this.label = 1;
                if (ProduceKt.awaitClose(producerScope, new Function0() { // from class: kotlinx.coroutines.rx3.RxConvertKt$asFlow$1$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return RxConvertKt.C20211.invokeSuspend$lambda$0(atomicReference);
                    }
                }, this) == coroutine_suspended) {
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

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$0(AtomicReference atomicReference) {
            Disposable disposable = (Disposable) atomicReference.getAndSet(Disposable.disposed());
            if (disposable != null) {
                disposable.dispose();
            }
            return Unit.INSTANCE;
        }
    }

    public static final <T> Flow<T> asFlow(ObservableSource<T> observableSource) {
        return FlowKt.callbackFlow(new C20211(observableSource, null));
    }

    public static final <T> Observable<T> asObservable(final Flow<? extends T> flow, final CoroutineContext coroutineContext) {
        return Observable.create(new ObservableOnSubscribe() { // from class: kotlinx.coroutines.rx3.RxConvertKt$$ExternalSyntheticLambda0
            @Override // io.reactivex.rxjava3.core.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                RxConvertKt.asObservable$lambda$0(coroutineContext, flow, observableEmitter);
            }
        });
    }

    public static /* synthetic */ Observable asObservable$default(Flow flow, CoroutineContext coroutineContext, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        return asObservable(flow, coroutineContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void asObservable$lambda$0(CoroutineContext coroutineContext, Flow flow, ObservableEmitter observableEmitter) {
        observableEmitter.setCancellable(new RxCancellable(BuildersKt.launch(GlobalScope.INSTANCE, Dispatchers.getUnconfined().plus(coroutineContext), CoroutineStart.ATOMIC, new RxConvertKt$asObservable$1$job$1(flow, observableEmitter, null))));
    }

    public static /* synthetic */ Flowable asFlowable$default(Flow flow, CoroutineContext coroutineContext, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        return asFlowable(flow, coroutineContext);
    }

    public static final <T> Flowable<T> asFlowable(Flow<? extends T> flow, CoroutineContext coroutineContext) {
        return Flowable.fromPublisher(ReactiveFlowKt.asPublisher(flow, coroutineContext));
    }

    public static /* synthetic */ Flowable from$default(Flow flow, CoroutineContext coroutineContext, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        return asFlowable(flow, coroutineContext);
    }

    /* JADX INFO: renamed from: from$default, reason: collision with other method in class */
    public static /* synthetic */ Observable m16407from$default(Flow flow, CoroutineContext coroutineContext, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        return asObservable(flow, coroutineContext);
    }
}
