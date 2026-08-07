package com.box.android.activities.urlsinterceptor;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.EditText;
import android.widget.Toast;
import androidx.lifecycle.ViewModelProvider;
import com.box.android.R;
import com.box.android.application.BoxBaseApplication;
import com.box.android.base.presentation.BoxPresentationUtils;
import com.box.android.base.presentation.activities.BoxFragmentActivity;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.common.utilities.IntentConstants;
import com.box.android.controller.ExecutorPool;
import com.box.android.coreservices.modelcontroller.BoxCallable;
import com.box.android.coreservices.modelcontroller.BoxFutureTask;
import com.box.android.coreservices.modelcontroller.messages.BoxMessage;
import com.box.android.coreservices.modelcontroller.messages.BoxSharedItemMessage;
import com.box.android.coreservices.modelcontroller.messages.BoxUserAuthenticationMessage;
import com.box.android.coreservices.modelcontroller.messages.Controller;
import com.box.android.coreservices.services.IntentServices;
import com.box.android.coreservices.utilities.CoreServiceUtils;
import com.box.android.data.service.impl.SharedLinkService;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.android.domain.identity.IUserContext;
import com.box.android.domain.models.preview.PreviewSource;
import com.box.android.utilities.BoxUtils;
import com.box.android.utilities.notificationmanager.BoxNotificationHelper;
import com.box.androidsdk.content.BoxException;
import com.box.androidsdk.content.models.BoxBookmark;
import com.box.androidsdk.content.models.BoxFile;
import com.box.androidsdk.content.models.BoxFolder;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.requests.BoxResponse;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import java.net.UnknownHostException;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes9.dex */
public class SharedLinkInterceptorActivity extends Hilt_SharedLinkInterceptorActivity {
    public static final String BOX_APP_SCHEME = "boxapp";
    public static final String BOX_EMM_SCHEME = "boxemm";
    public static final String BOX_SHARED_SCHEME = "boxopenshared";
    public static final String BOX_SHARED_URL = "url";
    public static final String EXTRA_PARAM_SHARED_URI = "extra_param_shared_uri";
    private static final String TRACKING_CODE_UNKNOWN = "https://box.com/sharedlink?utm_source=trans&utm_medium=unknown&utm_campaign=sharedlink";

    @Inject
    protected IntentServices mIntentServices;

    @Inject
    protected SharedLinkService mSharedLinkService;
    protected String mTarget;

    @Override // com.box.android.base.presentation.activities.BoxEntrypointActivity
    protected boolean authenticateOnResume() {
        return true;
    }

    @Override // com.box.android.base.presentation.activities.Hilt_BoxFragmentActivity, androidx.activity.ComponentActivity, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public /* bridge */ /* synthetic */ ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        return super.getDefaultViewModelProviderFactory();
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected void processBoxMessage(BoxMessage<?> boxMessage) {
        super.processBoxMessage(boxMessage);
        if (boxMessage.getAction().equals(Controller.ACTION_FETCHED_ITEM_FROM_SHARED_LINK)) {
            onFetchedSharedLink((BoxSharedItemMessage) boxMessage);
        }
    }

    @Override // com.box.android.base.presentation.activities.BoxEntrypointActivity, com.box.android.base.presentation.activities.BoxFragmentActivity
    public void onBoxCreate(Bundle bundle) {
        super.onBoxCreate(bundle);
        if (bundle != null) {
            this.mTarget = bundle.getString(EXTRA_PARAM_SHARED_URI);
        }
        processIntent();
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    public IntentFilter getIntentFilter() {
        IntentFilter intentFilter = super.getIntentFilter();
        intentFilter.addAction(Controller.ACTION_FETCHED_ITEM_FROM_SHARED_LINK);
        return intentFilter;
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity, com.box.android.base.presentation.activities.BoxSpinnerDialogFragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMSaveInstanceState(Bundle bundle) {
        bundle.putString(EXTRA_PARAM_SHARED_URI, this.mTarget);
        super.onMAMSaveInstanceState(bundle);
    }

    private void onFetchedSharedLink(BoxSharedItemMessage boxSharedItemMessage) {
        if (boxSharedItemMessage.wasSuccessful() && this.mTarget != null) {
            BoxItem payload = boxSharedItemMessage.getPayload();
            if (this.mTarget.equals(boxSharedItemMessage.getSharedLinkUrl()) || this.mTarget.equals(payload.getUserId())) {
                if (payload instanceof BoxFile) {
                    launchBoxToFile((BoxFile) payload);
                    return;
                } else if (payload instanceof BoxFolder) {
                    launchBoxToFolder((BoxFolder) payload);
                    return;
                } else {
                    if (payload instanceof BoxBookmark) {
                        launchBoxToWeblink((BoxBookmark) payload);
                        return;
                    }
                    return;
                }
            }
        }
        if (boxSharedItemMessage.getException() != null && boxSharedItemMessage.getException().getCause() != null && (boxSharedItemMessage.getException().getCause() instanceof UnknownHostException)) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.box.android.activities.urlsinterceptor.SharedLinkInterceptorActivity.1
                @Override // java.lang.Runnable
                public void run() {
                    BoxPresentationUtils.displayToast(R.string.check_connection_try_again, SharedLinkInterceptorActivity.this, new String[0]);
                    SharedLinkInterceptorActivity.this.finish();
                }
            });
        } else if (boxSharedItemMessage.wasApplicationRestricted()) {
            getSharedPassword();
        } else {
            launchStopScreen();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleInvalidLink() {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.box.android.activities.urlsinterceptor.SharedLinkInterceptorActivity$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                Toast.makeText(BoxBaseApplication.getInstance(), CommonBoxUtil.LS(R.string.There_was_a_problem_accessing_this_shared_link), 1).show();
            }
        });
        quitActivity();
        BoxAmplitudeAnalytics.getInstance().setReferrer(BoxAnalyticsParams.REFERRER_EXTERNAL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isInvalidTarget() {
        if (StringUtils.isEmpty(this.mTarget)) {
            return true;
        }
        return URLUtil.isValidUrl(this.mTarget) && !CommonBoxUtil.isAllowListedDomain(this.mTarget);
    }

    private void processIntent() {
        showSpinner();
        new Thread() { // from class: com.box.android.activities.urlsinterceptor.SharedLinkInterceptorActivity.2
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                SharedLinkInterceptorActivity sharedLinkInterceptorActivity = SharedLinkInterceptorActivity.this;
                sharedLinkInterceptorActivity.mTarget = sharedLinkInterceptorActivity.getTargetFromIntent(sharedLinkInterceptorActivity.getIntent());
                if (SharedLinkInterceptorActivity.this.isInvalidTarget()) {
                    SharedLinkInterceptorActivity.this.handleInvalidLink();
                } else {
                    Uri uri = Uri.parse(SharedLinkInterceptorActivity.this.mTarget);
                    String str = BoxUtils.isUriSourceEmail(uri) ? "email" : BoxAnalyticsParams.REFERRER_EXTERNAL;
                    JSONArray referrerTrackingArray = BoxAmplitudeAnalytics.getReferrerTrackingArray(uri);
                    if (referrerTrackingArray == null || referrerTrackingArray.length() < 1) {
                        uri = Uri.parse(SharedLinkInterceptorActivity.TRACKING_CODE_UNKNOWN);
                    }
                    BoxAmplitudeAnalytics.getInstance().setReferrer(str, uri);
                    BoxAmplitudeAnalytics.createPushNotifEventPropertyBuilder().logNotificationDeeplinkLaunched(SharedLinkInterceptorActivity.this.getIntent().getData());
                }
                SharedLinkInterceptorActivity.this.mBoxSession.setTriggeredByExternalLink();
            }
        }.start();
    }

    protected String getTargetFromIntent(Intent intent) {
        if (intent == null) {
            return null;
        }
        String dataString = intent.getDataString();
        if (intent.getScheme() != null) {
            return (intent.getScheme().equalsIgnoreCase(BOX_SHARED_SCHEME) || intent.getScheme().equalsIgnoreCase("boxapp") || intent.getScheme().equalsIgnoreCase("boxemm")) ? intent.getData().getQueryParameter("url") : dataString;
        }
        return dataString;
    }

    protected void quitActivity() {
        try {
            broadcastDismissSpinner();
        } catch (Exception unused) {
        }
        finish();
    }

    private void getSharedPassword() {
        try {
            broadcastDismissSpinner();
        } catch (Exception unused) {
        }
        MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(this);
        materialAlertDialogBuilder.setTitle((CharSequence) CommonBoxUtil.LS(R.string.Password_requred));
        View viewInflate = getLayoutInflater().inflate(R.layout.shared_link_password, (ViewGroup) null);
        final EditText editText = (EditText) viewInflate.findViewById(R.id.shared_link_password);
        materialAlertDialogBuilder.setView(viewInflate);
        materialAlertDialogBuilder.setPositiveButton((CharSequence) CommonBoxUtil.LS(R.string.button_ok), new DialogInterface.OnClickListener() { // from class: com.box.android.activities.urlsinterceptor.SharedLinkInterceptorActivity.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                SharedLinkInterceptorActivity.this.showSpinner();
                String string = editText.getText().toString();
                SharedLinkInterceptorActivity sharedLinkInterceptorActivity = SharedLinkInterceptorActivity.this;
                sharedLinkInterceptorActivity.getSharedItem(sharedLinkInterceptorActivity.mTarget, string, true);
            }
        });
        materialAlertDialogBuilder.setNegativeButton((CharSequence) CommonBoxUtil.LS(R.string.LO_Cancel), new DialogInterface.OnClickListener() { // from class: com.box.android.activities.urlsinterceptor.SharedLinkInterceptorActivity.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                SharedLinkInterceptorActivity.this.quitActivity();
            }
        });
        materialAlertDialogBuilder.create().show();
    }

    protected void launchBoxToFile(BoxFile boxFile) {
        Intent intentFileRouterActivityIntent = this.mIntentServices.fileRouterActivityIntent(this, PreviewSource.SharedLink.INSTANCE);
        intentFileRouterActivityIntent.addFlags(524288);
        intentFileRouterActivityIntent.setData(Uri.parse(boxFile.getUserId()));
        intentFileRouterActivityIntent.putExtra(IntentConstants.EXTRA_INIT_LAUNCH_NEW, true);
        intentFileRouterActivityIntent.putExtra(IntentConstants.EXTRA_INIT_FILE, boxFile);
        intentFileRouterActivityIntent.putExtra(BoxFragmentActivity.EXTRA_SHAREDLINK_URL, this.mBoxSession.getSharedLink());
        intentFileRouterActivityIntent.putExtra(BoxFragmentActivity.EXTRA_SHAREDLINK_PASSWORD, this.mBoxSession.getPassword());
        broadcastDismissSpinner();
        startActivity(intentFileRouterActivityIntent);
        quitActivity();
    }

    private void launchBoxToFolder(BoxFolder boxFolder) {
        Intent intentMainPhoneActivityIntent = this.mIntentServices.mainPhoneActivityIntent(this);
        intentMainPhoneActivityIntent.addFlags(524288);
        intentMainPhoneActivityIntent.setData(Uri.parse(boxFolder.getUserId()));
        intentMainPhoneActivityIntent.putExtra(IntentConstants.EXTRA_INIT_FOLDER_ID, boxFolder.getUserId());
        intentMainPhoneActivityIntent.putExtra(IntentConstants.EXTRA_ITEM_NAME, boxFolder.getName());
        intentMainPhoneActivityIntent.putExtra(BoxFragmentActivity.EXTRA_SHAREDLINK_URL, this.mBoxSession.getSharedLink());
        intentMainPhoneActivityIntent.putExtra(BoxFragmentActivity.EXTRA_SHAREDLINK_PASSWORD, this.mBoxSession.getPassword());
        startActivity(intentMainPhoneActivityIntent);
        quitActivity();
    }

    private void launchBoxToWeblink(BoxBookmark boxBookmark) {
        if (StringUtils.isEmpty(boxBookmark.getUrl())) {
            return;
        }
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(boxBookmark.getUrl())));
        quitActivity();
    }

    private void launchStopScreen() {
        if (!isInvalidTarget()) {
            startActivity(SharedLinkStopScreenActivity.newSharedLinkStopScreenActivity(this, this.mTarget));
        }
        quitActivity();
    }

    @Override // com.box.android.base.presentation.activities.BoxEntrypointActivity
    protected void onAuthenticated(BoxUserAuthenticationMessage boxUserAuthenticationMessage) {
        if (boxUserAuthenticationMessage.wasSuccessful()) {
            getSharedItem(this.mTarget, null, false);
        } else {
            BoxNotificationHelper.displayDialog(CommonBoxUtil.LS(R.string.LS_Error), CommonBoxUtil.LS(R.string.LS_Please_register));
            quitActivity();
        }
    }

    protected BoxFutureTask<BoxSharedItemMessage> getSharedItem(final String str, final String str2, final boolean z) {
        BoxFutureTask<BoxSharedItemMessage> boxFutureTask = new BoxFutureTask<>(new BoxCallable<BoxSharedItemMessage>() { // from class: com.box.android.activities.urlsinterceptor.SharedLinkInterceptorActivity.5
            @Override // java.util.concurrent.Callable
            public BoxSharedItemMessage call() throws Exception {
                BoxSharedItemMessage boxSharedItemMessage = new BoxSharedItemMessage();
                boxSharedItemMessage.setRequestId(getRequestId());
                boxSharedItemMessage.setAction(Controller.ACTION_FETCHED_ITEM_FROM_SHARED_LINK);
                boxSharedItemMessage.setSharedLinkUrl(str);
                try {
                    BoxResponse boxResponse = SharedLinkInterceptorActivity.this.mBaseMoco.performRemote(SharedLinkInterceptorActivity.this.mBoxApiShare.getSharedLinkRequest(str, str2)).get();
                    if (boxResponse.isSuccess()) {
                        BoxItem boxItem = (BoxItem) boxResponse.getResult();
                        String id = boxItem.getUserId();
                        boolean z2 = (boxItem instanceof BoxFolder) || (boxItem instanceof BoxFile) || (boxItem instanceof BoxBookmark);
                        boxSharedItemMessage.setItemId(id);
                        boxSharedItemMessage.setPayload(boxItem);
                        boxSharedItemMessage.setSuccess(z2);
                        String str3 = str;
                        if (str3 != null && !str3.isEmpty()) {
                            SharedLinkInterceptorActivity.this.mSharedLinkService.saveSharedLinkCredential(boxItem.getUserId(), str, str2, new Continuation<Unit>() { // from class: com.box.android.activities.urlsinterceptor.SharedLinkInterceptorActivity.5.1
                                @Override // kotlin.coroutines.Continuation
                                public void resumeWith(Object obj) {
                                }

                                @Override // kotlin.coroutines.Continuation
                                public CoroutineContext getContext() {
                                    return EmptyCoroutineContext.INSTANCE;
                                }
                            });
                        }
                    } else {
                        boxSharedItemMessage.setSuccess(false);
                        boxSharedItemMessage.setException(boxResponse.getException());
                        if (z && (boxResponse.getException() instanceof BoxException)) {
                            final BoxException boxException = (BoxException) boxResponse.getException();
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.box.android.activities.urlsinterceptor.SharedLinkInterceptorActivity.5.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (boxException.getErrorType() == BoxException.ErrorType.NETWORK_ERROR) {
                                        Toast.makeText(SharedLinkInterceptorActivity.this, R.string.check_connection_try_again, 1).show();
                                    } else {
                                        Toast.makeText(SharedLinkInterceptorActivity.this, R.string.unable_to_verify_password, 1).show();
                                        Log.e(SharedLinkInterceptorActivity.class.getName(), SharedLinkInterceptorActivity.this.getString(R.string.unable_to_verify_password), boxException);
                                    }
                                }
                            });
                        }
                    }
                } catch (Exception e) {
                    if (e instanceof InterruptedException) {
                        Thread.currentThread().interrupt();
                    }
                    boxSharedItemMessage.setSuccess(false);
                    boxSharedItemMessage.setException(e);
                }
                CoreServiceUtils.broadcastIntent(SharedLinkInterceptorActivity.this.mUserContextManager, boxSharedItemMessage);
                return boxSharedItemMessage;
            }
        }, hashCode());
        ((ExecutorPool) this.mUserContextManager.getCurrentContext().getUserContextComponent(IUserContext.UserContextComponent.EXECUTOR_POOL)).getOfflineStatusExecutor().submit(boxFutureTask);
        return boxFutureTask;
    }

    protected BoxFutureTask<BoxSharedItemMessage> getFileInfo(final String str) {
        BoxFutureTask<BoxSharedItemMessage> boxFutureTask = new BoxFutureTask<>(new BoxCallable<BoxSharedItemMessage>() { // from class: com.box.android.activities.urlsinterceptor.SharedLinkInterceptorActivity.6
            @Override // java.util.concurrent.Callable
            public BoxSharedItemMessage call() throws Exception {
                BoxSharedItemMessage boxSharedItemMessage = new BoxSharedItemMessage();
                boxSharedItemMessage.setRequestId(getRequestId());
                boxSharedItemMessage.setAction(Controller.ACTION_FETCHED_ITEM_FROM_SHARED_LINK);
                try {
                    BoxResponse boxResponse = SharedLinkInterceptorActivity.this.mBaseMoco.performRemote(SharedLinkInterceptorActivity.this.mBoxExtendedApiFile.getInfoRequest(str)).get();
                    if (boxResponse.isSuccess()) {
                        BoxItem boxItem = (BoxItem) boxResponse.getResult();
                        String id = boxItem.getUserId();
                        boolean z = (boxItem instanceof BoxFolder) || (boxItem instanceof BoxFile) || (boxItem instanceof BoxBookmark);
                        boxSharedItemMessage.setItemId(id);
                        boxSharedItemMessage.setPayload(boxItem);
                        boxSharedItemMessage.setSuccess(z);
                    } else {
                        boxSharedItemMessage.setSuccess(false);
                        boxSharedItemMessage.setException(boxResponse.getException());
                    }
                } catch (Exception e) {
                    if (e instanceof InterruptedException) {
                        Thread.currentThread().interrupt();
                    }
                    boxSharedItemMessage.setSuccess(false);
                    boxSharedItemMessage.setException(e);
                }
                CoreServiceUtils.broadcastIntent(SharedLinkInterceptorActivity.this.mUserContextManager, boxSharedItemMessage);
                return boxSharedItemMessage;
            }
        }, hashCode());
        ((ExecutorPool) this.mUserContextManager.getCurrentContext().getUserContextComponent(IUserContext.UserContextComponent.EXECUTOR_POOL)).getOfflineStatusExecutor().submit(boxFutureTask);
        return boxFutureTask;
    }
}
