package expo.modules.ui;

import android.graphics.Color;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import expo.modules.kotlin.views.ComposeProps;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ListItemView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bg\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012$\b\u0002\u0010\n\u001a\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\r0\fj\u0002`\u000e0\u000bj\u0002`\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\tHÆ\u0003J%\u0010!\u001a\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\r0\fj\u0002`\u000e0\u000bj\u0002`\u000fHÆ\u0003Ji\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2$\b\u0002\u0010\n\u001a\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\r0\fj\u0002`\u000e0\u000bj\u0002`\u000fHÆ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R-\u0010\n\u001a\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\r0\fj\u0002`\u000e0\u000bj\u0002`\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006)"}, d2 = {"Lexpo/modules/ui/ListItemProps;", "Lexpo/modules/kotlin/views/ComposeProps;", "headline", "", "supportingText", "overlineText", "color", "Landroid/graphics/Color;", "colors", "Lexpo/modules/ui/ListItemColors;", "modifiers", "", "", "", "Lexpo/modules/ui/ModifierType;", "Lexpo/modules/ui/ModifierList;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/graphics/Color;Lexpo/modules/ui/ListItemColors;Ljava/util/List;)V", "getHeadline", "()Ljava/lang/String;", "getSupportingText", "getOverlineText", "getColor", "()Landroid/graphics/Color;", "getColors", "()Lexpo/modules/ui/ListItemColors;", "getModifiers", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "expo-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class ListItemProps implements ComposeProps {
    public static final int $stable = 8;
    private final Color color;
    private final ListItemColors colors;
    private final String headline;
    private final List<Map<String, Object>> modifiers;
    private final String overlineText;
    private final String supportingText;

    public ListItemProps() {
        this(null, null, null, null, null, null, 63, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ListItemProps copy$default(ListItemProps listItemProps, String str, String str2, String str3, Color color, ListItemColors listItemColors, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = listItemProps.headline;
        }
        if ((i & 2) != 0) {
            str2 = listItemProps.supportingText;
        }
        if ((i & 4) != 0) {
            str3 = listItemProps.overlineText;
        }
        if ((i & 8) != 0) {
            color = listItemProps.color;
        }
        if ((i & 16) != 0) {
            listItemColors = listItemProps.colors;
        }
        if ((i & 32) != 0) {
            list = listItemProps.modifiers;
        }
        ListItemColors listItemColors2 = listItemColors;
        List list2 = list;
        return listItemProps.copy(str, str2, str3, color, listItemColors2, list2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getHeadline() {
        return this.headline;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSupportingText() {
        return this.supportingText;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getOverlineText() {
        return this.overlineText;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Color getColor() {
        return this.color;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final ListItemColors getColors() {
        return this.colors;
    }

    public final List<Map<String, Object>> component6() {
        return this.modifiers;
    }

    public final ListItemProps copy(String headline, String supportingText, String overlineText, Color color, ListItemColors colors, List<? extends Map<String, ? extends Object>> modifiers) {
        Intrinsics.checkNotNullParameter(headline, "headline");
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        return new ListItemProps(headline, supportingText, overlineText, color, colors, modifiers);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ListItemProps)) {
            return false;
        }
        ListItemProps listItemProps = (ListItemProps) other;
        return Intrinsics.areEqual(this.headline, listItemProps.headline) && Intrinsics.areEqual(this.supportingText, listItemProps.supportingText) && Intrinsics.areEqual(this.overlineText, listItemProps.overlineText) && Intrinsics.areEqual(this.color, listItemProps.color) && Intrinsics.areEqual(this.colors, listItemProps.colors) && Intrinsics.areEqual(this.modifiers, listItemProps.modifiers);
    }

    public int hashCode() {
        int iHashCode = this.headline.hashCode() * 31;
        String str = this.supportingText;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.overlineText;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Color color = this.color;
        int iHashCode4 = (iHashCode3 + (color == null ? 0 : color.hashCode())) * 31;
        ListItemColors listItemColors = this.colors;
        return ((iHashCode4 + (listItemColors != null ? listItemColors.hashCode() : 0)) * 31) + this.modifiers.hashCode();
    }

    public String toString() {
        return "ListItemProps(headline=" + this.headline + ", supportingText=" + this.supportingText + ", overlineText=" + this.overlineText + ", color=" + this.color + ", colors=" + this.colors + ", modifiers=" + this.modifiers + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ListItemProps(String headline, String str, String str2, Color color, ListItemColors listItemColors, List<? extends Map<String, ? extends Object>> modifiers) {
        Intrinsics.checkNotNullParameter(headline, "headline");
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        this.headline = headline;
        this.supportingText = str;
        this.overlineText = str2;
        this.color = color;
        this.colors = listItemColors;
        this.modifiers = modifiers;
    }

    public /* synthetic */ ListItemProps(String str, String str2, String str3, Color color, ListItemColors listItemColors, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : color, (i & 16) != 0 ? null : listItemColors, (i & 32) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final String getHeadline() {
        return this.headline;
    }

    public final String getSupportingText() {
        return this.supportingText;
    }

    public final String getOverlineText() {
        return this.overlineText;
    }

    public final Color getColor() {
        return this.color;
    }

    public final ListItemColors getColors() {
        return this.colors;
    }

    public final List<Map<String, Object>> getModifiers() {
        return this.modifiers;
    }
}
