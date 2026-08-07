package com.box.android.usercontext;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.box.android.application.BoxBaseApplication;
import com.box.android.common.utilities.BuildConfigProvider;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.controller.AndroidForWorkController;
import com.box.android.coreservices.modelcontroller.IMoCoBoxGlobalSettings;
import com.box.android.coreservices.modelcontroller.messages.BoxLocalUsersDataMessage;
import com.box.android.coreservices.modelcontroller.messages.BoxSwitchUserMessage;
import com.box.android.coreservices.modelcontroller.messages.Controller;
import com.box.android.coreservices.models.BoxAccountManager;
import com.box.android.coreservices.models.CustomBoxSession;
import com.box.android.coreservices.utilities.intune.IntuneAuthManager;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.analytics.PendoAnalytics;
import com.box.android.domain.configuration.BoxConfigConstants;
import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.identity.DeviceId;
import com.box.android.domain.identity.IUserContextComponent;
import com.box.android.domain.identity.IUserContextComponentListener;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.localrepo.IBoxStorage;
import com.box.android.domain.localrepo.ILocalSharedPreferences;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.services.IAppRestrictionsManager;
import com.box.android.domain.services.IBVEManager;
import com.box.android.domain.usecases.observability.MetricsUseCase;
import com.box.android.domain.usecases.pushnotifications.RegisterPushDeviceUseCase;
import com.box.android.domain.usecases.pushnotifications.UpdateDeviceRegistrationUseCase;
import com.box.android.domain.utils.result.Result;
import com.box.android.localrepo.BoxStorage;
import com.box.android.localrepo.LocalAuthStorage;
import com.box.android.models.BoxSessionFactory;
import com.box.android.pushnotification.PushNotifRegistrationController;
import com.box.android.receiver.DelayedNotificationReceiver;
import com.box.android.workers.AutoUploadUriTriggerWorker;
import com.box.androidsdk.content.BoxException;
import com.box.androidsdk.content.auth.BoxAuthentication;
import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.models.BoxUser;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.box.androidsdk.content.utils.SdkUtils;
import com.box.androidsdk.content.utils.logging.FileTree;
import com.box.boxandroidlibv2private.dao.BoxFeatures;
import com.box.boxandroidlibv2private.resourcemanagers.BoxApiPrivate;
import com.google.firebase.iid.FirebaseInstanceId;
import dagger.Lazy;
import java.lang.ref.SoftReference;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: loaded from: classes13.dex */
@Singleton
public class UserContextManager implements IUserContextManager, BoxAuthentication.AuthListener {
    public static final int USER_CREATE_NEW = 3;
    public static final int USER_DESTROYING = 1;
    public static final int USER_SET = 0;
    public static final int USER_SWITCHING = 2;
    private final AndroidForWorkController mAfWController;
    BoxApiPrivate mApiPrivate;
    private final Context mAppContext;
    LocalAuthStorage mAuthStorage;
    protected CustomBoxSession mBoxSession;
    protected BoxSessionFactory mBoxSessionFactory;
    private final IBVEManager mBveManager;
    private final DeviceId mDeviceId;
    private final Lazy<FeatureFlips> mFeatureFlips;
    private final IMoCoBoxGlobalSettings mGlobalSettings;
    private final Lazy<IntuneAuthManager> mIntuneAuthManager;
    private final Lazy<MetricsUseCase> mMetricsUseCase;
    private final Lazy<RegisterPushDeviceUseCase> mRegisterPushDeviceUseCase;
    private final IAppRestrictionsManager mRestrictionsManager;
    protected IBoxStorage mStorage;
    private final Lazy<UpdateDeviceRegistrationUseCase> mUpdateDeviceRegistrationUseCase;
    protected final UserContext mUserContext;
    private final ConcurrentHashMap<String, SoftReference<IUserContextComponentListener>> mListenerComponents = new ConcurrentHashMap<>();
    private final String mLogoutMsg = null;
    private final AtomicInteger userContextState = new AtomicInteger(0);

    @Override // com.box.androidsdk.content.auth.BoxAuthentication.AuthListener
    public void onAuthCreated(BoxAuthentication.BoxAuthenticationInfo boxAuthenticationInfo) {
    }

    @Override // com.box.androidsdk.content.auth.BoxAuthentication.AuthListener
    public void onRefreshed(BoxAuthentication.BoxAuthenticationInfo boxAuthenticationInfo) {
    }

    @Inject
    public UserContextManager(Context context, AndroidForWorkController androidForWorkController, IMoCoBoxGlobalSettings iMoCoBoxGlobalSettings, DeviceId deviceId, BoxSessionFactory boxSessionFactory, Lazy<RegisterPushDeviceUseCase> lazy, Lazy<UpdateDeviceRegistrationUseCase> lazy2, Lazy<MetricsUseCase> lazy3, IAppRestrictionsManager iAppRestrictionsManager, IBVEManager iBVEManager, Lazy<FeatureFlips> lazy4, Lazy<IntuneAuthManager> lazy5) {
        this.mAppContext = context;
        this.mGlobalSettings = iMoCoBoxGlobalSettings;
        this.mAuthStorage = new LocalAuthStorage(iMoCoBoxGlobalSettings);
        this.mUserContext = boxSessionFactory.getUserContext();
        this.mAfWController = androidForWorkController;
        this.mDeviceId = deviceId;
        this.mBoxSessionFactory = boxSessionFactory;
        this.mRegisterPushDeviceUseCase = lazy;
        this.mUpdateDeviceRegistrationUseCase = lazy2;
        this.mMetricsUseCase = lazy3;
        this.mRestrictionsManager = iAppRestrictionsManager;
        this.mBveManager = iBVEManager;
        this.mFeatureFlips = lazy4;
        this.mIntuneAuthManager = lazy5;
        BoxAuthentication.getInstance().addListener(this);
        setupFileLogger();
    }

    @Override // com.box.androidsdk.content.auth.BoxAuthentication.AuthListener
    public void onLoggedOut(BoxAuthentication.BoxAuthenticationInfo boxAuthenticationInfo, Exception exc) {
        this.mBveManager.setVerifiedEnterprise(false);
        this.mBveManager.setVerifiedEnterpriseDomain(null);
    }

    @Override // com.box.androidsdk.content.auth.BoxAuthentication.AuthListener
    public void onAuthFailure(BoxAuthentication.BoxAuthenticationInfo boxAuthenticationInfo, Exception exc) {
        if (isRefreshFailureAndFatal(boxAuthenticationInfo, exc)) {
            logAuthFailureDebugInfo(boxAuthenticationInfo, exc);
            String userIdFromInfo = getUserIdFromInfo(boxAuthenticationInfo);
            if (userIdFromInfo != null && userIdFromInfo.equals(getCurrentContextId())) {
                BoxLogUtils.e(IUserContextManager.LOGOUT_CURRENT_USER, "Token refresh failed. Error Type: " + ((BoxException.RefreshFailure) exc).getErrorType());
                destroyUser(getCurrentContextId());
            } else {
                destroyOtherUser(boxAuthenticationInfo);
            }
        }
    }

    private boolean isRefreshFailureAndFatal(BoxAuthentication.BoxAuthenticationInfo boxAuthenticationInfo, Exception exc) {
        return boxAuthenticationInfo != null && (exc instanceof BoxException.RefreshFailure) && ((BoxException.RefreshFailure) exc).isErrorFatal();
    }

    private void logAuthFailureDebugInfo(BoxAuthentication.BoxAuthenticationInfo boxAuthenticationInfo, Exception exc) {
        if (BuildConfigProvider.INSTANCE.isDebugBuild()) {
            try {
                String str = "onAuthFailure fatal auth " + exc + " \n";
                if (this.mBoxSession.getAuthInfo() != null) {
                    str = str + "currentAuth " + this.mBoxSession.getAuthInfo().toJson() + "\n";
                }
                if (this.mBoxSession.getUser() != null) {
                    str = str + "user " + this.mBoxSession.getUser().toJson() + "\n";
                }
                CommonBoxUtil.writeToFile(CommonBoxUtil.getCrashReportFile(), str + "info " + boxAuthenticationInfo.toJson() + "\n", true, true);
            } catch (Exception unused) {
            }
        }
    }

    private String getUserIdFromInfo(BoxAuthentication.BoxAuthenticationInfo boxAuthenticationInfo) {
        if (boxAuthenticationInfo.getUser() != null) {
            return boxAuthenticationInfo.getUser().getUserId();
        }
        return null;
    }

    private void destroyOtherUser(BoxAuthentication.BoxAuthenticationInfo boxAuthenticationInfo) {
        if (boxAuthenticationInfo.getUser() != null) {
            UserContext userContext = new UserContext(this.mAppContext);
            userContext.onCreate(boxAuthenticationInfo.getUser().getUserId());
            userContext.onHardDestroy();
        }
    }

    @Override // com.box.android.domain.identity.IUserContextManager
    public String getCurrentContextId() {
        return this.mUserContext.getContextId();
    }

    @Override // com.box.android.domain.identity.IUserContextManager
    public boolean isValidUserAvailable() {
        return (isSwitchingOrDestroyingUser() || "-1".equals(getCurrentContextId())) ? false : true;
    }

    @Override // com.box.android.domain.identity.IUserContextManager
    public void softSwitch(String str) {
        this.userContextState.set(2);
        this.mUserContext.onSoftDestroy();
        if (!SdkUtils.isBlank(str)) {
            notifyListenersOnSoftDestroy();
            switchToNewContext(str);
        } else {
            clearUserContext();
            notifyListenersOnSoftDestroy();
        }
        sendUserSwitchBroadcast(str);
    }

    private void switchToNewContext(String str) {
        this.mUserContext.onCreate(str);
        updateBoxSession(str);
        if (hasValidUserId() && this.mBoxSession.getUser() != null) {
            setupAnalytics();
        }
        startPushNotificationHandlingThread(str);
    }

    private void updateBoxSession(String str) {
        this.mBoxSession.setAuthInfo(new BoxSession(this.mAppContext, str, this.mBoxSession.getClientId(), this.mBoxSession.getClientSecret(), this.mBoxSession.getRedirectUrl(), this.mBoxSession.isAppFedrampHighCompliant()).getAuthInfo());
        this.mAuthStorage.storeLastAuthenticatedUserId(str, this.mAppContext);
        updatePreviewStorage();
    }

    private void setupAnalytics() {
        setupAmplitude();
        PendoAnalytics.INSTANCE.startSession(this.mBoxSession.getUser());
        setupLoggers();
    }

    private void clearUserContext() {
        this.mBoxSession.setAuthInfo(null);
        this.mAuthStorage.storeLastAuthenticatedUserId(null, this.mAppContext);
    }

    private void startPushNotificationHandlingThread(final String str) {
        new Thread(new Runnable() { // from class: com.box.android.usercontext.UserContextManager$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$startPushNotificationHandlingThread$0(str);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startPushNotificationHandlingThread$0(String str) {
        if (this.mApiPrivate != null) {
            notifyListenersOnCreate(str);
            tryRegisterForPushNotification(this.mApiPrivate);
            processDelayedNotifications(str);
        }
    }

    private void processDelayedNotifications(String str) {
        try {
            if (!str.equals("-1") && getCurrentContext().getKVStore().hasDB() && getCurrentContext().getKVStore().getLastKnowContextId().equals(str)) {
                DelayedNotificationReceiver.notify(BoxBaseApplication.getInstance(), false, null);
            }
        } catch (Exception e) {
            BoxLogUtils.logException("UserContextManager.softSwitch userNotificationManager", "failed to update", e);
        }
    }

    private void sendUserSwitchBroadcast(String str) {
        BoxSwitchUserMessage boxSwitchUserMessage = new BoxSwitchUserMessage(BoxSwitchUserMessage.ACTION_SWITCHED_USER);
        boxSwitchUserMessage.setPayload((Boolean) true);
        if (TextUtils.isEmpty(str)) {
            boxSwitchUserMessage.setSwitchToUserId("");
            this.userContextState.set(3);
        } else {
            boxSwitchUserMessage.setSwitchToUserId(str);
            updateAutoUploadServices();
            this.userContextState.set(0);
        }
        LocalBroadcastManager.getInstance(this.mAppContext).sendBroadcast(boxSwitchUserMessage);
    }

    private void updateAutoUploadServices() {
        AutoUploadUriTriggerWorker.toggleServices(getCurrentContext().getLocalAutoContentUploadInformation());
    }

    @Override // com.box.android.domain.identity.IUserContextManager
    public boolean isSwitchingOrDestroyingUser() {
        int i = this.userContextState.get();
        return i == 2 || i == 1;
    }

    @Override // com.box.android.domain.identity.IUserContextManager
    public boolean isSwitchingToNewUser() {
        return this.userContextState.get() == 3;
    }

    @Override // com.box.android.domain.identity.IUserContextManager
    public void expireAccessTokenForDebug() {
        this.mBoxSession.getAuthInfo().setAccessToken("expired_debug_token");
        this.mBoxSession.getAuthInfo().setRefreshToken("expired_debug_refresh_token");
    }

    @Override // com.box.android.domain.identity.IUserContextManager
    public void destroyUser() {
        destroyUser(null);
    }

    @Override // com.box.android.domain.identity.IUserContextManager
    public void destroyUser(final String str) {
        BuildersKt.launch(GlobalScope.INSTANCE, Dispatchers.getMain(), CoroutineStart.DEFAULT, new Function2() { // from class: com.box.android.usercontext.UserContextManager$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return this.f$0.lambda$destroyUser$1(str, (CoroutineScope) obj, (Continuation) obj2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$destroyUser$1(final String str, CoroutineScope coroutineScope, Continuation continuation) {
        return this.mMetricsUseCase.get().uploadMetricsOnLogOut(str, new Continuation<Result<Unit, ? extends DomainError>>() { // from class: com.box.android.usercontext.UserContextManager.1
            @Override // kotlin.coroutines.Continuation
            public CoroutineContext getContext() {
                return EmptyCoroutineContext.INSTANCE;
            }

            @Override // kotlin.coroutines.Continuation
            public void resumeWith(Object obj) {
                UserContextManager.this.removeUser(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeUser(String str) {
        boolean z = true;
        if (this.userContextState.getAndSet(1) == 1) {
            return;
        }
        intuneLogoutCheck();
        PendoAnalytics.INSTANCE.endSession();
        if (str == null) {
            str = this.mBoxSession.getUserId() != null ? this.mBoxSession.getUserId() : "-1";
        }
        try {
            this.mBoxSession.logout().get();
        } catch (InterruptedException e) {
            BoxLogUtils.logException(e);
            Thread.currentThread().interrupt();
        } catch (ExecutionException e2) {
            BoxLogUtils.logException(e2);
        }
        try {
            IMoCoBoxGlobalSettings iMoCoBoxGlobalSettings = this.mGlobalSettings;
            if (iMoCoBoxGlobalSettings != null) {
                iMoCoBoxGlobalSettings.removeUserData(str).get();
            }
        } catch (InterruptedException e3) {
            BoxLogUtils.logException(e3);
            Thread.currentThread().interrupt();
        } catch (ExecutionException e4) {
            BoxLogUtils.logException(e4);
        }
        this.mAfWController.resetConfigsWithLatestRestrictions();
        notifyListenersOnHardDestroy();
        this.mUserContext.onHardDestroy();
        BoxSwitchUserMessage boxSwitchUserMessage = new BoxSwitchUserMessage(BoxSwitchUserMessage.ACTION_DESTROYED_USER);
        boxSwitchUserMessage.setPayload((Boolean) true);
        if (!BoxBaseApplication.getInstance().getConfigManager().getBoolean(BoxConfigConstants.CONFIG_KEY_KILL_APP_ON_LOGOUT_BOOL).booleanValue() && !BoxBaseApplication.getInstance().shouldKillAppOnSignout()) {
            z = false;
        }
        boxSwitchUserMessage.putExtra(Controller.ARG_KILL_PROCESS_AT_LOGOUT, z);
        boxSwitchUserMessage.putExtra(Controller.ARG_CUSTOM_LOGOUT_MSG, this.mLogoutMsg);
        LocalBroadcastManager.getInstance(this.mAppContext).sendBroadcast(boxSwitchUserMessage);
        this.userContextState.set(0);
    }

    private void intuneLogoutCheck() {
        if (BoxAccountManager.isIntuneMAMEnabled(getUserSharedPrefs())) {
            this.mIntuneAuthManager.get().signOutUser();
        }
    }

    @Override // com.box.android.domain.identity.IUserContextManager
    public void destroyAllUsers() {
        BuildersKt.launch(GlobalScope.INSTANCE, Dispatchers.getMain(), CoroutineStart.DEFAULT, new Function2() { // from class: com.box.android.usercontext.UserContextManager$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return this.f$0.lambda$destroyAllUsers$2((CoroutineScope) obj, (Continuation) obj2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$destroyAllUsers$2(CoroutineScope coroutineScope, Continuation continuation) {
        return this.mMetricsUseCase.get().uploadMetricsOnLogOutAllUsers(new Continuation<Result<Unit, ? extends DomainError>>() { // from class: com.box.android.usercontext.UserContextManager.2
            @Override // kotlin.coroutines.Continuation
            public CoroutineContext getContext() {
                return EmptyCoroutineContext.INSTANCE;
            }

            @Override // kotlin.coroutines.Continuation
            public void resumeWith(Object obj) {
                UserContextManager.this.removeAllUsers();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeAllUsers() {
        if (this.userContextState.getAndSet(1) == 1) {
            return;
        }
        intuneLogoutCheck();
        PendoAnalytics.INSTANCE.endSession();
        BoxSwitchUserMessage boxSwitchUserMessageCreateDestroyedUserMessage = createDestroyedUserMessage();
        processAllUserData(boxSwitchUserMessageCreateDestroyedUserMessage);
        cleanupAndBroadcast(boxSwitchUserMessageCreateDestroyedUserMessage);
    }

    private BoxSwitchUserMessage createDestroyedUserMessage() {
        BoxSwitchUserMessage boxSwitchUserMessage = new BoxSwitchUserMessage(BoxSwitchUserMessage.ACTION_DESTROYED_USER);
        boxSwitchUserMessage.setPayload((Boolean) true);
        return boxSwitchUserMessage;
    }

    private void processAllUserData(BoxSwitchUserMessage boxSwitchUserMessage) {
        Iterable<BoxAuthentication.BoxAuthenticationInfo> iterableFetchAllUsersData = fetchAllUsersData(boxSwitchUserMessage);
        if (iterableFetchAllUsersData != null) {
            processEachUser(iterableFetchAllUsersData, boxSwitchUserMessage);
        }
    }

    private Iterable<BoxAuthentication.BoxAuthenticationInfo> fetchAllUsersData(BoxSwitchUserMessage boxSwitchUserMessage) {
        try {
            return ((BoxLocalUsersDataMessage) this.mGlobalSettings.getAllUsersData().get()).getPayload();
        } catch (InterruptedException e) {
            BoxLogUtils.e("UserContextManager remove all users", "Thread was interrupted", e);
            boxSwitchUserMessage.setException(e);
            boxSwitchUserMessage.setPayload((Boolean) false);
            Thread.currentThread().interrupt();
            return null;
        } catch (Exception e2) {
            boxSwitchUserMessage.setException(e2);
            boxSwitchUserMessage.setPayload((Boolean) false);
            return null;
        }
    }

    private void processEachUser(Iterable<BoxAuthentication.BoxAuthenticationInfo> iterable, BoxSwitchUserMessage boxSwitchUserMessage) {
        Iterator<BoxAuthentication.BoxAuthenticationInfo> it = iterable.iterator();
        while (it.hasNext()) {
            BoxUser user = it.next().getUser();
            removeUserData(user, boxSwitchUserMessage);
            if (user != null) {
                this.mUserContext.onCreate(user.getUserId());
            }
            this.mUserContext.onHardDestroy();
        }
    }

    private void removeUserData(BoxUser boxUser, BoxSwitchUserMessage boxSwitchUserMessage) {
        try {
            this.mGlobalSettings.removeUserData(boxUser.getUserId()).get();
        } catch (InterruptedException e) {
            BoxLogUtils.e("UserContextManager remove all users", "Thread was interrupted", e);
            boxSwitchUserMessage.setException(e);
            boxSwitchUserMessage.setPayload((Boolean) false);
            Thread.currentThread().interrupt();
        } catch (Exception e2) {
            boxSwitchUserMessage.setException(e2);
            boxSwitchUserMessage.setPayload((Boolean) false);
        }
    }

    private void cleanupAndBroadcast(BoxSwitchUserMessage boxSwitchUserMessage) {
        BoxAuthentication.getInstance().logoutAllUsers(this.mAppContext, this.mRestrictionsManager.isAppFedrampHighCompliant());
        this.mAfWController.resetConfigsWithLatestRestrictions();
        notifyListenersOnHardDestroy();
        addKillProcessExtras(boxSwitchUserMessage);
        LocalBroadcastManager.getInstance(this.mAppContext).sendBroadcast(boxSwitchUserMessage);
        this.userContextState.set(3);
    }

    private void addKillProcessExtras(BoxSwitchUserMessage boxSwitchUserMessage) {
        boxSwitchUserMessage.putExtra(Controller.ARG_KILL_PROCESS_AT_LOGOUT, BoxBaseApplication.getInstance().getConfigManager().getBoolean(BoxConfigConstants.CONFIG_KEY_KILL_APP_ON_LOGOUT_BOOL).booleanValue() || BoxBaseApplication.getInstance().shouldKillAppOnSignout());
    }

    @Override // com.box.android.domain.identity.IUserContextManager
    public UserContext getCurrentContext() {
        return this.mUserContext;
    }

    @Override // com.box.android.domain.identity.IUserContextManager
    public synchronized void createUser(String str, final BoxApiPrivate boxApiPrivate) throws IUserContextComponent.UserContextComponentCreationException {
        final String str2;
        if (getCurrentContextId() == null || !getCurrentContextId().equals(str)) {
            if (this.mBoxSession != null) {
                str2 = str;
                this.mBoxSession.setAuthInfo(new BoxSession(this.mAppContext, str2, this.mBoxSession.getClientId(), this.mBoxSession.getClientSecret(), this.mBoxSession.getRedirectUrl(), this.mBoxSession.isAppFedrampHighCompliant()).getAuthInfo());
                this.mAuthStorage.storeLastAuthenticatedUserId(str2, this.mAppContext);
            } else {
                str2 = str;
            }
            this.mApiPrivate = boxApiPrivate;
            this.mUserContext.onCreate(str2);
            updatePreviewStorage();
            new Thread(new Runnable() { // from class: com.box.android.usercontext.UserContextManager$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$createUser$3(str2, boxApiPrivate);
                }
            }).start();
            if (hasValidUserId()) {
                this.userContextState.set(0);
                if (this.mBoxSession.getUser() != null) {
                    PendoAnalytics.INSTANCE.startSession(this.mBoxSession.getUser());
                    setupAmplitude();
                    setupLoggers();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createUser$3(String str, BoxApiPrivate boxApiPrivate) {
        CustomBoxSession customBoxSession;
        notifyListenersOnCreate(str);
        if (!hasValidUserId() || (customBoxSession = this.mBoxSession) == null || customBoxSession.getAuthInfo() == null || SdkUtils.isBlank(this.mBoxSession.getAuthInfo().accessToken())) {
            return;
        }
        tryRegisterForPushNotification(boxApiPrivate);
    }

    private void setupAmplitude() {
        BoxAmplitudeAnalytics.UserPropertyBuilder userPropertyBuilder = new BoxAmplitudeAnalytics.UserPropertyBuilder();
        userPropertyBuilder.setUser(this.mBoxSession.getUser());
        userPropertyBuilder.updateUserProperties();
    }

    private void setupFileLogger() {
        BoxLogUtils.setLoggers(new FileTree(BoxBaseApplication.getInstance().getApplicationContext(), BoxBaseApplication.getInstance().getSharedPreferences(ILocalSharedPreferences.PreferenceName.OBSERVABILITY.name(), 0).getInt(BoxLogUtils.MIN_FILE_LOGGING_LEVEL, 4)));
    }

    private void setupLoggers() {
        setLoggerUserProperties();
    }

    private void setLoggerUserProperties() {
        BoxUser user;
        CustomBoxSession customBoxSession = this.mBoxSession;
        if (customBoxSession == null || (user = customBoxSession.getUser()) == null) {
            return;
        }
        BoxLogUtils.logUserProperties(user.getUserId(), user.getEnterprise() != null ? user.getEnterprise().getUserId() : null);
    }

    private void tryRegisterForPushNotification(BoxApiPrivate boxApiPrivate) {
        String token = FirebaseInstanceId.getInstance().getToken();
        if (TextUtils.isEmpty(token)) {
            return;
        }
        new PushNotifRegistrationController(boxApiPrivate, this, this.mRegisterPushDeviceUseCase.get(), this.mUpdateDeviceRegistrationUseCase.get(), this.mFeatureFlips.get(), this.mGlobalSettings).registerWithBoxServer(token);
    }

    @Override // com.box.android.domain.identity.IUserContextManager
    public void updatePushNotificationsLocale(BoxApiPrivate boxApiPrivate) {
        new PushNotifRegistrationController(boxApiPrivate, this, this.mRegisterPushDeviceUseCase.get(), this.mUpdateDeviceRegistrationUseCase.get(), this.mFeatureFlips.get(), this.mGlobalSettings).onLocaleChanged();
    }

    @Override // com.box.android.domain.identity.IUserContextManager
    public SharedPreferences getUserSharedPrefs() {
        return getCurrentContext().getLocalSharedPreferences().getSharedPreferences();
    }

    @Override // com.box.android.domain.identity.IUserContextManager
    public SharedPreferences getUserSharedPrefs(ILocalSharedPreferences.PreferenceName preferenceName) {
        return getCurrentContext().getLocalSharedPreferences().getSharedPreferences(preferenceName);
    }

    @Override // com.box.android.domain.identity.IUserContextManager
    public SharedPreferences getEncryptedSharedPrefs(ILocalSharedPreferences.PreferenceName preferenceName) {
        return getCurrentContext().getLocalSharedPreferences().getEncryptedSharedPrefs(preferenceName);
    }

    @Override // com.box.android.domain.identity.IUserContextManager
    public boolean hasValidUserId() {
        return (TextUtils.isEmpty(this.mUserContext.getContextId()) || this.mUserContext.getContextId().equals("-1")) ? false : true;
    }

    @Override // com.box.android.domain.identity.IUserContextManager
    public void addUserContextListener(String str, IUserContextComponentListener iUserContextComponentListener) {
        this.mListenerComponents.put(str, new SoftReference<>(iUserContextComponentListener));
    }

    private void notifyListenersOnCreate(String str) {
        if (this.mListenerComponents.size() > 0) {
            for (Map.Entry<String, SoftReference<IUserContextComponentListener>> entry : this.mListenerComponents.entrySet()) {
                try {
                    entry.getValue().get().onCreate(str);
                } catch (Exception e) {
                    BoxLogUtils.e("UserContextManager.notifyListenersOnCreate " + entry.getKey() + " ref " + entry.getValue(), e);
                }
            }
        }
    }

    private void notifyListenersOnSoftDestroy() {
        if (this.mListenerComponents.size() > 0) {
            Iterator<Map.Entry<String, SoftReference<IUserContextComponentListener>>> it = this.mListenerComponents.entrySet().iterator();
            while (it.hasNext()) {
                try {
                    it.next().getValue().get().onSoftDestroy();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void notifyListenersOnHardDestroy() {
        if (this.mListenerComponents.size() > 0) {
            Iterator<Map.Entry<String, SoftReference<IUserContextComponentListener>>> it = this.mListenerComponents.entrySet().iterator();
            while (it.hasNext()) {
                try {
                    it.next().getValue().get().onHardDestroy();
                } catch (Exception e) {
                    BoxLogUtils.logException(e);
                }
            }
        }
    }

    @Override // com.box.android.domain.identity.IUserContextManager
    public BoxUser getUserInfo() {
        return this.mBoxSession.getUser();
    }

    @Override // com.box.android.domain.identity.IUserContextManager
    public void setUserInfo(BoxUser boxUser) {
        boolean z = true;
        if ((boxUser != null || this.mBoxSession.getUser() == null) && ((this.mBoxSession.getUser() != null || boxUser == null) && (this.mBoxSession.getUser() == null || boxUser == null || this.mBoxSession.getUser().getUserId().equals(boxUser.getUserId())))) {
            z = false;
        }
        if (boxUser != null) {
            this.mUserContext.onCreate(boxUser.getUserId());
            this.userContextState.set(0);
            notifyListenersOnCreate(boxUser.getUserId());
        }
        if (z) {
            LocalBroadcastManager.getInstance(this.mAppContext).sendBroadcast(new BoxSwitchUserMessage(BoxSwitchUserMessage.ACTION_SET_USER));
        }
    }

    @Override // com.box.android.domain.identity.IUserContextManager
    public CustomBoxSession getBoxSession(Context context) {
        this.mBoxSession = this.mBoxSessionFactory.getBoxSession(context);
        updatePreviewStorage();
        return this.mBoxSession;
    }

    @Override // com.box.android.domain.identity.IUserContextManager
    public String getDeviceId() {
        return this.mDeviceId.getDeviceId();
    }

    protected void updatePreviewStorage() {
        if (!SdkUtils.isBlank(this.mBoxSession.getUserId())) {
            String userId = this.mBoxSession.getUserId();
            IBoxStorage iBoxStorage = this.mStorage;
            if (iBoxStorage == null || iBoxStorage.getUserId() == null || !this.mStorage.getUserId().equals(userId)) {
                this.mStorage = new BoxStorage(this.mBoxSession, this);
                return;
            }
            return;
        }
        this.mStorage = null;
    }

    @Override // com.box.android.domain.identity.IUserContextManager
    public IBoxStorage getPreviewStorage() {
        return this.mStorage;
    }

    @Override // com.box.android.domain.identity.IUserContextManager
    public int getUserType() {
        BoxUser userInfo = getUserInfo();
        if (userInfo != null && userInfo.getEnterprise() != null) {
            return 3;
        }
        if (userInfo != null && isPaidUser() == null) {
            return 1;
        }
        if (userInfo == null || !isPaidUser().booleanValue()) {
            return userInfo != null ? 0 : -1;
        }
        return 2;
    }

    @Override // com.box.android.domain.identity.IUserContextManager
    public String getUserTypeAsString() {
        int userType = getUserType();
        if (userType == -1) {
            return "unknown";
        }
        if (userType == 0) {
            return "free";
        }
        if (userType == 1) {
            return "paid_unknown";
        }
        if (userType == 2) {
            return "paid";
        }
        if (userType == 3) {
            return "enterprise";
        }
        return "new_unknown";
    }

    private Boolean isPaidUser() {
        try {
            BoxFeatures boxFeaturesSendForCachedResult = this.mApiPrivate.getFeaturesRequest().sendForCachedResult();
            return Boolean.valueOf(boxFeaturesSendForCachedResult.hasAutoContentUpload() || boxFeaturesSendForCachedResult.hasFeature(com.box.android.coreservices.models.BoxFeatures.FEATURE_PASSWORD_PROTECT_LINKS));
        } catch (Exception e) {
            BoxLogUtils.e("cached features", e);
            return null;
        }
    }
}
