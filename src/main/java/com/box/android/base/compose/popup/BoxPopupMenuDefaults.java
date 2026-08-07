package com.box.android.base.compose.popup;

import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* JADX INFO: compiled from: BoxPopupMenu.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0001\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/box/android/base/compose/popup/BoxPopupMenuDefaults;", "", "<init>", "()V", "DefaultWidth", "Landroidx/compose/ui/unit/Dp;", "getDefaultWidth-D9Ej5fM", "()F", "F", "WrapContentWidth", "", "getWrapContentWidth", "()Ljava/lang/Void;", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BoxPopupMenuDefaults {
    private static final Void WrapContentWidth = null;
    public static final BoxPopupMenuDefaults INSTANCE = new BoxPopupMenuDefaults();
    private static final float DefaultWidth = Dp.m9687constructorimpl(258);
    public static final int $stable = 8;

    private BoxPopupMenuDefaults() {
    }

    /* JADX INFO: renamed from: getDefaultWidth-D9Ej5fM, reason: not valid java name */
    public final float m11730getDefaultWidthD9Ej5fM() {
        return DefaultWidth;
    }

    public final Void getWrapContentWidth() {
        return WrapContentWidth;
    }
}
