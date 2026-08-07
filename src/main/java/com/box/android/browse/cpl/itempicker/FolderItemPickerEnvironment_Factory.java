package com.box.android.browse.cpl.itempicker;

import com.box.android.browse.cpl.browse.FolderViewEnvironment;
import com.box.android.browse.cpl.createfolder.CreateFolderEnvironment;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes10.dex */
public final class FolderItemPickerEnvironment_Factory implements Factory<FolderItemPickerEnvironment> {
    private final Provider<CreateFolderEnvironment> createFolderEnvironmentProvider;
    private final Provider<FolderViewEnvironment> itemsListViewEnvironmentProvider;

    private FolderItemPickerEnvironment_Factory(Provider<FolderViewEnvironment> provider, Provider<CreateFolderEnvironment> provider2) {
        this.itemsListViewEnvironmentProvider = provider;
        this.createFolderEnvironmentProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public FolderItemPickerEnvironment get() {
        return newInstance(this.itemsListViewEnvironmentProvider.get(), this.createFolderEnvironmentProvider.get());
    }

    public static FolderItemPickerEnvironment_Factory create(Provider<FolderViewEnvironment> provider, Provider<CreateFolderEnvironment> provider2) {
        return new FolderItemPickerEnvironment_Factory(provider, provider2);
    }

    public static FolderItemPickerEnvironment newInstance(FolderViewEnvironment folderViewEnvironment, CreateFolderEnvironment createFolderEnvironment) {
        return new FolderItemPickerEnvironment(folderViewEnvironment, createFolderEnvironment);
    }
}
