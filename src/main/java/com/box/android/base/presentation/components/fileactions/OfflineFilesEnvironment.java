package com.box.android.base.presentation.components.fileactions;

import com.box.android.coreservices.utilities.FileActionsManager;
import com.box.android.domain.services.IOfflineService;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OfflineFilesReducer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/box/android/base/presentation/components/fileactions/OfflineFilesEnvironment;", "", "fileActionsManager", "Lcom/box/android/coreservices/utilities/FileActionsManager;", "offlineService", "Lcom/box/android/domain/services/IOfflineService;", "<init>", "(Lcom/box/android/coreservices/utilities/FileActionsManager;Lcom/box/android/domain/services/IOfflineService;)V", "getFileActionsManager", "()Lcom/box/android/coreservices/utilities/FileActionsManager;", "getOfflineService", "()Lcom/box/android/domain/services/IOfflineService;", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class OfflineFilesEnvironment {
    public static final int $stable = 8;
    private final FileActionsManager fileActionsManager;
    private final IOfflineService offlineService;

    @Inject
    public OfflineFilesEnvironment(FileActionsManager fileActionsManager, IOfflineService offlineService) {
        Intrinsics.checkNotNullParameter(fileActionsManager, "fileActionsManager");
        Intrinsics.checkNotNullParameter(offlineService, "offlineService");
        this.fileActionsManager = fileActionsManager;
        this.offlineService = offlineService;
    }

    public final FileActionsManager getFileActionsManager() {
        return this.fileActionsManager;
    }

    public final IOfflineService getOfflineService() {
        return this.offlineService;
    }
}
