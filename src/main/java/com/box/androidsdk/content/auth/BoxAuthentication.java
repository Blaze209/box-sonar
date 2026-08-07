package com.box.androidsdk.content.auth;

import android.content.Context;
import android.content.Intent;
import com.box.androidsdk.content.BoxApiUser;
import com.box.androidsdk.content.BoxConfig;
import com.box.androidsdk.content.BoxConstants;
import com.box.androidsdk.content.BoxException;
import com.box.androidsdk.content.BoxFutureTask;
import com.box.androidsdk.content.models.BoxEntity;
import com.box.androidsdk.content.models.BoxJsonObject;
import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.models.BoxUser;
import com.box.androidsdk.content.requests.BoxResponse;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.box.androidsdk.content.utils.SdkUtils;
import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.JsonValue;
import com.microsoft.intune.mam.client.content.pm.MAMPackageManagement;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes13.dex */
public class BoxAuthentication {
    private ConcurrentHashMap<String, BoxAuthenticationInfo> mCurrentAccessInfo;
    private AuthenticationRefreshProvider mRefreshProvider;
    private static final BoxAuthentication mAuthentication = new BoxAuthentication();
    private static final ThreadPoolExecutor AUTH_EXECUTOR = SdkUtils.createDefaultThreadPoolExecutor(1, 1, 3600, TimeUnit.SECONDS);
    private static final String TAG = BoxAuthentication.class.getName();
    public static final String[] MINIMUM_USER_FIELDS = {"type", "id", "name", "login", BoxUser.FIELD_SPACE_AMOUNT, BoxUser.FIELD_SPACE_USED, BoxUser.FIELD_MAX_UPLOAD_SIZE, "enterprise", "created_at", BoxUser.FIELD_IS_BOXNOTE_CREATION_ENABLED};
    private ConcurrentLinkedQueue<WeakReference<AuthListener>> mListeners = new ConcurrentLinkedQueue<>();
    private final ConcurrentHashMap<String, FutureTask> mRefreshingTasks = new ConcurrentHashMap<>();
    private AuthStorage authStorage = new AuthStorage();

    public interface AuthListener {
        void onAuthCreated(BoxAuthenticationInfo boxAuthenticationInfo);

        void onAuthFailure(BoxAuthenticationInfo boxAuthenticationInfo, Exception exc);

        void onLoggedOut(BoxAuthenticationInfo boxAuthenticationInfo, Exception exc);

        void onRefreshed(BoxAuthenticationInfo boxAuthenticationInfo);
    }

    public interface AuthenticationRefreshProvider {
        boolean launchAuthUi(String str, BoxSession boxSession);

        BoxAuthenticationInfo refreshAuthenticationInfo(BoxAuthenticationInfo boxAuthenticationInfo) throws BoxException;
    }

    private BoxAuthentication() {
    }

    private BoxAuthentication(AuthenticationRefreshProvider authenticationRefreshProvider) {
        this.mRefreshProvider = authenticationRefreshProvider;
    }

    public BoxAuthenticationInfo getAuthInfo(String str, Context context) {
        if (str == null) {
            return null;
        }
        return getAuthInfoMap(context).get(str);
    }

    public Map<String, BoxAuthenticationInfo> getStoredAuthInfo(Context context) {
        return getAuthInfoMap(context);
    }

    public String getLastAuthenticatedUserId(Context context) {
        return this.authStorage.getLastAuthentictedUserId(context);
    }

    public static BoxAuthentication getInstance() {
        return mAuthentication;
    }

    public void setAuthStorage(AuthStorage authStorage) {
        this.authStorage = authStorage;
    }

    public AuthStorage getAuthStorage() {
        return this.authStorage;
    }

    public AuthenticationRefreshProvider getRefreshProvider() {
        return this.mRefreshProvider;
    }

    public void setRefreshProvider(AuthenticationRefreshProvider authenticationRefreshProvider) {
        this.mRefreshProvider = authenticationRefreshProvider;
    }

    public synchronized void startAuthenticationUI(BoxSession boxSession) {
        startAuthenticateUI(boxSession);
    }

    public void onAuthenticated(BoxAuthenticationInfo boxAuthenticationInfo, Context context, boolean z) {
        BoxAuthenticationInfo boxAuthenticationInfoUnmodifiableObject = BoxAuthenticationInfo.unmodifiableObject(boxAuthenticationInfo);
        if (!SdkUtils.isBlank(boxAuthenticationInfoUnmodifiableObject.accessToken()) && (boxAuthenticationInfoUnmodifiableObject.getUser() == null || SdkUtils.isBlank(boxAuthenticationInfoUnmodifiableObject.getUser().getUserId()))) {
            doUserRefresh(context, boxAuthenticationInfoUnmodifiableObject, z);
            return;
        }
        getAuthInfoMap(context).put(boxAuthenticationInfoUnmodifiableObject.getUser().getUserId(), boxAuthenticationInfoUnmodifiableObject.createDeepCopy());
        this.authStorage.storeLastAuthenticatedUserId(boxAuthenticationInfoUnmodifiableObject.getUser().getUserId(), context);
        this.authStorage.storeAuthInfoMap(this.mCurrentAccessInfo, context);
        Iterator<AuthListener> it = getListeners().iterator();
        while (it.hasNext()) {
            it.next().onAuthCreated(boxAuthenticationInfoUnmodifiableObject);
        }
    }

    public void onAuthenticationFailure(BoxAuthenticationInfo boxAuthenticationInfo, Exception exc) {
        String string;
        Object objValueOf;
        if (getAuthStorage() == null) {
            string = "failure:";
        } else {
            string = "failure:auth storage :" + getAuthStorage().toString();
        }
        BoxAuthenticationInfo boxAuthenticationInfoUnmodifiableObject = BoxAuthenticationInfo.unmodifiableObject(boxAuthenticationInfo);
        if (boxAuthenticationInfoUnmodifiableObject != null) {
            StringBuilder sbAppend = new StringBuilder().append(string);
            if (boxAuthenticationInfoUnmodifiableObject.getUser() == null) {
                objValueOf = "null user";
            } else {
                objValueOf = boxAuthenticationInfoUnmodifiableObject.getUser().getUserId() == null ? "null user id" : Integer.valueOf(boxAuthenticationInfoUnmodifiableObject.getUser().getUserId().length());
            }
            string = sbAppend.append(objValueOf).toString();
        }
        BoxLogUtils.logException("BoxAuthfail", string, exc);
        Iterator<AuthListener> it = getListeners().iterator();
        while (it.hasNext()) {
            it.next().onAuthFailure(boxAuthenticationInfoUnmodifiableObject, exc);
        }
    }

    public void onLoggedOut(BoxAuthenticationInfo boxAuthenticationInfo, Exception exc) {
        BoxAuthenticationInfo boxAuthenticationInfoUnmodifiableObject = BoxAuthenticationInfo.unmodifiableObject(boxAuthenticationInfo);
        Iterator<AuthListener> it = getListeners().iterator();
        while (it.hasNext()) {
            it.next().onLoggedOut(boxAuthenticationInfoUnmodifiableObject, exc);
        }
    }

    public Set<AuthListener> getListeners() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<WeakReference<AuthListener>> it = this.mListeners.iterator();
        while (it.hasNext()) {
            AuthListener authListener = it.next().get();
            if (authListener != null) {
                linkedHashSet.add(authListener);
            }
        }
        if (this.mListeners.size() > linkedHashSet.size()) {
            this.mListeners = new ConcurrentLinkedQueue<>();
            Iterator it2 = linkedHashSet.iterator();
            while (it2.hasNext()) {
                this.mListeners.add(new WeakReference<>((AuthListener) it2.next()));
            }
        }
        return linkedHashSet;
    }

    public synchronized void logout(BoxSession boxSession) {
        BoxUser user = boxSession.getUser();
        if (user == null) {
            return;
        }
        boxSession.clearCache();
        Context applicationContext = boxSession.getApplicationContext();
        String id = user.getUserId();
        getAuthInfoMap(boxSession.getApplicationContext());
        BoxAuthenticationInfo boxAuthenticationInfo = this.mCurrentAccessInfo.get(id);
        try {
            new BoxApiAuthentication(boxSession).revokeOAuth(boxAuthenticationInfo.refreshToken(), boxSession.getClientId(), boxSession.getClientSecret()).send();
            e = null;
        } catch (Exception e) {
            e = e;
            BoxLogUtils.e(TAG, "logout", e);
        }
        this.mCurrentAccessInfo.remove(id);
        if (this.authStorage.getLastAuthentictedUserId(applicationContext) != null) {
            this.authStorage.storeLastAuthenticatedUserId(null, applicationContext);
        }
        this.authStorage.storeAuthInfoMap(this.mCurrentAccessInfo, applicationContext);
        onLoggedOut(boxAuthenticationInfo, e);
        boxAuthenticationInfo.wipeOutAuth();
    }

    public synchronized void logoutAllUsers(Context context, boolean z) {
        getAuthInfoMap(context);
        Iterator<String> it = this.mCurrentAccessInfo.keySet().iterator();
        while (it.hasNext()) {
            logout(new BoxSession(context, it.next(), z));
        }
        this.authStorage.clearAuthInfoMap(context);
    }

    public synchronized FutureTask<BoxAuthenticationInfo> create(BoxSession boxSession, String str, String str2) {
        FutureTask<BoxAuthenticationInfo> futureTaskDoCreate;
        futureTaskDoCreate = doCreate(boxSession, str, str2);
        AUTH_EXECUTOR.submit(futureTaskDoCreate);
        return futureTaskDoCreate;
    }

    public synchronized FutureTask<BoxAuthenticationInfo> refresh(BoxSession boxSession) {
        BoxUser user = boxSession.getUser();
        if (user == null) {
            return doRefresh(boxSession, boxSession.getAuthInfo());
        }
        getAuthInfoMap(boxSession.getApplicationContext());
        final BoxAuthenticationInfo boxAuthenticationInfo = this.mCurrentAccessInfo.get(user.getUserId());
        if (boxAuthenticationInfo == null) {
            this.mCurrentAccessInfo.put(user.getUserId(), boxSession.getAuthInfo());
            boxAuthenticationInfo = this.mCurrentAccessInfo.get(user.getUserId());
        }
        if (boxSession.getAuthInfo().accessToken() != null && (boxSession.getAuthInfo().accessToken().equals(boxAuthenticationInfo.accessToken()) || boxAuthenticationInfo.getRefreshTime() == null || System.currentTimeMillis() - boxAuthenticationInfo.getRefreshTime().longValue() >= 15000)) {
            FutureTask<BoxAuthenticationInfo> futureTask = this.mRefreshingTasks.get(user.getUserId());
            if (futureTask != null && !futureTask.isCancelled() && !futureTask.isDone()) {
                return futureTask;
            }
            return doRefresh(boxSession, boxAuthenticationInfo);
        }
        BoxAuthenticationInfo.cloneInfo(boxSession.getAuthInfo(), boxAuthenticationInfo);
        FutureTask<BoxAuthenticationInfo> futureTask2 = new FutureTask<>(new Callable<BoxAuthenticationInfo>() { // from class: com.box.androidsdk.content.auth.BoxAuthentication.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public BoxAuthenticationInfo call() throws Exception {
                return boxAuthenticationInfo;
            }
        });
        AUTH_EXECUTOR.execute(futureTask2);
        return futureTask2;
    }

    protected FutureTask<BoxAuthenticationInfo> doCreate(final BoxSession boxSession, final String str, final String str2) {
        return new FutureTask<>(new Callable<BoxAuthenticationInfo>() { // from class: com.box.androidsdk.content.auth.BoxAuthentication.2
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.concurrent.Callable
            public BoxAuthenticationInfo call() throws Exception {
                BoxApiAuthentication.BoxCreateAuthRequest boxCreateAuthRequestCreateOAuth = new BoxApiAuthentication(boxSession).createOAuth(str, str2, boxSession.getClientId(), boxSession.getClientSecret());
                BoxAuthenticationInfo boxAuthenticationInfo = new BoxAuthenticationInfo();
                BoxAuthenticationInfo.cloneInfo(boxAuthenticationInfo, boxSession.getAuthInfo());
                BoxAuthenticationInfo boxAuthenticationInfoSend = boxCreateAuthRequestCreateOAuth.send();
                boxAuthenticationInfo.setAccessToken(boxAuthenticationInfoSend.accessToken());
                boxAuthenticationInfo.setRefreshToken(boxAuthenticationInfoSend.refreshToken());
                boxAuthenticationInfo.setExpiresIn(boxAuthenticationInfoSend.expiresIn());
                boxAuthenticationInfo.setRefreshTime(Long.valueOf(System.currentTimeMillis()));
                boxAuthenticationInfo.setUser((BoxUser) new BoxApiUser(new BoxSession(boxSession.getApplicationContext(), boxAuthenticationInfo, (AuthenticationRefreshProvider) null, boxSession.isAppFedrampHighCompliant())).getCurrentUserInfoRequest().setFields(BoxAuthentication.MINIMUM_USER_FIELDS).send());
                BoxAuthentication.getInstance().onAuthenticated(boxAuthenticationInfo, boxSession.getApplicationContext(), boxSession.isAppFedrampHighCompliant());
                return boxAuthenticationInfo;
            }
        });
    }

    private BoxFutureTask<BoxUser> doUserRefresh(final Context context, final BoxAuthenticationInfo boxAuthenticationInfo, final boolean z) {
        BoxFutureTask task = new BoxApiUser(new BoxSession(context, boxAuthenticationInfo.accessToken(), (AuthenticationRefreshProvider) null, z)).getCurrentUserInfoRequest().setFields(MINIMUM_USER_FIELDS).toTask();
        task.addOnCompletedListener(new BoxFutureTask.OnCompletedListener<BoxUser>() { // from class: com.box.androidsdk.content.auth.BoxAuthentication.3
            @Override // com.box.androidsdk.content.BoxFutureTask.OnCompletedListener
            public void onCompleted(BoxResponse<BoxUser> boxResponse) {
                if (boxResponse.isSuccess()) {
                    boxAuthenticationInfo.setUser((BoxUser) boxResponse.getResult());
                    BoxAuthentication.getInstance().onAuthenticated(boxAuthenticationInfo, context, z);
                } else {
                    BoxAuthentication.getInstance().onAuthenticationFailure(boxAuthenticationInfo, boxResponse.getException());
                }
            }
        });
        AUTH_EXECUTOR.execute(task);
        return task;
    }

    public synchronized void addListener(AuthListener authListener) {
        if (getListeners().contains(authListener)) {
            return;
        }
        this.mListeners.add(new WeakReference<>(authListener));
    }

    private synchronized void startAuthenticateUI(BoxSession boxSession) {
        Context applicationContext = boxSession.getApplicationContext();
        Intent intentCreateOAuthActivityIntent = OAuthActivity.createOAuthActivityIntent(applicationContext, boxSession, isBoxAuthAppAvailable(applicationContext) && boxSession.isEnabledBoxAppAuthentication());
        intentCreateOAuthActivityIntent.addFlags(268435456);
        applicationContext.startActivity(intentCreateOAuthActivityIntent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BoxException.RefreshFailure handleRefreshException(BoxSession boxSession, BoxException boxException, BoxAuthenticationInfo boxAuthenticationInfo, String str) {
        BoxException.RefreshFailure refreshFailure = new BoxException.RefreshFailure(boxException);
        if (refreshFailure.isErrorFatal() || refreshFailure.getErrorType() == BoxException.ErrorType.TERMS_OF_SERVICE_REQUIRED) {
            if (str != null && str.equals(getAuthStorage().getLastAuthentictedUserId(boxSession.getApplicationContext()))) {
                getAuthStorage().storeLastAuthenticatedUserId(null, boxSession.getApplicationContext());
            }
            getAuthInfoMap(boxSession.getApplicationContext()).remove(str);
            getAuthStorage().storeAuthInfoMap(this.mCurrentAccessInfo, boxSession.getApplicationContext());
        }
        getInstance().onAuthenticationFailure(boxAuthenticationInfo, refreshFailure);
        return refreshFailure;
    }

    private FutureTask<BoxAuthenticationInfo> doRefresh(final BoxSession boxSession, final BoxAuthenticationInfo boxAuthenticationInfo) {
        final boolean z = boxAuthenticationInfo.getUser() == null && boxSession.getUser() == null;
        final String strAccessToken = (SdkUtils.isBlank(boxSession.getUserId()) && z) ? boxAuthenticationInfo.accessToken() : boxSession.getUserId();
        final String id = boxAuthenticationInfo.getUser() != null ? boxAuthenticationInfo.getUser().getUserId() : boxSession.getUserId();
        FutureTask<BoxAuthenticationInfo> futureTask = new FutureTask<>(new Callable<BoxAuthenticationInfo>() { // from class: com.box.androidsdk.content.auth.BoxAuthentication.4
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.concurrent.Callable
            public BoxAuthenticationInfo call() throws Exception {
                BoxAuthenticationInfo boxAuthenticationInfoRefreshAuthenticationInfo;
                if (boxSession.getRefreshProvider() != null) {
                    try {
                        boxAuthenticationInfoRefreshAuthenticationInfo = boxSession.getRefreshProvider().refreshAuthenticationInfo(boxAuthenticationInfo);
                    } catch (BoxException e) {
                        BoxAuthentication.this.mRefreshingTasks.remove(strAccessToken);
                        throw BoxAuthentication.this.handleRefreshException(boxSession, e, boxAuthenticationInfo, id);
                    }
                } else if (BoxAuthentication.this.mRefreshProvider != null) {
                    try {
                        boxAuthenticationInfoRefreshAuthenticationInfo = BoxAuthentication.this.mRefreshProvider.refreshAuthenticationInfo(boxAuthenticationInfo);
                    } catch (BoxException e2) {
                        BoxAuthentication.this.mRefreshingTasks.remove(strAccessToken);
                        throw BoxAuthentication.this.handleRefreshException(boxSession, e2, boxAuthenticationInfo, id);
                    }
                } else {
                    String strRefreshToken = boxAuthenticationInfo.refreshToken() != null ? boxAuthenticationInfo.refreshToken() : "";
                    String clientId = boxSession.getClientId() != null ? boxSession.getClientId() : BoxConfig.CLIENT_ID;
                    String clientSecret = boxSession.getClientSecret() != null ? boxSession.getClientSecret() : BoxConfig.CLIENT_SECRET;
                    if (SdkUtils.isBlank(clientId) || SdkUtils.isBlank(clientSecret)) {
                        throw BoxAuthentication.this.handleRefreshException(boxSession, new BoxException("client id or secret not specified", 400, "{\"error\": \"bad_request\",\n  \"error_description\": \"client id or secret not specified\"}", null), boxAuthenticationInfo, id);
                    }
                    try {
                        boxAuthenticationInfoRefreshAuthenticationInfo = new BoxApiAuthentication(boxSession).refreshOAuth(strRefreshToken, clientId, clientSecret).send();
                    } catch (BoxException e3) {
                        BoxAuthentication.this.mRefreshingTasks.remove(strAccessToken);
                        throw BoxAuthentication.this.handleRefreshException(boxSession, e3, boxAuthenticationInfo, id);
                    }
                }
                if (boxAuthenticationInfoRefreshAuthenticationInfo != null) {
                    boxAuthenticationInfoRefreshAuthenticationInfo.setRefreshTime(Long.valueOf(System.currentTimeMillis()));
                }
                BoxAuthenticationInfo.cloneInfo(boxSession.getAuthInfo(), boxAuthenticationInfoRefreshAuthenticationInfo);
                if (z || boxSession.getRefreshProvider() != null || BoxAuthentication.this.mRefreshProvider != null) {
                    boxAuthenticationInfo.setUser((BoxUser) new BoxApiUser(boxSession).getCurrentUserInfoRequest().setFields(BoxAuthentication.MINIMUM_USER_FIELDS).send());
                }
                BoxAuthentication.this.getAuthInfoMap(boxSession.getApplicationContext()).put(boxAuthenticationInfo.getUser().getUserId(), boxAuthenticationInfoRefreshAuthenticationInfo);
                BoxAuthentication.this.getAuthStorage().storeAuthInfoMap(BoxAuthentication.this.mCurrentAccessInfo, boxSession.getApplicationContext());
                Iterator it = BoxAuthentication.this.mListeners.iterator();
                while (it.hasNext()) {
                    AuthListener authListener = (AuthListener) ((WeakReference) it.next()).get();
                    if (authListener != null) {
                        authListener.onRefreshed(boxAuthenticationInfoRefreshAuthenticationInfo);
                    }
                }
                if (!boxSession.getUserId().equals(boxAuthenticationInfo.getUser().getUserId())) {
                    boxSession.onAuthFailure(boxAuthenticationInfo, new BoxException("Session User Id has changed!"));
                }
                BoxAuthentication.this.mRefreshingTasks.remove(strAccessToken);
                return boxAuthenticationInfo;
            }
        });
        this.mRefreshingTasks.put(strAccessToken, futureTask);
        AUTH_EXECUTOR.execute(futureTask);
        return futureTask;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ConcurrentHashMap<String, BoxAuthenticationInfo> getAuthInfoMap(Context context) {
        if (this.mCurrentAccessInfo == null) {
            this.mCurrentAccessInfo = this.authStorage.loadAuthInfoMap(context);
        }
        return this.mCurrentAccessInfo;
    }

    public static class BoxAuthenticationInfo extends BoxJsonObject {
        public static final String FIELD_ACCESS_TOKEN = "access_token";
        public static final String FIELD_BASE_DOMAIN = "base_domain";
        public static final String FIELD_CLIENT_ID = "client_id";
        public static final String FIELD_EXPIRES_IN = "expires_in";
        private static final String FIELD_REFRESH_TIME = "refresh_time";
        public static final String FIELD_REFRESH_TOKEN = "refresh_token";
        public static final String FIELD_USER = "user";
        private static final long serialVersionUID = 2878150977399126399L;

        public BoxAuthenticationInfo() {
        }

        public BoxAuthenticationInfo(JsonObject jsonObject) {
            super(jsonObject);
        }

        public BoxAuthenticationInfo createDeepCopy() {
            BoxAuthenticationInfo boxAuthenticationInfo = new BoxAuthenticationInfo();
            cloneInfo(boxAuthenticationInfo, this);
            return boxAuthenticationInfo;
        }

        public static void cloneInfo(BoxAuthenticationInfo boxAuthenticationInfo, BoxAuthenticationInfo boxAuthenticationInfo2) {
            boxAuthenticationInfo.createFromJson(boxAuthenticationInfo2.toJsonObject());
        }

        public String getClientId() {
            return getPropertyAsString("client_id");
        }

        public String accessToken() {
            return getPropertyAsString("access_token");
        }

        public String refreshToken() {
            return getPropertyAsString("refresh_token");
        }

        public Long expiresIn() {
            return getPropertyAsLong("expires_in");
        }

        public void setExpiresIn(Long l) {
            set("expires_in", l);
        }

        public Long getRefreshTime() {
            return getPropertyAsLong(FIELD_REFRESH_TIME);
        }

        public void setRefreshTime(Long l) {
            set(FIELD_REFRESH_TIME, l);
        }

        public void setClientId(String str) {
            set("client_id", str);
        }

        public void setAccessToken(String str) {
            set("access_token", str);
        }

        public void setRefreshToken(String str) {
            set("refresh_token", str);
        }

        public void setBaseDomain(String str) {
            set(FIELD_BASE_DOMAIN, str);
        }

        public String getBaseDomain() {
            return getPropertyAsString(FIELD_BASE_DOMAIN);
        }

        public void setUser(BoxUser boxUser) {
            set("user", boxUser);
        }

        public BoxUser getUser() {
            return (BoxUser) getPropertyAsJsonObject(BoxEntity.getBoxJsonObjectCreator(), "user");
        }

        public void wipeOutAuth() {
            remove("user");
            remove("client_id");
            remove("access_token");
            remove("refresh_token");
        }

        public static BoxAuthenticationInfo unmodifiableObject(BoxAuthenticationInfo boxAuthenticationInfo) {
            if (boxAuthenticationInfo == null) {
                return null;
            }
            return new BoxImmutableAuthenticationInfo(boxAuthenticationInfo);
        }

        public static class BoxImmutableAuthenticationInfo extends BoxAuthenticationInfo {
            private static final long serialVersionUID = 494874517008319105L;

            @Override // com.box.androidsdk.content.models.BoxJsonObject
            public void createFromJson(JsonObject jsonObject) {
            }

            @Override // com.box.androidsdk.content.models.BoxJsonObject
            public void createFromJson(String str) {
            }

            BoxImmutableAuthenticationInfo(BoxAuthenticationInfo boxAuthenticationInfo) {
                super.createFromJson(boxAuthenticationInfo.toJsonObject());
            }

            @Override // com.box.androidsdk.content.auth.BoxAuthentication.BoxAuthenticationInfo
            public void setUser(BoxUser boxUser) {
                BoxLogUtils.e("trying to modify ImmutableBoxAuthenticationInfo", new RuntimeException());
            }

            @Override // com.box.androidsdk.content.auth.BoxAuthentication.BoxAuthenticationInfo
            public void setAccessToken(String str) {
                BoxLogUtils.e("trying to modify ImmutableBoxAuthenticationInfo", new RuntimeException());
            }

            @Override // com.box.androidsdk.content.auth.BoxAuthentication.BoxAuthenticationInfo
            public void setClientId(String str) {
                BoxLogUtils.e("trying to modify ImmutableBoxAuthenticationInfo", new RuntimeException());
            }

            @Override // com.box.androidsdk.content.auth.BoxAuthentication.BoxAuthenticationInfo
            public void setExpiresIn(Long l) {
                BoxLogUtils.e("trying to modify ImmutableBoxAuthenticationInfo", new RuntimeException());
            }

            @Override // com.box.androidsdk.content.auth.BoxAuthentication.BoxAuthenticationInfo
            public void setRefreshTime(Long l) {
                BoxLogUtils.e("trying to modify ImmutableBoxAuthenticationInfo", new RuntimeException());
            }

            @Override // com.box.androidsdk.content.auth.BoxAuthentication.BoxAuthenticationInfo
            public void setRefreshToken(String str) {
                BoxLogUtils.e("trying to modify ImmutableBoxAuthenticationInfo", new RuntimeException());
            }

            @Override // com.box.androidsdk.content.auth.BoxAuthentication.BoxAuthenticationInfo
            public void setBaseDomain(String str) {
                BoxLogUtils.e("trying to modify ImmutableBoxAuthenticationInfo", new RuntimeException());
            }

            @Override // com.box.androidsdk.content.auth.BoxAuthentication.BoxAuthenticationInfo
            public void wipeOutAuth() {
                BoxLogUtils.e("trying to modify ImmutableBoxAuthenticationInfo", new RuntimeException());
            }
        }
    }

    public static class AuthStorage {
        private static final String AUTH_STORAGE_NAME = AuthStorage.class.getCanonicalName() + "_SharedPref";
        private static final String AUTH_MAP_STORAGE_KEY = AuthStorage.class.getCanonicalName() + "_authInfoMap";
        private static final String AUTH_STORAGE_LAST_AUTH_USER_ID_KEY = AuthStorage.class.getCanonicalName() + "_lastAuthUserId";

        protected void storeAuthInfoMap(Map<String, BoxAuthenticationInfo> map, Context context) {
            JsonObject jsonObject = new JsonObject();
            for (Map.Entry<String, BoxAuthenticationInfo> entry : map.entrySet()) {
                jsonObject.add(entry.getKey(), entry.getValue().toJsonObject());
            }
            context.getSharedPreferences(AUTH_STORAGE_NAME, 0).edit().putString(AUTH_MAP_STORAGE_KEY, new BoxEntity(jsonObject).toJson()).commit();
        }

        protected void clearAuthInfoMap(Context context) {
            context.getSharedPreferences(AUTH_STORAGE_NAME, 0).edit().remove(AUTH_MAP_STORAGE_KEY).commit();
        }

        protected void storeLastAuthenticatedUserId(String str, Context context) {
            if (SdkUtils.isEmptyString(str)) {
                context.getSharedPreferences(AUTH_STORAGE_NAME, 0).edit().remove(AUTH_STORAGE_LAST_AUTH_USER_ID_KEY).commit();
            } else {
                context.getSharedPreferences(AUTH_STORAGE_NAME, 0).edit().putString(AUTH_STORAGE_LAST_AUTH_USER_ID_KEY, str).commit();
            }
        }

        protected String getLastAuthentictedUserId(Context context) {
            return context.getSharedPreferences(AUTH_STORAGE_NAME, 0).getString(AUTH_STORAGE_LAST_AUTH_USER_ID_KEY, null);
        }

        protected ConcurrentHashMap<String, BoxAuthenticationInfo> loadAuthInfoMap(Context context) {
            BoxAuthenticationInfo boxAuthenticationInfo;
            ConcurrentHashMap<String, BoxAuthenticationInfo> concurrentHashMap = new ConcurrentHashMap<>();
            String string = context.getSharedPreferences(AUTH_STORAGE_NAME, 0).getString(AUTH_MAP_STORAGE_KEY, "");
            if (string.length() > 0) {
                BoxEntity boxEntity = new BoxEntity();
                boxEntity.createFromJson(string);
                for (String str : boxEntity.getPropertiesKeySet()) {
                    JsonValue propertyValue = boxEntity.getPropertyValue(str);
                    if (propertyValue.isString()) {
                        boxAuthenticationInfo = new BoxAuthenticationInfo();
                        boxAuthenticationInfo.createFromJson(propertyValue.asString());
                    } else if (propertyValue.isObject()) {
                        boxAuthenticationInfo = new BoxAuthenticationInfo();
                        boxAuthenticationInfo.createFromJson(propertyValue.asObject());
                    } else {
                        boxAuthenticationInfo = null;
                    }
                    concurrentHashMap.put(str, boxAuthenticationInfo);
                }
            }
            return concurrentHashMap;
        }
    }

    public static boolean isBoxAuthAppAvailable(Context context) {
        return MAMPackageManagement.queryIntentActivities(context.getPackageManager(), new Intent(BoxConstants.REQUEST_BOX_APP_FOR_AUTH_INTENT_ACTION), 65600).size() > 0;
    }
}
