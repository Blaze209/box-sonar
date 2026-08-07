package expo.modules.ui;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ModifierRegistry.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\u0013"}, d2 = {"Lexpo/modules/ui/ShadowParams;", "Lexpo/modules/kotlin/records/Record;", "elevation", "", "<init>", "(I)V", "getElevation$annotations", "()V", "getElevation", "()I", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "toString", "", "expo-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class ShadowParams implements Record {
    public static final int $stable = 0;
    private final int elevation;

    public ShadowParams() {
        this(0, 1, null);
    }

    public static /* synthetic */ ShadowParams copy$default(ShadowParams shadowParams, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = shadowParams.elevation;
        }
        return shadowParams.copy(i);
    }

    @Field
    public static /* synthetic */ void getElevation$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getElevation() {
        return this.elevation;
    }

    public final ShadowParams copy(int elevation) {
        return new ShadowParams(elevation);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ShadowParams) && this.elevation == ((ShadowParams) other).elevation;
    }

    public int hashCode() {
        return Integer.hashCode(this.elevation);
    }

    public String toString() {
        return "ShadowParams(elevation=" + this.elevation + ")";
    }

    public ShadowParams(int i) {
        this.elevation = i;
    }

    public /* synthetic */ ShadowParams(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i);
    }

    public final int getElevation() {
        return this.elevation;
    }
}
