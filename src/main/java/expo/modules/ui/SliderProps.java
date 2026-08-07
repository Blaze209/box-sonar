package expo.modules.ui;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import expo.modules.kotlin.views.ComposeProps;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SliderView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B_\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012$\b\u0002\u0010\n\u001a\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\fj\u0002`\u000f0\u000bj\u0002`\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0007HÆ\u0003J\t\u0010!\u001a\u00020\tHÆ\u0003J%\u0010\"\u001a\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\fj\u0002`\u000f0\u000bj\u0002`\u0010HÆ\u0003Ja\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2$\b\u0002\u0010\n\u001a\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\fj\u0002`\u000f0\u000bj\u0002`\u0010HÆ\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010'\u001a\u00020\u0007HÖ\u0001J\t\u0010(\u001a\u00020\rHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR-\u0010\n\u001a\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\fj\u0002`\u000f0\u000bj\u0002`\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006)"}, d2 = {"Lexpo/modules/ui/SliderProps;", "Lexpo/modules/kotlin/views/ComposeProps;", "value", "", "min", "max", "steps", "", "elementColors", "Lexpo/modules/ui/SliderColors;", "modifiers", "", "", "", "", "Lexpo/modules/ui/ModifierType;", "Lexpo/modules/ui/ModifierList;", "<init>", "(FFFILexpo/modules/ui/SliderColors;Ljava/util/List;)V", "getValue", "()F", "getMin", "getMax", "getSteps", "()I", "getElementColors", "()Lexpo/modules/ui/SliderColors;", "getModifiers", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "toString", "expo-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class SliderProps implements ComposeProps {
    public static final int $stable = 8;
    private final SliderColors elementColors;
    private final float max;
    private final float min;
    private final List<Map<String, Object>> modifiers;
    private final int steps;
    private final float value;

    public SliderProps() {
        this(0.0f, 0.0f, 0.0f, 0, null, null, 63, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SliderProps copy$default(SliderProps sliderProps, float f, float f2, float f3, int i, SliderColors sliderColors, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            f = sliderProps.value;
        }
        if ((i2 & 2) != 0) {
            f2 = sliderProps.min;
        }
        if ((i2 & 4) != 0) {
            f3 = sliderProps.max;
        }
        if ((i2 & 8) != 0) {
            i = sliderProps.steps;
        }
        if ((i2 & 16) != 0) {
            sliderColors = sliderProps.elementColors;
        }
        if ((i2 & 32) != 0) {
            list = sliderProps.modifiers;
        }
        SliderColors sliderColors2 = sliderColors;
        List list2 = list;
        return sliderProps.copy(f, f2, f3, i, sliderColors2, list2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final float getValue() {
        return this.value;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final float getMin() {
        return this.min;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final float getMax() {
        return this.max;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getSteps() {
        return this.steps;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final SliderColors getElementColors() {
        return this.elementColors;
    }

    public final List<Map<String, Object>> component6() {
        return this.modifiers;
    }

    public final SliderProps copy(float value, float min, float max, int steps, SliderColors elementColors, List<? extends Map<String, ? extends Object>> modifiers) {
        Intrinsics.checkNotNullParameter(elementColors, "elementColors");
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        return new SliderProps(value, min, max, steps, elementColors, modifiers);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SliderProps)) {
            return false;
        }
        SliderProps sliderProps = (SliderProps) other;
        return Float.compare(this.value, sliderProps.value) == 0 && Float.compare(this.min, sliderProps.min) == 0 && Float.compare(this.max, sliderProps.max) == 0 && this.steps == sliderProps.steps && Intrinsics.areEqual(this.elementColors, sliderProps.elementColors) && Intrinsics.areEqual(this.modifiers, sliderProps.modifiers);
    }

    public int hashCode() {
        return (((((((((Float.hashCode(this.value) * 31) + Float.hashCode(this.min)) * 31) + Float.hashCode(this.max)) * 31) + Integer.hashCode(this.steps)) * 31) + this.elementColors.hashCode()) * 31) + this.modifiers.hashCode();
    }

    public String toString() {
        return "SliderProps(value=" + this.value + ", min=" + this.min + ", max=" + this.max + ", steps=" + this.steps + ", elementColors=" + this.elementColors + ", modifiers=" + this.modifiers + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SliderProps(float f, float f2, float f3, int i, SliderColors elementColors, List<? extends Map<String, ? extends Object>> modifiers) {
        Intrinsics.checkNotNullParameter(elementColors, "elementColors");
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        this.value = f;
        this.min = f2;
        this.max = f3;
        this.steps = i;
        this.elementColors = elementColors;
        this.modifiers = modifiers;
    }

    public final float getValue() {
        return this.value;
    }

    public final float getMin() {
        return this.min;
    }

    public final float getMax() {
        return this.max;
    }

    public final int getSteps() {
        return this.steps;
    }

    public /* synthetic */ SliderProps(float f, float f2, float f3, int i, SliderColors sliderColors, List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0.0f : f, (i2 & 2) != 0 ? 0.0f : f2, (i2 & 4) != 0 ? 1.0f : f3, (i2 & 8) != 0 ? 0 : i, (i2 & 16) != 0 ? new SliderColors() : sliderColors, (i2 & 32) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final SliderColors getElementColors() {
        return this.elementColors;
    }

    public final List<Map<String, Object>> getModifiers() {
        return this.modifiers;
    }
}
