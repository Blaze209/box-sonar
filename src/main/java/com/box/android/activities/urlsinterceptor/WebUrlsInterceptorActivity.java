package com.box.android.activities.urlsinterceptor;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.lifecycle.ViewModelProvider;
import com.box.android.R;
import com.box.android.activities.tasks.SingleTaskActivity;
import com.box.android.application.BoxBaseApplication;
import com.box.android.base.routing.preview.PreviewNavigationTarget;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.common.utilities.IntentConstants;
import com.box.android.coreservices.modelcontroller.messages.BoxUserAuthenticationMessage;
import com.box.android.coreservices.services.IntentServices;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.android.domain.localrepo.sqlitetables.BoxRecentItemSQLData;
import com.box.android.domain.models.preview.PreviewSource;
import com.box.android.navigationmodernization.MainActivity;
import com.box.android.observability.ObservabilitySettingsManager;
import com.box.android.preview.preview.PreviewActivity;
import com.box.android.utilities.BoxUtils;
import com.box.android.utilities.notificationmanager.BoxNotificationHelper;
import com.box.androidsdk.content.models.BoxCollection;
import com.box.androidsdk.content.models.BoxItem;
import com.box.boxandroidlibv2private.model.BoxTaskCollaborator;
import java.util.List;
import javax.inject.Inject;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes9.dex */
public class WebUrlsInterceptorActivity extends Hilt_WebUrlsInterceptorActivity {
    public static final String ACTIVITY_ID_QUERY = "activity_id";
    private static final String ACTIVITY_TYPE_ANNOTATION = "annotation";
    private static final String ACTIVITY_TYPE_COMMENT = "comment";
    private static final String ACTIVITY_TYPE_QUERY = "activity_type";
    private static final String COLLABORATORS = "collaborators";
    private static final String EXTRA_IS_SUPPORTED_PATH = "isSupported";
    private static final String SHARED_LINK_QUERY = "s";
    private static final String TRACKING_CODE_UNKNOWN = "https://box.com/sharedlink?utm_source=trans&utm_medium=unknown&utm_campaign=weburl";

    @Inject
    protected IntentServices mIntentServices;
    private boolean mIsNavigationHandled = false;
    boolean mIsSupported;

    @Inject
    protected ObservabilitySettingsManager mObservabilityManager;

    @Override // com.box.android.base.presentation.activities.Hilt_BoxFragmentActivity, androidx.activity.ComponentActivity, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public /* bridge */ /* synthetic */ ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        return super.getDefaultViewModelProviderFactory();
    }

    public enum HANDLED_PATH {
        FILE("file"),
        FOLDER("folder"),
        RECENTS(BoxAnalyticsParams.ACTION_RECENTS),
        FAVORITE_WITH_FILES("files"),
        FAVORITE("favorites"),
        OFFLINE(BoxRecentItemSQLData.OFFLINE_COLUMN_NAME),
        COLLECTION(BoxCollection.TYPE),
        COLLECTIONS(BoxItem.FIELD_COLLECTIONS),
        NOTIFICATIONS("notifications"),
        MY_TASKS("tasks/assigned"),
        SENT_TASKS("tasks/sent"),
        DIAGNOSIS("diagnosis"),
        HUBS("hubs");

        private String mSegment;

        HANDLED_PATH(String str) {
            this.mSegment = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.mSegment;
        }
    }

    boolean isIntentSupported(Intent intent) {
        HANDLED_PATH type;
        List<String> pathSegments = intent.getData().getPathSegments();
        if (pathSegments.size() > 0 && (type = getType(intent)) != null) {
            int i = AnonymousClass1.$SwitchMap$com$box$android$activities$urlsinterceptor$WebUrlsInterceptorActivity$HANDLED_PATH[type.ordinal()];
            if (i != 1 && i != 2 && i != 3) {
                if (i != 4) {
                    return true;
                }
                return pathSegments.size() > 1 && TextUtils.equals(HANDLED_PATH.FAVORITE.toString(), pathSegments.get(1).toLowerCase());
            }
            if (pathSegments.size() > 1) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: com.box.android.activities.urlsinterceptor.WebUrlsInterceptorActivity$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$box$android$activities$urlsinterceptor$WebUrlsInterceptorActivity$HANDLED_PATH;

        static {
            int[] iArr = new int[HANDLED_PATH.values().length];
            $SwitchMap$com$box$android$activities$urlsinterceptor$WebUrlsInterceptorActivity$HANDLED_PATH = iArr;
            try {
                iArr[HANDLED_PATH.FILE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$box$android$activities$urlsinterceptor$WebUrlsInterceptorActivity$HANDLED_PATH[HANDLED_PATH.FOLDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$box$android$activities$urlsinterceptor$WebUrlsInterceptorActivity$HANDLED_PATH[HANDLED_PATH.COLLECTION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$box$android$activities$urlsinterceptor$WebUrlsInterceptorActivity$HANDLED_PATH[HANDLED_PATH.FAVORITE_WITH_FILES.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$box$android$activities$urlsinterceptor$WebUrlsInterceptorActivity$HANDLED_PATH[HANDLED_PATH.OFFLINE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$box$android$activities$urlsinterceptor$WebUrlsInterceptorActivity$HANDLED_PATH[HANDLED_PATH.RECENTS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$box$android$activities$urlsinterceptor$WebUrlsInterceptorActivity$HANDLED_PATH[HANDLED_PATH.FAVORITE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$box$android$activities$urlsinterceptor$WebUrlsInterceptorActivity$HANDLED_PATH[HANDLED_PATH.NOTIFICATIONS.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$box$android$activities$urlsinterceptor$WebUrlsInterceptorActivity$HANDLED_PATH[HANDLED_PATH.COLLECTIONS.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$box$android$activities$urlsinterceptor$WebUrlsInterceptorActivity$HANDLED_PATH[HANDLED_PATH.MY_TASKS.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$box$android$activities$urlsinterceptor$WebUrlsInterceptorActivity$HANDLED_PATH[HANDLED_PATH.SENT_TASKS.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$box$android$activities$urlsinterceptor$WebUrlsInterceptorActivity$HANDLED_PATH[HANDLED_PATH.HUBS.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    HANDLED_PATH getType(Intent intent) {
        if (intent == null) {
            return null;
        }
        List<String> pathSegments = intent.getData().getPathSegments();
        if (pathSegments.size() > 0) {
            for (int size = pathSegments.size() - 1; size >= 0; size--) {
                HANDLED_PATH handledPath = getHandledPath(generatePathSegmentSlice(0, size, pathSegments));
                if (handledPath != null) {
                    return handledPath;
                }
            }
        }
        return null;
    }

    private String generatePathSegmentSlice(int i, int i2, List<String> list) {
        StringBuilder sb = new StringBuilder();
        if (i2 < i) {
            return null;
        }
        while (i <= i2) {
            sb.append(list.get(i));
            if (i < i2) {
                sb.append('/');
            }
            i++;
        }
        return sb.toString();
    }

    private HANDLED_PATH getHandledPath(String str) {
        for (HANDLED_PATH handled_path : HANDLED_PATH.values()) {
            if (handled_path.toString().equals(str)) {
                return handled_path;
            }
        }
        return null;
    }

    @Override // com.box.android.base.presentation.activities.BoxEntrypointActivity, com.box.android.base.presentation.activities.BoxFragmentActivity
    public void onBoxCreate(Bundle bundle) {
        super.onBoxCreate(bundle);
        if (bundle != null) {
            this.mIsSupported = bundle.getBoolean(EXTRA_IS_SUPPORTED_PATH);
        }
        processIntent();
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity, com.box.android.base.presentation.activities.BoxSpinnerDialogFragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMSaveInstanceState(Bundle bundle) {
        bundle.putBoolean(EXTRA_IS_SUPPORTED_PATH, this.mIsSupported);
        super.onMAMSaveInstanceState(bundle);
    }

    void processIntent() {
        Intent intent = getIntent();
        boolean zIsIntentSupported = isIntentSupported(intent);
        this.mIsSupported = zIsIntentSupported;
        String str = BoxAnalyticsParams.REFERRER_EXTERNAL;
        if (zIsIntentSupported) {
            Uri data = intent.getData();
            JSONArray referrerTrackingArray = BoxAmplitudeAnalytics.getReferrerTrackingArray(data);
            if (BoxUtils.isUriSourceEmail(data)) {
                str = "email";
            }
            if (referrerTrackingArray == null || referrerTrackingArray.length() < 1) {
                data = Uri.parse(TRACKING_CODE_UNKNOWN);
            }
            BoxAmplitudeAnalytics.getInstance().setReferrer(str, data);
            BoxAmplitudeAnalytics.createPushNotifEventPropertyBuilder().logNotificationDeeplinkLaunched(data);
        } else {
            Toast.makeText(BoxBaseApplication.getInstance(), CommonBoxUtil.LS(R.string.There_was_a_problem_accessing_this_link), 1).show();
            finish();
            BoxAmplitudeAnalytics.getInstance().setReferrer(BoxAnalyticsParams.REFERRER_EXTERNAL);
        }
        if (isAuthRequiredForIntentHandling()) {
            authenticateFromExternalLink();
        } else {
            handleUnauthenticatedIntent();
        }
    }

    /* JADX WARN: Code duplicated, block: B:51:0x018f  */
    Intent getIntentToLaunch(Intent intent) {
        Intent intentNavigationIntent;
        Intent intent2;
        HANDLED_PATH type = getType(intent);
        if (type != null && this.mIsSupported) {
            switch (AnonymousClass1.$SwitchMap$com$box$android$activities$urlsinterceptor$WebUrlsInterceptorActivity$HANDLED_PATH[type.ordinal()]) {
                case 1:
                    List<String> pathSegments = intent.getData().getPathSegments();
                    String str = pathSegments.get(1);
                    new Intent().putExtra(IntentConstants.EXTRA_INIT_LAUNCH_NEW, true);
                    String queryParameter = intent.getData().getQueryParameter("task_id");
                    String queryParameter2 = intent.getData().getQueryParameter("role");
                    String queryParameter3 = intent.getData().getQueryParameter("s");
                    String queryParameter4 = intent.getData().getQueryParameter(ACTIVITY_ID_QUERY);
                    String queryParameter5 = intent.getData().getQueryParameter(ACTIVITY_TYPE_QUERY);
                    if (StringUtils.isNotEmpty(queryParameter) && StringUtils.isNotEmpty(queryParameter2)) {
                        intentNavigationIntent = SingleTaskActivity.createIntent(this, queryParameter, BoxAnalyticsParams.SOURCE_EMAIL_NOTIFICATION, queryParameter2.equalsIgnoreCase(BoxTaskCollaborator.ROLE_ASSIGNEE));
                    } else if (StringUtils.isEmpty(queryParameter3)) {
                        boolean z = pathSegments.size() == 3 && StringUtils.equalsIgnoreCase(COLLABORATORS, pathSegments.get(2));
                        PreviewSource previewSource = (PreviewSource) intent.getParcelableExtra(IntentConstants.EXTRA_ENTRYPOINT);
                        if (previewSource == null) {
                            previewSource = PreviewSource.WebUrl.INSTANCE;
                        }
                        intentNavigationIntent = this.mIntentServices.fileRouterActivityIntent(this, previewSource);
                        intentNavigationIntent.putExtra(IntentConstants.EXTRA_INIT_FILE_ID, str);
                        if (z) {
                            intentNavigationIntent.putExtra(PreviewActivity.NAVIGATION_TARGET, PreviewNavigationTarget.Collaborators.INSTANCE);
                        } else if (StringUtils.isNotEmpty(queryParameter5)) {
                            if (queryParameter5.equals("comment")) {
                                intentNavigationIntent.putExtra(PreviewActivity.NAVIGATION_TARGET, new PreviewNavigationTarget.Comments(queryParameter4));
                            }
                            if (queryParameter5.equals(ACTIVITY_TYPE_ANNOTATION)) {
                                intentNavigationIntent.putExtra(PreviewActivity.NAVIGATION_TARGET, new PreviewNavigationTarget.FileActivityItemAnnotation(queryParameter4));
                            }
                        }
                    } else {
                        intent2 = new Intent("android.intent.action.VIEW", intent.getData(), this, SharedLinkInterceptorActivity.class);
                        intentNavigationIntent = intent2;
                    }
                    break;
                case 2:
                    String str2 = intent.getData().getPathSegments().get(1);
                    if (!StringUtils.isEmpty(intent.getData().getQueryParameter("s"))) {
                        intent2 = new Intent("android.intent.action.VIEW", intent.getData(), this, SharedLinkInterceptorActivity.class);
                        intentNavigationIntent = intent2;
                    } else {
                        intentNavigationIntent = this.mIntentServices.mainPhoneActivityIntent(this);
                        intentNavigationIntent.putExtra(IntentConstants.EXTRA_INIT_FOLDER_ID, str2);
                    }
                    break;
                case 3:
                    intentNavigationIntent = this.mIntentServices.openCollectionIntent(this, intent.getData().getPathSegments().get(1), this.mFeatureFlips.getMainScreenRedesign().getEnabled());
                    break;
                case 4:
                case 7:
                    intentNavigationIntent = navigationIntent(IntentServices.NavigationIntentTarget.FAVORITES);
                    break;
                case 5:
                    intentNavigationIntent = navigationIntent(IntentServices.NavigationIntentTarget.OFFLINE);
                    break;
                case 6:
                    intentNavigationIntent = navigationIntent(IntentServices.NavigationIntentTarget.RECENT);
                    break;
                case 8:
                    intentNavigationIntent = navigationIntent(IntentServices.NavigationIntentTarget.NOTIFICATIONS);
                    break;
                case 9:
                    intentNavigationIntent = navigationIntent(IntentServices.NavigationIntentTarget.COLLECTIONS);
                    break;
                case 10:
                    intentNavigationIntent = navigationIntent(IntentServices.NavigationIntentTarget.MY_TASKS);
                    break;
                case 11:
                    intentNavigationIntent = navigationIntent(IntentServices.NavigationIntentTarget.SENT_TASKS);
                    break;
                case 12:
                    intentNavigationIntent = this.mIntentServices.hubDetailsRouterActivityIntent(this, intent.getData());
                    break;
                default:
                    intentNavigationIntent = null;
                    break;
            }
        } else {
            intentNavigationIntent = null;
        }
        if (intentNavigationIntent == null) {
            intentNavigationIntent = navigationIntent(IntentServices.NavigationIntentTarget.ALL_FILES);
        }
        if (!targetsMainActivity(intentNavigationIntent)) {
            intentNavigationIntent.setFlags(524288);
        }
        return intentNavigationIntent;
    }

    private boolean targetsMainActivity(Intent intent) {
        return intent.getComponent() != null && MainActivity.class.getName().equals(intent.getComponent().getClassName());
    }

    private Intent navigationIntent(IntentServices.NavigationIntentTarget navigationIntentTarget) {
        return this.mIntentServices.navigationActivityIntent(this, this.mFeatureFlips.getMainScreenRedesign().getEnabled(), navigationIntentTarget);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void authenticateFromExternalLink() {
        this.mBoxSession.setTriggeredByExternalLink();
        authenticate();
    }

    @Override // com.box.android.base.presentation.activities.BoxEntrypointActivity
    protected boolean authenticateOnResume() {
        return isAuthRequiredForIntentHandling();
    }

    @Override // com.box.android.base.presentation.activities.BoxEntrypointActivity
    protected void onAuthenticated(BoxUserAuthenticationMessage boxUserAuthenticationMessage) {
        if (this.mIsNavigationHandled) {
            return;
        }
        this.mIsNavigationHandled = true;
        if (boxUserAuthenticationMessage.wasSuccessful()) {
            broadcastDismissSpinner();
            startActivity(getIntentToLaunch(getIntent()));
        } else {
            BoxNotificationHelper.displayDialog(CommonBoxUtil.LS(R.string.LS_Error), CommonBoxUtil.LS(R.string.LS_Please_register));
        }
        finish();
    }

    boolean isAuthRequiredForIntentHandling() {
        return getType(getIntent()) != HANDLED_PATH.DIAGNOSIS;
    }

    private void handleUnauthenticatedIntent() {
        if (getType(getIntent()) == HANDLED_PATH.DIAGNOSIS) {
            this.mObservabilityManager.handleDiagnosisIntent(this, getIntent().getData(), new ObservabilitySettingsManager.ObservabilityModeListener() { // from class: com.box.android.activities.urlsinterceptor.WebUrlsInterceptorActivity$$ExternalSyntheticLambda0
                @Override // com.box.android.observability.ObservabilitySettingsManager.ObservabilityModeListener
                public final void onHandled() {
                    this.f$0.authenticateFromExternalLink();
                }
            });
        }
    }
}
