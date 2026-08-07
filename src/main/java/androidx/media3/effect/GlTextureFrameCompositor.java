package androidx.media3.effect;

import android.content.Context;
import androidx.media3.common.GlObjectsProvider;
import androidx.media3.common.GlTextureInfo;
import androidx.media3.common.VideoCompositorSettings;
import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.GlUtil;
import androidx.media3.common.util.Size;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.ExecutorsKt;

/* JADX INFO: compiled from: GlTextureFrameCompositor.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0004B+\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\"\u0010\u0018\u001a\u00020\u00192\u0012\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u001bH\u0096@¢\u0006\u0002\u0010\u001cJ\u0016\u0010\u001d\u001a\u00020\u00192\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00030\u0001H\u0016J\u000e\u0010\u001f\u001a\u00020\u0019H\u0096@¢\u0006\u0002\u0010 J$\u0010!\u001a\u00020\u00032\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00190$H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Landroidx/media3/effect/GlTextureFrameCompositor;", "Landroidx/media3/effect/PacketConsumer;", "", "Landroidx/media3/effect/GlTextureFrame;", "Landroidx/media3/effect/PacketProcessor;", "context", "Landroid/content/Context;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "glObjectsProvider", "Landroidx/media3/common/GlObjectsProvider;", "videoCompositorSettings", "Landroidx/media3/common/VideoCompositorSettings;", "<init>", "(Landroid/content/Context;Lkotlinx/coroutines/CoroutineDispatcher;Landroidx/media3/common/GlObjectsProvider;Landroidx/media3/common/VideoCompositorSettings;)V", "getVideoCompositorSettings", "()Landroidx/media3/common/VideoCompositorSettings;", "setVideoCompositorSettings", "(Landroidx/media3/common/VideoCompositorSettings;)V", "glProgram", "Landroidx/media3/effect/DefaultCompositorGlProgram;", "outputTexturePool", "Landroidx/media3/effect/TexturePool;", "outputConsumer", "queuePacket", "", "packet", "Landroidx/media3/effect/PacketConsumer$Packet;", "(Landroidx/media3/effect/PacketConsumer$Packet;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setOutput", "output", "release", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "compositeFrames", "frames", "frameComposited", "Lkotlinx/coroutines/CompletableDeferred;", "lib-effect_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class GlTextureFrameCompositor implements PacketConsumer<List<? extends GlTextureFrame>>, PacketProcessor<List<? extends GlTextureFrame>, GlTextureFrame> {
    private final CoroutineDispatcher dispatcher;
    private final GlObjectsProvider glObjectsProvider;
    private final DefaultCompositorGlProgram glProgram;
    private volatile PacketConsumer<GlTextureFrame> outputConsumer;
    private final TexturePool outputTexturePool;
    private volatile VideoCompositorSettings videoCompositorSettings;

    public GlTextureFrameCompositor(Context context, CoroutineDispatcher dispatcher, GlObjectsProvider glObjectsProvider, VideoCompositorSettings videoCompositorSettings) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics.checkNotNullParameter(glObjectsProvider, "glObjectsProvider");
        this.dispatcher = dispatcher;
        this.glObjectsProvider = glObjectsProvider;
        this.videoCompositorSettings = videoCompositorSettings;
        this.glProgram = new DefaultCompositorGlProgram(context);
        this.outputTexturePool = new TexturePool(false, 1);
    }

    public /* synthetic */ GlTextureFrameCompositor(Context context, CoroutineDispatcher coroutineDispatcher, GlObjectsProvider glObjectsProvider, VideoCompositorSettings videoCompositorSettings, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, coroutineDispatcher, glObjectsProvider, (i & 8) != 0 ? null : videoCompositorSettings);
    }

    public final VideoCompositorSettings getVideoCompositorSettings() {
        return this.videoCompositorSettings;
    }

    public final void setVideoCompositorSettings(VideoCompositorSettings videoCompositorSettings) {
        this.videoCompositorSettings = videoCompositorSettings;
    }

    /* JADX INFO: renamed from: androidx.media3.effect.GlTextureFrameCompositor$queuePacket$2, reason: invalid class name */
    /* JADX INFO: compiled from: GlTextureFrameCompositor.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.media3.effect.GlTextureFrameCompositor$queuePacket$2", f = "GlTextureFrameCompositor.kt", i = {0, 0, 0, 1, 1}, l = {70, 71, 82}, m = "invokeSuspend", n = {"frames", "compositedFrame", "frameComposited", "frames", "compositedFrame"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1"})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PacketConsumer.Packet<List<GlTextureFrame>> $packet;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ GlTextureFrameCompositor this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(PacketConsumer.Packet<? extends List<? extends GlTextureFrame>> packet, GlTextureFrameCompositor glTextureFrameCompositor, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$packet = packet;
            this.this$0 = glTextureFrameCompositor;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$packet, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:35:0x00a0  */
        /* JADX WARN: Code duplicated, block: B:48:0x00c9 A[Catch: all -> 0x002c, TryCatch #5 {all -> 0x002c, blocks: (B:11:0x0027, B:36:0x00a2, B:46:0x00c3, B:48:0x00c9, B:49:0x00cc), top: B:66:0x0027 }] */
        /* JADX WARN: Code duplicated, block: B:53:0x00d7 A[LOOP:1: B:51:0x00d1->B:53:0x00d7, LOOP_END] */
        /* JADX WARN: Code restructure failed: missing block: B:60:0x00fb, code lost:
        
            if (r11.queuePacket(androidx.media3.effect.PacketConsumer.Packet.EndOfStream.INSTANCE, r10) == r0) goto L61;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v1, types: [T, androidx.media3.effect.GlTextureFrame] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r11) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 263
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.media3.effect.GlTextureFrameCompositor.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Override // androidx.media3.effect.PacketConsumer
    public Object queuePacket(PacketConsumer.Packet<? extends List<? extends GlTextureFrame>> packet, Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(this.dispatcher, new AnonymousClass2(packet, this, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    @Override // androidx.media3.effect.PacketProcessor
    public void setOutput(PacketConsumer<GlTextureFrame> output) {
        Intrinsics.checkNotNullParameter(output, "output");
        this.outputConsumer = output;
    }

    /* JADX INFO: renamed from: androidx.media3.effect.GlTextureFrameCompositor$release$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: GlTextureFrameCompositor.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.media3.effect.GlTextureFrameCompositor$release$2", f = "GlTextureFrameCompositor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C08302 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C08302(Continuation<? super C08302> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return GlTextureFrameCompositor.this.new C08302(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C08302) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            GlTextureFrameCompositor.this.glProgram.release();
            return Unit.INSTANCE;
        }
    }

    @Override // androidx.media3.effect.PacketConsumer
    public Object release(Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(this.dispatcher, new C08302(null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GlTextureFrame compositeFrames(List<? extends GlTextureFrame> frames, final CompletableDeferred<Unit> frameComposited) throws VideoFrameProcessingException, GlUtil.GlException {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i = 0;
        for (Object obj : frames) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            GlTextureFrame glTextureFrame = (GlTextureFrame) obj;
            GlTextureInfo glTextureInfo = glTextureFrame.glTextureInfo;
            Intrinsics.checkNotNullExpressionValue(glTextureInfo, "glTextureInfo");
            arrayList.add(new Size(glTextureInfo.width, glTextureInfo.height));
            VideoCompositorSettings videoCompositorSettings = this.videoCompositorSettings;
            if (videoCompositorSettings != null) {
                arrayList2.add(new DefaultCompositorGlProgram.InputFrameInfo(glTextureInfo, videoCompositorSettings.getOverlaySettings(i, glTextureFrame.presentationTimeUs)));
                i = i2;
            } else {
                throw new IllegalStateException("Required value was null.".toString());
            }
        }
        VideoCompositorSettings videoCompositorSettings2 = this.videoCompositorSettings;
        if (videoCompositorSettings2 == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        Size outputSize = videoCompositorSettings2.getOutputSize(arrayList);
        Intrinsics.checkNotNullExpressionValue(outputSize, "getOutputSize(...)");
        this.outputTexturePool.ensureConfigured(this.glObjectsProvider, outputSize.getWidth(), outputSize.getHeight());
        GlTextureInfo glTextureInfoUseTexture = this.outputTexturePool.useTexture();
        this.glProgram.drawFrame(arrayList2, glTextureInfoUseTexture);
        GlTextureFrame glTextureFrameBuild = new GlTextureFrame.Builder(glTextureInfoUseTexture, ExecutorsKt.asExecutor(this.dispatcher), new Consumer() { // from class: androidx.media3.effect.GlTextureFrameCompositor$$ExternalSyntheticLambda0
            @Override // androidx.media3.common.util.Consumer
            public final void accept(Object obj2) {
                GlTextureFrameCompositor.compositeFrames$lambda$1(this.f$0, frameComposited, (GlTextureInfo) obj2);
            }
        }).setMetadata(frames.get(0).getMetadata()).setFormat(frames.get(0).format).setPresentationTimeUs(frames.get(0).presentationTimeUs).setReleaseTimeNs(frames.get(0).releaseTimeNs).build();
        Intrinsics.checkNotNullExpressionValue(glTextureFrameBuild, "build(...)");
        return glTextureFrameBuild;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void compositeFrames$lambda$1(GlTextureFrameCompositor glTextureFrameCompositor, CompletableDeferred completableDeferred, GlTextureInfo glTextureInfo) {
        Intrinsics.checkNotNullParameter(glTextureInfo, "glTextureInfo");
        glTextureFrameCompositor.outputTexturePool.freeTexture(glTextureInfo);
        completableDeferred.complete(Unit.INSTANCE);
    }
}
