package com.box.android.activities.settings;

import com.box.android.cpl.Store;
import com.box.android.preview.filesandfolders.FilesAndFoldersReducer;
import kotlin.Metadata;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: FilesAndFoldersSettingsStoreFactory.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lcom/box/android/activities/settings/IFilesAndFoldersSettingsStoreFactory;", "", "createStore", "Lcom/box/android/cpl/Store;", "Lcom/box/android/preview/filesandfolders/FilesAndFoldersReducer$State;", "Lcom/box/android/preview/filesandfolders/FilesAndFoldersReducer$Action;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IFilesAndFoldersSettingsStoreFactory {
    Store<FilesAndFoldersReducer.State, FilesAndFoldersReducer.Action> createStore(CoroutineScope scope);
}
