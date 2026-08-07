package com.box.android.activities.settings;

import com.box.android.cpl.Store;
import com.box.android.domain.models.preview.ScrollableFileType;
import com.box.android.domain.services.IPreviewSettingsService;
import com.box.android.preview.filesandfolders.FilesAndFoldersReducer;
import com.box.android.preview.filesandfolders.FilesAndFoldersSettingsEnvironment;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: FilesAndFoldersSettingsStoreFactory.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/box/android/activities/settings/FilesAndFoldersSettingsStoreFactory;", "Lcom/box/android/activities/settings/IFilesAndFoldersSettingsStoreFactory;", "previewSettingsService", "Lcom/box/android/domain/services/IPreviewSettingsService;", "<init>", "(Lcom/box/android/domain/services/IPreviewSettingsService;)V", "createStore", "Lcom/box/android/cpl/Store;", "Lcom/box/android/preview/filesandfolders/FilesAndFoldersReducer$State;", "Lcom/box/android/preview/filesandfolders/FilesAndFoldersReducer$Action;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FilesAndFoldersSettingsStoreFactory implements IFilesAndFoldersSettingsStoreFactory {
    public static final int $stable = 8;
    private final IPreviewSettingsService previewSettingsService;

    @Inject
    public FilesAndFoldersSettingsStoreFactory(IPreviewSettingsService previewSettingsService) {
        Intrinsics.checkNotNullParameter(previewSettingsService, "previewSettingsService");
        this.previewSettingsService = previewSettingsService;
    }

    @Override // com.box.android.activities.settings.IFilesAndFoldersSettingsStoreFactory
    public Store<FilesAndFoldersReducer.State, FilesAndFoldersReducer.Action> createStore(CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        return new Store<>(new FilesAndFoldersReducer.State(this.previewSettingsService.getPageFitMode(), this.previewSettingsService.getPageScrollSettings(ScrollableFileType.PDF), this.previewSettingsService.getPageScrollSettings(ScrollableFileType.POWERPOINT), this.previewSettingsService.getPageScrollSettings(ScrollableFileType.WORD), null, false, 48, null), null, new FilesAndFoldersReducer(new FilesAndFoldersSettingsEnvironment(this.previewSettingsService)), scope, null, 18, null);
    }
}
