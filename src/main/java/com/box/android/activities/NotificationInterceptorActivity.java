package com.box.android.activities;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import androidx.lifecycle.ViewModelProvider;
import com.box.android.R;
import com.box.android.activities.urlsinterceptor.WebUrlsInterceptorActivity;
import com.box.android.application.BoxBaseApplication;
import com.box.android.base.BoxNotificationManager;
import com.box.android.base.cpl.IPreviewLauncher;
import com.box.android.base.presentation.BoxPresentationUtils;
import com.box.android.base.routing.preview.PreviewNavigationTarget;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.common.utilities.IntentConstants;
import com.box.android.controller.ExecutorPool;
import com.box.android.coreservices.modelcontroller.messages.BoxMessage;
import com.box.android.coreservices.modelcontroller.messages.BoxResponseMessage;
import com.box.android.coreservices.modelcontroller.messages.BoxUserAuthenticationMessage;
import com.box.android.coreservices.models.BoxPushNotificationV1;
import com.box.android.coreservices.services.IntentServices;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.analytics.BoxAnalytics;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.android.domain.identity.IUserContext;
import com.box.android.domain.mappers.FileModelMapper;
import com.box.android.domain.models.preview.PreviewSource;
import com.box.android.utilities.notificationmanager.BoxNotificationHelper;
import com.box.androidsdk.content.BoxException;
import com.box.androidsdk.content.models.BoxFile;
import com.box.androidsdk.content.requests.BoxRequest;
import com.box.androidsdk.content.requests.BoxRequestsFile;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.box.boxandroidlibv2private.model.BoxIteratorBoxPushNotification;
import com.box.boxandroidlibv2private.model.BoxPushNotification;
import com.box.boxandroidlibv2private.requests.BoxRequestGetPushNotifications;
import com.box.boxandroidlibv2private.resourcemanagers.BoxApiPrivate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: loaded from: classes9.dex */
public class NotificationInterceptorActivity extends Hilt_NotificationInterceptorActivity {
    public static final String EXTRA_COMMENT_ID = "extraCommentId";
    public static final String EXTRA_DISMISS = "extra_param_dismiss";
    public static final String EXTRA_FROM_ACTIVITY = "extra_param_from_activity";
    public static final String EXTRA_IDS_LIST = "extra_param_ids_list";
    public static final String EXTRA_MUTE = "extra_param_mute";
    public static final String EXTRA_NOTIFICATION_ID = "extra_param_notification_id";
    public static final String EXTRA_PUSH_NOTIF_TYPE = "extra_param_push_notif_type";
    public static final String EXTRA_REDIRECT_URL = "extra_param_redirect_url";
    public static final String EXTRA_TARGET_ID = "extra_param_target_id";
    public static final String EXTRA_TARGET_NAME = "extra_param_target_name";
    private static final String LAUNCH_DATA_URI_ACTIVITY_TYPE_QUERY = "activity_type";
    private static final String LAUNCH_DATA_URI_ACTIVITY_TYPE_QUERY_VALUE_COMMENT = "comment";
    private static final String LAUNCH_DATA_URI_AUTHORITY = "box.com";
    private static final String LAUNCH_DATA_URI_PATH_SEGMENT_FILE = "file/";
    private static final String LAUNCH_DATA_URI_SCHEME = "https";
    private static final String LEGACY_SCHEME = "boxopendirect";

    @Inject
    BoxApiPrivate mApiPrivate;
    protected String mCommentId;

    @Inject
    protected IntentServices mIntentServices;
    private BoxPushNotification.PushNotifType mPushNotifType;
    BoxIteratorBoxPushNotification mPushNotifications;
    private String mRedirectUrl;
    private List<String> notifIds;

    @Inject
    protected IPreviewLauncher previewLauncher;
    private String targetId;
    private String targetName;
    private boolean dismissOnly = false;
    private boolean mShallMute = false;
    private int mNotificationId = Integer.MIN_VALUE;
    private boolean mFromActivity = false;

    @Override // com.box.android.base.presentation.activities.Hilt_BoxFragmentActivity, androidx.activity.ComponentActivity, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public /* bridge */ /* synthetic */ ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        return super.getDefaultViewModelProviderFactory();
    }

    public static Intent getLaunchIntent(List<String> list, String str, String str2, BoxPushNotification.PushNotifType pushNotifType, Context context, String str3, String str4) {
        Intent intent = new Intent(context, (Class<?>) NotificationInterceptorActivity.class);
        intent.putExtra(EXTRA_IDS_LIST, concatIds(list));
        intent.putExtra(EXTRA_TARGET_ID, str);
        intent.putExtra(EXTRA_TARGET_NAME, str2);
        intent.putExtra(EXTRA_DISMISS, false);
        intent.putExtra(EXTRA_PUSH_NOTIF_TYPE, pushNotifType.ordinal());
        intent.putExtra(EXTRA_COMMENT_ID, str4);
        if (list != null && list.size() == 1) {
            intent.putExtra(EXTRA_REDIRECT_URL, str3);
        }
        return intent;
    }

    public static Intent getNotificationClickIntent(BoxPushNotification boxPushNotification) {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(boxPushNotification.getUserId());
        Intent launchIntent = getLaunchIntent(arrayList, boxPushNotification.getTargetResourceId(), boxPushNotification.getTargetResourceName(), boxPushNotification.getNotifType(), BoxBaseApplication.getInstance(), boxPushNotification instanceof BoxPushNotificationV1 ? ((BoxPushNotificationV1) boxPushNotification).getRedirectUrl() : null, boxPushNotification.getCommentId());
        launchIntent.putExtra(EXTRA_FROM_ACTIVITY, true);
        return launchIntent;
    }

    public static Intent getDismissIntent(List<String> list, String str, String str2, BoxPushNotification.PushNotifType pushNotifType, Context context) {
        Intent launchIntent = getLaunchIntent(list, str, str2, pushNotifType, context, null, null);
        launchIntent.putExtra(EXTRA_DISMISS, true);
        return launchIntent;
    }

    public static Intent getMuteIntent(List<String> list, String str, String str2, BoxPushNotification.PushNotifType pushNotifType, Context context, int i) {
        Intent dismissIntent = getDismissIntent(list, str, str2, pushNotifType, context);
        dismissIntent.putExtra(EXTRA_MUTE, true);
        dismissIntent.putExtra(EXTRA_NOTIFICATION_ID, i);
        return dismissIntent;
    }

    public static List<String> getIdsFromString(String str) {
        if (StringUtils.isEmpty(str)) {
            return new ArrayList();
        }
        return new ArrayList(Arrays.asList(str.split(",")));
    }

    public static String concatIds(List<String> list) {
        int size;
        if (list == null || (size = list.size()) == 0) {
            return "";
        }
        int i = 0;
        if (size == 1) {
            return list.get(0);
        }
        StringBuilder sb = new StringBuilder();
        while (true) {
            int i2 = size - 1;
            if (i < i2) {
                sb.append(list.get(i)).append(AbstractJsonLexerKt.COMMA);
                i++;
            } else {
                sb.append(list.get(i2));
                return sb.toString();
            }
        }
    }

    @Override // com.box.android.base.presentation.activities.BoxEntrypointActivity, com.box.android.base.presentation.activities.BoxFragmentActivity
    public void onBoxCreate(Bundle bundle) {
        String stringExtra;
        super.onBoxCreate(bundle);
        if (bundle != null) {
            stringExtra = bundle.getString(EXTRA_IDS_LIST);
            this.mFromActivity = bundle.getBoolean(EXTRA_FROM_ACTIVITY);
            this.targetId = bundle.getString(EXTRA_TARGET_ID);
            this.targetName = bundle.getString(EXTRA_TARGET_NAME);
            this.dismissOnly = bundle.getBoolean(EXTRA_DISMISS);
            this.mPushNotifType = BoxPushNotification.PushNotifType.values()[bundle.getInt(EXTRA_PUSH_NOTIF_TYPE, BoxPushNotification.PushNotifType.COLLAB_INVITE_COLLABORATOR.ordinal())];
            this.mShallMute = bundle.getBoolean(EXTRA_MUTE);
            this.mNotificationId = bundle.getInt(EXTRA_NOTIFICATION_ID, Integer.MIN_VALUE);
            this.mRedirectUrl = bundle.getString(EXTRA_REDIRECT_URL);
            this.mCommentId = bundle.getString(EXTRA_COMMENT_ID);
        } else {
            stringExtra = getIntent().getStringExtra(EXTRA_IDS_LIST);
            this.mFromActivity = getIntent().getBooleanExtra(EXTRA_FROM_ACTIVITY, false);
            this.targetId = getIntent().getStringExtra(EXTRA_TARGET_ID);
            this.targetName = getIntent().getStringExtra(EXTRA_TARGET_NAME);
            this.dismissOnly = getIntent().getBooleanExtra(EXTRA_DISMISS, false);
            this.mPushNotifType = BoxPushNotification.PushNotifType.values()[getIntent().getIntExtra(EXTRA_PUSH_NOTIF_TYPE, BoxPushNotification.PushNotifType.COLLAB_INVITE_COLLABORATOR.ordinal())];
            this.mShallMute = getIntent().getBooleanExtra(EXTRA_MUTE, false);
            this.mNotificationId = getIntent().getIntExtra(EXTRA_NOTIFICATION_ID, Integer.MIN_VALUE);
            this.mRedirectUrl = getIntent().getStringExtra(EXTRA_REDIRECT_URL);
            this.mCommentId = getIntent().getStringExtra(EXTRA_COMMENT_ID);
        }
        this.notifIds = getIdsFromString(stringExtra);
        BoxAmplitudeAnalytics.getInstance().setReferrer("notification");
        if (this.mFromActivity) {
            return;
        }
        BoxAmplitudeAnalytics.PushNotifEventPropertyBuilder.setNotificationTypeForSession(this.mPushNotifType);
    }

    @Override // com.box.android.base.presentation.activities.BoxEntrypointActivity
    protected void onAuthenticated(BoxUserAuthenticationMessage boxUserAuthenticationMessage) {
        if (boxUserAuthenticationMessage.wasSuccessful()) {
            handleNotifDismissing();
        } else {
            BoxNotificationHelper.displayDialog(CommonBoxUtil.LS(R.string.LS_Error), CommonBoxUtil.LS(R.string.LS_Please_register));
            finish();
        }
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    public IntentFilter getIntentFilter() {
        IntentFilter intentFilter = super.getIntentFilter();
        intentFilter.addAction(BoxRequestsFile.GetFileInfo.class.getName());
        return intentFilter;
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected void processBoxMessage(BoxMessage<?> boxMessage) {
        if (boxMessage instanceof BoxResponseMessage) {
            BoxResponseMessage boxResponseMessage = (BoxResponseMessage) boxMessage;
            BoxRequest request = boxResponseMessage.getRequest();
            if ((request instanceof BoxRequestsFile.GetFileInfo) && !this.dismissOnly && ((BoxRequestsFile.GetFileInfo) request).getId().equals(this.targetId)) {
                broadcastDismissSpinner();
                if (boxMessage.wasSuccessful()) {
                    BoxFile boxFile = (BoxFile) boxResponseMessage.getResponse().getResult();
                    if (boxFile.getUserId().equals(this.targetId)) {
                        String str = this.mRedirectUrl;
                        if (str != null && !str.isEmpty()) {
                            launchBoxToFile(boxFile, this.mRedirectUrl, this.mCommentId);
                            return;
                        } else {
                            launchBoxToFile(boxFile, this.mCommentId);
                            return;
                        }
                    }
                    return;
                }
                if (boxMessage.getException() instanceof BoxException) {
                    BoxLogUtils.e(NotificationInterceptorActivity.class.getName(), boxMessage.getException().toString());
                    if (((BoxException) boxMessage.getException()).getErrorType() == BoxException.ErrorType.NETWORK_ERROR) {
                        BoxPresentationUtils.displayToast(getResources().getString(R.string.check_connection_try_again), this);
                    } else if (((BoxException) boxMessage.getException()).getResponseCode() == 404) {
                        BoxPresentationUtils.displayToast(getResources().getString(R.string.error_item_unavailable), this);
                    } else if (boxMessage.getException().getLocalizedMessage() != null) {
                        BoxPresentationUtils.displayToast(boxMessage.getException().getLocalizedMessage(), this);
                    } else {
                        BoxPresentationUtils.displayToast(getResources().getString(R.string.err_unknown), this);
                    }
                }
                finish();
            }
        }
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity, com.box.android.base.presentation.activities.BoxSpinnerDialogFragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMSaveInstanceState(Bundle bundle) {
        bundle.putString(EXTRA_IDS_LIST, concatIds(this.notifIds));
        bundle.putString(EXTRA_TARGET_ID, this.targetId);
        bundle.putString(EXTRA_TARGET_NAME, this.targetName);
        bundle.putBoolean(EXTRA_DISMISS, this.dismissOnly);
        bundle.putInt(EXTRA_PUSH_NOTIF_TYPE, this.mPushNotifType.ordinal());
        bundle.putBoolean(EXTRA_MUTE, this.mShallMute);
        bundle.putInt(EXTRA_NOTIFICATION_ID, this.mNotificationId);
        bundle.putBoolean(EXTRA_FROM_ACTIVITY, this.mFromActivity);
        bundle.putString(EXTRA_REDIRECT_URL, this.mRedirectUrl);
        bundle.putString(EXTRA_COMMENT_ID, this.mCommentId);
        super.onMAMSaveInstanceState(bundle);
    }

    public static Runnable createDismissRunnable(final List<String> list, final BoxApiPrivate boxApiPrivate) {
        return new Runnable() { // from class: com.box.android.activities.NotificationInterceptorActivity.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                for (String str : list) {
                    BoxRequestGetPushNotifications pushNotificationsRequest = boxApiPrivate.getPushNotificationsRequest();
                    pushNotificationsRequest.setNotificationId(str).setShowNonProcessed(true);
                    try {
                        NotificationInterceptorActivity.dismissNotification((BoxPushNotification) pushNotificationsRequest.sendForCachedResult().get(0), boxApiPrivate);
                    } catch (Exception e) {
                        BoxLogUtils.e("unable to dismiss", e);
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void dismissNotification(BoxPushNotification boxPushNotification, BoxApiPrivate boxApiPrivate) {
        boxPushNotification.setIsDismissed();
        boxPushNotification.setPreviousDismissTime(System.currentTimeMillis());
        try {
            boxApiPrivate.getStorePushNotificationRequest(boxPushNotification).sendForCachedResult();
        } catch (Exception e) {
            BoxLogUtils.e("failed to store dismiss", e);
        }
        try {
            Integer numValueOf = Integer.valueOf((int) Float.parseFloat(boxPushNotification.getUserId()));
            if (numValueOf != null) {
                BoxNotificationManager.cancel(numValueOf.intValue());
            }
        } catch (Exception e2) {
            BoxLogUtils.e("BoxPushNotifObjectStatusBar.dismiss", e2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void handleNotifDismissing() {
        if (this.notifIds.size() > 0) {
            BoxRequestGetPushNotifications pushNotificationsRequest = this.mApiPrivate.getPushNotificationsRequest();
            List<String> list = this.notifIds;
            pushNotificationsRequest.setNotificationId(list.get(list.size() - 1)).setShowNonProcessed(true);
            BoxPushNotification boxPushNotification = null;
            try {
                BoxIteratorBoxPushNotification boxIteratorBoxPushNotificationSendForCachedResult = pushNotificationsRequest.sendForCachedResult();
                this.mPushNotifications = boxIteratorBoxPushNotificationSendForCachedResult;
                if (boxIteratorBoxPushNotificationSendForCachedResult != null && boxIteratorBoxPushNotificationSendForCachedResult.size() > 0) {
                    boxPushNotification = (BoxPushNotification) this.mPushNotifications.get(0);
                }
                ((ExecutorPool) this.mUserContextManager.getCurrentContext().getUserContextComponent(IUserContext.UserContextComponent.EXECUTOR_POOL)).getNotificationExecutor().submit(createDismissRunnable(this.notifIds, this.mApiPrivate));
            } catch (BoxException e) {
                BoxLogUtils.e("notification not found", e);
            }
            if (boxPushNotification != null) {
                String targetResourceType = boxPushNotification.getTargetResourceType();
                if (this.mShallMute) {
                    BoxAnalytics.INSTANCE.trackEvent(BoxAnalyticsParams.CATEGORY_PUSH_NOTIFICATIONS, BoxAnalyticsParams.ACTION_NOTIFICATION_BLOCKED, boxPushNotification.getNotifTypeString());
                    this.mBaseMoco.performLocal(this.mBoxExtendedApiFile.addMuteNotificationCategory(boxPushNotification.getTargetResourceId(), boxPushNotification.getNotifType().getMuteCollectionType()));
                    int i = this.mNotificationId;
                    if (i != Integer.MIN_VALUE) {
                        BoxNotificationManager.cancel(i);
                    }
                    finish();
                    return;
                }
                if (this.dismissOnly) {
                    BoxAnalytics.INSTANCE.trackEvent(BoxAnalyticsParams.CATEGORY_PUSH_NOTIFICATIONS, "dismiss_fixed_v2", boxPushNotification.getNotifTypeString());
                    finish();
                    return;
                }
                if (!this.mFromActivity) {
                    BoxAnalytics.INSTANCE.trackEvent(BoxAnalyticsParams.CATEGORY_PUSH_NOTIFICATIONS, "launch_fixed_v2", boxPushNotification.getNotifTypeString());
                }
                if (this.mRedirectUrl != null) {
                    BoxAmplitudeAnalytics.createPushNotifEventPropertyBuilder().logNotificationDeeplinkLaunched(Uri.parse(this.mRedirectUrl));
                }
                navigate(targetResourceType, boxPushNotification.getTargetResourceName());
                return;
            }
            finish();
        }
    }

    private void navigate(String str, String str2) {
        if (str.equalsIgnoreCase("folder")) {
            launchBoxToFolder(this.targetId, str2);
            finish();
        } else if (str.equalsIgnoreCase("file")) {
            showSpinner();
            this.mBaseMoco.performRemote(this.mBoxExtendedApiFile.getInfoRequest(this.targetId));
        }
    }

    private void launchBoxToFolder(String str, String str2) {
        Intent intentMainPhoneActivityIntent = this.mIntentServices.mainPhoneActivityIntent(this);
        intentMainPhoneActivityIntent.putExtra(IntentConstants.EXTRA_INIT_FOLDER_ID, str);
        intentMainPhoneActivityIntent.putExtra(IntentConstants.EXTRA_ITEM_NAME, str2);
        startActivity(intentMainPhoneActivityIntent);
    }

    protected void launchBoxToFile(BoxFile boxFile, String str) {
        this.previewLauncher.launchPreview(new IPreviewLauncher.NavigationData(this, FileModelMapper.INSTANCE.toFileModel(boxFile, true), PreviewSource.Notification.INSTANCE, null, this.mPushNotifType == BoxPushNotification.PushNotifType.COMMENT_CREATE ? new PreviewNavigationTarget.Comments(str) : null), null, new Function1() { // from class: com.box.android.activities.NotificationInterceptorActivity$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Unit.INSTANCE;
            }
        });
        finish();
    }

    protected void launchBoxToFile(BoxFile boxFile, String str, String str2) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setClass(this, WebUrlsInterceptorActivity.class);
        Uri uriBuild = Uri.parse(str);
        if (uriBuild.getScheme() != null && uriBuild.getScheme().equals("boxopendirect")) {
            Uri.Builder builderPath = new Uri.Builder().scheme("https").authority("box.com").path(LAUNCH_DATA_URI_PATH_SEGMENT_FILE + boxFile.getUserId());
            if (this.mPushNotifType == BoxPushNotification.PushNotifType.COMMENT_CREATE) {
                builderPath.appendQueryParameter(LAUNCH_DATA_URI_ACTIVITY_TYPE_QUERY, "comment");
            }
            uriBuild = builderPath.build();
        }
        intent.setData(uriBuild.buildUpon().appendQueryParameter(WebUrlsInterceptorActivity.ACTIVITY_ID_QUERY, str2).build());
        intent.putExtra(IntentConstants.EXTRA_ENTRYPOINT, PreviewSource.Notification.INSTANCE);
        startActivity(intent);
        finish();
    }
}
