package androidx.compose.material3;

import androidx.compose.material3.internal.ShapeUtilKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.graphics.shapes.Morph;
import androidx.graphics.shapes.RoundedPolygon;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MaterialShapes.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a(\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007\u001a\u001b\u0010\u0000\u001a\u00020\u0001*\u00020\b2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\t\u001a\u001b\u0010\n\u001a\u00020\u000b*\u00020\b2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"toPath", "Landroidx/compose/ui/graphics/Path;", "Landroidx/graphics/shapes/Morph;", "progress", "", "path", "startAngle", "", "Landroidx/graphics/shapes/RoundedPolygon;", "(Landroidx/graphics/shapes/RoundedPolygon;ILandroidx/compose/runtime/Composer;II)Landroidx/compose/ui/graphics/Path;", "toShape", "Landroidx/compose/ui/graphics/Shape;", "(Landroidx/graphics/shapes/RoundedPolygon;ILandroidx/compose/runtime/Composer;II)Landroidx/compose/ui/graphics/Shape;", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class MaterialShapesKt {
    public static /* synthetic */ Path toPath$default(Morph morph, float f, Path path, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            path = AndroidPath_androidKt.Path();
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return toPath(morph, f, path, i);
    }

    public static final Path toPath(Morph morph, float f, Path path, int i) {
        return ShapeUtilKt.toPath(morph, f, (20 & 2) != 0 ? AndroidPath_androidKt.Path() : path, (20 & 4) != 0 ? 270 : i, (20 & 8) != 0 ? false : false, (20 & 16) != 0, (20 & 32) != 0 ? 0.0f : 0.0f, (20 & 64) != 0 ? 0.0f : 0.0f);
    }

    public static final Path toPath(RoundedPolygon roundedPolygon, int i, Composer composer, int i2, int i3) {
        ComposerKt.sourceInformationMarkerStart(composer, -1218001419, "C(toPath)N(startAngle)68@2748L19,69@2779L130:MaterialShapes.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1218001419, i2, -1, "androidx.compose.material3.toPath (MaterialShapes.kt:67)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 2026710408, "CC(remember):MaterialShapes.kt#9igjgp");
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = AndroidPath_androidKt.Path();
            composer.updateRememberedValue(objRememberedValue);
        }
        Path path = (Path) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, 2026711511, "CC(remember):MaterialShapes.kt#9igjgp");
        boolean zChanged = ((((i2 & 112) ^ 48) > 32 && composer.changed(i)) || (i2 & 48) == 32) | composer.changed(roundedPolygon);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = ShapeUtilKt.toPath(roundedPolygon, path, i, false, true);
            composer.updateRememberedValue(objRememberedValue2);
        }
        Path path2 = (Path) objRememberedValue2;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return path2;
    }

    public static final Shape toShape(final RoundedPolygon roundedPolygon, final int i, Composer composer, int i2, int i3) {
        ComposerKt.sourceInformationMarkerStart(composer, -449076077, "C(toShape)N(startAngle)85@3447L1394:MaterialShapes.kt#uh7d8r");
        boolean z = true;
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-449076077, i2, -1, "androidx.compose.material3.toShape (MaterialShapes.kt:84)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -2065376827, "CC(remember):MaterialShapes.kt#9igjgp");
        boolean zChanged = composer.changed(roundedPolygon);
        if ((((i2 & 112) ^ 48) <= 32 || !composer.changed(i)) && (i2 & 48) != 32) {
            z = false;
        }
        boolean z2 = zChanged | z;
        Object objRememberedValue = composer.rememberedValue();
        if (z2 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Shape(roundedPolygon, i) { // from class: androidx.compose.material3.MaterialShapesKt$toShape$1$1
                private long lastSize = Size.INSTANCE.m6646getUnspecifiedNHjbRc();
                private final Path shapePath;
                private Path workPath;

                {
                    this.shapePath = ShapeUtilKt.toPath$default(roundedPolygon, null, i, false, false, 13, null);
                }

                @Override // androidx.compose.ui.graphics.Shape
                /* JADX INFO: renamed from: createOutline-Pq9zytI */
                public Outline mo655createOutlinePq9zytI(long size, LayoutDirection layoutDirection, Density density) {
                    Path path;
                    if (!Size.m6634equalsimpl0(size, this.lastSize) || (path = this.workPath) == null) {
                        this.lastSize = size;
                        this.workPath = AndroidPath_androidKt.Path();
                    } else {
                        Intrinsics.checkNotNull(path);
                        path.rewind();
                    }
                    Path path2 = this.workPath;
                    Intrinsics.checkNotNull(path2);
                    Path.m7100addPathUv8p0NA$default(path2, this.shapePath, 0L, 2, null);
                    float[] fArrM7060constructorimpl$default = Matrix.m7060constructorimpl$default(null, 1, null);
                    Matrix.m7076scaleimpl$default(fArrM7060constructorimpl$default, Float.intBitsToFloat((int) (size >> 32)), Float.intBitsToFloat((int) (4294967295L & size)), 0.0f, 4, null);
                    path2.mo6705transform58bKbWc(fArrM7060constructorimpl$default);
                    path2.mo6706translatek4lQ0M(Offset.m6573minusMKHz9U(SizeKt.m6648getCenteruvyYCjk(size), path2.getBounds().m6599getCenterF1C5BW0()));
                    return new Outline.Generic(path2);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        MaterialShapesKt$toShape$1$1 materialShapesKt$toShape$1$1 = (MaterialShapesKt$toShape$1$1) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return materialShapesKt$toShape$1$1;
    }
}
