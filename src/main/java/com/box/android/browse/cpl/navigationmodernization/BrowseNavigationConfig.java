package com.box.android.browse.cpl.navigationmodernization;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BrowseNavigationConfig.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/box/android/browse/cpl/navigationmodernization/BrowseNavigationConfig;", "", "startDestination", "Lcom/box/android/browse/cpl/navigationmodernization/BrowseDestination$InnerDestination$TabsScreen;", "<init>", "(Lcom/box/android/browse/cpl/navigationmodernization/BrowseDestination$InnerDestination$TabsScreen;)V", "getStartDestination", "()Lcom/box/android/browse/cpl/navigationmodernization/BrowseDestination$InnerDestination$TabsScreen;", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BrowseNavigationConfig {
    public static final int $stable = 8;
    private final BrowseDestination.InnerDestination.TabsScreen startDestination;

    public BrowseNavigationConfig(BrowseDestination.InnerDestination.TabsScreen startDestination) {
        Intrinsics.checkNotNullParameter(startDestination, "startDestination");
        this.startDestination = startDestination;
    }

    public final BrowseDestination.InnerDestination.TabsScreen getStartDestination() {
        return this.startDestination;
    }
}
