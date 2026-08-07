package expo.modules.ui;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.facebook.hermes.intl.Constants;
import expo.modules.kotlin.views.ComposeProps;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ChipView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001e\b\u0087\b\u0018\u00002\u00020\u0001B\u0081\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012$\b\u0002\u0010\r\u001a\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000fj\u0002`\u00110\u000ej\u0002`\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010&\u001a\u00020\bHÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u000bHÆ\u0003J\t\u0010)\u001a\u00020\u000bHÆ\u0003J%\u0010*\u001a\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000fj\u0002`\u00110\u000ej\u0002`\u0012HÆ\u0003J\u0083\u0001\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2$\b\u0002\u0010\r\u001a\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000fj\u0002`\u00110\u000ej\u0002`\u0012HÆ\u0001J\u0013\u0010,\u001a\u00020\u000b2\b\u0010-\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010.\u001a\u00020\bHÖ\u0001J\t\u0010/\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001eR-\u0010\r\u001a\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000fj\u0002`\u00110\u000ej\u0002`\u0012¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u00060"}, d2 = {"Lexpo/modules/ui/ChipProps;", "Lexpo/modules/kotlin/views/ComposeProps;", Constants.SENSITIVITY_VARIANT, "", "label", "leadingIcon", "trailingIcon", "iconSize", "", "textStyle", "enabled", "", "selected", "modifiers", "", "", "", "Lexpo/modules/ui/ModifierType;", "Lexpo/modules/ui/ModifierList;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ZZLjava/util/List;)V", "getVariant", "()Ljava/lang/String;", "getLabel", "getLeadingIcon", "getTrailingIcon", "getIconSize", "()I", "getTextStyle", "getEnabled", "()Z", "getSelected", "getModifiers", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "toString", "expo-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class ChipProps implements ComposeProps {
    public static final int $stable = 8;
    private final boolean enabled;
    private final int iconSize;
    private final String label;
    private final String leadingIcon;
    private final List<Map<String, Object>> modifiers;
    private final boolean selected;
    private final String textStyle;
    private final String trailingIcon;
    private final String variant;

    public ChipProps() {
        this(null, null, null, null, 0, null, false, false, null, 511, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ChipProps copy$default(ChipProps chipProps, String str, String str2, String str3, String str4, int i, String str5, boolean z, boolean z2, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = chipProps.variant;
        }
        if ((i2 & 2) != 0) {
            str2 = chipProps.label;
        }
        if ((i2 & 4) != 0) {
            str3 = chipProps.leadingIcon;
        }
        if ((i2 & 8) != 0) {
            str4 = chipProps.trailingIcon;
        }
        if ((i2 & 16) != 0) {
            i = chipProps.iconSize;
        }
        if ((i2 & 32) != 0) {
            str5 = chipProps.textStyle;
        }
        if ((i2 & 64) != 0) {
            z = chipProps.enabled;
        }
        if ((i2 & 128) != 0) {
            z2 = chipProps.selected;
        }
        if ((i2 & 256) != 0) {
            list = chipProps.modifiers;
        }
        boolean z3 = z2;
        List list2 = list;
        String str6 = str5;
        boolean z4 = z;
        int i3 = i;
        String str7 = str3;
        return chipProps.copy(str, str2, str7, str4, i3, str6, z4, z3, list2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getVariant() {
        return this.variant;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getLabel() {
        return this.label;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getLeadingIcon() {
        return this.leadingIcon;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getTrailingIcon() {
        return this.trailingIcon;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getIconSize() {
        return this.iconSize;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getTextStyle() {
        return this.textStyle;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getEnabled() {
        return this.enabled;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getSelected() {
        return this.selected;
    }

    public final List<Map<String, Object>> component9() {
        return this.modifiers;
    }

    public final ChipProps copy(String variant, String label, String leadingIcon, String trailingIcon, int iconSize, String textStyle, boolean enabled, boolean selected, List<? extends Map<String, ? extends Object>> modifiers) {
        Intrinsics.checkNotNullParameter(variant, "variant");
        Intrinsics.checkNotNullParameter(label, "label");
        Intrinsics.checkNotNullParameter(textStyle, "textStyle");
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        return new ChipProps(variant, label, leadingIcon, trailingIcon, iconSize, textStyle, enabled, selected, modifiers);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChipProps)) {
            return false;
        }
        ChipProps chipProps = (ChipProps) other;
        return Intrinsics.areEqual(this.variant, chipProps.variant) && Intrinsics.areEqual(this.label, chipProps.label) && Intrinsics.areEqual(this.leadingIcon, chipProps.leadingIcon) && Intrinsics.areEqual(this.trailingIcon, chipProps.trailingIcon) && this.iconSize == chipProps.iconSize && Intrinsics.areEqual(this.textStyle, chipProps.textStyle) && this.enabled == chipProps.enabled && this.selected == chipProps.selected && Intrinsics.areEqual(this.modifiers, chipProps.modifiers);
    }

    public int hashCode() {
        int iHashCode = ((this.variant.hashCode() * 31) + this.label.hashCode()) * 31;
        String str = this.leadingIcon;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.trailingIcon;
        return ((((((((((iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + Integer.hashCode(this.iconSize)) * 31) + this.textStyle.hashCode()) * 31) + Boolean.hashCode(this.enabled)) * 31) + Boolean.hashCode(this.selected)) * 31) + this.modifiers.hashCode();
    }

    public String toString() {
        return "ChipProps(variant=" + this.variant + ", label=" + this.label + ", leadingIcon=" + this.leadingIcon + ", trailingIcon=" + this.trailingIcon + ", iconSize=" + this.iconSize + ", textStyle=" + this.textStyle + ", enabled=" + this.enabled + ", selected=" + this.selected + ", modifiers=" + this.modifiers + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ChipProps(String variant, String label, String str, String str2, int i, String textStyle, boolean z, boolean z2, List<? extends Map<String, ? extends Object>> modifiers) {
        Intrinsics.checkNotNullParameter(variant, "variant");
        Intrinsics.checkNotNullParameter(label, "label");
        Intrinsics.checkNotNullParameter(textStyle, "textStyle");
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        this.variant = variant;
        this.label = label;
        this.leadingIcon = str;
        this.trailingIcon = str2;
        this.iconSize = i;
        this.textStyle = textStyle;
        this.enabled = z;
        this.selected = z2;
        this.modifiers = modifiers;
    }

    public /* synthetic */ ChipProps(String str, String str2, String str3, String str4, int i, String str5, boolean z, boolean z2, List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "assist" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? null : str3, (i2 & 8) != 0 ? null : str4, (i2 & 16) != 0 ? 18 : i, (i2 & 32) != 0 ? "labelSmall" : str5, (i2 & 64) != 0 ? true : z, (i2 & 128) != 0 ? false : z2, (i2 & 256) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final String getVariant() {
        return this.variant;
    }

    public final String getLabel() {
        return this.label;
    }

    public final String getLeadingIcon() {
        return this.leadingIcon;
    }

    public final String getTrailingIcon() {
        return this.trailingIcon;
    }

    public final int getIconSize() {
        return this.iconSize;
    }

    public final String getTextStyle() {
        return this.textStyle;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final boolean getSelected() {
        return this.selected;
    }

    public final List<Map<String, Object>> getModifiers() {
        return this.modifiers;
    }
}
