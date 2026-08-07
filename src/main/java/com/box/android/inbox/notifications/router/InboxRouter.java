package com.box.android.inbox.notifications.router;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.box.android.activities.tasks.SingleTaskActivity;
import com.box.android.activities.urlsinterceptor.WebUrlsInterceptorActivity;
import com.box.android.base.routing.preview.PreviewNavigationTarget;
import com.box.android.common.utilities.BoxCommonConstants;
import com.box.android.common.utilities.IntentConstants;
import com.box.android.coreservices.services.IntentServices;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.android.domain.configuration.BoxConfigConstants;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.ItemType;
import com.box.android.domain.models.preview.PreviewSource;
import com.box.android.preview.preview.PreviewActivity;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InboxRouter.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J \u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000bH\u0016J \u0010\u000f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000bH\u0016J\u0018\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000bH\u0016J\u0018\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u000bH\u0016J\u001a\u0010\u001a\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/box/android/inbox/notifications/router/InboxRouter;", "Lcom/box/android/inbox/notifications/router/IInboxRouter;", "context", "Landroid/content/Context;", "intentServices", "Lcom/box/android/coreservices/services/IntentServices;", "<init>", "(Landroid/content/Context;Lcom/box/android/coreservices/services/IntentServices;)V", "navigateToFile", "", "fileId", "", BoxCommonConstants.EXTRA_FILE_NAME, "navigateToFileWithComment", "commentId", "navigateToFileWithAnnotation", "annotationId", "navigateToFolder", "folderId", BoxCommonConstants.EXTRA_FOLDER_NAME, "navigateToTask", "taskId", "isMyTask", "", "navigateToUrl", "url", "launchFilePreview", "navigationTarget", "Lcom/box/android/base/routing/preview/PreviewNavigationTarget;", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class InboxRouter implements IInboxRouter {
    public static final int $stable = 8;
    private final Context context;
    private final IntentServices intentServices;

    @Inject
    public InboxRouter(Context context, IntentServices intentServices) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intentServices, "intentServices");
        this.context = context;
        this.intentServices = intentServices;
    }

    @Override // com.box.android.inbox.notifications.router.IInboxRouter
    public void navigateToFile(String fileId, String fileName) {
        Intrinsics.checkNotNullParameter(fileId, "fileId");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        launchFilePreview(fileId, null);
    }

    @Override // com.box.android.inbox.notifications.router.IInboxRouter
    public void navigateToFileWithComment(String fileId, String fileName, String commentId) {
        Intrinsics.checkNotNullParameter(fileId, "fileId");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Intrinsics.checkNotNullParameter(commentId, "commentId");
        launchFilePreview(fileId, new PreviewNavigationTarget.Comments(commentId));
    }

    @Override // com.box.android.inbox.notifications.router.IInboxRouter
    public void navigateToFileWithAnnotation(String fileId, String fileName, String annotationId) {
        Intrinsics.checkNotNullParameter(fileId, "fileId");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Intrinsics.checkNotNullParameter(annotationId, "annotationId");
        launchFilePreview(fileId, new PreviewNavigationTarget.FileActivityItemAnnotation(annotationId));
    }

    @Override // com.box.android.inbox.notifications.router.IInboxRouter
    public void navigateToFolder(String folderId, String folderName) {
        Intrinsics.checkNotNullParameter(folderId, "folderId");
        Intrinsics.checkNotNullParameter(folderName, "folderName");
        this.context.startActivity(this.intentServices.mainPhoneActivityIntent(this.context, new ItemId.Remote(folderId, ItemType.FOLDER), folderName, 335544320));
    }

    @Override // com.box.android.inbox.notifications.router.IInboxRouter
    public void navigateToTask(String taskId, boolean isMyTask) {
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        Intent intentCreateIntent = SingleTaskActivity.createIntent(this.context, taskId, BoxAnalyticsParams.SOURCE_EMAIL_NOTIFICATION, isMyTask);
        intentCreateIntent.setFlags(335544320);
        this.context.startActivity(intentCreateIntent);
    }

    @Override // com.box.android.inbox.notifications.router.IInboxRouter
    public void navigateToUrl(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setClass(this.context, WebUrlsInterceptorActivity.class);
        intent.setData(Uri.parse(BoxConfigConstants.BOX_DOMAIN_URL + url));
        intent.putExtra(IntentConstants.EXTRA_ENTRYPOINT, PreviewSource.Notification.INSTANCE);
        intent.setFlags(335544320);
        this.context.startActivity(intent);
    }

    private final void launchFilePreview(String fileId, PreviewNavigationTarget navigationTarget) {
        Intent intentFileRouterActivityIntent = this.intentServices.fileRouterActivityIntent(this.context, PreviewSource.Notification.INSTANCE);
        intentFileRouterActivityIntent.putExtra(IntentConstants.EXTRA_INIT_FILE_ID, fileId);
        intentFileRouterActivityIntent.putExtra(IntentConstants.EXTRA_INIT_LAUNCH_NEW, true);
        intentFileRouterActivityIntent.setFlags(335544320);
        if (navigationTarget != null) {
            intentFileRouterActivityIntent.putExtra(PreviewActivity.NAVIGATION_TARGET, navigationTarget);
        }
        this.context.startActivity(intentFileRouterActivityIntent);
    }
}
