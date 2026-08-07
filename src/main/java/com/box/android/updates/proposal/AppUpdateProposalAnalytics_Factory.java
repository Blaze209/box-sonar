package com.box.android.updates.proposal;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes13.dex */
public final class AppUpdateProposalAnalytics_Factory implements Factory<AppUpdateProposalAnalytics> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public AppUpdateProposalAnalytics get() {
        return newInstance();
    }

    public static AppUpdateProposalAnalytics_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static AppUpdateProposalAnalytics newInstance() {
        return new AppUpdateProposalAnalytics();
    }

    private static final class InstanceHolder {
        static final AppUpdateProposalAnalytics_Factory INSTANCE = new AppUpdateProposalAnalytics_Factory();

        private InstanceHolder() {
        }
    }
}
