package expo.modules.ui;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ShapeView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J1\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR\u001c\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\fR\u001c\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\n\u001a\u0004\b\u0012\u0010\f¨\u0006 "}, d2 = {"Lexpo/modules/ui/CornerRadii;", "Lexpo/modules/kotlin/records/Record;", "topStart", "", "topEnd", "bottomStart", "bottomEnd", "<init>", "(FFFF)V", "getTopStart$annotations", "()V", "getTopStart", "()F", "getTopEnd$annotations", "getTopEnd", "getBottomStart$annotations", "getBottomStart", "getBottomEnd$annotations", "getBottomEnd", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "expo-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class CornerRadii implements Record {
    public static final int $stable = 0;
    private final float bottomEnd;
    private final float bottomStart;
    private final float topEnd;
    private final float topStart;

    public CornerRadii() {
        this(0.0f, 0.0f, 0.0f, 0.0f, 15, null);
    }

    public static /* synthetic */ CornerRadii copy$default(CornerRadii cornerRadii, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = cornerRadii.topStart;
        }
        if ((i & 2) != 0) {
            f2 = cornerRadii.topEnd;
        }
        if ((i & 4) != 0) {
            f3 = cornerRadii.bottomStart;
        }
        if ((i & 8) != 0) {
            f4 = cornerRadii.bottomEnd;
        }
        return cornerRadii.copy(f, f2, f3, f4);
    }

    @Field
    public static /* synthetic */ void getBottomEnd$annotations() {
    }

    @Field
    public static /* synthetic */ void getBottomStart$annotations() {
    }

    @Field
    public static /* synthetic */ void getTopEnd$annotations() {
    }

    @Field
    public static /* synthetic */ void getTopStart$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final float getTopStart() {
        return this.topStart;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final float getTopEnd() {
        return this.topEnd;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final float getBottomStart() {
        return this.bottomStart;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final float getBottomEnd() {
        return this.bottomEnd;
    }

    public final CornerRadii copy(float topStart, float topEnd, float bottomStart, float bottomEnd) {
        return new CornerRadii(topStart, topEnd, bottomStart, bottomEnd);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CornerRadii)) {
            return false;
        }
        CornerRadii cornerRadii = (CornerRadii) other;
        return Float.compare(this.topStart, cornerRadii.topStart) == 0 && Float.compare(this.topEnd, cornerRadii.topEnd) == 0 && Float.compare(this.bottomStart, cornerRadii.bottomStart) == 0 && Float.compare(this.bottomEnd, cornerRadii.bottomEnd) == 0;
    }

    public int hashCode() {
        return (((((Float.hashCode(this.topStart) * 31) + Float.hashCode(this.topEnd)) * 31) + Float.hashCode(this.bottomStart)) * 31) + Float.hashCode(this.bottomEnd);
    }

    public String toString() {
        return "CornerRadii(topStart=" + this.topStart + ", topEnd=" + this.topEnd + ", bottomStart=" + this.bottomStart + ", bottomEnd=" + this.bottomEnd + ")";
    }

    public CornerRadii(float f, float f2, float f3, float f4) {
        this.topStart = f;
        this.topEnd = f2;
        this.bottomStart = f3;
        this.bottomEnd = f4;
    }

    public /* synthetic */ CornerRadii(float f, float f2, float f3, float f4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0.0f : f, (i & 2) != 0 ? 0.0f : f2, (i & 4) != 0 ? 0.0f : f3, (i & 8) != 0 ? 0.0f : f4);
    }

    public final float getTopStart() {
        return this.topStart;
    }

    public final float getTopEnd() {
        return this.topEnd;
    }

    public final float getBottomStart() {
        return this.bottomStart;
    }

    public final float getBottomEnd() {
        return this.bottomEnd;
    }
}
