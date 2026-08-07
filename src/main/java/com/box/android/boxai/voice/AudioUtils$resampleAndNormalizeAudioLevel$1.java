package com.box.android.boxai.voice;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: AudioUtils.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.boxai.voice.AudioUtils$resampleAndNormalizeAudioLevel$1", f = "AudioUtils.kt", i = {0, 0}, l = {24}, m = "invokeSuspend", n = {"$this$flow", "buffer"}, s = {"L$0", "L$1"}, v = 1)
final class AudioUtils$resampleAndNormalizeAudioLevel$1 extends SuspendLambda implements Function2<FlowCollector<? super Float>, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: $$v$c$kotlin-time-Duration$-sampleInterval$0, reason: not valid java name */
    final /* synthetic */ long f216$$v$c$kotlintimeDuration$sampleInterval$0;
    final /* synthetic */ Flow<Float> $rmsSamplesFlow;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AudioUtils$resampleAndNormalizeAudioLevel$1(long j, Flow<Float> flow, Continuation<? super AudioUtils$resampleAndNormalizeAudioLevel$1> continuation) {
        super(2, continuation);
        this.f216$$v$c$kotlintimeDuration$sampleInterval$0 = j;
        this.$rmsSamplesFlow = flow;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AudioUtils$resampleAndNormalizeAudioLevel$1 audioUtils$resampleAndNormalizeAudioLevel$1 = new AudioUtils$resampleAndNormalizeAudioLevel$1(this.f216$$v$c$kotlintimeDuration$sampleInterval$0, this.$rmsSamplesFlow, continuation);
        audioUtils$resampleAndNormalizeAudioLevel$1.L$0 = obj;
        return audioUtils$resampleAndNormalizeAudioLevel$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super Float> flowCollector, Continuation<? super Unit> continuation) {
        return ((AudioUtils$resampleAndNormalizeAudioLevel$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        FlowCollector flowCollector = (FlowCollector) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ArrayList arrayList = new ArrayList();
            this.L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
            this.L$1 = SpillingKt.nullOutSpilledVariable(arrayList);
            this.label = 1;
            if (CoroutineScopeKt.coroutineScope(new AnonymousClass1(arrayList, flowCollector, this.f216$$v$c$kotlintimeDuration$sampleInterval$0, this.$rmsSamplesFlow, null), this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.box.android.boxai.voice.AudioUtils$resampleAndNormalizeAudioLevel$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: AudioUtils.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.boxai.voice.AudioUtils$resampleAndNormalizeAudioLevel$1$1", f = "AudioUtils.kt", i = {0, 0, 1, 1}, l = {33, 34}, m = "invokeSuspend", n = {"$this$coroutineScope", "audioLevel", "$this$coroutineScope", "audioLevel"}, s = {"L$0", "F$0", "L$0", "F$0"}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ FlowCollector<Float> $$this$flow;

        /* JADX INFO: renamed from: $$v$c$kotlin-time-Duration$-sampleInterval$0, reason: not valid java name */
        final /* synthetic */ long f217$$v$c$kotlintimeDuration$sampleInterval$0;
        final /* synthetic */ List<Float> $buffer;
        final /* synthetic */ Flow<Float> $rmsSamplesFlow;
        float F$0;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(List<Float> list, FlowCollector<? super Float> flowCollector, long j, Flow<Float> flow, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$buffer = list;
            this.$$this$flow = flowCollector;
            this.f217$$v$c$kotlintimeDuration$sampleInterval$0 = j;
            this.$rmsSamplesFlow = flow;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$buffer, this.$$this$flow, this.f217$$v$c$kotlintimeDuration$sampleInterval$0, this.$rmsSamplesFlow, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.box.android.boxai.voice.AudioUtils$resampleAndNormalizeAudioLevel$1$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: AudioUtils.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.box.android.boxai.voice.AudioUtils$resampleAndNormalizeAudioLevel$1$1$1", f = "AudioUtils.kt", i = {}, l = {26}, m = "invokeSuspend", n = {}, s = {}, v = 1)
        static final class C01251 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ List<Float> $buffer;
            final /* synthetic */ Flow<Float> $rmsSamplesFlow;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01251(Flow<Float> flow, List<Float> list, Continuation<? super C01251> continuation) {
                super(2, continuation);
                this.$rmsSamplesFlow = flow;
                this.$buffer = list;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C01251(this.$rmsSamplesFlow, this.$buffer, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C01251) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    Flow<Float> flow = this.$rmsSamplesFlow;
                    final List<Float> list = this.$buffer;
                    this.label = 1;
                    if (flow.collect(new FlowCollector() { // from class: com.box.android.boxai.voice.AudioUtils.resampleAndNormalizeAudioLevel.1.1.1.1
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                            return emit(((Number) obj2).floatValue(), (Continuation<? super Unit>) continuation);
                        }

                        public final Object emit(float f, Continuation<? super Unit> continuation) {
                            list.add(Boxing.boxFloat(f));
                            return Unit.INSTANCE;
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
        }

        /* JADX WARN: Code duplicated, block: B:11:0x003c  */
        /* JADX WARN: Code duplicated, block: B:14:0x0063 A[PHI: r2
          0x0063: PHI (r2v3 float) = (r2v5 float), (r2v6 float) binds: [B:12:0x0060, B:9:0x001f] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0076 -> B:11:0x003c). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r10) {
            /*
                r9 = this;
                java.lang.Object r0 = r9.L$0
                r1 = r0
                kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r9.label
                r7 = 2
                r8 = 1
                if (r2 == 0) goto L25
                if (r2 == r8) goto L1f
                if (r2 != r7) goto L17
                kotlin.ResultKt.throwOnFailure(r10)
                goto L3c
            L17:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r10)
                throw r9
            L1f:
                float r2 = r9.F$0
                kotlin.ResultKt.throwOnFailure(r10)
                goto L63
            L25:
                kotlin.ResultKt.throwOnFailure(r10)
                com.box.android.boxai.voice.AudioUtils$resampleAndNormalizeAudioLevel$1$1$1 r10 = new com.box.android.boxai.voice.AudioUtils$resampleAndNormalizeAudioLevel$1$1$1
                kotlinx.coroutines.flow.Flow<java.lang.Float> r2 = r9.$rmsSamplesFlow
                java.util.List<java.lang.Float> r3 = r9.$buffer
                r4 = 0
                r10.<init>(r2, r3, r4)
                r4 = r10
                kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
                r5 = 3
                r6 = 0
                r2 = 0
                r3 = 0
                kotlinx.coroutines.BuildersKt.launch$default(r1, r2, r3, r4, r5, r6)
            L3c:
                com.box.android.boxai.voice.AudioUtils r10 = com.box.android.boxai.voice.AudioUtils.INSTANCE
                java.util.List<java.lang.Float> r2 = r9.$buffer
                float r2 = com.box.android.boxai.voice.AudioUtils.access$audioLevelFromRmsSamples(r10, r2)
                java.util.List<java.lang.Float> r10 = r9.$buffer
                r10.clear()
                kotlinx.coroutines.flow.FlowCollector<java.lang.Float> r10 = r9.$$this$flow
                java.lang.Float r3 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r2)
                r4 = r9
                kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
                java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
                r9.L$0 = r5
                r9.F$0 = r2
                r9.label = r8
                java.lang.Object r10 = r10.emit(r3, r4)
                if (r10 != r0) goto L63
                goto L78
            L63:
                long r3 = r9.f217$$v$c$kotlintimeDuration$sampleInterval$0
                r10 = r9
                kotlin.coroutines.Continuation r10 = (kotlin.coroutines.Continuation) r10
                java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
                r9.L$0 = r5
                r9.F$0 = r2
                r9.label = r7
                java.lang.Object r10 = kotlinx.coroutines.DelayKt.m16309delayVtjQ1oo(r3, r10)
                if (r10 != r0) goto L3c
            L78:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.boxai.voice.AudioUtils$resampleAndNormalizeAudioLevel$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }
}
