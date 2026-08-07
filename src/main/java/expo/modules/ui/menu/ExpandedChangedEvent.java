package expo.modules.ui.menu;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import kotlin.Metadata;

/* JADX INFO: compiled from: ContextMenu.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\u0013"}, d2 = {"Lexpo/modules/ui/menu/ExpandedChangedEvent;", "Lexpo/modules/kotlin/records/Record;", "expanded", "", "<init>", "(Z)V", "getExpanded$annotations", "()V", "getExpanded", "()Z", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "", "hashCode", "", "toString", "", "expo-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class ExpandedChangedEvent implements Record {
    public static final int $stable = 0;
    private final boolean expanded;

    public static /* synthetic */ ExpandedChangedEvent copy$default(ExpandedChangedEvent expandedChangedEvent, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = expandedChangedEvent.expanded;
        }
        return expandedChangedEvent.copy(z);
    }

    @Field
    public static /* synthetic */ void getExpanded$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getExpanded() {
        return this.expanded;
    }

    public final ExpandedChangedEvent copy(boolean expanded) {
        return new ExpandedChangedEvent(expanded);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ExpandedChangedEvent) && this.expanded == ((ExpandedChangedEvent) other).expanded;
    }

    public int hashCode() {
        return Boolean.hashCode(this.expanded);
    }

    public String toString() {
        return "ExpandedChangedEvent(expanded=" + this.expanded + ")";
    }

    public ExpandedChangedEvent(boolean z) {
        this.expanded = z;
    }

    public final boolean getExpanded() {
        return this.expanded;
    }
}
