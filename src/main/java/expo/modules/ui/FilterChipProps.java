package expo.modules.ui;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import expo.modules.kotlin.views.ComposeProps;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FilterChipView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BK\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012$\b\u0002\u0010\u0007\u001a\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\n0\tj\u0002`\u000b0\bj\u0002`\f¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J%\u0010\u0019\u001a\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\n0\tj\u0002`\u000b0\bj\u0002`\fHÆ\u0003JM\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032$\b\u0002\u0010\u0007\u001a\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\n0\tj\u0002`\u000b0\bj\u0002`\fHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u00032\b\u0010\u001c\u001a\u0004\u0018\u00010\nHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R-\u0010\u0007\u001a\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\n0\tj\u0002`\u000b0\bj\u0002`\f¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006 "}, d2 = {"Lexpo/modules/ui/FilterChipProps;", "Lexpo/modules/kotlin/views/ComposeProps;", "selected", "", "label", "", "enabled", "modifiers", "", "", "", "Lexpo/modules/ui/ModifierType;", "Lexpo/modules/ui/ModifierList;", "<init>", "(ZLjava/lang/String;ZLjava/util/List;)V", "getSelected", "()Z", "getLabel", "()Ljava/lang/String;", "getEnabled", "getModifiers", "()Ljava/util/List;", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "", "toString", "expo-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class FilterChipProps implements ComposeProps {
    public static final int $stable = 8;
    private final boolean enabled;
    private final String label;
    private final List<Map<String, Object>> modifiers;
    private final boolean selected;

    public FilterChipProps() {
        this(false, null, false, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FilterChipProps copy$default(FilterChipProps filterChipProps, boolean z, String str, boolean z2, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            z = filterChipProps.selected;
        }
        if ((i & 2) != 0) {
            str = filterChipProps.label;
        }
        if ((i & 4) != 0) {
            z2 = filterChipProps.enabled;
        }
        if ((i & 8) != 0) {
            list = filterChipProps.modifiers;
        }
        return filterChipProps.copy(z, str, z2, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getSelected() {
        return this.selected;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getLabel() {
        return this.label;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getEnabled() {
        return this.enabled;
    }

    public final List<Map<String, Object>> component4() {
        return this.modifiers;
    }

    public final FilterChipProps copy(boolean selected, String label, boolean enabled, List<? extends Map<String, ? extends Object>> modifiers) {
        Intrinsics.checkNotNullParameter(label, "label");
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        return new FilterChipProps(selected, label, enabled, modifiers);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FilterChipProps)) {
            return false;
        }
        FilterChipProps filterChipProps = (FilterChipProps) other;
        return this.selected == filterChipProps.selected && Intrinsics.areEqual(this.label, filterChipProps.label) && this.enabled == filterChipProps.enabled && Intrinsics.areEqual(this.modifiers, filterChipProps.modifiers);
    }

    public int hashCode() {
        return (((((Boolean.hashCode(this.selected) * 31) + this.label.hashCode()) * 31) + Boolean.hashCode(this.enabled)) * 31) + this.modifiers.hashCode();
    }

    public String toString() {
        return "FilterChipProps(selected=" + this.selected + ", label=" + this.label + ", enabled=" + this.enabled + ", modifiers=" + this.modifiers + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FilterChipProps(boolean z, String label, boolean z2, List<? extends Map<String, ? extends Object>> modifiers) {
        Intrinsics.checkNotNullParameter(label, "label");
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        this.selected = z;
        this.label = label;
        this.enabled = z2;
        this.modifiers = modifiers;
    }

    public final boolean getSelected() {
        return this.selected;
    }

    public /* synthetic */ FilterChipProps(boolean z, String str, boolean z2, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? true : z2, (i & 8) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final String getLabel() {
        return this.label;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final List<Map<String, Object>> getModifiers() {
        return this.modifiers;
    }
}
