package com.box.android.preview.preview.previewbar.topbar;

import com.box.android.coreservices.utilities.BoxAccountManagerHelper;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TopBarReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/box/android/preview/preview/previewbar/topbar/TopBarEnvironment;", "", "boxAccountManagerHelper", "Lcom/box/android/coreservices/utilities/BoxAccountManagerHelper;", "<init>", "(Lcom/box/android/coreservices/utilities/BoxAccountManagerHelper;)V", "getBoxAccountManagerHelper", "()Lcom/box/android/coreservices/utilities/BoxAccountManagerHelper;", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class TopBarEnvironment {
    public static final int $stable = 8;
    private final BoxAccountManagerHelper boxAccountManagerHelper;

    @Inject
    public TopBarEnvironment(BoxAccountManagerHelper boxAccountManagerHelper) {
        Intrinsics.checkNotNullParameter(boxAccountManagerHelper, "boxAccountManagerHelper");
        this.boxAccountManagerHelper = boxAccountManagerHelper;
    }

    public final BoxAccountManagerHelper getBoxAccountManagerHelper() {
        return this.boxAccountManagerHelper;
    }
}
