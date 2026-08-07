package androidx.compose.material3.internal;

import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.platform.InspectorInfo;
import com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: LinearWavyProgressModifiers.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u007f\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0012\u001a\u00020\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u0005¢\u0006\u0004\b\u0014\u0010\u0015J\b\u0010(\u001a\u00020\u0002H\u0016J\u0010\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u0002H\u0016J\f\u0010,\u001a\u00020**\u00020-H\u0016J\u0013\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u000101H\u0096\u0002J\b\u00102\u001a\u000203H\u0016R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0016\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\u000b\u001a\u00020\nX\u0096\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001e\u0010\u001cR\u0014\u0010\f\u001a\u00020\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0014\u0010\u000e\u001a\u00020\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010 R\u0016\u0010\u000f\u001a\u00020\u0010X\u0096\u0004¢\u0006\n\n\u0002\u0010$\u001a\u0004\b\"\u0010#R\u0016\u0010\u0011\u001a\u00020\u0010X\u0096\u0004¢\u0006\n\n\u0002\u0010$\u001a\u0004\b%\u0010#R\u0016\u0010\u0012\u001a\u00020\u0010X\u0096\u0004¢\u0006\n\n\u0002\u0010$\u001a\u0004\b&\u0010#R\u0011\u0010\u0013\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010#¨\u00064"}, d2 = {"Landroidx/compose/material3/internal/IndeterminateLinearWavyProgressElement;", "Landroidx/compose/material3/internal/BaseLinearWavyProgressElement;", "Landroidx/compose/material3/internal/IndeterminateLinearWavyProgressNode;", "firstLineHeadProgress", "Lkotlin/Function0;", "", "firstLineTailProgress", "secondLineHeadProgress", "secondLineTailProgress", "color", "Landroidx/compose/ui/graphics/Color;", "trackColor", "stroke", "Landroidx/compose/ui/graphics/drawscope/Stroke;", "trackStroke", "gapSize", "Landroidx/compose/ui/unit/Dp;", "wavelength", "waveSpeed", "amplitude", "<init>", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;JJLandroidx/compose/ui/graphics/drawscope/Stroke;Landroidx/compose/ui/graphics/drawscope/Stroke;FFFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getFirstLineHeadProgress", "()Lkotlin/jvm/functions/Function0;", "getFirstLineTailProgress", "getSecondLineHeadProgress", "getSecondLineTailProgress", "getColor-0d7_KjU", "()J", "J", "getTrackColor-0d7_KjU", "getStroke", "()Landroidx/compose/ui/graphics/drawscope/Stroke;", "getTrackStroke", "getGapSize-D9Ej5fM", "()F", "F", "getWavelength-D9Ej5fM", "getWaveSpeed-D9Ej5fM", "getAmplitude", PasskeyWebListener.CREATE_UNIQUE_KEY, "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "equals", "", "other", "", "hashCode", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class IndeterminateLinearWavyProgressElement extends BaseLinearWavyProgressElement<IndeterminateLinearWavyProgressNode> {
    private final float amplitude;
    private final long color;
    private final Function0<Float> firstLineHeadProgress;
    private final Function0<Float> firstLineTailProgress;
    private final float gapSize;
    private final Function0<Float> secondLineHeadProgress;
    private final Function0<Float> secondLineTailProgress;
    private final Stroke stroke;
    private final long trackColor;
    private final Stroke trackStroke;
    private final float waveSpeed;
    private final float wavelength;

    public /* synthetic */ IndeterminateLinearWavyProgressElement(Function0 function0, Function0 function1, Function0 function2, Function0 function3, long j, long j2, Stroke stroke, Stroke stroke2, float f, float f2, float f3, float f4, DefaultConstructorMarker defaultConstructorMarker) {
        this(function0, function1, function2, function3, j, j2, stroke, stroke2, f, f2, f3, f4);
    }

    private IndeterminateLinearWavyProgressElement(Function0<Float> function0, Function0<Float> function1, Function0<Float> function2, Function0<Float> function3, long j, long j2, Stroke stroke, Stroke stroke2, float f, float f2, float f3, float f4) {
        super(j, j2, stroke, stroke2, f, f2, f3, null);
        this.firstLineHeadProgress = function0;
        this.firstLineTailProgress = function1;
        this.secondLineHeadProgress = function2;
        this.secondLineTailProgress = function3;
        this.color = j;
        this.trackColor = j2;
        this.stroke = stroke;
        this.trackStroke = stroke2;
        this.gapSize = f;
        this.wavelength = f2;
        this.waveSpeed = f3;
        this.amplitude = f4;
    }

    public final Function0<Float> getFirstLineHeadProgress() {
        return this.firstLineHeadProgress;
    }

    public final Function0<Float> getFirstLineTailProgress() {
        return this.firstLineTailProgress;
    }

    public final Function0<Float> getSecondLineHeadProgress() {
        return this.secondLineHeadProgress;
    }

    public final Function0<Float> getSecondLineTailProgress() {
        return this.secondLineTailProgress;
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

    public final float getAmplitude() {
        return this.amplitude;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: create */
    public IndeterminateLinearWavyProgressNode getNode() {
        return new IndeterminateLinearWavyProgressNode(this.firstLineHeadProgress, this.firstLineTailProgress, this.secondLineHeadProgress, this.secondLineTailProgress, this.amplitude, getColor(), getTrackColor(), getStroke(), getTrackStroke(), getGapSize(), getWavelength(), getWaveSpeed(), null);
    }

    @Override // androidx.compose.material3.internal.BaseLinearWavyProgressElement, androidx.compose.ui.node.ModifierNodeElement
    public void update(IndeterminateLinearWavyProgressNode node) {
        super.update(node);
        node.setFirstLineHeadProgress(this.firstLineHeadProgress);
        node.setFirstLineTailProgress(this.firstLineTailProgress);
        node.setSecondLineHeadProgress(this.secondLineHeadProgress);
        node.setSecondLineTailProgress(this.secondLineTailProgress);
        node.setAmplitude(this.amplitude);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        inspectorInfo.setName("indeterminateLinearWavyProgressIndicator");
        inspectorInfo.getProperties().set("amplitude", Float.valueOf(this.amplitude));
        baseInspectableProperties(inspectorInfo);
    }

    @Override // androidx.compose.material3.internal.BaseLinearWavyProgressElement, androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object other) {
        return super.equals(other) && (other instanceof IndeterminateLinearWavyProgressElement) && this.amplitude == ((IndeterminateLinearWavyProgressElement) other).amplitude;
    }

    @Override // androidx.compose.material3.internal.BaseLinearWavyProgressElement, androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        return (super.hashCode() * 31) + Float.hashCode(this.amplitude);
    }
}
