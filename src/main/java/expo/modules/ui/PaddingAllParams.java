package expo.modules.ui;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ModifierRegistry.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\u0013"}, d2 = {"Lexpo/modules/ui/PaddingAllParams;", "Lexpo/modules/kotlin/records/Record;", "all", "", "<init>", "(I)V", "getAll$annotations", "()V", "getAll", "()I", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "toString", "", "expo-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class PaddingAllParams implements Record {
    public static final int $stable = 0;
    private final int all;

    public PaddingAllParams() {
        this(0, 1, null);
    }

    public static /* synthetic */ PaddingAllParams copy$default(PaddingAllParams paddingAllParams, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = paddingAllParams.all;
        }
        return paddingAllParams.copy(i);
    }

    @Field
    public static /* synthetic */ void getAll$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getAll() {
        return this.all;
    }

    public final PaddingAllParams copy(int all) {
        return new PaddingAllParams(all);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof PaddingAllParams) && this.all == ((PaddingAllParams) other).all;
    }

    public int hashCode() {
        return Integer.hashCode(this.all);
    }

    public String toString() {
        return "PaddingAllParams(all=" + this.all + ")";
    }

    public PaddingAllParams(int i) {
        this.all = i;
    }

    public /* synthetic */ PaddingAllParams(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i);
    }

    public final int getAll() {
        return this.all;
    }
}
