package com.box.android.coreservices.modelcontroller;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.box.android.coreservices.modelcontroller.messages.BoxLocalUserDataMessage;
import com.box.android.coreservices.modelcontroller.messages.BoxLocalUsersDataMessage;
import com.box.android.coreservices.modelcontroller.messages.BoxMessage;
import com.box.android.coreservices.utilities.BoxKeyManager;
import com.box.android.domain.localrepo.ILocalSharedPreferences;
import com.box.android.domain.models.BoxAuthMap;
import com.box.androidsdk.content.auth.BoxAuthentication;
import com.box.androidsdk.content.models.BoxUser;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.box.androidsdk.content.utils.SdkUtils;
import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.JsonValue;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: loaded from: classes9.dex */
public class MoCoBoxGlobalSettings implements IMoCoBoxGlobalSettings {
    private static final String KEY_ALLOW_COLLABS_PUSH_NOTIFICATION = "shared_pref_key_allow_collabs_notification";
    private static final String KEY_ALLOW_COMMENTS_PUSH_NOTIFICATION = "shared_pref_key_allow_comments_notification";
    private static final String KEY_ALLOW_TASKS_PUSH_NOTIFICATION = "shared_pref_key_allow_tasks_notification";
    private static final String KEY_ALLOW_UPDATES_PUSH_NOTIFICATION = "shared_pref_key_allow_updates_notification";
    private static final String KEY_BETA_FEATURE_SET = "shared_pref_key_beta_feature_set";
    private static final String KEY_IS_FIRST_LAUNCH = "shared_pref_key_is_first_launch";
    private static final String KEY_IS_FIRST_TIME_USER = "shared_pref_key_is_first_time_user";
    private static final String KEY_PUSH_REGISTRATION_PROMPT_SHOWN = "push_registration_prompt_shown";
    public static final String KEY_REMEMBERED_USER_NAME = "shared_pref_key_remembered_user_name";
    private static final String STORED_LOGGED_IN_USERS = "storedAuthInfo";
    private static final String STORED_PRIVATE_KEY = "storedPrivateKey";
    private static final String STORED_PUBLIC_KEY = "storedPublicKey";
    final Context mAppContext;
    final ThreadPoolExecutor mGlobalExecutor;
    final SharedPreferences mGlobalSharedPrefs;

    @Inject
    public MoCoBoxGlobalSettings(Context context, ILocalSharedPreferences iLocalSharedPreferences, @Named("global") ThreadPoolExecutor threadPoolExecutor) {
        this.mAppContext = context;
        this.mGlobalSharedPrefs = iLocalSharedPreferences.getSharedPreferences(ILocalSharedPreferences.PreferenceName.GLOBAL);
        this.mGlobalExecutor = threadPoolExecutor;
    }

    @Override // com.box.android.coreservices.modelcontroller.IMoCoBoxGlobalSettings
    public void setShouldAllowCommentsPushNotification(boolean z) {
        getGlobalSharedPreferences().edit().putBoolean(KEY_ALLOW_COMMENTS_PUSH_NOTIFICATION, z).commit();
    }

    @Override // com.box.android.coreservices.modelcontroller.IMoCoBoxGlobalSettings
    public void setShouldAllowCollabsPushNotification(boolean z) {
        getGlobalSharedPreferences().edit().putBoolean(KEY_ALLOW_COLLABS_PUSH_NOTIFICATION, z).commit();
    }

    @Override // com.box.android.coreservices.modelcontroller.IMoCoBoxGlobalSettings
    public void setShouldAllowUpdatesPushNotification(boolean z) {
        getGlobalSharedPreferences().edit().putBoolean(KEY_ALLOW_UPDATES_PUSH_NOTIFICATION, z).commit();
    }

    @Override // com.box.android.coreservices.modelcontroller.IMoCoBoxGlobalSettings
    public void setShouldAllowTasksPushNotification(boolean z) {
        getGlobalSharedPreferences().edit().putBoolean(KEY_ALLOW_TASKS_PUSH_NOTIFICATION, z).commit();
    }

    @Override // com.box.android.coreservices.modelcontroller.IMoCoBoxGlobalSettings
    public boolean shouldAllowCommentsPushNotification() {
        return getGlobalSharedPreferences().getBoolean(KEY_ALLOW_COMMENTS_PUSH_NOTIFICATION, true);
    }

    @Override // com.box.android.coreservices.modelcontroller.IMoCoBoxGlobalSettings
    public boolean shouldDisableAllPushNotifications() {
        return (shouldAllowCommentsPushNotification() || shouldAllowCollabsPushNotification()) ? false : true;
    }

    @Override // com.box.android.coreservices.modelcontroller.IMoCoBoxGlobalSettings
    public boolean shouldAllowCollabsPushNotification() {
        return getGlobalSharedPreferences().getBoolean(KEY_ALLOW_COLLABS_PUSH_NOTIFICATION, true);
    }

    @Override // com.box.android.coreservices.modelcontroller.IMoCoBoxGlobalSettings
    public boolean shouldAllowUpdatesPushNotification() {
        return getGlobalSharedPreferences().getBoolean(KEY_ALLOW_UPDATES_PUSH_NOTIFICATION, true);
    }

    @Override // com.box.android.coreservices.modelcontroller.IMoCoBoxGlobalSettings
    public boolean shouldAllowTasksPushNotification() {
        return getGlobalSharedPreferences().getBoolean(KEY_ALLOW_TASKS_PUSH_NOTIFICATION, true);
    }

    @Override // com.box.android.coreservices.modelcontroller.IMoCoBoxGlobalSettings
    public String getLastRememberedUserName() {
        return getGlobalSharedPreferences().getString(KEY_REMEMBERED_USER_NAME, "");
    }

    @Override // com.box.android.coreservices.modelcontroller.IMoCoBoxGlobalSettings
    public void setPushRegistrationPromptShown(boolean z) {
        getGlobalSharedPreferences().edit().putBoolean(KEY_PUSH_REGISTRATION_PROMPT_SHOWN, z).apply();
    }

    @Override // com.box.android.coreservices.modelcontroller.IMoCoBoxGlobalSettings
    public boolean isPushRegistrationPromptShown() {
        return getGlobalSharedPreferences().getBoolean(KEY_PUSH_REGISTRATION_PROMPT_SHOWN, false);
    }

    @Override // com.box.android.coreservices.modelcontroller.IMoCoBoxGlobalSettings
    public void setLastRememberedUserName(String str) {
        if (SdkUtils.isBlank(str)) {
            if (getGlobalSharedPreferences().edit().remove(KEY_REMEMBERED_USER_NAME).commit()) {
                return;
            }
            try {
                throw new RuntimeException("MoCoBoxGlobalSettings.setLastRemeberedUserName unable to remove");
            } catch (Exception e) {
                BoxLogUtils.e(MoCoBoxGlobalSettings.class.getName(), e);
                return;
            }
        }
        if (getGlobalSharedPreferences().edit().putString(KEY_REMEMBERED_USER_NAME, str).commit()) {
            return;
        }
        try {
            throw new RuntimeException("MoCoBoxGlobalSettings.setLastRemeberedUserName unable to store user");
        } catch (Exception e2) {
            BoxLogUtils.e(MoCoBoxGlobalSettings.class.getName(), e2);
        }
    }

    @Override // com.box.android.coreservices.modelcontroller.IMoCoBoxGlobalSettings
    public boolean isFirstTimeUser() {
        return getGlobalSharedPreferences().getBoolean(KEY_IS_FIRST_TIME_USER, true);
    }

    @Override // com.box.android.coreservices.modelcontroller.IMoCoBoxGlobalSettings
    public void setFirstTimeUser(boolean z) {
        getGlobalSharedPreferences().edit().putBoolean(KEY_IS_FIRST_TIME_USER, z).commit();
    }

    @Override // com.box.android.coreservices.modelcontroller.IMoCoBoxGlobalSettings
    public boolean isFirstLaunch() {
        return getGlobalSharedPreferences().getBoolean(KEY_IS_FIRST_LAUNCH, true);
    }

    @Override // com.box.android.coreservices.modelcontroller.IMoCoBoxGlobalSettings
    public void setFirstLaunch(boolean z) {
        getGlobalSharedPreferences().edit().putBoolean(KEY_IS_FIRST_LAUNCH, z).commit();
    }

    @Override // com.box.android.coreservices.modelcontroller.IMoCoBoxGlobalSettings
    public String getPrivateKeyString() {
        return getGlobalSharedPreferences().getString(STORED_PRIVATE_KEY, "");
    }

    @Override // com.box.android.coreservices.modelcontroller.IMoCoBoxGlobalSettings
    public String getEncryptedToken(String str) {
        if (SdkUtils.isBlank(str)) {
            return null;
        }
        return BoxKeyManager.encrypt(str);
    }

    @Override // com.box.android.coreservices.modelcontroller.IMoCoBoxGlobalSettings
    public String getDecryptedToken(String str) {
        return BoxKeyManager.decrypt(str, this);
    }

    @Override // com.box.android.coreservices.modelcontroller.IMoCoBoxGlobalSettings
    public BoxFutureTask<BoxLocalUserDataMessage> getCurrentUserData() {
        return asyncBuildAndRunFutureTask(new BoxCallable<BoxLocalUserDataMessage>() { // from class: com.box.android.coreservices.modelcontroller.MoCoBoxGlobalSettings.1
            @Override // java.util.concurrent.Callable
            public BoxLocalUserDataMessage call() throws Exception {
                BoxLocalUserDataMessage boxLocalUserDataMessage = new BoxLocalUserDataMessage();
                boxLocalUserDataMessage.setRequestId(getRequestId());
                boxLocalUserDataMessage.setAction(BoxLocalUserDataMessage.ACTION_FETCH_LOCAL_USER_DATA);
                boxLocalUserDataMessage.setIsLocal(true);
                boxLocalUserDataMessage.setSuccess(false);
                BoxAuthMap storedBoxIterator = MoCoBoxGlobalSettings.this.getStoredBoxIterator();
                String lastAuthenticatedUserId = BoxAuthentication.getInstance().getLastAuthenticatedUserId(MoCoBoxGlobalSettings.this.getAppContext());
                if (!TextUtils.isEmpty(lastAuthenticatedUserId)) {
                    for (BoxAuthentication.BoxAuthenticationInfo boxAuthenticationInfo : storedBoxIterator) {
                        if (boxAuthenticationInfo.getUser() != null && TextUtils.equals(lastAuthenticatedUserId, boxAuthenticationInfo.getUser().getUserId())) {
                            boxLocalUserDataMessage.setPayload(boxAuthenticationInfo);
                            boxLocalUserDataMessage.setSuccess(true);
                        }
                    }
                }
                return boxLocalUserDataMessage;
            }
        }, this.mGlobalExecutor);
    }

    @Override // com.box.android.coreservices.modelcontroller.IMoCoBoxGlobalSettings
    public BoxFutureTask<BoxLocalUserDataMessage> getUserData(final String str) {
        return asyncBuildAndRunFutureTask(new BoxCallable<BoxLocalUserDataMessage>() { // from class: com.box.android.coreservices.modelcontroller.MoCoBoxGlobalSettings.2
            @Override // java.util.concurrent.Callable
            public BoxLocalUserDataMessage call() throws Exception {
                BoxLocalUserDataMessage boxLocalUserDataMessage = new BoxLocalUserDataMessage();
                boxLocalUserDataMessage.setRequestId(getRequestId());
                boxLocalUserDataMessage.setAction(BoxLocalUserDataMessage.ACTION_FETCH_LOCAL_USER_DATA);
                boxLocalUserDataMessage.setIsLocal(true);
                BoxAuthMap storedBoxIterator = MoCoBoxGlobalSettings.this.getStoredBoxIterator();
                if (storedBoxIterator.size() < 1) {
                    boxLocalUserDataMessage.setSuccess(false);
                    return boxLocalUserDataMessage;
                }
                for (BoxAuthentication.BoxAuthenticationInfo boxAuthenticationInfo : storedBoxIterator) {
                    BoxUser user = boxAuthenticationInfo.getUser();
                    if (user != null && TextUtils.equals(user.getUserId(), str)) {
                        boxLocalUserDataMessage.setPayload(boxAuthenticationInfo);
                        boxLocalUserDataMessage.setSuccess(true);
                        break;
                    }
                }
                if (boxLocalUserDataMessage.getPayload() == null) {
                    boxLocalUserDataMessage.setSuccess(false);
                }
                return boxLocalUserDataMessage;
            }
        }, this.mGlobalExecutor);
    }

    @Override // com.box.android.coreservices.modelcontroller.IMoCoBoxGlobalSettings
    public BoxFutureTask<BoxLocalUsersDataMessage> getAllUsersData() {
        return asyncBuildAndRunFutureTask(new BoxCallable<BoxLocalUsersDataMessage>() { // from class: com.box.android.coreservices.modelcontroller.MoCoBoxGlobalSettings.3
            @Override // java.util.concurrent.Callable
            public BoxLocalUsersDataMessage call() throws Exception {
                BoxLocalUsersDataMessage boxLocalUsersDataMessage = new BoxLocalUsersDataMessage();
                boxLocalUsersDataMessage.setRequestId(getRequestId());
                boxLocalUsersDataMessage.setAction(BoxLocalUserDataMessage.ACTION_FETCH_LOCAL_USER_DATA);
                boxLocalUsersDataMessage.setIsLocal(true);
                BoxAuthMap storedBoxIterator = MoCoBoxGlobalSettings.this.getStoredBoxIterator();
                if (storedBoxIterator.size() < 1) {
                    boxLocalUsersDataMessage.setSuccess(false);
                    return boxLocalUsersDataMessage;
                }
                BoxAuthMap boxAuthMap = new BoxAuthMap();
                for (BoxAuthentication.BoxAuthenticationInfo boxAuthenticationInfo : storedBoxIterator) {
                    if (boxAuthenticationInfo.getUser() != null && !StringUtils.isEmpty(boxAuthenticationInfo.getUser().getUserId())) {
                        boxAuthMap.add(boxAuthenticationInfo);
                    }
                }
                boxLocalUsersDataMessage.setPayload(boxAuthMap);
                boxLocalUsersDataMessage.setSuccess(boxAuthMap.size() > 0);
                return boxLocalUsersDataMessage;
            }
        }, this.mGlobalExecutor);
    }

    @Override // com.box.android.coreservices.modelcontroller.IMoCoBoxGlobalSettings
    public BoxFutureTask<BoxLocalUserDataMessage> addCurrentUserData(final BoxAuthentication.BoxAuthenticationInfo boxAuthenticationInfo) {
        return asyncBuildAndRunFutureTask(new BoxCallable<BoxLocalUserDataMessage>() { // from class: com.box.android.coreservices.modelcontroller.MoCoBoxGlobalSettings.4
            @Override // java.util.concurrent.Callable
            public BoxLocalUserDataMessage call() throws Exception {
                BoxLocalUserDataMessage boxLocalUserDataMessage = new BoxLocalUserDataMessage();
                boxLocalUserDataMessage.setRequestId(getRequestId());
                boxLocalUserDataMessage.setAction(BoxLocalUserDataMessage.ACTION_ADD_LOCAL_USER_DATA);
                boxLocalUserDataMessage.setIsLocal(true);
                String encryptedToken = MoCoBoxGlobalSettings.this.getEncryptedToken(boxAuthenticationInfo.accessToken());
                String encryptedToken2 = MoCoBoxGlobalSettings.this.getEncryptedToken(boxAuthenticationInfo.refreshToken());
                BoxAuthentication.BoxAuthenticationInfo boxAuthenticationInfoCreateDeepCopy = boxAuthenticationInfo.createDeepCopy();
                boxAuthenticationInfoCreateDeepCopy.setAccessToken(encryptedToken);
                boxAuthenticationInfoCreateDeepCopy.setRefreshToken(encryptedToken2);
                BoxAuthMap storedBoxIterator = MoCoBoxGlobalSettings.this.getStoredBoxIterator();
                storedBoxIterator.remove(boxAuthenticationInfo.getUser().getUserId());
                storedBoxIterator.add(boxAuthenticationInfoCreateDeepCopy);
                MoCoBoxGlobalSettings.this.getGlobalSharedPreferences().edit().putString(MoCoBoxGlobalSettings.STORED_LOGGED_IN_USERS, storedBoxIterator.toJson()).commit();
                boxLocalUserDataMessage.setSuccess(true);
                boxLocalUserDataMessage.setPayload(boxAuthenticationInfo);
                return boxLocalUserDataMessage;
            }
        }, this.mGlobalExecutor);
    }

    @Override // com.box.android.coreservices.modelcontroller.IMoCoBoxGlobalSettings
    public BoxFutureTask<BoxLocalUserDataMessage> removeUserData(final String str) {
        return asyncBuildAndRunFutureTask(new BoxCallable<BoxLocalUserDataMessage>() { // from class: com.box.android.coreservices.modelcontroller.MoCoBoxGlobalSettings.5
            @Override // java.util.concurrent.Callable
            public BoxLocalUserDataMessage call() throws Exception {
                BoxLocalUserDataMessage boxLocalUserDataMessage = new BoxLocalUserDataMessage();
                boxLocalUserDataMessage.setRequestId(getRequestId());
                boxLocalUserDataMessage.setAction(BoxLocalUserDataMessage.ACTION_REMOVE_LOCAL_USER_DATA);
                boxLocalUserDataMessage.setIsLocal(true);
                BoxAuthMap storedBoxIterator = MoCoBoxGlobalSettings.this.getStoredBoxIterator();
                BoxAuthentication.BoxAuthenticationInfo boxAuthenticationInfo = storedBoxIterator.get(str);
                if (boxAuthenticationInfo == null) {
                    boxLocalUserDataMessage.setSuccess(false);
                    return boxLocalUserDataMessage;
                }
                boxLocalUserDataMessage.setSuccess(storedBoxIterator.remove(str));
                MoCoBoxGlobalSettings.this.getGlobalSharedPreferences().edit().putString(MoCoBoxGlobalSettings.STORED_LOGGED_IN_USERS, storedBoxIterator.toJson()).commit();
                boxLocalUserDataMessage.setPayload(boxAuthenticationInfo);
                return boxLocalUserDataMessage;
            }
        }, this.mGlobalExecutor);
    }

    @Override // com.box.android.coreservices.modelcontroller.IMoCoBoxGlobalSettings
    public SharedPreferences getGlobalSharedPreferences() {
        return this.mGlobalSharedPrefs;
    }

    protected Context getAppContext() {
        return this.mAppContext;
    }

    @Override // com.box.android.coreservices.modelcontroller.IMoCoBoxGlobalSettings
    public void saveFirebaseToken(String str) {
        getGlobalSharedPreferences().edit().putString(ILocalSharedPreferences.GlobalPreferenceKey.PUSH_NOTIF_FIREBASE_TOKEN.getKey(), str).apply();
    }

    @Override // com.box.android.coreservices.modelcontroller.IMoCoBoxGlobalSettings
    public String getFirebaseToken() {
        return getGlobalSharedPreferences().getString(ILocalSharedPreferences.GlobalPreferenceKey.PUSH_NOTIF_FIREBASE_TOKEN.getKey(), "");
    }

    @Override // com.box.android.coreservices.modelcontroller.IMoCoBoxGlobalSettings
    public BoxAuthMap getStoredBoxIterator() {
        BoxAuthMap boxAuthMap = new BoxAuthMap();
        try {
            String string = getGlobalSharedPreferences().getString(STORED_LOGGED_IN_USERS, null);
            if (!StringUtils.isEmpty(string)) {
                JsonObject from = JsonObject.readFrom(string);
                if (from.isArray()) {
                    Iterator<JsonValue> it = from.asArray().iterator();
                    while (it.hasNext()) {
                        boxAuthMap.add(new BoxAuthentication.BoxAuthenticationInfo(it.next().asObject()));
                    }
                } else {
                    boxAuthMap.createFromJson(from);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!StringUtils.isNotBlank(getPrivateKeyString())) {
            return boxAuthMap;
        }
        BoxAuthMap boxAuthMap2 = new BoxAuthMap();
        Iterator<BoxAuthentication.BoxAuthenticationInfo> it2 = boxAuthMap.iterator();
        while (it2.hasNext()) {
            BoxAuthentication.BoxAuthenticationInfo boxAuthenticationInfoCreateDeepCopy = it2.next().createDeepCopy();
            String strDecryptWithSharedPrefsKey = BoxKeyManager.decryptWithSharedPrefsKey(boxAuthenticationInfoCreateDeepCopy.accessToken(), this);
            String strDecryptWithSharedPrefsKey2 = BoxKeyManager.decryptWithSharedPrefsKey(boxAuthenticationInfoCreateDeepCopy.refreshToken(), this);
            boxAuthenticationInfoCreateDeepCopy.setAccessToken(getEncryptedToken(strDecryptWithSharedPrefsKey));
            boxAuthenticationInfoCreateDeepCopy.setRefreshToken(getEncryptedToken(strDecryptWithSharedPrefsKey2));
            boxAuthMap2.add(boxAuthenticationInfoCreateDeepCopy);
        }
        getGlobalSharedPreferences().edit().remove(STORED_LOGGED_IN_USERS).putString(STORED_LOGGED_IN_USERS, boxAuthMap2.toJson()).commit();
        getGlobalSharedPreferences().edit().remove(STORED_PRIVATE_KEY).remove(STORED_PUBLIC_KEY).commit();
        return boxAuthMap2;
    }

    protected <T extends BoxMessage<?>> BoxFutureTask<T> asyncBuildAndRunFutureTask(BoxCallable<T> boxCallable, ExecutorService executorService) {
        return asyncBuildAndRunFutureTask(boxCallable, BoxFutureTask.TaskPriority.PRIORITY_MEDIUM, executorService);
    }

    protected <T extends BoxMessage<?>> BoxFutureTask<T> asyncBuildAndRunFutureTask(BoxCallable<T> boxCallable, BoxFutureTask.TaskPriority taskPriority, ExecutorService executorService) {
        return asyncBuildAndRunFutureTask(boxCallable, null, taskPriority, executorService);
    }

    protected <T extends BoxMessage<?>> BoxFutureTask<T> asyncBuildAndRunFutureTask(final BoxCallable<T> boxCallable, BoxFutureTask.FinalMessageListener<T> finalMessageListener, BoxFutureTask.TaskPriority taskPriority, ExecutorService executorService) {
        BoxFutureTask<T> boxFutureTask = (BoxFutureTask<T>) new BoxFutureTask<T>(boxCallable, 1L, finalMessageListener, taskPriority) { // from class: com.box.android.coreservices.modelcontroller.MoCoBoxGlobalSettings.6
            @Override // java.util.concurrent.FutureTask, java.util.concurrent.Future
            public boolean cancel(boolean z) {
                boxCallable.onCancel(z);
                return super.cancel(z);
            }
        };
        boxCallable.setRequestId(1L);
        try {
            executorService.submit(boxFutureTask);
            return boxFutureTask;
        } catch (RejectedExecutionException unused) {
            boxFutureTask.cancel(true);
            return boxFutureTask;
        }
    }
}
