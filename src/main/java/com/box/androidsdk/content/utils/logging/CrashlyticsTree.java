package com.box.androidsdk.content.utils.logging;

import com.box.androidsdk.content.BoxException;
import com.box.androidsdk.content.auth.OAuthActivity;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.logging.LogFactory;
import timber.log.Timber;

/* JADX INFO: compiled from: CrashlyticsTree.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0006\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0014J\u000e\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\tJ\u000e\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\t¨\u0006\u0012"}, d2 = {"Lcom/box/androidsdk/content/utils/logging/CrashlyticsTree;", "Ltimber/log/Timber$Tree;", "<init>", "()V", "log", "", LogFactory.PRIORITY_KEY, "", "tag", "", "message", "t", "", "setUserId", OAuthActivity.USER_ID, "setEnterpriseId", CrashlyticsTree.ENTERPRISE_ID_KEY, "Companion", "content_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CrashlyticsTree extends Timber.Tree {
    private static final String ENTERPRISE_ID_KEY = "enterpriseId";

    @Override // timber.log.Timber.Tree
    protected void log(int priority, String tag, String message, Throwable t) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (priority < 5) {
            return;
        }
        FirebaseCrashlytics.getInstance().log(tag + ": " + message);
        if (t instanceof BoxException) {
            BoxException boxException = (BoxException) t;
            String str = "Response Code: " + boxException.getResponseCode();
            if (t instanceof BoxException.RefreshFailure) {
                str = str + " Response: " + boxException.getResponse();
            }
            FirebaseCrashlytics.getInstance().log("Exception Info: " + str);
        }
        if (t != null) {
            FirebaseCrashlytics.getInstance().recordException(t);
        }
    }

    public final void setUserId(String userId) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        FirebaseCrashlytics.getInstance().setUserId(userId);
    }

    public final void setEnterpriseId(String enterpriseId) {
        Intrinsics.checkNotNullParameter(enterpriseId, "enterpriseId");
        FirebaseCrashlytics.getInstance().setCustomKey(ENTERPRISE_ID_KEY, enterpriseId);
    }
}
