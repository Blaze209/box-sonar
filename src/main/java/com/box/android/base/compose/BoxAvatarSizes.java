package com.box.android.base.compose;

import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* JADX INFO: compiled from: BoxTheme.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/box/android/base/compose/BoxAvatarSizes;", "", "<init>", "()V", "Large", "Landroidx/compose/ui/unit/Dp;", "getLarge-D9Ej5fM", "()F", "F", "Medium", "getMedium-D9Ej5fM", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BoxAvatarSizes {
    public static final int $stable = 0;
    public static final BoxAvatarSizes INSTANCE = new BoxAvatarSizes();
    private static final float Large = Dp.m9687constructorimpl(32);
    private static final float Medium = Dp.m9687constructorimpl(28);

    private BoxAvatarSizes() {
    }

    /* JADX INFO: renamed from: getLarge-D9Ej5fM, reason: not valid java name */
    public final float m11349getLargeD9Ej5fM() {
        return Large;
    }

    /* JADX INFO: renamed from: getMedium-D9Ej5fM, reason: not valid java name */
    public final float m11350getMediumD9Ej5fM() {
        return Medium;
    }
}
