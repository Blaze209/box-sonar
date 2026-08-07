package expo.modules.ui;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import expo.modules.kotlin.views.ComposeProps;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RadioButtonView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012$\b\u0002\u0010\u0005\u001a\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007j\u0002`\n0\u0006j\u0002`\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J%\u0010\u0015\u001a\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007j\u0002`\n0\u0006j\u0002`\u000bHÆ\u0003JC\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032$\b\u0002\u0010\u0005\u001a\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007j\u0002`\n0\u0006j\u0002`\u000bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\tHÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR-\u0010\u0005\u001a\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007j\u0002`\n0\u0006j\u0002`\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001c"}, d2 = {"Lexpo/modules/ui/RadioButtonProps;", "Lexpo/modules/kotlin/views/ComposeProps;", "selected", "", "nativeClickable", "modifiers", "", "", "", "", "Lexpo/modules/ui/ModifierType;", "Lexpo/modules/ui/ModifierList;", "<init>", "(ZZLjava/util/List;)V", "getSelected", "()Z", "getNativeClickable", "getModifiers", "()Ljava/util/List;", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "", "toString", "expo-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class RadioButtonProps implements ComposeProps {
    public static final int $stable = 8;
    private final List<Map<String, Object>> modifiers;
    private final boolean nativeClickable;
    private final boolean selected;

    public RadioButtonProps() {
        this(false, false, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RadioButtonProps copy$default(RadioButtonProps radioButtonProps, boolean z, boolean z2, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            z = radioButtonProps.selected;
        }
        if ((i & 2) != 0) {
            z2 = radioButtonProps.nativeClickable;
        }
        if ((i & 4) != 0) {
            list = radioButtonProps.modifiers;
        }
        return radioButtonProps.copy(z, z2, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getSelected() {
        return this.selected;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getNativeClickable() {
        return this.nativeClickable;
    }

    public final List<Map<String, Object>> component3() {
        return this.modifiers;
    }

    public final RadioButtonProps copy(boolean selected, boolean nativeClickable, List<? extends Map<String, ? extends Object>> modifiers) {
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        return new RadioButtonProps(selected, nativeClickable, modifiers);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RadioButtonProps)) {
            return false;
        }
        RadioButtonProps radioButtonProps = (RadioButtonProps) other;
        return this.selected == radioButtonProps.selected && this.nativeClickable == radioButtonProps.nativeClickable && Intrinsics.areEqual(this.modifiers, radioButtonProps.modifiers);
    }

    public int hashCode() {
        return (((Boolean.hashCode(this.selected) * 31) + Boolean.hashCode(this.nativeClickable)) * 31) + this.modifiers.hashCode();
    }

    public String toString() {
        return "RadioButtonProps(selected=" + this.selected + ", nativeClickable=" + this.nativeClickable + ", modifiers=" + this.modifiers + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RadioButtonProps(boolean z, boolean z2, List<? extends Map<String, ? extends Object>> modifiers) {
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        this.selected = z;
        this.nativeClickable = z2;
        this.modifiers = modifiers;
    }

    public final boolean getSelected() {
        return this.selected;
    }

    public final boolean getNativeClickable() {
        return this.nativeClickable;
    }

    public /* synthetic */ RadioButtonProps(boolean z, boolean z2, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? true : z2, (i & 4) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final List<Map<String, Object>> getModifiers() {
        return this.modifiers;
    }
}
