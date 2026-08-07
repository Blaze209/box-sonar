package com.box.android.browse.cpl.helpers;

import com.box.android.base.presentation.activities.BoxFragmentActivity;
import com.box.android.browse.cpl.browse.fab.FabManager;
import com.box.android.domain.identity.IUserContextManager;
import dagger.internal.Provider;

/* JADX INFO: renamed from: com.box.android.browse.cpl.helpers.FabHelper_Factory, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C0950FabHelper_Factory {
    private final Provider<FabManager> fabManagerProvider;
    private final Provider<IUserContextManager> userContextManagerProvider;

    private C0950FabHelper_Factory(Provider<IUserContextManager> provider, Provider<FabManager> provider2) {
        this.userContextManagerProvider = provider;
        this.fabManagerProvider = provider2;
    }

    public FabHelper get(BoxFragmentActivity boxFragmentActivity) {
        return newInstance(this.userContextManagerProvider.get(), this.fabManagerProvider.get(), boxFragmentActivity);
    }

    public static C0950FabHelper_Factory create(Provider<IUserContextManager> provider, Provider<FabManager> provider2) {
        return new C0950FabHelper_Factory(provider, provider2);
    }

    public static FabHelper newInstance(IUserContextManager iUserContextManager, FabManager fabManager, BoxFragmentActivity boxFragmentActivity) {
        return new FabHelper(iUserContextManager, fabManager, boxFragmentActivity);
    }
}
