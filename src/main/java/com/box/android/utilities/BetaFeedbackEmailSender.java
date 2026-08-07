package com.box.android.utilities;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import com.box.android.R;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.domain.services.IAppInfoService;
import com.box.androidsdk.content.auth.OAuthActivity;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.apache.hc.core5.util.Deadline;

/* JADX INFO: compiled from: BetaFeedbackEmailSender.kt */
/* JADX INFO: loaded from: classes13.dex */
@Singleton
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eJ\b\u0010\u0010\u001a\u00020\u000bH\u0002J \u0010\u0011\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/box/android/utilities/BetaFeedbackEmailSender;", "", "appInfoService", "Lcom/box/android/domain/services/IAppInfoService;", "emailChooserHelper", "Lcom/box/android/utilities/EmailChooserHelper;", "<init>", "(Lcom/box/android/domain/services/IAppInfoService;Lcom/box/android/utilities/EmailChooserHelper;)V", "send", "", OAuthActivity.USER_ID, "", "userFeedback", "attachmentUris", "", "Landroid/net/Uri;", "getAppVersionName", "buildEmailBody", "versionName", "buildEmailSubject", "Companion", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BetaFeedbackEmailSender {
    private static final String BETA_FEEDBACK_EMAIL = "android-beta-feedback@box.com";
    private final IAppInfoService appInfoService;
    private final EmailChooserHelper emailChooserHelper;
    public static final int $stable = 8;

    @Inject
    public BetaFeedbackEmailSender(IAppInfoService appInfoService, EmailChooserHelper emailChooserHelper) {
        Intrinsics.checkNotNullParameter(appInfoService, "appInfoService");
        Intrinsics.checkNotNullParameter(emailChooserHelper, "emailChooserHelper");
        this.appInfoService = appInfoService;
        this.emailChooserHelper = emailChooserHelper;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void send$default(BetaFeedbackEmailSender betaFeedbackEmailSender, String str, String str2, List list, int i, Object obj) {
        if ((i & 4) != 0) {
            list = CollectionsKt.emptyList();
        }
        betaFeedbackEmailSender.send(str, str2, list);
    }

    public final void send(String userId, String userFeedback, List<? extends Uri> attachmentUris) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(userFeedback, "userFeedback");
        Intrinsics.checkNotNullParameter(attachmentUris, "attachmentUris");
        String appVersionName = getAppVersionName();
        List<? extends Uri> list = attachmentUris;
        Intent emailIntent = BoxUtils.getEmailIntent(new String[]{BETA_FEEDBACK_EMAIL}, buildEmailSubject(appVersionName), buildEmailBody(userFeedback, appVersionName, userId), "", !list.isEmpty() ? new ArrayList(list) : null);
        Intrinsics.checkNotNullExpressionValue(emailIntent, "getEmailIntent(...)");
        EmailChooserHelper.launchEmailOnlyChooser$default(this.emailChooserHelper, emailIntent, null, 2, null);
    }

    private final String getAppVersionName() {
        String appVersionName = this.appInfoService.getAppVersionName();
        return appVersionName == null ? "unknown" : appVersionName;
    }

    private final String buildEmailBody(String userFeedback, String versionName, String userId) {
        StringBuilder sb = new StringBuilder("Feedback:\n");
        sb.append(userFeedback);
        sb.append("\n\n--- Device Info ---\nApp Version: ");
        sb.append(versionName).append("\nBuild: ");
        sb.append(CommonBoxUtil.LS(R.string.git_commit_tag)).append("\nDevice: ");
        sb.append(Build.MANUFACTURER).append(" ").append(Build.MODEL).append("\nOS: Android ");
        sb.append(Build.VERSION.RELEASE).append(" (SDK ").append(Build.VERSION.SDK_INT).append(")\nTimestamp: ");
        sb.append(new SimpleDateFormat(Deadline.DATE_FORMAT, Locale.US).format(new Date())).append("\nUser ID: ");
        sb.append(userId).append("\n");
        return sb.toString();
    }

    private final String buildEmailSubject(String versionName) {
        return "[Beta Feedback] Box Android v" + versionName;
    }
}
