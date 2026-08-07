package expo.modules.ui;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import expo.modules.kotlin.views.ComposeProps;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SlotView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0004HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lexpo/modules/ui/SlotProps;", "Lexpo/modules/kotlin/views/ComposeProps;", "slotName", "Landroidx/compose/runtime/MutableState;", "", "<init>", "(Landroidx/compose/runtime/MutableState;)V", "getSlotName", "()Landroidx/compose/runtime/MutableState;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "expo-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class SlotProps implements ComposeProps {
    public static final int $stable = 0;
    private final MutableState<String> slotName;

    /* JADX WARN: Multi-variable type inference failed */
    public SlotProps() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SlotProps copy$default(SlotProps slotProps, MutableState mutableState, int i, Object obj) {
        if ((i & 1) != 0) {
            mutableState = slotProps.slotName;
        }
        return slotProps.copy(mutableState);
    }

    public final MutableState<String> component1() {
        return this.slotName;
    }

    public final SlotProps copy(MutableState<String> slotName) {
        Intrinsics.checkNotNullParameter(slotName, "slotName");
        return new SlotProps(slotName);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof SlotProps) && Intrinsics.areEqual(this.slotName, ((SlotProps) other).slotName);
    }

    public int hashCode() {
        return this.slotName.hashCode();
    }

    public String toString() {
        return "SlotProps(slotName=" + this.slotName + ")";
    }

    public SlotProps(MutableState<String> slotName) {
        Intrinsics.checkNotNullParameter(slotName, "slotName");
        this.slotName = slotName;
    }

    public /* synthetic */ SlotProps(MutableState mutableState, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null) : mutableState);
    }

    public final MutableState<String> getSlotName() {
        return this.slotName;
    }
}
