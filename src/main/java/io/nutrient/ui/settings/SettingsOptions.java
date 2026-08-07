package io.nutrient.ui.settings;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.pspdfkit.configuration.page.PageLayoutMode;
import com.pspdfkit.configuration.page.PageScrollDirection;
import com.pspdfkit.configuration.page.PageScrollMode;
import com.pspdfkit.configuration.settings.SettingsMenuItemType;
import com.pspdfkit.configuration.theming.ThemeMode;
import java.io.Serializable;
import java.util.EnumSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b&\n\u0002\u0010\u000e\n\u0000\b\u0017\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0012\u001a\u00020\u0010¢\u0006\u0004\b\u0013\u0010\u0014J\u0006\u00103\u001a\u00020\u0000J\u000e\u00104\u001a\u00020\u00102\u0006\u00105\u001a\u00020\u0000J\n\u00106\u001a\u000207H\u0096\u0080\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001a\u0010\u0011\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010,\"\u0004\b0\u0010.R\u001a\u0010\u0012\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010,\"\u0004\b2\u0010.¨\u00068"}, d2 = {"Lio/nutrient/ui/settings/SettingsOptions;", "Ljava/io/Serializable;", "scrollDirection", "Lcom/pspdfkit/configuration/page/PageScrollDirection;", "scrollMode", "Lcom/pspdfkit/configuration/page/PageScrollMode;", "layoutMode", "Lcom/pspdfkit/configuration/page/PageLayoutMode;", "themeMode", "Lcom/pspdfkit/configuration/theming/ThemeMode;", "screenTimeoutMillis", "", "visibleItems", "Ljava/util/EnumSet;", "Lcom/pspdfkit/configuration/settings/SettingsMenuItemType;", "snapToPoint", "", "snapToSelf", "showSmartGuides", "<init>", "(Lcom/pspdfkit/configuration/page/PageScrollDirection;Lcom/pspdfkit/configuration/page/PageScrollMode;Lcom/pspdfkit/configuration/page/PageLayoutMode;Lcom/pspdfkit/configuration/theming/ThemeMode;JLjava/util/EnumSet;ZZZ)V", "getScrollDirection", "()Lcom/pspdfkit/configuration/page/PageScrollDirection;", "setScrollDirection", "(Lcom/pspdfkit/configuration/page/PageScrollDirection;)V", "getScrollMode", "()Lcom/pspdfkit/configuration/page/PageScrollMode;", "setScrollMode", "(Lcom/pspdfkit/configuration/page/PageScrollMode;)V", "getLayoutMode", "()Lcom/pspdfkit/configuration/page/PageLayoutMode;", "setLayoutMode", "(Lcom/pspdfkit/configuration/page/PageLayoutMode;)V", "getThemeMode", "()Lcom/pspdfkit/configuration/theming/ThemeMode;", "setThemeMode", "(Lcom/pspdfkit/configuration/theming/ThemeMode;)V", "getScreenTimeoutMillis", "()J", "setScreenTimeoutMillis", "(J)V", "getVisibleItems", "()Ljava/util/EnumSet;", "getSnapToPoint", "()Z", "setSnapToPoint", "(Z)V", "getSnapToSelf", "setSnapToSelf", "getShowSmartGuides", "setShowSmartGuides", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "compare", "other", "toString", "", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public class SettingsOptions implements Serializable {
    public static final int $stable = 8;
    private PageLayoutMode layoutMode;
    private long screenTimeoutMillis;
    private PageScrollDirection scrollDirection;
    private PageScrollMode scrollMode;
    private boolean showSmartGuides;
    private boolean snapToPoint;
    private boolean snapToSelf;
    private ThemeMode themeMode;
    private final EnumSet<SettingsMenuItemType> visibleItems;

    public SettingsOptions(PageScrollDirection pageScrollDirection, PageScrollMode pageScrollMode, PageLayoutMode pageLayoutMode, ThemeMode themeMode, long j, EnumSet<SettingsMenuItemType> enumSet, boolean z, boolean z2, boolean z3) {
        pageScrollDirection.getClass();
        pageScrollMode.getClass();
        pageLayoutMode.getClass();
        themeMode.getClass();
        enumSet.getClass();
        this.scrollDirection = pageScrollDirection;
        this.scrollMode = pageScrollMode;
        this.layoutMode = pageLayoutMode;
        this.themeMode = themeMode;
        this.screenTimeoutMillis = j;
        this.visibleItems = enumSet;
        this.snapToPoint = z;
        this.snapToSelf = z2;
        this.showSmartGuides = z3;
    }

    public final boolean compare(SettingsOptions other) {
        other.getClass();
        return this.scrollDirection == other.scrollDirection && this.scrollMode == other.scrollMode && this.layoutMode == other.layoutMode && this.themeMode == other.themeMode && this.screenTimeoutMillis == other.screenTimeoutMillis && Intrinsics.areEqual(this.visibleItems, other.visibleItems) && this.snapToPoint == other.snapToPoint && this.snapToSelf == other.snapToSelf && this.showSmartGuides == other.showSmartGuides;
    }

    public final SettingsOptions copy() {
        PageScrollDirection pageScrollDirection = this.scrollDirection;
        PageScrollMode pageScrollMode = this.scrollMode;
        PageLayoutMode pageLayoutMode = this.layoutMode;
        ThemeMode themeMode = this.themeMode;
        long j = this.screenTimeoutMillis;
        EnumSet<E> enumSetClone = this.visibleItems.clone();
        enumSetClone.getClass();
        return new SettingsOptions(pageScrollDirection, pageScrollMode, pageLayoutMode, themeMode, j, enumSetClone, this.snapToPoint, this.snapToSelf, this.showSmartGuides);
    }

    public final PageLayoutMode getLayoutMode() {
        return this.layoutMode;
    }

    public final long getScreenTimeoutMillis() {
        return this.screenTimeoutMillis;
    }

    public final PageScrollDirection getScrollDirection() {
        return this.scrollDirection;
    }

    public final PageScrollMode getScrollMode() {
        return this.scrollMode;
    }

    public final boolean getShowSmartGuides() {
        return this.showSmartGuides;
    }

    public final boolean getSnapToPoint() {
        return this.snapToPoint;
    }

    public final boolean getSnapToSelf() {
        return this.snapToSelf;
    }

    public final ThemeMode getThemeMode() {
        return this.themeMode;
    }

    public final EnumSet<SettingsMenuItemType> getVisibleItems() {
        return this.visibleItems;
    }

    public final void setLayoutMode(PageLayoutMode pageLayoutMode) {
        pageLayoutMode.getClass();
        this.layoutMode = pageLayoutMode;
    }

    public final void setScreenTimeoutMillis(long j) {
        this.screenTimeoutMillis = j;
    }

    public final void setScrollDirection(PageScrollDirection pageScrollDirection) {
        pageScrollDirection.getClass();
        this.scrollDirection = pageScrollDirection;
    }

    public final void setScrollMode(PageScrollMode pageScrollMode) {
        pageScrollMode.getClass();
        this.scrollMode = pageScrollMode;
    }

    public final void setShowSmartGuides(boolean z) {
        this.showSmartGuides = z;
    }

    public final void setSnapToPoint(boolean z) {
        this.snapToPoint = z;
    }

    public final void setSnapToSelf(boolean z) {
        this.snapToSelf = z;
    }

    public final void setThemeMode(ThemeMode themeMode) {
        themeMode.getClass();
        this.themeMode = themeMode;
    }

    public String toString() {
        return "SettingsOptions(scrollDirection=" + this.scrollDirection + ", scrollMode=" + this.scrollMode + ", layoutMode=" + this.layoutMode + ", themeMode=" + this.themeMode + ", screenTimeoutMillis=" + this.screenTimeoutMillis + ", visibleItems=" + this.visibleItems + ", snapToPoint=" + this.snapToPoint + ", snapToSelf=" + this.snapToSelf + ", showSmartGuides=" + this.showSmartGuides + ")";
    }
}
