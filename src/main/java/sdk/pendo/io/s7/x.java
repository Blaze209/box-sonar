package sdk.pendo.io.s7;

import androidx.exifinterface.media.ExifInterface;
import androidx.media3.exoplayer.upstream.CmcdData;
import java.util.concurrent.CancellationException;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.sync.Mutex;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\u001aY\u0010\u000e\u001a\u00020\r*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00052'\u0010\f\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0007¢\u0006\u0002\b\u000bø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a$\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011\"\u0004\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u00028\u00000\u00112\u0006\u0010\u0013\u001a\u00020\u0012\u001a,\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011\"\u0004\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u00028\u00000\u00112\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/sync/Mutex;", "mutex", "Lkotlin/coroutines/CoroutineContext;", "context", "Lkotlinx/coroutines/CoroutineStart;", "start", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "block", "Lkotlinx/coroutines/Job;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "(Lkotlinx/coroutines/CoroutineScope;Lkotlinx/coroutines/sync/Mutex;Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/Job;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/Flow;", "", "timeoutMs", "debounceMs", "pendoIO_release"}, k = 2, mv = {1, 9, 0})
public final class x {

    /* JADX INFO: Add missing generic type declarations: [T] */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u008a@"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/channels/ProducerScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "sdk.pendo.io.utilities.KotlinFlowExtensionsKt$debounceWithTimeout$1", f = "KotlinFlowExtensions.kt", i = {0, 0, 0}, l = {71, 94}, m = "invokeSuspend", n = {"$this$channelFlow", "debounceJob", "maxWaitJob"}, s = {"L$0", "L$1", "L$2"})
    static final class a<T> extends SuspendLambda implements Function2<ProducerScope<? super T>, Continuation<? super Unit>, Object> {
        Object a;
        Object b;
        int c;
        private /* synthetic */ Object d;
        final /* synthetic */ long e;
        final /* synthetic */ long f;
        final /* synthetic */ Flow<T> g;

        /* JADX INFO: renamed from: sdk.pendo.io.s7.x$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        static final class C0484a<T> implements FlowCollector {
            final /* synthetic */ Ref.ObjectRef<T> a;
            final /* synthetic */ Ref.ObjectRef<Job> b;
            final /* synthetic */ ProducerScope<T> c;
            final /* synthetic */ Ref.ObjectRef<Job> d;
            final /* synthetic */ long e;
            final /* synthetic */ long f;

            /* JADX INFO: renamed from: sdk.pendo.io.s7.x$a$a$a, reason: collision with other inner class name */
            @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
            @DebugMetadata(c = "sdk.pendo.io.utilities.KotlinFlowExtensionsKt$debounceWithTimeout$1$2$1", f = "KotlinFlowExtensions.kt", i = {}, l = {77}, m = "invokeSuspend", n = {}, s = {})
            static final class C0485a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                int a;
                final /* synthetic */ long b;
                final /* synthetic */ Ref.ObjectRef<Job> c;
                final /* synthetic */ Ref.ObjectRef<T> d;
                final /* synthetic */ ProducerScope<T> e;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                C0485a(long j, Ref.ObjectRef<Job> objectRef, Ref.ObjectRef<T> objectRef2, ProducerScope<? super T> producerScope, Continuation<? super C0485a> continuation) {
                    super(2, continuation);
                    this.b = j;
                    this.c = objectRef;
                    this.d = objectRef2;
                    this.e = producerScope;
                }

                @Override // kotlin.jvm.functions.Function2
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((C0485a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new C0485a(this.b, this.c, this.d, this.e, continuation);
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
                    a.b(this.d, this.e);
                    Job job = this.c.element;
                    if (job != null) {
                        Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                    }
                    this.c.element = null;
                    return Unit.INSTANCE;
                }
            }

            /* JADX INFO: renamed from: sdk.pendo.io.s7.x$a$a$b */
            @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
            @DebugMetadata(c = "sdk.pendo.io.utilities.KotlinFlowExtensionsKt$debounceWithTimeout$1$2$2", f = "KotlinFlowExtensions.kt", i = {}, l = {86}, m = "invokeSuspend", n = {}, s = {})
            static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                int a;
                final /* synthetic */ long b;
                final /* synthetic */ Ref.ObjectRef<Job> c;
                final /* synthetic */ Ref.ObjectRef<Job> d;
                final /* synthetic */ Ref.ObjectRef<T> e;
                final /* synthetic */ ProducerScope<T> f;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                b(long j, Ref.ObjectRef<Job> objectRef, Ref.ObjectRef<Job> objectRef2, Ref.ObjectRef<T> objectRef3, ProducerScope<? super T> producerScope, Continuation<? super b> continuation) {
                    super(2, continuation);
                    this.b = j;
                    this.c = objectRef;
                    this.d = objectRef2;
                    this.e = objectRef3;
                    this.f = producerScope;
                }

                @Override // kotlin.jvm.functions.Function2
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new b(this.b, this.c, this.d, this.e, this.f, continuation);
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
                    Job job = this.c.element;
                    if (job != null) {
                        Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                    }
                    a.b(this.e, this.f);
                    this.d.element = null;
                    return Unit.INSTANCE;
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            C0484a(Ref.ObjectRef<T> objectRef, Ref.ObjectRef<Job> objectRef2, ProducerScope<? super T> producerScope, Ref.ObjectRef<Job> objectRef3, long j, long j2) {
                this.a = objectRef;
                this.b = objectRef2;
                this.c = producerScope;
                this.d = objectRef3;
                this.e = j;
                this.f = j2;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public final Object emit(T t, Continuation<? super Unit> continuation) {
                this.a.element = t;
                Job job = this.b.element;
                if (job != null) {
                    Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                }
                this.b.element = (T) BuildersKt__Builders_commonKt.launch$default(this.c, null, null, new C0485a(this.e, this.d, this.a, this.c, null), 3, null);
                Ref.ObjectRef<Job> objectRef = this.d;
                if (objectRef.element == null) {
                    objectRef.element = (T) BuildersKt__Builders_commonKt.launch$default(this.c, null, null, new b(this.f, this.b, this.d, this.a, this.c, null), 3, null);
                }
                return Unit.INSTANCE;
            }
        }

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "()V"}, k = 3, mv = {1, 9, 0})
        static final class b extends Lambda implements Function0<Unit> {
            final /* synthetic */ Ref.ObjectRef<Job> a;
            final /* synthetic */ Ref.ObjectRef<Job> b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(Ref.ObjectRef<Job> objectRef, Ref.ObjectRef<Job> objectRef2) {
                super(0);
                this.a = objectRef;
                this.b = objectRef2;
            }

            public final void a() {
                Job job = this.a.element;
                if (job != null) {
                    Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                }
                Job job2 = this.b.element;
                if (job2 != null) {
                    Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                a();
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(long j, long j2, Flow<? extends T> flow, Continuation<? super a> continuation) {
            super(2, continuation);
            this.e = j;
            this.f = j2;
            this.g = flow;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final <T> void b(Ref.ObjectRef<T> objectRef, ProducerScope<? super T> producerScope) {
            T t = objectRef.element;
            if (t != null) {
                ChannelResult.m16344isSuccessimpl(producerScope.mo11206trySendJP2dKIU(t));
                objectRef.element = null;
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            a aVar = new a(this.e, this.f, this.g, continuation);
            aVar.d = obj;
            return aVar;
        }

        /* JADX WARN: Code restructure failed: missing block: B:17:0x0078, code lost:
        
            if (kotlinx.coroutines.channels.ProduceKt.awaitClose(r4, r14, r13) == r0) goto L18;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r14) {
            /*
                r13 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r13.c
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L2a
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                kotlin.ResultKt.throwOnFailure(r14)
                goto L7b
            L12:
                java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
                r13.<init>(r14)
                throw r13
            L1a:
                java.lang.Object r1 = r13.b
                kotlin.jvm.internal.Ref$ObjectRef r1 = (kotlin.jvm.internal.Ref.ObjectRef) r1
                java.lang.Object r3 = r13.a
                kotlin.jvm.internal.Ref$ObjectRef r3 = (kotlin.jvm.internal.Ref.ObjectRef) r3
                java.lang.Object r4 = r13.d
                kotlinx.coroutines.channels.ProducerScope r4 = (kotlinx.coroutines.channels.ProducerScope) r4
                kotlin.ResultKt.throwOnFailure(r14)
                goto L66
            L2a:
                kotlin.ResultKt.throwOnFailure(r14)
                java.lang.Object r14 = r13.d
                r7 = r14
                kotlinx.coroutines.channels.ProducerScope r7 = (kotlinx.coroutines.channels.ProducerScope) r7
                long r4 = r13.e
                long r8 = r13.f
                int r14 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
                if (r14 > 0) goto L7e
                kotlin.jvm.internal.Ref$ObjectRef r5 = new kotlin.jvm.internal.Ref$ObjectRef
                r5.<init>()
                kotlin.jvm.internal.Ref$ObjectRef r6 = new kotlin.jvm.internal.Ref$ObjectRef
                r6.<init>()
                kotlin.jvm.internal.Ref$ObjectRef r8 = new kotlin.jvm.internal.Ref$ObjectRef
                r8.<init>()
                kotlinx.coroutines.flow.Flow<T> r14 = r13.g
                sdk.pendo.io.s7.x$a$a r4 = new sdk.pendo.io.s7.x$a$a
                long r9 = r13.e
                long r11 = r13.f
                r4.<init>(r5, r6, r7, r8, r9, r11)
                r13.d = r7
                r13.a = r6
                r13.b = r8
                r13.c = r3
                java.lang.Object r14 = r14.collect(r4, r13)
                if (r14 != r0) goto L63
                goto L7a
            L63:
                r3 = r6
                r4 = r7
                r1 = r8
            L66:
                sdk.pendo.io.s7.x$a$b r14 = new sdk.pendo.io.s7.x$a$b
                r14.<init>(r3, r1)
                r1 = 0
                r13.d = r1
                r13.a = r1
                r13.b = r1
                r13.c = r2
                java.lang.Object r13 = kotlinx.coroutines.channels.ProduceKt.awaitClose(r4, r14, r13)
                if (r13 != r0) goto L7b
            L7a:
                return r0
            L7b:
                kotlin.Unit r13 = kotlin.Unit.INSTANCE
                return r13
            L7e:
                java.lang.IllegalArgumentException r13 = new java.lang.IllegalArgumentException
                java.lang.String r14 = "debounceMs should be less or equal to maxWaitMs"
                java.lang.String r14 = r14.toString()
                r13.<init>(r14)
                throw r13
            */
            throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.s7.x.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(ProducerScope<? super T> producerScope, Continuation<? super Unit> continuation) {
            return ((a) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "sdk.pendo.io.utilities.KotlinFlowExtensionsKt$launchWithMutex$1", f = "KotlinFlowExtensions.kt", i = {0, 0, 1}, l = {104, 19}, m = "invokeSuspend", n = {"$this$launch", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$0"})
    static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object a;
        Object b;
        int c;
        private /* synthetic */ Object d;
        final /* synthetic */ Mutex e;
        final /* synthetic */ Function2<CoroutineScope, Continuation<? super Unit>, Object> f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        b(Mutex mutex, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super b> continuation) {
            super(2, continuation);
            this.e = mutex;
            this.f = function2;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            b bVar = new b(this.e, this.f, continuation);
            bVar.d = obj;
            return bVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            CoroutineScope coroutineScope;
            Mutex mutex;
            Function2<CoroutineScope, Continuation<? super Unit>, Object> function2;
            Mutex mutex2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.c;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    coroutineScope = (CoroutineScope) this.d;
                    mutex = this.e;
                    function2 = this.f;
                    this.d = coroutineScope;
                    this.a = mutex;
                    this.b = function2;
                    this.c = 1;
                    if (mutex.lock(null, this) != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                }
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    mutex2 = (Mutex) this.d;
                    try {
                        ResultKt.throwOnFailure(obj);
                        Unit unit = Unit.INSTANCE;
                        mutex2.unlock(null);
                        return Unit.INSTANCE;
                    } catch (Throwable th) {
                        mutex = mutex2;
                        th = th;
                        mutex.unlock(null);
                        throw th;
                    }
                }
                function2 = (Function2) this.b;
                Mutex mutex3 = (Mutex) this.a;
                coroutineScope = (CoroutineScope) this.d;
                ResultKt.throwOnFailure(obj);
                mutex = mutex3;
                this.d = mutex;
                this.a = null;
                this.b = null;
                this.c = 2;
                if (function2.invoke(coroutineScope, this) != coroutine_suspended) {
                    mutex2 = mutex;
                    Unit unit2 = Unit.INSTANCE;
                    mutex2.unlock(null);
                    return Unit.INSTANCE;
                }
                return coroutine_suspended;
            } catch (Throwable th2) {
                th = th2;
                mutex.unlock(null);
                throw th;
            }
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u008a@"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/channels/ProducerScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "sdk.pendo.io.utilities.KotlinFlowExtensionsKt$timeoutAndEmitLast$1", f = "KotlinFlowExtensions.kt", i = {0, 0}, l = {36, 49}, m = "invokeSuspend", n = {"$this$channelFlow", "timeoutJob"}, s = {"L$0", "L$1"})
    static final class c<T> extends SuspendLambda implements Function2<ProducerScope<? super T>, Continuation<? super Unit>, Object> {
        Object a;
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ Flow<T> d;
        final /* synthetic */ long e;

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        static final class a<T> implements FlowCollector {
            final /* synthetic */ Ref.ObjectRef<T> a;
            final /* synthetic */ Ref.ObjectRef<Job> b;
            final /* synthetic */ ProducerScope<T> c;
            final /* synthetic */ long d;

            /* JADX INFO: renamed from: sdk.pendo.io.s7.x$c$a$a, reason: collision with other inner class name */
            @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
            @DebugMetadata(c = "sdk.pendo.io.utilities.KotlinFlowExtensionsKt$timeoutAndEmitLast$1$1$1", f = "KotlinFlowExtensions.kt", i = {}, l = {42}, m = "invokeSuspend", n = {}, s = {})
            static final class C0486a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                int a;
                final /* synthetic */ long b;
                final /* synthetic */ Ref.ObjectRef<Job> c;
                final /* synthetic */ Ref.ObjectRef<T> d;
                final /* synthetic */ ProducerScope<T> e;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                C0486a(long j, Ref.ObjectRef<Job> objectRef, Ref.ObjectRef<T> objectRef2, ProducerScope<? super T> producerScope, Continuation<? super C0486a> continuation) {
                    super(2, continuation);
                    this.b = j;
                    this.c = objectRef;
                    this.d = objectRef2;
                    this.e = producerScope;
                }

                @Override // kotlin.jvm.functions.Function2
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((C0486a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new C0486a(this.b, this.c, this.d, this.e, continuation);
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
                    c.b(this.d, this.e);
                    this.c.element = null;
                    return Unit.INSTANCE;
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            a(Ref.ObjectRef<T> objectRef, Ref.ObjectRef<Job> objectRef2, ProducerScope<? super T> producerScope, long j) {
                this.a = objectRef;
                this.b = objectRef2;
                this.c = producerScope;
                this.d = j;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public final Object emit(T t, Continuation<? super Unit> continuation) {
                this.a.element = t;
                Ref.ObjectRef<Job> objectRef = this.b;
                if (objectRef.element == null) {
                    objectRef.element = (T) BuildersKt__Builders_commonKt.launch$default(this.c, null, null, new C0486a(this.d, this.b, this.a, this.c, null), 3, null);
                }
                return Unit.INSTANCE;
            }
        }

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "()V"}, k = 3, mv = {1, 9, 0})
        static final class b extends Lambda implements Function0<Unit> {
            final /* synthetic */ Ref.ObjectRef<Job> a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(Ref.ObjectRef<Job> objectRef) {
                super(0);
                this.a = objectRef;
            }

            public final void a() {
                Job job = this.a.element;
                if (job != null) {
                    Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                a();
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        c(Flow<? extends T> flow, long j, Continuation<? super c> continuation) {
            super(2, continuation);
            this.d = flow;
            this.e = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final <T> void b(Ref.ObjectRef<T> objectRef, ProducerScope<? super T> producerScope) {
            T t = objectRef.element;
            if (t != null) {
                ChannelResult.m16344isSuccessimpl(producerScope.mo11206trySendJP2dKIU(t));
                objectRef.element = null;
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            c cVar = new c(this.d, this.e, continuation);
            cVar.c = obj;
            return cVar;
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x0060, code lost:
        
            if (kotlinx.coroutines.channels.ProduceKt.awaitClose(r3, r11, r10) == r0) goto L16;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r11) {
            /*
                r10 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r10.b
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L26
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                kotlin.ResultKt.throwOnFailure(r11)
                goto L63
            L12:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r11)
                throw r10
            L1a:
                java.lang.Object r1 = r10.a
                kotlin.jvm.internal.Ref$ObjectRef r1 = (kotlin.jvm.internal.Ref.ObjectRef) r1
                java.lang.Object r3 = r10.c
                kotlinx.coroutines.channels.ProducerScope r3 = (kotlinx.coroutines.channels.ProducerScope) r3
                kotlin.ResultKt.throwOnFailure(r11)
                goto L50
            L26:
                kotlin.ResultKt.throwOnFailure(r11)
                java.lang.Object r11 = r10.c
                r7 = r11
                kotlinx.coroutines.channels.ProducerScope r7 = (kotlinx.coroutines.channels.ProducerScope) r7
                kotlin.jvm.internal.Ref$ObjectRef r5 = new kotlin.jvm.internal.Ref$ObjectRef
                r5.<init>()
                kotlin.jvm.internal.Ref$ObjectRef r6 = new kotlin.jvm.internal.Ref$ObjectRef
                r6.<init>()
                kotlinx.coroutines.flow.Flow<T> r11 = r10.d
                sdk.pendo.io.s7.x$c$a r4 = new sdk.pendo.io.s7.x$c$a
                long r8 = r10.e
                r4.<init>(r5, r6, r7, r8)
                r10.c = r7
                r10.a = r6
                r10.b = r3
                java.lang.Object r11 = r11.collect(r4, r10)
                if (r11 != r0) goto L4e
                goto L62
            L4e:
                r1 = r6
                r3 = r7
            L50:
                sdk.pendo.io.s7.x$c$b r11 = new sdk.pendo.io.s7.x$c$b
                r11.<init>(r1)
                r1 = 0
                r10.c = r1
                r10.a = r1
                r10.b = r2
                java.lang.Object r10 = kotlinx.coroutines.channels.ProduceKt.awaitClose(r3, r11, r10)
                if (r10 != r0) goto L63
            L62:
                return r0
            L63:
                kotlin.Unit r10 = kotlin.Unit.INSTANCE
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.s7.x.c.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(ProducerScope<? super T> producerScope, Continuation<? super Unit> continuation) {
            return ((c) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    public static final <T> Flow<T> a(Flow<? extends T> flow, long j, long j2) {
        Intrinsics.checkNotNullParameter(flow, "<this>");
        return FlowKt.channelFlow(new a(j, j2, flow, null));
    }

    public static final Job a(CoroutineScope coroutineScope, Mutex mutex, CoroutineContext context, CoroutineStart start, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> block) {
        Intrinsics.checkNotNullParameter(coroutineScope, "<this>");
        Intrinsics.checkNotNullParameter(mutex, "mutex");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(block, "block");
        return BuildersKt.launch(coroutineScope, context, start, new b(mutex, block, null));
    }

    public static /* synthetic */ Job a(CoroutineScope coroutineScope, Mutex mutex, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2 function2, int i, Object obj) {
        if ((i & 2) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        if ((i & 4) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        return a(coroutineScope, mutex, coroutineContext, coroutineStart, function2);
    }

    public static final <T> Flow<T> a(Flow<? extends T> flow, long j) {
        Intrinsics.checkNotNullParameter(flow, "<this>");
        return FlowKt.channelFlow(new c(flow, j, null));
    }
}
