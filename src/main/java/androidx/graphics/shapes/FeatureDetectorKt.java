package androidx.graphics.shapes;

import androidx.media3.exoplayer.upstream.CmcdData;
import com.facebook.react.animated.InterpolationAnimatedNode;
import external.sdk.pendo.io.mozilla.javascript.ES6Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FeatureDetector.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u0001H\u0000\u001a\u0014\u0010\u0005\u001a\u00020\u0002*\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0000\u001a\f\u0010\u0007\u001a\u00020\b*\u00020\u0004H\u0000\u001a\u0014\u0010\t\u001a\u00020\b*\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0000\u001a\u0014\u0010\n\u001a\u00020\b*\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0000\u001a\u001c\u0010\u000b\u001a\u00020\u0004*\u00020\f2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004H\u0002¨\u0006\u000f"}, d2 = {"detectFeatures", "", "Landroidx/graphics/shapes/Feature;", "cubics", "Landroidx/graphics/shapes/Cubic;", "asFeature", ES6Iterator.NEXT_METHOD, "straightIsh", "", "smoothesIntoIsh", "alignsIshWith", InterpolationAnimatedNode.EXTRAPOLATE_TYPE_EXTEND, "Landroidx/graphics/shapes/Cubic$Companion;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "b", "graphics-shapes"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class FeatureDetectorKt {
    public static final List<Feature> detectFeatures(List<? extends Cubic> cubics) {
        Intrinsics.checkNotNullParameter(cubics, "cubics");
        if (cubics.isEmpty()) {
            return CollectionsKt.emptyList();
        }
        List listCreateListBuilder = CollectionsKt.createListBuilder();
        Cubic cubicExtend = (Cubic) CollectionsKt.first((List) cubics);
        int size = cubics.size();
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            Cubic cubic = cubics.get(i2 % cubics.size());
            if (i < CollectionsKt.getLastIndex(cubics) && alignsIshWith(cubicExtend, cubic)) {
                cubicExtend = extend(Cubic.INSTANCE, cubicExtend, cubic);
            } else {
                listCreateListBuilder.add(asFeature(cubicExtend, cubic));
                if (!smoothesIntoIsh(cubicExtend, cubic)) {
                    listCreateListBuilder.add(asFeature(Cubic.INSTANCE.empty$graphics_shapes(cubicExtend.getAnchor1X(), cubicExtend.getAnchor1Y()), cubic));
                }
                cubicExtend = cubic;
            }
            i = i2;
        }
        return CollectionsKt.build(listCreateListBuilder);
    }

    public static final Feature asFeature(Cubic cubic, Cubic next) {
        Intrinsics.checkNotNullParameter(cubic, "<this>");
        Intrinsics.checkNotNullParameter(next, "next");
        return straightIsh(cubic) ? new Feature.Edge(CollectionsKt.listOf(cubic)) : new Feature.Corner(CollectionsKt.listOf(cubic), cubic.convexTo$graphics_shapes(next));
    }

    public static final boolean straightIsh(Cubic cubic) {
        Intrinsics.checkNotNullParameter(cubic, "<this>");
        return !cubic.zeroLength$graphics_shapes() && Utils.collinearIsh(cubic.getAnchor0X(), cubic.getAnchor0Y(), cubic.getAnchor1X(), cubic.getAnchor1Y(), cubic.getControl0X(), cubic.getControl0Y(), 0.005f) && Utils.collinearIsh(cubic.getAnchor0X(), cubic.getAnchor0Y(), cubic.getAnchor1X(), cubic.getAnchor1Y(), cubic.getControl1X(), cubic.getControl1Y(), 0.005f);
    }

    public static final boolean smoothesIntoIsh(Cubic cubic, Cubic next) {
        Intrinsics.checkNotNullParameter(cubic, "<this>");
        Intrinsics.checkNotNullParameter(next, "next");
        return Utils.collinearIsh(cubic.getControl1X(), cubic.getControl1Y(), next.getControl0X(), next.getControl0Y(), cubic.getAnchor1X(), cubic.getAnchor1Y(), 0.005f);
    }

    public static final boolean alignsIshWith(Cubic cubic, Cubic next) {
        Intrinsics.checkNotNullParameter(cubic, "<this>");
        Intrinsics.checkNotNullParameter(next, "next");
        return (straightIsh(cubic) && straightIsh(next) && smoothesIntoIsh(cubic, next)) || cubic.zeroLength$graphics_shapes() || next.zeroLength$graphics_shapes();
    }

    private static final Cubic extend(Cubic.Companion companion, Cubic cubic, Cubic cubic2) {
        if (cubic.zeroLength$graphics_shapes()) {
            return CubicKt.Cubic(cubic.getAnchor0X(), cubic.getAnchor0Y(), cubic2.getControl0X(), cubic2.getControl0Y(), cubic2.getControl1X(), cubic2.getControl1Y(), cubic2.getAnchor1X(), cubic2.getAnchor1Y());
        }
        return CubicKt.Cubic(cubic.getAnchor0X(), cubic.getAnchor0Y(), cubic.getControl0X(), cubic.getControl0Y(), cubic.getControl1X(), cubic.getControl1Y(), cubic2.getAnchor1X(), cubic2.getAnchor1Y());
    }
}
