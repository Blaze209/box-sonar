package com.pspdfkit.compose.theme;

import androidx.compose.material3.SwitchColors;
import androidx.compose.material3.SwitchDefaults;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.preview.annotations.ui.views.ColorPickerFragment;
import com.facebook.react.modules.appstate.AppStateModule;
import com.pspdfkit.internal.r;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\u0015\u001a\u00020\u0016H\u0007¢\u0006\u0002\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0019\u0010\rJ\u0010\u0010\u001a\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u001b\u0010\rJ\u0010\u0010\u001c\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u001d\u0010\rJ\u0010\u0010\u001e\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u001f\u0010\rJ\u0010\u0010 \u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b!\u0010\rJ\u0010\u0010\"\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b#\u0010\rJ\u0010\u0010$\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b%\u0010\rJV\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001¢\u0006\u0004\b'\u0010(J\u0014\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010,\u001a\u00020-HÖ\u0081\u0004J\n\u0010.\u001a\u00020/HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u000f\u0010\rR\u0013\u0010\u0005\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0010\u0010\rR\u0013\u0010\u0006\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0011\u0010\rR\u0013\u0010\u0007\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0012\u0010\rR\u0013\u0010\b\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0013\u0010\rR\u0013\u0010\t\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0014\u0010\r¨\u00060"}, d2 = {"Lcom/pspdfkit/compose/theme/SettingsColorScheme;", "", ColorPickerFragment.EXTRA_SELECTED_COLOR, "Landroidx/compose/ui/graphics/Color;", "unselectedColor", "unselectedTextColor", AppStateModule.APP_STATE_BACKGROUND, "dividerColor", "titleTextColor", "labelTextColor", "<init>", "(JJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getSelectedColor-0d7_KjU", "()J", "J", "getUnselectedColor-0d7_KjU", "getUnselectedTextColor-0d7_KjU", "getBackground-0d7_KjU", "getDividerColor-0d7_KjU", "getTitleTextColor-0d7_KjU", "getLabelTextColor-0d7_KjU", "forSwitch", "Landroidx/compose/material3/SwitchColors;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/SwitchColors;", "component1", "component1-0d7_KjU", "component2", "component2-0d7_KjU", "component3", "component3-0d7_KjU", "component4", "component4-0d7_KjU", "component5", "component5-0d7_KjU", "component6", "component6-0d7_KjU", "component7", "component7-0d7_KjU", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "copy-4JmcsL4", "(JJJJJJJ)Lcom/pspdfkit/compose/theme/SettingsColorScheme;", "equals", "", "other", "hashCode", "", "toString", "", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class SettingsColorScheme {
    public static final int $stable = 0;
    private final long background;
    private final long dividerColor;
    private final long labelTextColor;
    private final long selectedColor;
    private final long titleTextColor;
    private final long unselectedColor;
    private final long unselectedTextColor;

    public /* synthetic */ SettingsColorScheme(long j, long j2, long j3, long j4, long j5, long j6, long j7, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, j5, j6, j7);
    }

    /* JADX INFO: renamed from: component1-0d7_KjU, reason: not valid java name and from getter */
    public final long getSelectedColor() {
        return this.selectedColor;
    }

    /* JADX INFO: renamed from: component2-0d7_KjU, reason: not valid java name and from getter */
    public final long getUnselectedColor() {
        return this.unselectedColor;
    }

    /* JADX INFO: renamed from: component3-0d7_KjU, reason: not valid java name and from getter */
    public final long getUnselectedTextColor() {
        return this.unselectedTextColor;
    }

    /* JADX INFO: renamed from: component4-0d7_KjU, reason: not valid java name and from getter */
    public final long getBackground() {
        return this.background;
    }

    /* JADX INFO: renamed from: component5-0d7_KjU, reason: not valid java name and from getter */
    public final long getDividerColor() {
        return this.dividerColor;
    }

    /* JADX INFO: renamed from: component6-0d7_KjU, reason: not valid java name and from getter */
    public final long getTitleTextColor() {
        return this.titleTextColor;
    }

    /* JADX INFO: renamed from: component7-0d7_KjU, reason: not valid java name and from getter */
    public final long getLabelTextColor() {
        return this.labelTextColor;
    }

    /* JADX INFO: renamed from: copy-4JmcsL4, reason: not valid java name */
    public final SettingsColorScheme m13954copy4JmcsL4(long selectedColor, long unselectedColor, long unselectedTextColor, long background, long dividerColor, long titleTextColor, long labelTextColor) {
        return new SettingsColorScheme(selectedColor, unselectedColor, unselectedTextColor, background, dividerColor, titleTextColor, labelTextColor, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SettingsColorScheme)) {
            return false;
        }
        SettingsColorScheme settingsColorScheme = (SettingsColorScheme) other;
        return Color.m6815equalsimpl0(this.selectedColor, settingsColorScheme.selectedColor) && Color.m6815equalsimpl0(this.unselectedColor, settingsColorScheme.unselectedColor) && Color.m6815equalsimpl0(this.unselectedTextColor, settingsColorScheme.unselectedTextColor) && Color.m6815equalsimpl0(this.background, settingsColorScheme.background) && Color.m6815equalsimpl0(this.dividerColor, settingsColorScheme.dividerColor) && Color.m6815equalsimpl0(this.titleTextColor, settingsColorScheme.titleTextColor) && Color.m6815equalsimpl0(this.labelTextColor, settingsColorScheme.labelTextColor);
    }

    public final SwitchColors forSwitch(Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2076068801, i, -1, "com.pspdfkit.compose.theme.SettingsColorScheme.forSwitch (StyleElements.kt:113)");
        }
        SwitchDefaults switchDefaults = SwitchDefaults.INSTANCE;
        long j = this.selectedColor;
        long j2 = this.unselectedColor;
        long jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(j, 0.3f, 0.0f, 0.0f, 0.0f, 14, null);
        long j3 = this.background;
        long j4 = this.selectedColor;
        long j5 = this.unselectedColor;
        SwitchColors switchColorsM4356colorsV1nXRL4 = switchDefaults.m4356colorsV1nXRL4(j, jM6813copywmQWz5c$default, j, 0L, j2, j3, j, 0L, j4, Color.m6813copywmQWz5c$default(j5, 0.3f, 0.0f, 0.0f, 0.0f, 14, null), j5, 0L, j5, Color.m6813copywmQWz5c$default(this.unselectedColor, 0.3f, 0.0f, 0.0f, 0.0f, 14, null), j5, 0L, composer, 0, SwitchDefaults.$stable << 18, 34952);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return switchColorsM4356colorsV1nXRL4;
    }

    /* JADX INFO: renamed from: getBackground-0d7_KjU, reason: not valid java name */
    public final long m13955getBackground0d7_KjU() {
        return this.background;
    }

    /* JADX INFO: renamed from: getDividerColor-0d7_KjU, reason: not valid java name */
    public final long m13956getDividerColor0d7_KjU() {
        return this.dividerColor;
    }

    /* JADX INFO: renamed from: getLabelTextColor-0d7_KjU, reason: not valid java name */
    public final long m13957getLabelTextColor0d7_KjU() {
        return this.labelTextColor;
    }

    /* JADX INFO: renamed from: getSelectedColor-0d7_KjU, reason: not valid java name */
    public final long m13958getSelectedColor0d7_KjU() {
        return this.selectedColor;
    }

    /* JADX INFO: renamed from: getTitleTextColor-0d7_KjU, reason: not valid java name */
    public final long m13959getTitleTextColor0d7_KjU() {
        return this.titleTextColor;
    }

    /* JADX INFO: renamed from: getUnselectedColor-0d7_KjU, reason: not valid java name */
    public final long m13960getUnselectedColor0d7_KjU() {
        return this.unselectedColor;
    }

    /* JADX INFO: renamed from: getUnselectedTextColor-0d7_KjU, reason: not valid java name */
    public final long m13961getUnselectedTextColor0d7_KjU() {
        return this.unselectedTextColor;
    }

    public int hashCode() {
        return Color.m6821hashCodeimpl(this.labelTextColor) + r.a(this.titleTextColor, r.a(this.dividerColor, r.a(this.background, r.a(this.unselectedTextColor, r.a(this.unselectedColor, Color.m6821hashCodeimpl(this.selectedColor) * 31, 31), 31), 31), 31), 31);
    }

    public String toString() {
        return "SettingsColorScheme(selectedColor=" + Color.m6822toStringimpl(this.selectedColor) + ", unselectedColor=" + Color.m6822toStringimpl(this.unselectedColor) + ", unselectedTextColor=" + Color.m6822toStringimpl(this.unselectedTextColor) + ", background=" + Color.m6822toStringimpl(this.background) + ", dividerColor=" + Color.m6822toStringimpl(this.dividerColor) + ", titleTextColor=" + Color.m6822toStringimpl(this.titleTextColor) + ", labelTextColor=" + Color.m6822toStringimpl(this.labelTextColor) + ")";
    }

    private SettingsColorScheme(long j, long j2, long j3, long j4, long j5, long j6, long j7) {
        this.selectedColor = j;
        this.unselectedColor = j2;
        this.unselectedTextColor = j3;
        this.background = j4;
        this.dividerColor = j5;
        this.titleTextColor = j6;
        this.labelTextColor = j7;
    }
}
