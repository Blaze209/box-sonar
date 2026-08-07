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

/* JADX INFO: compiled from: DatePickerView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bw\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012$\b\u0002\u0010\u000f\u001a\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0011j\u0002`\u00130\u0010j\u0002`\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\u0010\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001aJ\t\u0010(\u001a\u00020\u0007HÆ\u0003J\t\u0010)\u001a\u00020\tHÆ\u0003J\t\u0010*\u001a\u00020\u000bHÆ\u0003J\t\u0010+\u001a\u00020\u000bHÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u000eHÆ\u0003J%\u0010-\u001a\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0011j\u0002`\u00130\u0010j\u0002`\u0014HÆ\u0003J~\u0010.\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2$\b\u0002\u0010\u000f\u001a\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0011j\u0002`\u00130\u0010j\u0002`\u0014HÆ\u0001¢\u0006\u0002\u0010/J\u0013\u00100\u001a\u00020\u000b2\b\u00101\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u00102\u001a\u000203HÖ\u0001J\t\u00104\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010!R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R-\u0010\u000f\u001a\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0011j\u0002`\u00130\u0010j\u0002`\u0014¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%¨\u00065"}, d2 = {"Lexpo/modules/ui/DateTimePickerProps;", "Lexpo/modules/kotlin/views/ComposeProps;", "title", "", "initialDate", "", Constants.SENSITIVITY_VARIANT, "Lexpo/modules/ui/Variant;", "displayedComponents", "Lexpo/modules/ui/DisplayedComponents;", "showVariantToggle", "", "is24Hour", "color", "Landroid/graphics/Color;", "modifiers", "", "", "", "Lexpo/modules/ui/ModifierType;", "Lexpo/modules/ui/ModifierList;", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Lexpo/modules/ui/Variant;Lexpo/modules/ui/DisplayedComponents;ZZLandroid/graphics/Color;Ljava/util/List;)V", "getTitle", "()Ljava/lang/String;", "getInitialDate", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getVariant", "()Lexpo/modules/ui/Variant;", "getDisplayedComponents", "()Lexpo/modules/ui/DisplayedComponents;", "getShowVariantToggle", "()Z", "getColor", "()Landroid/graphics/Color;", "getModifiers", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/String;Ljava/lang/Long;Lexpo/modules/ui/Variant;Lexpo/modules/ui/DisplayedComponents;ZZLandroid/graphics/Color;Ljava/util/List;)Lexpo/modules/ui/DateTimePickerProps;", "equals", "other", "hashCode", "", "toString", "expo-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class DateTimePickerProps implements ComposeProps {
    public static final int $stable = 8;
    private final Color color;
    private final DisplayedComponents displayedComponents;
    private final Long initialDate;
    private final boolean is24Hour;
    private final List<Map<String, Object>> modifiers;
    private final boolean showVariantToggle;
    private final String title;
    private final Variant variant;

    public DateTimePickerProps() {
        this(null, null, null, null, false, false, null, null, 255, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DateTimePickerProps copy$default(DateTimePickerProps dateTimePickerProps, String str, Long l, Variant variant, DisplayedComponents displayedComponents, boolean z, boolean z2, Color color, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = dateTimePickerProps.title;
        }
        if ((i & 2) != 0) {
            l = dateTimePickerProps.initialDate;
        }
        if ((i & 4) != 0) {
            variant = dateTimePickerProps.variant;
        }
        if ((i & 8) != 0) {
            displayedComponents = dateTimePickerProps.displayedComponents;
        }
        if ((i & 16) != 0) {
            z = dateTimePickerProps.showVariantToggle;
        }
        if ((i & 32) != 0) {
            z2 = dateTimePickerProps.is24Hour;
        }
        if ((i & 64) != 0) {
            color = dateTimePickerProps.color;
        }
        if ((i & 128) != 0) {
            list = dateTimePickerProps.modifiers;
        }
        Color color2 = color;
        List list2 = list;
        boolean z3 = z;
        boolean z4 = z2;
        return dateTimePickerProps.copy(str, l, variant, displayedComponents, z3, z4, color2, list2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Long getInitialDate() {
        return this.initialDate;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Variant getVariant() {
        return this.variant;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final DisplayedComponents getDisplayedComponents() {
        return this.displayedComponents;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getShowVariantToggle() {
        return this.showVariantToggle;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getIs24Hour() {
        return this.is24Hour;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Color getColor() {
        return this.color;
    }

    public final List<Map<String, Object>> component8() {
        return this.modifiers;
    }

    public final DateTimePickerProps copy(String title, Long initialDate, Variant variant, DisplayedComponents displayedComponents, boolean showVariantToggle, boolean is24Hour, Color color, List<? extends Map<String, ? extends Object>> modifiers) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(variant, "variant");
        Intrinsics.checkNotNullParameter(displayedComponents, "displayedComponents");
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        return new DateTimePickerProps(title, initialDate, variant, displayedComponents, showVariantToggle, is24Hour, color, modifiers);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DateTimePickerProps)) {
            return false;
        }
        DateTimePickerProps dateTimePickerProps = (DateTimePickerProps) other;
        return Intrinsics.areEqual(this.title, dateTimePickerProps.title) && Intrinsics.areEqual(this.initialDate, dateTimePickerProps.initialDate) && this.variant == dateTimePickerProps.variant && this.displayedComponents == dateTimePickerProps.displayedComponents && this.showVariantToggle == dateTimePickerProps.showVariantToggle && this.is24Hour == dateTimePickerProps.is24Hour && Intrinsics.areEqual(this.color, dateTimePickerProps.color) && Intrinsics.areEqual(this.modifiers, dateTimePickerProps.modifiers);
    }

    public int hashCode() {
        int iHashCode = this.title.hashCode() * 31;
        Long l = this.initialDate;
        int iHashCode2 = (((((((((iHashCode + (l == null ? 0 : l.hashCode())) * 31) + this.variant.hashCode()) * 31) + this.displayedComponents.hashCode()) * 31) + Boolean.hashCode(this.showVariantToggle)) * 31) + Boolean.hashCode(this.is24Hour)) * 31;
        Color color = this.color;
        return ((iHashCode2 + (color != null ? color.hashCode() : 0)) * 31) + this.modifiers.hashCode();
    }

    public String toString() {
        return "DateTimePickerProps(title=" + this.title + ", initialDate=" + this.initialDate + ", variant=" + this.variant + ", displayedComponents=" + this.displayedComponents + ", showVariantToggle=" + this.showVariantToggle + ", is24Hour=" + this.is24Hour + ", color=" + this.color + ", modifiers=" + this.modifiers + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DateTimePickerProps(String title, Long l, Variant variant, DisplayedComponents displayedComponents, boolean z, boolean z2, Color color, List<? extends Map<String, ? extends Object>> modifiers) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(variant, "variant");
        Intrinsics.checkNotNullParameter(displayedComponents, "displayedComponents");
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        this.title = title;
        this.initialDate = l;
        this.variant = variant;
        this.displayedComponents = displayedComponents;
        this.showVariantToggle = z;
        this.is24Hour = z2;
        this.color = color;
        this.modifiers = modifiers;
    }

    public /* synthetic */ DateTimePickerProps(String str, Long l, Variant variant, DisplayedComponents displayedComponents, boolean z, boolean z2, Color color, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? null : l, (i & 4) != 0 ? Variant.PICKER : variant, (i & 8) != 0 ? DisplayedComponents.DATE : displayedComponents, (i & 16) != 0 ? true : z, (i & 32) != 0 ? true : z2, (i & 64) != 0 ? null : color, (i & 128) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final String getTitle() {
        return this.title;
    }

    public final Long getInitialDate() {
        return this.initialDate;
    }

    public final Variant getVariant() {
        return this.variant;
    }

    public final DisplayedComponents getDisplayedComponents() {
        return this.displayedComponents;
    }

    public final boolean getShowVariantToggle() {
        return this.showVariantToggle;
    }

    public final boolean is24Hour() {
        return this.is24Hour;
    }

    public final Color getColor() {
        return this.color;
    }

    public final List<Map<String, Object>> getModifiers() {
        return this.modifiers;
    }
}
