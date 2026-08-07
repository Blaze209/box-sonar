package expo.modules.ui;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.facebook.hermes.intl.Constants;
import expo.modules.kotlin.views.ComposeProps;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PickerView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u007f\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u0012 \b\u0002\u0010\n\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\r0\fj\u0002`\u000e0\u000b\u0012$\b\u0002\u0010\u000f\u001a\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\r0\fj\u0002`\u000e0\u000bj\u0002`\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010!\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0017J\t\u0010\"\u001a\u00020\bHÆ\u0003J\t\u0010#\u001a\u00020\u0004HÆ\u0003J!\u0010$\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\r0\fj\u0002`\u000e0\u000bHÆ\u0003J%\u0010%\u001a\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\r0\fj\u0002`\u000e0\u000bj\u0002`\u0010HÆ\u0003J\u0086\u0001\u0010&\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00042 \b\u0002\u0010\n\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\r0\fj\u0002`\u000e0\u000b2$\b\u0002\u0010\u000f\u001a\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\r0\fj\u0002`\u000e0\u000bj\u0002`\u0010HÆ\u0001¢\u0006\u0002\u0010'J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010+\u001a\u00020\u0006HÖ\u0001J\t\u0010,\u001a\u00020\u0004HÖ\u0001R\u0019\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR)\u0010\n\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\r0\fj\u0002`\u000e0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR-\u0010\u000f\u001a\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\r0\fj\u0002`\u000e0\u000bj\u0002`\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001e¨\u0006-"}, d2 = {"Lexpo/modules/ui/PickerProps;", "Lexpo/modules/kotlin/views/ComposeProps;", "options", "", "", "selectedIndex", "", "elementColors", "Lexpo/modules/ui/PickerColors;", Constants.SENSITIVITY_VARIANT, "buttonModifiers", "", "", "", "Lexpo/modules/ui/ModifierType;", "modifiers", "Lexpo/modules/ui/ModifierList;", "<init>", "([Ljava/lang/String;Ljava/lang/Integer;Lexpo/modules/ui/PickerColors;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "getOptions", "()[Ljava/lang/String;", "[Ljava/lang/String;", "getSelectedIndex", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getElementColors", "()Lexpo/modules/ui/PickerColors;", "getVariant", "()Ljava/lang/String;", "getButtonModifiers", "()Ljava/util/List;", "getModifiers", "component1", "component2", "component3", "component4", "component5", "component6", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "([Ljava/lang/String;Ljava/lang/Integer;Lexpo/modules/ui/PickerColors;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)Lexpo/modules/ui/PickerProps;", "equals", "", "other", "hashCode", "toString", "expo-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class PickerProps implements ComposeProps {
    public static final int $stable = 8;
    private final List<Map<String, Object>> buttonModifiers;
    private final PickerColors elementColors;
    private final List<Map<String, Object>> modifiers;
    private final String[] options;
    private final Integer selectedIndex;
    private final String variant;

    public PickerProps() {
        this(null, null, null, null, null, null, 63, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PickerProps copy$default(PickerProps pickerProps, String[] strArr, Integer num, PickerColors pickerColors, String str, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            strArr = pickerProps.options;
        }
        if ((i & 2) != 0) {
            num = pickerProps.selectedIndex;
        }
        if ((i & 4) != 0) {
            pickerColors = pickerProps.elementColors;
        }
        if ((i & 8) != 0) {
            str = pickerProps.variant;
        }
        if ((i & 16) != 0) {
            list = pickerProps.buttonModifiers;
        }
        if ((i & 32) != 0) {
            list2 = pickerProps.modifiers;
        }
        List list3 = list;
        List list4 = list2;
        return pickerProps.copy(strArr, num, pickerColors, str, list3, list4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String[] getOptions() {
        return this.options;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Integer getSelectedIndex() {
        return this.selectedIndex;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final PickerColors getElementColors() {
        return this.elementColors;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getVariant() {
        return this.variant;
    }

    public final List<Map<String, Object>> component5() {
        return this.buttonModifiers;
    }

    public final List<Map<String, Object>> component6() {
        return this.modifiers;
    }

    public final PickerProps copy(String[] options, Integer selectedIndex, PickerColors elementColors, String variant, List<? extends Map<String, ? extends Object>> buttonModifiers, List<? extends Map<String, ? extends Object>> modifiers) {
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(elementColors, "elementColors");
        Intrinsics.checkNotNullParameter(variant, "variant");
        Intrinsics.checkNotNullParameter(buttonModifiers, "buttonModifiers");
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        return new PickerProps(options, selectedIndex, elementColors, variant, buttonModifiers, modifiers);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PickerProps)) {
            return false;
        }
        PickerProps pickerProps = (PickerProps) other;
        return Intrinsics.areEqual(this.options, pickerProps.options) && Intrinsics.areEqual(this.selectedIndex, pickerProps.selectedIndex) && Intrinsics.areEqual(this.elementColors, pickerProps.elementColors) && Intrinsics.areEqual(this.variant, pickerProps.variant) && Intrinsics.areEqual(this.buttonModifiers, pickerProps.buttonModifiers) && Intrinsics.areEqual(this.modifiers, pickerProps.modifiers);
    }

    public int hashCode() {
        int iHashCode = Arrays.hashCode(this.options) * 31;
        Integer num = this.selectedIndex;
        return ((((((((iHashCode + (num == null ? 0 : num.hashCode())) * 31) + this.elementColors.hashCode()) * 31) + this.variant.hashCode()) * 31) + this.buttonModifiers.hashCode()) * 31) + this.modifiers.hashCode();
    }

    public String toString() {
        return "PickerProps(options=" + Arrays.toString(this.options) + ", selectedIndex=" + this.selectedIndex + ", elementColors=" + this.elementColors + ", variant=" + this.variant + ", buttonModifiers=" + this.buttonModifiers + ", modifiers=" + this.modifiers + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PickerProps(String[] options, Integer num, PickerColors elementColors, String variant, List<? extends Map<String, ? extends Object>> buttonModifiers, List<? extends Map<String, ? extends Object>> modifiers) {
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(elementColors, "elementColors");
        Intrinsics.checkNotNullParameter(variant, "variant");
        Intrinsics.checkNotNullParameter(buttonModifiers, "buttonModifiers");
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        this.options = options;
        this.selectedIndex = num;
        this.elementColors = elementColors;
        this.variant = variant;
        this.buttonModifiers = buttonModifiers;
        this.modifiers = modifiers;
    }

    public /* synthetic */ PickerProps(String[] strArr, Integer num, PickerColors pickerColors, String str, List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new String[0] : strArr, (i & 2) != 0 ? null : num, (i & 4) != 0 ? new PickerColors() : pickerColors, (i & 8) != 0 ? "segmented" : str, (i & 16) != 0 ? CollectionsKt.emptyList() : list, (i & 32) != 0 ? CollectionsKt.emptyList() : list2);
    }

    public final String[] getOptions() {
        return this.options;
    }

    public final Integer getSelectedIndex() {
        return this.selectedIndex;
    }

    public final PickerColors getElementColors() {
        return this.elementColors;
    }

    public final String getVariant() {
        return this.variant;
    }

    public final List<Map<String, Object>> getButtonModifiers() {
        return this.buttonModifiers;
    }

    public final List<Map<String, Object>> getModifiers() {
        return this.modifiers;
    }
}
