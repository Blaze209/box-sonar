package com.box.android.common.di;

import com.box.android.common.utilities.Clock;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes10.dex */
public final class CommonModule_ProvidesClockFactory implements Factory<Clock> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public Clock get() {
        return providesClock();
    }

    public static CommonModule_ProvidesClockFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static Clock providesClock() {
        return (Clock) Preconditions.checkNotNullFromProvides(CommonModule.INSTANCE.providesClock());
    }

    private static final class InstanceHolder {
        static final CommonModule_ProvidesClockFactory INSTANCE = new CommonModule_ProvidesClockFactory();

        private InstanceHolder() {
        }
    }
}
