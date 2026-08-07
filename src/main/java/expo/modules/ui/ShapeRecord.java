package expo.modules.ui;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ShapeView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BO\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0006HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u0010(\u001a\u00020\fHÆ\u0003JQ\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\u0013\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-HÖ\u0003J\t\u0010.\u001a\u00020\u0006HÖ\u0001J\t\u0010/\u001a\u000200HÖ\u0001R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012R\u001c\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0010\u001a\u0004\b\u0019\u0010\u0012R\u001c\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u0010\u001a\u0004\b\u001b\u0010\u0012R\u001e\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0010\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010\u0010\u001a\u0004\b \u0010!¨\u00061"}, d2 = {"Lexpo/modules/ui/ShapeRecord;", "Lexpo/modules/kotlin/records/Record;", "cornerRounding", "", "smoothing", "verticesCount", "", "innerRadius", "radius", "cornerRadii", "Lexpo/modules/ui/CornerRadii;", "type", "Lexpo/modules/ui/ShapeType;", "<init>", "(FFIFFLexpo/modules/ui/CornerRadii;Lexpo/modules/ui/ShapeType;)V", "getCornerRounding$annotations", "()V", "getCornerRounding", "()F", "getSmoothing$annotations", "getSmoothing", "getVerticesCount$annotations", "getVerticesCount", "()I", "getInnerRadius$annotations", "getInnerRadius", "getRadius$annotations", "getRadius", "getCornerRadii$annotations", "getCornerRadii", "()Lexpo/modules/ui/CornerRadii;", "getType$annotations", "getType", "()Lexpo/modules/ui/ShapeType;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "toString", "", "expo-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class ShapeRecord implements Record {
    public static final int $stable = 0;
    private final CornerRadii cornerRadii;
    private final float cornerRounding;
    private final float innerRadius;
    private final float radius;
    private final float smoothing;
    private final ShapeType type;
    private final int verticesCount;

    public ShapeRecord() {
        this(0.0f, 0.0f, 0, 0.0f, 0.0f, null, null, 127, null);
    }

    public static /* synthetic */ ShapeRecord copy$default(ShapeRecord shapeRecord, float f, float f2, int i, float f3, float f4, CornerRadii cornerRadii, ShapeType shapeType, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            f = shapeRecord.cornerRounding;
        }
        if ((i2 & 2) != 0) {
            f2 = shapeRecord.smoothing;
        }
        if ((i2 & 4) != 0) {
            i = shapeRecord.verticesCount;
        }
        if ((i2 & 8) != 0) {
            f3 = shapeRecord.innerRadius;
        }
        if ((i2 & 16) != 0) {
            f4 = shapeRecord.radius;
        }
        if ((i2 & 32) != 0) {
            cornerRadii = shapeRecord.cornerRadii;
        }
        if ((i2 & 64) != 0) {
            shapeType = shapeRecord.type;
        }
        CornerRadii cornerRadii2 = cornerRadii;
        ShapeType shapeType2 = shapeType;
        float f5 = f4;
        int i3 = i;
        return shapeRecord.copy(f, f2, i3, f3, f5, cornerRadii2, shapeType2);
    }

    @Field
    public static /* synthetic */ void getCornerRadii$annotations() {
    }

    @Field
    public static /* synthetic */ void getCornerRounding$annotations() {
    }

    @Field
    public static /* synthetic */ void getInnerRadius$annotations() {
    }

    @Field
    public static /* synthetic */ void getRadius$annotations() {
    }

    @Field
    public static /* synthetic */ void getSmoothing$annotations() {
    }

    @Field
    public static /* synthetic */ void getType$annotations() {
    }

    @Field
    public static /* synthetic */ void getVerticesCount$annotations() {
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

    public final ShapeRecord copy(float cornerRounding, float smoothing, int verticesCount, float innerRadius, float radius, CornerRadii cornerRadii, ShapeType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return new ShapeRecord(cornerRounding, smoothing, verticesCount, innerRadius, radius, cornerRadii, type);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ShapeRecord)) {
            return false;
        }
        ShapeRecord shapeRecord = (ShapeRecord) other;
        return Float.compare(this.cornerRounding, shapeRecord.cornerRounding) == 0 && Float.compare(this.smoothing, shapeRecord.smoothing) == 0 && this.verticesCount == shapeRecord.verticesCount && Float.compare(this.innerRadius, shapeRecord.innerRadius) == 0 && Float.compare(this.radius, shapeRecord.radius) == 0 && Intrinsics.areEqual(this.cornerRadii, shapeRecord.cornerRadii) && this.type == shapeRecord.type;
    }

    public int hashCode() {
        int iHashCode = ((((((((Float.hashCode(this.cornerRounding) * 31) + Float.hashCode(this.smoothing)) * 31) + Integer.hashCode(this.verticesCount)) * 31) + Float.hashCode(this.innerRadius)) * 31) + Float.hashCode(this.radius)) * 31;
        CornerRadii cornerRadii = this.cornerRadii;
        return ((iHashCode + (cornerRadii == null ? 0 : cornerRadii.hashCode())) * 31) + this.type.hashCode();
    }

    public String toString() {
        return "ShapeRecord(cornerRounding=" + this.cornerRounding + ", smoothing=" + this.smoothing + ", verticesCount=" + this.verticesCount + ", innerRadius=" + this.innerRadius + ", radius=" + this.radius + ", cornerRadii=" + this.cornerRadii + ", type=" + this.type + ")";
    }

    public ShapeRecord(float f, float f2, int i, float f3, float f4, CornerRadii cornerRadii, ShapeType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.cornerRounding = f;
        this.smoothing = f2;
        this.verticesCount = i;
        this.innerRadius = f3;
        this.radius = f4;
        this.cornerRadii = cornerRadii;
        this.type = type;
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

    public final ShapeType getType() {
        return this.type;
    }

    public /* synthetic */ ShapeRecord(float f, float f2, int i, float f3, float f4, CornerRadii cornerRadii, ShapeType shapeType, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0.0f : f, (i2 & 2) != 0 ? 0.0f : f2, (i2 & 4) != 0 ? 6 : i, (i2 & 8) != 0 ? 0.0f : f3, (i2 & 16) != 0 ? 0.0f : f4, (i2 & 32) != 0 ? null : cornerRadii, (i2 & 64) != 0 ? ShapeType.CIRCLE : shapeType);
    }
}
