package androidx.graphics.shapes;

import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Cubic.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u001e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000f¨\u0006\u0010"}, d2 = {"Landroidx/graphics/shapes/MutableCubic;", "Landroidx/graphics/shapes/Cubic;", "<init>", "()V", "transformOnePoint", "", "f", "Landroidx/graphics/shapes/PointTransformer;", "ix", "", ViewProps.TRANSFORM, "interpolate", "c1", "c2", "progress", "", "graphics-shapes"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MutableCubic extends Cubic {
    public MutableCubic() {
        super(null, 1, null);
    }

    private final void transformOnePoint(PointTransformer f, int ix) {
        int i = ix + 1;
        long jMo5000transformXgqJiTY = f.mo5000transformXgqJiTY(getPoints()[ix], getPoints()[i]);
        getPoints()[ix] = Float.intBitsToFloat((int) (jMo5000transformXgqJiTY >> 32));
        getPoints()[i] = Float.intBitsToFloat((int) (4294967295L & jMo5000transformXgqJiTY));
    }

    public final void transform(PointTransformer f) {
        Intrinsics.checkNotNullParameter(f, "f");
        transformOnePoint(f, 0);
        transformOnePoint(f, 2);
        transformOnePoint(f, 4);
        transformOnePoint(f, 6);
    }

    public final void interpolate(Cubic c1, Cubic c2, float progress) {
        Intrinsics.checkNotNullParameter(c1, "c1");
        Intrinsics.checkNotNullParameter(c2, "c2");
        for (int i = 0; i < 8; i++) {
            getPoints()[i] = Utils.interpolate(c1.getPoints()[i], c2.getPoints()[i], progress);
        }
    }
}
