package androidx.compose.material3.internal;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.AndroidPathMeasure_androidKt;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathMeasure;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.Stroke;
import kotlin.Metadata;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CircularWavyProgressModifiers.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003Jð\u0002\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\b2\u008b\u0001\u00101\u001a\u0086\u0001\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(5\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(6\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(7\u0012\u0013\u0012\u00110\b¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(0\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(8\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(9\u0012\u0004\u0012\u00020\u001a022w\u0010:\u001as\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(5\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(6\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(7\u0012\u0013\u0012\u00110\b¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(0\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(9\u0012\u0006\u0012\u0004\u0018\u00010\u001a0;2\u0006\u0010<\u001a\u00020\u00142\b\b\u0001\u0010=\u001a\u00020\u00052\b\b\u0001\u0010>\u001a\u00020\u00052\b\b\u0001\u00105\u001a\u00020\u00052\b\b\u0001\u0010?\u001a\u00020\u00052\b\b\u0001\u00106\u001a\u00020\u00052\b\b\u0001\u0010@\u001a\u00020\u00052\u0006\u0010A\u001a\u00020\u000f2\u0006\u0010B\u001a\u00020\u000f¢\u0006\u0004\bC\u0010DJÔ\u0002\u0010E\u001a\u00020\u00142\u0006\u00100\u001a\u00020\b2\u008b\u0001\u00101\u001a\u0086\u0001\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(5\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(6\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(7\u0012\u0013\u0012\u00110\b¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(0\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(8\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(9\u0012\u0004\u0012\u00020\u001a022w\u0010:\u001as\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(5\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(6\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(7\u0012\u0013\u0012\u00110\b¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(0\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(9\u0012\u0006\u0012\u0004\u0018\u00010\u001a0;2\u0006\u0010<\u001a\u00020\u00142\b\b\u0001\u00105\u001a\u00020\u00052\b\b\u0001\u00106\u001a\u00020\u00052\b\b\u0001\u0010@\u001a\u00020\u00052\u0006\u0010A\u001a\u00020\u000f2\u0006\u0010B\u001a\u00020\u000fH\u0002¢\u0006\u0004\bF\u0010GJ'\u0010H\u001a\u00020/2\u0006\u00109\u001a\u00020\u001a2\u0006\u00100\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002¢\u0006\u0004\bI\u0010JJ.\u0010K\u001a\u00020/2\u0006\u0010L\u001a\u00020\u00142\b\b\u0001\u0010=\u001a\u00020\u00052\b\b\u0001\u0010>\u001a\u00020\u00052\b\b\u0001\u0010?\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\n\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0017R\u0010\u0010\u0018\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0017R\u0011\u0010\u0019\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u001d\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001cR\u0011\u0010\u001f\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001cR\u0011\u0010!\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001cR\u0011\u0010#\u001a\u00020$¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010'\u001a\u00020$¢\u0006\b\n\u0000\u001a\u0004\b(\u0010&R\u001a\u0010)\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-¨\u0006M"}, d2 = {"Landroidx/compose/material3/internal/CircularProgressDrawingCache;", "", "<init>", "()V", "currentAmplitude", "", "currentWavelength", "currentSize", "Landroidx/compose/ui/geometry/Size;", "J", "currentStartProgress", "currentEndProgress", "currentIndicatorTrackGapSize", "currentWaveOffset", "currentStroke", "Landroidx/compose/ui/graphics/drawscope/Stroke;", "currentTrackStroke", "progressPathLength", "trackPathLength", "currentProgressMotionEnabled", "", "scaleMatrix", "Landroidx/compose/ui/graphics/Matrix;", "[F", "transformMatrix", "fullProgressPath", "Landroidx/compose/ui/graphics/Path;", "getFullProgressPath", "()Landroidx/compose/ui/graphics/Path;", "fullTrackPath", "getFullTrackPath", "progressPathToDraw", "getProgressPathToDraw", "trackPathToDraw", "getTrackPathToDraw", "progressPathMeasure", "Landroidx/compose/ui/graphics/PathMeasure;", "getProgressPathMeasure", "()Landroidx/compose/ui/graphics/PathMeasure;", "trackPathMeasure", "getTrackPathMeasure", "currentStrokeCapWidth", "getCurrentStrokeCapWidth", "()F", "setCurrentStrokeCapWidth", "(F)V", "updatePaths", "", "size", "progressPathProvider", "Lkotlin/Function6;", "Lkotlin/ParameterName;", "name", "amplitude", "wavelength", "strokeWidth", "supportsMotion", "path", "trackPathProvider", "Lkotlin/Function5;", "enableProgressMotion", "startProgress", "endProgress", "waveOffset", "gapSize", "stroke", "trackStroke", "updatePaths-bLEYqPY", "(JLkotlin/jvm/functions/Function6;Lkotlin/jvm/functions/Function5;ZFFFFFFLandroidx/compose/ui/graphics/drawscope/Stroke;Landroidx/compose/ui/graphics/drawscope/Stroke;)V", "updateFullPaths", "updateFullPaths-SaZ-u-8", "(JLkotlin/jvm/functions/Function6;Lkotlin/jvm/functions/Function5;ZFFFLandroidx/compose/ui/graphics/drawscope/Stroke;Landroidx/compose/ui/graphics/drawscope/Stroke;)Z", "processPath", "processPath-HkQT9uY", "(Landroidx/compose/ui/graphics/Path;J[F)V", "updateDrawPaths", "forceUpdate", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class CircularProgressDrawingCache {
    private float currentEndProgress;
    private float currentIndicatorTrackGapSize;
    private boolean currentProgressMotionEnabled;
    private float currentStartProgress;
    private Stroke currentStroke;
    private float currentStrokeCapWidth;
    private Stroke currentTrackStroke;
    private final Path fullProgressPath;
    private final Path fullTrackPath;
    private float progressPathLength;
    private final PathMeasure progressPathMeasure;
    private final Path progressPathToDraw;
    private final float[] scaleMatrix;
    private float trackPathLength;
    private final PathMeasure trackPathMeasure;
    private final Path trackPathToDraw;
    private final float[] transformMatrix;
    private float currentAmplitude = -1.0f;
    private float currentWavelength = -1.0f;
    private long currentSize = Size.INSTANCE.m6646getUnspecifiedNHjbRc();
    private float currentWaveOffset = -1.0f;

    public CircularProgressDrawingCache() {
        Stroke stroke = new Stroke(0.0f, 0.0f, 0, 0, null, 31, null);
        this.currentStroke = stroke;
        this.currentTrackStroke = stroke;
        this.scaleMatrix = Matrix.m7060constructorimpl$default(null, 1, null);
        this.transformMatrix = Matrix.m7060constructorimpl$default(null, 1, null);
        this.fullProgressPath = AndroidPath_androidKt.Path();
        this.fullTrackPath = AndroidPath_androidKt.Path();
        this.progressPathToDraw = AndroidPath_androidKt.Path();
        this.trackPathToDraw = AndroidPath_androidKt.Path();
        this.progressPathMeasure = AndroidPathMeasure_androidKt.PathMeasure();
        this.trackPathMeasure = AndroidPathMeasure_androidKt.PathMeasure();
    }

    public final Path getFullProgressPath() {
        return this.fullProgressPath;
    }

    public final Path getFullTrackPath() {
        return this.fullTrackPath;
    }

    public final Path getProgressPathToDraw() {
        return this.progressPathToDraw;
    }

    public final Path getTrackPathToDraw() {
        return this.trackPathToDraw;
    }

    public final PathMeasure getProgressPathMeasure() {
        return this.progressPathMeasure;
    }

    public final PathMeasure getTrackPathMeasure() {
        return this.trackPathMeasure;
    }

    public final float getCurrentStrokeCapWidth() {
        return this.currentStrokeCapWidth;
    }

    public final void setCurrentStrokeCapWidth(float f) {
        this.currentStrokeCapWidth = f;
    }

    /* JADX INFO: renamed from: updatePaths-bLEYqPY, reason: not valid java name */
    public final void m4958updatePathsbLEYqPY(long size, Function6<? super Float, ? super Float, ? super Float, ? super Size, ? super Boolean, ? super Path, ? extends Path> progressPathProvider, Function5<? super Float, ? super Float, ? super Float, ? super Size, ? super Path, ? extends Path> trackPathProvider, boolean enableProgressMotion, float startProgress, float endProgress, float amplitude, float waveOffset, float wavelength, float gapSize, Stroke stroke, Stroke trackStroke) {
        updateDrawPaths(m4957updateFullPathsSaZu8(size, progressPathProvider, trackPathProvider, enableProgressMotion, amplitude, wavelength, gapSize, stroke, trackStroke), startProgress, endProgress, waveOffset);
    }

    /* JADX INFO: renamed from: updateFullPaths-SaZ-u-8, reason: not valid java name */
    private final boolean m4957updateFullPathsSaZu8(long size, Function6<? super Float, ? super Float, ? super Float, ? super Size, ? super Boolean, ? super Path, ? extends Path> progressPathProvider, Function5<? super Float, ? super Float, ? super Float, ? super Size, ? super Path, ? extends Path> trackPathProvider, boolean enableProgressMotion, float amplitude, float wavelength, float gapSize, Stroke stroke, Stroke trackStroke) {
        float fMax;
        float length;
        if (Size.m6634equalsimpl0(this.currentSize, size) && this.currentAmplitude == amplitude && this.currentWavelength == wavelength && Intrinsics.areEqual(this.currentStroke, stroke) && Intrinsics.areEqual(this.currentTrackStroke, trackStroke) && this.currentIndicatorTrackGapSize == gapSize && this.currentProgressMotionEnabled == enableProgressMotion) {
            return false;
        }
        float fIntBitsToFloat = Float.intBitsToFloat((int) (4294967295L & size));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (size >> 32));
        if (!(StrokeCap.m7186equalsimpl0(stroke.getCap(), StrokeCap.INSTANCE.m7190getButtKaPHkGw()) && StrokeCap.m7186equalsimpl0(trackStroke.getCap(), StrokeCap.INSTANCE.m7190getButtKaPHkGw())) && fIntBitsToFloat <= fIntBitsToFloat2) {
            float f = 2;
            fMax = Math.max(stroke.getWidth() / f, trackStroke.getWidth() / f);
        } else {
            fMax = 0.0f;
        }
        this.currentStrokeCapWidth = fMax;
        Matrix.m7069resetimpl(this.scaleMatrix);
        Matrix.m7076scaleimpl$default(this.scaleMatrix, fIntBitsToFloat2 - stroke.getWidth(), fIntBitsToFloat - stroke.getWidth(), 0.0f, 4, null);
        this.fullProgressPath.rewind();
        progressPathProvider.invoke(Float.valueOf(amplitude), Float.valueOf(wavelength), Float.valueOf(stroke.getWidth()), Size.m6626boximpl(size), Boolean.valueOf(enableProgressMotion), this.fullProgressPath);
        m4956processPathHkQT9uY(this.fullProgressPath, size, this.scaleMatrix);
        this.progressPathMeasure.setPath(this.fullProgressPath, true);
        if (enableProgressMotion) {
            length = this.progressPathMeasure.getLength() / 2;
        } else {
            length = this.progressPathMeasure.getLength();
        }
        this.progressPathLength = length;
        this.fullTrackPath.rewind();
        if (trackPathProvider.invoke(Float.valueOf(amplitude), Float.valueOf(wavelength), Float.valueOf(stroke.getWidth()), Size.m6626boximpl(size), this.fullTrackPath) != null) {
            m4956processPathHkQT9uY(this.fullTrackPath, size, this.scaleMatrix);
            this.trackPathMeasure.setPath(this.fullTrackPath, true);
            this.trackPathLength = this.trackPathMeasure.getLength();
        } else {
            this.trackPathLength = 0.0f;
        }
        this.currentSize = size;
        this.currentAmplitude = amplitude;
        this.currentWavelength = wavelength;
        this.currentStroke = stroke;
        this.currentTrackStroke = trackStroke;
        this.currentIndicatorTrackGapSize = gapSize;
        this.currentProgressMotionEnabled = enableProgressMotion;
        return true;
    }

    /* JADX INFO: renamed from: processPath-HkQT9uY, reason: not valid java name */
    private final void m4956processPathHkQT9uY(Path path, long size, float[] scaleMatrix) {
        path.mo6705transform58bKbWc(scaleMatrix);
        path.mo6706translatek4lQ0M(Offset.m6573minusMKHz9U(SizeKt.m6648getCenteruvyYCjk(size), path.getBounds().m6599getCenterF1C5BW0()));
    }

    private final void updateDrawPaths(boolean forceUpdate, float startProgress, float endProgress, float waveOffset) {
        if (Size.m6634equalsimpl0(this.currentSize, Size.INSTANCE.m6646getUnspecifiedNHjbRc())) {
            throw new IllegalArgumentException("updateDrawPaths was called before updateFullPaths".toString());
        }
        if (!forceUpdate && this.currentStartProgress == startProgress && this.currentEndProgress == endProgress && this.currentWaveOffset == waveOffset) {
            return;
        }
        this.trackPathToDraw.rewind();
        this.progressPathToDraw.rewind();
        float f = this.progressPathLength;
        float f2 = startProgress * f;
        float f3 = endProgress * f;
        float fMin = Math.min(f3, this.currentIndicatorTrackGapSize) + (Math.min(f3, this.currentStrokeCapWidth) * 2);
        if (this.currentProgressMotionEnabled) {
            float f4 = waveOffset < 0.0f ? 0.0f : waveOffset;
            if (f4 > 1.0f) {
                f4 = 1.0f;
            }
            float f5 = this.progressPathLength * f4;
            PathMeasure.getSegment$default(this.progressPathMeasure, f2 + f5, f3 + f5, this.progressPathToDraw, false, 8, null);
            float f6 = 360;
            float f7 = (f4 * f6) % f6;
            if (f7 != 0.0f) {
                Rect bounds = this.fullProgressPath.getBounds();
                this.progressPathToDraw.mo6706translatek4lQ0M(Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(-Float.intBitsToFloat((int) (bounds.m6599getCenterF1C5BW0() & 4294967295L)))) & 4294967295L) | (((long) Float.floatToRawIntBits(-Float.intBitsToFloat((int) (bounds.m6599getCenterF1C5BW0() >> 32)))) << 32)));
                Matrix.m7069resetimpl(this.transformMatrix);
                Path path = this.progressPathToDraw;
                float[] fArr = this.transformMatrix;
                Matrix.m7074rotateZimpl(fArr, -f7);
                path.mo6705transform58bKbWc(fArr);
                this.progressPathToDraw.mo6706translatek4lQ0M(Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (bounds.m6599getCenterF1C5BW0() >> 32)))) << 32) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (bounds.m6599getCenterF1C5BW0() & 4294967295L)))) & 4294967295L)));
            }
        } else {
            PathMeasure.getSegment$default(this.progressPathMeasure, f2, f3, this.progressPathToDraw, false, 8, null);
        }
        float f8 = this.trackPathLength;
        if (f8 > 0.0f) {
            PathMeasure.getSegment$default(this.trackPathMeasure, (endProgress * f8) + fMin, f8 - fMin, this.trackPathToDraw, false, 8, null);
        }
        this.currentStartProgress = startProgress;
        this.currentEndProgress = endProgress;
        this.currentWaveOffset = waveOffset;
    }
}
