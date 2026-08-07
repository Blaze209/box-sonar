package com.box.android.navigationmodernization.homescreen;

import com.box.android.domain.services.ITabPersistenceService;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HomeScreenViewModel.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/box/android/navigationmodernization/homescreen/HomeScreenEnvironment;", "", "tabPersistenceService", "Lcom/box/android/domain/services/ITabPersistenceService;", "<init>", "(Lcom/box/android/domain/services/ITabPersistenceService;)V", "getTabPersistenceService", "()Lcom/box/android/domain/services/ITabPersistenceService;", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class HomeScreenEnvironment {
    public static final int $stable = 8;
    private final ITabPersistenceService tabPersistenceService;

    @Inject
    public HomeScreenEnvironment(ITabPersistenceService tabPersistenceService) {
        Intrinsics.checkNotNullParameter(tabPersistenceService, "tabPersistenceService");
        this.tabPersistenceService = tabPersistenceService;
    }

    public final ITabPersistenceService getTabPersistenceService() {
        return this.tabPersistenceService;
    }
}
