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

/* JADX INFO: compiled from: IconButton.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B[\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012$\b\u0002\u0010\n\u001a\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\fj\u0002`\u000f0\u000bj\u0002`\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0018J\u000b\u0010!\u001a\u0004\u0018\u00010\tHÆ\u0003J%\u0010\"\u001a\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\fj\u0002`\u000f0\u000bj\u0002`\u0010HÆ\u0003Jb\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2$\b\u0002\u0010\n\u001a\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\fj\u0002`\u000f0\u000bj\u0002`\u0010HÆ\u0001¢\u0006\u0002\u0010$J\u0013\u0010%\u001a\u00020\u00072\b\u0010&\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010'\u001a\u00020(HÖ\u0001J\t\u0010)\u001a\u00020\rHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR-\u0010\n\u001a\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\fj\u0002`\u000f0\u000bj\u0002`\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006*"}, d2 = {"Lexpo/modules/ui/button/IconButtonProps;", "Lexpo/modules/kotlin/views/ComposeProps;", Constants.SENSITIVITY_VARIANT, "Lexpo/modules/ui/button/IconButtonVariant;", "elementColors", "Lexpo/modules/ui/button/ButtonColors;", "disabled", "", "shape", "Lexpo/modules/ui/ShapeRecord;", "modifiers", "", "", "", "", "Lexpo/modules/ui/ModifierType;", "Lexpo/modules/ui/ModifierList;", "<init>", "(Lexpo/modules/ui/button/IconButtonVariant;Lexpo/modules/ui/button/ButtonColors;Ljava/lang/Boolean;Lexpo/modules/ui/ShapeRecord;Ljava/util/List;)V", "getVariant", "()Lexpo/modules/ui/button/IconButtonVariant;", "getElementColors", "()Lexpo/modules/ui/button/ButtonColors;", "getDisabled", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getShape", "()Lexpo/modules/ui/ShapeRecord;", "getModifiers", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Lexpo/modules/ui/button/IconButtonVariant;Lexpo/modules/ui/button/ButtonColors;Ljava/lang/Boolean;Lexpo/modules/ui/ShapeRecord;Ljava/util/List;)Lexpo/modules/ui/button/IconButtonProps;", "equals", "other", "hashCode", "", "toString", "expo-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class IconButtonProps implements ComposeProps {
    public static final int $stable = 8;
    private final Boolean disabled;
    private final ButtonColors elementColors;
    private final List<Map<String, Object>> modifiers;
    private final ShapeRecord shape;
    private final IconButtonVariant variant;

    public IconButtonProps() {
        this(null, null, null, null, null, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ IconButtonProps copy$default(IconButtonProps iconButtonProps, IconButtonVariant iconButtonVariant, ButtonColors buttonColors, Boolean bool, ShapeRecord shapeRecord, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            iconButtonVariant = iconButtonProps.variant;
        }
        if ((i & 2) != 0) {
            buttonColors = iconButtonProps.elementColors;
        }
        if ((i & 4) != 0) {
            bool = iconButtonProps.disabled;
        }
        if ((i & 8) != 0) {
            shapeRecord = iconButtonProps.shape;
        }
        if ((i & 16) != 0) {
            list = iconButtonProps.modifiers;
        }
        List list2 = list;
        Boolean bool2 = bool;
        return iconButtonProps.copy(iconButtonVariant, buttonColors, bool2, shapeRecord, list2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final IconButtonVariant getVariant() {
        return this.variant;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final ButtonColors getElementColors() {
        return this.elementColors;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Boolean getDisabled() {
        return this.disabled;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final ShapeRecord getShape() {
        return this.shape;
    }

    public final List<Map<String, Object>> component5() {
        return this.modifiers;
    }

    public final IconButtonProps copy(IconButtonVariant variant, ButtonColors elementColors, Boolean disabled, ShapeRecord shape, List<? extends Map<String, ? extends Object>> modifiers) {
        Intrinsics.checkNotNullParameter(elementColors, "elementColors");
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        return new IconButtonProps(variant, elementColors, disabled, shape, modifiers);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IconButtonProps)) {
            return false;
        }
        IconButtonProps iconButtonProps = (IconButtonProps) other;
        return this.variant == iconButtonProps.variant && Intrinsics.areEqual(this.elementColors, iconButtonProps.elementColors) && Intrinsics.areEqual(this.disabled, iconButtonProps.disabled) && Intrinsics.areEqual(this.shape, iconButtonProps.shape) && Intrinsics.areEqual(this.modifiers, iconButtonProps.modifiers);
    }

    public int hashCode() {
        IconButtonVariant iconButtonVariant = this.variant;
        int iHashCode = (((iconButtonVariant == null ? 0 : iconButtonVariant.hashCode()) * 31) + this.elementColors.hashCode()) * 31;
        Boolean bool = this.disabled;
        int iHashCode2 = (iHashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        ShapeRecord shapeRecord = this.shape;
        return ((iHashCode2 + (shapeRecord != null ? shapeRecord.hashCode() : 0)) * 31) + this.modifiers.hashCode();
    }

    public String toString() {
        return "IconButtonProps(variant=" + this.variant + ", elementColors=" + this.elementColors + ", disabled=" + this.disabled + ", shape=" + this.shape + ", modifiers=" + this.modifiers + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public IconButtonProps(IconButtonVariant iconButtonVariant, ButtonColors elementColors, Boolean bool, ShapeRecord shapeRecord, List<? extends Map<String, ? extends Object>> modifiers) {
        Intrinsics.checkNotNullParameter(elementColors, "elementColors");
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        this.variant = iconButtonVariant;
        this.elementColors = elementColors;
        this.disabled = bool;
        this.shape = shapeRecord;
        this.modifiers = modifiers;
    }

    public /* synthetic */ IconButtonProps(IconButtonVariant iconButtonVariant, ButtonColors buttonColors, Boolean bool, ShapeRecord shapeRecord, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? IconButtonVariant.DEFAULT : iconButtonVariant, (i & 2) != 0 ? new ButtonColors() : buttonColors, (i & 4) != 0 ? false : bool, (i & 8) != 0 ? null : shapeRecord, (i & 16) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final IconButtonVariant getVariant() {
        return this.variant;
    }

    public final ButtonColors getElementColors() {
        return this.elementColors;
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
