package androidx.compose.material3.internal;

import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.platform.InspectorInfo;
import com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: CircularWavyProgressModifiers.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BI\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\b\u0001\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u000e\u001a\u00020\n¢\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u001e\u001a\u00020\u0002H\u0016J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0002H\u0016J\f\u0010\"\u001a\u00020 *\u00020#H\u0016J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'H\u0096\u0002J\b\u0010(\u001a\u00020)H\u0016R\u0016\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0005\u001a\u00020\u0004X\u0096\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0014\u0010\u0012R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\b\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0016\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u0016\u0010\r\u001a\u00020\nX\u0096\u0004¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u001c\u0010\u0019R\u0016\u0010\u000e\u001a\u00020\nX\u0096\u0004¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u001d\u0010\u0019¨\u0006*"}, d2 = {"Landroidx/compose/material3/internal/IndeterminateCircularWavyProgressElement;", "Landroidx/compose/material3/internal/BaseCircularWavyProgressElement;", "Landroidx/compose/material3/internal/IndeterminateCircularWavyProgressNode;", "color", "Landroidx/compose/ui/graphics/Color;", "trackColor", "stroke", "Landroidx/compose/ui/graphics/drawscope/Stroke;", "trackStroke", "gapSize", "Landroidx/compose/ui/unit/Dp;", "amplitude", "", "wavelength", "waveSpeed", "<init>", "(JJLandroidx/compose/ui/graphics/drawscope/Stroke;Landroidx/compose/ui/graphics/drawscope/Stroke;FFFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getColor-0d7_KjU", "()J", "J", "getTrackColor-0d7_KjU", "getStroke", "()Landroidx/compose/ui/graphics/drawscope/Stroke;", "getTrackStroke", "getGapSize-D9Ej5fM", "()F", "F", "getAmplitude", "getWavelength-D9Ej5fM", "getWaveSpeed-D9Ej5fM", PasskeyWebListener.CREATE_UNIQUE_KEY, "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "equals", "", "other", "", "hashCode", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class IndeterminateCircularWavyProgressElement extends BaseCircularWavyProgressElement<IndeterminateCircularWavyProgressNode> {
    private final float amplitude;
    private final long color;
    private final float gapSize;
    private final Stroke stroke;
    private final long trackColor;
    private final Stroke trackStroke;
    private final float waveSpeed;
    private final float wavelength;

    public /* synthetic */ IndeterminateCircularWavyProgressElement(long j, long j2, Stroke stroke, Stroke stroke2, float f, float f2, float f3, float f4, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, stroke, stroke2, f, f2, f3, f4);
    }

    private IndeterminateCircularWavyProgressElement(long j, long j2, Stroke stroke, Stroke stroke2, float f, float f2, float f3, float f4) {
        super(j, j2, stroke, stroke2, f, f3, f4, null);
        this.color = j;
        this.trackColor = j2;
        this.stroke = stroke;
        this.trackStroke = stroke2;
        this.gapSize = f;
        this.amplitude = f2;
        this.wavelength = f3;
        this.waveSpeed = f4;
    }

    @Override // androidx.compose.material3.internal.BaseCircularWavyProgressElement
    /* JADX INFO: renamed from: getColor-0d7_KjU, reason: from getter */
    public long getColor() {
        return this.color;
    }

    @Override // androidx.compose.material3.internal.BaseCircularWavyProgressElement
    /* JADX INFO: renamed from: getTrackColor-0d7_KjU, reason: from getter */
    public long getTrackColor() {
        return this.trackColor;
    }

    @Override // androidx.compose.material3.internal.BaseCircularWavyProgressElement
    public Stroke getStroke() {
        return this.stroke;
    }

    @Override // androidx.compose.material3.internal.BaseCircularWavyProgressElement
    public Stroke getTrackStroke() {
        return this.trackStroke;
    }

    @Override // androidx.compose.material3.internal.BaseCircularWavyProgressElement
    /* JADX INFO: renamed from: getGapSize-D9Ej5fM, reason: from getter */
    public float getGapSize() {
        return this.gapSize;
    }

    public final float getAmplitude() {
        return this.amplitude;
    }

    @Override // androidx.compose.material3.internal.BaseCircularWavyProgressElement
    /* JADX INFO: renamed from: getWavelength-D9Ej5fM, reason: from getter */
    public float getWavelength() {
        return this.wavelength;
    }

    @Override // androidx.compose.material3.internal.BaseCircularWavyProgressElement
    /* JADX INFO: renamed from: getWaveSpeed-D9Ej5fM, reason: from getter */
    public float getWaveSpeed() {
        return this.waveSpeed;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: create */
    public IndeterminateCircularWavyProgressNode getNode() {
        return new IndeterminateCircularWavyProgressNode(getColor(), getTrackColor(), getStroke(), getTrackStroke(), getGapSize(), this.amplitude, getWavelength(), getWaveSpeed(), null);
    }

    @Override // androidx.compose.material3.internal.BaseCircularWavyProgressElement, androidx.compose.ui.node.ModifierNodeElement
    public void update(IndeterminateCircularWavyProgressNode node) {
        super.update(node);
        node.setAmplitude(this.amplitude);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        inspectorInfo.setName("indeterminateCircularWavyProgressIndicator");
        baseInspectableProperties(inspectorInfo);
        inspectorInfo.getProperties().set("amplitude", Float.valueOf(this.amplitude));
    }

    @Override // androidx.compose.material3.internal.BaseCircularWavyProgressElement, androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof IndeterminateCircularWavyProgressElement) && super.equals(other) && this.amplitude == ((IndeterminateCircularWavyProgressElement) other).amplitude;
    }

    @Override // androidx.compose.material3.internal.BaseCircularWavyProgressElement, androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        return (super.hashCode() * 31) + Float.hashCode(this.amplitude);
    }
}
