package com.pspdfkit.internal;

import com.pspdfkit.configuration.page.PageLayoutMode;
import com.pspdfkit.configuration.page.PageScrollDirection;
import com.pspdfkit.configuration.settings.SettingsMenuItemType;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class c10 {
    public static final /* synthetic */ int[] a;
    public static final /* synthetic */ int[] b;
    public static final /* synthetic */ int[] c;

    static {
        int[] iArr = new int[PageLayoutMode.values().length];
        try {
            iArr[PageLayoutMode.SINGLE.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr[PageLayoutMode.DOUBLE.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        a = iArr;
        int[] iArr2 = new int[SettingsMenuItemType.values().length];
        try {
            iArr2[SettingsMenuItemType.PAGE_TRANSITION.ordinal()] = 1;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr2[SettingsMenuItemType.PAGE_LAYOUT.ordinal()] = 2;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            iArr2[SettingsMenuItemType.SCROLL_DIRECTION.ordinal()] = 3;
        } catch (NoSuchFieldError unused5) {
        }
        b = iArr2;
        int[] iArr3 = new int[PageScrollDirection.values().length];
        try {
            iArr3[PageScrollDirection.HORIZONTAL.ordinal()] = 1;
        } catch (NoSuchFieldError unused6) {
        }
        c = iArr3;
    }
}
