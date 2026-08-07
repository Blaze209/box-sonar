package com.margelo.nitro.boxcontext;

import com.box.brownfieldApi.featuresNavigator.activities.ReactNativeFeatureActivity;
import com.margelo.nitro.core.Promise;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: compiled from: MessengerService.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J\u001e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\r2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016J.\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\r2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\tH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/margelo/nitro/boxcontext/MessengerService;", "Lcom/margelo/nitro/boxcontext/HybridMessengerServiceSpec;", "<init>", "()V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "sendMessage", "", "recipientId", "", SemanticAttributes.MessagingDestinationKindValues.TOPIC, "message", "listen", "Lcom/margelo/nitro/core/Promise;", "getResult", "resultTopic", "cirrus_box-context_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MessengerService extends HybridMessengerServiceSpec {
    private final CoroutineScope scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));

    /* JADX INFO: renamed from: com.margelo.nitro.boxcontext.MessengerService$sendMessage$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MessengerService.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.margelo.nitro.boxcontext.MessengerService$sendMessage$1", f = "MessengerService.kt", i = {}, l = {23}, m = "invokeSuspend", n = {}, s = {})
    static final class C18051 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $message;
        final /* synthetic */ String $recipientId;
        final /* synthetic */ String $topic;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C18051(String str, String str2, String str3, Continuation<? super C18051> continuation) {
            super(2, continuation);
            this.$recipientId = str;
            this.$topic = str2;
            this.$message = str3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C18051(this.$recipientId, this.$topic, this.$message, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C18051) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (MessengerBus.sendMessage$default(MessengerBus.INSTANCE, this.$recipientId, this.$topic, this.$message, null, this, 8, null) == coroutine_suspended) {
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

    @Override // com.margelo.nitro.boxcontext.HybridMessengerServiceSpec
    public void sendMessage(String recipientId, String topic, String message) {
        Intrinsics.checkNotNullParameter(recipientId, "recipientId");
        Intrinsics.checkNotNullParameter(topic, "topic");
        Intrinsics.checkNotNullParameter(message, "message");
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C18051(recipientId, topic, message, null), 3, null);
    }

    /* JADX INFO: renamed from: com.margelo.nitro.boxcontext.MessengerService$listen$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MessengerService.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.margelo.nitro.boxcontext.MessengerService$listen$1", f = "MessengerService.kt", i = {}, l = {28}, m = "invokeSuspend", n = {}, s = {})
    static final class C18041 extends SuspendLambda implements Function1<Continuation<? super String>, Object> {
        final /* synthetic */ String $recipientId;
        final /* synthetic */ String $topic;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C18041(String str, String str2, Continuation<? super C18041> continuation) {
            super(1, continuation);
            this.$recipientId = str;
            this.$topic = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C18041(this.$recipientId, this.$topic, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super String> continuation) {
            return ((C18041) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = MessengerBus.INSTANCE.getResult(this.$recipientId, this.$topic, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            MessengerEvent messengerEvent = (MessengerEvent) obj;
            String status = messengerEvent.getStatus();
            if (Intrinsics.areEqual(status, MessengerBus.STATUS_OK)) {
                return messengerEvent.getContent();
            }
            if (Intrinsics.areEqual(status, "cancelled")) {
                throw new RuntimeException("cancelled");
            }
            return messengerEvent.getContent();
        }
    }

    @Override // com.margelo.nitro.boxcontext.HybridMessengerServiceSpec
    public Promise<String> listen(String recipientId, String topic) {
        Intrinsics.checkNotNullParameter(recipientId, "recipientId");
        Intrinsics.checkNotNullParameter(topic, "topic");
        return Promise.Companion.async$default(Promise.INSTANCE, null, new C18041(recipientId, topic, null), 1, null);
    }

    /* JADX INFO: renamed from: com.margelo.nitro.boxcontext.MessengerService$getResult$1, reason: invalid class name */
    /* JADX INFO: compiled from: MessengerService.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.margelo.nitro.boxcontext.MessengerService$getResult$1", f = "MessengerService.kt", i = {}, l = {42}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super String>, Object> {
        final /* synthetic */ String $message;
        final /* synthetic */ String $recipientId;
        final /* synthetic */ String $resultTopic;
        final /* synthetic */ String $topic;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, String str2, String str3, String str4, Continuation<? super AnonymousClass1> continuation) {
            super(1, continuation);
            this.$recipientId = str;
            this.$topic = str2;
            this.$message = str3;
            this.$resultTopic = str4;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass1(this.$recipientId, this.$topic, this.$message, this.$resultTopic, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super String> continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.margelo.nitro.boxcontext.MessengerService$getResult$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: MessengerService.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.margelo.nitro.boxcontext.MessengerService$getResult$1$1", f = "MessengerService.kt", i = {0}, l = {46, 47}, m = "invokeSuspend", n = {ReactNativeFeatureActivity.RESULT_EXTRA_KEY}, s = {"L$0"})
        static final class C02311 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
            final /* synthetic */ String $message;
            final /* synthetic */ String $recipientId;
            final /* synthetic */ String $resultTopic;
            final /* synthetic */ String $topic;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C02311(String str, String str2, String str3, String str4, Continuation<? super C02311> continuation) {
                super(2, continuation);
                this.$recipientId = str;
                this.$topic = str2;
                this.$message = str3;
                this.$resultTopic = str4;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C02311 c02311 = new C02311(this.$recipientId, this.$topic, this.$message, this.$resultTopic, continuation);
                c02311.L$0 = obj;
                return c02311;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
                return ((C02311) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Code restructure failed: missing block: B:14:0x0065, code lost:
            
                if (r14 == r0) goto L15;
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
                    int r1 = r13.label
                    r2 = 0
                    r3 = 2
                    r4 = 1
                    if (r1 == 0) goto L23
                    if (r1 == r4) goto L1b
                    if (r1 != r3) goto L13
                    kotlin.ResultKt.throwOnFailure(r14)
                    goto L68
                L13:
                    java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                    java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
                    r13.<init>(r14)
                    throw r13
                L1b:
                    java.lang.Object r1 = r13.L$0
                    kotlinx.coroutines.Deferred r1 = (kotlinx.coroutines.Deferred) r1
                    kotlin.ResultKt.throwOnFailure(r14)
                    goto L5a
                L23:
                    kotlin.ResultKt.throwOnFailure(r14)
                    java.lang.Object r14 = r13.L$0
                    r5 = r14
                    kotlinx.coroutines.CoroutineScope r5 = (kotlinx.coroutines.CoroutineScope) r5
                    kotlinx.coroutines.CoroutineStart r7 = kotlinx.coroutines.CoroutineStart.UNDISPATCHED
                    com.margelo.nitro.boxcontext.MessengerService$getResult$1$1$result$1 r14 = new com.margelo.nitro.boxcontext.MessengerService$getResult$1$1$result$1
                    java.lang.String r1 = r13.$recipientId
                    java.lang.String r6 = r13.$resultTopic
                    r14.<init>(r1, r6, r2)
                    r8 = r14
                    kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
                    r9 = 1
                    r10 = 0
                    r6 = 0
                    kotlinx.coroutines.Deferred r1 = kotlinx.coroutines.BuildersKt.async$default(r5, r6, r7, r8, r9, r10)
                    com.margelo.nitro.boxcontext.MessengerBus r5 = com.margelo.nitro.boxcontext.MessengerBus.INSTANCE
                    java.lang.String r6 = r13.$recipientId
                    java.lang.String r7 = r13.$topic
                    java.lang.String r8 = r13.$message
                    r10 = r13
                    kotlin.coroutines.Continuation r10 = (kotlin.coroutines.Continuation) r10
                    r13.L$0 = r1
                    r13.label = r4
                    r9 = 0
                    r11 = 8
                    r12 = 0
                    java.lang.Object r14 = com.margelo.nitro.boxcontext.MessengerBus.sendMessage$default(r5, r6, r7, r8, r9, r10, r11, r12)
                    if (r14 != r0) goto L5a
                    goto L67
                L5a:
                    r14 = r13
                    kotlin.coroutines.Continuation r14 = (kotlin.coroutines.Continuation) r14
                    r13.L$0 = r2
                    r13.label = r3
                    java.lang.Object r14 = r1.await(r14)
                    if (r14 != r0) goto L68
                L67:
                    return r0
                L68:
                    com.margelo.nitro.boxcontext.MessengerEvent r14 = (com.margelo.nitro.boxcontext.MessengerEvent) r14
                    java.lang.String r13 = r14.getStatus()
                    java.lang.String r0 = "ok"
                    boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r13, r0)
                    if (r0 == 0) goto L7b
                    java.lang.String r13 = r14.getContent()
                    return r13
                L7b:
                    java.lang.String r0 = "cancelled"
                    boolean r13 = kotlin.jvm.internal.Intrinsics.areEqual(r13, r0)
                    if (r13 != 0) goto L88
                    java.lang.String r13 = r14.getContent()
                    return r13
                L88:
                    java.lang.RuntimeException r13 = new java.lang.RuntimeException
                    r13.<init>(r0)
                    throw r13
                */
                throw new UnsupportedOperationException("Method not decompiled: com.margelo.nitro.boxcontext.MessengerService.AnonymousClass1.C02311.invokeSuspend(java.lang.Object):java.lang.Object");
            }
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
            Object objCoroutineScope = CoroutineScopeKt.coroutineScope(new C02311(this.$recipientId, this.$topic, this.$message, this.$resultTopic, null), this);
            return objCoroutineScope == coroutine_suspended ? coroutine_suspended : objCoroutineScope;
        }
    }

    @Override // com.margelo.nitro.boxcontext.HybridMessengerServiceSpec
    public Promise<String> getResult(String recipientId, String topic, String message, String resultTopic) {
        Intrinsics.checkNotNullParameter(recipientId, "recipientId");
        Intrinsics.checkNotNullParameter(topic, "topic");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(resultTopic, "resultTopic");
        return Promise.Companion.async$default(Promise.INSTANCE, null, new AnonymousClass1(recipientId, topic, message, resultTopic, null), 1, null);
    }
}
