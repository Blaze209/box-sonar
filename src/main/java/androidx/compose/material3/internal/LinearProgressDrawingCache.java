package androidx.compose.material3.internal;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidPathMeasure_androidKt;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathMeasure;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.Stroke;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LinearWavyProgressModifiers.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JU\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\b2\b\b\u0003\u0010+\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u000b2\b\b\u0001\u0010-\u001a\u00020\u00052\b\b\u0001\u0010.\u001a\u00020\u00052\b\b\u0001\u0010/\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u000f2\u0006\u00101\u001a\u00020\u000f¢\u0006\u0004\b2\u00103JE\u00104\u001a\u0002052\u0006\u0010*\u001a\u00020\b2\b\b\u0001\u0010+\u001a\u00020\u00052\b\b\u0001\u0010-\u001a\u00020\u00052\b\b\u0001\u0010/\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u000f2\u0006\u00101\u001a\u00020\u000fH\u0002¢\u0006\u0004\b6\u00107J,\u00108\u001a\u00020)2\u0006\u00109\u001a\u0002052\u0006\u0010,\u001a\u00020\u000b2\b\b\u0001\u0010-\u001a\u00020\u00052\b\b\u0001\u0010.\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R$\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u001dX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\"\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010#\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006:"}, d2 = {"Landroidx/compose/material3/internal/LinearProgressDrawingCache;", "", "<init>", "()V", "currentWavelength", "", "currentAmplitude", "currentSize", "Landroidx/compose/ui/geometry/Size;", "J", "currentProgressFractions", "", "currentIndicatorTrackGapSize", "currentWaveOffset", "currentStroke", "Landroidx/compose/ui/graphics/drawscope/Stroke;", "currentTrackStroke", "progressPathScale", "fullProgressPath", "Landroidx/compose/ui/graphics/Path;", "getFullProgressPath", "()Landroidx/compose/ui/graphics/Path;", "pathMeasure", "Landroidx/compose/ui/graphics/PathMeasure;", "getPathMeasure", "()Landroidx/compose/ui/graphics/PathMeasure;", "trackPathToDraw", "getTrackPathToDraw", "progressPathsToDraw", "", "getProgressPathsToDraw", "()[Landroidx/compose/ui/graphics/Path;", "setProgressPathsToDraw", "([Landroidx/compose/ui/graphics/Path;)V", "[Landroidx/compose/ui/graphics/Path;", "currentStrokeCapWidth", "getCurrentStrokeCapWidth", "()F", "setCurrentStrokeCapWidth", "(F)V", "updatePaths", "", "size", "wavelength", "progressFractions", "amplitude", "waveOffset", "gapSize", "stroke", "trackStroke", "updatePaths-VygBpHg", "(JF[FFFFLandroidx/compose/ui/graphics/drawscope/Stroke;Landroidx/compose/ui/graphics/drawscope/Stroke;)V", "updateFullPaths", "", "updateFullPaths-LjSzlW0", "(JFFFLandroidx/compose/ui/graphics/drawscope/Stroke;Landroidx/compose/ui/graphics/drawscope/Stroke;)Z", "updateDrawPaths", "forceUpdate", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class LinearProgressDrawingCache {
    private float currentIndicatorTrackGapSize;
    private float[] currentProgressFractions;
    private Stroke currentStroke;
    private float currentStrokeCapWidth;
    private Stroke currentTrackStroke;
    private final Path fullProgressPath;
    private final PathMeasure pathMeasure;
    private float progressPathScale;
    private Path[] progressPathsToDraw;
    private final Path trackPathToDraw;
    private float currentWavelength = -1.0f;
    private float currentAmplitude = -1.0f;
    private long currentSize = Size.INSTANCE.m6646getUnspecifiedNHjbRc();
    private float currentWaveOffset = -1.0f;

    public LinearProgressDrawingCache() {
        Stroke stroke = new Stroke(0.0f, 0.0f, 0, 0, null, 31, null);
        this.currentStroke = stroke;
        this.currentTrackStroke = stroke;
        this.progressPathScale = 1.0f;
        this.fullProgressPath = AndroidPath_androidKt.Path();
        this.pathMeasure = AndroidPathMeasure_androidKt.PathMeasure();
        this.trackPathToDraw = AndroidPath_androidKt.Path();
    }

    public final Path getFullProgressPath() {
        return this.fullProgressPath;
    }

    public final PathMeasure getPathMeasure() {
        return this.pathMeasure;
    }

    public final Path getTrackPathToDraw() {
        return this.trackPathToDraw;
    }

    public final Path[] getProgressPathsToDraw() {
        return this.progressPathsToDraw;
    }

    public final void setProgressPathsToDraw(Path[] pathArr) {
        this.progressPathsToDraw = pathArr;
    }

    public final float getCurrentStrokeCapWidth() {
        return this.currentStrokeCapWidth;
    }

    public final void setCurrentStrokeCapWidth(float f) {
        this.currentStrokeCapWidth = f;
    }

    /* JADX INFO: renamed from: updatePaths-VygBpHg$default, reason: not valid java name */
    public static /* synthetic */ void m4991updatePathsVygBpHg$default(LinearProgressDrawingCache linearProgressDrawingCache, long j, float f, float[] fArr, float f2, float f3, float f4, Stroke stroke, Stroke stroke2, int i, Object obj) {
        if ((i & 2) != 0) {
            f = 0.0f;
        }
        linearProgressDrawingCache.m4992updatePathsVygBpHg(j, f, fArr, f2, f3, f4, stroke, stroke2);
    }

    /* JADX INFO: renamed from: updatePaths-VygBpHg, reason: not valid java name */
    public final void m4992updatePathsVygBpHg(long size, float wavelength, float[] progressFractions, float amplitude, float waveOffset, float gapSize, Stroke stroke, Stroke trackStroke) {
        if (this.currentProgressFractions == null) {
            this.currentProgressFractions = new float[progressFractions.length];
            int length = progressFractions.length / 2;
            Path[] pathArr = new Path[length];
            for (int i = 0; i < length; i++) {
                pathArr[i] = AndroidPath_androidKt.Path();
            }
            this.progressPathsToDraw = pathArr;
        }
        updateDrawPaths(m4990updateFullPathsLjSzlW0(size, wavelength, amplitude, gapSize, stroke, trackStroke), progressFractions, amplitude, waveOffset);
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0085 A[PHI: r17
      0x0085: PHI (r17v3 long) = (r17v1 long), (r17v4 long) binds: [B:29:0x0083, B:25:0x007c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:34:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:36:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:39:0x00c8 A[LOOP:0: B:37:0x00c4->B:39:0x00c8, LOOP_END] */
    /* JADX INFO: renamed from: updateFullPaths-LjSzlW0, reason: not valid java name */
    private final boolean m4990updateFullPathsLjSzlW0(long size, float wavelength, float amplitude, float gapSize, Stroke stroke, Stroke trackStroke) {
        long j;
        float fMax;
        float f;
        float f2;
        float f3;
        float width;
        float f4;
        if (Size.m6634equalsimpl0(this.currentSize, size) && this.currentWavelength == wavelength && Intrinsics.areEqual(this.currentStroke, stroke) && Intrinsics.areEqual(this.currentTrackStroke, trackStroke) && this.currentIndicatorTrackGapSize == gapSize) {
            float f5 = this.currentAmplitude;
            if ((f5 != 0.0f && amplitude != 0.0f) || (f5 == 0.0f && amplitude == 0.0f)) {
                return false;
            }
        }
        float fIntBitsToFloat = Float.intBitsToFloat((int) (size & 4294967295L));
        char c = ' ';
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (size >> 32));
        if (StrokeCap.m7186equalsimpl0(stroke.getCap(), StrokeCap.INSTANCE.m7190getButtKaPHkGw())) {
            j = 4294967295L;
            if (StrokeCap.m7186equalsimpl0(trackStroke.getCap(), StrokeCap.INSTANCE.m7190getButtKaPHkGw())) {
                fMax = 0.0f;
            }
            this.currentStrokeCapWidth = fMax;
            this.fullProgressPath.rewind();
            this.fullProgressPath.moveTo(0.0f, 0.0f);
            if (amplitude == 0.0f) {
                this.fullProgressPath.lineTo(fIntBitsToFloat2, 0.0f);
            } else {
                f = wavelength / 2.0f;
                f2 = f / 2.0f;
                f3 = fIntBitsToFloat2 + (2 * wavelength);
                width = fIntBitsToFloat - stroke.getWidth();
                f4 = f;
                while (f4 <= f3) {
                    this.fullProgressPath.quadraticTo(f2, width, f4, 0.0f);
                    f4 += f;
                    f2 += f;
                    width *= -1.0f;
                    c = c;
                }
            }
            this.fullProgressPath.mo6706translatek4lQ0M(Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(0.0f)) << c) | (((long) Float.floatToRawIntBits(fIntBitsToFloat / 2.0f)) & j)));
            this.pathMeasure.setPath(this.fullProgressPath, false);
            float length = this.pathMeasure.getLength();
            Rect bounds = this.fullProgressPath.getBounds();
            this.progressPathScale = length / ((bounds.getRight() - bounds.getLeft()) + 1.0E-8f);
            this.currentSize = size;
            this.currentWavelength = wavelength;
            this.currentStroke = stroke;
            this.currentTrackStroke = trackStroke;
            this.currentIndicatorTrackGapSize = gapSize;
            return true;
        }
        j = 4294967295L;
        if (fIntBitsToFloat > fIntBitsToFloat2) {
            fMax = 0.0f;
        } else {
            float f6 = 2;
            fMax = Math.max(stroke.getWidth() / f6, trackStroke.getWidth() / f6);
        }
        this.currentStrokeCapWidth = fMax;
        this.fullProgressPath.rewind();
        this.fullProgressPath.moveTo(0.0f, 0.0f);
        if (amplitude == 0.0f) {
            this.fullProgressPath.lineTo(fIntBitsToFloat2, 0.0f);
        } else {
            f = wavelength / 2.0f;
            f2 = f / 2.0f;
            f3 = fIntBitsToFloat2 + (2 * wavelength);
            width = fIntBitsToFloat - stroke.getWidth();
            f4 = f;
            while (f4 <= f3) {
                this.fullProgressPath.quadraticTo(f2, width, f4, 0.0f);
                f4 += f;
                f2 += f;
                width *= -1.0f;
                c = c;
            }
        }
        this.fullProgressPath.mo6706translatek4lQ0M(Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(0.0f)) << c) | (((long) Float.floatToRawIntBits(fIntBitsToFloat / 2.0f)) & j)));
        this.pathMeasure.setPath(this.fullProgressPath, false);
        float length2 = this.pathMeasure.getLength();
        Rect bounds2 = this.fullProgressPath.getBounds();
        this.progressPathScale = length2 / ((bounds2.getRight() - bounds2.getLeft()) + 1.0E-8f);
        this.currentSize = size;
        this.currentWavelength = wavelength;
        this.currentStroke = stroke;
        this.currentTrackStroke = trackStroke;
        this.currentIndicatorTrackGapSize = gapSize;
        return true;
    }

    private final void updateDrawPaths(boolean forceUpdate, float[] progressFractions, float amplitude, float waveOffset) {
        Path path;
        float[] fArr;
        if (Size.m6634equalsimpl0(this.currentSize, Size.INSTANCE.m6646getUnspecifiedNHjbRc())) {
            throw new IllegalArgumentException("updateDrawPaths was called before updateFullPaths".toString());
        }
        Path[] pathArr = this.progressPathsToDraw;
        Intrinsics.checkNotNull(pathArr);
        if (pathArr.length != progressFractions.length / 2) {
            StringBuilder sbAppend = new StringBuilder("the given progress fraction pairs do not match the expected number of progress paths to draw. updateDrawPaths called with ").append(progressFractions.length / 2).append(" pairs, while there are ");
            Path[] pathArr2 = this.progressPathsToDraw;
            Intrinsics.checkNotNull(pathArr2);
            throw new IllegalArgumentException(sbAppend.append(pathArr2.length).append(" expected progress paths.").toString().toString());
        }
        if (!forceUpdate && Arrays.equals(this.currentProgressFractions, progressFractions) && this.currentAmplitude == amplitude && this.currentWaveOffset == waveOffset) {
            return;
        }
        float fIntBitsToFloat = Float.intBitsToFloat((int) (this.currentSize >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (this.currentSize & 4294967295L)) / 2.0f;
        float fMin = this.currentIndicatorTrackGapSize;
        float f = fIntBitsToFloat - this.currentStrokeCapWidth;
        this.trackPathToDraw.rewind();
        this.trackPathToDraw.moveTo(f, fIntBitsToFloat2);
        Path[] pathArr3 = this.progressPathsToDraw;
        Intrinsics.checkNotNull(pathArr3);
        int length = pathArr3.length;
        float f2 = f;
        boolean z = false;
        int i = 0;
        while (i < length) {
            Path[] pathArr4 = this.progressPathsToDraw;
            Intrinsics.checkNotNull(pathArr4);
            pathArr4[i].rewind();
            int i2 = i * 2;
            float f3 = progressFractions[i2];
            float f4 = progressFractions[i2 + 1];
            float f5 = f3 * fIntBitsToFloat;
            float f6 = f4 * fIntBitsToFloat;
            if (i == 0) {
                float f7 = this.currentStrokeCapWidth;
                fMin = f6 < f7 ? 0.0f : Math.min(f6 - f7, this.currentIndicatorTrackGapSize);
                z = f6 >= this.currentStrokeCapWidth;
            }
            float f8 = fMin;
            boolean z2 = z;
            float f9 = this.currentStrokeCapWidth;
            float f10 = fIntBitsToFloat - f9;
            float f11 = f6 < f9 ? f9 : f6;
            if (f11 > f10) {
                f11 = f10;
            }
            float f12 = fIntBitsToFloat - f9;
            if (f5 >= f9) {
                f9 = f5;
            }
            float f13 = f9 > f12 ? f12 : f9;
            if (Math.abs(f4 - f3) > 0.0f) {
                float f14 = amplitude == 0.0f ? 0.0f : this.currentWavelength * waveOffset;
                PathMeasure pathMeasure = this.pathMeasure;
                float f15 = this.progressPathScale;
                Path[] pathArr5 = this.progressPathsToDraw;
                Intrinsics.checkNotNull(pathArr5);
                PathMeasure.getSegment$default(pathMeasure, (f13 + f14) * f15, (f11 + f14) * f15, pathArr5[i], false, 8, null);
                Path[] pathArr6 = this.progressPathsToDraw;
                Intrinsics.checkNotNull(pathArr6);
                Path path2 = pathArr6[i];
                float[] fArrM7060constructorimpl$default = Matrix.m7060constructorimpl$default(null, 1, null);
                Matrix.m7082translateimpl$default(fArrM7060constructorimpl$default, f14 > 0.0f ? -f14 : 0.0f, (1.0f - amplitude) * fIntBitsToFloat2, 0.0f, 4, null);
                if (amplitude == 1.0f) {
                    path = path2;
                    fArr = fArrM7060constructorimpl$default;
                } else {
                    path = path2;
                    fArr = fArrM7060constructorimpl$default;
                    Matrix.m7076scaleimpl$default(fArr, 0.0f, amplitude, 0.0f, 5, null);
                }
                path.mo6705transform58bKbWc(fArr);
            }
            float f16 = z2 ? f8 + (this.currentStrokeCapWidth * 2) : f8;
            float f17 = f11 + f16;
            if (f2 > f17) {
                this.trackPathToDraw.lineTo(Math.max(this.currentStrokeCapWidth, f17), fIntBitsToFloat2);
            }
            if (f6 > f5) {
                float fMax = Math.max(this.currentStrokeCapWidth, f13 - f16);
                this.trackPathToDraw.moveTo(fMax, fIntBitsToFloat2);
                f2 = fMax;
            }
            i++;
            fMin = f8;
            z = z2;
        }
        float f18 = this.currentStrokeCapWidth;
        if (f2 > f18) {
            this.trackPathToDraw.lineTo(f18, fIntBitsToFloat2);
        }
        float[] fArr2 = this.currentProgressFractions;
        Intrinsics.checkNotNull(fArr2);
        ArraysKt.copyInto$default(progressFractions, fArr2, 0, 0, 0, 14, (Object) null);
        this.currentAmplitude = amplitude;
        this.currentWaveOffset = waveOffset;
    }
}
