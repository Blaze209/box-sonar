package androidx.graphics.shapes;

import androidx.collection.FloatFloatPair;
import androidx.collection.MutableFloatList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: RoundedPolygon.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aL\u0010\u0000\u001a\u00020\u00012\b\b\u0001\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u000bH\u0007\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u0001\u001a@\u0010\u0000\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\b\u001a\u00020\t2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b2\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005H\u0007\u001a*\u0010\u0000\u001a\u00020\u00012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u000b2\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005H\u0007\u001a\u0019\u0010\u0011\u001a\u00060\u0012j\u0002`\u00132\u0006\u0010\r\u001a\u00020\u000eH\u0000¢\u0006\u0002\u0010\u0014\u001a(\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0002¨\u0006\u0016"}, d2 = {"RoundedPolygon", "Landroidx/graphics/shapes/RoundedPolygon;", "numVertices", "", "radius", "", "centerX", "centerY", "rounding", "Landroidx/graphics/shapes/CornerRounding;", "perVertexRounding", "", "source", "vertices", "", "features", "Landroidx/graphics/shapes/Feature;", "calculateCenter", "Landroidx/collection/FloatFloatPair;", "Landroidx/graphics/shapes/Point;", "([F)J", "verticesFromNumVerts", "graphics-shapes"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class RoundedPolygonKt {
    public static final RoundedPolygon RoundedPolygon(int i) {
        return RoundedPolygon$default(i, 0.0f, 0.0f, 0.0f, null, null, 62, null);
    }

    public static final RoundedPolygon RoundedPolygon(int i, float f) {
        return RoundedPolygon$default(i, f, 0.0f, 0.0f, null, null, 60, null);
    }

    public static final RoundedPolygon RoundedPolygon(int i, float f, float f2) {
        return RoundedPolygon$default(i, f, f2, 0.0f, null, null, 56, null);
    }

    public static final RoundedPolygon RoundedPolygon(int i, float f, float f2, float f3) {
        return RoundedPolygon$default(i, f, f2, f3, null, null, 48, null);
    }

    public static final RoundedPolygon RoundedPolygon(int i, float f, float f2, float f3, CornerRounding rounding) {
        Intrinsics.checkNotNullParameter(rounding, "rounding");
        return RoundedPolygon$default(i, f, f2, f3, rounding, null, 32, null);
    }

    public static final RoundedPolygon RoundedPolygon(List<? extends Feature> features) {
        Intrinsics.checkNotNullParameter(features, "features");
        return RoundedPolygon$default(features, 0.0f, 0.0f, 6, null);
    }

    public static final RoundedPolygon RoundedPolygon(List<? extends Feature> features, float f) {
        Intrinsics.checkNotNullParameter(features, "features");
        return RoundedPolygon$default(features, f, 0.0f, 4, null);
    }

    public static final RoundedPolygon RoundedPolygon(float[] vertices) {
        Intrinsics.checkNotNullParameter(vertices, "vertices");
        return RoundedPolygon$default(vertices, null, null, 0.0f, 0.0f, 30, null);
    }

    public static final RoundedPolygon RoundedPolygon(float[] vertices, CornerRounding rounding) {
        Intrinsics.checkNotNullParameter(vertices, "vertices");
        Intrinsics.checkNotNullParameter(rounding, "rounding");
        return RoundedPolygon$default(vertices, rounding, null, 0.0f, 0.0f, 28, null);
    }

    public static final RoundedPolygon RoundedPolygon(float[] vertices, CornerRounding rounding, List<CornerRounding> list) {
        Intrinsics.checkNotNullParameter(vertices, "vertices");
        Intrinsics.checkNotNullParameter(rounding, "rounding");
        return RoundedPolygon$default(vertices, rounding, list, 0.0f, 0.0f, 24, null);
    }

    public static final RoundedPolygon RoundedPolygon(float[] vertices, CornerRounding rounding, List<CornerRounding> list, float f) {
        Intrinsics.checkNotNullParameter(vertices, "vertices");
        Intrinsics.checkNotNullParameter(rounding, "rounding");
        return RoundedPolygon$default(vertices, rounding, list, f, 0.0f, 16, null);
    }

    public static /* synthetic */ RoundedPolygon RoundedPolygon$default(int i, float f, float f2, float f3, CornerRounding cornerRounding, List list, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            f = 1.0f;
        }
        if ((i2 & 4) != 0) {
            f2 = 0.0f;
        }
        if ((i2 & 8) != 0) {
            f3 = 0.0f;
        }
        if ((i2 & 16) != 0) {
            cornerRounding = CornerRounding.Unrounded;
        }
        if ((i2 & 32) != 0) {
            list = null;
        }
        List list2 = list;
        return RoundedPolygon(i, f, f2, f3, cornerRounding, list2);
    }

    public static final RoundedPolygon RoundedPolygon(int i, float f, float f2, float f3, CornerRounding rounding, List<CornerRounding> list) {
        Intrinsics.checkNotNullParameter(rounding, "rounding");
        return RoundedPolygon(verticesFromNumVerts(i, f, f2, f3), rounding, list, f2, f3);
    }

    public static final RoundedPolygon RoundedPolygon(RoundedPolygon source) {
        Intrinsics.checkNotNullParameter(source, "source");
        return new RoundedPolygon(source.getFeatures(), source.getCenter(), null);
    }

    public static /* synthetic */ RoundedPolygon RoundedPolygon$default(float[] fArr, CornerRounding cornerRounding, List list, float f, float f2, int i, Object obj) {
        if ((i & 2) != 0) {
            cornerRounding = CornerRounding.Unrounded;
        }
        if ((i & 4) != 0) {
            list = null;
        }
        if ((i & 8) != 0) {
            f = Float.MIN_VALUE;
        }
        if ((i & 16) != 0) {
            f2 = Float.MIN_VALUE;
        }
        return RoundedPolygon(fArr, cornerRounding, (List<CornerRounding>) list, f, f2);
    }

    public static final RoundedPolygon RoundedPolygon(float[] vertices, CornerRounding rounding, List<CornerRounding> list, float f, float f2) {
        long jCalculateCenter;
        Pair pair;
        CornerRounding cornerRounding;
        Intrinsics.checkNotNullParameter(vertices, "vertices");
        Intrinsics.checkNotNullParameter(rounding, "rounding");
        if (vertices.length < 6) {
            throw new IllegalArgumentException("Polygons must have at least 3 vertices");
        }
        if (vertices.length % 2 == 1) {
            throw new IllegalArgumentException("The vertices array should have even size");
        }
        if (list != null && list.size() * 2 != vertices.length) {
            throw new IllegalArgumentException("perVertexRounding list should be either null or the same size as the number of vertices (vertices.size / 2)");
        }
        ArrayList arrayList = new ArrayList();
        int length = vertices.length / 2;
        ArrayList arrayList2 = new ArrayList();
        int i = 0;
        int i2 = 0;
        while (i2 < length) {
            CornerRounding cornerRounding2 = (list == null || (cornerRounding = list.get(i2)) == null) ? rounding : cornerRounding;
            int i3 = (((i2 + length) - 1) % length) * 2;
            int i4 = i2 + 1;
            int i5 = (i4 % length) * 2;
            int i6 = i2 * 2;
            arrayList2.add(new RoundedCorner(FloatFloatPair.m315constructorimpl(vertices[i3], vertices[i3 + 1]), FloatFloatPair.m315constructorimpl(vertices[i6], vertices[i6 + 1]), FloatFloatPair.m315constructorimpl(vertices[i5], vertices[i5 + 1]), cornerRounding2, null));
            i2 = i4;
        }
        IntRange intRangeUntil = RangesKt.until(0, length);
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRangeUntil, 10));
        Iterator<Integer> it = intRangeUntil.iterator();
        while (it.hasNext()) {
            int iNextInt = ((IntIterator) it).nextInt();
            int i7 = (iNextInt + 1) % length;
            float expectedRoundCut = ((RoundedCorner) arrayList2.get(iNextInt)).getExpectedRoundCut() + ((RoundedCorner) arrayList2.get(i7)).getExpectedRoundCut();
            float expectedCut = ((RoundedCorner) arrayList2.get(iNextInt)).getExpectedCut() + ((RoundedCorner) arrayList2.get(i7)).getExpectedCut();
            int i8 = iNextInt * 2;
            int i9 = i7 * 2;
            float fDistance = Utils.distance(vertices[i8] - vertices[i9], vertices[i8 + 1] - vertices[i9 + 1]);
            if (expectedRoundCut > fDistance) {
                pair = TuplesKt.to(Float.valueOf(fDistance / expectedRoundCut), Float.valueOf(0.0f));
            } else if (expectedCut > fDistance) {
                pair = TuplesKt.to(Float.valueOf(1.0f), Float.valueOf((fDistance - expectedRoundCut) / (expectedCut - expectedRoundCut)));
            } else {
                pair = TuplesKt.to(Float.valueOf(1.0f), Float.valueOf(1.0f));
            }
            arrayList3.add(pair);
        }
        ArrayList arrayList4 = arrayList3;
        for (int i10 = 0; i10 < length; i10++) {
            MutableFloatList mutableFloatList = new MutableFloatList(2);
            for (int i11 = 0; i11 < 2; i11++) {
                Pair pair2 = (Pair) arrayList4.get((((i10 + length) - 1) + i11) % length);
                mutableFloatList.add((((RoundedCorner) arrayList2.get(i10)).getExpectedRoundCut() * ((Number) pair2.component1()).floatValue()) + ((((RoundedCorner) arrayList2.get(i10)).getExpectedCut() - ((RoundedCorner) arrayList2.get(i10)).getExpectedRoundCut()) * ((Number) pair2.component2()).floatValue()));
            }
            arrayList.add(((RoundedCorner) arrayList2.get(i10)).getCubics(mutableFloatList.get(0), mutableFloatList.get(1)));
        }
        ArrayList arrayList5 = new ArrayList();
        while (i < length) {
            int i12 = i + 1;
            int i13 = i12 % length;
            int i14 = i * 2;
            long jM315constructorimpl = FloatFloatPair.m315constructorimpl(vertices[i14], vertices[i14 + 1]);
            int i15 = (((i + length) - 1) % length) * 2;
            long jM315constructorimpl2 = FloatFloatPair.m315constructorimpl(vertices[i15], vertices[i15 + 1]);
            int i16 = i13 * 2;
            arrayList5.add(new Feature.Corner((List) arrayList.get(i), Utils.m10301convexb22R3LQ(jM315constructorimpl2, jM315constructorimpl, FloatFloatPair.m315constructorimpl(vertices[i16], vertices[i16 + 1]))));
            arrayList5.add(new Feature.Edge(CollectionsKt.listOf(Cubic.INSTANCE.straightLine(((Cubic) CollectionsKt.last((List) arrayList.get(i))).getAnchor1X(), ((Cubic) CollectionsKt.last((List) arrayList.get(i))).getAnchor1Y(), ((Cubic) CollectionsKt.first((List) arrayList.get(i13))).getAnchor0X(), ((Cubic) CollectionsKt.first((List) arrayList.get(i13))).getAnchor0Y()))));
            i = i12;
        }
        if (f == Float.MIN_VALUE || f2 == Float.MIN_VALUE) {
            jCalculateCenter = calculateCenter(vertices);
        } else {
            jCalculateCenter = FloatFloatPair.m315constructorimpl(f, f2);
        }
        return RoundedPolygon(arrayList5, Float.intBitsToFloat((int) (jCalculateCenter >> 32)), Float.intBitsToFloat((int) (jCalculateCenter & 4294967295L)));
    }

    public static /* synthetic */ RoundedPolygon RoundedPolygon$default(List list, float f, float f2, int i, Object obj) {
        if ((i & 2) != 0) {
            f = Float.NaN;
        }
        if ((i & 4) != 0) {
            f2 = Float.NaN;
        }
        return RoundedPolygon((List<? extends Feature>) list, f, f2);
    }

    public static final RoundedPolygon RoundedPolygon(List<? extends Feature> features, float f, float f2) {
        Intrinsics.checkNotNullParameter(features, "features");
        if (features.size() < 2) {
            throw new IllegalArgumentException("Polygons must have at least 2 features".toString());
        }
        List listCreateListBuilder = CollectionsKt.createListBuilder();
        Iterator<? extends Feature> it = features.iterator();
        while (it.hasNext()) {
            for (Cubic cubic : it.next().getCubics()) {
                listCreateListBuilder.add(Float.valueOf(cubic.getAnchor0X()));
                listCreateListBuilder.add(Float.valueOf(cubic.getAnchor0Y()));
            }
        }
        float[] floatArray = CollectionsKt.toFloatArray(CollectionsKt.build(listCreateListBuilder));
        if (Float.isNaN(f)) {
            f = Float.intBitsToFloat((int) (calculateCenter(floatArray) >> 32));
        }
        if (Float.isNaN(f2)) {
            f2 = Float.intBitsToFloat((int) (calculateCenter(floatArray) & 4294967295L));
        }
        return new RoundedPolygon(features, FloatFloatPair.m315constructorimpl(f, f2), null);
    }

    public static final long calculateCenter(float[] vertices) {
        Intrinsics.checkNotNullParameter(vertices, "vertices");
        float f = 0.0f;
        int i = 0;
        float f2 = 0.0f;
        while (i < vertices.length) {
            int i2 = i + 1;
            f += vertices[i];
            i += 2;
            f2 += vertices[i2];
        }
        return FloatFloatPair.m315constructorimpl(f / (vertices.length / 2), f2 / (vertices.length / 2));
    }

    private static final float[] verticesFromNumVerts(int i, float f, float f2, float f3) {
        float[] fArr = new float[i * 2];
        int i2 = 0;
        int i3 = 0;
        while (i2 < i) {
            float f4 = f;
            long jM10271plusybeJwSQ = PointKt.m10271plusybeJwSQ(Utils.m10303radialToCartesianL6JJ3z0$default(f4, (Utils.getFloatPi() / i) * 2 * i2, 0L, 4, null), FloatFloatPair.m315constructorimpl(f2, f3));
            int i4 = i3 + 1;
            fArr[i3] = PointKt.m10267getXDnnuFBc(jM10271plusybeJwSQ);
            i3 += 2;
            fArr[i4] = PointKt.m10268getYDnnuFBc(jM10271plusybeJwSQ);
            i2++;
            f = f4;
        }
        return fArr;
    }
}
