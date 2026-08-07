package com.box.android.jobsui;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes12.dex */
public final class JobsUICoreHelper_Factory implements Factory<JobsUICoreHelper> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public JobsUICoreHelper get() {
        return newInstance();
    }

    public static JobsUICoreHelper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static JobsUICoreHelper newInstance() {
        return new JobsUICoreHelper();
    }

    private static final class InstanceHolder {
        static final JobsUICoreHelper_Factory INSTANCE = new JobsUICoreHelper_Factory();

        private InstanceHolder() {
        }
    }
}
