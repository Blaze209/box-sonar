package com.box.android.cpl.mainphone;

import com.box.android.browse.cpl.browse.BrowseEnvironment;
import com.box.android.domain.configuration.ConfigManager;
import com.box.android.domain.identity.IUserContextManager;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MainPhoneReducer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/box/android/cpl/mainphone/MainPhoneEnvironment;", "", "browseEnvironment", "Lcom/box/android/browse/cpl/browse/BrowseEnvironment;", "mConfigManager", "Lcom/box/android/domain/configuration/ConfigManager;", "mUserContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "<init>", "(Lcom/box/android/browse/cpl/browse/BrowseEnvironment;Lcom/box/android/domain/configuration/ConfigManager;Lcom/box/android/domain/identity/IUserContextManager;)V", "getBrowseEnvironment", "()Lcom/box/android/browse/cpl/browse/BrowseEnvironment;", "getMConfigManager", "()Lcom/box/android/domain/configuration/ConfigManager;", "getMUserContextManager", "()Lcom/box/android/domain/identity/IUserContextManager;", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MainPhoneEnvironment {
    public static final int $stable = 8;
    private final BrowseEnvironment browseEnvironment;
    private final ConfigManager mConfigManager;
    private final IUserContextManager mUserContextManager;

    @Inject
    public MainPhoneEnvironment(BrowseEnvironment browseEnvironment, ConfigManager mConfigManager, IUserContextManager mUserContextManager) {
        Intrinsics.checkNotNullParameter(browseEnvironment, "browseEnvironment");
        Intrinsics.checkNotNullParameter(mConfigManager, "mConfigManager");
        Intrinsics.checkNotNullParameter(mUserContextManager, "mUserContextManager");
        this.browseEnvironment = browseEnvironment;
        this.mConfigManager = mConfigManager;
        this.mUserContextManager = mUserContextManager;
    }

    public final BrowseEnvironment getBrowseEnvironment() {
        return this.browseEnvironment;
    }

    public final ConfigManager getMConfigManager() {
        return this.mConfigManager;
    }

    public final IUserContextManager getMUserContextManager() {
        return this.mUserContextManager;
    }
}
