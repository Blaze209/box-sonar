package com.box.android.preview.wopi;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes12.dex */
public final class OfficeAppDetector_Factory implements Factory<OfficeAppDetector> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public OfficeAppDetector get() {
        return newInstance();
    }

    public static OfficeAppDetector_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static OfficeAppDetector newInstance() {
        return new OfficeAppDetector();
    }

    private static final class InstanceHolder {
        static final OfficeAppDetector_Factory INSTANCE = new OfficeAppDetector_Factory();

        private InstanceHolder() {
        }
    }
}
