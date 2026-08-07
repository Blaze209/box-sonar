package com.box.android.inbox.notifications.router;

import com.box.android.common.utilities.BoxCommonConstants;
import kotlin.Metadata;

/* JADX INFO: compiled from: IInboxRouter.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J \u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H&J \u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H&J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H&J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011H&J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0005H&¨\u0006\u0014À\u0006\u0003"}, d2 = {"Lcom/box/android/inbox/notifications/router/IInboxRouter;", "", "navigateToFile", "", "fileId", "", BoxCommonConstants.EXTRA_FILE_NAME, "navigateToFileWithComment", "commentId", "navigateToFileWithAnnotation", "annotationId", "navigateToFolder", "folderId", BoxCommonConstants.EXTRA_FOLDER_NAME, "navigateToTask", "taskId", "isMyTask", "", "navigateToUrl", "url", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IInboxRouter {
    void navigateToFile(String fileId, String fileName);

    void navigateToFileWithAnnotation(String fileId, String fileName, String annotationId);

    void navigateToFileWithComment(String fileId, String fileName, String commentId);

    void navigateToFolder(String folderId, String folderName);

    void navigateToTask(String taskId, boolean isMyTask);

    void navigateToUrl(String url);
}
