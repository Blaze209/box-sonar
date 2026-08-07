package androidx.graphics.shapes;

import androidx.collection.FloatFloatPair;
import androidx.media3.extractor.text.ttml.TtmlNode;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RoundedPolygon.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 (2\u00020\u0001:\u0001(B#\b\u0000\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\u0010\u0005\u001a\u00060\u0006j\u0002`\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010\u001b\u001a\u00020\u0000J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020\u001fJ\u001c\u0010!\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020\u001f2\b\b\u0002\u0010\"\u001a\u00020#H\u0007J\u0013\u0010$\u001a\u00020#2\b\u0010%\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010&\u001a\u00020'H\u0016R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0005\u001a\u00060\u0006j\u0002`\u0007X\u0080\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000f\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0012R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000b¨\u0006)"}, d2 = {"Landroidx/graphics/shapes/RoundedPolygon;", "", "features", "", "Landroidx/graphics/shapes/Feature;", TtmlNode.CENTER, "Landroidx/collection/FloatFloatPair;", "Landroidx/graphics/shapes/Point;", "<init>", "(Ljava/util/List;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getFeatures", "()Ljava/util/List;", "getCenter-1ufDz9w$graphics_shapes", "()J", "J", "centerX", "", "getCenterX", "()F", "centerY", "getCenterY", "cubics", "Landroidx/graphics/shapes/Cubic;", "getCubics", "transformed", "f", "Landroidx/graphics/shapes/PointTransformer;", "normalized", "toString", "", "calculateMaxBounds", "", "bounds", "calculateBounds", "approximate", "", "equals", "other", "hashCode", "", "Companion", "graphics-shapes"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RoundedPolygon {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final long center;
    private final List<Cubic> cubics;
    private final List<Feature> features;

    public /* synthetic */ RoundedPolygon(List list, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, j);
    }

    public final float[] calculateBounds() {
        return calculateBounds$default(this, null, false, 3, null);
    }

    public final float[] calculateBounds(float[] bounds) {
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        return calculateBounds$default(this, bounds, false, 2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private RoundedPolygon(List<? extends Feature> features, long j) {
        List<Cubic> listMutableListOf;
        List<Cubic> listMutableListOf2;
        Cubic cubic;
        List<Cubic> cubics;
        Intrinsics.checkNotNullParameter(features, "features");
        this.features = features;
        this.center = j;
        List listCreateListBuilder = CollectionsKt.createListBuilder();
        int i = 0;
        Cubic cubic2 = null;
        if (features.size() <= 0 || ((Feature) features.get(0)).getCubics().size() != 3) {
            listMutableListOf = null;
            listMutableListOf2 = null;
        } else {
            Pair<Cubic, Cubic> pairSplit = ((Feature) features.get(0)).getCubics().get(1).split(0.5f);
            Cubic cubicComponent1 = pairSplit.component1();
            Cubic cubicComponent2 = pairSplit.component2();
            listMutableListOf2 = CollectionsKt.mutableListOf(((Feature) features.get(0)).getCubics().get(0), cubicComponent1);
            listMutableListOf = CollectionsKt.mutableListOf(cubicComponent2, ((Feature) features.get(0)).getCubics().get(2));
        }
        int size = features.size();
        if (size >= 0) {
            int i2 = 0;
            Cubic cubic3 = null;
            while (true) {
                if (i2 == 0 && listMutableListOf != null) {
                    cubics = listMutableListOf;
                } else if (i2 != this.features.size()) {
                    cubics = this.features.get(i2).getCubics();
                } else if (listMutableListOf2 == null) {
                    break;
                } else {
                    cubics = listMutableListOf2;
                }
                int size2 = cubics.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    Cubic cubic4 = cubics.get(i3);
                    if (!cubic4.zeroLength$graphics_shapes()) {
                        if (cubic3 != null) {
                            listCreateListBuilder.add(cubic3);
                        }
                        if (cubic2 == null) {
                            cubic2 = cubic4;
                            cubic3 = cubic2;
                        } else {
                            cubic3 = cubic4;
                        }
                    } else if (cubic3 != null) {
                        float[] points = cubic3.getPoints();
                        float[] fArrCopyOf = Arrays.copyOf(points, points.length);
                        Intrinsics.checkNotNullExpressionValue(fArrCopyOf, "copyOf(...)");
                        Cubic cubic5 = new Cubic(fArrCopyOf);
                        cubic5.getPoints()[6] = cubic4.getAnchor1X();
                        cubic5.getPoints()[7] = cubic4.getAnchor1Y();
                        cubic3 = cubic5;
                    }
                }
                if (i2 == size) {
                    break;
                } else {
                    i2++;
                }
            }
            cubic = cubic2;
            cubic2 = cubic3;
        } else {
            cubic = null;
        }
        if (cubic2 != null && cubic != null) {
            listCreateListBuilder.add(CubicKt.Cubic(cubic2.getAnchor0X(), cubic2.getAnchor0Y(), cubic2.getControl0X(), cubic2.getControl0Y(), cubic2.getControl1X(), cubic2.getControl1Y(), cubic.getAnchor0X(), cubic.getAnchor0Y()));
        } else {
            listCreateListBuilder.add(CubicKt.Cubic(getCenterX(), getCenterY(), getCenterX(), getCenterY(), getCenterX(), getCenterY(), getCenterX(), getCenterY()));
        }
        List<Cubic> listBuild = CollectionsKt.build(listCreateListBuilder);
        this.cubics = listBuild;
        Cubic cubic6 = listBuild.get(listBuild.size() - 1);
        int size3 = listBuild.size();
        while (i < size3) {
            Cubic cubic7 = this.cubics.get(i);
            Cubic cubic8 = cubic6;
            if (Math.abs(cubic7.getAnchor0X() - cubic8.getAnchor1X()) > 1.0E-4f || Math.abs(cubic7.getAnchor0Y() - cubic8.getAnchor1Y()) > 1.0E-4f) {
                throw new IllegalArgumentException("RoundedPolygon must be contiguous, with the anchor points of all curves matching the anchor points of the preceding and succeeding cubics");
            }
            i++;
            cubic6 = cubic7;
        }
    }

    /* JADX INFO: renamed from: getCenter-1ufDz9w$graphics_shapes, reason: not valid java name and from getter */
    public final long getCenter() {
        return this.center;
    }

    public final List<Feature> getFeatures() {
        return this.features;
    }

    public final float getCenterX() {
        return PointKt.m10267getXDnnuFBc(this.center);
    }

    public final float getCenterY() {
        return PointKt.m10268getYDnnuFBc(this.center);
    }

    public final List<Cubic> getCubics() {
        return this.cubics;
    }

    public final RoundedPolygon transformed(PointTransformer f) {
        Intrinsics.checkNotNullParameter(f, "f");
        long jM10274transformedso9K2fw = PointKt.m10274transformedso9K2fw(this.center, f);
        List listCreateListBuilder = CollectionsKt.createListBuilder();
        int size = this.features.size();
        for (int i = 0; i < size; i++) {
            listCreateListBuilder.add(this.features.get(i).transformed(f));
        }
        return new RoundedPolygon(CollectionsKt.build(listCreateListBuilder), jM10274transformedso9K2fw, null);
    }

    public final RoundedPolygon normalized() {
        float[] fArrCalculateBounds$default = calculateBounds$default(this, null, false, 3, null);
        float f = fArrCalculateBounds$default[2] - fArrCalculateBounds$default[0];
        float f2 = fArrCalculateBounds$default[3] - fArrCalculateBounds$default[1];
        final float fMax = Math.max(f, f2);
        float f3 = 2;
        final float f4 = ((fMax - f) / f3) - fArrCalculateBounds$default[0];
        final float f5 = ((fMax - f2) / f3) - fArrCalculateBounds$default[1];
        return transformed(new PointTransformer() { // from class: androidx.graphics.shapes.RoundedPolygon.normalized.1
            @Override // androidx.graphics.shapes.PointTransformer
            /* JADX INFO: renamed from: transform-XgqJiTY */
            public final long mo5000transformXgqJiTY(float f6, float f7) {
                float f8 = f6 + f4;
                float f9 = fMax;
                return FloatFloatPair.m315constructorimpl(f8 / f9, (f7 + f5) / f9);
            }
        });
    }

    public String toString() {
        return "[RoundedPolygon. Cubics = " + CollectionsKt.joinToString$default(this.cubics, null, null, null, 0, null, null, 63, null) + " || Features = " + CollectionsKt.joinToString$default(this.features, null, null, null, 0, null, null, 63, null) + " || Center = (" + getCenterX() + ", " + getCenterY() + ")]";
    }

    public static /* synthetic */ float[] calculateMaxBounds$default(RoundedPolygon roundedPolygon, float[] fArr, int i, Object obj) {
        if ((i & 1) != 0) {
            fArr = new float[4];
        }
        return roundedPolygon.calculateMaxBounds(fArr);
    }

    public final float[] calculateMaxBounds(float[] bounds) {
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        if (bounds.length < 4) {
            throw new IllegalArgumentException("Required bounds size of 4".toString());
        }
        int size = this.cubics.size();
        float fMax = 0.0f;
        for (int i = 0; i < size; i++) {
            Cubic cubic = this.cubics.get(i);
            float fDistanceSquared = Utils.distanceSquared(cubic.getAnchor0X() - getCenterX(), cubic.getAnchor0Y() - getCenterY());
            long jM10255pointOnCurveOOQOV4g$graphics_shapes = cubic.m10255pointOnCurveOOQOV4g$graphics_shapes(0.5f);
            fMax = Math.max(fMax, Math.max(fDistanceSquared, Utils.distanceSquared(PointKt.m10267getXDnnuFBc(jM10255pointOnCurveOOQOV4g$graphics_shapes) - getCenterX(), PointKt.m10268getYDnnuFBc(jM10255pointOnCurveOOQOV4g$graphics_shapes) - getCenterY())));
        }
        float fSqrt = (float) Math.sqrt(fMax);
        bounds[0] = getCenterX() - fSqrt;
        bounds[1] = getCenterY() - fSqrt;
        bounds[2] = getCenterX() + fSqrt;
        bounds[3] = getCenterY() + fSqrt;
        return bounds;
    }

    public static /* synthetic */ float[] calculateBounds$default(RoundedPolygon roundedPolygon, float[] fArr, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            fArr = new float[4];
        }
        if ((i & 2) != 0) {
            z = true;
        }
        return roundedPolygon.calculateBounds(fArr, z);
    }

    public final float[] calculateBounds(float[] bounds, boolean approximate) {
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        if (bounds.length < 4) {
            throw new IllegalArgumentException("Required bounds size of 4".toString());
        }
        int size = this.cubics.size();
        float fMax = Float.MIN_VALUE;
        float fMin = Float.MAX_VALUE;
        float fMin2 = Float.MAX_VALUE;
        float fMax2 = Float.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            this.cubics.get(i).calculateBounds$graphics_shapes(bounds, approximate);
            fMin = Math.min(fMin, bounds[0]);
            fMin2 = Math.min(fMin2, bounds[1]);
            fMax = Math.max(fMax, bounds[2]);
            fMax2 = Math.max(fMax2, bounds[3]);
        }
        bounds[0] = fMin;
        bounds[1] = fMin2;
        bounds[2] = fMax;
        bounds[3] = fMax2;
        return bounds;
    }

    /* JADX INFO: compiled from: RoundedPolygon.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Landroidx/graphics/shapes/RoundedPolygon$Companion;", "", "<init>", "()V", "graphics-shapes"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof RoundedPolygon) {
            return Intrinsics.areEqual(this.features, ((RoundedPolygon) other).features);
        }
        return false;
    }

    public int hashCode() {
        return this.features.hashCode();
    }
}
