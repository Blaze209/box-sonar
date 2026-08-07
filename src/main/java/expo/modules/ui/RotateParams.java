package expo.modules.ui;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ModifierRegistry.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lexpo/modules/ui/RotateParams;", "Lexpo/modules/kotlin/records/Record;", "degrees", "", "<init>", "(F)V", "getDegrees$annotations", "()V", "getDegrees", "()F", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "expo-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class RotateParams implements Record {
    public static final int $stable = 0;
    private final float degrees;

    public RotateParams() {
        this(0.0f, 1, null);
    }

    public static /* synthetic */ RotateParams copy$default(RotateParams rotateParams, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            f = rotateParams.degrees;
        }
        return rotateParams.copy(f);
    }

    @Field
    public static /* synthetic */ void getDegrees$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final float getDegrees() {
        return this.degrees;
    }

    public final RotateParams copy(float degrees) {
        return new RotateParams(degrees);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof RotateParams) && Float.compare(this.degrees, ((RotateParams) other).degrees) == 0;
    }

    public int hashCode() {
        return Float.hashCode(this.degrees);
    }

    public String toString() {
        return "RotateParams(degrees=" + this.degrees + ")";
    }

    public RotateParams(float f) {
        this.degrees = f;
    }

    public /* synthetic */ RotateParams(float f, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0.0f : f);
    }

    public final float getDegrees() {
        return this.degrees;
    }
}
