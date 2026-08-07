package com.box.android.preview.preview.previewbar.bottombar;

import com.box.android.coreservices.utilities.FileActionsManager;
import com.box.android.domain.services.IBoxAiService;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BottomBarReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/box/android/preview/preview/previewbar/bottombar/BottomBarEnvironment;", "", "fileActionsManager", "Lcom/box/android/coreservices/utilities/FileActionsManager;", "boxAiService", "Lcom/box/android/domain/services/IBoxAiService;", "<init>", "(Lcom/box/android/coreservices/utilities/FileActionsManager;Lcom/box/android/domain/services/IBoxAiService;)V", "getFileActionsManager", "()Lcom/box/android/coreservices/utilities/FileActionsManager;", "getBoxAiService", "()Lcom/box/android/domain/services/IBoxAiService;", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BottomBarEnvironment {
    public static final int $stable = 8;
    private final IBoxAiService boxAiService;
    private final FileActionsManager fileActionsManager;

    @Inject
    public BottomBarEnvironment(FileActionsManager fileActionsManager, IBoxAiService boxAiService) {
        Intrinsics.checkNotNullParameter(fileActionsManager, "fileActionsManager");
        Intrinsics.checkNotNullParameter(boxAiService, "boxAiService");
        this.fileActionsManager = fileActionsManager;
        this.boxAiService = boxAiService;
    }

    public final IBoxAiService getBoxAiService() {
        return this.boxAiService;
    }

    public final FileActionsManager getFileActionsManager() {
        return this.fileActionsManager;
    }
}
