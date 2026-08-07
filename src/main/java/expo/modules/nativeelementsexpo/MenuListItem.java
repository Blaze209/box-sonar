package expo.modules.nativeelementsexpo;

import android.graphics.drawable.Drawable;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.metrics.hubs.HubsObservability;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MenuListItem.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lexpo/modules/nativeelementsexpo/MenuListItem;", "", "<init>", "()V", "Action", "SectionHeader", "Submenu", "Divider", "Lexpo/modules/nativeelementsexpo/MenuListItem$Action;", "Lexpo/modules/nativeelementsexpo/MenuListItem$Divider;", "Lexpo/modules/nativeelementsexpo/MenuListItem$SectionHeader;", "Lexpo/modules/nativeelementsexpo/MenuListItem$Submenu;", "cirrus-native-elements-expo_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class MenuListItem {
    public static final int $stable = 0;

    public /* synthetic */ MenuListItem(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private MenuListItem() {
    }

    /* JADX INFO: compiled from: MenuListItem.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u001d\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001Bc\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010#\u001a\u00020\u0007HÆ\u0003J\t\u0010$\u001a\u00020\u0007HÆ\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u0010&\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u0010'\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001bJ\t\u0010(\u001a\u00020\u0007HÆ\u0003J\u000f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fHÆ\u0003Jv\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\r\u001a\u00020\u00072\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fHÆ\u0001¢\u0006\u0002\u0010+J\u0013\u0010,\u001a\u00020\u00072\b\u0010-\u001a\u0004\u0018\u00010.HÖ\u0003J\t\u0010/\u001a\u00020\nHÖ\u0001J\t\u00100\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u0015\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001d\u0010\u001bR\u0015\u0010\f\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001e\u0010\u001bR\u0011\u0010\r\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0018R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 ¨\u00061"}, d2 = {"Lexpo/modules/nativeelementsexpo/MenuListItem$Action;", "Lexpo/modules/nativeelementsexpo/MenuListItem;", "title", "", HubsObservability.HUB_ASSET_ICON, "Landroid/graphics/drawable/Drawable;", "disabled", "", "destructive", "destructiveColor", "", "textColor", "disabledTextColor", "isFirstInSection", "onSelected", "Lkotlin/Function0;", "", "<init>", "(Ljava/lang/String;Landroid/graphics/drawable/Drawable;ZZLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;ZLkotlin/jvm/functions/Function0;)V", "getTitle", "()Ljava/lang/String;", "getIcon", "()Landroid/graphics/drawable/Drawable;", "getDisabled", "()Z", "getDestructive", "getDestructiveColor", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTextColor", "getDisabledTextColor", "getOnSelected", "()Lkotlin/jvm/functions/Function0;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/String;Landroid/graphics/drawable/Drawable;ZZLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;ZLkotlin/jvm/functions/Function0;)Lexpo/modules/nativeelementsexpo/MenuListItem$Action;", "equals", "other", "", "hashCode", "toString", "cirrus-native-elements-expo_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class Action extends MenuListItem {
        public static final int $stable = 8;
        private final boolean destructive;
        private final Integer destructiveColor;
        private final boolean disabled;
        private final Integer disabledTextColor;
        private final Drawable icon;
        private final boolean isFirstInSection;
        private final Function0<Unit> onSelected;
        private final Integer textColor;
        private final String title;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Action copy$default(Action action, String str, Drawable drawable, boolean z, boolean z2, Integer num, Integer num2, Integer num3, boolean z3, Function0 function0, int i, Object obj) {
            if ((i & 1) != 0) {
                str = action.title;
            }
            if ((i & 2) != 0) {
                drawable = action.icon;
            }
            if ((i & 4) != 0) {
                z = action.disabled;
            }
            if ((i & 8) != 0) {
                z2 = action.destructive;
            }
            if ((i & 16) != 0) {
                num = action.destructiveColor;
            }
            if ((i & 32) != 0) {
                num2 = action.textColor;
            }
            if ((i & 64) != 0) {
                num3 = action.disabledTextColor;
            }
            if ((i & 128) != 0) {
                z3 = action.isFirstInSection;
            }
            if ((i & 256) != 0) {
                function0 = action.onSelected;
            }
            boolean z4 = z3;
            Function0 function1 = function0;
            Integer num4 = num2;
            Integer num5 = num3;
            Integer num6 = num;
            boolean z5 = z;
            return action.copy(str, drawable, z5, z2, num6, num4, num5, z4, function1);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Drawable getIcon() {
            return this.icon;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getDisabled() {
            return this.disabled;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final boolean getDestructive() {
            return this.destructive;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Integer getDestructiveColor() {
            return this.destructiveColor;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Integer getTextColor() {
            return this.textColor;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final Integer getDisabledTextColor() {
            return this.disabledTextColor;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final boolean getIsFirstInSection() {
            return this.isFirstInSection;
        }

        public final Function0<Unit> component9() {
            return this.onSelected;
        }

        public final Action copy(String title, Drawable icon, boolean disabled, boolean destructive, Integer destructiveColor, Integer textColor, Integer disabledTextColor, boolean isFirstInSection, Function0<Unit> onSelected) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(onSelected, "onSelected");
            return new Action(title, icon, disabled, destructive, destructiveColor, textColor, disabledTextColor, isFirstInSection, onSelected);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Action)) {
                return false;
            }
            Action action = (Action) other;
            return Intrinsics.areEqual(this.title, action.title) && Intrinsics.areEqual(this.icon, action.icon) && this.disabled == action.disabled && this.destructive == action.destructive && Intrinsics.areEqual(this.destructiveColor, action.destructiveColor) && Intrinsics.areEqual(this.textColor, action.textColor) && Intrinsics.areEqual(this.disabledTextColor, action.disabledTextColor) && this.isFirstInSection == action.isFirstInSection && Intrinsics.areEqual(this.onSelected, action.onSelected);
        }

        public int hashCode() {
            int iHashCode = this.title.hashCode() * 31;
            Drawable drawable = this.icon;
            int iHashCode2 = (((((iHashCode + (drawable == null ? 0 : drawable.hashCode())) * 31) + Boolean.hashCode(this.disabled)) * 31) + Boolean.hashCode(this.destructive)) * 31;
            Integer num = this.destructiveColor;
            int iHashCode3 = (iHashCode2 + (num == null ? 0 : num.hashCode())) * 31;
            Integer num2 = this.textColor;
            int iHashCode4 = (iHashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
            Integer num3 = this.disabledTextColor;
            return ((((iHashCode4 + (num3 != null ? num3.hashCode() : 0)) * 31) + Boolean.hashCode(this.isFirstInSection)) * 31) + this.onSelected.hashCode();
        }

        public String toString() {
            return "Action(title=" + this.title + ", icon=" + this.icon + ", disabled=" + this.disabled + ", destructive=" + this.destructive + ", destructiveColor=" + this.destructiveColor + ", textColor=" + this.textColor + ", disabledTextColor=" + this.disabledTextColor + ", isFirstInSection=" + this.isFirstInSection + ", onSelected=" + this.onSelected + ")";
        }

        public final String getTitle() {
            return this.title;
        }

        public final Drawable getIcon() {
            return this.icon;
        }

        public final boolean getDisabled() {
            return this.disabled;
        }

        public final boolean getDestructive() {
            return this.destructive;
        }

        public final Integer getDestructiveColor() {
            return this.destructiveColor;
        }

        public final Integer getTextColor() {
            return this.textColor;
        }

        public final Integer getDisabledTextColor() {
            return this.disabledTextColor;
        }

        public final boolean isFirstInSection() {
            return this.isFirstInSection;
        }

        public final Function0<Unit> getOnSelected() {
            return this.onSelected;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Action(String title, Drawable drawable, boolean z, boolean z2, Integer num, Integer num2, Integer num3, boolean z3, Function0<Unit> onSelected) {
            super(null);
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(onSelected, "onSelected");
            this.title = title;
            this.icon = drawable;
            this.disabled = z;
            this.destructive = z2;
            this.destructiveColor = num;
            this.textColor = num2;
            this.disabledTextColor = num3;
            this.isFirstInSection = z3;
            this.onSelected = onSelected;
        }
    }

    /* JADX INFO: compiled from: MenuListItem.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J.\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000f¨\u0006\u001a"}, d2 = {"Lexpo/modules/nativeelementsexpo/MenuListItem$SectionHeader;", "Lexpo/modules/nativeelementsexpo/MenuListItem;", "title", "", "titleColor", "", "isFirstInSection", "", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Z)V", "getTitle", "()Ljava/lang/String;", "getTitleColor", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "()Z", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/String;Ljava/lang/Integer;Z)Lexpo/modules/nativeelementsexpo/MenuListItem$SectionHeader;", "equals", "other", "", "hashCode", "toString", "cirrus-native-elements-expo_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class SectionHeader extends MenuListItem {
        public static final int $stable = 0;
        private final boolean isFirstInSection;
        private final String title;
        private final Integer titleColor;

        public static /* synthetic */ SectionHeader copy$default(SectionHeader sectionHeader, String str, Integer num, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                str = sectionHeader.title;
            }
            if ((i & 2) != 0) {
                num = sectionHeader.titleColor;
            }
            if ((i & 4) != 0) {
                z = sectionHeader.isFirstInSection;
            }
            return sectionHeader.copy(str, num, z);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Integer getTitleColor() {
            return this.titleColor;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getIsFirstInSection() {
            return this.isFirstInSection;
        }

        public final SectionHeader copy(String title, Integer titleColor, boolean isFirstInSection) {
            Intrinsics.checkNotNullParameter(title, "title");
            return new SectionHeader(title, titleColor, isFirstInSection);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SectionHeader)) {
                return false;
            }
            SectionHeader sectionHeader = (SectionHeader) other;
            return Intrinsics.areEqual(this.title, sectionHeader.title) && Intrinsics.areEqual(this.titleColor, sectionHeader.titleColor) && this.isFirstInSection == sectionHeader.isFirstInSection;
        }

        public int hashCode() {
            int iHashCode = this.title.hashCode() * 31;
            Integer num = this.titleColor;
            return ((iHashCode + (num == null ? 0 : num.hashCode())) * 31) + Boolean.hashCode(this.isFirstInSection);
        }

        public String toString() {
            return "SectionHeader(title=" + this.title + ", titleColor=" + this.titleColor + ", isFirstInSection=" + this.isFirstInSection + ")";
        }

        public final String getTitle() {
            return this.title;
        }

        public final Integer getTitleColor() {
            return this.titleColor;
        }

        public final boolean isFirstInSection() {
            return this.isFirstInSection;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SectionHeader(String title, Integer num, boolean z) {
            super(null);
            Intrinsics.checkNotNullParameter(title, "title");
            this.title = title;
            this.titleColor = num;
            this.isFirstInSection = z;
        }
    }

    /* JADX INFO: compiled from: MenuListItem.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J7\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u000f¨\u0006\u001d"}, d2 = {"Lexpo/modules/nativeelementsexpo/MenuListItem$Submenu;", "Lexpo/modules/nativeelementsexpo/MenuListItem;", "title", "", "disabled", "", "actions", "", "Lexpo/modules/nativeelementsexpo/MenuAction;", "isFirstInSection", "<init>", "(Ljava/lang/String;ZLjava/util/List;Z)V", "getTitle", "()Ljava/lang/String;", "getDisabled", "()Z", "getActions", "()Ljava/util/List;", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "", "hashCode", "", "toString", "cirrus-native-elements-expo_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class Submenu extends MenuListItem {
        public static final int $stable = 8;
        private final List<MenuAction> actions;
        private final boolean disabled;
        private final boolean isFirstInSection;
        private final String title;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Submenu copy$default(Submenu submenu, String str, boolean z, List list, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = submenu.title;
            }
            if ((i & 2) != 0) {
                z = submenu.disabled;
            }
            if ((i & 4) != 0) {
                list = submenu.actions;
            }
            if ((i & 8) != 0) {
                z2 = submenu.isFirstInSection;
            }
            return submenu.copy(str, z, list, z2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getDisabled() {
            return this.disabled;
        }

        public final List<MenuAction> component3() {
            return this.actions;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final boolean getIsFirstInSection() {
            return this.isFirstInSection;
        }

        public final Submenu copy(String title, boolean disabled, List<? extends MenuAction> actions, boolean isFirstInSection) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(actions, "actions");
            return new Submenu(title, disabled, actions, isFirstInSection);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Submenu)) {
                return false;
            }
            Submenu submenu = (Submenu) other;
            return Intrinsics.areEqual(this.title, submenu.title) && this.disabled == submenu.disabled && Intrinsics.areEqual(this.actions, submenu.actions) && this.isFirstInSection == submenu.isFirstInSection;
        }

        public int hashCode() {
            return (((((this.title.hashCode() * 31) + Boolean.hashCode(this.disabled)) * 31) + this.actions.hashCode()) * 31) + Boolean.hashCode(this.isFirstInSection);
        }

        public String toString() {
            return "Submenu(title=" + this.title + ", disabled=" + this.disabled + ", actions=" + this.actions + ", isFirstInSection=" + this.isFirstInSection + ")";
        }

        public final String getTitle() {
            return this.title;
        }

        public final boolean getDisabled() {
            return this.disabled;
        }

        public final List<MenuAction> getActions() {
            return this.actions;
        }

        public final boolean isFirstInSection() {
            return this.isFirstInSection;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public Submenu(String title, boolean z, List<? extends MenuAction> actions, boolean z2) {
            super(null);
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(actions, "actions");
            this.title = title;
            this.disabled = z;
            this.actions = actions;
            this.isFirstInSection = z2;
        }
    }

    /* JADX INFO: compiled from: MenuListItem.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0018\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"Lexpo/modules/nativeelementsexpo/MenuListItem$Divider;", "Lexpo/modules/nativeelementsexpo/MenuListItem;", "dummy", "", "<init>", "(Lkotlin/Unit;)V", "getDummy", "()Lkotlin/Unit;", "Lkotlin/Unit;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Lkotlin/Unit;)Lexpo/modules/nativeelementsexpo/MenuListItem$Divider;", "equals", "", "other", "", "hashCode", "", "toString", "", "cirrus-native-elements-expo_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class Divider extends MenuListItem {
        public static final int $stable = 0;
        private final Unit dummy;

        /* JADX WARN: Multi-variable type inference failed */
        public Divider() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ Divider copy$default(Divider divider, Unit unit, int i, Object obj) {
            if ((i & 1) != 0) {
                unit = divider.dummy;
            }
            return divider.copy(unit);
        }

        public final void component1() {
        }

        public final Divider copy(Unit dummy) {
            Intrinsics.checkNotNullParameter(dummy, "dummy");
            return new Divider(dummy);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Divider) && Intrinsics.areEqual(this.dummy, ((Divider) other).dummy);
        }

        public int hashCode() {
            return this.dummy.hashCode();
        }

        public String toString() {
            return "Divider(dummy=" + this.dummy + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Divider(Unit dummy) {
            super(null);
            Intrinsics.checkNotNullParameter(dummy, "dummy");
            this.dummy = dummy;
        }

        public /* synthetic */ Divider(Unit unit, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? Unit.INSTANCE : unit);
        }

        public final Unit getDummy() {
            return this.dummy;
        }
    }
}
