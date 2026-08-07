package expo.modules.ui;

import android.graphics.Color;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.facebook.hermes.intl.Constants;
import expo.modules.kotlin.views.ComposeProps;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ToggleButtonView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bc\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012$\b\u0002\u0010\n\u001a\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\r0\fj\u0002`\u000e0\u000bj\u0002`\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J%\u0010!\u001a\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\r0\fj\u0002`\u000e0\u000bj\u0002`\u000fHÆ\u0003Je\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\u00032$\b\u0002\u0010\n\u001a\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\r0\fj\u0002`\u000e0\u000bj\u0002`\u000fHÆ\u0001J\u0013\u0010#\u001a\u00020\u00032\b\u0010$\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010%\u001a\u00020&HÖ\u0001J\t\u0010'\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R-\u0010\n\u001a\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\r0\fj\u0002`\u000e0\u000bj\u0002`\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006("}, d2 = {"Lexpo/modules/ui/ToggleButtonProps;", "Lexpo/modules/kotlin/views/ComposeProps;", "checked", "", "text", "", Constants.SENSITIVITY_VARIANT, "color", "Landroid/graphics/Color;", "disabled", "modifiers", "", "", "", "Lexpo/modules/ui/ModifierType;", "Lexpo/modules/ui/ModifierList;", "<init>", "(ZLjava/lang/String;Ljava/lang/String;Landroid/graphics/Color;ZLjava/util/List;)V", "getChecked", "()Z", "getText", "()Ljava/lang/String;", "getVariant", "getColor", "()Landroid/graphics/Color;", "getDisabled", "getModifiers", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "", "toString", "expo-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class ToggleButtonProps implements ComposeProps {
    public static final int $stable = 8;
    private final boolean checked;
    private final Color color;
    private final boolean disabled;
    private final List<Map<String, Object>> modifiers;
    private final String text;
    private final String variant;

    public ToggleButtonProps() {
        this(false, null, null, null, false, null, 63, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ToggleButtonProps copy$default(ToggleButtonProps toggleButtonProps, boolean z, String str, String str2, Color color, boolean z2, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            z = toggleButtonProps.checked;
        }
        if ((i & 2) != 0) {
            str = toggleButtonProps.text;
        }
        if ((i & 4) != 0) {
            str2 = toggleButtonProps.variant;
        }
        if ((i & 8) != 0) {
            color = toggleButtonProps.color;
        }
        if ((i & 16) != 0) {
            z2 = toggleButtonProps.disabled;
        }
        if ((i & 32) != 0) {
            list = toggleButtonProps.modifiers;
        }
        boolean z3 = z2;
        List list2 = list;
        return toggleButtonProps.copy(z, str, str2, color, z3, list2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getChecked() {
        return this.checked;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getText() {
        return this.text;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getVariant() {
        return this.variant;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Color getColor() {
        return this.color;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getDisabled() {
        return this.disabled;
    }

    public final List<Map<String, Object>> component6() {
        return this.modifiers;
    }

    public final ToggleButtonProps copy(boolean checked, String text, String variant, Color color, boolean disabled, List<? extends Map<String, ? extends Object>> modifiers) {
        Intrinsics.checkNotNullParameter(variant, "variant");
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        return new ToggleButtonProps(checked, text, variant, color, disabled, modifiers);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ToggleButtonProps)) {
            return false;
        }
        ToggleButtonProps toggleButtonProps = (ToggleButtonProps) other;
        return this.checked == toggleButtonProps.checked && Intrinsics.areEqual(this.text, toggleButtonProps.text) && Intrinsics.areEqual(this.variant, toggleButtonProps.variant) && Intrinsics.areEqual(this.color, toggleButtonProps.color) && this.disabled == toggleButtonProps.disabled && Intrinsics.areEqual(this.modifiers, toggleButtonProps.modifiers);
    }

    public int hashCode() {
        int iHashCode = Boolean.hashCode(this.checked) * 31;
        String str = this.text;
        int iHashCode2 = (((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.variant.hashCode()) * 31;
        Color color = this.color;
        return ((((iHashCode2 + (color != null ? color.hashCode() : 0)) * 31) + Boolean.hashCode(this.disabled)) * 31) + this.modifiers.hashCode();
    }

    public String toString() {
        return "ToggleButtonProps(checked=" + this.checked + ", text=" + this.text + ", variant=" + this.variant + ", color=" + this.color + ", disabled=" + this.disabled + ", modifiers=" + this.modifiers + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ToggleButtonProps(boolean z, String str, String variant, Color color, boolean z2, List<? extends Map<String, ? extends Object>> modifiers) {
        Intrinsics.checkNotNullParameter(variant, "variant");
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        this.checked = z;
        this.text = str;
        this.variant = variant;
        this.color = color;
        this.disabled = z2;
        this.modifiers = modifiers;
    }

    public final boolean getChecked() {
        return this.checked;
    }

    public final String getText() {
        return this.text;
    }

    public /* synthetic */ ToggleButtonProps(boolean z, String str, String str2, Color color, boolean z2, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? null : str, (i & 4) != 0 ? "default" : str2, (i & 8) != 0 ? null : color, (i & 16) != 0 ? false : z2, (i & 32) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final String getVariant() {
        return this.variant;
    }

    public final Color getColor() {
        return this.color;
    }

    public final boolean getDisabled() {
        return this.disabled;
    }

    public final List<Map<String, Object>> getModifiers() {
        return this.modifiers;
    }
}
