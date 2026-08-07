package expo.modules.ui;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HostView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ&\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u000b\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u000b\u0012\u0004\b\f\u0010\b\u001a\u0004\b\r\u0010\n¨\u0006\u001a"}, d2 = {"Lexpo/modules/ui/LayoutContentEvent;", "Lexpo/modules/kotlin/records/Record;", "width", "", "height", "<init>", "(Ljava/lang/Double;Ljava/lang/Double;)V", "getWidth$annotations", "()V", "getWidth", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getHeight$annotations", "getHeight", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/Double;Ljava/lang/Double;)Lexpo/modules/ui/LayoutContentEvent;", "equals", "", "other", "", "hashCode", "", "toString", "", "expo-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class LayoutContentEvent implements Record {
    public static final int $stable = 0;
    private final Double height;
    private final Double width;

    public static /* synthetic */ LayoutContentEvent copy$default(LayoutContentEvent layoutContentEvent, Double d, Double d2, int i, Object obj) {
        if ((i & 1) != 0) {
            d = layoutContentEvent.width;
        }
        if ((i & 2) != 0) {
            d2 = layoutContentEvent.height;
        }
        return layoutContentEvent.copy(d, d2);
    }

    @Field
    public static /* synthetic */ void getHeight$annotations() {
    }

    @Field
    public static /* synthetic */ void getWidth$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Double getWidth() {
        return this.width;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Double getHeight() {
        return this.height;
    }

    public final LayoutContentEvent copy(Double width, Double height) {
        return new LayoutContentEvent(width, height);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LayoutContentEvent)) {
            return false;
        }
        LayoutContentEvent layoutContentEvent = (LayoutContentEvent) other;
        return Intrinsics.areEqual((Object) this.width, (Object) layoutContentEvent.width) && Intrinsics.areEqual((Object) this.height, (Object) layoutContentEvent.height);
    }

    public int hashCode() {
        Double d = this.width;
        int iHashCode = (d == null ? 0 : d.hashCode()) * 31;
        Double d2 = this.height;
        return iHashCode + (d2 != null ? d2.hashCode() : 0);
    }

    public String toString() {
        return "LayoutContentEvent(width=" + this.width + ", height=" + this.height + ")";
    }

    public LayoutContentEvent(Double d, Double d2) {
        this.width = d;
        this.height = d2;
    }

    public final Double getWidth() {
        return this.width;
    }

    public final Double getHeight() {
        return this.height;
    }
}
