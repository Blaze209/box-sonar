package expo.modules.ui;

import android.graphics.Color;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import expo.modules.kotlin.views.ComposeProps;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ShapeView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u0081\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012$\b\u0002\u0010\u000f\u001a\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0011j\u0002`\u00140\u0010j\u0002`\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0006HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u0010-\u001a\u00020\fHÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u000eHÆ\u0003J%\u0010/\u001a\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0011j\u0002`\u00140\u0010j\u0002`\u0015HÆ\u0003J\u0083\u0001\u00100\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2$\b\u0002\u0010\u000f\u001a\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0011j\u0002`\u00140\u0010j\u0002`\u0015HÆ\u0001J\u0013\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u00104\u001a\u00020\u0006HÖ\u0001J\t\u00105\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0019R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R-\u0010\u000f\u001a\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0011j\u0002`\u00140\u0010j\u0002`\u0015¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&¨\u00066"}, d2 = {"Lexpo/modules/ui/ShapeProps;", "Lexpo/modules/kotlin/views/ComposeProps;", "cornerRounding", "", "smoothing", "verticesCount", "", "innerRadius", "radius", "cornerRadii", "Lexpo/modules/ui/CornerRadii;", "type", "Lexpo/modules/ui/ShapeType;", "color", "Landroid/graphics/Color;", "modifiers", "", "", "", "", "Lexpo/modules/ui/ModifierType;", "Lexpo/modules/ui/ModifierList;", "<init>", "(FFIFFLexpo/modules/ui/CornerRadii;Lexpo/modules/ui/ShapeType;Landroid/graphics/Color;Ljava/util/List;)V", "getCornerRounding", "()F", "getSmoothing", "getVerticesCount", "()I", "getInnerRadius", "getRadius", "getCornerRadii", "()Lexpo/modules/ui/CornerRadii;", "getType", "()Lexpo/modules/ui/ShapeType;", "getColor", "()Landroid/graphics/Color;", "getModifiers", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "toString", "expo-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class ShapeProps implements ComposeProps {
    public static final int $stable = 8;
    private final Color color;
    private final CornerRadii cornerRadii;
    private final float cornerRounding;
    private final float innerRadius;
    private final List<Map<String, Object>> modifiers;
    private final float radius;
    private final float smoothing;
    private final ShapeType type;
    private final int verticesCount;

    public ShapeProps() {
        this(0.0f, 0.0f, 0, 0.0f, 0.0f, null, null, null, null, 511, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ShapeProps copy$default(ShapeProps shapeProps, float f, float f2, int i, float f3, float f4, CornerRadii cornerRadii, ShapeType shapeType, Color color, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            f = shapeProps.cornerRounding;
        }
        if ((i2 & 2) != 0) {
            f2 = shapeProps.smoothing;
        }
        if ((i2 & 4) != 0) {
            i = shapeProps.verticesCount;
        }
        if ((i2 & 8) != 0) {
            f3 = shapeProps.innerRadius;
        }
        if ((i2 & 16) != 0) {
            f4 = shapeProps.radius;
        }
        if ((i2 & 32) != 0) {
            cornerRadii = shapeProps.cornerRadii;
        }
        if ((i2 & 64) != 0) {
            shapeType = shapeProps.type;
        }
        if ((i2 & 128) != 0) {
            color = shapeProps.color;
        }
        if ((i2 & 256) != 0) {
            list = shapeProps.modifiers;
        }
        Color color2 = color;
        List list2 = list;
        CornerRadii cornerRadii2 = cornerRadii;
        ShapeType shapeType2 = shapeType;
        float f5 = f4;
        int i3 = i;
        return shapeProps.copy(f, f2, i3, f3, f5, cornerRadii2, shapeType2, color2, list2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final float getCornerRounding() {
        return this.cornerRounding;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final float getSmoothing() {
        return this.smoothing;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getVerticesCount() {
        return this.verticesCount;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final float getInnerRadius() {
        return this.innerRadius;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final float getRadius() {
        return this.radius;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final CornerRadii getCornerRadii() {
        return this.cornerRadii;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final ShapeType getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Color getColor() {
        return this.color;
    }

    public final List<Map<String, Object>> component9() {
        return this.modifiers;
    }

    public final ShapeProps copy(float cornerRounding, float smoothing, int verticesCount, float innerRadius, float radius, CornerRadii cornerRadii, ShapeType type, Color color, List<? extends Map<String, ? extends Object>> modifiers) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        return new ShapeProps(cornerRounding, smoothing, verticesCount, innerRadius, radius, cornerRadii, type, color, modifiers);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ShapeProps)) {
            return false;
        }
        ShapeProps shapeProps = (ShapeProps) other;
        return Float.compare(this.cornerRounding, shapeProps.cornerRounding) == 0 && Float.compare(this.smoothing, shapeProps.smoothing) == 0 && this.verticesCount == shapeProps.verticesCount && Float.compare(this.innerRadius, shapeProps.innerRadius) == 0 && Float.compare(this.radius, shapeProps.radius) == 0 && Intrinsics.areEqual(this.cornerRadii, shapeProps.cornerRadii) && this.type == shapeProps.type && Intrinsics.areEqual(this.color, shapeProps.color) && Intrinsics.areEqual(this.modifiers, shapeProps.modifiers);
    }

    public int hashCode() {
        int iHashCode = ((((((((Float.hashCode(this.cornerRounding) * 31) + Float.hashCode(this.smoothing)) * 31) + Integer.hashCode(this.verticesCount)) * 31) + Float.hashCode(this.innerRadius)) * 31) + Float.hashCode(this.radius)) * 31;
        CornerRadii cornerRadii = this.cornerRadii;
        int iHashCode2 = (((iHashCode + (cornerRadii == null ? 0 : cornerRadii.hashCode())) * 31) + this.type.hashCode()) * 31;
        Color color = this.color;
        return ((iHashCode2 + (color != null ? color.hashCode() : 0)) * 31) + this.modifiers.hashCode();
    }

    public String toString() {
        return "ShapeProps(cornerRounding=" + this.cornerRounding + ", smoothing=" + this.smoothing + ", verticesCount=" + this.verticesCount + ", innerRadius=" + this.innerRadius + ", radius=" + this.radius + ", cornerRadii=" + this.cornerRadii + ", type=" + this.type + ", color=" + this.color + ", modifiers=" + this.modifiers + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ShapeProps(float f, float f2, int i, float f3, float f4, CornerRadii cornerRadii, ShapeType type, Color color, List<? extends Map<String, ? extends Object>> modifiers) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        this.cornerRounding = f;
        this.smoothing = f2;
        this.verticesCount = i;
        this.innerRadius = f3;
        this.radius = f4;
        this.cornerRadii = cornerRadii;
        this.type = type;
        this.color = color;
        this.modifiers = modifiers;
    }

    public final float getCornerRounding() {
        return this.cornerRounding;
    }

    public final float getSmoothing() {
        return this.smoothing;
    }

    public final int getVerticesCount() {
        return this.verticesCount;
    }

    public final float getInnerRadius() {
        return this.innerRadius;
    }

    public final float getRadius() {
        return this.radius;
    }

    public final CornerRadii getCornerRadii() {
        return this.cornerRadii;
    }

    public /* synthetic */ ShapeProps(float f, float f2, int i, float f3, float f4, CornerRadii cornerRadii, ShapeType shapeType, Color color, List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0.0f : f, (i2 & 2) != 0 ? 0.0f : f2, (i2 & 4) != 0 ? 6 : i, (i2 & 8) != 0 ? 0.0f : f3, (i2 & 16) != 0 ? 0.0f : f4, (i2 & 32) != 0 ? null : cornerRadii, (i2 & 64) != 0 ? ShapeType.CIRCLE : shapeType, (i2 & 128) != 0 ? null : color, (i2 & 256) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final ShapeType getType() {
        return this.type;
    }

    public final Color getColor() {
        return this.color;
    }

    public final List<Map<String, Object>> getModifiers() {
        return this.modifiers;
    }
}
