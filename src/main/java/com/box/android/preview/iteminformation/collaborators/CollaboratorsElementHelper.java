package com.box.android.preview.iteminformation.collaborators;

import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* JADX INFO: compiled from: CollaboratorsElementHelper.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/box/android/preview/iteminformation/collaborators/CollaboratorsElementHelper;", "", "<init>", "()V", "calculateAvatarsToDisplay", "", "avatarSize", "Landroidx/compose/ui/unit/Dp;", "overlapSize", "availableWidth", "maxAvatars", "calculateAvatarsToDisplay-DRUOcmI", "(FFFI)I", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CollaboratorsElementHelper {
    public static final int $stable = 0;
    public static final CollaboratorsElementHelper INSTANCE = new CollaboratorsElementHelper();

    private CollaboratorsElementHelper() {
    }

    /* JADX INFO: renamed from: calculateAvatarsToDisplay-DRUOcmI, reason: not valid java name */
    public final int m12847calculateAvatarsToDisplayDRUOcmI(float avatarSize, float overlapSize, float availableWidth, int maxAvatars) {
        return Integer.min((int) (Dp.m9687constructorimpl(availableWidth - overlapSize) / Dp.m9687constructorimpl(avatarSize - overlapSize)), maxAvatars);
    }
}
