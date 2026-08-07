package androidx.compose.ui.graphics;

import kotlin.Metadata;

/* JADX INFO: compiled from: TransformOrigin.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\u001a\u001b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"TransformOrigin", "Landroidx/compose/ui/graphics/TransformOrigin;", "pivotFractionX", "", "pivotFractionY", "(FF)J", "ui"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TransformOriginKt {
    public static final long TransformOrigin(float f, float f2) {
        return TransformOrigin.m7219constructorimpl((((long) Float.floatToRawIntBits(f2)) & 4294967295L) | (Float.floatToRawIntBits(f) << 32));
    }
}
