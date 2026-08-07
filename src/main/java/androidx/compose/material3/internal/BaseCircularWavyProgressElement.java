package androidx.compose.material3.internal;

import androidx.compose.material3.internal.BaseCircularWavyProgressNode;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CircularWavyProgressModifiers.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\"\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B?\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0096\u0002J\b\u0010$\u001a\u00020%H\u0016J\f\u0010&\u001a\u00020\u001d*\u00020'H\u0004R\u0016\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0006\u001a\u00020\u0005X\u0096\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0013\u0010\u0011R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\t\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0016\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\f\u001a\u00020\u000bX\u0096\u0004¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u001a\u0010\u0018R\u0016\u0010\r\u001a\u00020\u000bX\u0096\u0004¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u001b\u0010\u0018¨\u0006("}, d2 = {"Landroidx/compose/material3/internal/BaseCircularWavyProgressElement;", "N", "Landroidx/compose/material3/internal/BaseCircularWavyProgressNode;", "Landroidx/compose/ui/node/ModifierNodeElement;", "color", "Landroidx/compose/ui/graphics/Color;", "trackColor", "stroke", "Landroidx/compose/ui/graphics/drawscope/Stroke;", "trackStroke", "gapSize", "Landroidx/compose/ui/unit/Dp;", "wavelength", "waveSpeed", "<init>", "(JJLandroidx/compose/ui/graphics/drawscope/Stroke;Landroidx/compose/ui/graphics/drawscope/Stroke;FFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getColor-0d7_KjU", "()J", "J", "getTrackColor-0d7_KjU", "getStroke", "()Landroidx/compose/ui/graphics/drawscope/Stroke;", "getTrackStroke", "getGapSize-D9Ej5fM", "()F", "F", "getWavelength-D9Ej5fM", "getWaveSpeed-D9Ej5fM", "update", "", "node", "(Landroidx/compose/material3/internal/BaseCircularWavyProgressNode;)V", "equals", "", "other", "", "hashCode", "", "baseInspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
abstract class BaseCircularWavyProgressElement<N extends BaseCircularWavyProgressNode> extends ModifierNodeElement<N> {
    private final long color;
    private final float gapSize;
    private final Stroke stroke;
    private final long trackColor;
    private final Stroke trackStroke;
    private final float waveSpeed;
    private final float wavelength;

    public /* synthetic */ BaseCircularWavyProgressElement(long j, long j2, Stroke stroke, Stroke stroke2, float f, float f2, float f3, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, stroke, stroke2, f, f2, f3);
    }

    private BaseCircularWavyProgressElement(long j, long j2, Stroke stroke, Stroke stroke2, float f, float f2, float f3) {
        this.color = j;
        this.trackColor = j2;
        this.stroke = stroke;
        this.trackStroke = stroke2;
        this.gapSize = f;
        this.wavelength = f2;
        this.waveSpeed = f3;
    }

    /* JADX INFO: renamed from: getColor-0d7_KjU, reason: not valid java name and from getter */
    public long getColor() {
        return this.color;
    }

    /* JADX INFO: renamed from: getTrackColor-0d7_KjU, reason: not valid java name and from getter */
    public long getTrackColor() {
        return this.trackColor;
    }

    public Stroke getStroke() {
        return this.stroke;
    }

    public Stroke getTrackStroke() {
        return this.trackStroke;
    }

    /* JADX INFO: renamed from: getGapSize-D9Ej5fM, reason: not valid java name and from getter */
    public float getGapSize() {
        return this.gapSize;
    }

    /* JADX INFO: renamed from: getWavelength-D9Ej5fM, reason: not valid java name and from getter */
    public float getWavelength() {
        return this.wavelength;
    }

    /* JADX INFO: renamed from: getWaveSpeed-D9Ej5fM, reason: not valid java name and from getter */
    public float getWaveSpeed() {
        return this.waveSpeed;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(N node) {
        node.m4920setColor8_81llA(getColor());
        node.m4922setTrackColor8_81llA(getTrackColor());
        node.setStroke(getStroke());
        node.setTrackStroke(getTrackStroke());
        node.m4921setGapSize0680j_4(getGapSize());
        node.m4924setWavelength0680j_4(getWavelength());
        node.m4923setWaveSpeed0680j_4(getWaveSpeed());
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BaseCircularWavyProgressElement)) {
            return false;
        }
        BaseCircularWavyProgressElement baseCircularWavyProgressElement = (BaseCircularWavyProgressElement) other;
        return Color.m6815equalsimpl0(getColor(), baseCircularWavyProgressElement.getColor()) && Color.m6815equalsimpl0(getTrackColor(), baseCircularWavyProgressElement.getTrackColor()) && Intrinsics.areEqual(getStroke(), baseCircularWavyProgressElement.getStroke()) && Intrinsics.areEqual(getTrackStroke(), baseCircularWavyProgressElement.getTrackStroke()) && Dp.m9692equalsimpl0(getGapSize(), baseCircularWavyProgressElement.getGapSize()) && Dp.m9692equalsimpl0(getWavelength(), baseCircularWavyProgressElement.getWavelength()) && Dp.m9692equalsimpl0(getWaveSpeed(), baseCircularWavyProgressElement.getWaveSpeed());
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        return (((((((((((Color.m6821hashCodeimpl(getColor()) * 31) + Color.m6821hashCodeimpl(getTrackColor())) * 31) + getStroke().hashCode()) * 31) + getTrackStroke().hashCode()) * 31) + Dp.m9693hashCodeimpl(getGapSize())) * 31) + Dp.m9693hashCodeimpl(getWavelength())) * 31) + Dp.m9693hashCodeimpl(getWaveSpeed());
    }

    protected final void baseInspectableProperties(InspectorInfo inspectorInfo) {
        inspectorInfo.getProperties().set("color", Color.m6804boximpl(getColor()));
        inspectorInfo.getProperties().set("trackColor", Color.m6804boximpl(getTrackColor()));
        inspectorInfo.getProperties().set("stroke", getStroke());
        inspectorInfo.getProperties().set("trackStroke", getTrackStroke());
        inspectorInfo.getProperties().set("gapSize", Dp.m9685boximpl(getGapSize()));
        inspectorInfo.getProperties().set("wavelength", Dp.m9685boximpl(getWavelength()));
        inspectorInfo.getProperties().set("waveSpeed", Dp.m9685boximpl(getWaveSpeed()));
    }
}
