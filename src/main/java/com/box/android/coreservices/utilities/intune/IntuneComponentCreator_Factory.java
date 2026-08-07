package com.box.android.coreservices.utilities.intune;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes9.dex */
public final class IntuneComponentCreator_Factory implements Factory<IntuneComponentCreator> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public IntuneComponentCreator get() {
        return newInstance();
    }

    public static IntuneComponentCreator_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static IntuneComponentCreator newInstance() {
        return new IntuneComponentCreator();
    }

    private static final class InstanceHolder {
        static final IntuneComponentCreator_Factory INSTANCE = new IntuneComponentCreator_Factory();

        private InstanceHolder() {
        }
    }
}
