package expo.modules.ui.convertibles;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Arrangement.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u001a\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\rJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\n\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\u0015"}, d2 = {"Lexpo/modules/ui/convertibles/HorizontalArrangementCustom;", "Lexpo/modules/kotlin/records/Record;", "spacedBy", "", "<init>", "(Ljava/lang/Integer;)V", "getSpacedBy$annotations", "()V", "getSpacedBy", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/Integer;)Lexpo/modules/ui/convertibles/HorizontalArrangementCustom;", "equals", "", "other", "", "hashCode", "toString", "", "expo-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class HorizontalArrangementCustom implements Record {
    public static final int $stable = 0;
    private final Integer spacedBy;

    /* JADX WARN: Multi-variable type inference failed */
    public HorizontalArrangementCustom() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ HorizontalArrangementCustom copy$default(HorizontalArrangementCustom horizontalArrangementCustom, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            num = horizontalArrangementCustom.spacedBy;
        }
        return horizontalArrangementCustom.copy(num);
    }

    @Field
    public static /* synthetic */ void getSpacedBy$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Integer getSpacedBy() {
        return this.spacedBy;
    }

    public final HorizontalArrangementCustom copy(Integer spacedBy) {
        return new HorizontalArrangementCustom(spacedBy);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof HorizontalArrangementCustom) && Intrinsics.areEqual(this.spacedBy, ((HorizontalArrangementCustom) other).spacedBy);
    }

    public int hashCode() {
        Integer num = this.spacedBy;
        if (num == null) {
            return 0;
        }
        return num.hashCode();
    }

    public String toString() {
        return "HorizontalArrangementCustom(spacedBy=" + this.spacedBy + ")";
    }

    public HorizontalArrangementCustom(Integer num) {
        this.spacedBy = num;
    }

    public /* synthetic */ HorizontalArrangementCustom(Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num);
    }

    public final Integer getSpacedBy() {
        return this.spacedBy;
    }
}
