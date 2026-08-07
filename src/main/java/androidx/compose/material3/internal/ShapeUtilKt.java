package androidx.compose.material3.internal;

import androidx.collection.FloatFloatPair;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.graphics.Path;
import androidx.graphics.shapes.Cubic;
import androidx.graphics.shapes.Morph;
import androidx.graphics.shapes.PointTransformer;
import androidx.graphics.shapes.RoundedPolygon;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: ShapeUtil.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001b\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a4\u0010\u0006\u001a\u00020\u0007*\u00020\u00012\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\fH\u0000\u001aP\u0010\u0006\u001a\u00020\u0007*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u0010H\u0000\u001aF\u0010\u0013\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H\u0002\u001a\u0010\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0010H\u0002¨\u0006\u001a"}, d2 = {"transformed", "Landroidx/graphics/shapes/RoundedPolygon;", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "transformed-EL8BTi8", "(Landroidx/graphics/shapes/RoundedPolygon;[F)Landroidx/graphics/shapes/RoundedPolygon;", "toPath", "Landroidx/compose/ui/graphics/Path;", "path", "startAngle", "", "repeatPath", "", "closePath", "Landroidx/graphics/shapes/Morph;", "progress", "", "rotationPivotX", "rotationPivotY", "pathFromCubics", "", "cubics", "", "Landroidx/graphics/shapes/Cubic;", "radiansToDegrees", "radians", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ShapeUtilKt {
    private static final float radiansToDegrees(float f) {
        return (float) ((((double) f) * 180.0d) / 3.141592653589793d);
    }

    /* JADX INFO: renamed from: transformed-EL8BTi8, reason: not valid java name */
    public static final RoundedPolygon m4999transformedEL8BTi8(RoundedPolygon roundedPolygon, final float[] fArr) {
        return roundedPolygon.transformed(new PointTransformer() { // from class: androidx.compose.material3.internal.ShapeUtilKt$transformed$1
            @Override // androidx.graphics.shapes.PointTransformer
            /* JADX INFO: renamed from: transform-XgqJiTY, reason: not valid java name */
            public final long mo5000transformXgqJiTY(float f, float f2) {
                long jM7066mapMKHz9U = Matrix.m7066mapMKHz9U(fArr, Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(f2)) & 4294967295L) | (Float.floatToRawIntBits(f) << 32)));
                return FloatFloatPair.m315constructorimpl(Float.intBitsToFloat((int) (jM7066mapMKHz9U >> 32)), Float.intBitsToFloat((int) (jM7066mapMKHz9U & 4294967295L)));
            }
        });
    }

    public static /* synthetic */ Path toPath$default(RoundedPolygon roundedPolygon, Path path, int i, boolean z, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            path = AndroidPath_androidKt.Path();
        }
        if ((i2 & 2) != 0) {
            i = 270;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        if ((i2 & 8) != 0) {
            z2 = true;
        }
        return toPath(roundedPolygon, path, i, z, z2);
    }

    public static final Path toPath(RoundedPolygon roundedPolygon, Path path, int i, boolean z, boolean z2) {
        pathFromCubics(path, i, z, z2, roundedPolygon.getCubics(), roundedPolygon.getCenterX(), roundedPolygon.getCenterY());
        return path;
    }

    public static final Path toPath(Morph morph, float f, Path path, int i, boolean z, boolean z2, float f2, float f3) {
        pathFromCubics(path, i, z, z2, morph.asCubics(f), f2, f3);
        return path;
    }

    private static final void pathFromCubics(Path path, int i, boolean z, boolean z2, List<? extends Cubic> list, float f, float f2) {
        boolean z3;
        Cubic cubic;
        boolean z4;
        path.rewind();
        List<? extends Cubic> list2 = list;
        int size = list2.size();
        boolean z5 = true;
        Cubic cubic2 = null;
        int i2 = 0;
        while (i2 < size) {
            Cubic cubic3 = list.get(i2);
            if (z5) {
                path.moveTo(cubic3.getAnchor0X(), cubic3.getAnchor0Y());
                if (i != 0) {
                    cubic2 = cubic3;
                }
                cubic = cubic2;
                z4 = false;
            } else {
                cubic = cubic2;
                z4 = z5;
            }
            path.cubicTo(cubic3.getControl0X(), cubic3.getControl0Y(), cubic3.getControl1X(), cubic3.getControl1Y(), cubic3.getAnchor1X(), cubic3.getAnchor1Y());
            i2++;
            z5 = z4;
            cubic2 = cubic;
        }
        if (z) {
            int size2 = list2.size();
            boolean z6 = true;
            int i3 = 0;
            while (i3 < size2) {
                Cubic cubic4 = list.get(i3);
                if (z6) {
                    path.lineTo(cubic4.getAnchor0X(), cubic4.getAnchor0Y());
                    z3 = false;
                } else {
                    z3 = z6;
                }
                path.cubicTo(cubic4.getControl0X(), cubic4.getControl0Y(), cubic4.getControl1X(), cubic4.getControl1Y(), cubic4.getAnchor1X(), cubic4.getAnchor1Y());
                i3++;
                z6 = z3;
            }
        }
        if (z2) {
            path.close();
        }
        if (i == 0 || cubic2 == null) {
            return;
        }
        float fRadiansToDegrees = radiansToDegrees((float) Math.atan2(list.get(0).getAnchor0Y() - f2, list.get(0).getAnchor0X() - f));
        float[] fArrM7060constructorimpl$default = Matrix.m7060constructorimpl$default(null, 1, null);
        Matrix.m7074rotateZimpl(fArrM7060constructorimpl$default, (-fRadiansToDegrees) + i);
        path.mo6705transform58bKbWc(fArrM7060constructorimpl$default);
    }
}
