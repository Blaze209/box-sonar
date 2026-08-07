package com.box.android.fileactivity.presentation;

import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.core.os.BundleCompat;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.box.android.base.presentation.components.commentbar.CommentWithMentionsReducer;
import com.box.android.base.presentation.components.commentbar.TimestampedCommentConfig;
import com.box.android.common.utilities.ViewModelAssistedFactory;
import com.box.android.cpl.IStoreFactory;
import com.box.android.cpl.Store;
import com.box.android.domain.models.item.FileModel;
import dagger.assisted.Assisted;
import dagger.assisted.AssistedFactory;
import dagger.assisted.AssistedInject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileActivitiesViewModel.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0002\u0019\u001aB#\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\t\u0018\u00010\u000f¢\u0006\u0002\b\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lcom/box/android/fileactivity/presentation/FileActivitiesViewModel;", "Landroidx/lifecycle/ViewModel;", "args", "Landroid/os/Bundle;", "fileActivitiesEnvironment", "Lcom/box/android/fileactivity/presentation/FileActivitiesEnvironment;", "storeFactory", "Lcom/box/android/cpl/IStoreFactory;", "<init>", "(Landroid/os/Bundle;Lcom/box/android/fileactivity/presentation/FileActivitiesEnvironment;Lcom/box/android/cpl/IStoreFactory;)V", "fileModel", "Lcom/box/android/domain/models/item/FileModel;", "getFileModel", "()Lcom/box/android/domain/models/item/FileModel;", "timestampedCommentConfig", "Lcom/box/android/base/presentation/components/commentbar/TimestampedCommentConfig;", "Lorg/jspecify/annotations/Nullable;", "getTimestampedCommentConfig", "()Lcom/box/android/base/presentation/components/commentbar/TimestampedCommentConfig;", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/fileactivity/presentation/FileActivitiesReducer$State;", "Lcom/box/android/fileactivity/presentation/FileActivitiesReducer$Action;", "getStore", "()Lcom/box/android/cpl/Store;", "Factory", "Companion", "file-activity_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FileActivitiesViewModel extends ViewModel {
    public static final String CAN_COMMENT_PERMISSION_KEY = "CanCommentPermission";
    public static final String FILE_MODEL_KEY = "FILE_MODEL_KEY";
    public static final String SELECTED_ACTIVITY_ID_KEY = "Selected_ActivityId";
    public static final String TIMESTAMPED_COMMENT_CONFIG_KEY = "TimestampedCommentConfig";
    private final FileModel fileModel;
    private final Store<FileActivitiesReducer.State, FileActivitiesReducer.Action> store;
    private final TimestampedCommentConfig timestampedCommentConfig;
    public static final int $stable = 8;

    /* JADX INFO: compiled from: FileActivitiesViewModel.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003À\u0006\u0003"}, d2 = {"Lcom/box/android/fileactivity/presentation/FileActivitiesViewModel$Factory;", "Lcom/box/android/common/utilities/ViewModelAssistedFactory;", "Lcom/box/android/fileactivity/presentation/FileActivitiesViewModel;", "file-activity_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @AssistedFactory
    public interface Factory extends ViewModelAssistedFactory<FileActivitiesViewModel> {
    }

    @AssistedInject
    public FileActivitiesViewModel(@Assisted Bundle args, FileActivitiesEnvironment fileActivitiesEnvironment, IStoreFactory storeFactory) {
        Parcelable parcelable;
        Parcelable parcelable2;
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(fileActivitiesEnvironment, "fileActivitiesEnvironment");
        Intrinsics.checkNotNullParameter(storeFactory, "storeFactory");
        if (Build.VERSION.SDK_INT >= 33) {
            parcelable2 = (Parcelable) args.getParcelable("FILE_MODEL_KEY", FileModel.class);
        } else {
            Parcelable parcelable3 = args.getParcelable("FILE_MODEL_KEY");
            parcelable = (FileModel) (parcelable3 instanceof FileModel ? parcelable3 : null);
        }
        if (parcelable == null) {
            parcelable = parcelable2;
            throw new IllegalArgumentException("Parcelable with key FILE_MODEL_KEY not found in Bundle".toString());
        }
        parcelable = parcelable2;
        FileModel fileModel = (FileModel) parcelable;
        this.fileModel = fileModel;
        TimestampedCommentConfig timestampedCommentConfig = (TimestampedCommentConfig) BundleCompat.getParcelable(args, "TimestampedCommentConfig", TimestampedCommentConfig.class);
        this.timestampedCommentConfig = timestampedCommentConfig;
        boolean z = false ? 1 : 0;
        this.store = storeFactory.create(new FileActivitiesReducer.State(fileModel, null, null, args.getString("Selected_ActivityId"), z, false, null, null, false, new CommentWithMentionsReducer.State(fileModel.getItemId(), null, null, null, timestampedCommentConfig, 14, null), args.getString("Selected_ActivityId"), null, 2550, null), new FileActivitiesReducer(fileActivitiesEnvironment), ViewModelKt.getViewModelScope(this));
    }

    public final FileModel getFileModel() {
        return this.fileModel;
    }

    public final TimestampedCommentConfig getTimestampedCommentConfig() {
        return this.timestampedCommentConfig;
    }

    public final Store<FileActivitiesReducer.State, FileActivitiesReducer.Action> getStore() {
        return this.store;
    }
}
