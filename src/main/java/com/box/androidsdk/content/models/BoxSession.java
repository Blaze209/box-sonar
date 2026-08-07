package com.box.androidsdk.content.models;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Looper;
import com.box.android.common.utilities.BuildConfigProvider;
import com.box.android.dataaccess.content.R;
import com.box.androidsdk.content.BoxApiUser;
import com.box.androidsdk.content.BoxConfig;
import com.box.androidsdk.content.BoxException;
import com.box.androidsdk.content.BoxFutureTask;
import com.box.androidsdk.content.auth.BoxAuthentication;
import com.box.androidsdk.content.requests.BoxRequest;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.box.androidsdk.content.utils.SdkUtils;
import com.box.androidsdk.content.utils.StringMappedThreadPoolExecutor;
import com.microsoft.intune.mam.client.content.pm.MAMPackageManagement;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.io.FilesKt;

/* JADX INFO: loaded from: classes13.dex */
public class BoxSession extends BoxObject implements BoxAuthentication.AuthListener {
    private static final transient ThreadPoolExecutor AUTH_CREATION_EXECUTOR = SdkUtils.createDefaultThreadPoolExecutor(1, 20, 3600, TimeUnit.SECONDS);
    private static final long serialVersionUID = 8122900496609434013L;
    protected String mAccountEmail;
    private transient Context mApplicationContext;
    protected BoxAuthentication.BoxAuthenticationInfo mAuthInfo;
    protected String mClientId;
    protected String mClientRedirectUrl;
    protected String mClientSecret;
    protected String mDeviceId;
    protected String mDeviceName;
    protected boolean mEnableBoxAppAuthentication;
    protected Long mExpiresAt;
    private boolean mIsAppFedrampHighCompliant;
    private String mLastAuthCreationTaskId;
    protected BoxMDMData mMDMData;
    protected BoxAuthentication.AuthenticationRefreshProvider mRefreshProvider;
    private transient WeakReference<BoxFutureTask<BoxSession>> mRefreshTask;
    private boolean mSuppressAuthErrorUIAfterLogin;
    private String mUserAgent;
    private String mUserId;
    private transient BoxAuthentication.AuthListener sessionAuthListener;

    public BoxSession(Context context, boolean z) {
        this(context, getBestStoredUserId(context), z);
    }

    private static String getBestStoredUserId(Context context) {
        String lastAuthenticatedUserId = BoxAuthentication.getInstance().getLastAuthenticatedUserId(context);
        Map<String, BoxAuthentication.BoxAuthenticationInfo> storedAuthInfo = BoxAuthentication.getInstance().getStoredAuthInfo(context);
        if (storedAuthInfo == null) {
            return null;
        }
        if (!SdkUtils.isEmptyString(lastAuthenticatedUserId) && storedAuthInfo.get(lastAuthenticatedUserId) != null) {
            return lastAuthenticatedUserId;
        }
        if (storedAuthInfo.size() == 1) {
            return storedAuthInfo.keySet().iterator().next();
        }
        return null;
    }

    public BoxSession(Context context, String str, boolean z) {
        this(context, str, BoxConfig.CLIENT_ID, BoxConfig.CLIENT_SECRET, BoxConfig.REDIRECT_URL, z);
        if (!SdkUtils.isEmptyString(BoxConfig.DEVICE_NAME)) {
            setDeviceName(BoxConfig.DEVICE_NAME);
        }
        if (SdkUtils.isEmptyString(BoxConfig.DEVICE_ID)) {
            return;
        }
        setDeviceName(BoxConfig.DEVICE_ID);
    }

    public BoxSession(Context context, String str, String str2, String str3, String str4, boolean z) {
        this.mUserAgent = "com.box.sdk.android/5.0.0";
        this.mApplicationContext = BoxConfig.APPLICATION_CONTEXT;
        this.mSuppressAuthErrorUIAfterLogin = false;
        this.mIsAppFedrampHighCompliant = false;
        this.mEnableBoxAppAuthentication = BoxConfig.ENABLE_BOX_APP_AUTHENTICATION;
        this.mClientId = str2;
        this.mClientSecret = str3;
        this.mClientRedirectUrl = str4;
        this.mIsAppFedrampHighCompliant = z;
        if (getRefreshProvider() == null && (SdkUtils.isEmptyString(this.mClientId) || SdkUtils.isEmptyString(this.mClientSecret))) {
            throw new RuntimeException("Session must have a valid client id and client secret specified.");
        }
        this.mApplicationContext = context.getApplicationContext();
        if (!SdkUtils.isEmptyString(str)) {
            this.mAuthInfo = BoxAuthentication.getInstance().getAuthInfo(str, context);
            this.mUserId = str;
        }
        if (this.mAuthInfo == null) {
            this.mUserId = str;
            this.mAuthInfo = new BoxAuthentication.BoxAuthenticationInfo();
        }
        this.mAuthInfo.setClientId(this.mClientId);
        setupSession();
    }

    protected BoxSession(BoxSession boxSession) {
        this.mUserAgent = "com.box.sdk.android/5.0.0";
        this.mApplicationContext = BoxConfig.APPLICATION_CONTEXT;
        this.mSuppressAuthErrorUIAfterLogin = false;
        this.mIsAppFedrampHighCompliant = false;
        this.mEnableBoxAppAuthentication = BoxConfig.ENABLE_BOX_APP_AUTHENTICATION;
        this.mApplicationContext = boxSession.mApplicationContext;
        if (!SdkUtils.isBlank(boxSession.getUserId())) {
            setUserId(boxSession.getUserId());
        }
        if (!SdkUtils.isBlank(boxSession.getDeviceId())) {
            setDeviceId(boxSession.getDeviceId());
        }
        if (!SdkUtils.isBlank(boxSession.getDeviceName())) {
            setDeviceName(boxSession.getDeviceName());
        }
        if (!SdkUtils.isBlank(boxSession.getBoxAccountEmail())) {
            setBoxAccountEmail(boxSession.getBoxAccountEmail());
        }
        if (boxSession.getManagementData() != null) {
            setManagementData(boxSession.getManagementData());
        }
        if (!SdkUtils.isBlank(boxSession.getClientId())) {
            this.mClientId = boxSession.mClientId;
        }
        if (!SdkUtils.isBlank(boxSession.getClientSecret())) {
            this.mClientSecret = boxSession.getClientSecret();
        }
        if (!SdkUtils.isBlank(boxSession.getRedirectUrl())) {
            this.mClientRedirectUrl = boxSession.getRedirectUrl();
        }
        this.mIsAppFedrampHighCompliant = boxSession.isAppFedrampHighCompliant();
        setAuthInfo(boxSession.getAuthInfo());
        setupSession();
    }

    public <E extends BoxAuthentication.AuthenticationRefreshProvider & Serializable> BoxSession(Context context, BoxAuthentication.BoxAuthenticationInfo boxAuthenticationInfo, E e, boolean z) {
        this.mUserAgent = "com.box.sdk.android/5.0.0";
        this.mApplicationContext = BoxConfig.APPLICATION_CONTEXT;
        this.mSuppressAuthErrorUIAfterLogin = false;
        this.mIsAppFedrampHighCompliant = false;
        this.mEnableBoxAppAuthentication = BoxConfig.ENABLE_BOX_APP_AUTHENTICATION;
        this.mApplicationContext = context.getApplicationContext();
        this.mIsAppFedrampHighCompliant = z;
        setAuthInfo(boxAuthenticationInfo);
        this.mRefreshProvider = e;
        setupSession();
    }

    protected void setAuthInfo(BoxAuthentication.BoxAuthenticationInfo boxAuthenticationInfo) {
        if (boxAuthenticationInfo == null) {
            BoxAuthentication.BoxAuthenticationInfo boxAuthenticationInfo2 = new BoxAuthentication.BoxAuthenticationInfo();
            this.mAuthInfo = boxAuthenticationInfo2;
            boxAuthenticationInfo2.setClientId(this.mClientId);
        } else {
            this.mAuthInfo = boxAuthenticationInfo;
        }
        if (this.mAuthInfo.getUser() != null && !SdkUtils.isBlank(this.mAuthInfo.getUser().getUserId())) {
            setUserId(this.mAuthInfo.getUser().getUserId());
        } else {
            setUserId(null);
        }
    }

    public <E extends BoxAuthentication.AuthenticationRefreshProvider & Serializable> BoxSession(Context context, String str, E e, boolean z) {
        this(context, createSimpleBoxAuthenticationInfo(str), e, z);
    }

    private static BoxAuthentication.BoxAuthenticationInfo createSimpleBoxAuthenticationInfo(String str) {
        BoxAuthentication.BoxAuthenticationInfo boxAuthenticationInfo = new BoxAuthentication.BoxAuthenticationInfo();
        boxAuthenticationInfo.setAccessToken(str);
        return boxAuthenticationInfo;
    }

    public void setEnableBoxAppAuthentication(boolean z) {
        this.mEnableBoxAppAuthentication = z;
    }

    public boolean isEnabledBoxAppAuthentication() {
        return this.mEnableBoxAppAuthentication;
    }

    public void setApplicationContext(Context context) {
        this.mApplicationContext = context.getApplicationContext();
    }

    public Context getApplicationContext() {
        return this.mApplicationContext;
    }

    public void setSessionAuthListener(BoxAuthentication.AuthListener authListener) {
        this.sessionAuthListener = authListener;
    }

    protected void setupSession() {
        try {
            Context context = this.mApplicationContext;
            if (context != null && context.getPackageManager() != null) {
                if (BoxConfig.APPLICATION_CONTEXT == null) {
                    BoxConfig.APPLICATION_CONTEXT = this.mApplicationContext;
                }
                MAMPackageManagement.getPackageInfo(this.mApplicationContext.getPackageManager(), this.mApplicationContext.getPackageName(), 0);
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        BoxConfig.IS_DEBUG = BuildConfigProvider.INSTANCE.isDebugBuild();
        BoxAuthentication.getInstance().addListener(this);
    }

    public BoxUser getUser() {
        return this.mAuthInfo.getUser();
    }

    public String getUserId() {
        return this.mUserId;
    }

    protected void setUserId(String str) {
        this.mUserId = str;
    }

    public BoxAuthentication.BoxAuthenticationInfo getAuthInfo() {
        return this.mAuthInfo;
    }

    public BoxAuthentication.AuthenticationRefreshProvider getRefreshProvider() {
        BoxAuthentication.AuthenticationRefreshProvider authenticationRefreshProvider = this.mRefreshProvider;
        return authenticationRefreshProvider != null ? authenticationRefreshProvider : BoxAuthentication.getInstance().getRefreshProvider();
    }

    public void setDeviceId(String str) {
        this.mDeviceId = str;
    }

    public String getDeviceId() {
        return this.mDeviceId;
    }

    public void setDeviceName(String str) {
        this.mDeviceName = str;
    }

    public String getDeviceName() {
        return this.mDeviceName;
    }

    public String getUserAgent() {
        return this.mUserAgent;
    }

    public void setManagementData(BoxMDMData boxMDMData) {
        this.mMDMData = boxMDMData;
    }

    public BoxMDMData getManagementData() {
        return this.mMDMData;
    }

    public boolean isAppFedrampHighCompliant() {
        return this.mIsAppFedrampHighCompliant;
    }

    public void setRefreshTokenExpiresAt(long j) {
        this.mExpiresAt = Long.valueOf(j);
    }

    public Long getRefreshTokenExpiresAt() {
        return this.mExpiresAt;
    }

    public void setBoxAccountEmail(String str) {
        this.mAccountEmail = str;
    }

    public String getBoxAccountEmail() {
        return this.mAccountEmail;
    }

    @Deprecated
    public BoxFutureTask<BoxSession> authenticate() {
        return authenticate(getApplicationContext());
    }

    public BoxFutureTask<BoxSession> authenticate(Context context) {
        return authenticate(context, null);
    }

    public BoxFutureTask<BoxSession> authenticate(Context context, BoxFutureTask.OnCompletedListener<BoxSession> onCompletedListener) {
        if (context != null) {
            Context applicationContext = context.getApplicationContext();
            this.mApplicationContext = applicationContext;
            BoxConfig.APPLICATION_CONTEXT = applicationContext;
        }
        if (!SdkUtils.isBlank(this.mLastAuthCreationTaskId)) {
            ThreadPoolExecutor threadPoolExecutor = AUTH_CREATION_EXECUTOR;
            if (threadPoolExecutor instanceof StringMappedThreadPoolExecutor) {
                Runnable taskFor = ((StringMappedThreadPoolExecutor) threadPoolExecutor).getTaskFor(this.mLastAuthCreationTaskId);
                if (taskFor instanceof BoxSessionAuthCreationRequest.BoxAuthCreationTask) {
                    BoxSessionAuthCreationRequest.BoxAuthCreationTask boxAuthCreationTask = (BoxSessionAuthCreationRequest.BoxAuthCreationTask) taskFor;
                    if (!boxAuthCreationTask.isDone()) {
                        if (onCompletedListener != null) {
                            boxAuthCreationTask.addOnCompletedListener(onCompletedListener);
                        }
                        boxAuthCreationTask.bringUiToFrontIfNecessary();
                        return boxAuthCreationTask;
                    }
                }
            }
        }
        BoxFutureTask<BoxSession> task = new BoxSessionAuthCreationRequest(this, this.mEnableBoxAppAuthentication).toTask();
        if (onCompletedListener != null) {
            task.addOnCompletedListener(onCompletedListener);
        }
        this.mLastAuthCreationTaskId = task.toString();
        AUTH_CREATION_EXECUTOR.execute(task);
        return task;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.box.androidsdk.content.models.BoxSession$1] */
    public BoxFutureTask<BoxSession> logout() {
        final BoxFutureTask<BoxSession> task = new BoxSessionLogoutRequest(this).toTask();
        new Thread() { // from class: com.box.androidsdk.content.models.BoxSession.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                task.run();
            }
        }.start();
        return task;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.box.androidsdk.content.models.BoxSession$2] */
    public BoxFutureTask<BoxSession> refresh() {
        WeakReference<BoxFutureTask<BoxSession>> weakReference = this.mRefreshTask;
        if (weakReference != null && weakReference.get() != null) {
            BoxFutureTask<BoxSession> boxFutureTask = this.mRefreshTask.get();
            if (!boxFutureTask.isCancelled() && !boxFutureTask.isDone()) {
                return boxFutureTask;
            }
        }
        final BoxFutureTask<BoxSession> task = new BoxSessionRefreshRequest(this).toTask();
        new Thread() { // from class: com.box.androidsdk.content.models.BoxSession.2
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                task.run();
            }
        }.start();
        this.mRefreshTask = new WeakReference<>(task);
        return task;
    }

    public void suppressAuthErrorUIAfterLogin(boolean z) {
        this.mSuppressAuthErrorUIAfterLogin = z;
    }

    public boolean suppressesAuthErrorUIAfterLogin() {
        return this.mSuppressAuthErrorUIAfterLogin;
    }

    public File getCacheDir() {
        return new File(getApplicationContext().getFilesDir(), getUserId());
    }

    public void clearCache() {
        FilesKt.deleteRecursively(getCacheDir());
    }

    @Override // com.box.androidsdk.content.auth.BoxAuthentication.AuthListener
    public void onRefreshed(BoxAuthentication.BoxAuthenticationInfo boxAuthenticationInfo) {
        if (sameUser(boxAuthenticationInfo)) {
            BoxAuthentication.BoxAuthenticationInfo.cloneInfo(this.mAuthInfo, boxAuthenticationInfo);
            BoxAuthentication.AuthListener authListener = this.sessionAuthListener;
            if (authListener != null) {
                authListener.onRefreshed(boxAuthenticationInfo);
            }
        }
    }

    @Override // com.box.androidsdk.content.auth.BoxAuthentication.AuthListener
    public void onAuthCreated(BoxAuthentication.BoxAuthenticationInfo boxAuthenticationInfo) {
        if (sameUser(boxAuthenticationInfo) || getUserId() == null) {
            BoxAuthentication.BoxAuthenticationInfo.cloneInfo(this.mAuthInfo, boxAuthenticationInfo);
            if (boxAuthenticationInfo.getUser() != null) {
                setUserId(boxAuthenticationInfo.getUser().getUserId());
            }
            BoxAuthentication.AuthListener authListener = this.sessionAuthListener;
            if (authListener != null) {
                authListener.onAuthCreated(boxAuthenticationInfo);
            }
        }
    }

    public void onAuthFailure(BoxAuthentication.BoxAuthenticationInfo boxAuthenticationInfo, Exception exc) {
        if (sameUser(boxAuthenticationInfo) || (boxAuthenticationInfo == null && getUserId() == null)) {
            BoxAuthentication.AuthListener authListener = this.sessionAuthListener;
            if (authListener != null) {
                authListener.onAuthFailure(boxAuthenticationInfo, exc);
            }
            if (exc instanceof BoxException) {
                if (AnonymousClass3.$SwitchMap$com$box$androidsdk$content$BoxException$ErrorType[((BoxException) exc).getErrorType().ordinal()] == 1) {
                    toastString(this.mApplicationContext, R.string.boxsdk_error_network_connection);
                } else {
                    toastString(this.mApplicationContext, R.string.boxsdk_Authentication_fail);
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.box.androidsdk.content.models.BoxSession$3, reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$box$androidsdk$content$BoxException$ErrorType;

        static {
            int[] iArr = new int[BoxException.ErrorType.values().length];
            $SwitchMap$com$box$androidsdk$content$BoxException$ErrorType = iArr;
            try {
                iArr[BoxException.ErrorType.NETWORK_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$box$androidsdk$content$BoxException$ErrorType[BoxException.ErrorType.IP_BLOCKED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    protected void startAuthenticationUI() {
        BoxAuthentication.getInstance().startAuthenticationUI(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void toastString(Context context, int i) {
        SdkUtils.toastSafely(context, i, 1);
    }

    @Override // com.box.androidsdk.content.auth.BoxAuthentication.AuthListener
    public void onLoggedOut(BoxAuthentication.BoxAuthenticationInfo boxAuthenticationInfo, Exception exc) {
        if (sameUser(boxAuthenticationInfo)) {
            getAuthInfo().wipeOutAuth();
            setUserId(null);
            BoxAuthentication.AuthListener authListener = this.sessionAuthListener;
            if (authListener != null) {
                authListener.onLoggedOut(boxAuthenticationInfo, exc);
            }
        }
    }

    public String getClientId() {
        return this.mClientId;
    }

    public String getClientSecret() {
        return this.mClientSecret;
    }

    public String getRedirectUrl() {
        return this.mClientRedirectUrl;
    }

    private boolean sameUser(BoxAuthentication.BoxAuthenticationInfo boxAuthenticationInfo) {
        return (boxAuthenticationInfo == null || boxAuthenticationInfo.getUser() == null || getUserId() == null || !getUserId().equals(boxAuthenticationInfo.getUser().getUserId())) ? false : true;
    }

    private static class BoxSessionLogoutRequest extends BoxRequest<BoxSession, BoxSessionLogoutRequest> {
        private static final long serialVersionUID = 8123965031279971582L;

        public BoxSessionLogoutRequest(BoxSession boxSession) {
            super(null, " ", null);
            this.mSession = boxSession;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.box.androidsdk.content.requests.BoxRequest
        public BoxSession onSend() throws BoxException {
            synchronized (this.mSession) {
                if (this.mSession.getUser() != null) {
                    BoxAuthentication.getInstance().logout(this.mSession);
                    this.mSession.getAuthInfo().wipeOutAuth();
                    this.mSession.setUserId(null);
                }
            }
            return this.mSession;
        }
    }

    private static class BoxSessionRefreshRequest extends BoxRequest<BoxSession, BoxSessionRefreshRequest> {
        private static final long serialVersionUID = 8123965031279971587L;

        public BoxSessionRefreshRequest(BoxSession boxSession) {
            super(null, " ", null);
            this.mSession = boxSession;
        }

        @Override // com.box.androidsdk.content.requests.BoxRequest
        public BoxSession onSend() throws BoxException {
            try {
                BoxAuthentication.getInstance().refresh(this.mSession).get();
            } catch (Exception e) {
                if (e instanceof InterruptedException) {
                    Thread.currentThread().interrupt();
                }
                BoxLogUtils.e("BoxSession", "Unable to repair user", e);
                Exception exc = e.getCause() instanceof BoxException ? (Exception) e.getCause() : e;
                if (exc instanceof BoxException) {
                    if (this.mSession.mSuppressAuthErrorUIAfterLogin) {
                        this.mSession.onAuthFailure(null, exc);
                    } else {
                        if ((exc instanceof BoxException.RefreshFailure) && ((BoxException.RefreshFailure) exc).isErrorFatal()) {
                            BoxSession.toastString(this.mSession.getApplicationContext(), R.string.boxsdk_error_fatal_refresh);
                            this.mSession.startAuthenticationUI();
                            this.mSession.onAuthFailure(this.mSession.getAuthInfo(), exc);
                            throw ((BoxException) exc);
                        }
                        if (((BoxException) e).getErrorType() == BoxException.ErrorType.TERMS_OF_SERVICE_REQUIRED) {
                            BoxSession.toastString(this.mSession.getApplicationContext(), R.string.boxsdk_error_terms_of_service);
                            this.mSession.startAuthenticationUI();
                            this.mSession.onAuthFailure(this.mSession.getAuthInfo(), exc);
                            BoxLogUtils.e("BoxSession", "TOS refresh exception ", exc);
                            throw ((BoxException) exc);
                        }
                        this.mSession.onAuthFailure(null, exc);
                        throw ((BoxException) exc);
                    }
                } else {
                    throw new BoxException("BoxSessionRefreshRequest failed", exc);
                }
            }
            BoxAuthentication.BoxAuthenticationInfo.cloneInfo(this.mSession.mAuthInfo, BoxAuthentication.getInstance().getAuthInfo(this.mSession.getUserId(), this.mSession.getApplicationContext()));
            return this.mSession;
        }
    }

    private static class BoxSessionAuthCreationRequest extends BoxRequest<BoxSession, BoxSessionAuthCreationRequest> implements BoxAuthentication.AuthListener {
        private static final long serialVersionUID = 8123965031279971545L;
        private boolean mIsWaitingForLoginUi;
        private final BoxSession session;

        @Override // com.box.androidsdk.content.auth.BoxAuthentication.AuthListener
        public void onLoggedOut(BoxAuthentication.BoxAuthenticationInfo boxAuthenticationInfo, Exception exc) {
        }

        @Override // com.box.androidsdk.content.auth.BoxAuthentication.AuthListener
        public void onRefreshed(BoxAuthentication.BoxAuthenticationInfo boxAuthenticationInfo) {
        }

        public BoxSessionAuthCreationRequest(BoxSession boxSession, boolean z) {
            super(null, " ", null);
            this.session = boxSession;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.box.androidsdk.content.requests.BoxRequest
        public BoxSession onSend() throws BoxException {
            synchronized (this.session) {
                if (this.session.getUser() == null) {
                    if (this.session.getAuthInfo() != null && !SdkUtils.isBlank(this.session.getAuthInfo().accessToken()) && this.session.getUser() == null) {
                        try {
                            BoxUser boxUser = (BoxUser) new BoxApiUser(this.session).getCurrentUserInfoRequest().setFields(BoxAuthentication.MINIMUM_USER_FIELDS).send();
                            this.session.setUserId(boxUser.getUserId());
                            this.session.getAuthInfo().setUser(boxUser);
                            BoxAuthentication.getInstance().onAuthenticated(this.session.getAuthInfo(), this.session.getApplicationContext(), this.session.isAppFedrampHighCompliant());
                            return this.session;
                        } catch (BoxException e) {
                            BoxLogUtils.e("BoxSession", "Unable to repair user", e);
                            if ((e instanceof BoxException.RefreshFailure) && ((BoxException.RefreshFailure) e).isErrorFatal()) {
                                BoxSession.toastString(this.session.getApplicationContext(), R.string.boxsdk_error_fatal_refresh);
                            } else if (e.getErrorType() == BoxException.ErrorType.TERMS_OF_SERVICE_REQUIRED) {
                                BoxSession.toastString(this.session.getApplicationContext(), R.string.boxsdk_error_terms_of_service);
                            } else {
                                this.session.onAuthFailure(null, e);
                                throw e;
                            }
                        }
                    }
                    BoxAuthentication.getInstance().addListener(this);
                    launchAuthUI();
                    return this.session;
                }
                BoxAuthentication.BoxAuthenticationInfo authInfo = BoxAuthentication.getInstance().getAuthInfo(this.session.getUserId(), this.session.getApplicationContext());
                if (authInfo != null) {
                    BoxAuthentication.BoxAuthenticationInfo.cloneInfo(this.session.mAuthInfo, authInfo);
                    if (SdkUtils.isBlank(this.session.getAuthInfo().accessToken()) && SdkUtils.isBlank(this.session.getAuthInfo().refreshToken())) {
                        BoxAuthentication.getInstance().addListener(this);
                        launchAuthUI();
                    } else {
                        if (authInfo.getUser() == null || SdkUtils.isBlank(authInfo.getUser().getUserId())) {
                            try {
                                BoxUser boxUser2 = (BoxUser) new BoxApiUser(this.session).getCurrentUserInfoRequest().setFields(BoxAuthentication.MINIMUM_USER_FIELDS).send();
                                this.session.setUserId(boxUser2.getUserId());
                                this.session.getAuthInfo().setUser(boxUser2);
                                BoxSession boxSession = this.session;
                                boxSession.onAuthCreated(boxSession.getAuthInfo());
                                return this.session;
                            } catch (BoxException e2) {
                                BoxLogUtils.e("BoxSession", "Unable to repair user", e2);
                                if ((e2 instanceof BoxException.RefreshFailure) && ((BoxException.RefreshFailure) e2).isErrorFatal()) {
                                    BoxSession.toastString(this.session.getApplicationContext(), R.string.boxsdk_error_fatal_refresh);
                                } else if (e2.getErrorType() == BoxException.ErrorType.TERMS_OF_SERVICE_REQUIRED) {
                                    BoxSession.toastString(this.session.getApplicationContext(), R.string.boxsdk_error_terms_of_service);
                                } else {
                                    this.session.onAuthFailure(null, e2);
                                    throw e2;
                                }
                            }
                        }
                        BoxSession boxSession2 = this.session;
                        boxSession2.onAuthCreated(boxSession2.getAuthInfo());
                    }
                } else {
                    this.session.mAuthInfo.setUser(null);
                    launchAuthUI();
                }
                return this.session;
                throw th;
            }
        }

        private void launchAuthUI() {
            synchronized (this.session) {
                this.mIsWaitingForLoginUi = true;
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.box.androidsdk.content.models.BoxSession.BoxSessionAuthCreationRequest.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (BoxSessionAuthCreationRequest.this.session.getRefreshProvider() == null || !BoxSessionAuthCreationRequest.this.session.getRefreshProvider().launchAuthUi(BoxSessionAuthCreationRequest.this.session.getUserId(), BoxSessionAuthCreationRequest.this.session)) {
                            BoxSessionAuthCreationRequest.this.session.startAuthenticationUI();
                        }
                    }
                });
                while (this.mIsWaitingForLoginUi) {
                    try {
                        this.session.wait();
                    } catch (InterruptedException unused) {
                        BoxLogUtils.e(getClass().getSimpleName(), "could not launch auth UI");
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        @Override // com.box.androidsdk.content.requests.BoxRequest
        public BoxFutureTask<BoxSession> toTask() {
            return new BoxAuthCreationTask(BoxSession.class, this);
        }

        @Override // com.box.androidsdk.content.auth.BoxAuthentication.AuthListener
        public void onAuthCreated(BoxAuthentication.BoxAuthenticationInfo boxAuthenticationInfo) {
            notifyAuthDone();
        }

        private void notifyAuthDone() {
            synchronized (this.session) {
                this.mIsWaitingForLoginUi = false;
                this.session.notifyAll();
            }
        }

        @Override // com.box.androidsdk.content.auth.BoxAuthentication.AuthListener
        public void onAuthFailure(BoxAuthentication.BoxAuthenticationInfo boxAuthenticationInfo, Exception exc) {
            notifyAuthDone();
        }

        static class BoxAuthCreationTask extends BoxFutureTask<BoxSession> {
            public BoxAuthCreationTask(Class<BoxSession> cls, BoxRequest boxRequest) {
                super(cls, boxRequest);
            }

            public void bringUiToFrontIfNecessary() {
                if ((this.mRequest instanceof BoxSessionAuthCreationRequest) && ((BoxSessionAuthCreationRequest) this.mRequest).mIsWaitingForLoginUi) {
                    ((BoxSessionAuthCreationRequest) this.mRequest).session.startAuthenticationUI();
                }
            }
        }

        @Override // com.box.androidsdk.content.requests.BoxRequest
        public boolean equals(Object obj) {
            if ((obj instanceof BoxSessionAuthCreationRequest) && ((BoxSessionAuthCreationRequest) obj).session.equals(this.session)) {
                return super.equals(obj);
            }
            return false;
        }

        @Override // com.box.androidsdk.content.requests.BoxRequest
        public int hashCode() {
            return this.session.hashCode() + super.hashCode();
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        if (BoxConfig.APPLICATION_CONTEXT != null) {
            setApplicationContext(BoxConfig.APPLICATION_CONTEXT);
        }
    }
}
