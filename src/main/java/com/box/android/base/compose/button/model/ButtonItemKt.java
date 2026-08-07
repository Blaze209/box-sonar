package com.box.android.base.compose.button.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ButtonItem.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"toIconButtonItem", "Lcom/box/android/base/compose/button/model/ButtonItem$IconButtonItem;", "Lcom/box/android/base/compose/button/model/ButtonItem$BadgedIconButtonItem;", "base_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ButtonItemKt {
    public static final ButtonItem.IconButtonItem toIconButtonItem(ButtonItem.BadgedIconButtonItem badgedIconButtonItem) {
        Intrinsics.checkNotNullParameter(badgedIconButtonItem, "<this>");
        ButtonItemIconResource iconResource = badgedIconButtonItem.getIconResource();
        return new ButtonItem.IconButtonItem(badgedIconButtonItem.getIsEnabled(), badgedIconButtonItem.getOnClick(), badgedIconButtonItem.getContentDescription(), iconResource, badgedIconButtonItem.isLoading());
    }
}
