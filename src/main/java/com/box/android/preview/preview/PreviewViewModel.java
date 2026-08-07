package com.box.android.preview.preview;

import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.box.android.common.utilities.ViewModelAssistedFactory;
import com.box.android.cpl.IStoreFactory;
import com.box.android.cpl.Store;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.preview.PreviewSource;
import com.box.android.preview.previewtype.boxnote.BoxNoteConstants;
import com.box.android.preview.utils.PreviewPrefetcher;
import dagger.assisted.Assisted;
import dagger.assisted.AssistedFactory;
import dagger.assisted.AssistedInject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PreviewViewModel.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 $2\u00020\u0001:\u0002#$B+\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010!\u001a\u00020\"H\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e0\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 ¨\u0006%"}, d2 = {"Lcom/box/android/preview/preview/PreviewViewModel;", "Landroidx/lifecycle/ViewModel;", "args", "Landroid/os/Bundle;", "previewEnvironment", "Lcom/box/android/preview/preview/PreviewEnvironment;", "previewPrefetcher", "Lcom/box/android/preview/utils/PreviewPrefetcher;", "storeFactory", "Lcom/box/android/cpl/IStoreFactory;", "<init>", "(Landroid/os/Bundle;Lcom/box/android/preview/preview/PreviewEnvironment;Lcom/box/android/preview/utils/PreviewPrefetcher;Lcom/box/android/cpl/IStoreFactory;)V", "getPreviewEnvironment", "()Lcom/box/android/preview/preview/PreviewEnvironment;", "getPreviewPrefetcher", "()Lcom/box/android/preview/utils/PreviewPrefetcher;", "getStoreFactory", "()Lcom/box/android/cpl/IStoreFactory;", "fileModel", "Lcom/box/android/domain/models/item/FileModel;", "previewSource", "Lcom/box/android/domain/models/preview/PreviewSource;", BoxNoteConstants.NOTES_BUILDER_SHARED_LINK, "", "observabilityId", "isNewlyCreatedFile", "", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/preview/preview/PreviewReducer$State;", "Lcom/box/android/preview/preview/PreviewReducer$Action;", "getStore", "()Lcom/box/android/cpl/Store;", "onCleared", "", "Factory", "Companion", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PreviewViewModel extends ViewModel {
    public static final String VM_INITIAL_FILE_MODEL_KEY = "VM_INITIAL_FILE_MODEL_KEY";
    public static final String VM_IS_NEWLY_CREATED_FILE = "VM_IS_NEWLY_CREATED_FILE";
    public static final String VM_OBSERVABILITY_ID = "VM_OBSERVABILITY_ID";
    public static final String VM_PREVIEW_SOURCE = "PREVIEW_SOURCE";
    public static final String VM_SHARED_LINK_KEY = "VM_SHARED_LINK_KEY";
    private final Bundle args;
    private final FileModel fileModel;
    private final boolean isNewlyCreatedFile;
    private final String observabilityId;
    private final PreviewEnvironment previewEnvironment;
    private final PreviewPrefetcher previewPrefetcher;
    private final PreviewSource previewSource;
    private final String sharedLink;
    private final Store<PreviewReducer.State, PreviewReducer.Action> store;
    private final IStoreFactory storeFactory;
    public static final int $stable = 8;

    /* JADX INFO: compiled from: PreviewViewModel.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003À\u0006\u0003"}, d2 = {"Lcom/box/android/preview/preview/PreviewViewModel$Factory;", "Lcom/box/android/common/utilities/ViewModelAssistedFactory;", "Lcom/box/android/preview/preview/PreviewViewModel;", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @AssistedFactory
    public interface Factory extends ViewModelAssistedFactory<PreviewViewModel> {
    }

    @AssistedInject
    public PreviewViewModel(@Assisted Bundle args, PreviewEnvironment previewEnvironment, PreviewPrefetcher previewPrefetcher, IStoreFactory storeFactory) {
        Parcelable parcelable;
        Parcelable parcelable2;
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(previewEnvironment, "previewEnvironment");
        Intrinsics.checkNotNullParameter(previewPrefetcher, "previewPrefetcher");
        Intrinsics.checkNotNullParameter(storeFactory, "storeFactory");
        this.args = args;
        this.previewEnvironment = previewEnvironment;
        this.previewPrefetcher = previewPrefetcher;
        this.storeFactory = storeFactory;
        if (Build.VERSION.SDK_INT >= 33) {
            parcelable = (Parcelable) args.getParcelable("VM_INITIAL_FILE_MODEL_KEY", FileModel.class);
        } else {
            Parcelable parcelable3 = args.getParcelable("VM_INITIAL_FILE_MODEL_KEY");
            parcelable = (FileModel) (parcelable3 instanceof FileModel ? parcelable3 : null);
        }
        if (parcelable == null) {
            throw new IllegalArgumentException("Parcelable with key VM_INITIAL_FILE_MODEL_KEY not found in Bundle".toString());
        }
        FileModel fileModel = (FileModel) parcelable;
        this.fileModel = fileModel;
        if (Build.VERSION.SDK_INT >= 33) {
            parcelable2 = (Parcelable) args.getParcelable("PREVIEW_SOURCE", PreviewSource.class);
        } else {
            Parcelable parcelable4 = args.getParcelable("PREVIEW_SOURCE");
            parcelable2 = (PreviewSource) (parcelable4 instanceof PreviewSource ? parcelable4 : null);
        }
        if (parcelable2 == null) {
            throw new IllegalArgumentException("Parcelable with key PREVIEW_SOURCE not found in Bundle".toString());
        }
        PreviewSource previewSource = (PreviewSource) parcelable2;
        this.previewSource = previewSource;
        String string = args.getString(VM_SHARED_LINK_KEY);
        this.sharedLink = string;
        String string2 = args.getString(VM_OBSERVABILITY_ID);
        this.observabilityId = string2;
        boolean z = args.getBoolean(VM_IS_NEWLY_CREATED_FILE, false);
        this.isNewlyCreatedFile = z;
        this.store = storeFactory.create(PreviewReducerHelpersKt.createState(PreviewReducer.State.INSTANCE, fileModel, previewSource, z), new PreviewReducer(previewEnvironment, new PreviewConfig(string, string2, z)), ViewModelKt.getViewModelScope(this));
    }

    public final PreviewEnvironment getPreviewEnvironment() {
        return this.previewEnvironment;
    }

    public final PreviewPrefetcher getPreviewPrefetcher() {
        return this.previewPrefetcher;
    }

    public final IStoreFactory getStoreFactory() {
        return this.storeFactory;
    }

    public final Store<PreviewReducer.State, PreviewReducer.Action> getStore() {
        return this.store;
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        super.onCleared();
        this.previewPrefetcher.cancel(this.fileModel);
    }
}
