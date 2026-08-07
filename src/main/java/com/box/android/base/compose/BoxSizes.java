package com.box.android.base.compose;

import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* JADX INFO: compiled from: BoxTheme.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u000f\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0010\u0010\u0007R\u0013\u0010\u0011\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0012\u0010\u0007R\u0013\u0010\u0013\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0014\u0010\u0007R\u0013\u0010\u0015\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0016\u0010\u0007R\u0013\u0010\u0017\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0018\u0010\u0007R\u0013\u0010\u0019\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u001a\u0010\u0007R\u0013\u0010\u001b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u001c\u0010\u0007¨\u0006\u001d"}, d2 = {"Lcom/box/android/base/compose/BoxSizes;", "", "<init>", "()V", "listItemHeight", "Landroidx/compose/ui/unit/Dp;", "getListItemHeight-D9Ej5fM", "()F", "F", "listContentBottomPadding", "getListContentBottomPadding-D9Ej5fM", "avatar", "Lcom/box/android/base/compose/BoxAvatarSizes;", "getAvatar", "()Lcom/box/android/base/compose/BoxAvatarSizes;", "bottomBarHeight", "getBottomBarHeight-D9Ej5fM", "bottomBarGradientHeight", "getBottomBarGradientHeight-D9Ej5fM", "topBarHeight", "getTopBarHeight-D9Ej5fM", "expandedRenameTopBarHeight", "getExpandedRenameTopBarHeight-D9Ej5fM", "previewBottomSearchBarHeight", "getPreviewBottomSearchBarHeight-D9Ej5fM", "AudioPlayerControllerHeight", "getAudioPlayerControllerHeight-D9Ej5fM", "AudioPlayerControllerBottomPadding", "getAudioPlayerControllerBottomPadding-D9Ej5fM", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BoxSizes {
    public static final int $stable = 0;
    private static final float AudioPlayerControllerBottomPadding;
    private static final float AudioPlayerControllerHeight;
    private static final float bottomBarHeight;
    private static final float expandedRenameTopBarHeight;
    private static final float previewBottomSearchBarHeight;
    private static final float topBarHeight;
    public static final BoxSizes INSTANCE = new BoxSizes();
    private static final float listItemHeight = Dp.m9687constructorimpl(60);
    private static final float listContentBottomPadding = Dp.m9687constructorimpl(88);
    private static final BoxAvatarSizes avatar = BoxAvatarSizes.INSTANCE;
    private static final float bottomBarGradientHeight = Dp.m9687constructorimpl(12);

    private BoxSizes() {
    }

    /* JADX INFO: renamed from: getListItemHeight-D9Ej5fM, reason: not valid java name */
    public final float m11612getListItemHeightD9Ej5fM() {
        return listItemHeight;
    }

    /* JADX INFO: renamed from: getListContentBottomPadding-D9Ej5fM, reason: not valid java name */
    public final float m11611getListContentBottomPaddingD9Ej5fM() {
        return listContentBottomPadding;
    }

    public final BoxAvatarSizes getAvatar() {
        return avatar;
    }

    /* JADX INFO: renamed from: getBottomBarHeight-D9Ej5fM, reason: not valid java name */
    public final float m11609getBottomBarHeightD9Ej5fM() {
        return bottomBarHeight;
    }

    /* JADX INFO: renamed from: getBottomBarGradientHeight-D9Ej5fM, reason: not valid java name */
    public final float m11608getBottomBarGradientHeightD9Ej5fM() {
        return bottomBarGradientHeight;
    }

    /* JADX INFO: renamed from: getTopBarHeight-D9Ej5fM, reason: not valid java name */
    public final float m11614getTopBarHeightD9Ej5fM() {
        return topBarHeight;
    }

    /* JADX INFO: renamed from: getExpandedRenameTopBarHeight-D9Ej5fM, reason: not valid java name */
    public final float m11610getExpandedRenameTopBarHeightD9Ej5fM() {
        return expandedRenameTopBarHeight;
    }

    /* JADX INFO: renamed from: getPreviewBottomSearchBarHeight-D9Ej5fM, reason: not valid java name */
    public final float m11613getPreviewBottomSearchBarHeightD9Ej5fM() {
        return previewBottomSearchBarHeight;
    }

    /* JADX INFO: renamed from: getAudioPlayerControllerHeight-D9Ej5fM, reason: not valid java name */
    public final float m11607getAudioPlayerControllerHeightD9Ej5fM() {
        return AudioPlayerControllerHeight;
    }

    /* JADX INFO: renamed from: getAudioPlayerControllerBottomPadding-D9Ej5fM, reason: not valid java name */
    public final float m11606getAudioPlayerControllerBottomPaddingD9Ej5fM() {
        return AudioPlayerControllerBottomPadding;
    }

    static {
        float f = 80;
        bottomBarHeight = Dp.m9687constructorimpl(f);
        float fM9687constructorimpl = Dp.m9687constructorimpl(64);
        topBarHeight = fM9687constructorimpl;
        expandedRenameTopBarHeight = Dp.m9687constructorimpl(fM9687constructorimpl * 1.75f);
        previewBottomSearchBarHeight = Dp.m9687constructorimpl(48);
        AudioPlayerControllerHeight = Dp.m9687constructorimpl(120);
        AudioPlayerControllerBottomPadding = Dp.m9687constructorimpl(f);
    }
}
