package com.box.android.preview.filesandfolders;

import com.box.android.domain.models.preview.PageScrollDirection;
import com.box.android.domain.models.preview.PageScrollMode;
import com.box.android.domain.models.preview.ScrollSettings;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PagingModeHelper.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/box/android/preview/filesandfolders/PagingModeHelper;", "", "<init>", "()V", "getPagingMode", "Lcom/box/android/preview/filesandfolders/PagingMode;", "scrollSettings", "Lcom/box/android/domain/models/preview/ScrollSettings;", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PagingModeHelper {
    public static final int $stable = 0;
    public static final PagingModeHelper INSTANCE = new PagingModeHelper();

    private PagingModeHelper() {
    }

    public final PagingMode getPagingMode(ScrollSettings scrollSettings) {
        Intrinsics.checkNotNullParameter(scrollSettings, "scrollSettings");
        PageScrollDirection direction = scrollSettings.getDirection();
        PageScrollMode mode = scrollSettings.getMode();
        if (direction == PageScrollDirection.HORIZONTAL && mode == PageScrollMode.PER_PAGE) {
            return PagingMode.HORIZONTAL;
        }
        if (direction == PageScrollDirection.VERTICAL && mode == PageScrollMode.PER_PAGE) {
            return PagingMode.VERTICAL;
        }
        return (direction == PageScrollDirection.VERTICAL && mode == PageScrollMode.CONTINUOUS) ? PagingMode.VERTICAL_CONTINUOUS : PagingMode.UNSUPPORTED;
    }
}
