package com.box.android.activities.settings;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentFactory;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FilesAndFoldersFragmentFactory.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/box/android/activities/settings/FilesAndFoldersFragmentFactory;", "Landroidx/fragment/app/FragmentFactory;", "storeFactory", "Lcom/box/android/activities/settings/IFilesAndFoldersSettingsStoreFactory;", "<init>", "(Lcom/box/android/activities/settings/IFilesAndFoldersSettingsStoreFactory;)V", "instantiate", "Landroidx/fragment/app/Fragment;", "classLoader", "Ljava/lang/ClassLoader;", "className", "", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FilesAndFoldersFragmentFactory extends FragmentFactory {
    public static final int $stable = 8;
    private final IFilesAndFoldersSettingsStoreFactory storeFactory;

    @Inject
    public FilesAndFoldersFragmentFactory(IFilesAndFoldersSettingsStoreFactory storeFactory) {
        Intrinsics.checkNotNullParameter(storeFactory, "storeFactory");
        this.storeFactory = storeFactory;
    }

    @Override // androidx.fragment.app.FragmentFactory
    public Fragment instantiate(ClassLoader classLoader, String className) {
        Intrinsics.checkNotNullParameter(classLoader, "classLoader");
        Intrinsics.checkNotNullParameter(className, "className");
        if (Intrinsics.areEqual(className, FilesAndFoldersSettingsFragment.class.getName())) {
            return new FilesAndFoldersSettingsFragment(this.storeFactory);
        }
        Fragment fragmentInstantiate = super.instantiate(classLoader, className);
        Intrinsics.checkNotNullExpressionValue(fragmentInstantiate, "instantiate(...)");
        return fragmentInstantiate;
    }
}
