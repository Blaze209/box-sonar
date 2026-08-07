package androidx.compose.ui.graphics.drawscope;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.InlineClassHelperKt;
import androidx.compose.ui.graphics.Path;
import kotlin.Metadata;

/* JADX INFO: compiled from: CanvasDrawScope.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002¨\u0006\u0003"}, d2 = {"asDrawTransform", "Landroidx/compose/ui/graphics/drawscope/DrawTransform;", "Landroidx/compose/ui/graphics/drawscope/DrawContext;", "ui-graphics"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class CanvasDrawScopeKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final DrawTransform asDrawTransform(final DrawContext drawContext) {
        return new DrawTransform() { // from class: androidx.compose.ui.graphics.drawscope.CanvasDrawScopeKt.asDrawTransform.1
            @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
            /* JADX INFO: renamed from: getSize-NH-jbRc, reason: not valid java name */
            public long mo7321getSizeNHjbRc() {
                return drawContext.mo7316getSizeNHjbRc();
            }

            @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
            /* JADX INFO: renamed from: getCenter-F1C5BW0, reason: not valid java name */
            public long mo7320getCenterF1C5BW0() {
                return SizeKt.m6648getCenteruvyYCjk(mo7321getSizeNHjbRc());
            }

            @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
            public void inset(float left, float top, float right, float bottom) {
                Canvas canvas = drawContext.getCanvas();
                DrawContext drawContext2 = drawContext;
                long jM6629constructorimpl = Size.m6629constructorimpl((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (mo7321getSizeNHjbRc() >> 32)) - (right + left))) << 32) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (mo7321getSizeNHjbRc() & 4294967295L)) - (bottom + top))) & 4294967295L));
                if (!(Float.intBitsToFloat((int) (jM6629constructorimpl >> 32)) >= 0.0f && Float.intBitsToFloat((int) (jM6629constructorimpl & 4294967295L)) >= 0.0f)) {
                    InlineClassHelperKt.throwIllegalArgumentException("Width and height must be greater than or equal to zero");
                }
                drawContext2.mo7317setSizeuvyYCjk(jM6629constructorimpl);
                canvas.translate(left, top);
            }

            @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
            /* JADX INFO: renamed from: clipRect-N_I0leg, reason: not valid java name */
            public void mo7319clipRectN_I0leg(float left, float top, float right, float bottom, int clipOp) {
                drawContext.getCanvas().mo6664clipRectN_I0leg(left, top, right, bottom, clipOp);
            }

            @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
            /* JADX INFO: renamed from: clipPath-mtrdD-E, reason: not valid java name */
            public void mo7318clipPathmtrdDE(Path path, int clipOp) {
                drawContext.getCanvas().mo6663clipPathmtrdDE(path, clipOp);
            }

            @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
            public void translate(float left, float top) {
                drawContext.getCanvas().translate(left, top);
            }

            @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
            /* JADX INFO: renamed from: rotate-Uv8p0NA, reason: not valid java name */
            public void mo7322rotateUv8p0NA(float degrees, long pivot) {
                Canvas canvas = drawContext.getCanvas();
                int i = (int) (pivot >> 32);
                int i2 = (int) (pivot & 4294967295L);
                canvas.translate(Float.intBitsToFloat(i), Float.intBitsToFloat(i2));
                canvas.rotate(degrees);
                canvas.translate(-Float.intBitsToFloat(i), -Float.intBitsToFloat(i2));
            }

            @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
            /* JADX INFO: renamed from: scale-0AR0LA0, reason: not valid java name */
            public void mo7323scale0AR0LA0(float scaleX, float scaleY, long pivot) {
                Canvas canvas = drawContext.getCanvas();
                int i = (int) (pivot >> 32);
                int i2 = (int) (pivot & 4294967295L);
                canvas.translate(Float.intBitsToFloat(i), Float.intBitsToFloat(i2));
                canvas.scale(scaleX, scaleY);
                canvas.translate(-Float.intBitsToFloat(i), -Float.intBitsToFloat(i2));
            }

            @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
            /* JADX INFO: renamed from: transform-58bKbWc, reason: not valid java name */
            public void mo7324transform58bKbWc(float[] matrix) {
                drawContext.getCanvas().mo6665concat58bKbWc(matrix);
            }
        };
    }
}
