package com.margelo.nitro.boxcontext;

import androidx.exifinterface.media.ExifInterface;
import com.box.android.common.utilities.BoxCommonConstants;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* JADX INFO: compiled from: MessengerBus.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J0\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u0010\u0010J\u001e\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u0010\u0012J\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\u00142\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005J\u001e\u0010\u0015\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u0010\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/margelo/nitro/boxcontext/MessengerBus;", "", "<init>", "()V", "STATUS_OK", "", "STATUS_CANCELLED", "bus", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/margelo/nitro/boxcontext/MessengerEvent;", "sendMessage", "", "recipientId", SemanticAttributes.MessagingDestinationKindValues.TOPIC, "content", "status", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendCancellation", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "messages", "Lkotlinx/coroutines/flow/Flow;", "getResult", "cirrus_box-context_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MessengerBus {
    public static final String STATUS_CANCELLED = "cancelled";
    public static final String STATUS_OK = "ok";
    public static final MessengerBus INSTANCE = new MessengerBus();
    private static final MutableSharedFlow<MessengerEvent> bus = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 6, null);

    private MessengerBus() {
    }

    public static /* synthetic */ Object sendMessage$default(MessengerBus messengerBus, String str, String str2, String str3, String str4, Continuation continuation, int i, Object obj) {
        if ((i & 8) != 0) {
            str4 = STATUS_OK;
        }
        return messengerBus.sendMessage(str, str2, str3, str4, continuation);
    }

    public final Object sendMessage(String str, String str2, String str3, String str4, Continuation<? super Unit> continuation) {
        Object objEmit = bus.emit(new MessengerEvent(str, str2, str3, str4), continuation);
        return objEmit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objEmit : Unit.INSTANCE;
    }

    public final Object sendCancellation(String str, String str2, Continuation<? super Unit> continuation) {
        Object objSendMessage = sendMessage(str, str2, "", "cancelled", continuation);
        return objSendMessage == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objSendMessage : Unit.INSTANCE;
    }

    public final Flow<MessengerEvent> messages(final String recipientId, final String topic) {
        Intrinsics.checkNotNullParameter(recipientId, "recipientId");
        Intrinsics.checkNotNullParameter(topic, "topic");
        final MutableSharedFlow<MessengerEvent> mutableSharedFlow = bus;
        return new Flow<MessengerEvent>() { // from class: com.margelo.nitro.boxcontext.MessengerBus$messages$$inlined$filter$1

            /* JADX INFO: renamed from: com.margelo.nitro.boxcontext.MessengerBus$messages$$inlined$filter$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 1, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ String $recipientId$inlined;
                final /* synthetic */ FlowCollector $this_unsafeFlow;
                final /* synthetic */ String $topic$inlined;

                /* JADX INFO: renamed from: com.margelo.nitro.boxcontext.MessengerBus$messages$$inlined$filter$1$2$1, reason: invalid class name */
                /* JADX INFO: compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
                @DebugMetadata(c = "com.margelo.nitro.boxcontext.MessengerBus$messages$$inlined$filter$1$2", f = "MessengerBus.kt", i = {}, l = {BoxCommonConstants.REQUEST_INVITE_COLLABORATORS}, m = "emit", n = {}, s = {})
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    Object L$1;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, String str, String str2) {
                    this.$this_unsafeFlow = flowCollector;
                    this.$recipientId$inlined = str;
                    this.$topic$inlined = str2;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0014  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                public final Object emit(Object obj, Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label -= Integer.MIN_VALUE;
                        } else {
                            anonymousClass1 = new AnonymousClass1(continuation);
                        }
                    } else {
                        anonymousClass1 = new AnonymousClass1(continuation);
                    }
                    Object obj2 = anonymousClass1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = anonymousClass1.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj2);
                        FlowCollector flowCollector = this.$this_unsafeFlow;
                        MessengerEvent messengerEvent = (MessengerEvent) obj;
                        if (Intrinsics.areEqual(messengerEvent.getRecipientId(), this.$recipientId$inlined) && Intrinsics.areEqual(messengerEvent.getTopic(), this.$topic$inlined)) {
                            anonymousClass1.label = 1;
                            if (flowCollector.emit(obj, anonymousClass1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj2);
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super MessengerEvent> flowCollector, Continuation continuation) {
                Object objCollect = mutableSharedFlow.collect(new AnonymousClass2(flowCollector, recipientId, topic), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        };
    }

    public final Object getResult(String str, String str2, Continuation<? super MessengerEvent> continuation) {
        return FlowKt.first(messages(str, str2), continuation);
    }
}
