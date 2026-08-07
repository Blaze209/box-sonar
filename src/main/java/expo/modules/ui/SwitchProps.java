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

/* JADX INFO: compiled from: SwitchView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BK\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012$\b\u0002\u0010\b\u001a\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\nj\u0002`\f0\tj\u0002`\r¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J%\u0010\u001b\u001a\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\nj\u0002`\f0\tj\u0002`\rHÆ\u0003JM\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072$\b\u0002\u0010\b\u001a\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\nj\u0002`\f0\tj\u0002`\rHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R-\u0010\b\u001a\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\nj\u0002`\f0\tj\u0002`\r¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006\""}, d2 = {"Lexpo/modules/ui/SwitchProps;", "Lexpo/modules/kotlin/views/ComposeProps;", "value", "", Constants.SENSITIVITY_VARIANT, "", "elementColors", "Lexpo/modules/ui/SwitchColors;", "modifiers", "", "", "", "Lexpo/modules/ui/ModifierType;", "Lexpo/modules/ui/ModifierList;", "<init>", "(ZLjava/lang/String;Lexpo/modules/ui/SwitchColors;Ljava/util/List;)V", "getValue", "()Z", "getVariant", "()Ljava/lang/String;", "getElementColors", "()Lexpo/modules/ui/SwitchColors;", "getModifiers", "()Ljava/util/List;", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "", "toString", "expo-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class SwitchProps implements ComposeProps {
    public static final int $stable = 8;
    private final SwitchColors elementColors;
    private final List<Map<String, Object>> modifiers;
    private final boolean value;
    private final String variant;

    public SwitchProps() {
        this(false, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SwitchProps copy$default(SwitchProps switchProps, boolean z, String str, SwitchColors switchColors, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            z = switchProps.value;
        }
        if ((i & 2) != 0) {
            str = switchProps.variant;
        }
        if ((i & 4) != 0) {
            switchColors = switchProps.elementColors;
        }
        if ((i & 8) != 0) {
            list = switchProps.modifiers;
        }
        return switchProps.copy(z, str, switchColors, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getValue() {
        return this.value;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getVariant() {
        return this.variant;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final SwitchColors getElementColors() {
        return this.elementColors;
    }

    public final List<Map<String, Object>> component4() {
        return this.modifiers;
    }

    public final SwitchProps copy(boolean value, String variant, SwitchColors elementColors, List<? extends Map<String, ? extends Object>> modifiers) {
        Intrinsics.checkNotNullParameter(variant, "variant");
        Intrinsics.checkNotNullParameter(elementColors, "elementColors");
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        return new SwitchProps(value, variant, elementColors, modifiers);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SwitchProps)) {
            return false;
        }
        SwitchProps switchProps = (SwitchProps) other;
        return this.value == switchProps.value && Intrinsics.areEqual(this.variant, switchProps.variant) && Intrinsics.areEqual(this.elementColors, switchProps.elementColors) && Intrinsics.areEqual(this.modifiers, switchProps.modifiers);
    }

    public int hashCode() {
        return (((((Boolean.hashCode(this.value) * 31) + this.variant.hashCode()) * 31) + this.elementColors.hashCode()) * 31) + this.modifiers.hashCode();
    }

    public String toString() {
        return "SwitchProps(value=" + this.value + ", variant=" + this.variant + ", elementColors=" + this.elementColors + ", modifiers=" + this.modifiers + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SwitchProps(boolean z, String variant, SwitchColors elementColors, List<? extends Map<String, ? extends Object>> modifiers) {
        Intrinsics.checkNotNullParameter(variant, "variant");
        Intrinsics.checkNotNullParameter(elementColors, "elementColors");
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        this.value = z;
        this.variant = variant;
        this.elementColors = elementColors;
        this.modifiers = modifiers;
    }

    public final boolean getValue() {
        return this.value;
    }

    public /* synthetic */ SwitchProps(boolean z, String str, SwitchColors switchColors, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? "switch" : str, (i & 4) != 0 ? new SwitchColors() : switchColors, (i & 8) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final String getVariant() {
        return this.variant;
    }

    public final SwitchColors getElementColors() {
        return this.elementColors;
    }

    public final List<Map<String, Object>> getModifiers() {
        return this.modifiers;
    }
}
