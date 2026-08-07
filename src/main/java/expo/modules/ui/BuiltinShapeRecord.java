package expo.modules.ui;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ModifierRegistry.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001BY\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010!\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010$\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010%\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010&\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0014J\u000b\u0010'\u001a\u0004\u0018\u00010\u000bHÆ\u0003J`\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010)J\u0013\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-HÖ\u0003J\t\u0010.\u001a\u00020/HÖ\u0001J\t\u00100\u001a\u000201HÖ\u0001R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0015\u0012\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0014R \u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0015\u0012\u0004\b\u0016\u0010\u000f\u001a\u0004\b\u0017\u0010\u0014R \u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0015\u0012\u0004\b\u0018\u0010\u000f\u001a\u0004\b\u0019\u0010\u0014R \u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0015\u0012\u0004\b\u001a\u0010\u000f\u001a\u0004\b\u001b\u0010\u0014R \u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0015\u0012\u0004\b\u001c\u0010\u000f\u001a\u0004\b\u001d\u0010\u0014R\u001e\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u000f\u001a\u0004\b\u001f\u0010 ¨\u00062"}, d2 = {"Lexpo/modules/ui/BuiltinShapeRecord;", "Lexpo/modules/kotlin/records/Record;", "type", "Lexpo/modules/ui/BuiltinShapeType;", "radius", "", "topStart", "topEnd", "bottomStart", "bottomEnd", "name", "Lexpo/modules/ui/MaterialShapeType;", "<init>", "(Lexpo/modules/ui/BuiltinShapeType;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Lexpo/modules/ui/MaterialShapeType;)V", "getType$annotations", "()V", "getType", "()Lexpo/modules/ui/BuiltinShapeType;", "getRadius$annotations", "getRadius", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getTopStart$annotations", "getTopStart", "getTopEnd$annotations", "getTopEnd", "getBottomStart$annotations", "getBottomStart", "getBottomEnd$annotations", "getBottomEnd", "getName$annotations", "getName", "()Lexpo/modules/ui/MaterialShapeType;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Lexpo/modules/ui/BuiltinShapeType;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Lexpo/modules/ui/MaterialShapeType;)Lexpo/modules/ui/BuiltinShapeRecord;", "equals", "", "other", "", "hashCode", "", "toString", "", "expo-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class BuiltinShapeRecord implements Record {
    public static final int $stable = 0;
    private final Float bottomEnd;
    private final Float bottomStart;
    private final MaterialShapeType name;
    private final Float radius;
    private final Float topEnd;
    private final Float topStart;
    private final BuiltinShapeType type;

    public BuiltinShapeRecord() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ BuiltinShapeRecord copy$default(BuiltinShapeRecord builtinShapeRecord, BuiltinShapeType builtinShapeType, Float f, Float f2, Float f3, Float f4, Float f5, MaterialShapeType materialShapeType, int i, Object obj) {
        if ((i & 1) != 0) {
            builtinShapeType = builtinShapeRecord.type;
        }
        if ((i & 2) != 0) {
            f = builtinShapeRecord.radius;
        }
        if ((i & 4) != 0) {
            f2 = builtinShapeRecord.topStart;
        }
        if ((i & 8) != 0) {
            f3 = builtinShapeRecord.topEnd;
        }
        if ((i & 16) != 0) {
            f4 = builtinShapeRecord.bottomStart;
        }
        if ((i & 32) != 0) {
            f5 = builtinShapeRecord.bottomEnd;
        }
        if ((i & 64) != 0) {
            materialShapeType = builtinShapeRecord.name;
        }
        Float f6 = f5;
        MaterialShapeType materialShapeType2 = materialShapeType;
        Float f7 = f4;
        Float f8 = f2;
        return builtinShapeRecord.copy(builtinShapeType, f, f8, f3, f7, f6, materialShapeType2);
    }

    @Field
    public static /* synthetic */ void getBottomEnd$annotations() {
    }

    @Field
    public static /* synthetic */ void getBottomStart$annotations() {
    }

    @Field
    public static /* synthetic */ void getName$annotations() {
    }

    @Field
    public static /* synthetic */ void getRadius$annotations() {
    }

    @Field
    public static /* synthetic */ void getTopEnd$annotations() {
    }

    @Field
    public static /* synthetic */ void getTopStart$annotations() {
    }

    @Field
    public static /* synthetic */ void getType$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final BuiltinShapeType getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Float getRadius() {
        return this.radius;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Float getTopStart() {
        return this.topStart;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Float getTopEnd() {
        return this.topEnd;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Float getBottomStart() {
        return this.bottomStart;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Float getBottomEnd() {
        return this.bottomEnd;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final MaterialShapeType getName() {
        return this.name;
    }

    public final BuiltinShapeRecord copy(BuiltinShapeType type, Float radius, Float topStart, Float topEnd, Float bottomStart, Float bottomEnd, MaterialShapeType name) {
        Intrinsics.checkNotNullParameter(type, "type");
        return new BuiltinShapeRecord(type, radius, topStart, topEnd, bottomStart, bottomEnd, name);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BuiltinShapeRecord)) {
            return false;
        }
        BuiltinShapeRecord builtinShapeRecord = (BuiltinShapeRecord) other;
        return this.type == builtinShapeRecord.type && Intrinsics.areEqual((Object) this.radius, (Object) builtinShapeRecord.radius) && Intrinsics.areEqual((Object) this.topStart, (Object) builtinShapeRecord.topStart) && Intrinsics.areEqual((Object) this.topEnd, (Object) builtinShapeRecord.topEnd) && Intrinsics.areEqual((Object) this.bottomStart, (Object) builtinShapeRecord.bottomStart) && Intrinsics.areEqual((Object) this.bottomEnd, (Object) builtinShapeRecord.bottomEnd) && this.name == builtinShapeRecord.name;
    }

    public int hashCode() {
        int iHashCode = this.type.hashCode() * 31;
        Float f = this.radius;
        int iHashCode2 = (iHashCode + (f == null ? 0 : f.hashCode())) * 31;
        Float f2 = this.topStart;
        int iHashCode3 = (iHashCode2 + (f2 == null ? 0 : f2.hashCode())) * 31;
        Float f3 = this.topEnd;
        int iHashCode4 = (iHashCode3 + (f3 == null ? 0 : f3.hashCode())) * 31;
        Float f4 = this.bottomStart;
        int iHashCode5 = (iHashCode4 + (f4 == null ? 0 : f4.hashCode())) * 31;
        Float f5 = this.bottomEnd;
        int iHashCode6 = (iHashCode5 + (f5 == null ? 0 : f5.hashCode())) * 31;
        MaterialShapeType materialShapeType = this.name;
        return iHashCode6 + (materialShapeType != null ? materialShapeType.hashCode() : 0);
    }

    public String toString() {
        return "BuiltinShapeRecord(type=" + this.type + ", radius=" + this.radius + ", topStart=" + this.topStart + ", topEnd=" + this.topEnd + ", bottomStart=" + this.bottomStart + ", bottomEnd=" + this.bottomEnd + ", name=" + this.name + ")";
    }

    public BuiltinShapeRecord(BuiltinShapeType type, Float f, Float f2, Float f3, Float f4, Float f5, MaterialShapeType materialShapeType) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.type = type;
        this.radius = f;
        this.topStart = f2;
        this.topEnd = f3;
        this.bottomStart = f4;
        this.bottomEnd = f5;
        this.name = materialShapeType;
    }

    public /* synthetic */ BuiltinShapeRecord(BuiltinShapeType builtinShapeType, Float f, Float f2, Float f3, Float f4, Float f5, MaterialShapeType materialShapeType, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? BuiltinShapeType.RECTANGLE : builtinShapeType, (i & 2) != 0 ? null : f, (i & 4) != 0 ? null : f2, (i & 8) != 0 ? null : f3, (i & 16) != 0 ? null : f4, (i & 32) != 0 ? null : f5, (i & 64) != 0 ? null : materialShapeType);
    }

    public final BuiltinShapeType getType() {
        return this.type;
    }

    public final Float getRadius() {
        return this.radius;
    }

    public final Float getTopStart() {
        return this.topStart;
    }

    public final Float getTopEnd() {
        return this.topEnd;
    }

    public final Float getBottomStart() {
        return this.bottomStart;
    }

    public final Float getBottomEnd() {
        return this.bottomEnd;
    }

    public final MaterialShapeType getName() {
        return this.name;
    }
}
