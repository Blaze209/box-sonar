package androidx.graphics.shapes;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: CornerRounding.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u001b\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u000b"}, d2 = {"Landroidx/graphics/shapes/CornerRounding;", "", "radius", "", "smoothing", "<init>", "(FF)V", "getRadius", "()F", "getSmoothing", "Companion", "graphics-shapes"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CornerRounding {
    public static final CornerRounding Unrounded;
    private final float radius;
    private final float smoothing;

    /* JADX WARN: Illegal instructions before constructor call */
    public CornerRounding() {
        float f = 0.0f;
        this(f, f, 3, null);
    }

    public CornerRounding(float f, float f2) {
        this.radius = f;
        this.smoothing = f2;
    }

    public /* synthetic */ CornerRounding(float f, float f2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0.0f : f, (i & 2) != 0 ? 0.0f : f2);
    }

    public final float getRadius() {
        return this.radius;
    }

    public final float getSmoothing() {
        return this.smoothing;
    }

    static {
        DefaultConstructorMarker defaultConstructorMarker = null;
        INSTANCE = new Companion(defaultConstructorMarker);
        float f = 0.0f;
        Unrounded = new CornerRounding(f, f, 3, defaultConstructorMarker);
    }
}
