package com.box.android.fileactivity.presentation;

import android.os.Bundle;
import com.box.android.cpl.IStoreFactory;
import dagger.internal.Provider;

/* JADX INFO: renamed from: com.box.android.fileactivity.presentation.FileActivitiesViewModel_Factory, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes11.dex */
public final class C1639FileActivitiesViewModel_Factory {
    private final Provider<FileActivitiesEnvironment> fileActivitiesEnvironmentProvider;
    private final Provider<IStoreFactory> storeFactoryProvider;

    private C1639FileActivitiesViewModel_Factory(Provider<FileActivitiesEnvironment> provider, Provider<IStoreFactory> provider2) {
        this.fileActivitiesEnvironmentProvider = provider;
        this.storeFactoryProvider = provider2;
    }

    public FileActivitiesViewModel get(Bundle bundle) {
        return newInstance(bundle, this.fileActivitiesEnvironmentProvider.get(), this.storeFactoryProvider.get());
    }

    public static C1639FileActivitiesViewModel_Factory create(Provider<FileActivitiesEnvironment> provider, Provider<IStoreFactory> provider2) {
        return new C1639FileActivitiesViewModel_Factory(provider, provider2);
    }

    public static FileActivitiesViewModel newInstance(Bundle bundle, FileActivitiesEnvironment fileActivitiesEnvironment, IStoreFactory iStoreFactory) {
        return new FileActivitiesViewModel(bundle, fileActivitiesEnvironment, iStoreFactory);
    }
}
