package androidx.graphics.shapes;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: Features.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b&\u0018\u0000 \u00132\u00020\u0001:\u0003\u0013\u0014\u0015B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\t\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\u0000H&R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0012\u0010\r\u001a\u00020\u000eX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000fR\u0012\u0010\u0010\u001a\u00020\u000eX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000fR\u0012\u0010\u0011\u001a\u00020\u000eX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000fR\u0012\u0010\u0012\u001a\u00020\u000eX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u000f¨\u0006\u0016"}, d2 = {"Landroidx/graphics/shapes/Feature;", "", "cubics", "", "Landroidx/graphics/shapes/Cubic;", "<init>", "(Ljava/util/List;)V", "getCubics", "()Ljava/util/List;", "transformed", "f", "Landroidx/graphics/shapes/PointTransformer;", "reversed", "isIgnorableFeature", "", "()Z", "isEdge", "isConvexCorner", "isConcaveCorner", "Factory", "Edge", "Corner", "graphics-shapes"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class Feature {

    /* JADX INFO: renamed from: Factory, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<Cubic> cubics;

    /* JADX INFO: renamed from: isConcaveCorner */
    public abstract boolean getIsConcaveCorner();

    /* JADX INFO: renamed from: isConvexCorner */
    public abstract boolean getIsConvexCorner();

    /* JADX INFO: renamed from: isEdge */
    public abstract boolean getIsEdge();

    /* JADX INFO: renamed from: isIgnorableFeature */
    public abstract boolean getIsIgnorableFeature();

    public abstract Feature reversed();

    public abstract Feature transformed(PointTransformer f);

    /* JADX WARN: Multi-variable type inference failed */
    public Feature(List<? extends Cubic> cubics) {
        Intrinsics.checkNotNullParameter(cubics, "cubics");
        this.cubics = cubics;
    }

    public final List<Cubic> getCubics() {
        return this.cubics;
    }

    /* JADX INFO: renamed from: androidx.graphics.shapes.Feature$Factory, reason: from kotlin metadata */
    /* JADX INFO: compiled from: Features.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\bJ\u0014\u0010\u000b\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\u0014\u0010\f\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005H\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u0005H\u0002¨\u0006\u0011"}, d2 = {"Landroidx/graphics/shapes/Feature$Factory;", "", "<init>", "()V", "buildIgnorableFeature", "Landroidx/graphics/shapes/Feature;", "cubics", "", "Landroidx/graphics/shapes/Cubic;", "buildEdge", "cubic", "buildConvexCorner", "buildConcaveCorner", "validated", "feature", "isContinuous", "", "graphics-shapes"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Feature buildIgnorableFeature(List<? extends Cubic> cubics) {
            Intrinsics.checkNotNullParameter(cubics, "cubics");
            return validated(new Edge(cubics));
        }

        public final Feature buildEdge(Cubic cubic) {
            Intrinsics.checkNotNullParameter(cubic, "cubic");
            return new Edge(CollectionsKt.listOf(cubic));
        }

        public final Feature buildConvexCorner(List<? extends Cubic> cubics) {
            Intrinsics.checkNotNullParameter(cubics, "cubics");
            return validated(new Corner(cubics, true));
        }

        public final Feature buildConcaveCorner(List<? extends Cubic> cubics) {
            Intrinsics.checkNotNullParameter(cubics, "cubics");
            return validated(new Corner(cubics, false));
        }

        private final Feature validated(Feature feature) {
            if (feature.getCubics().isEmpty()) {
                throw new IllegalArgumentException("Features need at least one cubic.".toString());
            }
            if (isContinuous(feature)) {
                return feature;
            }
            throw new IllegalArgumentException("Feature must be continuous, with the anchor points of all cubics matching the anchor points of the preceding and succeeding cubics".toString());
        }

        private final boolean isContinuous(Feature feature) {
            Cubic cubic = (Cubic) CollectionsKt.first((List) feature.getCubics());
            int lastIndex = CollectionsKt.getLastIndex(feature.getCubics());
            if (1 <= lastIndex) {
                int i = 1;
                while (true) {
                    Cubic cubic2 = feature.getCubics().get(i);
                    if (Math.abs(cubic2.getAnchor0X() - cubic.getAnchor1X()) > 1.0E-4f || Math.abs(cubic2.getAnchor0Y() - cubic.getAnchor1Y()) > 1.0E-4f) {
                        return false;
                    }
                    if (i != lastIndex) {
                        i++;
                        cubic = cubic2;
                    }
                }
            }
            return true;
        }
    }

    /* JADX INFO: compiled from: Features.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0000H\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016R\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000f¨\u0006\u0013"}, d2 = {"Landroidx/graphics/shapes/Feature$Edge;", "Landroidx/graphics/shapes/Feature;", "cubics", "", "Landroidx/graphics/shapes/Cubic;", "<init>", "(Ljava/util/List;)V", "transformed", "f", "Landroidx/graphics/shapes/PointTransformer;", "reversed", "toString", "", "isIgnorableFeature", "", "()Z", "isEdge", "isConvexCorner", "isConcaveCorner", "graphics-shapes"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Edge extends Feature {
        private final boolean isConcaveCorner;
        private final boolean isConvexCorner;
        private final boolean isEdge;
        private final boolean isIgnorableFeature;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Edge(List<? extends Cubic> cubics) {
            super(cubics);
            Intrinsics.checkNotNullParameter(cubics, "cubics");
            this.isIgnorableFeature = true;
            this.isEdge = true;
        }

        @Override // androidx.graphics.shapes.Feature
        public Edge transformed(PointTransformer f) {
            Intrinsics.checkNotNullParameter(f, "f");
            List listCreateListBuilder = CollectionsKt.createListBuilder();
            int size = getCubics().size();
            for (int i = 0; i < size; i++) {
                listCreateListBuilder.add(getCubics().get(i).transformed(f));
            }
            return new Edge(CollectionsKt.build(listCreateListBuilder));
        }

        @Override // androidx.graphics.shapes.Feature
        public Edge reversed() {
            ArrayList arrayList = new ArrayList();
            for (int lastIndex = CollectionsKt.getLastIndex(getCubics()); -1 < lastIndex; lastIndex--) {
                arrayList.add(getCubics().get(lastIndex).reverse());
            }
            return new Edge(arrayList);
        }

        public String toString() {
            return "Edge";
        }

        @Override // androidx.graphics.shapes.Feature
        /* JADX INFO: renamed from: isIgnorableFeature, reason: from getter */
        public boolean getIsIgnorableFeature() {
            return this.isIgnorableFeature;
        }

        @Override // androidx.graphics.shapes.Feature
        /* JADX INFO: renamed from: isEdge, reason: from getter */
        public boolean getIsEdge() {
            return this.isEdge;
        }

        @Override // androidx.graphics.shapes.Feature
        /* JADX INFO: renamed from: isConvexCorner, reason: from getter */
        public boolean getIsConvexCorner() {
            return this.isConvexCorner;
        }

        @Override // androidx.graphics.shapes.Feature
        /* JADX INFO: renamed from: isConcaveCorner, reason: from getter */
        public boolean getIsConcaveCorner() {
            return this.isConcaveCorner;
        }
    }

    /* JADX INFO: compiled from: Features.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u0000H\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0011\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\nR\u0014\u0010\u0012\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\nR\u0014\u0010\u0013\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\nR\u0014\u0010\u0014\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\n¨\u0006\u0015"}, d2 = {"Landroidx/graphics/shapes/Feature$Corner;", "Landroidx/graphics/shapes/Feature;", "cubics", "", "Landroidx/graphics/shapes/Cubic;", "convex", "", "<init>", "(Ljava/util/List;Z)V", "getConvex", "()Z", "transformed", "f", "Landroidx/graphics/shapes/PointTransformer;", "reversed", "toString", "", "isIgnorableFeature", "isEdge", "isConvexCorner", "isConcaveCorner", "graphics-shapes"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Corner extends Feature {
        private final boolean convex;
        private final boolean isConcaveCorner;
        private final boolean isConvexCorner;
        private final boolean isEdge;
        private final boolean isIgnorableFeature;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Corner(List<? extends Cubic> cubics, boolean z) {
            super(cubics);
            Intrinsics.checkNotNullParameter(cubics, "cubics");
            this.convex = z;
            this.isConvexCorner = z;
            this.isConcaveCorner = !z;
        }

        public /* synthetic */ Corner(List list, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(list, (i & 2) != 0 ? true : z);
        }

        public final boolean getConvex() {
            return this.convex;
        }

        @Override // androidx.graphics.shapes.Feature
        public Feature transformed(PointTransformer f) {
            Intrinsics.checkNotNullParameter(f, "f");
            List listCreateListBuilder = CollectionsKt.createListBuilder();
            int size = getCubics().size();
            for (int i = 0; i < size; i++) {
                listCreateListBuilder.add(getCubics().get(i).transformed(f));
            }
            return new Corner(CollectionsKt.build(listCreateListBuilder), this.convex);
        }

        @Override // androidx.graphics.shapes.Feature
        public Corner reversed() {
            ArrayList arrayList = new ArrayList();
            for (int lastIndex = CollectionsKt.getLastIndex(getCubics()); -1 < lastIndex; lastIndex--) {
                arrayList.add(getCubics().get(lastIndex).reverse());
            }
            return new Corner(arrayList, !this.convex);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final CharSequence toString$lambda$1(Cubic it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return "[" + it + AbstractJsonLexerKt.END_LIST;
        }

        public String toString() {
            return "Corner: cubics=" + CollectionsKt.joinToString$default(getCubics(), ", ", null, null, 0, null, new Function1() { // from class: androidx.graphics.shapes.Feature$Corner$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Feature.Corner.toString$lambda$1((Cubic) obj);
                }
            }, 30, null) + " convex=" + this.convex;
        }

        @Override // androidx.graphics.shapes.Feature
        /* JADX INFO: renamed from: isIgnorableFeature, reason: from getter */
        public boolean getIsIgnorableFeature() {
            return this.isIgnorableFeature;
        }

        @Override // androidx.graphics.shapes.Feature
        /* JADX INFO: renamed from: isEdge, reason: from getter */
        public boolean getIsEdge() {
            return this.isEdge;
        }

        @Override // androidx.graphics.shapes.Feature
        /* JADX INFO: renamed from: isConvexCorner, reason: from getter */
        public boolean getIsConvexCorner() {
            return this.isConvexCorner;
        }

        @Override // androidx.graphics.shapes.Feature
        /* JADX INFO: renamed from: isConcaveCorner, reason: from getter */
        public boolean getIsConcaveCorner() {
            return this.isConcaveCorner;
        }
    }
}
