package androidx.graphics.shapes;

import androidx.collection.FloatFloatPair;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FeatureMapping.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u001a,\u0010\u0003\u001a\u00020\u00042\u0010\u0010\u0005\u001a\f\u0012\u0004\u0012\u00020\u00020\u0001j\u0002`\u00062\u0010\u0010\u0007\u001a\f\u0012\u0004\u0012\u00020\u00020\u0001j\u0002`\u0006H\u0000\u001a6\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t0\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0000\u001a\u0018\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0000\u001a\u0019\u0010\u0010\u001a\u00060\u0011j\u0002`\u00122\u0006\u0010\u0013\u001a\u00020\u000eH\u0000¢\u0006\u0002\u0010\u0014\" \u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0015\u001a\u00020\u0016X\u0082D¢\u0006\u0002\n\u0000*\u0018\b\u0000\u0010\u0000\"\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0017"}, d2 = {"MeasuredFeatures", "", "Landroidx/graphics/shapes/ProgressableFeature;", "featureMapper", "Landroidx/graphics/shapes/DoubleMapper;", "features1", "Landroidx/graphics/shapes/MeasuredFeatures;", "features2", "doMapping", "Lkotlin/Pair;", "", "IdentityMapping", "featureDistSquared", "f1", "Landroidx/graphics/shapes/Feature;", "f2", "featureRepresentativePoint", "Landroidx/collection/FloatFloatPair;", "Landroidx/graphics/shapes/Point;", "feature", "(Landroidx/graphics/shapes/Feature;)J", "LOG_TAG", "", "graphics-shapes"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class FeatureMappingKt {
    private static final List<Pair<Float, Float>> IdentityMapping;
    private static final String LOG_TAG;

    public static final DoubleMapper featureMapper(List<ProgressableFeature> features1, List<ProgressableFeature> features2) {
        Intrinsics.checkNotNullParameter(features1, "features1");
        Intrinsics.checkNotNullParameter(features2, "features2");
        List listCreateListBuilder = CollectionsKt.createListBuilder();
        int size = features1.size();
        for (int i = 0; i < size; i++) {
            if (features1.get(i).getFeature() instanceof Feature.Corner) {
                listCreateListBuilder.add(features1.get(i));
            }
        }
        List listBuild = CollectionsKt.build(listCreateListBuilder);
        List listCreateListBuilder2 = CollectionsKt.createListBuilder();
        int size2 = features2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            if (features2.get(i2).getFeature() instanceof Feature.Corner) {
                listCreateListBuilder2.add(features2.get(i2));
            }
        }
        Pair[] pairArr = (Pair[]) doMapping(listBuild, CollectionsKt.build(listCreateListBuilder2)).toArray(new Pair[0]);
        return new DoubleMapper((Pair[]) Arrays.copyOf(pairArr, pairArr.length));
    }

    private static final CharSequence featureMapper$lambda$3$lambda$2(Pair it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return ((Number) it.getFirst()).floatValue() + " -> " + ((Number) it.getSecond()).floatValue();
    }

    public static final List<Pair<Float, Float>> doMapping(List<ProgressableFeature> features1, List<ProgressableFeature> features2) {
        Intrinsics.checkNotNullParameter(features1, "features1");
        Intrinsics.checkNotNullParameter(features2, "features2");
        List listCreateListBuilder = CollectionsKt.createListBuilder();
        for (ProgressableFeature progressableFeature : features1) {
            for (ProgressableFeature progressableFeature2 : features2) {
                float fFeatureDistSquared = featureDistSquared(progressableFeature.getFeature(), progressableFeature2.getFeature());
                if (fFeatureDistSquared != Float.MAX_VALUE) {
                    listCreateListBuilder.add(new DistanceVertex(fFeatureDistSquared, progressableFeature, progressableFeature2));
                }
            }
        }
        List<DistanceVertex> listSortedWith = CollectionsKt.sortedWith(CollectionsKt.build(listCreateListBuilder), new Comparator() { // from class: androidx.graphics.shapes.FeatureMappingKt$doMapping$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Float.valueOf(((DistanceVertex) t).getDistance()), Float.valueOf(((DistanceVertex) t2).getDistance()));
            }
        });
        if (listSortedWith.isEmpty()) {
            return IdentityMapping;
        }
        if (listSortedWith.size() == 1) {
            DistanceVertex distanceVertex = (DistanceVertex) CollectionsKt.first(listSortedWith);
            float progress = distanceVertex.getF1().getProgress();
            float progress2 = distanceVertex.getF2().getProgress();
            return CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to(Float.valueOf(progress), Float.valueOf(progress2)), TuplesKt.to(Float.valueOf((progress + 0.5f) % 1.0f), Float.valueOf((progress2 + 0.5f) % 1.0f))});
        }
        MappingHelper mappingHelper = new MappingHelper();
        for (DistanceVertex distanceVertex2 : listSortedWith) {
            mappingHelper.addMapping(distanceVertex2.getF1(), distanceVertex2.getF2());
        }
        return mappingHelper.getMapping();
    }

    static {
        Float fValueOf = Float.valueOf(0.0f);
        Float fValueOf2 = Float.valueOf(0.5f);
        IdentityMapping = CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to(fValueOf, fValueOf), TuplesKt.to(fValueOf2, fValueOf2)});
        LOG_TAG = "FeatureMapping";
    }

    public static final float featureDistSquared(Feature f1, Feature f2) {
        Intrinsics.checkNotNullParameter(f1, "f1");
        Intrinsics.checkNotNullParameter(f2, "f2");
        if ((f1 instanceof Feature.Corner) && (f2 instanceof Feature.Corner) && ((Feature.Corner) f1).getConvex() != ((Feature.Corner) f2).getConvex()) {
            return Float.MAX_VALUE;
        }
        return PointKt.m10266getDistanceSquaredDnnuFBc(PointKt.m10270minusybeJwSQ(featureRepresentativePoint(f1), featureRepresentativePoint(f2)));
    }

    public static final long featureRepresentativePoint(Feature feature) {
        Intrinsics.checkNotNullParameter(feature, "feature");
        return FloatFloatPair.m315constructorimpl((((Cubic) CollectionsKt.first((List) feature.getCubics())).getAnchor0X() + ((Cubic) CollectionsKt.last((List) feature.getCubics())).getAnchor1X()) / 2.0f, (((Cubic) CollectionsKt.first((List) feature.getCubics())).getAnchor0Y() + ((Cubic) CollectionsKt.last((List) feature.getCubics())).getAnchor1Y()) / 2.0f);
    }
}
