package androidx.media3.effect;

import androidx.media3.common.GlObjectsProvider;
import androidx.media3.common.GlTextureInfo;
import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.util.Consumer;
import com.google.common.util.concurrent.ListenableFuture;
import com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.JobKt__JobKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.guava.ListenableFutureKt;

/* JADX INFO: compiled from: GlShaderProgramPacketProcessor.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b\u0007\u0018\u0000 *2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004:\u0001*B!\b\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u001c\u0010\u0019\u001a\u00020\u00182\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\u001bH\u0096@¢\u0006\u0002\u0010\u001cJ\u0016\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u0002H\u0082@¢\u0006\u0002\u0010\u001fJ\u0016\u0010 \u001a\u00020\u00182\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00020\u0010H\u0016J\u000e\u0010\"\u001a\u00020\u0018H\u0096@¢\u0006\u0002\u0010#J\b\u0010$\u001a\u00020\u0018H\u0016J\u0018\u0010%\u001a\u00020\u00182\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Landroidx/media3/effect/GlShaderProgramPacketProcessor;", "Landroidx/media3/effect/PacketProcessor;", "Landroidx/media3/effect/GlTextureFrame;", "Landroidx/media3/effect/GlShaderProgram$InputListener;", "Landroidx/media3/effect/GlShaderProgram$OutputListener;", "glThreadDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "shaderProgram", "Landroidx/media3/effect/GlShaderProgram;", "glObjectsProvider", "Landroidx/media3/common/GlObjectsProvider;", "<init>", "(Lkotlinx/coroutines/CoroutineDispatcher;Landroidx/media3/effect/GlShaderProgram;Landroidx/media3/common/GlObjectsProvider;)V", "isReleased", "Ljava/util/concurrent/atomic/AtomicBoolean;", "outputConsumer", "Landroidx/media3/effect/PacketConsumer;", "currentInputFrame", "currentInputMetadata", "Landroidx/media3/effect/Frame$Metadata;", "outputFrameDeferred", "Lkotlinx/coroutines/CompletableDeferred;", "inputCapacityChannel", "Lkotlinx/coroutines/channels/Channel;", "", "queuePacket", "packet", "Landroidx/media3/effect/PacketConsumer$Packet;", "(Landroidx/media3/effect/PacketConsumer$Packet;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processFramePacket", "inputFrame", "(Landroidx/media3/effect/GlTextureFrame;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setOutput", "output", "release", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onReadyToAcceptInputFrame", "onOutputFrameAvailable", "outputTexture", "Landroidx/media3/common/GlTextureInfo;", "presentationTimeUs", "", "Companion", "lib-effect_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class GlShaderProgramPacketProcessor implements PacketProcessor<GlTextureFrame, GlTextureFrame>, GlShaderProgram.InputListener, GlShaderProgram.OutputListener {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private GlTextureFrame currentInputFrame;
    private Frame.Metadata currentInputMetadata;
    private final GlObjectsProvider glObjectsProvider;
    private final CoroutineDispatcher glThreadDispatcher;
    private final Channel<Unit> inputCapacityChannel;
    private final AtomicBoolean isReleased;
    private volatile PacketConsumer<GlTextureFrame> outputConsumer;
    private CompletableDeferred<GlTextureFrame> outputFrameDeferred;
    private final GlShaderProgram shaderProgram;

    /* JADX INFO: renamed from: androidx.media3.effect.GlShaderProgramPacketProcessor$processFramePacket$1, reason: invalid class name */
    /* JADX INFO: compiled from: GlShaderProgramPacketProcessor.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.media3.effect.GlShaderProgramPacketProcessor", f = "GlShaderProgramPacketProcessor.kt", i = {0, 0, 1, 1, 2, 2, 2}, l = {111, 125, 126}, m = "processFramePacket", n = {"this", "inputFrame", "this", "inputFrame", "this", "inputFrame", "outputFrame"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$2"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GlShaderProgramPacketProcessor.this.processFramePacket(null, this);
        }
    }

    public /* synthetic */ GlShaderProgramPacketProcessor(CoroutineDispatcher coroutineDispatcher, GlShaderProgram glShaderProgram, GlObjectsProvider glObjectsProvider, DefaultConstructorMarker defaultConstructorMarker) {
        this(coroutineDispatcher, glShaderProgram, glObjectsProvider);
    }

    private GlShaderProgramPacketProcessor(CoroutineDispatcher coroutineDispatcher, GlShaderProgram glShaderProgram, GlObjectsProvider glObjectsProvider) {
        this.glThreadDispatcher = coroutineDispatcher;
        this.shaderProgram = glShaderProgram;
        this.glObjectsProvider = glObjectsProvider;
        this.isReleased = new AtomicBoolean();
        this.inputCapacityChannel = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
        glShaderProgram.setInputListener(this);
        glShaderProgram.setOutputListener(this);
        glShaderProgram.setErrorListener(ExecutorsKt.asExecutor(coroutineDispatcher), new GlShaderProgram.ErrorListener() { // from class: androidx.media3.effect.GlShaderProgramPacketProcessor$$ExternalSyntheticLambda0
            @Override // androidx.media3.effect.GlShaderProgram.ErrorListener
            public final void onError(VideoFrameProcessingException videoFrameProcessingException) {
                GlShaderProgramPacketProcessor._init_$lambda$0(this.f$0, videoFrameProcessingException);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(GlShaderProgramPacketProcessor glShaderProgramPacketProcessor, VideoFrameProcessingException videoFrameProcessingException) {
        CompletableDeferred<GlTextureFrame> completableDeferred = glShaderProgramPacketProcessor.outputFrameDeferred;
        if (completableDeferred != null) {
            Intrinsics.checkNotNull(videoFrameProcessingException);
            completableDeferred.completeExceptionally(videoFrameProcessingException);
        }
    }

    /* JADX INFO: renamed from: androidx.media3.effect.GlShaderProgramPacketProcessor$queuePacket$2, reason: invalid class name */
    /* JADX INFO: compiled from: GlShaderProgramPacketProcessor.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.media3.effect.GlShaderProgramPacketProcessor$queuePacket$2", f = "GlShaderProgramPacketProcessor.kt", i = {}, l = {97, 99}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PacketConsumer.Packet<GlTextureFrame> $packet;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(PacketConsumer.Packet<? extends GlTextureFrame> packet, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$packet = packet;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return GlShaderProgramPacketProcessor.this.new AnonymousClass2(this.$packet, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:20:0x0058, code lost:
        
            if (r5.this$0.processFramePacket((androidx.media3.effect.GlTextureFrame) ((androidx.media3.effect.PacketConsumer.Packet.Payload) r6).getPayload(), r5) == r0) goto L30;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x007b, code lost:
        
            if (r1.queuePacket(androidx.media3.effect.PacketConsumer.Packet.EndOfStream.INSTANCE, r5) == r0) goto L30;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x007d, code lost:
        
            return r0;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
            /*
                r5 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r5.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L1b
                if (r1 == r3) goto L17
                if (r1 != r2) goto Lf
                goto L17
            Lf:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L17:
                kotlin.ResultKt.throwOnFailure(r6)
                goto L7e
            L1b:
                kotlin.ResultKt.throwOnFailure(r6)
                androidx.media3.effect.GlShaderProgramPacketProcessor r6 = androidx.media3.effect.GlShaderProgramPacketProcessor.this
                java.util.concurrent.atomic.AtomicBoolean r6 = androidx.media3.effect.GlShaderProgramPacketProcessor.access$isReleased$p(r6)
                boolean r6 = r6.get()
                r1 = 0
                if (r6 == 0) goto L3f
                androidx.media3.effect.PacketConsumer$Packet<androidx.media3.effect.GlTextureFrame> r5 = r5.$packet
                boolean r6 = r5 instanceof androidx.media3.effect.PacketConsumer.Packet.Payload
                if (r6 == 0) goto L3c
                androidx.media3.effect.PacketConsumer$Packet$Payload r5 = (androidx.media3.effect.PacketConsumer.Packet.Payload) r5
                java.lang.Object r5 = r5.getPayload()
                androidx.media3.effect.GlTextureFrame r5 = (androidx.media3.effect.GlTextureFrame) r5
                r5.release(r1)
            L3c:
                kotlin.Unit r5 = kotlin.Unit.INSTANCE
                return r5
            L3f:
                androidx.media3.effect.PacketConsumer$Packet<androidx.media3.effect.GlTextureFrame> r6 = r5.$packet
                boolean r4 = r6 instanceof androidx.media3.effect.PacketConsumer.Packet.Payload
                if (r4 == 0) goto L5b
                androidx.media3.effect.GlShaderProgramPacketProcessor r1 = androidx.media3.effect.GlShaderProgramPacketProcessor.this
                androidx.media3.effect.PacketConsumer$Packet$Payload r6 = (androidx.media3.effect.PacketConsumer.Packet.Payload) r6
                java.lang.Object r6 = r6.getPayload()
                androidx.media3.effect.GlTextureFrame r6 = (androidx.media3.effect.GlTextureFrame) r6
                r2 = r5
                kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                r5.label = r3
                java.lang.Object r5 = androidx.media3.effect.GlShaderProgramPacketProcessor.access$processFramePacket(r1, r6, r2)
                if (r5 != r0) goto L7e
                goto L7d
            L5b:
                boolean r6 = r6 instanceof androidx.media3.effect.PacketConsumer.Packet.EndOfStream
                if (r6 == 0) goto L81
                androidx.media3.effect.GlShaderProgramPacketProcessor r6 = androidx.media3.effect.GlShaderProgramPacketProcessor.this
                androidx.media3.effect.PacketConsumer r6 = androidx.media3.effect.GlShaderProgramPacketProcessor.access$getOutputConsumer$p(r6)
                if (r6 != 0) goto L6d
                java.lang.String r6 = "outputConsumer"
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r6)
                goto L6e
            L6d:
                r1 = r6
            L6e:
                androidx.media3.effect.PacketConsumer$Packet$EndOfStream r6 = androidx.media3.effect.PacketConsumer.Packet.EndOfStream.INSTANCE
                androidx.media3.effect.PacketConsumer$Packet r6 = (androidx.media3.effect.PacketConsumer.Packet) r6
                r3 = r5
                kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
                r5.label = r2
                java.lang.Object r5 = r1.queuePacket(r6, r3)
                if (r5 != r0) goto L7e
            L7d:
                return r0
            L7e:
                kotlin.Unit r5 = kotlin.Unit.INSTANCE
                return r5
            L81:
                kotlin.NoWhenBranchMatchedException r5 = new kotlin.NoWhenBranchMatchedException
                r5.<init>()
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.media3.effect.GlShaderProgramPacketProcessor.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Override // androidx.media3.effect.PacketConsumer
    public Object queuePacket(PacketConsumer.Packet<? extends GlTextureFrame> packet, Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(this.glThreadDispatcher, new AnonymousClass2(packet, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:44:0x00b6 A[Catch: all -> 0x0059, Exception -> 0x00de, TryCatch #0 {Exception -> 0x00de, blocks: (B:42:0x00b2, B:44:0x00b6, B:45:0x00bc), top: B:62:0x00b2 }] */
    /* JADX WARN: Code duplicated, block: B:48:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:54:0x00e5 A[Catch: all -> 0x003e, TRY_ENTER, TryCatch #3 {all -> 0x003e, blocks: (B:14:0x0039, B:54:0x00e5, B:55:0x00e8), top: B:64:0x0025 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v2, types: [androidx.media3.effect.GlShaderProgramPacketProcessor$processFramePacket$1, kotlin.coroutines.Continuation] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final Object processFramePacket(GlTextureFrame glTextureFrame, Continuation<? super Unit> continuation) throws Throwable {
        GlShaderProgramPacketProcessor anonymousClass1;
        GlTextureFrame glTextureFrame2;
        GlTextureFrame glTextureFrame3;
        PacketConsumer<GlTextureFrame> packetConsumer;
        PacketConsumer packetConsumer2;
        PacketConsumer.Packet packetOf;
        GlShaderProgramPacketProcessor glShaderProgramPacketProcessor;
        if (continuation instanceof AnonymousClass1) {
            AnonymousClass1 anonymousClass2 = (AnonymousClass1) continuation;
            if ((anonymousClass2.label & Integer.MIN_VALUE) != 0) {
                anonymousClass2.label -= Integer.MIN_VALUE;
                anonymousClass1 = anonymousClass2;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object objAwait = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        try {
            try {
                try {
                    if (i == 0) {
                        ResultKt.throwOnFailure(objAwait);
                        if (this.outputFrameDeferred != null) {
                            throw new IllegalStateException("Frame processing already in progress".toString());
                        }
                        if (this.currentInputFrame != null) {
                            throw new IllegalStateException("currentInputFrame not null".toString());
                        }
                        ReceiveChannel receiveChannel = this.inputCapacityChannel;
                        anonymousClass1.L$0 = this;
                        anonymousClass1.L$1 = glTextureFrame;
                        anonymousClass1.label = 1;
                        if (receiveChannel.receive(anonymousClass1) != coroutine_suspended) {
                        }
                        return coroutine_suspended;
                    }
                    if (i != 1) {
                        if (i != 2) {
                            if (i != 3) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            glTextureFrame2 = (GlTextureFrame) anonymousClass1.L$2;
                            glTextureFrame = (GlTextureFrame) anonymousClass1.L$1;
                            glShaderProgramPacketProcessor = (GlShaderProgramPacketProcessor) anonymousClass1.L$0;
                            try {
                                ResultKt.throwOnFailure(objAwait);
                                glTextureFrame.release(null);
                                glShaderProgramPacketProcessor.currentInputFrame = null;
                                glShaderProgramPacketProcessor.currentInputMetadata = null;
                                glShaderProgramPacketProcessor.outputFrameDeferred = null;
                                return Unit.INSTANCE;
                            } catch (Exception e) {
                                e = e;
                                if (glTextureFrame2 != null) {
                                    glTextureFrame2.release(null);
                                }
                                throw e;
                            }
                        }
                        glTextureFrame = (GlTextureFrame) anonymousClass1.L$1;
                        this = (GlShaderProgramPacketProcessor) anonymousClass1.L$0;
                        ResultKt.throwOnFailure(objAwait);
                        glTextureFrame3 = (GlTextureFrame) objAwait;
                        try {
                            packetConsumer = this.outputConsumer;
                            packetConsumer2 = packetConsumer;
                            if (packetConsumer == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("outputConsumer");
                                packetConsumer2 = 0;
                            }
                            packetOf = PacketConsumer.Packet.INSTANCE.of(glTextureFrame3);
                            anonymousClass1.L$0 = this;
                            anonymousClass1.L$1 = glTextureFrame;
                            anonymousClass1.L$2 = glTextureFrame3;
                            anonymousClass1.label = 3;
                            if (packetConsumer2.queuePacket(packetOf, anonymousClass1) != coroutine_suspended) {
                                glShaderProgramPacketProcessor = this;
                                glTextureFrame.release(null);
                                glShaderProgramPacketProcessor.currentInputFrame = null;
                                glShaderProgramPacketProcessor.currentInputMetadata = null;
                                glShaderProgramPacketProcessor.outputFrameDeferred = null;
                                return Unit.INSTANCE;
                            }
                            return coroutine_suspended;
                        } catch (Exception e2) {
                            glTextureFrame2 = glTextureFrame3;
                            e = e2;
                            if (glTextureFrame2 != null) {
                                glTextureFrame2.release(null);
                            }
                            throw e;
                        }
                    }
                    glTextureFrame = (GlTextureFrame) anonymousClass1.L$1;
                    this = (GlShaderProgramPacketProcessor) anonymousClass1.L$0;
                    ResultKt.throwOnFailure(objAwait);
                    this.currentInputFrame = glTextureFrame;
                    this.currentInputMetadata = glTextureFrame.getMetadata();
                    CompletableDeferred<GlTextureFrame> completableDeferredCompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
                    this.outputFrameDeferred = completableDeferredCompletableDeferred$default;
                    this.shaderProgram.queueInputFrame(this.glObjectsProvider, glTextureFrame.glTextureInfo, glTextureFrame.presentationTimeUs);
                    anonymousClass1.L$0 = this;
                    anonymousClass1.L$1 = glTextureFrame;
                    anonymousClass1.label = 2;
                    objAwait = completableDeferredCompletableDeferred$default.await(anonymousClass1);
                    if (objAwait != coroutine_suspended) {
                        glTextureFrame3 = (GlTextureFrame) objAwait;
                        packetConsumer = this.outputConsumer;
                        packetConsumer2 = packetConsumer;
                        if (packetConsumer == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("outputConsumer");
                            packetConsumer2 = 0;
                        }
                        packetOf = PacketConsumer.Packet.INSTANCE.of(glTextureFrame3);
                        anonymousClass1.L$0 = this;
                        anonymousClass1.L$1 = glTextureFrame;
                        anonymousClass1.L$2 = glTextureFrame3;
                        anonymousClass1.label = 3;
                        if (packetConsumer2.queuePacket(packetOf, anonymousClass1) != coroutine_suspended) {
                            glShaderProgramPacketProcessor = this;
                            glTextureFrame.release(null);
                            glShaderProgramPacketProcessor.currentInputFrame = null;
                            glShaderProgramPacketProcessor.currentInputMetadata = null;
                            glShaderProgramPacketProcessor.outputFrameDeferred = null;
                            return Unit.INSTANCE;
                        }
                    }
                    return coroutine_suspended;
                } catch (Exception e3) {
                    e = e3;
                    glTextureFrame2 = null;
                }
            } catch (Throwable th) {
                anonymousClass1 = this;
                th = th;
                glTextureFrame.release(null);
                anonymousClass1.currentInputFrame = null;
                anonymousClass1.currentInputMetadata = null;
                anonymousClass1.outputFrameDeferred = null;
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            glTextureFrame.release(null);
            anonymousClass1.currentInputFrame = null;
            anonymousClass1.currentInputMetadata = null;
            anonymousClass1.outputFrameDeferred = null;
            throw th;
        }
    }

    @Override // androidx.media3.effect.PacketProcessor
    public void setOutput(PacketConsumer<GlTextureFrame> output) {
        Intrinsics.checkNotNullParameter(output, "output");
        this.outputConsumer = output;
    }

    /* JADX INFO: renamed from: androidx.media3.effect.GlShaderProgramPacketProcessor$release$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: GlShaderProgramPacketProcessor.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.media3.effect.GlShaderProgramPacketProcessor$release$2", f = "GlShaderProgramPacketProcessor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C08292 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        int label;

        C08292(Continuation<? super C08292> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return GlShaderProgramPacketProcessor.this.new C08292(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
            return ((C08292) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws VideoFrameProcessingException {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                CompletableDeferred completableDeferred = GlShaderProgramPacketProcessor.this.outputFrameDeferred;
                if (completableDeferred != null) {
                    JobKt__JobKt.cancel$default(completableDeferred, "Processor released", null, 2, null);
                }
                GlShaderProgramPacketProcessor.this.outputFrameDeferred = null;
                GlTextureFrame glTextureFrame = GlShaderProgramPacketProcessor.this.currentInputFrame;
                if (glTextureFrame != null) {
                    glTextureFrame.release(null);
                }
                GlShaderProgramPacketProcessor.this.currentInputFrame = null;
                GlShaderProgramPacketProcessor.this.currentInputMetadata = null;
                GlShaderProgramPacketProcessor.this.shaderProgram.release();
                return Boxing.boxBoolean(SendChannel.DefaultImpls.close$default(GlShaderProgramPacketProcessor.this.inputCapacityChannel, null, 1, null));
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // androidx.media3.effect.PacketConsumer
    public Object release(Continuation<? super Unit> continuation) {
        Object objWithContext;
        return (this.isReleased.compareAndSet(false, true) && (objWithContext = BuildersKt.withContext(this.glThreadDispatcher, new C08292(null), continuation)) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) ? objWithContext : Unit.INSTANCE;
    }

    @Override // androidx.media3.effect.GlShaderProgram.InputListener
    public void onReadyToAcceptInputFrame() {
        this.inputCapacityChannel.mo11206trySendJP2dKIU(Unit.INSTANCE);
    }

    @Override // androidx.media3.effect.GlShaderProgram.OutputListener
    public void onOutputFrameAvailable(final GlTextureInfo outputTexture, long presentationTimeUs) {
        Intrinsics.checkNotNullParameter(outputTexture, "outputTexture");
        if (this.isReleased.get()) {
            this.shaderProgram.releaseOutputFrame(outputTexture);
            return;
        }
        CompletableDeferred<GlTextureFrame> completableDeferred = this.outputFrameDeferred;
        if (completableDeferred == null) {
            this.shaderProgram.releaseOutputFrame(outputTexture);
            return;
        }
        Frame.Metadata metadata = this.currentInputMetadata;
        GlTextureFrame glTextureFrame = this.currentInputFrame;
        if (glTextureFrame == null || metadata == null) {
            completableDeferred.completeExceptionally(new VideoFrameProcessingException("Missing input frame/metadata for output at " + presentationTimeUs));
            return;
        }
        GlTextureFrame glTextureFrameBuild = new GlTextureFrame.Builder(outputTexture, ExecutorsKt.asExecutor(this.glThreadDispatcher), new Consumer() { // from class: androidx.media3.effect.GlShaderProgramPacketProcessor$$ExternalSyntheticLambda1
            @Override // androidx.media3.common.util.Consumer
            public final void accept(Object obj) {
                GlShaderProgramPacketProcessor.onOutputFrameAvailable$lambda$3(this.f$0, outputTexture, (GlTextureInfo) obj);
            }
        }).setPresentationTimeUs(presentationTimeUs).setFormat(glTextureFrame.format).setMetadata(metadata).setReleaseTimeNs(glTextureFrame.releaseTimeNs).setFenceSync(glTextureFrame.fenceSync).build();
        Intrinsics.checkNotNull(glTextureFrameBuild);
        if (!completableDeferred.complete(glTextureFrameBuild)) {
            throw new IllegalStateException("Check failed.".toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onOutputFrameAvailable$lambda$3(GlShaderProgramPacketProcessor glShaderProgramPacketProcessor, GlTextureInfo glTextureInfo, GlTextureInfo glTextureInfo2) {
        Intrinsics.checkNotNullParameter(glTextureInfo2, "<unused var>");
        glShaderProgramPacketProcessor.shaderProgram.releaseOutputFrame(glTextureInfo);
    }

    /* JADX INFO: compiled from: GlShaderProgramPacketProcessor.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0086@¢\u0006\u0002\u0010\fJ$\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000b¨\u0006\u0011"}, d2 = {"Landroidx/media3/effect/GlShaderProgramPacketProcessor$Companion;", "", "<init>", "()V", PasskeyWebListener.CREATE_UNIQUE_KEY, "Landroidx/media3/effect/GlShaderProgramPacketProcessor;", "shaderProgram", "Landroidx/media3/effect/GlShaderProgram;", "glThreadDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "glObjectsProvider", "Landroidx/media3/common/GlObjectsProvider;", "(Landroidx/media3/effect/GlShaderProgram;Lkotlinx/coroutines/CoroutineDispatcher;Landroidx/media3/common/GlObjectsProvider;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createAsync", "Lcom/google/common/util/concurrent/ListenableFuture;", "glThreadExecutorService", "Ljava/util/concurrent/ExecutorService;", "lib-effect_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Object create(GlShaderProgram glShaderProgram, CoroutineDispatcher coroutineDispatcher, GlObjectsProvider glObjectsProvider, Continuation<? super GlShaderProgramPacketProcessor> continuation) {
            return BuildersKt.withContext(coroutineDispatcher, new GlShaderProgramPacketProcessor$Companion$create$2(coroutineDispatcher, glShaderProgram, glObjectsProvider, null), continuation);
        }

        public final ListenableFuture<GlShaderProgramPacketProcessor> createAsync(GlShaderProgram shaderProgram, ExecutorService glThreadExecutorService, GlObjectsProvider glObjectsProvider) {
            Intrinsics.checkNotNullParameter(shaderProgram, "shaderProgram");
            Intrinsics.checkNotNullParameter(glThreadExecutorService, "glThreadExecutorService");
            Intrinsics.checkNotNullParameter(glObjectsProvider, "glObjectsProvider");
            ExecutorCoroutineDispatcher executorCoroutineDispatcherFrom = ExecutorsKt.from(glThreadExecutorService);
            return ListenableFutureKt.future$default(CoroutineScopeKt.CoroutineScope(executorCoroutineDispatcherFrom), null, null, new GlShaderProgramPacketProcessor$Companion$createAsync$1(shaderProgram, executorCoroutineDispatcherFrom, glObjectsProvider, null), 3, null);
        }
    }
}
