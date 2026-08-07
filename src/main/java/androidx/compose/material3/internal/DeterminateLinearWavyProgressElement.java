package androidx.compose.material3.internal;

import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: LinearWavyProgressModifiers.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001Bx\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012!\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u00050\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0013\u001a\u00020\u0011\u0012\u0006\u0010\u0014\u001a\u00020\u0011¢\u0006\u0004\b\u0015\u0010\u0016J\b\u0010(\u001a\u00020\u0002H\u0016J\u0010\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u0002H\u0016J\f\u0010,\u001a\u00020**\u00020-H\u0016J\u0013\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u000101H\u0096\u0002J\b\u00102\u001a\u000203H\u0016R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R,\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\f\u001a\u00020\u000bX\u0096\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001e\u0010\u001cR\u0014\u0010\r\u001a\u00020\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0014\u0010\u000f\u001a\u00020\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010 R\u0016\u0010\u0010\u001a\u00020\u0011X\u0096\u0004¢\u0006\n\n\u0002\u0010$\u001a\u0004\b\"\u0010#R\u0013\u0010\u0012\u001a\u00020\u0011¢\u0006\n\n\u0002\u0010$\u001a\u0004\b%\u0010#R\u0016\u0010\u0013\u001a\u00020\u0011X\u0096\u0004¢\u0006\n\n\u0002\u0010$\u001a\u0004\b&\u0010#R\u0016\u0010\u0014\u001a\u00020\u0011X\u0096\u0004¢\u0006\n\n\u0002\u0010$\u001a\u0004\b'\u0010#¨\u00064"}, d2 = {"Landroidx/compose/material3/internal/DeterminateLinearWavyProgressElement;", "Landroidx/compose/material3/internal/BaseLinearWavyProgressElement;", "Landroidx/compose/material3/internal/DeterminateLinearWavyProgressNode;", "progress", "Lkotlin/Function0;", "", "amplitude", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "color", "Landroidx/compose/ui/graphics/Color;", "trackColor", "stroke", "Landroidx/compose/ui/graphics/drawscope/Stroke;", "trackStroke", "gapSize", "Landroidx/compose/ui/unit/Dp;", "stopSize", "wavelength", "waveSpeed", "<init>", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;JJLandroidx/compose/ui/graphics/drawscope/Stroke;Landroidx/compose/ui/graphics/drawscope/Stroke;FFFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getProgress", "()Lkotlin/jvm/functions/Function0;", "getAmplitude", "()Lkotlin/jvm/functions/Function1;", "getColor-0d7_KjU", "()J", "J", "getTrackColor-0d7_KjU", "getStroke", "()Landroidx/compose/ui/graphics/drawscope/Stroke;", "getTrackStroke", "getGapSize-D9Ej5fM", "()F", "F", "getStopSize-D9Ej5fM", "getWavelength-D9Ej5fM", "getWaveSpeed-D9Ej5fM", PasskeyWebListener.CREATE_UNIQUE_KEY, "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "equals", "", "other", "", "hashCode", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class DeterminateLinearWavyProgressElement extends BaseLinearWavyProgressElement<DeterminateLinearWavyProgressNode> {
    private final Function1<Float, Float> amplitude;
    private final long color;
    private final float gapSize;
    private final Function0<Float> progress;
    private final float stopSize;
    private final Stroke stroke;
    private final long trackColor;
    private final Stroke trackStroke;
    private final float waveSpeed;
    private final float wavelength;

    public /* synthetic */ DeterminateLinearWavyProgressElement(Function0 function0, Function1 function1, long j, long j2, Stroke stroke, Stroke stroke2, float f, float f2, float f3, float f4, DefaultConstructorMarker defaultConstructorMarker) {
        this(function0, function1, j, j2, stroke, stroke2, f, f2, f3, f4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private DeterminateLinearWavyProgressElement(Function0<Float> function0, Function1<? super Float, Float> function1, long j, long j2, Stroke stroke, Stroke stroke2, float f, float f2, float f3, float f4) {
        super(j, j2, stroke, stroke2, f, f3, f4, null);
        this.progress = function0;
        this.amplitude = function1;
        this.color = j;
        this.trackColor = j2;
        this.stroke = stroke;
        this.trackStroke = stroke2;
        this.gapSize = f;
        this.stopSize = f2;
        this.wavelength = f3;
        this.waveSpeed = f4;
    }

    public final Function0<Float> getProgress() {
        return this.progress;
    }

    public final Function1<Float, Float> getAmplitude() {
        return this.amplitude;
    }

    @Override // androidx.compose.material3.internal.BaseLinearWavyProgressElement
    /* JADX INFO: renamed from: getColor-0d7_KjU, reason: from getter */
    public long getColor() {
        return this.color;
    }

    @Override // androidx.compose.material3.internal.BaseLinearWavyProgressElement
    /* JADX INFO: renamed from: getTrackColor-0d7_KjU, reason: from getter */
    public long getTrackColor() {
        return this.trackColor;
    }

    @Override // androidx.compose.material3.internal.BaseLinearWavyProgressElement
    public Stroke getStroke() {
        return this.stroke;
    }

    @Override // androidx.compose.material3.internal.BaseLinearWavyProgressElement
    public Stroke getTrackStroke() {
        return this.trackStroke;
    }

    @Override // androidx.compose.material3.internal.BaseLinearWavyProgressElement
    /* JADX INFO: renamed from: getGapSize-D9Ej5fM, reason: from getter */
    public float getGapSize() {
        return this.gapSize;
    }

    /* JADX INFO: renamed from: getStopSize-D9Ej5fM, reason: not valid java name and from getter */
    public final float getStopSize() {
        return this.stopSize;
    }

    @Override // androidx.compose.material3.internal.BaseLinearWavyProgressElement
    /* JADX INFO: renamed from: getWavelength-D9Ej5fM, reason: from getter */
    public float getWavelength() {
        return this.wavelength;
    }

    @Override // androidx.compose.material3.internal.BaseLinearWavyProgressElement
    /* JADX INFO: renamed from: getWaveSpeed-D9Ej5fM, reason: from getter */
    public float getWaveSpeed() {
        return this.waveSpeed;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: create */
    public DeterminateLinearWavyProgressNode getNode() {
        return new DeterminateLinearWavyProgressNode(this.progress, this.amplitude, this.stopSize, getColor(), getTrackColor(), getStroke(), getTrackStroke(), getGapSize(), getWavelength(), getWaveSpeed(), null);
    }

    @Override // androidx.compose.material3.internal.BaseLinearWavyProgressElement, androidx.compose.ui.node.ModifierNodeElement
    public void update(DeterminateLinearWavyProgressNode node) {
        super.update(node);
        node.m4971setStopSize0680j_4(this.stopSize);
        if (node.getProgress() == this.progress && node.getAmplitude() == this.amplitude) {
            return;
        }
        node.setProgress(this.progress);
        node.setAmplitude(this.amplitude);
        node.getCacheDrawNodeDelegate().invalidateDrawCache();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        inspectorInfo.setName("determinateLinearWavyProgressIndicator");
        inspectorInfo.getProperties().set("stopSize", Dp.m9685boximpl(this.stopSize));
        baseInspectableProperties(inspectorInfo);
    }

    @Override // androidx.compose.material3.internal.BaseLinearWavyProgressElement, androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object other) {
        if (!super.equals(other) || !(other instanceof DeterminateLinearWavyProgressElement)) {
            return false;
        }
        DeterminateLinearWavyProgressElement determinateLinearWavyProgressElement = (DeterminateLinearWavyProgressElement) other;
        return Dp.m9692equalsimpl0(this.stopSize, determinateLinearWavyProgressElement.stopSize) && this.progress == determinateLinearWavyProgressElement.progress && this.amplitude == determinateLinearWavyProgressElement.amplitude;
    }

    @Override // androidx.compose.material3.internal.BaseLinearWavyProgressElement, androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        return (((((super.hashCode() * 31) + Dp.m9693hashCodeimpl(this.stopSize)) * 31) + this.progress.hashCode()) * 31) + this.amplitude.hashCode();
    }
}
