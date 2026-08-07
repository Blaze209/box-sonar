package androidx.compose.material3.internal;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.animation.core.RepeatMode;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.unit.Dp;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: CircularWavyProgressModifiers.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\"\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ\b\u0010,\u001a\u00020-H$J\b\u0010.\u001a\u00020-H$J\b\u0010/\u001a\u000200H$J9\u0010Q\u001a\u0004\u0018\u00010R2\u0006\u0010S\u001a\u00020?2\u0006\u0010&\u001a\u00020?2\u0006\u0010T\u001a\u00020?2\u0006\u0010U\u001a\u00020V2\u0006\u0010W\u001a\u00020RH\u0004¢\u0006\u0004\bX\u0010YJ?\u0010Z\u001a\u00020R2\u0006\u0010S\u001a\u00020?2\u0006\u0010&\u001a\u00020?2\u0006\u0010T\u001a\u00020?2\u0006\u0010U\u001a\u00020V2\u0006\u0010[\u001a\u0002002\u0006\u0010W\u001a\u00020RH\u0004¢\u0006\u0004\b\\\u0010]J\b\u0010^\u001a\u00020-H\u0004J\b\u0010_\u001a\u00020-H\u0004R&\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003@FX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R&\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003@FX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013R$\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001cR&\u0010 \u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t@FX\u0086\u000e¢\u0006\u0010\n\u0002\u0010%\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R&\u0010&\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t@FX\u0086\u000e¢\u0006\u0010\n\u0002\u0010%\u001a\u0004\b'\u0010\"\"\u0004\b(\u0010$R&\u0010)\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t@FX\u0086\u000e¢\u0006\u0010\n\u0002\u0010%\u001a\u0004\b*\u0010\"\"\u0004\b+\u0010$R\u0014\u00101\u001a\u000202X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0014\u00105\u001a\u000206X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0014\u00109\u001a\u00020:X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R(\u0010=\u001a\u0010\u0012\u0004\u0012\u00020?\u0012\u0004\u0012\u00020@\u0018\u00010>X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u001c\u0010E\u001a\u0004\u0018\u00010FX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u001a\u0010K\u001a\u00020LX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010N\"\u0004\bO\u0010P¨\u0006`"}, d2 = {"Landroidx/compose/material3/internal/BaseCircularWavyProgressNode;", "Landroidx/compose/ui/node/DelegatingNode;", "colorParameter", "Landroidx/compose/ui/graphics/Color;", "trackColorParameter", "strokeParameter", "Landroidx/compose/ui/graphics/drawscope/Stroke;", "trackStrokeParameter", "gapSizeParameter", "Landroidx/compose/ui/unit/Dp;", "wavelengthParameter", "waveSpeedParameter", "<init>", "(JJLandroidx/compose/ui/graphics/drawscope/Stroke;Landroidx/compose/ui/graphics/drawscope/Stroke;FFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "value", "color", "getColor-0d7_KjU", "()J", "setColor-8_81llA", "(J)V", "J", "trackColor", "getTrackColor-0d7_KjU", "setTrackColor-8_81llA", "stroke", "getStroke", "()Landroidx/compose/ui/graphics/drawscope/Stroke;", "setStroke", "(Landroidx/compose/ui/graphics/drawscope/Stroke;)V", "trackStroke", "getTrackStroke", "setTrackStroke", "gapSize", "getGapSize-D9Ej5fM", "()F", "setGapSize-0680j_4", "(F)V", "F", "wavelength", "getWavelength-D9Ej5fM", "setWavelength-0680j_4", "waveSpeed", "getWaveSpeed-D9Ej5fM", "setWaveSpeed-0680j_4", "invalidateDraw", "", "invalidateDrawCache", "isDrawingWave", "", "circularShapes", "Landroidx/compose/material3/internal/CircularShapes;", "getCircularShapes", "()Landroidx/compose/material3/internal/CircularShapes;", "progressDrawingCache", "Landroidx/compose/material3/internal/CircularProgressDrawingCache;", "getProgressDrawingCache", "()Landroidx/compose/material3/internal/CircularProgressDrawingCache;", "waveOffsetState", "Landroidx/compose/runtime/MutableFloatState;", "getWaveOffsetState", "()Landroidx/compose/runtime/MutableFloatState;", "offsetAnimatable", "Landroidx/compose/animation/core/Animatable;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "getOffsetAnimatable", "()Landroidx/compose/animation/core/Animatable;", "setOffsetAnimatable", "(Landroidx/compose/animation/core/Animatable;)V", "offsetAnimationJob", "Lkotlinx/coroutines/Job;", "getOffsetAnimationJob", "()Lkotlinx/coroutines/Job;", "setOffsetAnimationJob", "(Lkotlinx/coroutines/Job;)V", "vertexCountForCurrentAnimation", "", "getVertexCountForCurrentAnimation", "()I", "setVertexCountForCurrentAnimation", "(I)V", "trackPathProvider", "Landroidx/compose/ui/graphics/Path;", "amplitude", "strokeWidth", "size", "Landroidx/compose/ui/geometry/Size;", "path", "trackPathProvider-yzxVdVo", "(FFFJLandroidx/compose/ui/graphics/Path;)Landroidx/compose/ui/graphics/Path;", "progressPathProvider", "supportMotion", "progressPathProvider-wzdHmys", "(FFFJZLandroidx/compose/ui/graphics/Path;)Landroidx/compose/ui/graphics/Path;", "startOffsetAnimation", "stopOffsetAnimation", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
abstract class BaseCircularWavyProgressNode extends DelegatingNode {
    private final CircularShapes circularShapes;
    private long color;
    private float gapSize;
    private Animatable<Float, AnimationVector1D> offsetAnimatable;
    private Job offsetAnimationJob;
    private final CircularProgressDrawingCache progressDrawingCache;
    private Stroke stroke;
    private long trackColor;
    private Stroke trackStroke;
    private int vertexCountForCurrentAnimation;
    private final MutableFloatState waveOffsetState;
    private float waveSpeed;
    private float wavelength;

    public /* synthetic */ BaseCircularWavyProgressNode(long j, long j2, Stroke stroke, Stroke stroke2, float f, float f2, float f3, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, stroke, stroke2, f, f2, f3);
    }

    protected abstract void invalidateDraw();

    protected abstract void invalidateDrawCache();

    protected abstract boolean isDrawingWave();

    private BaseCircularWavyProgressNode(long j, long j2, Stroke stroke, Stroke stroke2, float f, float f2, float f3) {
        this.color = j;
        this.trackColor = j2;
        this.stroke = stroke;
        this.trackStroke = stroke2;
        this.gapSize = f;
        this.wavelength = f2;
        this.waveSpeed = f3;
        this.circularShapes = new CircularShapes();
        this.progressDrawingCache = new CircularProgressDrawingCache();
        this.waveOffsetState = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
        this.vertexCountForCurrentAnimation = -1;
    }

    /* JADX INFO: renamed from: getColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getColor() {
        return this.color;
    }

    /* JADX INFO: renamed from: setColor-8_81llA, reason: not valid java name */
    public final void m4920setColor8_81llA(long j) {
        if (Color.m6815equalsimpl0(this.color, j)) {
            return;
        }
        this.color = j;
        invalidateDraw();
    }

    /* JADX INFO: renamed from: getTrackColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getTrackColor() {
        return this.trackColor;
    }

    /* JADX INFO: renamed from: setTrackColor-8_81llA, reason: not valid java name */
    public final void m4922setTrackColor8_81llA(long j) {
        if (Color.m6815equalsimpl0(this.trackColor, j)) {
            return;
        }
        this.trackColor = j;
        invalidateDraw();
    }

    public final Stroke getStroke() {
        return this.stroke;
    }

    public final void setStroke(Stroke stroke) {
        if (Intrinsics.areEqual(this.stroke, stroke)) {
            return;
        }
        this.stroke = stroke;
        invalidateDrawCache();
    }

    public final Stroke getTrackStroke() {
        return this.trackStroke;
    }

    public final void setTrackStroke(Stroke stroke) {
        if (Intrinsics.areEqual(this.trackStroke, stroke)) {
            return;
        }
        this.trackStroke = stroke;
        invalidateDrawCache();
    }

    /* JADX INFO: renamed from: getGapSize-D9Ej5fM, reason: not valid java name and from getter */
    public final float getGapSize() {
        return this.gapSize;
    }

    /* JADX INFO: renamed from: setGapSize-0680j_4, reason: not valid java name */
    public final void m4921setGapSize0680j_4(float f) {
        if (Dp.m9692equalsimpl0(this.gapSize, f)) {
            return;
        }
        this.gapSize = f;
        invalidateDrawCache();
    }

    /* JADX INFO: renamed from: getWavelength-D9Ej5fM, reason: not valid java name and from getter */
    public final float getWavelength() {
        return this.wavelength;
    }

    /* JADX INFO: renamed from: setWavelength-0680j_4, reason: not valid java name */
    public final void m4924setWavelength0680j_4(float f) {
        if (Dp.m9692equalsimpl0(this.wavelength, f)) {
            return;
        }
        this.wavelength = f;
        startOffsetAnimation();
    }

    /* JADX INFO: renamed from: getWaveSpeed-D9Ej5fM, reason: not valid java name and from getter */
    public final float getWaveSpeed() {
        return this.waveSpeed;
    }

    /* JADX INFO: renamed from: setWaveSpeed-0680j_4, reason: not valid java name */
    public final void m4923setWaveSpeed0680j_4(float f) {
        if (Dp.m9692equalsimpl0(this.waveSpeed, f)) {
            return;
        }
        this.waveSpeed = f;
        startOffsetAnimation();
    }

    protected final CircularShapes getCircularShapes() {
        return this.circularShapes;
    }

    protected final CircularProgressDrawingCache getProgressDrawingCache() {
        return this.progressDrawingCache;
    }

    protected final MutableFloatState getWaveOffsetState() {
        return this.waveOffsetState;
    }

    protected final Animatable<Float, AnimationVector1D> getOffsetAnimatable() {
        return this.offsetAnimatable;
    }

    protected final void setOffsetAnimatable(Animatable<Float, AnimationVector1D> animatable) {
        this.offsetAnimatable = animatable;
    }

    protected final Job getOffsetAnimationJob() {
        return this.offsetAnimationJob;
    }

    protected final void setOffsetAnimationJob(Job job) {
        this.offsetAnimationJob = job;
    }

    protected final int getVertexCountForCurrentAnimation() {
        return this.vertexCountForCurrentAnimation;
    }

    protected final void setVertexCountForCurrentAnimation(int i) {
        this.vertexCountForCurrentAnimation = i;
    }

    /* JADX INFO: renamed from: trackPathProvider-yzxVdVo, reason: not valid java name */
    protected final Path m4925trackPathProvideryzxVdVo(float amplitude, float wavelength, float strokeWidth, long size, Path path) {
        return this.circularShapes.getTrackPath(path);
    }

    /* JADX INFO: renamed from: progressPathProvider-wzdHmys, reason: not valid java name */
    protected final Path m4919progressPathProviderwzdHmys(float amplitude, float wavelength, float strokeWidth, long size, boolean supportMotion, Path path) {
        return CircularShapes.getProgressPath$default(this.circularShapes, amplitude, path, supportMotion, 0.0f, 0.0f, 24, null);
    }

    protected final void startOffsetAnimation() {
        int i;
        stopOffsetAnimation();
        if (getIsAttached() && CoroutineScopeKt.isActive(getCoroutineScope()) && isDrawingWave()) {
            float f = 0;
            if (Dp.m9686compareTo0680j_4(this.waveSpeed, Dp.m9687constructorimpl(f)) > 0 && Dp.m9686compareTo0680j_4(this.wavelength, Dp.m9687constructorimpl(f)) > 0 && (i = this.vertexCountForCurrentAnimation) > 0) {
                int iCoerceAtLeast = RangesKt.coerceAtLeast(Math.round((this.wavelength / this.waveSpeed) * 1000 * i), 50);
                float floatValue = this.waveOffsetState.getFloatValue();
                this.offsetAnimatable = AnimatableKt.Animatable$default(floatValue, 0.0f, 2, null);
                this.offsetAnimationJob = BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new AnonymousClass1(floatValue, iCoerceAtLeast, null), 3, null);
                return;
            }
            this.waveOffsetState.setFloatValue(0.0f);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.internal.BaseCircularWavyProgressNode$startOffsetAnimation$1, reason: invalid class name */
    /* JADX INFO: compiled from: CircularWavyProgressModifiers.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material3.internal.BaseCircularWavyProgressNode$startOffsetAnimation$1", f = "CircularWavyProgressModifiers.kt", i = {}, l = {365}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $durationMillis;
        final /* synthetic */ float $startOffset;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(float f, int i, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$startOffset = f;
            this.$durationMillis = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return BaseCircularWavyProgressNode.this.new AnonymousClass1(this.$startOffset, this.$durationMillis, continuation);
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
                Animatable<Float, AnimationVector1D> offsetAnimatable = BaseCircularWavyProgressNode.this.getOffsetAnimatable();
                if (offsetAnimatable == null) {
                    return Unit.INSTANCE;
                }
                offsetAnimatable.updateBounds(Boxing.boxFloat(this.$startOffset), Boxing.boxFloat(this.$startOffset + 1.0f));
                Float fBoxFloat = Boxing.boxFloat(this.$startOffset + 1.0f);
                InfiniteRepeatableSpec infiniteRepeatableSpecM475infiniteRepeatable9IiC70o$default = AnimationSpecKt.m475infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(this.$durationMillis, 0, EasingKt.getLinearEasing(), 2, null), RepeatMode.Restart, 0L, 4, null);
                final BaseCircularWavyProgressNode baseCircularWavyProgressNode = BaseCircularWavyProgressNode.this;
                this.label = 1;
                if (Animatable.animateTo$default(offsetAnimatable, fBoxFloat, infiniteRepeatableSpecM475infiniteRepeatable9IiC70o$default, null, new Function1() { // from class: androidx.compose.material3.internal.BaseCircularWavyProgressNode$startOffsetAnimation$1$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return BaseCircularWavyProgressNode.AnonymousClass1.invokeSuspend$lambda$0(baseCircularWavyProgressNode, (Animatable) obj2);
                    }
                }, this, 4, null) == coroutine_suspended) {
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
        public static final Unit invokeSuspend$lambda$0(BaseCircularWavyProgressNode baseCircularWavyProgressNode, Animatable animatable) {
            baseCircularWavyProgressNode.getWaveOffsetState().setFloatValue(((Number) animatable.getValue()).floatValue() % 1.0f);
            return Unit.INSTANCE;
        }
    }

    protected final void stopOffsetAnimation() {
        Job job = this.offsetAnimationJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.offsetAnimationJob = null;
        this.offsetAnimatable = null;
    }
}
