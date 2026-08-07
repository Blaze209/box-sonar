package com.box.android.browse.cpl.itempicker;

import com.box.android.browse.cpl.createfolder.CreateFolderEnvironment;
import com.box.android.browse.cpl.recents.RecentsViewEnvironment;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes10.dex */
public final class RecentItemPickerEnvironment_Factory implements Factory<RecentItemPickerEnvironment> {
    private final Provider<CreateFolderEnvironment> createFolderEnvironmentProvider;
    private final Provider<RecentsViewEnvironment> itemsListViewEnvironmentProvider;

    private RecentItemPickerEnvironment_Factory(Provider<RecentsViewEnvironment> provider, Provider<CreateFolderEnvironment> provider2) {
        this.itemsListViewEnvironmentProvider = provider;
        this.createFolderEnvironmentProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public RecentItemPickerEnvironment get() {
        return newInstance(this.itemsListViewEnvironmentProvider.get(), this.createFolderEnvironmentProvider.get());
    }

    public static RecentItemPickerEnvironment_Factory create(Provider<RecentsViewEnvironment> provider, Provider<CreateFolderEnvironment> provider2) {
        return new RecentItemPickerEnvironment_Factory(provider, provider2);
    }

    public static RecentItemPickerEnvironment newInstance(RecentsViewEnvironment recentsViewEnvironment, CreateFolderEnvironment createFolderEnvironment) {
        return new RecentItemPickerEnvironment(recentsViewEnvironment, createFolderEnvironment);
    }
}
