package com.box.android.hubs.hubDetails.presentation;

import com.box.android.domain.services.IBVEManager;
import com.box.android.domain.utils.IBoxUriSupportChecker;
import com.box.android.hubs.hubDetails.domain.HubSpecificUrlHandler;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HubDetailsReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/box/android/hubs/hubDetails/presentation/HubDetailsEnvironment;", "", "boxUriSupportChecker", "Lcom/box/android/domain/utils/IBoxUriSupportChecker;", "hubsSpecificUrlHandler", "Lcom/box/android/hubs/hubDetails/domain/HubSpecificUrlHandler;", "bveManager", "Lcom/box/android/domain/services/IBVEManager;", "<init>", "(Lcom/box/android/domain/utils/IBoxUriSupportChecker;Lcom/box/android/hubs/hubDetails/domain/HubSpecificUrlHandler;Lcom/box/android/domain/services/IBVEManager;)V", "getBoxUriSupportChecker", "()Lcom/box/android/domain/utils/IBoxUriSupportChecker;", "getHubsSpecificUrlHandler", "()Lcom/box/android/hubs/hubDetails/domain/HubSpecificUrlHandler;", "getBveManager", "()Lcom/box/android/domain/services/IBVEManager;", "hubs_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class HubDetailsEnvironment {
    public static final int $stable = 8;
    private final IBoxUriSupportChecker boxUriSupportChecker;
    private final IBVEManager bveManager;
    private final HubSpecificUrlHandler hubsSpecificUrlHandler;

    @Inject
    public HubDetailsEnvironment(IBoxUriSupportChecker boxUriSupportChecker, HubSpecificUrlHandler hubsSpecificUrlHandler, IBVEManager bveManager) {
        Intrinsics.checkNotNullParameter(boxUriSupportChecker, "boxUriSupportChecker");
        Intrinsics.checkNotNullParameter(hubsSpecificUrlHandler, "hubsSpecificUrlHandler");
        Intrinsics.checkNotNullParameter(bveManager, "bveManager");
        this.boxUriSupportChecker = boxUriSupportChecker;
        this.hubsSpecificUrlHandler = hubsSpecificUrlHandler;
        this.bveManager = bveManager;
    }

    public final IBoxUriSupportChecker getBoxUriSupportChecker() {
        return this.boxUriSupportChecker;
    }

    public final HubSpecificUrlHandler getHubsSpecificUrlHandler() {
        return this.hubsSpecificUrlHandler;
    }

    public final IBVEManager getBveManager() {
        return this.bveManager;
    }
}
