package com.box.android.observability;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes12.dex */
public final class ObservabilitySettingsManager_Factory implements Factory<ObservabilitySettingsManager> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public ObservabilitySettingsManager get() {
        return newInstance();
    }

    public static ObservabilitySettingsManager_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static ObservabilitySettingsManager newInstance() {
        return new ObservabilitySettingsManager();
    }

    private static final class InstanceHolder {
        static final ObservabilitySettingsManager_Factory INSTANCE = new ObservabilitySettingsManager_Factory();

        private InstanceHolder() {
        }
    }
}
