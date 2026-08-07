package expo.modules.ui;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import expo.modules.kotlin.views.ComposeProps;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RNHostView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001BW\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003\u0012*\b\u0002\u0010\u0006\u001a$\u0012 \u0012\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\bj\u0002`\u000b0\u0007j\u0002`\f0\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0011\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003HÆ\u0003J\u0011\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003HÆ\u0003J+\u0010\u0015\u001a$\u0012 \u0012\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\bj\u0002`\u000b0\u0007j\u0002`\f0\u0003HÆ\u0003JY\u0010\u0016\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032*\b\u0002\u0010\u0006\u001a$\u0012 \u0012\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\bj\u0002`\u000b0\u0007j\u0002`\f0\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\nHÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\tHÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R3\u0010\u0006\u001a$\u0012 \u0012\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\bj\u0002`\u000b0\u0007j\u0002`\f0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010¨\u0006\u001c"}, d2 = {"Lexpo/modules/ui/RNHostProps;", "Lexpo/modules/kotlin/views/ComposeProps;", "matchContents", "Landroidx/compose/runtime/MutableState;", "", "verticalScrollEnabled", "modifiers", "", "", "", "", "Lexpo/modules/ui/ModifierType;", "Lexpo/modules/ui/ModifierList;", "<init>", "(Landroidx/compose/runtime/MutableState;Landroidx/compose/runtime/MutableState;Landroidx/compose/runtime/MutableState;)V", "getMatchContents", "()Landroidx/compose/runtime/MutableState;", "getVerticalScrollEnabled", "getModifiers", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "", "toString", "expo-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class RNHostProps implements ComposeProps {
    public static final int $stable = 0;
    private final MutableState<Boolean> matchContents;
    private final MutableState<List<Map<String, Object>>> modifiers;
    private final MutableState<Boolean> verticalScrollEnabled;

    public RNHostProps() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RNHostProps copy$default(RNHostProps rNHostProps, MutableState mutableState, MutableState mutableState2, MutableState mutableState3, int i, Object obj) {
        if ((i & 1) != 0) {
            mutableState = rNHostProps.matchContents;
        }
        if ((i & 2) != 0) {
            mutableState2 = rNHostProps.verticalScrollEnabled;
        }
        if ((i & 4) != 0) {
            mutableState3 = rNHostProps.modifiers;
        }
        return rNHostProps.copy(mutableState, mutableState2, mutableState3);
    }

    public final MutableState<Boolean> component1() {
        return this.matchContents;
    }

    public final MutableState<Boolean> component2() {
        return this.verticalScrollEnabled;
    }

    public final MutableState<List<Map<String, Object>>> component3() {
        return this.modifiers;
    }

    public final RNHostProps copy(MutableState<Boolean> matchContents, MutableState<Boolean> verticalScrollEnabled, MutableState<List<Map<String, Object>>> modifiers) {
        Intrinsics.checkNotNullParameter(matchContents, "matchContents");
        Intrinsics.checkNotNullParameter(verticalScrollEnabled, "verticalScrollEnabled");
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        return new RNHostProps(matchContents, verticalScrollEnabled, modifiers);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RNHostProps)) {
            return false;
        }
        RNHostProps rNHostProps = (RNHostProps) other;
        return Intrinsics.areEqual(this.matchContents, rNHostProps.matchContents) && Intrinsics.areEqual(this.verticalScrollEnabled, rNHostProps.verticalScrollEnabled) && Intrinsics.areEqual(this.modifiers, rNHostProps.modifiers);
    }

    public int hashCode() {
        return (((this.matchContents.hashCode() * 31) + this.verticalScrollEnabled.hashCode()) * 31) + this.modifiers.hashCode();
    }

    public String toString() {
        return "RNHostProps(matchContents=" + this.matchContents + ", verticalScrollEnabled=" + this.verticalScrollEnabled + ", modifiers=" + this.modifiers + ")";
    }

    public RNHostProps(MutableState<Boolean> matchContents, MutableState<Boolean> verticalScrollEnabled, MutableState<List<Map<String, Object>>> modifiers) {
        Intrinsics.checkNotNullParameter(matchContents, "matchContents");
        Intrinsics.checkNotNullParameter(verticalScrollEnabled, "verticalScrollEnabled");
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        this.matchContents = matchContents;
        this.verticalScrollEnabled = verticalScrollEnabled;
        this.modifiers = modifiers;
    }

    public /* synthetic */ RNHostProps(MutableState mutableState, MutableState mutableState2, MutableState mutableState3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null) : mutableState, (i & 2) != 0 ? SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null) : mutableState2, (i & 4) != 0 ? SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(CollectionsKt.emptyList(), null, 2, null) : mutableState3);
    }

    public final MutableState<Boolean> getMatchContents() {
        return this.matchContents;
    }

    public final MutableState<Boolean> getVerticalScrollEnabled() {
        return this.verticalScrollEnabled;
    }

    public final MutableState<List<Map<String, Object>>> getModifiers() {
        return this.modifiers;
    }
}
