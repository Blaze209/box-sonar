package androidx.graphics.shapes;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PolygonValidation.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Landroidx/graphics/shapes/PolygonValidator;", "", "<init>", "()V", "Companion", "graphics-shapes"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PolygonValidator {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: PolygonValidation.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¨\u0006\n"}, d2 = {"Landroidx/graphics/shapes/PolygonValidator$Companion;", "", "<init>", "()V", "fix", "Landroidx/graphics/shapes/RoundedPolygon;", "polygon", "isCWOriented", "", "fixCWOrientation", "graphics-shapes"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final RoundedPolygon fix(RoundedPolygon polygon) {
            Intrinsics.checkNotNullParameter(polygon, "polygon");
            return isCWOriented(polygon) ? polygon : fixCWOrientation(polygon);
        }

        private final boolean isCWOriented(RoundedPolygon polygon) {
            int size = polygon.getCubics().size();
            float anchor1X = 0.0f;
            for (int i = 0; i < size; i++) {
                Cubic cubic = polygon.getCubics().get(i);
                anchor1X += (cubic.getAnchor1X() - cubic.getAnchor0X()) * (cubic.getAnchor1Y() + cubic.getAnchor0Y());
            }
            return anchor1X < 0.0f;
        }

        private final RoundedPolygon fixCWOrientation(RoundedPolygon polygon) {
            List listCreateListBuilder = CollectionsKt.createListBuilder();
            listCreateListBuilder.add(((Feature) CollectionsKt.first((List) polygon.getFeatures())).reversed());
            for (int lastIndex = CollectionsKt.getLastIndex(polygon.getFeatures()); lastIndex > 0; lastIndex--) {
                listCreateListBuilder.add(polygon.getFeatures().get(lastIndex).reversed());
            }
            return new RoundedPolygon(CollectionsKt.build(listCreateListBuilder), polygon.getCenter(), null);
        }
    }
}
