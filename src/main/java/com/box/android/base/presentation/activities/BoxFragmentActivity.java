package com.box.android.base.presentation.activities;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.view.ActionMode;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.box.android.base.presentation.BoxFragmentInterface;
import com.box.android.base.presentation.BoxPresentationUtils;
import com.box.android.base.presentation.fragments.IApplicationFragmentCallback;
import com.box.android.base.presentation.fragments.IBoxFragmentActivity;
import com.box.android.base.presentation.shake.BetaFeedbackManager;
import com.box.android.common.utilities.ApplicationProvider;
import com.box.android.common.utilities.BuildConfigProvider;
import com.box.android.coreservices.modelcontroller.IBaseModelController;
import com.box.android.coreservices.modelcontroller.IMoCoBoxGlobalSettings;
import com.box.android.coreservices.modelcontroller.IMoCoBoxTransfers;
import com.box.android.coreservices.modelcontroller.messages.BoxMessage;
import com.box.android.coreservices.modelcontroller.messages.BoxSwitchUserMessage;
import com.box.android.coreservices.modelcontroller.messages.BoxUserAuthenticationMessage;
import com.box.android.coreservices.models.CustomBoxSession;
import com.box.android.coreservices.services.IUserContextMigration;
import com.box.android.coreservices.services.IntentServices;
import com.box.android.coreservices.services.NotificationServices;
import com.box.android.coreservices.utilities.CoreServiceUtils;
import com.box.android.coreservices.utilities.intune.IntuneAuthManager;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.analytics.BoxAnalytics;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.android.domain.analytics.PendoAnalytics;
import com.box.android.domain.configuration.ConfigManager;
import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.configuration.IBoxAccountSettings;
import com.box.android.domain.configuration.ISplitConfiguration;
import com.box.android.domain.identity.IUserContext;
import com.box.android.domain.identity.IUserContextComponent;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.initialisation.ClientSettingsInitialisation;
import com.box.android.domain.localrepo.ILocalSharedPreferences;
import com.box.android.domain.services.IAppRestrictionsManager;
import com.box.android.domain.services.IForceUpdateCoordinator;
import com.box.android.domain.usecases.capture.LaunchIntoCaptureUseCase;
import com.box.androidsdk.content.BoxApiShare;
import com.box.androidsdk.content.BoxFutureTask;
import com.box.androidsdk.content.auth.BoxAuthentication;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.models.BoxUser;
import com.box.androidsdk.content.requests.BoxResponse;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.box.androidsdk.content.utils.SdkUtils;
import com.box.boxandroidlibv2private.resourcemanagers.BoxApiPrivate;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFile;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFolder;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiWeblink;
import com.github.clans.fab.FloatingActionMenu;
import com.google.android.material.snackbar.Snackbar;
import com.microsoft.intune.mam.client.content.MAMBroadcastReceiver;
import com.microsoft.intune.mam.client.view.MAMWindowManagement;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.inject.Inject;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: loaded from: classes9.dex */
public abstract class BoxFragmentActivity extends Hilt_BoxFragmentActivity implements IBoxFragmentActivity {
    public static final String EXTRA_FORCE_DARK_MODE = "extraForceDarkMode";
    public static final String EXTRA_SHAREDLINK_PASSWORD = "com.box.android.extraSharedLinkPassword";
    public static final String EXTRA_SHAREDLINK_URL = "com.box.android.extraSharedLinkUrl";
    private static final String EXTRA_USER_CONTEXT_ID = "com.box.android.userContextId";
    public static final String SHOW_INTUNE_AUTH_TAG = "showIntuneAuth";

    @Inject
    protected BetaFeedbackManager betaFeedbackManager;

    @Inject
    protected ClientSettingsInitialisation clientSettingsInitialisation;

    @Inject
    protected IForceUpdateCoordinator forceUpdateCoordinator;
    private String mActivityUserId;

    @Inject
    protected IBaseModelController mBaseMoco;

    @Inject
    public IBoxAccountSettings mBoxAccountSettings;

    @Inject
    protected BoxExtendedApiWeblink mBoxApiBookmark;

    @Inject
    protected BoxApiPrivate mBoxApiPrivate;

    @Inject
    protected BoxApiShare mBoxApiShare;

    @Inject
    public BoxExtendedApiFile mBoxExtendedApiFile;

    @Inject
    protected BoxExtendedApiFolder mBoxExtendedApiFolder;
    protected CustomBoxSession mBoxSession;

    @Inject
    protected ConfigManager mConfigManager;
    private BroadcastReceiver mControllerReceiver;
    private Bundle mDelayCreationSavedInstanceState;

    @Inject
    public FeatureFlips mFeatureFlips;

    @Inject
    public IMoCoBoxGlobalSettings mGlobalSettings;

    @Inject
    public IntentServices mIntentServices;

    @Inject
    protected IntuneAuthManager mIntuneAuthManager;
    private boolean mIsResumed;

    @Inject
    protected LaunchIntoCaptureUseCase mLaunchIntoCapture;
    private LocalBroadcastManager mLocalBroadcastManager;

    @Inject
    protected IUserContextMigration mMigration;

    @Inject
    protected NotificationServices mNotificationServices;

    @Inject
    protected IAppRestrictionsManager mRestrictionsManager;

    @Inject
    public ISplitConfiguration mSplitConfiguration;

    @Inject
    protected IMoCoBoxTransfers mTransfersModelController;

    @Inject
    protected IUserContextManager mUserContextManager;
    private Set<String> mPassedPinCodeUsers = new HashSet();
    private boolean mDelayCreationTillUserChanged = false;
    private boolean mIsBoxCreated = false;
    private boolean mIsStarted = false;
    private final MutableStateFlow<Boolean> mIsInActionModeFlow = StateFlowKt.MutableStateFlow(false);
    IntentFilter restrictionsFilter = new IntentFilter("android.intent.action.APPLICATION_RESTRICTIONS_CHANGED");
    BroadcastReceiver restrictionsReceiver = new MAMBroadcastReceiver() { // from class: com.box.android.base.presentation.activities.BoxFragmentActivity.1
        @Override // com.microsoft.intune.mam.client.content.HookedBroadcastReceiver
        public void onMAMReceive(Context context, Intent intent) {
            BoxLogUtils.d("AndroidForWork", "App restrictions changed broadcast received. Validating restrictions");
            BoxFragmentActivity.this.validateAppRestrictions();
        }
    };

    @Override // com.box.android.base.presentation.fragments.IBoxFragmentActivity
    public void dismissOutdatedSnackbar(BoxFragmentInterface boxFragmentInterface) {
    }

    public void dismissSnackbar() {
    }

    @Override // com.box.android.base.presentation.fragments.IBoxFragmentActivity
    public void dismissSnackbar(BoxFragmentInterface boxFragmentInterface) {
    }

    public Snackbar displaySnackbar(int i, int i2, View.OnClickListener onClickListener) {
        return null;
    }

    public Snackbar displaySnackbar(int i, int i2, View.OnClickListener onClickListener, int i3) {
        return null;
    }

    public Snackbar displaySnackbar(BoxFragmentInterface boxFragmentInterface, int i, int i2, View.OnClickListener onClickListener) {
        return null;
    }

    public Snackbar displaySnackbar(String str, int i, View.OnClickListener onClickListener) {
        return null;
    }

    public Snackbar displaySnackbar(String str, int i, View.OnClickListener onClickListener, int i2) {
        return null;
    }

    protected abstract Integer getActivityLayoutId();

    public FloatingActionMenu getFabMenu() {
        return null;
    }

    protected void handleOnNewIntent(Intent intent) {
    }

    protected void onBoxCreate(Bundle bundle) {
    }

    protected void onBoxInitialize(Bundle bundle) {
    }

    protected void onBoxStart() {
    }

    protected void processBoxMessage(BoxMessage<?> boxMessage) {
    }

    protected boolean requiresAuthToken() {
        return true;
    }

    protected boolean requiresPinCode() {
        return true;
    }

    public void setupAddFab() {
    }

    public void setupFab() {
    }

    protected boolean shouldHandleCaptureLaunch() {
        return true;
    }

    protected boolean shouldValidateRestrictions() {
        return true;
    }

    public void showBottomSheet(BoxItem boxItem) {
    }

    public boolean showNonActionItems() {
        return false;
    }

    public void toggleFab(boolean z) {
    }

    @Override // com.box.android.base.presentation.activities.Hilt_BoxFragmentActivity, com.box.android.base.presentation.activities.BoxSpinnerDialogFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMCreate(Bundle bundle) {
        if (getIntent().getBooleanExtra(EXTRA_FORCE_DARK_MODE, false)) {
            getDelegate().setLocalNightMode(2);
        }
        super.onMAMCreate(bundle);
        this.mBoxSession = (CustomBoxSession) this.mUserContextManager.getBoxSession(this);
        PendoAnalytics.INSTANCE.startSession(this.mUserContextManager.getUserInfo());
        BoxAnalytics.INSTANCE.trackEvent(BoxAnalyticsParams.CATEGORY_GENERAL_STATS, this.mUserContextManager.getUserTypeAsString());
        BoxAmplitudeAnalytics.UserPropertyBuilder userPropertyBuilder = new BoxAmplitudeAnalytics.UserPropertyBuilder();
        userPropertyBuilder.setUserType(BoxAnalyticsParams.INSTANCE.calculateUserType(this.mUserContextManager));
        userPropertyBuilder.updateUserProperties();
        this.mLocalBroadcastManager = LocalBroadcastManager.getInstance(this);
        setFinishOnTouchOutside(false);
        ((IApplicationFragmentCallback) ApplicationProvider.application).onFragmentStarted();
        registerReceiver();
        if (bundle == null) {
            if (this.mUserContextManager.hasValidUserId()) {
                setActivityUserId(this.mUserContextManager.getCurrentContextId());
            }
        } else if (bundle.containsKey(EXTRA_USER_CONTEXT_ID)) {
            setActivityUserId(bundle.getString(EXTRA_USER_CONTEXT_ID));
        }
        if (getActivityLayoutId() != null) {
            setContentView(getActivityLayoutId().intValue());
        }
        if (isSwitchingUsers()) {
            this.mDelayCreationTillUserChanged = true;
            this.mDelayCreationSavedInstanceState = bundle;
        } else {
            handleCreation(bundle);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected final void onStart() {
        super.onStart();
        if (this.mIsBoxCreated) {
            onBoxStart();
        }
        this.mIsStarted = true;
        if (getIntent() == null || SdkUtils.isBlank(getIntent().getStringExtra(EXTRA_SHAREDLINK_URL))) {
            return;
        }
        this.mBoxSession.setSharedLink(getIntent().getStringExtra(EXTRA_SHAREDLINK_URL));
        if (SdkUtils.isBlank(getIntent().getStringExtra(EXTRA_SHAREDLINK_PASSWORD))) {
            return;
        }
        this.mBoxSession.setPassword(getIntent().getStringExtra(EXTRA_SHAREDLINK_PASSWORD));
    }

    public void authenticate() {
        final WeakReference weakReference = new WeakReference(this);
        this.mBoxSession.authenticate(new BoxFutureTask.OnCompletedListener() { // from class: com.box.android.base.presentation.activities.BoxFragmentActivity$$ExternalSyntheticLambda1
            @Override // com.box.androidsdk.content.BoxFutureTask.OnCompletedListener
            public final void onCompleted(BoxResponse boxResponse) {
                this.f$0.lambda$authenticate$0(weakReference, boxResponse);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$authenticate$0(WeakReference weakReference, BoxResponse boxResponse) {
        if (weakReference.get() == null) {
            return;
        }
        if (boxResponse.isSuccess() && !SdkUtils.isBlank(((BoxSession) boxResponse.getResult()).getAuthInfo().accessToken())) {
            ((BoxFragmentActivity) weakReference.get()).updateAuthInfo(BoxUserAuthenticationMessage.newMessage(((BoxSession) boxResponse.getResult()).getAuthInfo()));
            return;
        }
        if (boxResponse.getException() != null) {
            BoxLogUtils.e(boxResponse.getException());
        }
        if (this instanceof BoxEntrypointActivity) {
            BoxUserAuthenticationMessage boxUserAuthenticationMessageNewMessage = BoxUserAuthenticationMessage.newMessage(this.mBoxSession.getAuthInfo());
            boxUserAuthenticationMessageNewMessage.setException(boxResponse.getException());
            boxUserAuthenticationMessageNewMessage.setSuccess(false);
            Object obj = weakReference.get();
            if (obj instanceof BoxEntrypointActivity) {
                ((BoxEntrypointActivity) obj).onAuthenticated(boxUserAuthenticationMessageNewMessage);
            }
        }
    }

    protected void validateAppRestrictions() {
        boolean zContainsMandatoryKey;
        if (shouldValidateRestrictions()) {
            Bundle latestAppRestrictions = this.mRestrictionsManager.getLatestAppRestrictions();
            ArrayList<String> alteredAppRestrictionKeys = this.mRestrictionsManager.getAlteredAppRestrictionKeys(latestAppRestrictions);
            if (!alteredAppRestrictionKeys.isEmpty() || this.mRestrictionsManager.getSavedAppRestrictions().isEmpty()) {
                boolean zIsRestrictionsValid = false;
                try {
                    zContainsMandatoryKey = this.mRestrictionsManager.containsMandatoryKey(alteredAppRestrictionKeys);
                    try {
                        zIsRestrictionsValid = this.mRestrictionsManager.isRestrictionsValid(latestAppRestrictions);
                    } catch (RuntimeException e) {
                        e = e;
                        BoxLogUtils.logException(IUserContextManager.LOGOUT_CURRENT_USER, "App initialization error. Cause: context.getResources() is null", e);
                        this.mUserContextManager.destroyUser();
                    }
                } catch (RuntimeException e2) {
                    e = e2;
                    zContainsMandatoryKey = false;
                }
                if (zContainsMandatoryKey || !zIsRestrictionsValid) {
                    BoxLogUtils.e(IUserContextManager.LOGOUT_CURRENT_USER, "App Restrictions check failed");
                    this.mUserContextManager.destroyUser();
                    return;
                }
                BoxLogUtils.d("AndroidForWork", "App restrictions have been updated and do not require logout.");
                this.mRestrictionsManager.setAppRestrictions();
                if (this.mUserContextManager.isValidUserAvailable()) {
                    this.mRestrictionsManager.commitAppRestrictions(latestAppRestrictions);
                }
            }
        }
    }

    private void handleCreation(Bundle bundle) {
        this.mMigration.migrateUsersIfNeeded(this.mUserContextManager, this.mGlobalSettings);
        this.mBoxSession.setUseWelcomeTour(!this.mUserContextManager.isSwitchingToNewUser() && (this instanceof BoxEntrypointActivity));
        if (shouldFinishActivity(handleUserContextSetup())) {
            finish();
            return;
        }
        repairSessionUserIdIfNeeded();
        onBoxCreate(bundle);
        if (isDifferentUserAccessed() && onDifferentUserAccessed()) {
            return;
        }
        onBoxInitialize(bundle);
        if (this.mIsStarted) {
            onBoxStart();
        }
        this.mIsBoxCreated = true;
    }

    private boolean handleUserContextSetup() {
        String lastAuthenticatedUserId = BoxAuthentication.getInstance().getLastAuthenticatedUserId(this);
        if (this.mUserContextManager.isSwitchingToNewUser()) {
            setActivityUserId("");
            return false;
        }
        if (isActiveAuthenticatedUser(lastAuthenticatedUserId)) {
            setActivityUserId(lastAuthenticatedUserId);
            validateAndCreateUser(lastAuthenticatedUserId);
            return false;
        }
        BoxLogUtils.v("mUserContextManager.isSwitchingOrDestroyingUser() " + this.mUserContextManager.isSwitchingOrDestroyingUser() + " TextUtils.isEmpty(lastAuthenticatedUserId) " + TextUtils.isEmpty(lastAuthenticatedUserId) + " SdkUtils.isBlank(mBoxSession.getUserId()) " + SdkUtils.isBlank(this.mBoxSession.getUserId()));
        return true;
    }

    private boolean isActiveAuthenticatedUser(String str) {
        return (this.mUserContextManager.isSwitchingOrDestroyingUser() || TextUtils.isEmpty(str) || SdkUtils.isBlank(this.mBoxSession.getUserId())) ? false : true;
    }

    private void validateAndCreateUser(String str) {
        if (!str.equals(this.mBoxSession.getUserId())) {
            BoxLogUtils.d("BoxFragmentActivity.error userid and lastAuthenticated do not match");
            if (BuildConfigProvider.INSTANCE.isDebugBuild()) {
                BoxLogUtils.v("BoxFragmentActivity.handleCreation lastAuthUserId " + str + " session user id  " + this.mBoxSession.getUserId());
            }
        }
        try {
            this.mUserContextManager.createUser(this.mBoxSession.getUserId(), this.mBoxApiPrivate);
        } catch (IUserContextComponent.UserContextComponentCreationException e) {
            BoxLogUtils.e(e);
        }
    }

    private boolean shouldFinishActivity(boolean z) {
        boolean z2 = requiresAuthToken() && !hasAuthentication();
        BoxLogUtils.v("BoxFragmentActivity.handleCreation", "failedAuthCheck " + z2 + " isOtherCreation " + z + " " + this + " has valid user id " + this.mUserContextManager.hasValidUserId());
        return z2;
    }

    private void repairSessionUserIdIfNeeded() {
        if (SdkUtils.isBlank(this.mBoxSession.getUserId()) && this.mUserContextManager.hasValidUserId()) {
            logSessionRepairDebugInfo();
            this.mBoxSession.setUserId(this.mUserContextManager.getCurrentContextId());
        }
    }

    private void logSessionRepairDebugInfo() {
        BoxLogUtils.v("BoxFragmentActivity.handleCreation", "session has user" + (this.mBoxSession.getUser() != null));
        if (this.mBoxSession.getUser() != null) {
            BoxLogUtils.v("BoxFragmentActivity.handleCreation", "session has user id? " + (true ^ SdkUtils.isBlank(this.mBoxSession.getUser().getUserId())));
            if (!SdkUtils.isBlank(this.mBoxSession.getUser().getUserId())) {
                BoxLogUtils.v("BoxFragmentActivity.handleCreation", "user ids equal? " + this.mBoxSession.getUser().getUserId().equals(this.mUserContextManager.getCurrentContextId()) + " " + this.mBoxSession.getUser().getUserId().length() + " contextId " + this.mUserContextManager.getCurrentContextId());
            }
        }
        if (this.mBoxSession.getDebuggingException() != null) {
            BoxLogUtils.e(this.mBoxSession.getDebuggingException());
        }
        BoxLogUtils.v("BoxFragmentActivity.handleCreation", "session repair needed " + this.mBoxSession);
    }

    private boolean isSwitchingUsers() {
        return this.mUserContextManager.isSwitchingOrDestroyingUser();
    }

    protected boolean isDifferentUserAccessed() {
        if (requiresAuthToken()) {
            return getActivityUserId() == null || !getActivityUserId().equals(this.mUserContextManager.getCurrentContextId());
        }
        return false;
    }

    protected void setActivityUserId(String str) {
        this.mActivityUserId = str;
    }

    protected String getActivityUserId() {
        return this.mActivityUserId;
    }

    protected boolean onDifferentUserAccessed() {
        finish();
        return true;
    }

    protected void onSwitchedUser(BoxSwitchUserMessage boxSwitchUserMessage) {
        if (this.mDelayCreationTillUserChanged) {
            handleCreation(this.mDelayCreationSavedInstanceState);
            this.mDelayCreationTillUserChanged = false;
            onBoxResume();
        }
    }

    public final boolean hasAuthentication() {
        CustomBoxSession customBoxSession = this.mBoxSession;
        boolean z = (customBoxSession == null || customBoxSession.getAuthInfo() == null || TextUtils.isEmpty(this.mBoxSession.getAuthInfo().accessToken()) || !this.mUserContextManager.hasValidUserId()) ? false : true;
        if (z && SdkUtils.isBlank(this.mBoxSession.getUserId())) {
            BoxLogUtils.e("hasAuthentication.no UserId  " + getClass() + " hasAccessToken ");
        }
        return z;
    }

    @Override // androidx.fragment.app.FragmentActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public final void onMAMResume() {
        if (CreatePincodeActivity.userHasSetPincode(this.mUserContextManager) || !CoreServiceUtils.getIsScreenCaptureAllowedByMAMPolicy()) {
            getWindow().addFlags(8192);
        } else {
            MAMWindowManagement.clearFlags(getWindow(), 8192);
        }
        validateAppRestrictions();
        registerReceiver(this.restrictionsReceiver, this.restrictionsFilter);
        super.onMAMResume();
        this.mIsResumed = true;
        if (this.mDelayCreationTillUserChanged) {
            return;
        }
        onBoxResume();
    }

    @Override // androidx.fragment.app.FragmentActivity
    protected void onResumeFragments() {
        if (!requiresAuthToken() || hasAuthentication()) {
            super.onResumeFragments();
        }
    }

    protected void handleOnActivityResult(int i, int i2, Intent intent) {
        this.mLaunchIntoCapture.clearPending();
    }

    @Override // androidx.activity.ComponentActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public final void onMAMNewIntent(Intent intent) {
        super.onMAMNewIntent(intent);
        handleOnNewIntent(intent);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public final void onMAMActivityResult(int i, int i2, Intent intent) {
        handleOnActivityResult(i, i2, intent);
        super.onMAMActivityResult(i, i2, intent);
    }

    public void onBoxResume() {
        if (requiresAuthToken() && !hasAuthentication()) {
            finish();
            return;
        }
        restoreSharedLinkIfAvailable();
        if (isDifferentUserAccessed() && onDifferentUserAccessed()) {
            return;
        }
        this.mPassedPinCodeUsers.remove(this.mUserContextManager.getCurrentContextId());
        if (showIntuneAuth()) {
            return;
        }
        handlePinCodeRequirements();
        amplitudeSetCurrentPage();
        handleCaptureLaunch();
        this.forceUpdateCoordinator.enforceIfNeeded();
        this.betaFeedbackManager.registerShakeDetectionIfNeeded(this);
    }

    private void restoreSharedLinkIfAvailable() {
        if (getIntent() == null || SdkUtils.isBlank(getIntent().getStringExtra(EXTRA_SHAREDLINK_URL))) {
            return;
        }
        this.mBoxSession.setSharedLink(getIntent().getStringExtra(EXTRA_SHAREDLINK_URL));
        if (SdkUtils.isBlank(getIntent().getStringExtra(EXTRA_SHAREDLINK_PASSWORD))) {
            return;
        }
        this.mBoxSession.setPassword(getIntent().getStringExtra(EXTRA_SHAREDLINK_PASSWORD));
    }

    private void handlePinCodeRequirements() {
        if (requiresPinCode() && CreatePincodeActivity.userHasSetPincode(this.mUserContextManager)) {
            if (CoreServiceUtils.getIsPinRequiredByMAMPolicy()) {
                CreatePincodeActivity.clearPinCodeInformation(this.mUserContextManager);
            } else if (Pincode.shouldShow(this.mUserContextManager)) {
                showPinCodePrompt();
            } else {
                this.mPassedPinCodeUsers.add(this.mUserContextManager.getCurrentContextId());
                Pincode.enableWaitForIgnorePeriod(true, this.mUserContextManager);
            }
        }
    }

    private void showPinCodePrompt() {
        if (Pincode.shouldWaitForIgnorePeriod(this.mUserContextManager)) {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.box.android.base.presentation.activities.BoxFragmentActivity$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$showPinCodePrompt$1();
                }
            }, 300L);
        } else {
            Pincode.startPinCodeActivity(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showPinCodePrompt$1() {
        if (Pincode.shouldShow(this.mUserContextManager)) {
            Pincode.startPinCodeActivity(this);
        }
    }

    private void handleCaptureLaunch() {
        if (shouldHandleCaptureLaunch() && this.mLaunchIntoCapture.isPending()) {
            this.mLaunchIntoCapture.clearPending();
            Intent intent = new Intent("android.intent.action.VIEW", new Uri.Builder().scheme("boxapp").authority("capture").build());
            intent.setPackage("com.box.android");
            startActivity(intent);
        }
    }

    @Override // com.box.android.base.presentation.fragments.IBoxFragmentActivity
    public void logAnalyticsCurrentPage() {
        amplitudeSetCurrentPage();
    }

    public boolean showIntuneAuth() {
        boolean zShouldBlockUser = this.mIntuneAuthManager.shouldBlockUser();
        boolean zHasStoredAadId = this.mIntuneAuthManager.hasStoredAadId();
        BoxLogUtils.i(SHOW_INTUNE_AUTH_TAG, "shouldBlockUser=" + zShouldBlockUser + ", hasStoredAadId=" + zHasStoredAadId);
        if (!zShouldBlockUser) {
            return false;
        }
        if (this.mIntuneAuthManager.getEnrollmentInProgress()) {
            BoxLogUtils.i(SHOW_INTUNE_AUTH_TAG, "Enrollment already in progress, skipping");
            return false;
        }
        if (zHasStoredAadId) {
            BoxLogUtils.i(SHOW_INTUNE_AUTH_TAG, "User enrolled but has no policies, showing blocking UI");
            BoxIntuneMAMAuthActivity.startActivity(this, null, false, null, true);
        } else {
            BoxLogUtils.i(SHOW_INTUNE_AUTH_TAG, "First-time enrollment, starting automatic flow");
            BoxIntuneMAMAuthActivity.startActivity(this, null, false, null, false);
        }
        finish();
        return true;
    }

    @Override // androidx.fragment.app.FragmentActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMPause() {
        if (this.mPassedPinCodeUsers.contains(this.mUserContextManager.getCurrentContextId())) {
            Pincode.startIgnorePeriod(this.mUserContextManager);
            Pincode.enableWaitForIgnorePeriod(false, this.mUserContextManager);
        }
        this.betaFeedbackManager.unregisterShakeDetectionIfNeeded();
        unregisterReceiver(this.restrictionsReceiver);
        super.onMAMPause();
        this.mIsResumed = false;
    }

    @Override // com.box.android.base.presentation.activities.Hilt_BoxFragmentActivity, com.box.android.base.presentation.activities.BoxSpinnerDialogFragmentActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMDestroy() {
        destroyReceiver();
        ((IApplicationFragmentCallback) ApplicationProvider.application).onFragmentStopped();
        super.onMAMDestroy();
    }

    public void registerReceiver() {
        BoxFragmentActivityBroadcastReceiver boxFragmentActivityBroadcastReceiver = new BoxFragmentActivityBroadcastReceiver();
        this.mControllerReceiver = boxFragmentActivityBroadcastReceiver;
        LocalBroadcastManager localBroadcastManager = this.mLocalBroadcastManager;
        if (localBroadcastManager != null) {
            localBroadcastManager.registerReceiver(boxFragmentActivityBroadcastReceiver, getIntentFilter());
        }
    }

    public void destroyReceiver() {
        LocalBroadcastManager localBroadcastManager;
        BroadcastReceiver broadcastReceiver = this.mControllerReceiver;
        if (broadcastReceiver == null || (localBroadcastManager = this.mLocalBroadcastManager) == null) {
            return;
        }
        localBroadcastManager.unregisterReceiver(broadcastReceiver);
    }

    public IntentFilter getIntentFilter() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(BoxSwitchUserMessage.ACTION_CLEARED_USER);
        intentFilter.addAction(BoxSwitchUserMessage.ACTION_DESTROYED_USER);
        intentFilter.addAction(BoxSwitchUserMessage.ACTION_SWITCHED_USER);
        intentFilter.addAction(CoreServiceUtils.GRAPH_QL_UPDATE_ACTION);
        return intentFilter;
    }

    public BoxUser getUserInfo() {
        return this.mUserContextManager.getBoxSession(ApplicationProvider.application).getUser();
    }

    protected SharedPreferences getUserSharedPrefs() {
        return ((ILocalSharedPreferences) this.mUserContextManager.getCurrentContext().getUserContextComponent(IUserContext.UserContextComponent.LOCAL_SHARED_PREFERENCES)).getSharedPreferences();
    }

    @Override // com.box.android.base.presentation.activities.BoxSpinnerDialogFragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMSaveInstanceState(Bundle bundle) {
        bundle.putString(EXTRA_USER_CONTEXT_ID, getActivityUserId());
        super.onMAMSaveInstanceState(bundle);
    }

    public class BoxFragmentActivityBroadcastReceiver extends MAMBroadcastReceiver {
        public BoxFragmentActivityBroadcastReceiver() {
        }

        @Override // com.microsoft.intune.mam.client.content.HookedBroadcastReceiver
        public final void onMAMReceive(Context context, Intent intent) {
            if (BoxFragmentActivity.this.isFinishing()) {
                return;
            }
            if (intent instanceof BoxSwitchUserMessage) {
                BoxSwitchUserMessage boxSwitchUserMessage = (BoxSwitchUserMessage) intent;
                String action = intent.getAction();
                if (action.equals(BoxSwitchUserMessage.ACTION_DESTROYED_USER) || action.equals(BoxSwitchUserMessage.ACTION_CLEARED_USER)) {
                    BoxFragmentActivity.this.finish();
                } else if (action.equals(BoxSwitchUserMessage.ACTION_SWITCHED_USER)) {
                    BoxFragmentActivity.this.onSwitchedUser(boxSwitchUserMessage);
                }
            }
            if ((intent instanceof BoxMessage) && BoxFragmentActivity.this.mUserContextManager.hasValidUserId()) {
                BoxFragmentActivity.this.processBoxMessage((BoxMessage) intent);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean isActivityResumed() {
        return this.mIsResumed;
    }

    private void updateAuthInfo(BoxUserAuthenticationMessage boxUserAuthenticationMessage) {
        if (boxUserAuthenticationMessage.wasSuccessful()) {
            BoxUser payload = boxUserAuthenticationMessage.getPayload();
            try {
                this.mUserContextManager.createUser(payload.getUserId(), this.mBoxApiPrivate);
            } catch (IUserContextComponent.UserContextComponentCreationException e) {
                BoxLogUtils.e("updateAuthInfo", e);
            }
            this.mUserContextManager.setUserInfo(payload);
            this.mSplitConfiguration.init(payload);
            this.clientSettingsInitialisation.init();
            BoxAmplitudeAnalytics.UserPropertyBuilder userPropertyBuilder = new BoxAmplitudeAnalytics.UserPropertyBuilder();
            userPropertyBuilder.setUser(payload);
            userPropertyBuilder.updateUserProperties();
            if (this instanceof BoxEntrypointActivity) {
                ((BoxEntrypointActivity) this).onAuthenticated(boxUserAuthenticationMessage);
            }
        }
    }

    public void displaySnackbar(String str, int i, View view, View.OnClickListener onClickListener) {
        if (view != null) {
            view.setVisibility(0);
            Object parent = view.getParent();
            if ((parent instanceof View) && ((View) parent).getAlpha() == 0.0f) {
                Toast.makeText(this, str, 1).show();
                return;
            }
        }
        BoxPresentationUtils.displaySnackBar(this, view, str, i, onClickListener);
    }

    public void onActionModeCreated(ActionMode.Callback callback) {
        this.mIsInActionModeFlow.setValue(true);
    }

    public void onActionModeDestroyed(ActionMode.Callback callback) {
        this.mIsInActionModeFlow.setValue(false);
    }

    protected boolean isLightModeEnabled() {
        return (getResources().getConfiguration().uiMode & 48) != 32;
    }

    public StateFlow<Boolean> getIsInActionModeFlow() {
        return this.mIsInActionModeFlow;
    }
}
