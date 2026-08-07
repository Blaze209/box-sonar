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

/* JADX INFO: compiled from: ProgressView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BY\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012$\b\u0002\u0010\n\u001a\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\fj\u0002`\u000f0\u000bj\u0002`\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0016J\u000b\u0010 \u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010!\u001a\u00020\tHÆ\u0003J%\u0010\"\u001a\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\fj\u0002`\u000f0\u000bj\u0002`\u0010HÆ\u0003J`\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2$\b\u0002\u0010\n\u001a\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\fj\u0002`\u000f0\u000bj\u0002`\u0010HÆ\u0001¢\u0006\u0002\u0010$J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010(\u001a\u00020)HÖ\u0001J\t\u0010*\u001a\u00020\rHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR-\u0010\n\u001a\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\fj\u0002`\u000f0\u000bj\u0002`\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006+"}, d2 = {"Lexpo/modules/ui/ProgressProps;", "Lexpo/modules/kotlin/views/ComposeProps;", Constants.SENSITIVITY_VARIANT, "Lexpo/modules/ui/ProgressVariant;", "progress", "", "color", "Landroid/graphics/Color;", "elementColors", "Lexpo/modules/ui/ProgressColors;", "modifiers", "", "", "", "", "Lexpo/modules/ui/ModifierType;", "Lexpo/modules/ui/ModifierList;", "<init>", "(Lexpo/modules/ui/ProgressVariant;Ljava/lang/Float;Landroid/graphics/Color;Lexpo/modules/ui/ProgressColors;Ljava/util/List;)V", "getVariant", "()Lexpo/modules/ui/ProgressVariant;", "getProgress", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getColor", "()Landroid/graphics/Color;", "getElementColors", "()Lexpo/modules/ui/ProgressColors;", "getModifiers", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Lexpo/modules/ui/ProgressVariant;Ljava/lang/Float;Landroid/graphics/Color;Lexpo/modules/ui/ProgressColors;Ljava/util/List;)Lexpo/modules/ui/ProgressProps;", "equals", "", "other", "hashCode", "", "toString", "expo-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class ProgressProps implements ComposeProps {
    public static final int $stable = 8;
    private final Color color;
    private final ProgressColors elementColors;
    private final List<Map<String, Object>> modifiers;
    private final Float progress;
    private final ProgressVariant variant;

    public ProgressProps() {
        this(null, null, null, null, null, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ProgressProps copy$default(ProgressProps progressProps, ProgressVariant progressVariant, Float f, Color color, ProgressColors progressColors, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            progressVariant = progressProps.variant;
        }
        if ((i & 2) != 0) {
            f = progressProps.progress;
        }
        if ((i & 4) != 0) {
            color = progressProps.color;
        }
        if ((i & 8) != 0) {
            progressColors = progressProps.elementColors;
        }
        if ((i & 16) != 0) {
            list = progressProps.modifiers;
        }
        List list2 = list;
        Color color2 = color;
        return progressProps.copy(progressVariant, f, color2, progressColors, list2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ProgressVariant getVariant() {
        return this.variant;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Float getProgress() {
        return this.progress;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Color getColor() {
        return this.color;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final ProgressColors getElementColors() {
        return this.elementColors;
    }

    public final List<Map<String, Object>> component5() {
        return this.modifiers;
    }

    public final ProgressProps copy(ProgressVariant variant, Float progress, Color color, ProgressColors elementColors, List<? extends Map<String, ? extends Object>> modifiers) {
        Intrinsics.checkNotNullParameter(variant, "variant");
        Intrinsics.checkNotNullParameter(elementColors, "elementColors");
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        return new ProgressProps(variant, progress, color, elementColors, modifiers);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ProgressProps)) {
            return false;
        }
        ProgressProps progressProps = (ProgressProps) other;
        return this.variant == progressProps.variant && Intrinsics.areEqual((Object) this.progress, (Object) progressProps.progress) && Intrinsics.areEqual(this.color, progressProps.color) && Intrinsics.areEqual(this.elementColors, progressProps.elementColors) && Intrinsics.areEqual(this.modifiers, progressProps.modifiers);
    }

    public int hashCode() {
        int iHashCode = this.variant.hashCode() * 31;
        Float f = this.progress;
        int iHashCode2 = (iHashCode + (f == null ? 0 : f.hashCode())) * 31;
        Color color = this.color;
        return ((((iHashCode2 + (color != null ? color.hashCode() : 0)) * 31) + this.elementColors.hashCode()) * 31) + this.modifiers.hashCode();
    }

    public String toString() {
        return "ProgressProps(variant=" + this.variant + ", progress=" + this.progress + ", color=" + this.color + ", elementColors=" + this.elementColors + ", modifiers=" + this.modifiers + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ProgressProps(ProgressVariant variant, Float f, Color color, ProgressColors elementColors, List<? extends Map<String, ? extends Object>> modifiers) {
        Intrinsics.checkNotNullParameter(variant, "variant");
        Intrinsics.checkNotNullParameter(elementColors, "elementColors");
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        this.variant = variant;
        this.progress = f;
        this.color = color;
        this.elementColors = elementColors;
        this.modifiers = modifiers;
    }

    public /* synthetic */ ProgressProps(ProgressVariant progressVariant, Float f, Color color, ProgressColors progressColors, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? ProgressVariant.CIRCULAR : progressVariant, (i & 2) != 0 ? null : f, (i & 4) != 0 ? null : color, (i & 8) != 0 ? new ProgressColors() : progressColors, (i & 16) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final ProgressVariant getVariant() {
        return this.variant;
    }

    public final Float getProgress() {
        return this.progress;
    }

    public final Color getColor() {
        return this.color;
    }

    public final ProgressColors getElementColors() {
        return this.elementColors;
    }

    public final List<Map<String, Object>> getModifiers() {
        return this.modifiers;
    }
}
