package com.pspdfkit.internal;

import com.pspdfkit.configuration.page.PageLayoutMode;
import com.pspdfkit.configuration.page.PageScrollDirection;
import com.pspdfkit.configuration.page.PageScrollMode;
import io.nutrient.ui.settings.SettingsOptions;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'd' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:422)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:351)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:160)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: loaded from: classes3.dex */
public final class xw {
    public static final xw d;
    public static final xw e;
    public static final /* synthetic */ xw[] f;
    public final PageScrollMode a;
    public final PageLayoutMode b;
    public final PageScrollDirection c;

    static {
        PageScrollMode pageScrollMode = PageScrollMode.PER_PAGE;
        PageLayoutMode pageLayoutMode = PageLayoutMode.AUTO;
        xw xwVar = new xw("HORIZONTAL", 0, pageScrollMode, pageLayoutMode, PageScrollDirection.HORIZONTAL);
        d = xwVar;
        xw xwVar2 = new xw("VERTICAL", 1, PageScrollMode.CONTINUOUS, pageLayoutMode, PageScrollDirection.VERTICAL);
        e = xwVar2;
        xw[] xwVarArr = {xwVar, xwVar2};
        f = xwVarArr;
        EnumEntriesKt.enumEntries(xwVarArr);
    }

    public xw(String str, int i, PageScrollMode pageScrollMode, PageLayoutMode pageLayoutMode, PageScrollDirection pageScrollDirection) {
        super(str, i);
        this.a = pageScrollMode;
        this.b = pageLayoutMode;
        this.c = pageScrollDirection;
    }

    public static xw valueOf(String str) {
        return (xw) Enum.valueOf(xw.class, str);
    }

    public static xw[] values() {
        return (xw[]) f.clone();
    }

    public final boolean a(SettingsOptions settingsOptions) {
        settingsOptions.getClass();
        return this.a == settingsOptions.getScrollMode() && this.b == settingsOptions.getLayoutMode() && this.c == settingsOptions.getScrollDirection();
    }
}
