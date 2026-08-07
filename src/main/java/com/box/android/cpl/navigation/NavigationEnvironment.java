package com.box.android.cpl.navigation;

import com.box.android.browse.cpl.browse.BrowseEnvironment;
import com.box.android.browse.cpl.offlined.OfflinedEnvironment;
import com.box.android.browse.cpl.recents.RecentsEnvironment;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NavigationReducer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/box/android/cpl/navigation/NavigationEnvironment;", "", "browseEnvironment", "Lcom/box/android/browse/cpl/browse/BrowseEnvironment;", "recentsEnvironment", "Lcom/box/android/browse/cpl/recents/RecentsEnvironment;", "offlinedEnvironment", "Lcom/box/android/browse/cpl/offlined/OfflinedEnvironment;", "<init>", "(Lcom/box/android/browse/cpl/browse/BrowseEnvironment;Lcom/box/android/browse/cpl/recents/RecentsEnvironment;Lcom/box/android/browse/cpl/offlined/OfflinedEnvironment;)V", "getBrowseEnvironment", "()Lcom/box/android/browse/cpl/browse/BrowseEnvironment;", "getRecentsEnvironment", "()Lcom/box/android/browse/cpl/recents/RecentsEnvironment;", "getOfflinedEnvironment", "()Lcom/box/android/browse/cpl/offlined/OfflinedEnvironment;", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class NavigationEnvironment {
    public static final int $stable = (OfflinedEnvironment.$stable | RecentsEnvironment.$stable) | BrowseEnvironment.$stable;
    private final BrowseEnvironment browseEnvironment;
    private final OfflinedEnvironment offlinedEnvironment;
    private final RecentsEnvironment recentsEnvironment;

    @Inject
    public NavigationEnvironment(BrowseEnvironment browseEnvironment, RecentsEnvironment recentsEnvironment, OfflinedEnvironment offlinedEnvironment) {
        Intrinsics.checkNotNullParameter(browseEnvironment, "browseEnvironment");
        Intrinsics.checkNotNullParameter(recentsEnvironment, "recentsEnvironment");
        Intrinsics.checkNotNullParameter(offlinedEnvironment, "offlinedEnvironment");
        this.browseEnvironment = browseEnvironment;
        this.recentsEnvironment = recentsEnvironment;
        this.offlinedEnvironment = offlinedEnvironment;
    }

    public final BrowseEnvironment getBrowseEnvironment() {
        return this.browseEnvironment;
    }

    public final RecentsEnvironment getRecentsEnvironment() {
        return this.recentsEnvironment;
    }

    public final OfflinedEnvironment getOfflinedEnvironment() {
        return this.offlinedEnvironment;
    }
}
