package androidx.compose.material3.internal;

import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Path;
import androidx.graphics.shapes.CornerRounding;
import androidx.graphics.shapes.Morph;
import androidx.graphics.shapes.RoundedPolygon;
import androidx.graphics.shapes.ShapesKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CircularWavyProgressModifiers.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J1\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00052\b\b\u0001\u0010\u0014\u001a\u00020\u00072\b\b\u0001\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0017¢\u0006\u0004\b\u0018\u0010\u0019J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bJ4\u0010\u001d\u001a\u00020\u001b2\b\b\u0001\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u00172\b\b\u0002\u0010 \u001a\u00020\u00072\b\b\u0002\u0010!\u001a\u00020\u0007R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\""}, d2 = {"Landroidx/compose/material3/internal/CircularShapes;", "", "<init>", "()V", "currentSize", "Landroidx/compose/ui/geometry/Size;", "currentWavelength", "", "trackPolygon", "Landroidx/graphics/shapes/RoundedPolygon;", "activeIndicatorPolygon", "activeIndicatorMorph", "Landroidx/graphics/shapes/Morph;", "currentVertexCount", "Landroidx/compose/runtime/MutableIntState;", "getCurrentVertexCount", "()Landroidx/compose/runtime/MutableIntState;", "update", "", "size", "wavelength", "strokeWidth", "requiresMorph", "", "update-Cqks5Fs", "(JFFZ)V", "getTrackPath", "Landroidx/compose/ui/graphics/Path;", "path", "getProgressPath", "amplitude", "repeatPath", "rotationPivotX", "rotationPivotY", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class CircularShapes {
    private Morph activeIndicatorMorph;
    private RoundedPolygon activeIndicatorPolygon;
    private Size currentSize;
    private RoundedPolygon trackPolygon;
    private float currentWavelength = -1.0f;
    private final MutableIntState currentVertexCount = SnapshotIntStateKt.mutableIntStateOf(-1);

    public final MutableIntState getCurrentVertexCount() {
        return this.currentVertexCount;
    }

    /* JADX INFO: renamed from: update-Cqks5Fs, reason: not valid java name */
    public final void m4959updateCqks5Fs(long size, float wavelength, float strokeWidth, boolean requiresMorph) {
        if (wavelength <= 0.0f) {
            throw new IllegalArgumentException("Wavelength should be greater than zero".toString());
        }
        if (Size.m6633equalsimpl(size, this.currentSize) && wavelength == this.currentWavelength) {
            if (requiresMorph && this.activeIndicatorMorph == null) {
                RoundedPolygon roundedPolygon = this.trackPolygon;
                Intrinsics.checkNotNull(roundedPolygon);
                RoundedPolygon roundedPolygon2 = this.activeIndicatorPolygon;
                Intrinsics.checkNotNull(roundedPolygon2);
                this.activeIndicatorMorph = new Morph(roundedPolygon, roundedPolygon2);
                return;
            }
            return;
        }
        float f = 2;
        int iMax = Math.max(5, (int) Math.round((((double) ((Size.m6637getMinDimensionimpl(size) / f) - (strokeWidth / f))) * 6.283185307179586d) / ((double) wavelength)));
        if (iMax != this.currentVertexCount.getIntValue()) {
            this.trackPolygon = ShapesKt.circle$default(RoundedPolygon.INSTANCE, iMax, 0.0f, 0.0f, 0.0f, 14, null).normalized();
            this.activeIndicatorPolygon = ShapesKt.star$default(RoundedPolygon.INSTANCE, iMax, 0.0f, 0.75f, new CornerRounding(0.35f, 0.4f), new CornerRounding(0.5f, 0.0f, 2, null), null, 0.0f, 0.0f, 226, null).normalized();
            if (requiresMorph) {
                RoundedPolygon roundedPolygon3 = this.trackPolygon;
                Intrinsics.checkNotNull(roundedPolygon3);
                RoundedPolygon roundedPolygon4 = this.activeIndicatorPolygon;
                Intrinsics.checkNotNull(roundedPolygon4);
                this.activeIndicatorMorph = new Morph(roundedPolygon3, roundedPolygon4);
            }
        }
        this.currentSize = Size.m6626boximpl(size);
        this.currentWavelength = wavelength;
        this.currentVertexCount.setIntValue(iMax);
    }

    public final Path getTrackPath(Path path) {
        RoundedPolygon roundedPolygon = this.trackPolygon;
        if (roundedPolygon == null) {
            return path;
        }
        ShapeUtilKt.toPath$default(roundedPolygon, path, 0, false, false, 14, null);
        return path;
    }

    public static /* synthetic */ Path getProgressPath$default(CircularShapes circularShapes, float f, Path path, boolean z, float f2, float f3, int i, Object obj) {
        if ((i & 8) != 0) {
            f2 = 0.5f;
        }
        if ((i & 16) != 0) {
            f3 = 0.5f;
        }
        return circularShapes.getProgressPath(f, path, z, f2, f3);
    }

    public final Path getProgressPath(float amplitude, Path path, boolean repeatPath, float rotationPivotX, float rotationPivotY) {
        RoundedPolygon roundedPolygon;
        Morph morph = this.activeIndicatorMorph;
        if (morph != null) {
            Intrinsics.checkNotNull(morph);
            ShapeUtilKt.toPath(morph, amplitude, (20 & 2) != 0 ? AndroidPath_androidKt.Path() : path, (20 & 4) != 0 ? 270 : 0, (20 & 8) != 0 ? false : repeatPath, (20 & 16) != 0, (20 & 32) != 0 ? 0.0f : rotationPivotX, (20 & 64) != 0 ? 0.0f : rotationPivotY);
            return path;
        }
        if (amplitude == 1.0f && (roundedPolygon = this.activeIndicatorPolygon) != null) {
            Intrinsics.checkNotNull(roundedPolygon);
            ShapeUtilKt.toPath$default(roundedPolygon, path, 0, repeatPath, false, 10, null);
            return path;
        }
        RoundedPolygon roundedPolygon2 = this.trackPolygon;
        if (roundedPolygon2 != null) {
            ShapeUtilKt.toPath$default(roundedPolygon2, path, 0, repeatPath, false, 10, null);
        }
        return path;
    }
}
