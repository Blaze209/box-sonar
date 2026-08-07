package com.box.android.domain.models.preview;

import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.android.domain.localrepo.sqlitetables.BoxRecentItemSQLData;
import com.box.androidsdk.content.models.BoxCollection;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PreviewSource.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"toMetricsName", "", "Lcom/box/android/domain/models/preview/PreviewSource;", "domain_prodRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class PreviewSourceKt {
    public static final String toMetricsName(PreviewSource previewSource) {
        Intrinsics.checkNotNullParameter(previewSource, "<this>");
        if (previewSource instanceof PreviewSource.Browse) {
            return "browse";
        }
        if (previewSource instanceof PreviewSource.Recents) {
            return BoxAnalyticsParams.ACTION_RECENTS;
        }
        if (previewSource instanceof PreviewSource.Notes) {
            return "notes";
        }
        if (previewSource instanceof PreviewSource.Offline) {
            return BoxRecentItemSQLData.OFFLINE_COLUMN_NAME;
        }
        if (previewSource instanceof PreviewSource.Search) {
            return "search";
        }
        if (previewSource instanceof PreviewSource.Favorites) {
            return "favourites";
        }
        if (previewSource instanceof PreviewSource.Collection) {
            return BoxCollection.TYPE;
        }
        if (previewSource instanceof PreviewSource.MyTasks) {
            return "my_tasks";
        }
        if (previewSource instanceof PreviewSource.SentTasks) {
            return "sent_tasks";
        }
        if (previewSource instanceof PreviewSource.Notification) {
            return "notification";
        }
        if (previewSource instanceof PreviewSource.AudioNotification) {
            return "audio_notification";
        }
        if (previewSource instanceof PreviewSource.Transfers) {
            return "transfers";
        }
        if (previewSource instanceof PreviewSource.CaptureHistory) {
            return "capture_history";
        }
        if (previewSource instanceof PreviewSource.SharedLink) {
            return "shared_link";
        }
        if (previewSource instanceof PreviewSource.WebUrl) {
            return "web_url";
        }
        if (previewSource instanceof PreviewSource.DirectLink) {
            return "direct_link";
        }
        if (previewSource instanceof PreviewSource.ItemShortcut) {
            return "item_shortcut";
        }
        if (previewSource instanceof PreviewSource.PreviewRetry) {
            return "preview_retry";
        }
        if (previewSource instanceof PreviewSource.FileActivities) {
            return "file_activities";
        }
        if (previewSource instanceof PreviewSource.AICenter) {
            return "ai_center";
        }
        if (previewSource instanceof PreviewSource.Unknown) {
            return "unknown";
        }
        throw new NoWhenBranchMatchedException();
    }
}
