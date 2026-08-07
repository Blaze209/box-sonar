package androidx.compose.material3.internal;

import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.platform.InspectorInfo;
import com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: CircularWavyProgressModifiers.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001Bp\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\r\u0012!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u00050\u000f\u0012\u0006\u0010\u0012\u001a\u00020\r\u0012\u0006\u0010\u0013\u001a\u00020\r¢\u0006\u0004\b\u0014\u0010\u0015J\b\u0010&\u001a\u00020\u0002H\u0016J\u0010\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0002H\u0016J\f\u0010*\u001a\u00020(*\u00020+H\u0016J\u0013\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/H\u0096\u0002J\b\u00100\u001a\u000201H\u0016R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\b\u001a\u00020\u0007X\u0096\u0004¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u001b\u0010\u0019R\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u000b\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u0016\u0010\f\u001a\u00020\rX\u0096\u0004¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 R,\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u00050\u000f¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0016\u0010\u0012\u001a\u00020\rX\u0096\u0004¢\u0006\n\n\u0002\u0010!\u001a\u0004\b$\u0010 R\u0016\u0010\u0013\u001a\u00020\rX\u0096\u0004¢\u0006\n\n\u0002\u0010!\u001a\u0004\b%\u0010 ¨\u00062"}, d2 = {"Landroidx/compose/material3/internal/DeterminateCircularWavyProgressElement;", "Landroidx/compose/material3/internal/BaseCircularWavyProgressElement;", "Landroidx/compose/material3/internal/DeterminateCircularWavyProgressNode;", "progress", "Lkotlin/Function0;", "", "color", "Landroidx/compose/ui/graphics/Color;", "trackColor", "stroke", "Landroidx/compose/ui/graphics/drawscope/Stroke;", "trackStroke", "gapSize", "Landroidx/compose/ui/unit/Dp;", "amplitude", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "wavelength", "waveSpeed", "<init>", "(Lkotlin/jvm/functions/Function0;JJLandroidx/compose/ui/graphics/drawscope/Stroke;Landroidx/compose/ui/graphics/drawscope/Stroke;FLkotlin/jvm/functions/Function1;FFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getProgress", "()Lkotlin/jvm/functions/Function0;", "getColor-0d7_KjU", "()J", "J", "getTrackColor-0d7_KjU", "getStroke", "()Landroidx/compose/ui/graphics/drawscope/Stroke;", "getTrackStroke", "getGapSize-D9Ej5fM", "()F", "F", "getAmplitude", "()Lkotlin/jvm/functions/Function1;", "getWavelength-D9Ej5fM", "getWaveSpeed-D9Ej5fM", PasskeyWebListener.CREATE_UNIQUE_KEY, "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "equals", "", "other", "", "hashCode", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class DeterminateCircularWavyProgressElement extends BaseCircularWavyProgressElement<DeterminateCircularWavyProgressNode> {
    private final Function1<Float, Float> amplitude;
    private final long color;
    private final float gapSize;
    private final Function0<Float> progress;
    private final Stroke stroke;
    private final long trackColor;
    private final Stroke trackStroke;
    private final float waveSpeed;
    private final float wavelength;

    public /* synthetic */ DeterminateCircularWavyProgressElement(Function0 function0, long j, long j2, Stroke stroke, Stroke stroke2, float f, Function1 function1, float f2, float f3, DefaultConstructorMarker defaultConstructorMarker) {
        this(function0, j, j2, stroke, stroke2, f, function1, f2, f3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private DeterminateCircularWavyProgressElement(Function0<Float> function0, long j, long j2, Stroke stroke, Stroke stroke2, float f, Function1<? super Float, Float> function1, float f2, float f3) {
        super(j, j2, stroke, stroke2, f, f2, f3, null);
        this.progress = function0;
        this.color = j;
        this.trackColor = j2;
        this.stroke = stroke;
        this.trackStroke = stroke2;
        this.gapSize = f;
        this.amplitude = function1;
        this.wavelength = f2;
        this.waveSpeed = f3;
    }

    public final Function0<Float> getProgress() {
        return this.progress;
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

    public final Function1<Float, Float> getAmplitude() {
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
    public DeterminateCircularWavyProgressNode getNode() {
        return new DeterminateCircularWavyProgressNode(this.progress, this.amplitude, getColor(), getTrackColor(), getStroke(), getTrackStroke(), getGapSize(), getWavelength(), getWaveSpeed(), null);
    }

    @Override // androidx.compose.material3.internal.BaseCircularWavyProgressElement, androidx.compose.ui.node.ModifierNodeElement
    public void update(DeterminateCircularWavyProgressNode node) {
        super.update(node);
        if (node.getProgress() == this.progress && node.getAmplitude() == this.amplitude) {
            return;
        }
        node.setProgress(this.progress);
        node.setAmplitude(this.amplitude);
        node.getCacheDrawNode().invalidateDrawCache();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        inspectorInfo.setName("determinateCircularWavyProgressIndicator");
        baseInspectableProperties(inspectorInfo);
    }

    @Override // androidx.compose.material3.internal.BaseCircularWavyProgressElement, androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object other) {
        if (!super.equals(other) || !(other instanceof DeterminateCircularWavyProgressElement)) {
            return false;
        }
        DeterminateCircularWavyProgressElement determinateCircularWavyProgressElement = (DeterminateCircularWavyProgressElement) other;
        return this.progress == determinateCircularWavyProgressElement.progress && this.amplitude == determinateCircularWavyProgressElement.amplitude;
    }

    @Override // androidx.compose.material3.internal.BaseCircularWavyProgressElement, androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        return (((super.hashCode() * 31) + this.progress.hashCode()) * 31) + this.amplitude.hashCode();
    }
}
