package com.box.android.fileactivity.presentation;

import androidx.fragment.app.FragmentActivity;
import com.box.android.base.presentation.components.commentbar.TimestampedCommentConfig;
import com.box.android.domain.models.item.FileModel;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileActivitiesLauncher.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¨\u0006\u000e"}, d2 = {"Lcom/box/android/fileactivity/presentation/FileActivitiesLauncher;", "", "<init>", "()V", "openFileActivities", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "fileModel", "Lcom/box/android/domain/models/item/FileModel;", "scrollToActivityId", "", "timestampedCommentConfig", "Lcom/box/android/base/presentation/components/commentbar/TimestampedCommentConfig;", "file-activity_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FileActivitiesLauncher {
    public static final int $stable = 0;

    @Inject
    public FileActivitiesLauncher() {
    }

    public static /* synthetic */ void openFileActivities$default(FileActivitiesLauncher fileActivitiesLauncher, FragmentActivity fragmentActivity, FileModel fileModel, String str, TimestampedCommentConfig timestampedCommentConfig, int i, Object obj) {
        if ((i & 8) != 0) {
            timestampedCommentConfig = null;
        }
        fileActivitiesLauncher.openFileActivities(fragmentActivity, fileModel, str, timestampedCommentConfig);
    }

    public final void openFileActivities(FragmentActivity activity, FileModel fileModel, String scrollToActivityId, TimestampedCommentConfig timestampedCommentConfig) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(fileModel, "fileModel");
        activity.startActivity(FileActivitiesActivity.INSTANCE.getIntent(activity, fileModel, scrollToActivityId, timestampedCommentConfig));
    }
}
