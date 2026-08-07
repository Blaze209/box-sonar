package dev.chrisbanes.haze;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.unit.Dp;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HazeEffectNode.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0001\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0013\u0010\n\u001a\u00020\u000b¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001c¨\u0006\u001e"}, d2 = {"Ldev/chrisbanes/haze/RenderEffectParams;", "", "blurRadius", "Landroidx/compose/ui/unit/Dp;", "noiseFactor", "", "tints", "", "Ldev/chrisbanes/haze/HazeTint;", "tintAlphaModulate", "contentSize", "Landroidx/compose/ui/geometry/Size;", "mask", "Landroidx/compose/ui/graphics/Brush;", "progressive", "<init>", "(FFLjava/util/List;FJLandroidx/compose/ui/graphics/Brush;Landroidx/compose/ui/graphics/Brush;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getBlurRadius-D9Ej5fM", "()F", "F", "getNoiseFactor", "getTints", "()Ljava/util/List;", "getTintAlphaModulate", "getContentSize-NH-jbRc", "()J", "J", "getMask", "()Landroidx/compose/ui/graphics/Brush;", "getProgressive", "haze_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RenderEffectParams {
    public static final int $stable = 8;
    private final float blurRadius;
    private final long contentSize;
    private final Brush mask;
    private final float noiseFactor;
    private final Brush progressive;
    private final float tintAlphaModulate;
    private final List<HazeTint> tints;

    public /* synthetic */ RenderEffectParams(float f, float f2, List list, float f3, long j, Brush brush, Brush brush2, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2, list, f3, j, brush, brush2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RenderEffectParams)) {
            return false;
        }
        RenderEffectParams renderEffectParams = (RenderEffectParams) obj;
        return Dp.m9692equalsimpl0(this.blurRadius, renderEffectParams.blurRadius) && Float.compare(this.noiseFactor, renderEffectParams.noiseFactor) == 0 && Intrinsics.areEqual(this.tints, renderEffectParams.tints) && Float.compare(this.tintAlphaModulate, renderEffectParams.tintAlphaModulate) == 0 && Size.m6634equalsimpl0(this.contentSize, renderEffectParams.contentSize) && Intrinsics.areEqual(this.mask, renderEffectParams.mask) && Intrinsics.areEqual(this.progressive, renderEffectParams.progressive);
    }

    public int hashCode() {
        int iM9693hashCodeimpl = ((((((((Dp.m9693hashCodeimpl(this.blurRadius) * 31) + Float.hashCode(this.noiseFactor)) * 31) + this.tints.hashCode()) * 31) + Float.hashCode(this.tintAlphaModulate)) * 31) + Size.m6639hashCodeimpl(this.contentSize)) * 31;
        Brush brush = this.mask;
        int iHashCode = (iM9693hashCodeimpl + (brush == null ? 0 : brush.hashCode())) * 31;
        Brush brush2 = this.progressive;
        return iHashCode + (brush2 != null ? brush2.hashCode() : 0);
    }

    public String toString() {
        return "RenderEffectParams(blurRadius=" + Dp.m9698toStringimpl(this.blurRadius) + ", noiseFactor=" + this.noiseFactor + ", tints=" + this.tints + ", tintAlphaModulate=" + this.tintAlphaModulate + ", contentSize=" + Size.m6642toStringimpl(this.contentSize) + ", mask=" + this.mask + ", progressive=" + this.progressive + ")";
    }

    private RenderEffectParams(float f, float f2, List<HazeTint> tints, float f3, long j, Brush brush, Brush brush2) {
        Intrinsics.checkNotNullParameter(tints, "tints");
        this.blurRadius = f;
        this.noiseFactor = f2;
        this.tints = tints;
        this.tintAlphaModulate = f3;
        this.contentSize = j;
        this.mask = brush;
        this.progressive = brush2;
    }

    /* JADX INFO: renamed from: getBlurRadius-D9Ej5fM, reason: not valid java name and from getter */
    public final float getBlurRadius() {
        return this.blurRadius;
    }

    public final float getNoiseFactor() {
        return this.noiseFactor;
    }

    public /* synthetic */ RenderEffectParams(float f, float f2, List list, float f3, long j, Brush brush, Brush brush2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2, (i & 4) != 0 ? CollectionsKt.emptyList() : list, (i & 8) != 0 ? 1.0f : f3, j, (i & 32) != 0 ? null : brush, (i & 64) != 0 ? null : brush2, null);
    }

    public final List<HazeTint> getTints() {
        return this.tints;
    }

    public final float getTintAlphaModulate() {
        return this.tintAlphaModulate;
    }

    /* JADX INFO: renamed from: getContentSize-NH-jbRc, reason: not valid java name and from getter */
    public final long getContentSize() {
        return this.contentSize;
    }

    public final Brush getMask() {
        return this.mask;
    }

    public final Brush getProgressive() {
        return this.progressive;
    }
}
