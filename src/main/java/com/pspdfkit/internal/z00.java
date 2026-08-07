package com.pspdfkit.internal;

import com.pspdfkit.configuration.page.PageLayoutMode;
import com.pspdfkit.configuration.page.PageScrollDirection;
import com.pspdfkit.configuration.page.PageScrollMode;
import com.pspdfkit.configuration.settings.SettingsMenuItemType;
import com.pspdfkit.configuration.theming.ThemeMode;
import io.nutrient.ui.settings.SettingsOptions;
import java.util.EnumSet;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class z00 {
    public final SettingsOptions a;
    public final boolean b;
    public final a10 c;
    public final Set<SettingsMenuItemType> d;
    public final Set<SettingsMenuItemType> e;

    public z00() {
        this(0);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof z00)) {
            return false;
        }
        z00 z00Var = (z00) obj;
        return Intrinsics.areEqual(this.a, z00Var.a) && this.b == z00Var.b && Intrinsics.areEqual(this.c, z00Var.c);
    }

    public final int hashCode() {
        int iA = mv.a(this.b, this.a.hashCode() * 31, 31);
        a10 a10Var = this.c;
        return iA + (a10Var == null ? 0 : a10Var.hashCode());
    }

    public final String toString() {
        return "SettingsState(options=" + this.a + ", saveEnabled=" + this.b + ", theme=" + this.c + ")";
    }

    public z00(SettingsOptions settingsOptions, boolean z, a10 a10Var) {
        this.a = settingsOptions;
        this.b = z;
        this.c = a10Var;
        this.d = SetsKt.setOf((Object[]) new SettingsMenuItemType[]{SettingsMenuItemType.PAGE_TRANSITION, SettingsMenuItemType.PAGE_LAYOUT, SettingsMenuItemType.SCROLL_DIRECTION});
        this.e = SetsKt.setOf((Object[]) new SettingsMenuItemType[]{SettingsMenuItemType.THEME, SettingsMenuItemType.SCREEN_AWAKE});
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ z00(int i) {
        PageScrollDirection pageScrollDirection = PageScrollDirection.VERTICAL;
        PageScrollMode pageScrollMode = PageScrollMode.CONTINUOUS;
        PageLayoutMode pageLayoutMode = PageLayoutMode.AUTO;
        ThemeMode themeMode = ThemeMode.DEFAULT;
        EnumSet enumSetNoneOf = EnumSet.noneOf(SettingsMenuItemType.class);
        enumSetNoneOf.getClass();
        this(new SettingsOptions(pageScrollDirection, pageScrollMode, pageLayoutMode, themeMode, 0L, enumSetNoneOf, false, false, false), false, null);
    }
}
