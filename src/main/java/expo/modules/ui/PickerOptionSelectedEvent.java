package expo.modules.ui;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.google.firebase.analytics.FirebaseAnalytics;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PickerView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lexpo/modules/ui/PickerOptionSelectedEvent;", "Lexpo/modules/kotlin/records/Record;", FirebaseAnalytics.Param.INDEX, "", "label", "", "<init>", "(ILjava/lang/String;)V", "getIndex$annotations", "()V", "getIndex", "()I", "getLabel$annotations", "getLabel", "()Ljava/lang/String;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "toString", "expo-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class PickerOptionSelectedEvent implements Record {
    public static final int $stable = 0;
    private final int index;
    private final String label;

    public static /* synthetic */ PickerOptionSelectedEvent copy$default(PickerOptionSelectedEvent pickerOptionSelectedEvent, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = pickerOptionSelectedEvent.index;
        }
        if ((i2 & 2) != 0) {
            str = pickerOptionSelectedEvent.label;
        }
        return pickerOptionSelectedEvent.copy(i, str);
    }

    @Field
    public static /* synthetic */ void getIndex$annotations() {
    }

    @Field
    public static /* synthetic */ void getLabel$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getIndex() {
        return this.index;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getLabel() {
        return this.label;
    }

    public final PickerOptionSelectedEvent copy(int index, String label) {
        Intrinsics.checkNotNullParameter(label, "label");
        return new PickerOptionSelectedEvent(index, label);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PickerOptionSelectedEvent)) {
            return false;
        }
        PickerOptionSelectedEvent pickerOptionSelectedEvent = (PickerOptionSelectedEvent) other;
        return this.index == pickerOptionSelectedEvent.index && Intrinsics.areEqual(this.label, pickerOptionSelectedEvent.label);
    }

    public int hashCode() {
        return (Integer.hashCode(this.index) * 31) + this.label.hashCode();
    }

    public String toString() {
        return "PickerOptionSelectedEvent(index=" + this.index + ", label=" + this.label + ")";
    }

    public PickerOptionSelectedEvent(int i, String label) {
        Intrinsics.checkNotNullParameter(label, "label");
        this.index = i;
        this.label = label;
    }

    public final int getIndex() {
        return this.index;
    }

    public final String getLabel() {
        return this.label;
    }
}
