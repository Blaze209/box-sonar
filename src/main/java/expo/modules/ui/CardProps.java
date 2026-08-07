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

/* JADX INFO: compiled from: CardView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BO\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012$\b\u0002\u0010\b\u001a\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\nj\u0002`\f0\tj\u0002`\r¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003J%\u0010\u001b\u001a\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\nj\u0002`\f0\tj\u0002`\rHÆ\u0003JQ\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072$\b\u0002\u0010\b\u001a\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\nj\u0002`\f0\tj\u0002`\rHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R-\u0010\b\u001a\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\nj\u0002`\f0\tj\u0002`\r¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006#"}, d2 = {"Lexpo/modules/ui/CardProps;", "Lexpo/modules/kotlin/views/ComposeProps;", Constants.SENSITIVITY_VARIANT, "", "color", "Landroid/graphics/Color;", "elementColors", "Lexpo/modules/ui/CardElementColors;", "modifiers", "", "", "", "Lexpo/modules/ui/ModifierType;", "Lexpo/modules/ui/ModifierList;", "<init>", "(Ljava/lang/String;Landroid/graphics/Color;Lexpo/modules/ui/CardElementColors;Ljava/util/List;)V", "getVariant", "()Ljava/lang/String;", "getColor", "()Landroid/graphics/Color;", "getElementColors", "()Lexpo/modules/ui/CardElementColors;", "getModifiers", "()Ljava/util/List;", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "expo-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class CardProps implements ComposeProps {
    public static final int $stable = 8;
    private final Color color;
    private final CardElementColors elementColors;
    private final List<Map<String, Object>> modifiers;
    private final String variant;

    public CardProps() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CardProps copy$default(CardProps cardProps, String str, Color color, CardElementColors cardElementColors, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = cardProps.variant;
        }
        if ((i & 2) != 0) {
            color = cardProps.color;
        }
        if ((i & 4) != 0) {
            cardElementColors = cardProps.elementColors;
        }
        if ((i & 8) != 0) {
            list = cardProps.modifiers;
        }
        return cardProps.copy(str, color, cardElementColors, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getVariant() {
        return this.variant;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Color getColor() {
        return this.color;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final CardElementColors getElementColors() {
        return this.elementColors;
    }

    public final List<Map<String, Object>> component4() {
        return this.modifiers;
    }

    public final CardProps copy(String variant, Color color, CardElementColors elementColors, List<? extends Map<String, ? extends Object>> modifiers) {
        Intrinsics.checkNotNullParameter(variant, "variant");
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        return new CardProps(variant, color, elementColors, modifiers);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CardProps)) {
            return false;
        }
        CardProps cardProps = (CardProps) other;
        return Intrinsics.areEqual(this.variant, cardProps.variant) && Intrinsics.areEqual(this.color, cardProps.color) && Intrinsics.areEqual(this.elementColors, cardProps.elementColors) && Intrinsics.areEqual(this.modifiers, cardProps.modifiers);
    }

    public int hashCode() {
        int iHashCode = this.variant.hashCode() * 31;
        Color color = this.color;
        int iHashCode2 = (iHashCode + (color == null ? 0 : color.hashCode())) * 31;
        CardElementColors cardElementColors = this.elementColors;
        return ((iHashCode2 + (cardElementColors != null ? cardElementColors.hashCode() : 0)) * 31) + this.modifiers.hashCode();
    }

    public String toString() {
        return "CardProps(variant=" + this.variant + ", color=" + this.color + ", elementColors=" + this.elementColors + ", modifiers=" + this.modifiers + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CardProps(String variant, Color color, CardElementColors cardElementColors, List<? extends Map<String, ? extends Object>> modifiers) {
        Intrinsics.checkNotNullParameter(variant, "variant");
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        this.variant = variant;
        this.color = color;
        this.elementColors = cardElementColors;
        this.modifiers = modifiers;
    }

    public /* synthetic */ CardProps(String str, Color color, CardElementColors cardElementColors, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "default" : str, (i & 2) != 0 ? null : color, (i & 4) != 0 ? null : cardElementColors, (i & 8) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final String getVariant() {
        return this.variant;
    }

    public final Color getColor() {
        return this.color;
    }

    public final CardElementColors getElementColors() {
        return this.elementColors;
    }

    public final List<Map<String, Object>> getModifiers() {
        return this.modifiers;
    }
}
