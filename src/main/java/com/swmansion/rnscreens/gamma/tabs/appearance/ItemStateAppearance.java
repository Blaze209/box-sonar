package com.swmansion.rnscreens.gamma.tabs.appearance;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TabsAppearanceModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ&\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u000eJ\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/swmansion/rnscreens/gamma/tabs/appearance/ItemStateAppearance;", "", "tabBarItemIconColor", "", "tabBarItemTitleFontColor", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "getTabBarItemIconColor", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTabBarItemTitleFontColor", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/swmansion/rnscreens/gamma/tabs/appearance/ItemStateAppearance;", "equals", "", "other", "hashCode", "toString", "", "react-native-screens_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class ItemStateAppearance {
    private final Integer tabBarItemIconColor;
    private final Integer tabBarItemTitleFontColor;

    /* JADX WARN: Multi-variable type inference failed */
    public ItemStateAppearance() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ ItemStateAppearance copy$default(ItemStateAppearance itemStateAppearance, Integer num, Integer num2, int i, Object obj) {
        if ((i & 1) != 0) {
            num = itemStateAppearance.tabBarItemIconColor;
        }
        if ((i & 2) != 0) {
            num2 = itemStateAppearance.tabBarItemTitleFontColor;
        }
        return itemStateAppearance.copy(num, num2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Integer getTabBarItemIconColor() {
        return this.tabBarItemIconColor;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Integer getTabBarItemTitleFontColor() {
        return this.tabBarItemTitleFontColor;
    }

    public final ItemStateAppearance copy(Integer tabBarItemIconColor, Integer tabBarItemTitleFontColor) {
        return new ItemStateAppearance(tabBarItemIconColor, tabBarItemTitleFontColor);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ItemStateAppearance)) {
            return false;
        }
        ItemStateAppearance itemStateAppearance = (ItemStateAppearance) other;
        return Intrinsics.areEqual(this.tabBarItemIconColor, itemStateAppearance.tabBarItemIconColor) && Intrinsics.areEqual(this.tabBarItemTitleFontColor, itemStateAppearance.tabBarItemTitleFontColor);
    }

    public int hashCode() {
        Integer num = this.tabBarItemIconColor;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.tabBarItemTitleFontColor;
        return iHashCode + (num2 != null ? num2.hashCode() : 0);
    }

    public String toString() {
        return "ItemStateAppearance(tabBarItemIconColor=" + this.tabBarItemIconColor + ", tabBarItemTitleFontColor=" + this.tabBarItemTitleFontColor + ")";
    }

    public ItemStateAppearance(Integer num, Integer num2) {
        this.tabBarItemIconColor = num;
        this.tabBarItemTitleFontColor = num2;
    }

    public /* synthetic */ ItemStateAppearance(Integer num, Integer num2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2);
    }

    public final Integer getTabBarItemIconColor() {
        return this.tabBarItemIconColor;
    }

    public final Integer getTabBarItemTitleFontColor() {
        return this.tabBarItemTitleFontColor;
    }
}
