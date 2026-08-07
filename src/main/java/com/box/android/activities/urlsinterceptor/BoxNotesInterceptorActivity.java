package com.box.android.activities.urlsinterceptor;

import android.content.Intent;
import android.net.Uri;
import com.box.android.R;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.coreservices.modelcontroller.messages.BoxUserAuthenticationMessage;
import com.box.android.utilities.notificationmanager.BoxNotificationHelper;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: loaded from: classes9.dex */
public class BoxNotesInterceptorActivity extends Hilt_BoxNotesInterceptorActivity {
    private static final String SHARED_LINK_QUERY = "s";
    private boolean mIsSharedLink = false;

    @Override // com.box.android.activities.urlsinterceptor.SharedLinkInterceptorActivity
    protected String getTargetFromIntent(Intent intent) {
        if (intent == null || intent.getData() == null) {
            return null;
        }
        Uri data = intent.getData();
        String queryParameter = data.getQueryParameter("s");
        if (!StringUtils.isEmpty(queryParameter)) {
            this.mIsSharedLink = true;
            return new Uri.Builder().scheme(data.getScheme()).authority(data.getAuthority()).path("s").appendPath(queryParameter).build().toString();
        }
        if (intent.getData().getPathSegments().size() == 2) {
            return intent.getData().getLastPathSegment();
        }
        return null;
    }

    @Override // com.box.android.activities.urlsinterceptor.SharedLinkInterceptorActivity, com.box.android.base.presentation.activities.BoxEntrypointActivity
    protected void onAuthenticated(BoxUserAuthenticationMessage boxUserAuthenticationMessage) {
        if (StringUtils.isEmpty(this.mTarget)) {
            return;
        }
        if (boxUserAuthenticationMessage.wasSuccessful()) {
            if (this.mIsSharedLink) {
                getSharedItem(this.mTarget, null, false);
                return;
            } else {
                getFileInfo(this.mTarget);
                return;
            }
        }
        BoxNotificationHelper.displayDialog(CommonBoxUtil.LS(R.string.LS_Error), CommonBoxUtil.LS(R.string.LS_Please_register));
        quitActivity();
    }
}
