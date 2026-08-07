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

/* JADX INFO: compiled from: HorizontalFloatingToolbarView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012$\b\u0002\u0010\u0004\u001a\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0006j\u0002`\t0\u0005j\u0002`\n¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J%\u0010\u0012\u001a\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0006j\u0002`\t0\u0005j\u0002`\nHÆ\u0003J;\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032$\b\u0002\u0010\u0004\u001a\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0006j\u0002`\t0\u0005j\u0002`\nHÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\bHÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0007HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR-\u0010\u0004\u001a\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0006j\u0002`\t0\u0005j\u0002`\n¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lexpo/modules/ui/HorizontalFloatingToolbarProps;", "Lexpo/modules/kotlin/views/ComposeProps;", Constants.SENSITIVITY_VARIANT, "Lexpo/modules/ui/HorizontalFloatingToolbarVariant;", "modifiers", "", "", "", "", "Lexpo/modules/ui/ModifierType;", "Lexpo/modules/ui/ModifierList;", "<init>", "(Lexpo/modules/ui/HorizontalFloatingToolbarVariant;Ljava/util/List;)V", "getVariant", "()Lexpo/modules/ui/HorizontalFloatingToolbarVariant;", "getModifiers", "()Ljava/util/List;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "expo-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class HorizontalFloatingToolbarProps implements ComposeProps {
    public static final int $stable = 8;
    private final List<Map<String, Object>> modifiers;
    private final HorizontalFloatingToolbarVariant variant;

    /* JADX WARN: Multi-variable type inference failed */
    public HorizontalFloatingToolbarProps() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HorizontalFloatingToolbarProps copy$default(HorizontalFloatingToolbarProps horizontalFloatingToolbarProps, HorizontalFloatingToolbarVariant horizontalFloatingToolbarVariant, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            horizontalFloatingToolbarVariant = horizontalFloatingToolbarProps.variant;
        }
        if ((i & 2) != 0) {
            list = horizontalFloatingToolbarProps.modifiers;
        }
        return horizontalFloatingToolbarProps.copy(horizontalFloatingToolbarVariant, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final HorizontalFloatingToolbarVariant getVariant() {
        return this.variant;
    }

    public final List<Map<String, Object>> component2() {
        return this.modifiers;
    }

    public final HorizontalFloatingToolbarProps copy(HorizontalFloatingToolbarVariant variant, List<? extends Map<String, ? extends Object>> modifiers) {
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        return new HorizontalFloatingToolbarProps(variant, modifiers);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HorizontalFloatingToolbarProps)) {
            return false;
        }
        HorizontalFloatingToolbarProps horizontalFloatingToolbarProps = (HorizontalFloatingToolbarProps) other;
        return this.variant == horizontalFloatingToolbarProps.variant && Intrinsics.areEqual(this.modifiers, horizontalFloatingToolbarProps.modifiers);
    }

    public int hashCode() {
        HorizontalFloatingToolbarVariant horizontalFloatingToolbarVariant = this.variant;
        return ((horizontalFloatingToolbarVariant == null ? 0 : horizontalFloatingToolbarVariant.hashCode()) * 31) + this.modifiers.hashCode();
    }

    public String toString() {
        return "HorizontalFloatingToolbarProps(variant=" + this.variant + ", modifiers=" + this.modifiers + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public HorizontalFloatingToolbarProps(HorizontalFloatingToolbarVariant horizontalFloatingToolbarVariant, List<? extends Map<String, ? extends Object>> modifiers) {
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        this.variant = horizontalFloatingToolbarVariant;
        this.modifiers = modifiers;
    }

    public final HorizontalFloatingToolbarVariant getVariant() {
        return this.variant;
    }

    public /* synthetic */ HorizontalFloatingToolbarProps(HorizontalFloatingToolbarVariant horizontalFloatingToolbarVariant, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? HorizontalFloatingToolbarVariant.STANDARD : horizontalFloatingToolbarVariant, (i & 2) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final List<Map<String, Object>> getModifiers() {
        return this.modifiers;
    }
}
