package expo.modules.ui.button;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.facebook.hermes.intl.Constants;
import expo.modules.kotlin.views.ComposeProps;
import expo.modules.ui.ShapeRecord;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Button.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B}\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012$\b\u0002\u0010\u000e\u001a\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0010j\u0002`\u00120\u000fj\u0002`\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010'\u001a\u00020\u0007HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010*\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u001fJ\u000b\u0010+\u001a\u0004\u0018\u00010\rHÆ\u0003J%\u0010,\u001a\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0010j\u0002`\u00120\u000fj\u0002`\u0013HÆ\u0003J\u0084\u0001\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2$\b\u0002\u0010\u000e\u001a\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0010j\u0002`\u00120\u000fj\u0002`\u0013HÆ\u0001¢\u0006\u0002\u0010.J\u0013\u0010/\u001a\u00020\u000b2\b\u00100\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u00101\u001a\u000202HÖ\u0001J\t\u00103\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017R\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R-\u0010\u000e\u001a\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0010j\u0002`\u00120\u000fj\u0002`\u0013¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$¨\u00064"}, d2 = {"Lexpo/modules/ui/button/ButtonProps;", "Lexpo/modules/kotlin/views/ComposeProps;", "text", "", Constants.SENSITIVITY_VARIANT, "Lexpo/modules/ui/button/ButtonVariant;", "elementColors", "Lexpo/modules/ui/button/ButtonColors;", "leadingIcon", "trailingIcon", "disabled", "", "shape", "Lexpo/modules/ui/ShapeRecord;", "modifiers", "", "", "", "Lexpo/modules/ui/ModifierType;", "Lexpo/modules/ui/ModifierList;", "<init>", "(Ljava/lang/String;Lexpo/modules/ui/button/ButtonVariant;Lexpo/modules/ui/button/ButtonColors;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lexpo/modules/ui/ShapeRecord;Ljava/util/List;)V", "getText", "()Ljava/lang/String;", "getVariant", "()Lexpo/modules/ui/button/ButtonVariant;", "getElementColors", "()Lexpo/modules/ui/button/ButtonColors;", "getLeadingIcon", "getTrailingIcon", "getDisabled", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getShape", "()Lexpo/modules/ui/ShapeRecord;", "getModifiers", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/String;Lexpo/modules/ui/button/ButtonVariant;Lexpo/modules/ui/button/ButtonColors;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lexpo/modules/ui/ShapeRecord;Ljava/util/List;)Lexpo/modules/ui/button/ButtonProps;", "equals", "other", "hashCode", "", "toString", "expo-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class ButtonProps implements ComposeProps {
    public static final int $stable = 8;
    private final Boolean disabled;
    private final ButtonColors elementColors;
    private final String leadingIcon;
    private final List<Map<String, Object>> modifiers;
    private final ShapeRecord shape;
    private final String text;
    private final String trailingIcon;
    private final ButtonVariant variant;

    public ButtonProps() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ButtonProps copy$default(ButtonProps buttonProps, String str, ButtonVariant buttonVariant, ButtonColors buttonColors, String str2, String str3, Boolean bool, ShapeRecord shapeRecord, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = buttonProps.text;
        }
        if ((i & 2) != 0) {
            buttonVariant = buttonProps.variant;
        }
        if ((i & 4) != 0) {
            buttonColors = buttonProps.elementColors;
        }
        if ((i & 8) != 0) {
            str2 = buttonProps.leadingIcon;
        }
        if ((i & 16) != 0) {
            str3 = buttonProps.trailingIcon;
        }
        if ((i & 32) != 0) {
            bool = buttonProps.disabled;
        }
        if ((i & 64) != 0) {
            shapeRecord = buttonProps.shape;
        }
        if ((i & 128) != 0) {
            list = buttonProps.modifiers;
        }
        ShapeRecord shapeRecord2 = shapeRecord;
        List list2 = list;
        String str4 = str3;
        Boolean bool2 = bool;
        return buttonProps.copy(str, buttonVariant, buttonColors, str2, str4, bool2, shapeRecord2, list2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getText() {
        return this.text;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final ButtonVariant getVariant() {
        return this.variant;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final ButtonColors getElementColors() {
        return this.elementColors;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getLeadingIcon() {
        return this.leadingIcon;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getTrailingIcon() {
        return this.trailingIcon;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Boolean getDisabled() {
        return this.disabled;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final ShapeRecord getShape() {
        return this.shape;
    }

    public final List<Map<String, Object>> component8() {
        return this.modifiers;
    }

    public final ButtonProps copy(String text, ButtonVariant variant, ButtonColors elementColors, String leadingIcon, String trailingIcon, Boolean disabled, ShapeRecord shape, List<? extends Map<String, ? extends Object>> modifiers) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(elementColors, "elementColors");
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        return new ButtonProps(text, variant, elementColors, leadingIcon, trailingIcon, disabled, shape, modifiers);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ButtonProps)) {
            return false;
        }
        ButtonProps buttonProps = (ButtonProps) other;
        return Intrinsics.areEqual(this.text, buttonProps.text) && this.variant == buttonProps.variant && Intrinsics.areEqual(this.elementColors, buttonProps.elementColors) && Intrinsics.areEqual(this.leadingIcon, buttonProps.leadingIcon) && Intrinsics.areEqual(this.trailingIcon, buttonProps.trailingIcon) && Intrinsics.areEqual(this.disabled, buttonProps.disabled) && Intrinsics.areEqual(this.shape, buttonProps.shape) && Intrinsics.areEqual(this.modifiers, buttonProps.modifiers);
    }

    public int hashCode() {
        int iHashCode = this.text.hashCode() * 31;
        ButtonVariant buttonVariant = this.variant;
        int iHashCode2 = (((iHashCode + (buttonVariant == null ? 0 : buttonVariant.hashCode())) * 31) + this.elementColors.hashCode()) * 31;
        String str = this.leadingIcon;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.trailingIcon;
        int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Boolean bool = this.disabled;
        int iHashCode5 = (iHashCode4 + (bool == null ? 0 : bool.hashCode())) * 31;
        ShapeRecord shapeRecord = this.shape;
        return ((iHashCode5 + (shapeRecord != null ? shapeRecord.hashCode() : 0)) * 31) + this.modifiers.hashCode();
    }

    public String toString() {
        return "ButtonProps(text=" + this.text + ", variant=" + this.variant + ", elementColors=" + this.elementColors + ", leadingIcon=" + this.leadingIcon + ", trailingIcon=" + this.trailingIcon + ", disabled=" + this.disabled + ", shape=" + this.shape + ", modifiers=" + this.modifiers + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ButtonProps(String text, ButtonVariant buttonVariant, ButtonColors elementColors, String str, String str2, Boolean bool, ShapeRecord shapeRecord, List<? extends Map<String, ? extends Object>> modifiers) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(elementColors, "elementColors");
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        this.text = text;
        this.variant = buttonVariant;
        this.elementColors = elementColors;
        this.leadingIcon = str;
        this.trailingIcon = str2;
        this.disabled = bool;
        this.shape = shapeRecord;
        this.modifiers = modifiers;
    }

    public /* synthetic */ ButtonProps(String str, ButtonVariant buttonVariant, ButtonColors buttonColors, String str2, String str3, Boolean bool, ShapeRecord shapeRecord, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? ButtonVariant.DEFAULT : buttonVariant, (i & 4) != 0 ? new ButtonColors() : buttonColors, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? false : bool, (i & 64) != 0 ? null : shapeRecord, (i & 128) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final String getText() {
        return this.text;
    }

    public final ButtonVariant getVariant() {
        return this.variant;
    }

    public final ButtonColors getElementColors() {
        return this.elementColors;
    }

    public final String getLeadingIcon() {
        return this.leadingIcon;
    }

    public final String getTrailingIcon() {
        return this.trailingIcon;
    }

    public final Boolean getDisabled() {
        return this.disabled;
    }

    public final ShapeRecord getShape() {
        return this.shape;
    }

    public final List<Map<String, Object>> getModifiers() {
        return this.modifiers;
    }
}
