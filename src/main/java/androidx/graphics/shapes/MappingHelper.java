package androidx.graphics.shapes;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FeatureMapping.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\fR#\u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Landroidx/graphics/shapes/MappingHelper;", "", "<init>", "()V", "mapping", "", "Lkotlin/Pair;", "", "getMapping", "()Ljava/util/List;", "usedF1", "", "Landroidx/graphics/shapes/ProgressableFeature;", "usedF2", "addMapping", "", "f1", "f2", "graphics-shapes"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class MappingHelper {
    private final List<Pair<Float, Float>> mapping = new ArrayList();
    private final Set<ProgressableFeature> usedF1 = new LinkedHashSet();
    private final Set<ProgressableFeature> usedF2 = new LinkedHashSet();

    public final List<Pair<Float, Float>> getMapping() {
        return this.mapping;
    }

    public final void addMapping(ProgressableFeature f1, ProgressableFeature f2) {
        Intrinsics.checkNotNullParameter(f1, "f1");
        Intrinsics.checkNotNullParameter(f2, "f2");
        if (this.usedF1.contains(f1) || this.usedF2.contains(f2)) {
            return;
        }
        List<Pair<Float, Float>> list = this.mapping;
        final Float fValueOf = Float.valueOf(f1.getProgress());
        int iBinarySearch = CollectionsKt.binarySearch(list, 0, list.size(), new Function1<Pair<? extends Float, ? extends Float>, Integer>() { // from class: androidx.graphics.shapes.MappingHelper$addMapping$$inlined$binarySearchBy$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Integer invoke(Pair<? extends Float, ? extends Float> pair) {
                return Integer.valueOf(ComparisonsKt.compareValues(pair.getFirst(), fValueOf));
            }
        });
        if (iBinarySearch >= 0) {
            throw new IllegalArgumentException("There can't be two features with the same progress".toString());
        }
        int i = (-iBinarySearch) - 1;
        int size = this.mapping.size();
        if (size >= 1) {
            Pair<Float, Float> pair = this.mapping.get(((i + size) - 1) % size);
            float fFloatValue = pair.component1().floatValue();
            float fFloatValue2 = pair.component2().floatValue();
            Pair<Float, Float> pair2 = this.mapping.get(i % size);
            float fFloatValue3 = pair2.component1().floatValue();
            float fFloatValue4 = pair2.component2().floatValue();
            if (FloatMappingKt.progressDistance(f1.getProgress(), fFloatValue) < 1.0E-4f || FloatMappingKt.progressDistance(f1.getProgress(), fFloatValue3) < 1.0E-4f || FloatMappingKt.progressDistance(f2.getProgress(), fFloatValue2) < 1.0E-4f || FloatMappingKt.progressDistance(f2.getProgress(), fFloatValue4) < 1.0E-4f) {
                return;
            }
            if (size > 1 && !FloatMappingKt.progressInRange(f2.getProgress(), fFloatValue2, fFloatValue4)) {
                return;
            }
        }
        this.mapping.add(i, TuplesKt.to(Float.valueOf(f1.getProgress()), Float.valueOf(f2.getProgress())));
        this.usedF1.add(f1);
        this.usedF2.add(f2);
    }
}
